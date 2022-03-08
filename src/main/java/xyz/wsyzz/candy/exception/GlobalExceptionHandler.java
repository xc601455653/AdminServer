package xyz.wsyzz.candy.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.util.ResultDataUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ${XC} on 2019/5/17.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        exception.printStackTrace();
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    private ResultData handleErrorInfo(HttpServletRequest request, String message, Exception exception) {
        log.info(message);
        return ResultDataUtils.exception(message);
    }
}
