package xuan.configuration.exception;

import lombok.extern.slf4j.Slf4j;
import xuan.configuration.result.ResponseResult;
import xuan.configuration.result.ResponseResultEnum;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 *
 * @author 善待
 */
@Slf4j
@ResponseBody
@ControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {

    /**
     * 处理系统异常
     *
     * @param ex 异常
     * @return 异常数据
     */
    @ExceptionHandler(SystemException.class)
    public ResponseResult<String> doSystemException(SystemException ex) {
        log.error(String.valueOf(ex));
        return ResponseResult.result(ex.getResponseResultEnum());
    }

    /**
     * 处理业务异常
     *
     * @param ex 异常
     * @return 异常数据
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult<String> exceptionHandler(BusinessException ex) {
        log.error(String.valueOf(ex));
        return ResponseResult.result(ex.getResponseResultEnum());
    }

    /**
     * 处理不可预知异常
     *
     * @param ex 异常
     * @return 异常数据
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<String> doOtherException(Exception ex) {
        log.error(String.valueOf(ex));
        return ResponseResult.result(ResponseResultEnum.SYSTEM_ERROR); // 系统繁忙，请稍后重试
    }


}
