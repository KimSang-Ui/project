package project.team3.three.timetable;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.team3.three.user.User;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class TimeTableController {

    private final TimeTableService timeTableService;

    //    시간표 등록
   @PostMapping("/timeTable")
   public TimeTable Insert(@RequestBody TimeTableDto timeTableDto, Authentication authentication) {
       User user = (User) authentication.getPrincipal();
       return timeTableService.insert(timeTableDto,user);
   }

}
