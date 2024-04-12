package project.team3.three.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.team3.three.board.Deleteyn;
import project.team3.three.user.User;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    // todo 등록
    public Todo insertTodo(User user, TodoDto todoDto){
        Todo todo = new Todo();
        todo.setTodo(todoDto.getTodo());
        todo.setUser(user);
        todo.setDeleteyn(DeleteYN.valueOf("N"));
        if (todo.getTodo() == null){
        throw  new TodoInsertException("ERROR 내용을 입력해주세요");
        } else if (todo.getTodo().length() <= 1) {
            throw  new TodoInsertException("ERROR 내용을 두글자 이상 입력해주세요");
        } else {
            return todoRepository.save(todo);
        }
    }
}
