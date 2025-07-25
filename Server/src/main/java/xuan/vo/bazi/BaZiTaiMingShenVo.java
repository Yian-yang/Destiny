package xuan.vo.bazi;

import lombok.Data;

import java.util.List;

/**
 * 胎命身切换数据响应数据
 *
 * @author 善待
 */
@Data
public class BaZiTaiMingShenVo {

    /**
     * 天干留意
     */
    private List<String> tianGanLiuYi;
    /**
     * 地支留意
     */
    private List<String> diZhiLiuYi;


}
