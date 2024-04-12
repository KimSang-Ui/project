package project.team3.three.conf;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import project.team3.three.exception.BizException;
import project.team3.three.exception.ErrorCode;
import project.team3.three.login.TokenManager;
import project.team3.three.user.User;
import project.team3.three.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static project.team3.three.exception.ErrorCode.NOTFOUNDJWT;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("일로오나");
        String token = request.getHeader("Authorization");

        System.out.println(request.getRequestURI());

        // 토큰이 없어도 허용하는 경로
        if( request.getRequestURI().contains("signUp")
                || request.getRequestURI().contains("error")
                || request.getRequestURI().contains("signIn")
                || request.getRequestURI().contains("findId")
                || request.getRequestURI().contains("findPw")
                || request.getRequestURI().contains("swagger")
                || request.getRequestURI().contains("api-docs")
                || request.getRequestURI().contains("v3/api-docs")
        ){
            return true;
        }

        // jason web token(jwt)이 없거나 유효성이 확인이 안되면 예외처리로 진행을 못하도록 막는다
        if(token == null || !token.startsWith("Bearer ")){
            throw new BizException(NOTFOUNDJWT);
        }
        try {
            Jws<Claims> jws = tokenManager.validateToken(token.substring("Bearer ".length()));

            List<SimpleGrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(jws.getPayload().get("email").toString())); // 문제1 -> body가 없는데 body를 불러서도 문제고, 난 role도 없다!!!!!!!!!!!!!
            System.out.println(roles);


            // 로그인한 사람 정보를 authentication 에 저장해라
            Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(// 문제2 디버깅으로 반환값 확인하기(디버깅하면 뭐가 담기는지 보인다 wow) username인데 name으로 담을려고해서 안됐다
                    User.builder()
                            .email(jws.getPayload().get("email").toString())
                            .name(jws.getPayload().get("username").toString())
                            .userId(jws.getPayload().get("id", Long.class))
                            .build(),
                    null,
                    roles
            );

            // 로그인한 사람의 정보를 저장해라
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }catch (ExpiredJwtException e){
            System.out.println("토큰 만료");
            throw new BizException(ErrorCode.VALIDITYPERIODEXPIRED);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("토큰 검증 실패");
            throw new BizException(ErrorCode.NOTVALUDJWT);
        }
        return true;
    }
}
