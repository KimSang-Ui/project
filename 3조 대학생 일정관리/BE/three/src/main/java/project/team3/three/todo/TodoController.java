package project.team3.three.todo;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import project.team3.three.board.Deleteyn;
import project.team3.three.user.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("main")
@SecurityRequirement(name = "Bearer Authentication")
public class TodoController {
    private final TodoService todoService;
    private final TodoRepository todoRepository;

    // 투두 등록
    @PostMapping("/todo")
    public Todo InsertTodo(Authentication authentication, @RequestBody TodoDto todoDto){
        User user = (User) authentication.getPrincipal();
        return todoService.insertTodo(user, todoDto);
    }
    // todo 찾기 // Y인 경우는 안나오게
    @GetMapping("/todo/profile")
    public List<Todo> selectbyprofileId(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        List<Todo> list = todoRepository.findByUser(user)
                .stream().filter(todo -> todo.getDeleteyn() != DeleteYN.Y)
                .collect(Collectors.toList());
        return list;
    }
    @PutMapping("/todo/update/") // todo 업데이트 // 완성
    public Todo updateTodoByprofileId(Authentication authentication,
                                      @RequestBody TodoDto todoDto, @RequestParam Long id){
        User user = (User)authentication.getPrincipal();
        Long profile_id = user.getUserId();
        Optional<Todo>optionalTodo = Optional.ofNullable(todoRepository.findByUserAndId(profile_id, id));
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            todo.setTodo(todoDto.getTodo());
            todo.setDeleteyn(DeleteYN.N);
            return todoRepository.save(todo);
        }else {
            return null;
        }
    }
    //todo 삭제 // Y면 안나오게
    @PutMapping("/todo/delete/")
    public Todo deleteTodoByprofileId(Authentication authentication,
                                      @RequestParam Long id){
        User user = (User)authentication.getPrincipal();
        Long profile_id = user.getUserId();
        Optional<Todo>optionalTodo = Optional.ofNullable(todoRepository.findByUserAndId(profile_id, id));
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            todo.setDeleteyn(DeleteYN.valueOf("Y"));
            return todoRepository.save(todo);
        }else {
            return null;
        }
    }
}
