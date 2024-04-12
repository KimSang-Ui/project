package project.team3.three.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDto {

    private Long userId;

    private String name;

    private String nickname;

    private String address;

    @NotBlank
    private String phoneNum;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String studies;

    private Grade grade;

    private EnrollmentStatus enrollmentStatus;

    private WithdrawStatus withdrawStatus;

    private String imagePath;

    public static User of(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }


}

