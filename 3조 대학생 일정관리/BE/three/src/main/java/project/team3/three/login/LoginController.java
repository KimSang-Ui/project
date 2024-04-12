package project.team3.three.login;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.team3.three.exception.BizException;
import project.team3.three.user.User;
import project.team3.three.user.UserDto;
import project.team3.three.user.UserService;
import project.team3.three.user.WithdrawStatus;

import java.io.PushbackReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static project.team3.three.exception.ErrorCode.*;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "Bearer Authentication")
public class LoginController {

    private final LoginService loginService;
    private final TokenManager tokenManager;
    private final Path imagePath;

    // 이미지 경로
    // 생성자 -> 자동주입말고 직접 주입해줘야한다
    public LoginController(LoginService loginService, TokenManager tokenManager) {
        this.loginService = loginService;
        this.tokenManager = tokenManager;
        imagePath
                = Paths.get("src/main/resources/static/images/upload/")
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 이미지를 프론트쪽에서 가져갈려고 필요
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        Path filePath = this.imagePath.resolve(fileName).normalize();
        Resource resource = null;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        //파일 있을때는 해당되는 파일 리소스 보내기
        return ResponseEntity.ok().body(resource);
    }


    // 회원가입
    // 이메일, 전화번호, 닉네임 중복체크도 같이 실행
    // 프로필 업로드
    @PostMapping(value = "/signUp", produces = APPLICATION_JSON_VALUE
            , consumes = MULTIPART_FORM_DATA_VALUE)
    public boolean UserSignUp(@Valid @RequestPart(value = "userDto") UserDto userDto,
                              @RequestPart(value = "file") MultipartFile imageFile) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);
        loginService.signUp(user, imageFile);
        return true;
    }

    //로그인
    @PostMapping("/signIn")
    @Parameters(
            {
                    @Parameter(in = ParameterIn.PATH, name = "email", description = "email"),
                    @Parameter(in = ParameterIn.PATH, name = "password", description = "password"),
            }
    )
    public String token(@RequestBody LoginDto loginDto) {
        User dbUser = loginService.signIn(loginDto.getEmail(), loginDto.getPassword());
        if (dbUser == null) {
            throw new BizException(REGISTRATIONREQUIRED);
        } else if (dbUser.getWithdrawStatus() == WithdrawStatus.Y) {
            throw new BizException(MEMBERWHOWITHDREW);
        }
        return tokenManager.generateToken(dbUser);
    }

    // 아이디(이메일) 찾기
    @PostMapping("/findId")
    @Operation(summary = "아이디 찾기", description = "이름, 학과, 전화번호를 입력하면 아이디를 찾아줍니다."
            , parameters = {
            @Parameter(name = "name", description = "이름", required = true),
            @Parameter(name = "studies", description = "학과", required = true),
            @Parameter(name = "phoneNum", description = "전화번호", required = true)
        }
    )
    public Optional<String> findId(@RequestBody UserDto userDto) {
        Optional<String> userId = loginService.findByNameAndStudiesAndPhoneNum(userDto.getName(), userDto.getStudies(), userDto.getPhoneNum());

        if (userId == null) {
            throw new BizException(NOTFOUNDEMAIL);
        }
        return userId;
    }

    // 비밀번호 찾기
    @PostMapping("/findPw")
    public Optional<Long> findPw(@RequestBody UserDto userDto) {
        Optional<Long> userPw = loginService.findByNameAndStudiesAndPhoneNumAndEmail(userDto.getName(), userDto.getStudies(), userDto.getPhoneNum(), userDto.getEmail());

        if (userPw == null) {
            throw new BizException(NOTFOUNDPASSWORD);
        }
        return userPw;
    }

    // 토큰실험
    @GetMapping("/auth")
    public String loginTest(Authentication authentication) {
        System.out.println(authentication);
        // 로그인 되어있나
        System.out.println(authentication.isAuthenticated());
        // jws.getPayload().get("username") 가져오는 이름
        System.out.println(authentication.getPrincipal());
        return "loginTest";
    }
}
