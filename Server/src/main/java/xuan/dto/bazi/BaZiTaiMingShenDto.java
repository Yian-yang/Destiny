package xuan.dto.bazi;

import lombok.Data;

import java.util.Date;

/**
 * 胎命身切换请求数据
 *
 * @author 善待
 */
@Data
public class BaZiTaiMingShenDto {

    /**
     * 胎元干支
     */
    private String taiYuanGanZhi;

    /**
     * 胎息干支
     */
    private String taiXiGanZhi;

    /**
     * 命宫干支
     */
    private String mingGongGanZhi;

    /**
     * 身宫干支
     */
    private String shenGongGanZhi;

    /**
     * 年干支
     */
    private String yearGanZhi;

    /**
     * 月干支
     */
    private String monthGanZhi;

    /**
     * 日干支
     */
    private String dayGanZhi;

    /**
     * 时干支
     */
    private String hourGanZhi;


}


