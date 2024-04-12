package project.team3.three.timetable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.team3.three.exception.BizException;
import project.team3.three.exception.ErrorCode;
import project.team3.three.user.User;
import project.team3.three.user.UserRepository;

@Service
@RequiredArgsConstructor
public class TimeTableService {

    private final TimeTableRepository timeTableRepository;
    private final UserRepository userRepository;

    public TimeTable insert(TimeTableDto timeTableDto, User user) {
        User dbuser = userRepository.findByUserId(user.getUserId());
        if(dbuser==null){
            throw new BizException(ErrorCode.NOTFOUNDUSER);
        }
        TimeTable timeTable = new TimeTable();
        timeTable.setUser(dbuser);
        timeTable.setSubject(timeTableDto.getSubject());
        return timeTableRepository.save(timeTable);
    }

}
