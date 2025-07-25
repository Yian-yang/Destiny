package xuan.dto.bazi;

import lombok.Data;

import java.util.Date;

/**
 * 流年切换请求数据
 *
 * @author 善待
 */
@Data
public class BaZiLiuNianDto {

    /**
     * 公历出生日期
     */
    private Date solarDate;

    /**
     * 性别（0:女。1:男）
     */
    private int sex;

    /**
     * 年干支类型（0:以正月初一作为新年的开始。1:以立春当天作为新年的开始。2:以立春交接时刻作为新年的开始）
     */
    protected int yearGanZhiType;

    /**
     * 月干支类型（0:以节交接当天起算。1:以节交接时刻起算）
     */
    protected int monthGanZhiType;

    /**
     * 日干支类型（0:晚子时日柱按明天。1:晚子时日柱按当天）
     */
    protected int dayGanZhiType;

    /**
     * 起运流派（0:按天数和时辰数计算：3天1年、1天4个月、1时辰10天。1:按分钟数计算：4320分=1年、360分=1月、12分=1天、1分=2小时）
     */
    private int qiYunLiuPai;

    /**
     * 一共需要计算多少轮大运（最小10轮，最大16轮）
     */
    private int daYunLunShu;

    /**
     * 大运干支
     */
    private String daYunGanZhi;

    /**
     * 流年干支
     */
    private String liuNianGanZhi;

    /**
     * 大运轮
     */
    private int daYunLun;

    /**
     * 流年轮
     */
    private int liuNianLun;

    /**
     * 流年公历日期
     */
    private String liuNianSolarDate;


}


