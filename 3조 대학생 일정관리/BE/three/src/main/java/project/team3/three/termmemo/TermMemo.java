package project.team3.three.termmemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import project.team3.three.timetable.TimeTable;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "termMemo")
public class TermMemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "termMemo_id")
    private Long termMemoId;


    private String todo;

    @Schema(title = "시간표 ID")
    @JoinColumn(name = "timeTable_id")
    private Long timeTableId;
  
}