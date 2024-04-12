package project.team3.three.board;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import project.team3.three.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
@SecurityRequirement(name = "Bearer Authentication")
public class BoardController {


    private final BoardService boardService;

    private final BoardRepository boardRepository;

   // 게시판 등록// 완성
    @PostMapping("/insert")
    public Board InsertBoard(Authentication authentication, @RequestBody BoardDto boardDto){
    User user = (User) authentication.getPrincipal();
    return boardService.insert(user, boardDto);
    }
    // 내 글만 보기 // 완성
    @GetMapping("my")
    public List<Board> findme(Authentication authentication){
        User user= (User)authentication.getPrincipal();
        List<Board> list = boardRepository.findByUser(user)
                .stream()
                .filter(board -> board.getDeleteyn() != Deleteyn.Y)
                .collect(Collectors.toList());
        return list;

    }
    // 게시판 전체 보이기 // 완성
    @GetMapping()
    public List<Board> findALl(){
        List<Board>list = boardRepository.findAll()
                .stream()
                .filter(board -> board.getDeleteyn() != Deleteyn.Y)
                .collect(Collectors.toList());
        return list;
    }
    // 게시판 제목으로 검색 // 완성
        @PostMapping("/select")
        public List<Board> findTitle(@RequestBody BoardDto boardDto){
        String title = boardDto.getTitle();
            List<Board> boards = boardRepository.findByTitleContaining(title)
                    .stream()
                    .filter(board -> board.getDeleteyn() != Deleteyn.Y)
                    .collect(Collectors.toList());
            if (boards == null){
                return null;
            }else {
                return boards;
            }
        }
    // 게시판 업데이트
    @PutMapping("/update/") // 완성
    public Board updateBoardByuProfileId(Authentication authentication, @RequestBody BoardDto boardDto, @RequestParam Long id){
        User user = (User)authentication.getPrincipal();
        Long profile_id = user.getUserId();
        Optional<Board>optionalBoard = Optional.ofNullable(boardRepository.findByUserAndId(profile_id, id));
        if (optionalBoard.isPresent()){
            Board board = optionalBoard.get();
            board.setTitle(boardDto.getTitle());
            board.setContent(boardDto.getContent());
            board.setCategories(boardDto.getCategories());
            board.setModifiedDate(LocalDateTime.now());
            return boardRepository.save(board);
        }else {
            return null;
        }
    }
    // 게시판 삭제로 변경 // 완성
    @PutMapping("/delete/")
    public Board deleteBoardBuProfileId(Authentication authentication, @RequestBody BoardDto boardDto, @RequestParam Long id){
        User user = (User)authentication.getPrincipal();
        Long profile_id = user.getUserId();
        Optional<Board>optionalBoard = Optional.ofNullable(boardRepository.findByUserAndId(profile_id, id));
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.setDeleteyn(Deleteyn.valueOf("Y"));
            return boardRepository.save(board);
        } else {
            return null;
        }
    }

}

