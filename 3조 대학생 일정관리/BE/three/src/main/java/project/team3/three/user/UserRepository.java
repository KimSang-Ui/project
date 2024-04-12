package project.team3.three.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "select m from User m where m.email = :email and m.withdrawStatus='N'")
    public User findMyCustom(String email);


    User findByEmail(String email);


    User findByUserId(Long userId);

}
