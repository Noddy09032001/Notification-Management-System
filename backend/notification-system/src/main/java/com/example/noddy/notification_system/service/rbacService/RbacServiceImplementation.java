package com.example.noddy.notification_system.service.rbacService;

import com.example.noddy.notification_system.constants.RoleConstants;
import com.example.noddy.notification_system.dto.request.*;
import com.example.noddy.notification_system.dto.response.AuthResponse;
import com.example.noddy.notification_system.dto.response.RolePermissionMappingResponse;
import com.example.noddy.notification_system.pojo.PermissionsData;
import com.example.noddy.notification_system.pojo.RoleData;
import com.example.noddy.notification_system.pojo.UserData;
import com.example.noddy.notification_system.repository.PermissionRepository;
import com.example.noddy.notification_system.repository.RoleRepository;
import com.example.noddy.notification_system.repository.UserDataRepository;
import com.example.noddy.notification_system.service.jwtService.JwtServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RbacServiceImplementation implements RbacService{

    private UserDataRepository userDataRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;
    private JwtServiceImplementation jwtServiceImplementation;
    private AuthenticationManager authenticationManager;

    private static final Logger logger = LoggerFactory.getLogger(RbacServiceImplementation.class);

    @Autowired
    public RbacServiceImplementation(UserDataRepository userDataRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, JwtServiceImplementation jwtServiceImplementation, AuthenticationManager authenticationManager, PermissionRepository permissionRepository){
        this.userDataRepository = userDataRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtServiceImplementation = jwtServiceImplementation;
        this.authenticationManager = authenticationManager;
        this.permissionRepository = permissionRepository;
    }

    /**
     * method for logging in the user
     * @param request
     * @throws Exception
     */
    @Override
    public void createUser(CreateUserRequest request) throws Exception {
        logger.info("Inside the signup method - ");
        try {
            // check if the user with the given username already exists in the database
            if(userDataRepository.existsByUsername(request.getUserName()))
                throw new Exception("Username already exists");

            UserData user = new UserData();   // creating a new user
            user.setUsername(request.getUserName());
            user.setName(request.getName());
            user.setMobileNumber(request.getMobileNumber());
            user.setCreatedOn(LocalDateTime.now());
            user.setModifiedOn(LocalDateTime.now());

            String rawPassword = request.getPassword();   // getting the password from the request
            String encryptedPassword = passwordEncoder.encode(rawPassword);   // storing the encrypted password

            user.setPassword(encryptedPassword);

            // getting the role permissions based on the role name
            // finding the role id based on the role name

            Set<RoleData> roleData = new HashSet<>();

            for(String roles : request.getRole()){
                RoleData role = roleRepository.findByRoleName(roles).orElseThrow(() -> new RuntimeException("No such role exists"));
                roleData.add(role);
            }

            user.setRoles(roleData);   // setting the role data and the permissions
            userDataRepository.save(user);   // saving the user inside the database

        } catch (Exception e) {
            logger.info("Error during signup: {}", e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public AuthResponse login(AuthUserRequest request) throws Exception{
        logger.info("Inside the login method - ");
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            // getting the user details
            UserData user = userDataRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

            // generating jwt token
            String token = jwtServiceImplementation.generateToken(user);

            // getting the user roles
            List<String> roles = user.getRoles().stream().map(role -> role.getRoleName()).toList();

            // getting the user permissions
            List<String> permissions = user.getRoles().stream().flatMap(role ->
                    role.getPermissions().stream()).map(permission -> permission.getPermissionName()).distinct().toList();

            // returning the response object
            return new AuthResponse(token, user.getUsername(), roles, permissions);
        } catch (Exception e) {
            logger.info("Error during login: {}", e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public void createRole(CreateRoleRequest request) throws Exception {
        logger.info("Inside the role creation method - ");
        try{
            // checking for duplicate role entries
            RoleData existingRole = roleRepository.findByRoleName(request.getRoleName()).orElseThrow(() -> new RuntimeException("No such role exists"));

            RoleData role = new RoleData();    // creating new role objects
            role.setRoleName(request.getRoleName());
            role.setRoleDescription(request.getRoleDescription());

            roleRepository.save(role);   // saving the newly created role

        } catch (Exception e) {
            logger.info("Error during role creation: {}", e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public void createPermissions(CreatePermissionRequest request) throws Exception {
        logger.info("Inside the permission creation method - ");
        try{
            // checking for duplicate permission entries
            PermissionsData existingPermission = permissionRepository.findPermissionByPermissionName(request.getPermissionName()).orElseThrow(() -> new RuntimeException("No such permission exists"));

            PermissionsData permission = new PermissionsData();    // creating new permission objects
            permission.setPermissionName(request.getPermissionName());
            permission.setPermissionDescription(request.getPermissionDescription());

            permissionRepository.save(permission);   // saving the newly created permission

        } catch (Exception e) {
            logger.info("Error during permission creation: {}", e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public List<RolePermissionMappingResponse> createRolePermissionsMapping(List<RolePermissionMappingRequest> request) throws Exception {
        logger.info("Inside the role permission mapping method - ");
        try{
            if(request == null || request.isEmpty())
                throw new Exception("Request Body to contain at-least one role permission mapping listing");

            List<RolePermissionMappingResponse> response = new ArrayList<>();

            for(RolePermissionMappingRequest roles : request){
                if (roles.getRoleId() == null)
                    throw new Exception("Role id cannot be null");

                // getting the current role based on the role id
                RoleData role = roleRepository.findById(Long.valueOf(roles.getRoleId())).orElseThrow(() ->
                        new Exception("No role exists with the given id : " + roles.getRoleId()));

                if (roles.getPermissionIdList() == null || roles.getPermissionIdList().isEmpty())
                    throw new Exception("Permission list cannot be empty");

                // getting the current permissions based on the permissions id
                List<PermissionsData> permissions = permissionRepository.findAllById(roles.getPermissionIdList()
                                        .stream().map(Long::valueOf).toList());

                // Adding the permissions to role
                for (PermissionsData permission : permissions) {
                    role.addPermission(permission);
                }

                // Save the updated role data with the mapped permissions
                RoleData data = roleRepository.save(role);

                // creating a new response object for storing the data in the needed format
                RolePermissionMappingResponse mappingResponse = new RolePermissionMappingResponse();

                mappingResponse.setRole(data.getRoleName());
                mappingResponse.setPermissions(data.getPermissions().stream().map(PermissionsData::getPermissionName).toList());

                response.add(mappingResponse);   // adding to the response list
            }

            return response;   // returning the response

        } catch (Exception e) {
            logger.info("Error during roles and permission mappings: {}", e.getMessage());
            throw new Exception(e);
        }
    }
}
