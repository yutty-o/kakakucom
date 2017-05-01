package kakakucom.component.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ログ出力をします。
 * 実行タイミングはControllerのRequestMappingが付与されたメソッドの実行後。
 */
@Component
@Aspect
@Slf4j
public class LogAdvice {

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void controller() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {}

    @Pointcut("execution(* kakakucom..*.*(..))")
    public void anyProjectMethodExecution() {}

    @After("controller() && requestMapping() && anyProjectMethodExecution()")
    public void createLog(JoinPoint jp) {
        log.info(
            jp.getTarget().getClass().toString() + "." +
            jp.getSignature().getName().toString()
        );
    }
}
