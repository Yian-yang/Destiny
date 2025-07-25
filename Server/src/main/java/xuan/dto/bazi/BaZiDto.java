package xuan.dto.bazi;

import lombok.Data;

import java.util.Date;

/**
 * 八字请求数据
 *
 * @author 善待
 */
@Data
public class BaZiDto {

    /**
     * 姓名
     */
    private String name;

    /**
     * 占事
     */
    private String occupy;

    /**
     * 性别（0:女。1:男）
     */
    private int sex;

    /**
     * 日期
     */
    private Date date;

    /**
     * 日期类型（0:公历。1:农历）
     */
    private int dateType;

    /**
     * 地区
     */
    private String address;

    /**
     * 闰月类型（0:不使用闰月。1:使用闰月）
     */
    private int leapMonthType;

    /**
     * 节气类型（0:按天计算。1:按分钟计算）
     */
    private int jieQiType;

    /**
     * 起运流派类型（0:按天数和时辰数计算：3天1年、1天4个月、1时辰10天。1:按分钟数计算：4320分=1年、360分=1月、12分=1天、1分=2小时）
     */
    private int qiYunLiuPaiType;

    /**
     * 人元司令分野类型（0:子平真诠法诀。1:渊海子平法诀。2:星平会海法诀。3:三命通会法诀。4:神峰通考法诀。5:万育吾之法诀）
     */
    private int renYuanType;

    /**
     * 大运轮数（最小10轮，最大16轮）
     */
    private int daYunLunShu;

    /**
     * 未知时辰（0:不使用未知时辰。1:使用未知时辰）
     */
    private int isUnknownTime;

    /**
     * 年干支类型（0:以正月初一作为新年的开始。1:以立春当天作为新年的开始。2:以立春交接时刻作为新年的开始）
     */
    private int yearGanZhiType;

    /**
     * 月干支类型（0:以节交接当天起算。1:以节交接时刻起算）
     */
    private int monthGanZhiType;

    /**
     * 日干支类型（0:晚子时日柱按明天。1:晚子时日柱按当天）
     */
    private int dayGanZhiType;


}
