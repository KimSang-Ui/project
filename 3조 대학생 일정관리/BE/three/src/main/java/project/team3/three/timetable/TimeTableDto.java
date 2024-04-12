package project.team3.three.timetable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeTableDto {

    private Long id;

    private String subject;

    public TimeTableDto(Long id, String subject) {
        this.id = id;
        this.subject = subject;
    }
}
