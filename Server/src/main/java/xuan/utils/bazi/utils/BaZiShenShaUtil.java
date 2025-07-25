package xuan.utils.bazi.utils;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import xuan.utils.bazi.maps.BaZiShenShaMap;
import xuan.utils.CommonUtil;
import xuan.utils.bazi.maps.BaZiJiChuMap;

/**
 * 八字 - 神煞工具
 *
 * @author 善待
 */
public class BaZiShenShaUtil {

    /**
     * 性别（0:女。1:男）
     */
    private int sex;
    /**
     * 季节
     */
    private String jiJie;
    /**
     * 年干支纳音五行
     */
    private String yearGanZhiNaYinWuXing;

    /**
     * 年干
     */
    private String yearGan;
    /**
     * 月干
     */
    private String monthGan;
    /**
     * 日干
     */
    private String dayGan;
    /**
     * 时干
     */
    private String hourGan;
    /**
     * 大运干
     */
    private String daYunGan;
    /**
     * 流年干
     */
    private String liuNianGan;
    /**
     * 流月干
     */
    private String liuYueGan;
    /**
     * 流日干
     */
    private String liuRiGan;
    /**
     * 流时干
     */
    private String liuShiGan;

    /**
     * 年支
     */
    private String yearZhi;
    /**
     * 月支
     */
    private String monthZhi;
    /**
     * 日支
     */
    private String dayZhi;
    /**
     * 时支
     */
    private String hourZhi;
    /**
     * 大运支
     */
    private String daYunZhi;
    /**
     * 流年支
     */
    private String liuNianZhi;
    /**
     * 流月支
     */
    private String liuYueZhi;
    /**
     * 流日支
     */
    private String liuRiZhi;
    /**
     * 流时支
     */
    private String liuShiZhi;

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

    /**
     * 年干支神煞
     */
    private List<String> yearGanZhiShenSha = new ArrayList<>();
    /**
     * 月干支神煞
     */
    private List<String> monthGanZhiShenSha = new ArrayList<>();
    /**
     * 日干支神煞
     */
    private List<String> dayGanZhiShenSha = new ArrayList<>();
    /**
     * 时干支神煞
     */
    private List<String> hourGanZhiShenSha = new ArrayList<>();
    /**
     * 大运干支神煞
     */
    private List<String> daYunGanZhiShenSha = new ArrayList<>();
    /**
     * 流年干支神煞
     */
    private List<String> liuNianGanZhiShenSha = new ArrayList<>();
    /**
     * 流月干支神煞
     */
    private List<String> liuYueGanZhiShenSha = new ArrayList<>();
    /**
     * 流日干支神煞
     */
    private List<String> liuRiGanZhiShenSha = new ArrayList<>();
    /**
     * 流时干支神煞
     */
    private List<String> liuShiGanZhiShenSha = new ArrayList<>();

//*******************************************************************************************************************************

    /**
     * 初始化
     *
     * @param sex                   性别（0:女。1:男）
     * @param jiJie                 季节
     * @param yearGanZhiNaYinWuXing 年干支纳音五行
     * @param yearGanZhi            年干支（若为空或格式错误则不计算此柱神煞）
     * @param monthGanZhi           月干支（若为空或格式错误则不计算此柱神煞）
     * @param dayGanZhi             日干支（若为空或格式错误则不计算此柱神煞）
     * @param hourGanZhi            时干支（若为空或格式错误则不计算此柱神煞）
     * @param daYunGanZhi           大运干支（若为空或格式错误则不计算此柱神煞）
     * @param liuNianGanZhi         流年干支（若为空或格式错误则不计算此柱神煞）
     * @param liuYueGanZhi          流月干支（若为空或格式错误则不计算此柱神煞）
     * @param liuRiGanZhi           流日干支（若为空或格式错误则不计算此柱神煞）
     * @param liuShiGanZhi          流时干支（若为空或格式错误则不计算此柱神煞）
     */
    public BaZiShenShaUtil(int sex, String jiJie, String yearGanZhiNaYinWuXing, String yearGanZhi, String monthGanZhi, String dayGanZhi, String hourGanZhi, String daYunGanZhi, String liuNianGanZhi, String liuYueGanZhi, String liuRiGanZhi, String liuShiGanZhi) {

        // 1、处理数据
        this.sex = sex; // 性别
        this.jiJie = jiJie; // 季节
        this.yearGanZhiNaYinWuXing = yearGanZhiNaYinWuXing; // 年干支纳音五行
        this.yearGanZhi = (StringUtils.isNotBlank(yearGanZhi) && yearGanZhi.length() == 2) ? yearGanZhi : CommonUtil.EMPTY2; // 年干支
        this.yearGan = this.yearGanZhi.substring(0, 1); // 年干
        this.yearZhi = this.yearGanZhi.substring(1, 2); // 年支
        this.monthGanZhi = (StringUtils.isNotBlank(monthGanZhi) && monthGanZhi.length() == 2) ? monthGanZhi : CommonUtil.EMPTY2; // 月干支
        this.monthGan = this.monthGanZhi.substring(0, 1); // 月干
        this.monthZhi = this.monthGanZhi.substring(1, 2); // 月支
        this.dayGanZhi = (StringUtils.isNotBlank(dayGanZhi) && dayGanZhi.length() == 2) ? dayGanZhi : CommonUtil.EMPTY2; // 日干支
        this.dayGan = this.dayGanZhi.substring(0, 1); // 日干
        this.dayZhi = this.dayGanZhi.substring(1, 2); // 日支
        this.hourGanZhi = (StringUtils.isNotBlank(hourGanZhi) && hourGanZhi.length() == 2) ? hourGanZhi : CommonUtil.EMPTY2; // 时干支
        this.hourGan = this.hourGanZhi.substring(0, 1); // 时干
        this.hourZhi = this.hourGanZhi.substring(1, 2); // 时支
        this.daYunGanZhi = (StringUtils.isNotBlank(daYunGanZhi) && daYunGanZhi.length() == 2) ? daYunGanZhi : CommonUtil.EMPTY2; // 大运干支
        this.daYunGan = this.daYunGanZhi.substring(0, 1); // 大运干
        this.daYunZhi = this.daYunGanZhi.substring(1, 2); // 大运支
        this.liuNianGanZhi = (StringUtils.isNotBlank(liuNianGanZhi) && liuNianGanZhi.length() == 2) ? liuNianGanZhi : CommonUtil.EMPTY2; // 流年干支
        this.liuNianGan = this.liuNianGanZhi.substring(0, 1); // 流年干
        this.liuNianZhi = this.liuNianGanZhi.substring(1, 2); // 流年支
        this.liuYueGanZhi = (StringUtils.isNotBlank(liuYueGanZhi) && liuYueGanZhi.length() == 2) ? liuYueGanZhi : CommonUtil.EMPTY2; // 流月干支
        this.liuYueGan = this.liuYueGanZhi.substring(0, 1); // 流月干
        this.liuYueZhi = this.liuYueGanZhi.substring(1, 2); // 流月支
        this.liuRiGanZhi = (StringUtils.isNotBlank(liuRiGanZhi) && liuRiGanZhi.length() == 2) ? liuRiGanZhi : CommonUtil.EMPTY2; // 流日干支
        this.liuRiGan = this.liuRiGanZhi.substring(0, 1); // 流日干
        this.liuRiZhi = this.liuRiGanZhi.substring(1, 2); // 流日支
        this.liuShiGanZhi = (StringUtils.isNotBlank(liuShiGanZhi) && liuShiGanZhi.length() == 2) ? liuShiGanZhi : CommonUtil.EMPTY2; // 流时干支
        this.liuShiGan = this.liuShiGanZhi.substring(0, 1); // 流时干
        this.liuShiZhi = this.liuShiGanZhi.substring(1, 2); // 流时支

        // 2、初始化数据
        initializeShenSha(); // 初始化神煞

    }

//===============================================================================================================================

    /**
     * 获取年干支神煞
     *
     * @return 年干支神煞（如：[太极贵人]）
     */
    public List<String> getYearGanZhiShenSha() {
        return this.yearGanZhiShenSha;
    }

    /**
     * 获取月干支神煞
     *
     * @return 月干支神煞（如：[太极贵人]）
     */
    public List<String> getMonthGanZhiShenSha() {
        return this.monthGanZhiShenSha;
    }

    /**
     * 获取日干支神煞
     *
     * @return 日干支神煞（如：[太极贵人]）
     */
    public List<String> getDayGanZhiShenSha() {
        return this.dayGanZhiShenSha;
    }

    /**
     * 获取时干支神煞
     *
     * @return 时干支神煞（如：[太极贵人]）
     */
    public List<String> getHourGanZhiShenSha() {
        return this.hourGanZhiShenSha;
    }

    /**
     * 获取大运干支神煞
     *
     * @return 大运干支神煞（如：[太极贵人]）
     */
    public List<String> getDaYunGanZhiShenSha() {
        return this.daYunGanZhiShenSha;
    }

    /**
     * 获取流年干支神煞
     *
     * @return 流年干支神煞（如：[太极贵人]）
     */
    public List<String> getLiuNianGanZhiShenSha() {
        return this.liuNianGanZhiShenSha;
    }

    /**
     * 获取流月干支神煞
     *
     * @return 流月干支神煞（如：[太极贵人]）
     */
    public List<String> getLiuYueGanZhiShenSha() {
        return this.liuYueGanZhiShenSha;
    }

    /**
     * 获取流日干支神煞
     *
     * @return 流日干支神煞（如：[太极贵人]）
     */
    public List<String> getLiuRiGanZhiShenSha() {
        return this.liuRiGanZhiShenSha;
    }

    /**
     * 获取流时干支神煞
     *
     * @return 流时干支神煞（如：[太极贵人]）
     */
    public List<String> getLiuShiGanZhiShenSha() {
        return this.liuShiGanZhiShenSha;
    }

//-------------------------------------------------------------------------------------------------------------------------------

    /**
     * 计算太极贵人
     */
    private void taiJiGuiRen() {

        Map<String, String> map = BaZiShenShaMap.TAI_JI_GUI_REN; // 太极贵人（年干\日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.yearGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGan + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算天乙贵人
     */
    private void tianYiGuiRen() {

        Map<String, String> map = BaZiShenShaMap.TIAN_YI_GUI_REN; // 天乙贵人（年干\日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.yearGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGan + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算福星贵人
     */
    private void fuXingGuiRen() {

        Map<String, String> map = BaZiShenShaMap.FU_XING_GUI_REN; // 福星贵人（年干\日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.yearGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGan + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算文昌贵人
     */
    private void wenChangGuiRen() {

        Map<String, String> map = BaZiShenShaMap.WEN_CHANG_GUI_REN; // 文昌贵人（年干\日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.yearGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGan + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算天厨贵人
     */
    private void tianChuGuiRen() {

        Map<String, String> map = BaZiShenShaMap.TIAN_CHU_GUI_REN; // 天厨贵人（年干\日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.yearGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGan + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算国印
     */
    private void guoYin() {

        Map<String, String> map = BaZiShenShaMap.GUO_YIN; // 国印（年干\日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.yearGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGan + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算金舆
     */
    private void jinYu() {

        Map<String, String> map = BaZiShenShaMap.JIN_YU; // 金舆（年干\日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.yearGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGan + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算红艳煞
     */
    private void hongYanSha() {

        Map<String, String> map = BaZiShenShaMap.HONG_YAN_SHA; // 红艳煞（日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算羊刃
     */
    private void yangRen() {

        Map<String, String> map = BaZiShenShaMap.YANG_REN; // 羊刃（日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算飞刃
     */
    private void feiRen() {

        Map<String, String> map = BaZiShenShaMap.FEI_REN; // 飞刃（日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算流霞
     */
    private void liuXia() {

        Map<String, String> map = BaZiShenShaMap.LIU_XIA; // 流霞（日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算禄神
     */
    private void luShen() {

        Map<String, String> map = BaZiShenShaMap.LU_SHEN; // 禄神（日干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.dayGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.dayGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGan + this.liuShiZhi));

    }

    /**
     * 计算驿马
     */
    private void yiMa() {

        Map<String, String> map = BaZiShenShaMap.YI_MA; // 驿马（年支\日支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayZhi + this.monthZhi));
//        this.dayGanZhiShenSha.add(map.get(this.dayZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayZhi + this.liuShiZhi));

    }

    /**
     * 计算劫煞
     */
    private void jieSha() {

        Map<String, String> map = BaZiShenShaMap.JIE_SHA; // 劫煞（年支\日支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayZhi + this.monthZhi));
//        this.dayGanZhiShenSha.add(map.get(this.dayZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayZhi + this.liuShiZhi));

    }

    /**
     * 计算将星
     */
    private void jiangXing() {

        Map<String, String> map = BaZiShenShaMap.JIANG_XING; // 将星（年支\日支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayZhi + this.monthZhi));
//        this.dayGanZhiShenSha.add(map.get(this.dayZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayZhi + this.liuShiZhi));

    }

    /**
     * 计算桃花
     */
    private void taoHua() {

        Map<String, String> map = BaZiShenShaMap.TAO_HUA; // 桃花（年支\日支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayZhi + this.monthZhi));
//        this.dayGanZhiShenSha.add(map.get(this.dayZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayZhi + this.liuShiZhi));

    }

    /**
     * 计算亡神
     */
    private void wangShen() {

        Map<String, String> map = BaZiShenShaMap.WANG_SHEN; // 亡神（年支\日支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayZhi + this.monthZhi));
//        this.dayGanZhiShenSha.add(map.get(this.dayZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayZhi + this.liuShiZhi));

    }

    /**
     * 计算吊客
     */
    private void diaoKe() {

        Map<String, String> map = BaZiShenShaMap.DIAO_KE; // 吊客（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算披麻
     */
    private void piMa() {

        Map<String, String> map = BaZiShenShaMap.PI_MA; // 披麻（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算天官贵人
     */
    private void tianGuanGuiRen() {

        Map<String, String> map = BaZiShenShaMap.TIAN_GUAN_GUI_REN; // 天官贵人（年干+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.yearGan + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGan + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGan + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGan + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGan + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGan + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGan + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGan + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGan + this.liuShiZhi));

    }

    /**
     * 计算天喜
     */
    private void tianXi() {

        Map<String, String> map = BaZiShenShaMap.TIAN_XI; // 天喜（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算勾绞煞
     */
    private void gouJiaoSha() {

        Map<String, String> map = BaZiShenShaMap.GOU_JIAO_SHA; // 勾绞煞（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算红鸾
     */
    private void hongLuan() {

        Map<String, String> map = BaZiShenShaMap.HONG_LUAN; // 红鸾（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算丧门
     */
    private void sangMen() {

        Map<String, String> map = BaZiShenShaMap.SANG_MEN; // 丧门（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算灾煞
     */
    private void zaiSha() {

        Map<String, String> map = BaZiShenShaMap.ZAI_SHA; // 灾煞（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算孤辰
     */
    private void guChen() {

        Map<String, String> map = BaZiShenShaMap.GU_CHEN; // 孤辰（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算寡宿
     */
    private void guaXiu() {

        Map<String, String> map = BaZiShenShaMap.GUA_XIU; // 寡宿（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算元辰
     */
    private void yuanChen() {

        Map<String, String> map1 = BaZiShenShaMap.YUAN_CHEN_YANG_NAN; // 元辰（年支+其余地支），阳男阴女
        Map<String, String> map2 = BaZiShenShaMap.YUAN_CHEN_YIN_NAN; // 元辰（年支+其余地支），阴男阳女

        Map<String, String> map;
        String sex = this.sex == 0 ? "女" : "男";
        String yearGanYinYangSex = BaZiJiChuMap.TIAN_GAN_YIN_YANG.get(this.yearGan) + sex;
        if ("阳男".equals(yearGanYinYangSex) || "阴女".equals(yearGanYinYangSex)) {
            map = map1;
        } else {
            map = map2;
        }

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

    }

    /**
     * 计算血刃
     */
    private void xueRen() {

        Map<String, String> map = BaZiShenShaMap.XUE_REN; // 血刃（月支+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiZhi));

    }

    /**
     * 计算天医
     */
    private void tianYi() {

        Map<String, String> map = BaZiShenShaMap.TIAN_YI; // 天医（月支+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearZhi));
//        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiZhi));

    }

    /**
     * 计算天德合
     */
    private void tianDeHe() {

        Map<String, String> map = BaZiShenShaMap.TIAN_DE_HE; // 天德合（月支+其余天干或地支为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearGan));
        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthGan));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGan));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourGan));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunGan));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianGan));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueGan));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiGan));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiGan));

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearZhi));
//        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiZhi));

    }

    /**
     * 计算月德合
     */
    private void yueDeHe() {

        Map<String, String> map = BaZiShenShaMap.YUE_DE_HE; // 月德合（月支+其余天干为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearGan));
        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthGan));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGan));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourGan));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunGan));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianGan));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueGan));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiGan));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiGan));

    }

    /**
     * 计算词馆
     */
    private void ciGuan() {

        Map<String, String> map = BaZiShenShaMap.CI_GUAN_LU_MING; // 词馆（年柱纳音五行+干支为键），禄命法

//        if (null != map.get(this.yearGanZhiNaYinWuXing + this.yearZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.yearGanZhi)) {
//            this.yearGanZhiShenSha.add("词馆");
//        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.yearGanZhi)) {
//            this.yearGanZhiShenSha.add("正词馆");
//        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.monthZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.monthGanZhi)) {
            this.monthGanZhiShenSha.add("词馆");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.monthGanZhi)) {
            this.monthGanZhiShenSha.add("正词馆");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.dayZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.dayGanZhi)) {
            this.dayGanZhiShenSha.add("词馆");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.dayGanZhi)) {
            this.dayGanZhiShenSha.add("正词馆");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.hourZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.hourGanZhi)) {
            this.hourGanZhiShenSha.add("词馆");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.hourGanZhi)) {
            this.hourGanZhiShenSha.add("正词馆");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.daYunZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.daYunGanZhi)) {
            this.daYunGanZhiShenSha.add("词馆");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.daYunGanZhi)) {
            this.daYunGanZhiShenSha.add("正词馆");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuNianZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.liuNianGanZhi)) {
            this.liuNianGanZhiShenSha.add("词馆");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuNianGanZhi)) {
            this.liuNianGanZhiShenSha.add("正词馆");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuYueZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.liuYueGanZhi)) {
            this.liuYueGanZhiShenSha.add("词馆");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuYueGanZhi)) {
            this.liuYueGanZhiShenSha.add("正词馆");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuRiZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.liuRiGanZhi)) {
            this.liuRiGanZhiShenSha.add("词馆");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuRiGanZhi)) {
            this.liuRiGanZhiShenSha.add("正词馆");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuShiZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.liuShiGanZhi)) {
            this.liuShiGanZhiShenSha.add("词馆");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuShiGanZhi)) {
            this.liuShiGanZhiShenSha.add("正词馆");
        }

    }

    /**
     * 计算学堂
     */
    private void xueTang() {

        Map<String, String> map = BaZiShenShaMap.XUE_TANG_LU_MING; // 学堂（年柱纳音五行+干支为键），禄命法

//        if (null != map.get(this.yearGanZhiNaYinWuXing + this.yearZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.yearGanZhi)) {
//            this.yearGanZhiShenSha.add("学堂");
//        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.yearGanZhi)) {
//            this.yearGanZhiShenSha.add("正学堂");
//        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.monthZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.monthGanZhi)) {
            this.monthGanZhiShenSha.add("学堂");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.monthGanZhi)) {
            this.monthGanZhiShenSha.add("正学堂");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.dayZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.dayGanZhi)) {
            this.dayGanZhiShenSha.add("学堂");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.dayGanZhi)) {
            this.dayGanZhiShenSha.add("正学堂");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.hourZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.hourGanZhi)) {
            this.hourGanZhiShenSha.add("学堂");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.hourGanZhi)) {
            this.hourGanZhiShenSha.add("正学堂");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.daYunZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.daYunGanZhi)) {
            this.daYunGanZhiShenSha.add("学堂");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.daYunGanZhi)) {
            this.daYunGanZhiShenSha.add("正学堂");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuNianZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.liuNianGanZhi)) {
            this.liuNianGanZhiShenSha.add("学堂");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuNianGanZhi)) {
            this.liuNianGanZhiShenSha.add("正学堂");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuYueZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.liuYueGanZhi)) {
            this.liuYueGanZhiShenSha.add("学堂");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuYueGanZhi)) {
            this.liuYueGanZhiShenSha.add("正学堂");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuRiZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.liuRiGanZhi)) {
            this.liuRiGanZhiShenSha.add("学堂");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuRiGanZhi)) {
            this.liuRiGanZhiShenSha.add("正学堂");
        }

        if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuShiZhi) && null == map.get(this.yearGanZhiNaYinWuXing + this.liuShiGanZhi)) {
            this.liuShiGanZhiShenSha.add("学堂");
        } else if (null != map.get(this.yearGanZhiNaYinWuXing + this.liuShiGanZhi)) {
            this.liuShiGanZhiShenSha.add("正学堂");
        }

    }

    /**
     * 计算天赦
     */
    private void tianShe() {

        Map<String, String> map = BaZiShenShaMap.TIAN_SHE; // 天赦（月支+日干支为键）

        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGanZhi));

    }

    /**
     * 计算天转
     */
    private void tianZhuan() {

        Map<String, String> map = BaZiShenShaMap.TIAN_ZHUAN; // 天转（月支+日干支为键）

        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGanZhi));

    }

    /**
     * 计算地转
     */
    private void diZhuan() {

        Map<String, String> map = BaZiShenShaMap.DI_ZHUAN; // 地转（月支+日干支为键）

        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGanZhi));

    }

    /**
     * 计算月德贵人
     */
    private void yueDeGuiRen() {

        Map<String, String> map = BaZiShenShaMap.YUE_DE_GUI_REN; // 月德贵人（月支+其余天干为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearGan));
        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthGan));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGan));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourGan));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunGan));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianGan));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueGan));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiGan));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiGan));

    }

    /**
     * 计算德秀贵人
     */
    private void deXiuGuiRen() {

        Map<String, String> map = BaZiShenShaMap.DE_XIU_GUI_REN; // 德秀贵人（月支+其余天干为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearGan));
        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthGan));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGan));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourGan));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunGan));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianGan));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueGan));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiGan));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiGan));

    }

    /**
     * 计算天德贵人
     */
    private void tianDeGuiRen() {

        Map<String, String> map = BaZiShenShaMap.TIAN_DE_GUI_REN; // 天德贵人（月支+其余天干或地支为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearGan));
        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthGan));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGan));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourGan));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunGan));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianGan));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueGan));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiGan));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiGan));

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearZhi));
//        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiZhi));

    }

    /**
     * 计算拱禄
     */
    private void gongLu() {

        Map<String, String> map = BaZiShenShaMap.GONG_LU; // 拱禄（日干支+时干支+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearGan));
        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthGan));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGan));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourGan));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunGan));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianGan));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueGan));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiGan));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiGan));

    }

    /**
     * 计算华盖
     */
    private void huaGai() {

        Map<String, String> map = BaZiShenShaMap.HUA_GAI; // 华盖（年支\日支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayZhi + this.monthZhi));
//        this.dayGanZhiShenSha.add(map.get(this.dayZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayZhi + this.liuShiZhi));

    }

    /**
     * 计算童子煞
     */
    private void tongZiSha() {

        Map<String, String> map = BaZiShenShaMap.TONG_ZI_SHA; // 童子煞（季节+日支\时支为键。年柱纳音五行+日支\时支为键）

        this.dayGanZhiShenSha.add(map.get(this.jiJie + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.jiJie + this.hourZhi));

        this.dayGanZhiShenSha.add(map.get(this.yearGanZhiNaYinWuXing + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGanZhiNaYinWuXing + this.hourZhi));

    }

    /**
     * 计算冲天煞
     */
    private void chongTianSha() {

        // 判断年干支与月干支是否相同
        if (this.yearGanZhi.equals(this.monthGanZhi)) {
            this.yearGanZhiShenSha.add("冲天煞");
            this.monthGanZhiShenSha.add("冲天煞");
        }

        // 判断日干支与时干支是否相同
        if (this.dayGanZhi.equals(this.hourGanZhi)) {
            this.dayGanZhiShenSha.add("冲天煞");
            this.hourGanZhiShenSha.add("冲天煞");
        }

    }

    /**
     * 计算四废日
     */
    private void siFeiRi() {

        Map<String, String> map = BaZiShenShaMap.SI_FEI_RI; // 四废日（月支+日干支为键）

        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayGanZhi));

    }

    /**
     * 计算阴注阳受
     */
    private void yinZhuYangShou() {

        Map<String, String> map = BaZiShenShaMap.YIN_ZHU_YANG_SHOU; // 阴注阳受（月支+其余地支为键）

        this.yearGanZhiShenSha.add(map.get(this.monthZhi + this.yearZhi));
//        this.monthGanZhiShenSha.add(map.get(this.monthZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.monthZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.monthZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.monthZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.monthZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.monthZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.monthZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.monthZhi + this.liuShiZhi));

    }

    /**
     * 计算天罗地网
     */
    private void tianLuoDiWang() {

        Map<String, String> map = BaZiShenShaMap.TIAN_LUO_DI_WANG; // 天罗地网（年支\日支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearZhi + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayZhi + this.monthZhi));
//        this.dayGanZhiShenSha.add(map.get(this.dayZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayZhi + this.liuShiZhi));

    }

    /**
     * 计算空亡
     */
    private void kongWang() {

        Map<String, String> map = BaZiShenShaMap.KONG_WANG; // 空亡（年干支\日干支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearGanZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGanZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGanZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGanZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGanZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGanZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGanZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGanZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGanZhi + this.liuShiZhi));

        this.yearGanZhiShenSha.add(map.get(this.dayGanZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.dayGanZhi + this.monthZhi));
//        this.dayGanZhiShenSha.add(map.get(this.dayGanZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.dayGanZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.dayGanZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.dayGanZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.dayGanZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.dayGanZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.dayGanZhi + this.liuShiZhi));

    }

    /**
     * 计算截空
     */
    private void jieKong() {

        Map<String, String> map = BaZiShenShaMap.JIE_KONG; // 截空（日干+时支为键）

        this.hourGanZhiShenSha.add(map.get(this.dayGan + this.hourZhi));

    }

    /**
     * 计算六厄
     */
    private void liuE() {

        Map<String, String> map = BaZiShenShaMap.LIU_E; // 六厄（年支+其余地支为键）

//        this.yearGanZhiShenSha.add(map.get(this.yearGanZhi + this.yearZhi));
        this.monthGanZhiShenSha.add(map.get(this.yearGanZhi + this.monthZhi));
        this.dayGanZhiShenSha.add(map.get(this.yearGanZhi + this.dayZhi));
        this.hourGanZhiShenSha.add(map.get(this.yearGanZhi + this.hourZhi));
        this.daYunGanZhiShenSha.add(map.get(this.yearGanZhi + this.daYunZhi));
        this.liuNianGanZhiShenSha.add(map.get(this.yearGanZhi + this.liuNianZhi));
        this.liuYueGanZhiShenSha.add(map.get(this.yearGanZhi + this.liuYueZhi));
        this.liuRiGanZhiShenSha.add(map.get(this.yearGanZhi + this.liuRiZhi));
        this.liuShiGanZhiShenSha.add(map.get(this.yearGanZhi + this.liuShiZhi));

    }

    /**
     * 计算三奇贵人
     */
    private void sanQiGuiRen() {

        Map<String, String> map = BaZiShenShaMap.SAN_QI_GUI_REN; // 三奇贵人（年干+月干+日干\月干+日干+时干为键）

        String yearMonthDayGan = map.get(this.yearGan + this.monthGan + this.dayGan); // 年干+月干+日干
        String monthDayHourGan = map.get(this.monthGan + this.dayGan + this.hourGan); // 月干+日干+时干
        if (null != yearMonthDayGan) this.dayGanZhiShenSha.add("三奇贵人");
        if (null != monthDayHourGan) this.dayGanZhiShenSha.add("三奇贵人");

    }

    /**
     * 计算十恶大败
     */
    private void shiEDaBai() {

        String[] strings = BaZiShenShaMap.SHI_E_DA_BAI; // 十恶大败（日干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("十恶大败");
        }

    }

    /**
     * 计算阴差阳错
     */
    private void yinChaYangCuo() {

        String[] strings = BaZiShenShaMap.YIN_CHA_YANG_CUO; // 阴差阳错（日干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("阴差阳错");
        }

    }

    /**
     * 计算孤鸾煞
     */
    private void guLuanSha() {

        String[] strings = BaZiShenShaMap.GU_LUAN_SHA; // 孤鸾煞（日干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("孤鸾煞");
        }

    }

    /**
     * 计算六秀日
     */
    private void liuXiuRi() {

        String[] strings = BaZiShenShaMap.LIU_XIU_RI; // 六秀日（日干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("六秀日");
        }

    }

    /**
     * 计算十灵日
     */
    private void shiLingRi() {

        String[] strings = BaZiShenShaMap.SHI_LING_RI; // 十灵日（日干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("十灵日");
        }

    }

    /**
     * 计算魁罡日
     */
    private void kuiGangRi() {

        String[] strings = BaZiShenShaMap.KUI_GANG_RI; // 魁罡日（日干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("魁罡日");
        }

    }

    /**
     * 计算八专日
     */
    private void baZhuanRi() {

        String[] strings = BaZiShenShaMap.BA_ZHUAN_RI; // 八专日（日干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("八专日");
        }

    }

    /**
     * 计算九丑日
     */
    private void jiuChouRi() {

        String[] strings = BaZiShenShaMap.JIU_CHOU_RI; // 九丑日（日干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("九丑日");
        }

    }

    /**
     * 计算金神
     */
    private void jinShen() {

        String[] strings = BaZiShenShaMap.JIN_SHEN; // 金神（日干支\时干支）

        for (String value : strings) {
            if (this.dayGanZhi.equals(value)) this.dayGanZhiShenSha.add("金神");
        }
        for (String value : strings) {
            if (this.hourGanZhi.equals(value)) this.hourGanZhiShenSha.add("金神");
        }

    }

//-------------------------------------------------------------------------------------------------------------------------------

    /**
     * 初始化神煞
     */
    protected void initializeShenSha() {

        // 1、计算数据
        taiJiGuiRen(); // 太极贵人
        tianYiGuiRen(); // 天乙贵人
        fuXingGuiRen(); // 福星贵人
        wenChangGuiRen(); // 文昌贵人
        tianChuGuiRen(); // 天厨贵人
        yueDeGuiRen(); // 月德贵人
        deXiuGuiRen(); // 德秀贵人
        tianDeGuiRen(); // 天德贵人
        tianGuanGuiRen(); // 天官贵人
        sanQiGuiRen(); // 三奇贵人
        yinZhuYangShou(); // 阴注阳受
        shiEDaBai(); // 十恶大败
        yinChaYangCuo(); // 阴差阳错
        tianLuoDiWang(); // 天罗地网
        tianDeHe(); // 天德合
        yueDeHe(); // 月德合
        liuXiuRi(); // 六秀日
        shiLingRi(); // 十灵日
        kuiGangRi(); // 魁罡日
        baZhuanRi(); // 八专日
        jiuChouRi(); // 九丑日
        siFeiRi(); // 四废日
        guLuanSha(); // 孤鸾煞
        hongYanSha(); // 红艳煞
        gouJiaoSha(); // 勾绞煞
        tongZiSha(); // 童子煞
        chongTianSha(); // 冲天煞
        ciGuan(); // 词馆
        xueTang(); // 学堂
        huaGai(); // 华盖
        guoYin(); // 国印
        jinShen(); // 金神
        jinYu(); // 金舆
        gongLu(); // 拱禄
        luShen(); // 禄神
        jiangXing(); // 将星
        taoHua(); // 桃花
        tianXi(); // 天喜
        hongLuan(); // 红鸾
        tianYi(); // 天医
        tianShe(); // 天赦
        yiMa(); // 驿马
        kongWang(); // 空亡
        jieKong(); // 截空
        yangRen(); // 羊刃
        feiRen(); // 飞刃
        liuXia(); // 流霞
        jieSha(); // 劫煞
        wangShen(); // 亡神
        diaoKe(); // 吊客
        piMa(); // 披麻
        sangMen(); // 丧门
        zaiSha(); // 灾煞
        guChen(); // 孤辰
        guaXiu(); // 寡宿
        yuanChen(); // 元辰
        xueRen(); // 血刃
        tianZhuan(); // 天转
        diZhuan(); // 地转
        liuE(); // 六厄

        // 2、删除重复数据
        this.yearGanZhiShenSha = CommonUtil.removeDuplicates(this.yearGanZhiShenSha); // 年干支神煞
        this.monthGanZhiShenSha = CommonUtil.removeDuplicates(this.monthGanZhiShenSha); // 月干支神煞
        this.dayGanZhiShenSha = CommonUtil.removeDuplicates(this.dayGanZhiShenSha); // 日干支神煞
        this.hourGanZhiShenSha = CommonUtil.removeDuplicates(this.hourGanZhiShenSha); // 时干支神煞
        this.daYunGanZhiShenSha = CommonUtil.removeDuplicates(this.daYunGanZhiShenSha); // 大运干支神煞
        this.liuNianGanZhiShenSha = CommonUtil.removeDuplicates(this.liuNianGanZhiShenSha); // 流年干支神煞
        this.liuYueGanZhiShenSha = CommonUtil.removeDuplicates(this.liuYueGanZhiShenSha); // 流月干支神煞
        this.liuRiGanZhiShenSha = CommonUtil.removeDuplicates(this.liuRiGanZhiShenSha); // 流日干支神煞
        this.liuShiGanZhiShenSha = CommonUtil.removeDuplicates(this.liuShiGanZhiShenSha); // 流时干支神煞

    }


}
