package xuan.configuration.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 结果响应类
 *
 * @author 善待
 */
@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 数据
     */
    private T data;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String msg;

//--------------------------------------------------------------------------------------------------------------------------------

    /**
     * 响应结果
     *
     * @param responseResultEnum 返回参数结果枚举
     * @param <T>                数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> result(ResponseResultEnum responseResultEnum) {

        ResponseResult<T> r = new ResponseResult<>();
        r.code = responseResultEnum.getCode();
        r.msg = responseResultEnum.getMsg();
        return r;

    }

    /**
     * 响应结果
     *
     * @param responseResultEnum 返回参数结果枚举
     * @param data               数据
     * @param <T>                数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> result(ResponseResultEnum responseResultEnum, T data) {

        ResponseResult<T> r = new ResponseResult<>();
        r.code = responseResultEnum.getCode();
        r.msg = responseResultEnum.getMsg();
        r.data = data;
        return r;

    }

    /**
     * 响应结果
     *
     * @param responseResultEnum 返回参数结果枚举
     * @param msg                响应信息
     * @param <T>                数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> result(ResponseResultEnum responseResultEnum, String msg) {

        ResponseResult<T> r = new ResponseResult<>();
        r.code = responseResultEnum.getCode();
        r.msg = msg;
        return r;

    }

    /**
     * 响应结果
     *
     * @param responseResultEnum 返回参数结果枚举
     * @param msg                响应信息
     * @param data               数据
     * @param <T>                数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> result(ResponseResultEnum responseResultEnum, String msg, T data) {

        ResponseResult<T> r = new ResponseResult<>();
        r.code = responseResultEnum.getCode();
        r.msg = msg;
        r.data = data;
        return r;

    }


}
