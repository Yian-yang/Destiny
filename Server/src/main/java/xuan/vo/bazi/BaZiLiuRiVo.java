package xuan.vo.bazi;

import lombok.Data;

import java.util.List;

/**
 * 流日切换数据响应数据
 *
 * @author 善待
 */
@Data
public class BaZiLiuRiVo {

    /**
     * 流时
     */
    private List<BaZiDaYunLiuNianPackageVo> liuShi;

    /**
     * 天干留意
     */
    private List<String> tianGanLiuYi;
    /**
     * 地支留意
     */
    private List<String> diZhiLiuYi;


}
