package project.team3.three.todo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.team3.three.user.User;

@Entity
@Getter
@Setter
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(title = "todo내용")
    @Column(name = "todo")
    private String todo;

    @Schema(title = "사용자 ID")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private DeleteYN deleteyn;

}
