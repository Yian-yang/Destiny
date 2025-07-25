package xuan.configuration.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xuan.configuration.result.ResponseResultEnum;

/**
 * 系统异常处理器
 *
 * @author 善待
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SystemException extends RuntimeException {

    /**
     * 返回参数结果枚举
     */
    private ResponseResultEnum responseResultEnum;

//**********************************************************************************************************************

    public SystemException(ResponseResultEnum responseResultEnum) {
        this.responseResultEnum = responseResultEnum;
    }


}
