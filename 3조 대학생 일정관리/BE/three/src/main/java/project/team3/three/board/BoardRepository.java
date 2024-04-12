package project.team3.three.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.team3.three.user.User;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

     @Query(value = "select m from board m where m.profile_id = :profile_id and m.id = :id", nativeQuery = true)
     Board findByUserAndId(@Param("profile_id")Long profile_id, @Param("id")Long id);

     public List<Board> findByTitleContaining(String title);

     public List<Board> findByUser(User user);

     boolean existsByTitle(String title);
}
