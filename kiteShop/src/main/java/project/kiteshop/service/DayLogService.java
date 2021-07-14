package project.kiteshop.service;

import java.util.List;

public interface DayLogService {

    void createDayLog();

    List<Integer> findFirstSeven();

    void seedDayLog();

}
