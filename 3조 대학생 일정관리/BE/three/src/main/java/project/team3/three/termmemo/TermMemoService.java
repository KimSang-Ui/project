package project.team3.three.termmemo;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TermMemoService {

    private final TermMemoRepository termMemoRepository;

    public TermMemo insertTermMemo(TermMemoDto termMemoDto) {
        TermMemo termMemo = new TermMemo();
        termMemo.setTodo(termMemoDto.getTodo());
        return termMemoRepository.save(termMemo);

    }

    public TermMemo updateTermMemo(TermMemoDto termMemoDto) {
        TermMemo termMemo = new ModelMapper().map(termMemoDto, TermMemo.class);
        return termMemoRepository.save(termMemo);

    }

}



