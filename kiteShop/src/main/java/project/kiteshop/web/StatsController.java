package project.kiteshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.kiteshop.service.DayLogService;
import project.kiteshop.service.LogService;

import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatsController {

    private final LogService logService;
    private final DayLogService dayLogService;


    public StatsController(LogService logService, DayLogService dayLogService) {
        this.logService = logService;
        this.dayLogService = dayLogService;
    }

    @GetMapping
    public String stats(Model model){

        List<Integer> dayLogs= dayLogService.findFirstSeven();

        int first = dayLogs.get(0);
        int second = dayLogs.get(1);
        int third = dayLogs.get(2);
        int fourth = dayLogs.get(3);
        int fifth = dayLogs.get(4);
        int sixth = dayLogs.get(5);
        int seventh = dayLogs.get(6);


        model.addAttribute("logs", logService.findAllLogs());

        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("third", third);
        model.addAttribute("fourth", fourth);
        model.addAttribute("fifth", fifth);
        model.addAttribute("sixth", sixth);
        model.addAttribute("seventh", seventh);

        return "stats";
    }
}
