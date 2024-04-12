package project.team3.three.login;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.team3.three.exception.BizException;
import project.team3.three.exception.ErrorCode;
import project.team3.three.user.User;
import project.team3.three.user.UserRepository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import static project.team3.three.exception.ErrorCode.*;


@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final Path imagePath;

    // 이미지 경로
    // 생성자 -> 자동주입말고 직접 주입해줘야한다
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
        imagePath
                = Paths.get("src/main/resources/static/images/upload/")
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원가입
    public User signUp(User user, MultipartFile imageFile){
        User emailDuplicate =loginRepository.findByEmail(user.getEmail());
        User phoneNumDuplicate = loginRepository.findByPhoneNum(user.getPhoneNum());
        User nicknameDuplicate = loginRepository.findByNickname(user.getNickname());
        String uuid = UUID.randomUUID().toString();
        // 이메일, 전화번호, 닉네임이 중복나면 에러
        if(emailDuplicate != null){
            throw new BizException(EMAILDUPLICATE);
        }else if(phoneNumDuplicate != null){
            throw new BizException(PHONEDUPLICATE);
        }else if(nicknameDuplicate != null){
            throw new BizException(NICKNAMEDUPLICATE);
        }else{
            try {
                // 저장...
                File dest = new File(imagePath +
                        "/"  + uuid + imageFile.getOriginalFilename());
                imageFile.transferTo(dest);
            }catch (Exception e){
                // 만약 디스크 저장에 실패하면 DB에 저장하지 않는다.
                e.printStackTrace();
                return null;
            }
            // 경로받는놈
            Link link = WebMvcLinkBuilder
                    .linkTo(
                            WebMvcLinkBuilder
                                    .methodOn(LoginController.class)
                                    .getImage(imageFile.getOriginalFilename())
                    )
                    .withRel("download");
            // D: 드라이브에 저장
//        user.setImagePath(imagePath + "/" + imageFile.getOriginalFilename());
            // http://localhost:8080/api/file/download/파일이름
            user.setImagePath(link.getHref().toString());

        }
        User signUpUser = loginRepository.save(user);

        return signUpUser;
    }

    // 로그인
    public User signIn(String email, String password) {
        User dbuser = loginRepository.findByEmailAndPasswordAndN(email, password);
        return dbuser;
    }

    // 아이디(이메일) 찾기
    public Optional<String> findByNameAndStudiesAndPhoneNum(String name, String studies, String phoneNum) {
        Optional<String> userId = loginRepository.findByNameAndStudiesAndPhoneNum(name, studies, phoneNum);
        return userId;
    }

    // 비밀번호 찾기
    public Optional<Long> findByNameAndStudiesAndPhoneNumAndEmail(String name, String studies, String phoneNum, String email) {
        Optional<Long> userPw = loginRepository.findByNameAndStudiesAndPhoneNumAndEmail(name, studies, phoneNum, email);
        return userPw;
    }
}
