package xuan.dto.bazi;

import lombok.Data;

import java.util.Date;

/**
 * 流时切换请求数据
 *
 * @author 善待
 */
@Data
public class BaZiLiuShiDto {

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

    /**
     * 大运干支
     */
    private String daYunGanZhi;

    /**
     * 流年干支
     */
    private String liuNianGanZhi;

    /**
     * 流月干支
     */
    private String liuYueGanZhi;

    /**
     * 流日干支
     */
    private String liuRiGanZhi;

    /**
     * 流时干支
     */
    private String liuShiGanZhi;


}


