package project.kiteshop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import project.kiteshop.models.entities.DayLogEntity;
import project.kiteshop.repository.DayLogRepository;
import project.kiteshop.repository.LogRepository;
import project.kiteshop.service.DayLogService;
import project.kiteshop.service.LogService;

import java.time.LocalDate;
import java.util.List;

@Service
public class DayLogServiceImpl implements DayLogService {

    private Logger LOGGER = LoggerFactory.getLogger(DayLogServiceImpl.class);

    private final LogRepository logRepository;
    private final DayLogRepository dayLogRepository;
    private final LogService logService;

    public DayLogServiceImpl(LogRepository logRepository, DayLogRepository dayLogRepository, LogService logService) {
        this.logRepository = logRepository;
        this.dayLogRepository = dayLogRepository;
        this.logService = logService;
    }


    @Override
    @Scheduled(cron = "${logs.refresh-cron}")
    public void createDayLog() {

        LOGGER.info("Create DayLog  ...");

        int countOfLogs= logService.findAllLogs().size();

        DayLogEntity dayLogEntity = new DayLogEntity();

        dayLogEntity.setLocalDate(LocalDate.now());
        dayLogEntity.setNumber(countOfLogs);

        logRepository.deleteAll();
        dayLogRepository.save(dayLogEntity);

    }

    @Override
    public List<Integer> findFirstSeven() {

        return dayLogRepository.findFirstSeven();

    }

    @Override
    public void seedDayLog() {
        if (dayLogRepository.count() == 0){

            DayLogEntity first = createZeroDeyLog();
            DayLogEntity second = createZeroDeyLog();
            DayLogEntity third = createZeroDeyLog();
            DayLogEntity fore = createZeroDeyLog();
            DayLogEntity five = createZeroDeyLog();
            DayLogEntity six = createZeroDeyLog();
            DayLogEntity seven = createZeroDeyLog();


            dayLogRepository.saveAll(List.of(first, second, third, fore, five, six, seven));
        }



    }

    private DayLogEntity createZeroDeyLog() {

        DayLogEntity dayLogEntity = new DayLogEntity();

        dayLogEntity.setNumber(0);
        dayLogEntity.setLocalDate(LocalDate.now());

        return dayLogEntity;
    }
}
