package project.kiteshop.service;

import project.kiteshop.models.entities.UserEntity;
import project.kiteshop.models.service.UserRegistrationServiceModel;

public interface UserService {

    void seedUsers();

    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean userNameExists(String username);

    UserEntity findByName(String username);
}
