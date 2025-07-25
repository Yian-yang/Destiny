package xuan.configuration.result;

import lombok.Getter;

/**
 * 结果响应枚举类
 *
 * @author 善待
 */
@Getter
public enum ResponseResultEnum {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 操作失败
     */
    ERROR(500, "操作失败"),

    /**
     * 该农历日期无法排盘
     */
    LUNAR_DATE_ERROR(401, "该农历日期无法排盘"),

    /**
     * 系统繁忙，请稍后重试
     */
    SYSTEM_ERROR(505, "系统繁忙，请稍后重试");

//********************************************************************************************************************************

    /**
     * 状态码
     */
    int code;

    /**
     * 响应信息
     */
    String msg;

//--------------------------------------------------------------------------------------------------------------------------------

    /**
     * 构造
     *
     * @param code 状态码
     * @param msg  响应信息
     */
    ResponseResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
