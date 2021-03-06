package project.kiteshop.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import project.kiteshop.models.entities.UserEntity;
import project.kiteshop.models.entities.UserRoleEntity;
import project.kiteshop.models.entities.enums.UserRole;
import project.kiteshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class KiteDBUserServiceTest {


    private KiteDBUserService serviceToTest;

    @Mock
    UserRepository mockUserRepository;

    @BeforeEach
    public void setUp(){
        serviceToTest = new KiteDBUserService(mockUserRepository);
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class, () -> {
                    serviceToTest.loadUserByUsername("user_does_not_exits");
                }
        );
    }

    @Test
    void testExistingUser(){
        // prepare data
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("bobo");
        userEntity.setPassword("12345");

        UserRoleEntity roleUser = new UserRoleEntity();
        roleUser.setRole(UserRole.USER);
        UserRoleEntity roleAdmin = new UserRoleEntity();
        roleAdmin.setRole(UserRole.ADMIN);

        userEntity.setRoles(List.of(roleUser, roleAdmin));

        //configure mock
        Mockito.when(mockUserRepository.findByUsername("bobo")).thenReturn(Optional.of(userEntity));

        //test
        UserDetails userDetails = serviceToTest.loadUserByUsername("bobo");

        Assertions.assertEquals(userEntity.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(2,userDetails.getAuthorities().size());

        List<String> authorities = userDetails.getAuthorities().
                stream()
                .map(a -> a.getAuthority()).
                collect(Collectors.toList());

        Assertions.assertTrue(authorities.contains("ROLE_ADMIN"));
        Assertions.assertTrue(authorities.contains("ROLE_USER"));
    }
}
