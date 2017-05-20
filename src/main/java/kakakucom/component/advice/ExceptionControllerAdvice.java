package kakakucom.component.advice;

import kakakucom.component.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ApplicationException.class)
    public ModelAndView handleApplicationException(HttpServletRequest req, ApplicationException ex)
        throws Exception {
        log.warn("[" + ex.getStatusCode().getReasonPhrase() + "] "
            + req.getRequestURI() + " : " + ex.getMessage());

        ModelAndView mav = new ModelAndView();
        mav.setStatus(ex.getStatusCode());
        mav.setViewName("error/" + ex.getStatusCode().value());
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleUsernameNotFoundException(HttpServletRequest req, Exception ex)
        throws Exception {
        log.error(req.getRequestURI() + " : " + ex.getMessage());

        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        return mav;
    }
}
