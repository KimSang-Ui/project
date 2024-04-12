package project.team3.three.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.team3.three.user.User;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시판 글 등록
    public Board insert(User user, BoardDto boardDto) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setUser(user);
        board.setDeleteyn(Deleteyn.valueOf("N"));
        board.setCreateDate(LocalDateTime.now());
        board.setCategories(boardDto.getCategories());
        board.setModifiedDate(LocalDateTime.now());
        if (board.getTitle() == null){
            throw  new BoardInsertException("ERROR 제목을 입력해주세요");
        }if (board.getTitle().length() <= 1){
            throw new BoardInsertException("ERROR 제목을 두글자 이상 입력해주세요");
        }if (board.getContent() == null){
            throw new BoardInsertException("ERROR 내용을 입력해주세요");
        }if (board.getContent().length() <= 1){
            throw new BoardInsertException("ERROR 내용을 두글자 이상 입력해주세요");
        }if (board.getCategories() == null){
            throw new BoardInsertException("ERROR 카테고리를 선택해주세요");
        }if (boardRepository.existsByTitle(boardDto.getTitle())) {
            throw new BoardInsertException("ERROR 이미 존재하는 제목입니다");
        }
        else{
            return boardRepository.save(board);
        }
    }

}

