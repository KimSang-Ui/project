package project.team3.three.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import project.team3.three.user.User;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private Deleteyn deleteyn;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private Categories categories;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime createDate;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime modifiedDate;

    private User user;

}