package project.kiteshop.service;

import project.kiteshop.models.service.LogServiceModel;

import java.util.List;

public interface LogService {

    void createLog(String action, Long productId);

    List<LogServiceModel> findAllLogs();

}
