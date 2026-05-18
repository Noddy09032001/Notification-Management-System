package com.example.noddy.notification_system.service.rbacService;

import com.example.noddy.notification_system.constants.RoleConstants;
import com.example.noddy.notification_system.dto.request.CreateUserRequest;
import com.example.noddy.notification_system.pojo.RoleData;
import com.example.noddy.notification_system.pojo.UserData;
import com.example.noddy.notification_system.repository.RoleRepository;
import com.example.noddy.notification_system.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RbacServiceImplementation implements RbacService{

    private UserDataRepository userDataRepository;
    private final PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    @Autowired
    public RbacServiceImplementation(UserDataRepository userDataRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository){
        this.userDataRepository = userDataRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void createUser(CreateUserRequest request) throws Exception {
        try {

            UserData user = new UserData();   // creating a new user
            user.setUserName(request.getUserName());
            user.setName(request.getName());
            user.setMobileNumber(request.getMobileNumber());

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
}
