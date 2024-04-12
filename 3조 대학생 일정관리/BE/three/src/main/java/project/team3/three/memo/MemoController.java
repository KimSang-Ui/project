package project.team3.three.memo;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import project.team3.three.user.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("main")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class MemoController {
    private final MemoService memoService;
    private final MemoRepository memoRepository;
    //메인 부분
    @PostMapping("/memo") // 메모 등록
    public Memo Insert(Authentication authentication,@RequestBody MemoDto memodto){
        User user = (User) authentication.getPrincipal();
        return memoService.insertMemo(user ,memodto);
    }
    @GetMapping("/memo/profile") // 사용자 id로 찾기 // Y면 안나오게
    public List<Memo> selectByprofileId(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        List<Memo>list = memoRepository.findByUser(user)
                .stream().filter(memo -> memo.getDeleteYN() != DeleteYN.Y)
                .collect(Collectors.toList());
        return list;
    }
    @PutMapping("/memo/update/") // memo 업데이트
    public Memo updateMemoByfindByprofileId(Authentication authentication,
                                            @RequestBody MemoDto memoDto, @RequestParam Long id){
        User user = (User) authentication.getPrincipal();
        Long profile_id = user.getUserId();
        Optional<Memo> optionalMemo = Optional.ofNullable(memoRepository.findByUserAndId(profile_id, id));
        if (optionalMemo.isPresent()){
            Memo memo = optionalMemo.get();
            memo.setMemo(memoDto.getMemo());
            return memoRepository.save(memo);
        }else {
            return null;
        }
    }
    // memo 삭제 // Y면 안나오게
    @PutMapping("/memo/delete/")
    public Memo deleteByProfileId(Authentication authentication,
                                  @RequestParam Long id){
        User user = (User)authentication.getPrincipal();
        Long profile_id = user.getUserId();
        Optional<Memo>optionalMemo = Optional.ofNullable(memoRepository.findByUserAndId(profile_id, id));
        if (optionalMemo.isPresent()){
            Memo memo = optionalMemo.get();
            memo.setDeleteYN(DeleteYN.valueOf("Y"));
            return memoRepository.save(memo);
        }else {
            return null;
        }
    }
}
