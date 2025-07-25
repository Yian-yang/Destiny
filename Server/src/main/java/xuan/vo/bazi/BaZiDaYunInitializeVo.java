package xuan.vo.bazi;

import lombok.Data;

import java.util.List;

/**
 * 大运流年初始化数据响应数据
 *
 * @author 善待
 */
@Data
public class BaZiDaYunInitializeVo {

    /**
     * 大运
     */
    private List<BaZiDaYunLiuNianPackageVo> daYun;
    /**
     * 小运
     */
    private List<BaZiDaYunLiuNianPackageVo> xiaoYun;
    /**
     * 流年
     */
    private List<BaZiDaYunLiuNianPackageVo> liuNian;
    /**
     * 流月
     */
    private List<BaZiDaYunLiuNianPackageVo> liuYue;

    /**
     * 天干留意
     */
    private List<String> tianGanLiuYi;
    /**
     * 地支留意
     */
    private List<String> diZhiLiuYi;


}
