package project.kiteshop.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "day_log")
public class DayLogEntity extends BaseEntity {

    private Integer number;
    private LocalDate localDate;


    public DayLogEntity() {
    }

    public Integer getNumber() {
        return number;
    }

    public DayLogEntity setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public DayLogEntity setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
        return this;
    }
}
