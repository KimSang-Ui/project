package project.team3.three.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.team3.three.user.User;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board")
public class Board{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    제목
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Categories categories;

    //글 삭제 여부
    @Enumerated(EnumType.STRING)
    private Deleteyn deleteyn;

    @Schema(title = "사용자 ID")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private User user;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "createDate",updatable = false)
    private LocalDateTime createDate;


}
