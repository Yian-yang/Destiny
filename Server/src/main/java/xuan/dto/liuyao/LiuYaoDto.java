package xuan.dto.liuyao;

import lombok.Data;

import java.util.Date;

/**
 * 六爻请求数据
 *
 * @author 善待
 */
@Data
public class LiuYaoDto {

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
     * 闰月类型（0:不使用闰月。1:使用闰月）
     */
    private int leapMonthType;

    /**
     * 节气类型（0:按天计算。1:按分钟计算）
     */
    private int jieQiType;

    /**
     * 排盘类型（0:日期。1:自动。2:手动）
     */
    private int paiPanType;

    /**
     * 上爻（0:—（2正1背）。1:- -（1正2背）。2:— ○（0正3背）。3:- - ×（3正0背））
     */
    private int liuYao;

    /**
     * 五爻（0:—（2正1背）。1:- -（1正2背）。2:— ○（0正3背）。3:- - ×（3正0背））
     */
    private int wuYao;

    /**
     * 四爻（0:—（2正1背）。1:- -（1正2背）。2:— ○（0正3背）。3:- - ×（3正0背））
     */
    private int siYao;

    /**
     * 三爻（0:—（2正1背）。1:- -（1正2背）。2:— ○（0正3背）。3:- - ×（3正0背））
     */
    private int sanYao;

    /**
     * 二爻（0:—（2正1背）。1:- -（1正2背）。2:— ○（0正3背）。3:- - ×（3正0背））
     */
    private int erYao;

    /**
     * 初爻（0:—（2正1背）。1:- -（1正2背）。2:— ○（0正3背）。3:- - ×（3正0背））
     */
    private int yiYao;

    /**
     * 年干支设置（0:以正月初一作为新年的开始。1:以立春当天作为新年的开始。2:以立春交接时刻作为新年的开始）
     */
    private int yearGanZhiSet;

    /**
     * 月干支设置（0:以节交接当天起算。1:以节交接时刻起算）
     */
    private int monthGanZhiSet;

    /**
     * 日干支设置（0:晚子时日干支算当天。1:晚子时日干支算明天）
     */
    private int dayGanZhiSet;


}
