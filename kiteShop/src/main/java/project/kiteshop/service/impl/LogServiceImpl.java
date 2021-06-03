package project.kiteshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project.kiteshop.models.entities.LogEntity;
import project.kiteshop.models.entities.ProductEntity;
import project.kiteshop.models.entities.UserEntity;
import project.kiteshop.models.service.LogServiceModel;
import project.kiteshop.repository.LogRepository;
import project.kiteshop.service.LogService;
import project.kiteshop.service.ProductService;
import project.kiteshop.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final ProductService productService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public LogServiceImpl(LogRepository logRepository, ProductService productService, UserService userService, ModelMapper modelMapper) {
        this.logRepository = logRepository;
        this.productService = productService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createLog(String action, Long productId) {

        ProductEntity productEntity =
                productService.findEntityById(productId);

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String username = authentication.getName();

        UserEntity userEntity = userService.findByName(username);

        LogEntity logEntity = new LogEntity()
                .setProductEntity(productEntity)
                .setUserEntity(userEntity)
                .setAction(action)
                .setLocalDateTime(LocalDateTime.now());

        logRepository.save(logEntity);
    }

    @Override
    public List<LogServiceModel> findAllLogs() {
        return logRepository.findAll().stream().map(
                logEntity -> {
                    LogServiceModel logServiceModel =
                            modelMapper.map(logEntity, LogServiceModel.class);
                    logServiceModel.setProduct(logEntity.getProductEntity().getName())
                            .setUser(logEntity.getUserEntity().getUsername());

                    return logServiceModel;

                }).collect(Collectors.toList());
    }
}
