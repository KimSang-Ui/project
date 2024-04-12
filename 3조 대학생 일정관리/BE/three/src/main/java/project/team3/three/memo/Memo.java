package project.team3.three.memo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.team3.three.user.User;


@Entity
@Getter
@Setter
@Table(name = "memo")
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(title = "memo내용")
    @Column(name = "memo")
    private String memo;

    @Schema(title = "사용자 ID")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private User user;
    @Enumerated(EnumType.STRING)
    private DeleteYN deleteYN;

}
