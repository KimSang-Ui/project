package project.team3.three.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.team3.three.user.User;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    // 로그인
    // nativeQuery -> 아스타를 쓸려면 필요하다
    @Query(value = "SELECT *" +
            " FROM user u" +
            " WHERE 1 = 1" +
            " AND u.email = :email" +
            " AND u.password = :password", nativeQuery = true)
    public User findByEmailAndPasswordAndN(String email, String password);

    // 아이디(이메일) 찾기
    @Query(value = "SELECT u.email" +
            " FROM user u" +
            " WHERE 1 = 1" +
            " AND u.name = :name" +
            " AND u.studies = :studies" +
            " AND u.phone_num = :phoneNum", nativeQuery = true)
    public Optional<String> findByNameAndStudiesAndPhoneNum(String name, String studies, String phoneNum);


    // 비밀번호 찾기
    @Query(value = "SELECT u.password" +
            " FROM user u" +
            " WHERE 1 = 1" +
            " AND u.name = :name" +
            " AND u.studies = :studies" +
            " AND u.phone_num = :phoneNum" +
            " AND u.email = :email", nativeQuery = true)
    public Optional<Long> findByNameAndStudiesAndPhoneNumAndEmail(String name, String studies, String phoneNum, String email);

    // 이메일 중복체크
    User findByEmail(String email);

    // 전화번호 중복체크
    User findByPhoneNum(String phoneNum);

    // 닉네임 중복체크
    User findByNickname(String nickname);
}

