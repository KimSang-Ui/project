package project.team3.three.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.team3.three.login.TokenManager;

import project.team3.three.login.LoginService;
import project.team3.three.login.TokenManager;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("user")
@Tag(name = "UserController", description = "회원 정보 조회, 등록, 수정, 삭제")
public class UserController {

    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;


    }

    @GetMapping("{email}")
    @Operation(summary = "사용자 한명 보기", description = "사용자 한명의 정보를 조회 할 수 있습니다.")
    @Parameters(
            @Parameter(description = "조회하고자 하는 사용자 이메일을 입력하세요.",
                    name = "email",
                    required = true)
    )
    public ResponseEntity<User> selectUserByEmail(
            @PathVariable String email) {
        System.out.println(email);

        User user = userService.selectUserByEmail(email);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping(value = "update/{email}")
    public User updateUser(@PathVariable String email,

                           @RequestBody UserDto userDto) {

        return userService.updateUser(email, userDto);
    }

    @PutMapping("withdraw/{email}")
    public User withdrawUser(@PathVariable String email) {
        return userService.withdrawUser(email);
    }

}