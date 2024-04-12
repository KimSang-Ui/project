package project.team3.three.memo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemoDto {

    private Long id;
    private String memo;
    private Long profileId;

    public MemoDto(Long id, String memo, Long profileId) {
        this.id = id;
        this.memo = memo;
        this.profileId = profileId;
    }
}
