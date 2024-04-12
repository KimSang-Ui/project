package project.team3.three.memo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.team3.three.user.User;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    public List<Memo> findByUser(User user);
    @Query(value = "select * from memo m where m.profile_id = :profile_id and m.id = :id", nativeQuery = true)
    Memo findByUserAndId(@Param("profile_id")Long profile_id, @Param("id")Long id);
}
