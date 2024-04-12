package project.team3.three.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.team3.three.exception.BizException;
import project.team3.three.exception.ErrorCode;

import java.util.Optional;

import static project.team3.three.exception.ErrorCode.NOTFOUNDUSER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User selectUserByEmail(String email) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));
        if (optionalUser.isEmpty()) {
            throw new BizException(NOTFOUNDUSER);
        } else {
            return optionalUser.get();
        }
    }

    public User updateUser(String email, UserDto userDto) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));
        if (optionalUser.isPresent()) {
            User dbUser = optionalUser.get();
            dbUser.setName(userDto.getName());
            dbUser.setNickname(userDto.getNickname());
            dbUser.setPhoneNum(userDto.getPhoneNum());
            dbUser.setEmail(userDto.getEmail());
            dbUser.setPassword(userDto.getPassword());
            dbUser.setGrade(userDto.getGrade());
            dbUser.setStudies(userDto.getStudies());
            dbUser.setAddress(userDto.getAddress());
            return userRepository.save(dbUser);

        } else {
            throw new BizException(NOTFOUNDUSER);
        }
    }

    public User withdrawUser(String email) {
        User dbUser = userRepository.findMyCustom(email);
  
        if (dbUser != null) {
            dbUser.setWithdrawStatus(WithdrawStatus.Y);
            userRepository.save(dbUser);
            return dbUser;
        } else {
            throw new BizException(NOTFOUNDUSER);
        }
    }

}



