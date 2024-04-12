package project.team3.three.timetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.team3.three.user.User;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

    TimeTable findByUser(User user);
}
