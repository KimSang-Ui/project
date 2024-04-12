package project.team3.three.termmemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@ToString
public class TermMemoDto {

    private Long termMemoId;

    private String todo;

    private Long timeTableId;

    public TermMemoDto(Long termMemoId, String todo, Long timeTableId){
        this.termMemoId = termMemoId;
        this.todo = todo;
        this.timeTableId = timeTableId;
    }
}

