package project.team3.three.termmemo;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("termMemo")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class TermMemoController {
    private final TermMemoService termMemoService;

    @PostMapping("insert")
    public TermMemo insertTermMemo(@RequestBody TermMemoDto termMemoDto) {
        return termMemoService.insertTermMemo(termMemoDto);
    }

    @PutMapping("update")
    public TermMemo updateTermMemo(@RequestBody TermMemoDto termMemoDto) {
        return termMemoService.updateTermMemo( termMemoDto);
    }
}


