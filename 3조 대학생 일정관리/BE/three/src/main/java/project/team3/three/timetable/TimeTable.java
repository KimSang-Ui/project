package project.team3.three.timetable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import project.team3.three.user.User;
import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;


@Entity
@Getter @Setter
@Table(name = "timeTable")
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeTable_id")
//    시간표_id
    private Long id;

//    회원정보_ID
    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "profile_id")
    private User user;

//    과목
    private String subject;



}
