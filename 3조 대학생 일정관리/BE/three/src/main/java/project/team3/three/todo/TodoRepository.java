package project.team3.three.todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.team3.three.user.User;

import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findByUser(User user);

    @Query(value = "select * from todo m where m.profile_id = :profile_id and m.id = :id", nativeQuery = true)
    Todo findByUserAndId(@Param("profile_id")Long profile_id, @Param("id")Long id);
}
