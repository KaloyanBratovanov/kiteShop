package project.kiteshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.kiteshop.models.entities.UserEntity;
import project.kiteshop.models.entities.UserRoleEntity;
import project.kiteshop.models.entities.enums.UserRole;
import project.kiteshop.models.service.UserRegistrationServiceModel;
import project.kiteshop.repository.UserRepository;
import project.kiteshop.repository.UserRoleRepository;
import project.kiteshop.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final KiteDBUserService kiteDBUserService;


    public UserServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, KiteDBUserService kiteDBUserService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.kiteDBUserService = kiteDBUserService;
    }


    @Override
    public void seedUsers() {

        if (userRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));


            UserEntity admin = new UserEntity()
                    .setUsername("admin")
                    .setFullname("admin adminov")
                    .setPassword(passwordEncoder.encode("12345"))
                    .setEmail("admin@email.bg")
                    .setRoles(List.of(adminRole, userRole));


            UserEntity user = new UserEntity()
                    .setUsername("user")
                    .setFullname("user userov")
                    .setPassword(passwordEncoder.encode("12345"))
                    .setEmail("user@email.bg")
                    .setRoles(List.of(userRole));

            userRepository.saveAll(List.of(admin, user));

        }
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {

        UserEntity newUser= modelMapper.map(serviceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository.findByRole(UserRole.USER)
                .orElseThrow(() -> new IllegalStateException("USER role not found. Please seed the roles"));

        newUser.addRole(userRole);

        newUser =  userRepository.save(newUser);

        UserDetails principal = kiteDBUserService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(

                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserEntity findByName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(IllegalArgumentException::new);
    }
}
