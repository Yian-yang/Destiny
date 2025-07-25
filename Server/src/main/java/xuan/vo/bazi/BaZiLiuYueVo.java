package xuan.vo.bazi;

import lombok.Data;

import java.util.List;

/**
 * 流月切换数据响应数据
 *
 * @author 善待
 */
@Data
public class BaZiLiuYueVo {

    /**
     * 流日
     */
    private List<BaZiDaYunLiuNianPackageVo> liuRi;

    /**
     * 天干留意
     */
    private List<String> tianGanLiuYi;
    /**
     * 地支留意
     */
    private List<String> diZhiLiuYi;


}
