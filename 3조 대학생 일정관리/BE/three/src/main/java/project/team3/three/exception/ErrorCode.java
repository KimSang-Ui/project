package project.team3.three.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@ToString
public enum ErrorCode {

    //
    DUPLICATE(HttpStatus.BAD_REQUEST,"DUPLICATION","중복된 내용이 있습니다."),
    NOTSELECT(HttpStatus.NOT_FOUND,"NOTFSELECT","조회할 내용이 없습니다."),
    NOTUPDATE(HttpStatus.NOT_FOUND, "NOTUPDATE", "수정할 내용이 없습니다."),
    NOTDELETE(HttpStatus.NOT_FOUND, "NOTDELETE", "삭제할 내용이 없습니다."),
    NOTINSERT(HttpStatus.NOT_FOUND, "NOTINSERT", "내용을 등록할 수 없습니다."),


    // 회원 관리 에러코드...
    NOTFOUNDUSER(HttpStatus.NOT_FOUND,"NOTFOUNDUPSER","해당하는 유저가 없습니다."),
    NOTFOUNDPASSWORD(HttpStatus.NOT_FOUND,"NOTFOUNDPASSWORD","비밀번호가 찾을 수 없습니다."),
    NOTFOUNDEMAIL(HttpStatus.NOT_FOUND,"NOTFOUNDEMAIL","아이디를 찾을 수 없습니다."),
    REGISTRATIONREQUIRED(HttpStatus.NOT_FOUND,"REGISTRATIONREQUIRED","회원가입이 안되어져있습니다."),
    MEMBERWHOWITHDREW(HttpStatus.NOT_FOUND,"MEMBERWHOWITHDREW","이미 탈퇴한 회원입니다."),


    EMAILDUPLICATE(HttpStatus.NOT_FOUND,"EMAILDUPLICATE","이메일중복입니다."),
    PHONEDUPLICATE(HttpStatus.NOT_FOUND,"PHONEDUPLICATE","전화번호중복입니다."),
    NICKNAMEDUPLICATE(HttpStatus.NOT_FOUND,"NICKNAMEDUPLICATE","닉네임중복입니다."),



    // JWT 관련 에러코드
    NOTFOUNDJWT(HttpStatus.BAD_REQUEST,"NOTFOUNDJWT","user/signIn 으로 로그인해서 JWT토큰을발행하세요"),
    NOTVALUDJWT(HttpStatus.BAD_REQUEST,"NOTVALUDJWT","JWT가 유효하지 않습니다."),
    VALIDITYPERIODEXPIRED(HttpStatus.BAD_REQUEST,"VALIDITYPERIODEXPIRED","JWT가 만료되었습니다."),

    ;

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
