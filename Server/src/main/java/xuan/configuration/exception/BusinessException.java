package xuan.configuration.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xuan.configuration.result.ResponseResultEnum;

/**
 * 业务异常处理器
 *
 * @author 善待
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    /**
     * 返回参数结果枚举
     */
    private ResponseResultEnum responseResultEnum;

//**********************************************************************************************************************

    public BusinessException(ResponseResultEnum responseResultEnum) {
        this.responseResultEnum = responseResultEnum;
    }


}
