package project.team3.three.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.team3.three.user.User;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    // memo 등록
    public Memo insertMemo(User user , MemoDto memoDto) {
        Memo memo = new Memo();
        memo.setMemo(memoDto.getMemo());
        memo.setDeleteYN(DeleteYN.valueOf("N"));
        memo.setUser(user);
       if (memo.getMemo() == null){
           throw new MemoInsertionException("ERROR 내용을 입력해주세요");
       } else if (memo.getMemo().length() <= 1) {
           throw new MemoInsertionException("ERROR 내용을 두글자 이상 입력해주세요");
       } else {
           return memoRepository.save(memo);
       }
    }
}
