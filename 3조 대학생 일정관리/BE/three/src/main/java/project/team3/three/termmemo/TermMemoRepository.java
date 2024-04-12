package project.team3.three.termmemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.team3.three.timetable.TimeTable;

@Repository
public interface TermMemoRepository extends JpaRepository<TermMemo, Long> {

}
