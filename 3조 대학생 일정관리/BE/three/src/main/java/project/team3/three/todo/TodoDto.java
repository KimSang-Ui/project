package project.team3.three.todo;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.team3.three.board.Deleteyn;

@Getter
@Setter
@ToString
public class TodoDto {
    private Long id;
    private String todo;
    private Long profileId;
    private Deleteyn deleteyn;

    public TodoDto(Long id, String todo, Long profileId, Deleteyn deleteyn) {
        this.id = id;
        this.todo = todo;
        this.profileId = profileId;
        this.deleteyn = deleteyn;
    }
}
