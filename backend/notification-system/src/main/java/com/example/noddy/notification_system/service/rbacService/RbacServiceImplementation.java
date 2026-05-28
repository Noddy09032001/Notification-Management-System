package com.example.noddy.notification_system.service.rbacService;

import com.example.noddy.notification_system.constants.RoleConstants;
import com.example.noddy.notification_system.dto.request.AuthUserRequest;
import com.example.noddy.notification_system.dto.request.CreateUserRequest;
import com.example.noddy.notification_system.dto.response.AuthResponse;
import com.example.noddy.notification_system.pojo.RoleData;
import com.example.noddy.notification_system.pojo.UserData;
import com.example.noddy.notification_system.repository.RoleRepository;
import com.example.noddy.notification_system.repository.UserDataRepository;
import com.example.noddy.notification_system.service.jwtService.JwtServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RbacServiceImplementation implements RbacService{

    private UserDataRepository userDataRepository;
    private  PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private JwtServiceImplementation jwtServiceImplementation;
    private AuthenticationManager authenticationManager;

    @Autowired
    public RbacServiceImplementation(UserDataRepository userDataRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, JwtServiceImplementation jwtServiceImplementation, AuthenticationManager authenticationManager){
        this.userDataRepository = userDataRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtServiceImplementation = jwtServiceImplementation;
        this.authenticationManager = authenticationManager;
    }

    /**
     * method for logging in the user
     * @param request
     * @throws Exception
     */
    @Override
    public void createUser(CreateUserRequest request) throws Exception {
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

            for(RoleConstants roles : request.getRole()){
                RoleData role = roleRepository.findByRoleName(roles);
                roleData.add(role);
            }

            user.setRoles(roleData);   // setting the role data and the permissions
            userDataRepository.save(user);   // saving the user inside the database

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public AuthResponse login(AuthUserRequest request) throws Exception{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        // getting the user details
        UserData user = userDataRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        // generating jwt token
        String token = jwtServiceImplementation.generateToken(user);

        // getting the user roles
        List<String> roles = user.getRoles().stream().map(role -> role.getRoleName().name()).toList();

       // getting the user permissions
        List<String> permissions = user.getRoles().stream().flatMap(role ->
                                role.getPermissions().stream()).map(permission -> permission.getPermissionName()).distinct().toList();

        // returning the response object
        return new AuthResponse(token, user.getUsername(), roles, permissions);
    }
}
