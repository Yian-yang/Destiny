package xuan.utils;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import xuan.utils.DateUtil;
import xuan.utils.bazi.BaZi;
import xuan.utils.bazi.settings.BaZiJiChuSetting;
import xuan.utils.bazi.utils.BaZiDaYunLiuNianUtil;

/**
 * 八字排盘测试
 *
 * @author 善待
 */
public class BaZiTest {

    /**
     * 八字排盘
     */
    @Test
    public void baZiTest() {

        // 1、基础设置（可选）
        BaZiJiChuSetting baZiJiChuSetting = new BaZiJiChuSetting();
        baZiJiChuSetting.setName("某人"); // 姓名
        baZiJiChuSetting.setOccupy("某事"); // 占事
        baZiJiChuSetting.setSex(1); // 性别（0:女。1:男）
        baZiJiChuSetting.setDate(new Date(2024 - 1900, 1 - 1, 1, 0, 0, 0)); // 日期
        baZiJiChuSetting.setDateType(0); // 日期类型（0:公历。1:农历）
        baZiJiChuSetting.setLeapMonthType(0); // 闰月类型（0:不使用闰月。1:使用闰月）
        baZiJiChuSetting.setJieQiType(1); //  节气类型（0:按天计算。1:按分钟计算）
        baZiJiChuSetting.setQiYunLiuPaiType(0); // 起运流派类型（0:按天数和时辰数计算：3天1年、1天4个月、1时辰10天。1:按分钟数计算：4320分=1年、360分=1月、12分=1天、1分=2小时）
        baZiJiChuSetting.setRenYuanType(0); // 人元司令分野类型（0:子平真诠法诀。1:渊海子平法诀。2:星平会海法诀。3:三命通会法诀。4:神峰通考法诀。5:万育吾之法诀）
        baZiJiChuSetting.setDaYunLunShu(10); // 大运轮数（最小10轮，最大16轮）
        baZiJiChuSetting.setYearGanZhiType(2); // 年干支类型（0:以正月初一作为新年的开始。1:以立春当天作为新年的开始。2:以立春交接的时刻作为新年的开始）
        baZiJiChuSetting.setMonthGanZhiType(1); // 月干支类型（0:以节交接当天起算。1:以节交接时刻起算）
        baZiJiChuSetting.setDayGanZhiType(0); // 日干支类型（0:晚子时日干支算当天。1:晚子时日干支算明天）
        baZiJiChuSetting.setHourGanZhiType(0); // 时干支类型（0:支持早子时和晚子时）


        // 2、初始化
//        BaZi baZi = new BaZi(new BaZiJiChuSetting()); // 使用默认基础设置初始化
        BaZi baZi = new BaZi(baZiJiChuSetting); // 使用基础设置初始化


        // 3、数据
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ ☯ 八字 ☯ ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n");

        System.out.println("公历日期（Solar型）：" + baZi.getSolar());
        System.out.println("农历日期（Lunar型）：" + baZi.getLunar());
        System.out.println("公历日期（String型）：" + baZi.getSolarStr());
        System.out.println("农历日期（String型）：" + baZi.getLunarStr());
        System.out.println("公历日期（Date型）：" + baZi.getSolarDate());
        System.out.println("农历日期（Date型）：" + baZi.getLunarDate());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年龄：" + baZi.getAge(false) + "岁");
        System.out.println("姓名：" + baZi.getName());
        System.out.println("性别：" + baZi.getSex());
        System.out.println("占事：" + baZi.getOccupy());
        System.out.println("造：" + baZi.getZao());
        System.out.println("太岁类型：" + baZi.getTaiSuiType());
        System.out.println("星期：" + baZi.getXingQi());
        System.out.println("季节：" + baZi.getJiJie());
        System.out.println("生肖：" + baZi.getShengXiao());
        System.out.println("年冲生肖：" + baZi.getYearChongShengXiao());
        System.out.println("月冲生肖：" + baZi.getMonthChongShengXiao());
        System.out.println("日冲生肖：" + baZi.getDayChongShengXiao());
        System.out.println("时冲生肖：" + baZi.getHourChongShengXiao());
        System.out.println("星座：" + baZi.getXingZuo());
        System.out.println("五不遇时：" + baZi.getWuBuYuShi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("值年九星五行：" + baZi.getYearJiuXingWuXing());
        System.out.println("值月九星五行：" + baZi.getMonthJiuXingWuXing());
        System.out.println("值日九星五行：" + baZi.getDayJiuXingWuXing());
        System.out.println("值时九星五行：" + baZi.getHourJiuXingWuXing());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("值年九星方位：" + baZi.getYearJiuXingFangWei());
        System.out.println("值月九星方位：" + baZi.getMonthJiuXingFangWei());
        System.out.println("值日九星方位：" + baZi.getDayJiuXingFangWei());
        System.out.println("值时九星方位：" + baZi.getHourJiuXingFangWei());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("值年九星方位描述：" + baZi.getYearJiuXingFangWeiMiaoShu());
        System.out.println("值月九星方位描述：" + baZi.getMonthJiuXingFangWeiMiaoShu());
        System.out.println("值日九星方位描述：" + baZi.getDayJiuXingFangWeiMiaoShu());
        System.out.println("值时九星方位描述：" + baZi.getHourJiuXingFangWeiMiaoShu());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("值年九星之玄空九星：" + baZi.getYearJiuXingXuanKong());
        System.out.println("值月九星之玄空九星：" + baZi.getMonthJiuXingXuanKong());
        System.out.println("值日九星之玄空九星：" + baZi.getDayJiuXingXuanKong());
        System.out.println("值时九星之玄空九星：" + baZi.getHourJiuXingXuanKong());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("值年九星之北斗九星：" + baZi.getYearJiuXingBeiDou());
        System.out.println("值月九星之北斗九星：" + baZi.getMonthJiuXingBeiDou());
        System.out.println("值日九星之北斗九星：" + baZi.getDayJiuXingBeiDou());
        System.out.println("值时九星之北斗九星：" + baZi.getHourJiuXingBeiDou());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("值年九星之奇门九星：" + baZi.getYearJiuXingQiMen());
        System.out.println("值月九星之奇门九星：" + baZi.getMonthJiuXingQiMen());
        System.out.println("值日九星之奇门九星：" + baZi.getDayJiuXingQiMen());
        System.out.println("值时九星之奇门九星：" + baZi.getHourJiuXingQiMen());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("值年九星之太乙九星：" + baZi.getYearJiuXingTaiYi());
        System.out.println("值月九星之太乙九星：" + baZi.getMonthJiuXingTaiYi());
        System.out.println("值日九星之太乙九星：" + baZi.getDayJiuXingTaiYi());
        System.out.println("值时九星之太乙九星：" + baZi.getHourJiuXingTaiYi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("八字：" + baZi.getBaZi());
        System.out.println("八字五行：" + baZi.getBaZiWuXing());
        System.out.println("八字纳音：" + baZi.getBaZiNaYin());
        System.out.println("八字空亡：" + baZi.getBaZiKongWang());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干：" + baZi.getYearGan());
        System.out.println("月干：" + baZi.getMonthGan());
        System.out.println("日干：" + baZi.getDayGan());
        System.out.println("时干：" + baZi.getHourGan());
        System.out.println("胎元干：" + baZi.getTaiYuanGan());
        System.out.println("胎息干：" + baZi.getTaiXiGan());
        System.out.println("命宫干：" + baZi.getMingGongGan());
        System.out.println("身宫干：" + baZi.getShenGongGan());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年支：" + baZi.getYearZhi());
        System.out.println("月支：" + baZi.getMonthZhi());
        System.out.println("日支：" + baZi.getDayZhi());
        System.out.println("时支：" + baZi.getHourZhi());
        System.out.println("胎元支：" + baZi.getTaiYuanZhi());
        System.out.println("胎息支：" + baZi.getTaiXiZhi());
        System.out.println("命宫支：" + baZi.getMingGongZhi());
        System.out.println("身宫支：" + baZi.getShenGongZhi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支：" + baZi.getYearGanZhi());
        System.out.println("月干支：" + baZi.getMonthGanZhi());
        System.out.println("日干支：" + baZi.getDayGanZhi());
        System.out.println("时干支：" + baZi.getHourGanZhi());
        System.out.println("胎元干支：" + baZi.getTaiYuanGanZhi());
        System.out.println("胎息干支：" + baZi.getTaiXiGanZhi());
        System.out.println("命宫干支：" + baZi.getMingGongGanZhi());
        System.out.println("身宫干支：" + baZi.getShenGongGanZhi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干五行：" + baZi.getYearGanWuXing());
        System.out.println("月干五行：" + baZi.getMonthGanWuXing());
        System.out.println("日干五行：" + baZi.getDayGanWuXing());
        System.out.println("时干五行：" + baZi.getHourGanWuXing());
        System.out.println("胎元干五行：" + baZi.getTaiYuanGanWuXing());
        System.out.println("胎息干五行：" + baZi.getTaiXiGanWuXing());
        System.out.println("命宫干五行：" + baZi.getMingGongGanWuXing());
        System.out.println("身宫干五行：" + baZi.getShenGongGanWuXing());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年支五行：" + baZi.getYearZhiWuXing());
        System.out.println("月支五行：" + baZi.getMonthZhiWuXing());
        System.out.println("日支五行：" + baZi.getDayZhiWuXing());
        System.out.println("时支五行：" + baZi.getHourZhiWuXing());
        System.out.println("胎元支五行：" + baZi.getTaiYuanZhiWuXing());
        System.out.println("胎息支五行：" + baZi.getTaiXiZhiWuXing());
        System.out.println("命宫支五行：" + baZi.getMingGongZhiWuXing());
        System.out.println("身宫支五行：" + baZi.getShenGongZhiWuXing());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支五行：" + baZi.getYearGanZhiWuXing());
        System.out.println("月干支五行：" + baZi.getMonthGanZhiWuXing());
        System.out.println("日干支五行：" + baZi.getDayGanZhiWuXing());
        System.out.println("时干支五行：" + baZi.getHourGanZhiWuXing());
        System.out.println("胎元干支五行：" + baZi.getTaiYuanGanZhiWuXing());
        System.out.println("胎息干支五行：" + baZi.getTaiXiGanZhiWuXing());
        System.out.println("命宫干支五行：" + baZi.getMingGongGanZhiWuXing());
        System.out.println("身宫干支五行：" + baZi.getShenGongGanZhiWuXing());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支纳音：" + baZi.getYearGanZhiNaYin());
        System.out.println("月干支纳音：" + baZi.getMonthGanZhiNaYin());
        System.out.println("日干支纳音：" + baZi.getDayGanZhiNaYin());
        System.out.println("时干支纳音：" + baZi.getHourGanZhiNaYin());
        System.out.println("胎元干支纳音：" + baZi.getTaiYuanGanZhiNaYin());
        System.out.println("胎息干支纳音：" + baZi.getTaiXiGanZhiNaYin());
        System.out.println("命宫干支纳音：" + baZi.getMingGongGanZhiNaYin());
        System.out.println("身宫干支纳音：" + baZi.getShenGongGanZhiNaYin());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支空亡：" + baZi.getYearGanZhiKongWang());
        System.out.println("月干支空亡：" + baZi.getMonthGanZhiKongWang());
        System.out.println("日干支空亡：" + baZi.getDayGanZhiKongWang());
        System.out.println("时干支空亡：" + baZi.getHourGanZhiKongWang());
        System.out.println("胎元干支空亡：" + baZi.getTaiYuanGanZhiKongWang());
        System.out.println("胎息干支空亡：" + baZi.getTaiXiGanZhiKongWang());
        System.out.println("命宫干支空亡：" + baZi.getMingGongGanZhiKongWang());
        System.out.println("身宫干支空亡：" + baZi.getShenGongGanZhiKongWang());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支主星：" + baZi.getYearGanZhiZhuXing());
        System.out.println("月干支主星：" + baZi.getMonthGanZhiZhuXing());
        System.out.println("日干支主星：" + baZi.getDayGanZhiZhuXing());
        System.out.println("时干支主星：" + baZi.getHourGanZhiZhuXing());
        System.out.println("胎元干支主星：" + baZi.getTaiYuanGanZhiZhuXing());
        System.out.println("胎息干支主星：" + baZi.getTaiXiGanZhiZhuXing());
        System.out.println("命宫干支主星：" + baZi.getMingGongGanZhiZhuXing());
        System.out.println("身宫干支主星：" + baZi.getShenGongGanZhiZhuXing());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年支藏干：" + baZi.getYearZhiCangGan());
        System.out.println("月支藏干：" + baZi.getMonthZhiCangGan());
        System.out.println("日支藏干：" + baZi.getDayZhiCangGan());
        System.out.println("时支藏干：" + baZi.getHourZhiCangGan());
        System.out.println("胎元支藏干：" + baZi.getTaiYuanZhiCangGan());
        System.out.println("胎息支藏干：" + baZi.getTaiXiZhiCangGan());
        System.out.println("命宫支藏干：" + baZi.getMingGongZhiCangGan());
        System.out.println("身宫支藏干：" + baZi.getShenGongZhiCangGan());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年支藏干五行：" + baZi.getYearZhiCangGanWuXing());
        System.out.println("月支藏干五行：" + baZi.getMonthZhiCangGanWuXing());
        System.out.println("日支藏干五行：" + baZi.getDayZhiCangGanWuXing());
        System.out.println("时支藏干五行：" + baZi.getHourZhiCangGanWuXing());
        System.out.println("胎元支藏干五行：" + baZi.getTaiYuanZhiCangGanWuXing());
        System.out.println("胎息支藏干五行：" + baZi.getTaiXiZhiCangGanWuXing());
        System.out.println("命宫支藏干五行：" + baZi.getMingGongZhiCangGanWuXing());
        System.out.println("身宫支藏干五行：" + baZi.getShenGongZhiCangGanWuXing());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支副星：" + baZi.getYearGanZhiFuXing());
        System.out.println("月干支副星：" + baZi.getMonthGanZhiFuXing());
        System.out.println("日干支副星：" + baZi.getDayGanZhiFuXing());
        System.out.println("时干支副星：" + baZi.getHourGanZhiFuXing());
        System.out.println("胎元干支副星：" + baZi.getTaiYuanGanZhiFuXing());
        System.out.println("胎息干支副星：" + baZi.getTaiXiGanZhiFuXing());
        System.out.println("命宫干支副星：" + baZi.getMingGongGanZhiFuXing());
        System.out.println("身宫干支副星：" + baZi.getShenGongGanZhiFuXing());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支自坐：" + baZi.getYearGanZhiZiZuo());
        System.out.println("月干支自坐：" + baZi.getMonthGanZhiZiZuo());
        System.out.println("日干支自坐：" + baZi.getDayGanZhiZiZuo());
        System.out.println("时干支自坐：" + baZi.getHourGanZhiZiZuo());
        System.out.println("胎元干支自坐：" + baZi.getTaiYuanGanZhiZiZuo());
        System.out.println("胎息干支自坐：" + baZi.getTaiXiGanZhiZiZuo());
        System.out.println("命宫干支自坐：" + baZi.getMingGongGanZhiZiZuo());
        System.out.println("身宫干支自坐：" + baZi.getShenGongGanZhiZiZuo());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支星运：" + baZi.getYearGanZhiXingYun());
        System.out.println("月干支星运：" + baZi.getMonthGanZhiXingYun());
        System.out.println("日干支星运：" + baZi.getDayGanZhiXingYun());
        System.out.println("时干支星运：" + baZi.getHourGanZhiXingYun());
        System.out.println("胎元干支星运：" + baZi.getTaiYuanGanZhiXingYun());
        System.out.println("胎息干支星运：" + baZi.getTaiXiGanZhiXingYun());
        System.out.println("命宫干支星运：" + baZi.getMingGongGanZhiXingYun());
        System.out.println("身宫干支星运：" + baZi.getShenGongGanZhiXingYun());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("年干支神煞：" + baZi.getYearGanZhiShenSha());
        System.out.println("月干支神煞：" + baZi.getMonthGanZhiShenSha());
        System.out.println("日干支神煞：" + baZi.getDayGanZhiShenSha());
        System.out.println("时干支神煞：" + baZi.getHourGanZhiShenSha());
        System.out.println("胎元干支神煞：" + baZi.getTaiYuanGanZhiShenSha());
        System.out.println("胎息干支神煞：" + baZi.getTaiXiGanZhiShenSha());
        System.out.println("命宫干支神煞：" + baZi.getMingGongGanZhiShenSha());
        System.out.println("身宫干支神煞：" + baZi.getShenGongGanZhiShenSha());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("五行木数量：" + baZi.getWuXingMuCount(false));
        System.out.println("五行火数量：" + baZi.getWuXingHuoCount(false));
        System.out.println("五行土数量：" + baZi.getWuXingTuCount(false));
        System.out.println("五行金数量：" + baZi.getWuXingJinCount(false));
        System.out.println("五行水数量：" + baZi.getWuXingShuiCount(false));

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("五行旺衰：" + baZi.getWuXingWangShuai());
        System.out.println("五行缺失：" + baZi.getWuXingQueShi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("天干留意：" + baZi.getTianGanLiuYi());
        System.out.println("地支留意：" + baZi.getDiZhiLiuYi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("上一节：" + baZi.getPrevJie());
        System.out.println("上一节日期：" + baZi.getPrevJieDateStr());
        System.out.println("距上一节天数：" + baZi.getPrevJieDay());
        System.out.println();
        System.out.println("下一节：" + baZi.getNextJie());
        System.out.println("下一节日期：" + baZi.getNextJieDateStr());
        System.out.println("距下一节天数：" + baZi.getNextJieDay());
        System.out.println();
        System.out.println("出生节：" + baZi.getChuShengJie());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("上一气：" + baZi.getPrevQi());
        System.out.println("上一气日期：" + baZi.getPrevQiDateStr());
        System.out.println("距上一气天数：" + baZi.getPrevQiDay());
        System.out.println();
        System.out.println("下一气：" + baZi.getNextQi());
        System.out.println("下一气日期：" + baZi.getNextQiDateStr());
        System.out.println("距下一气天数：" + baZi.getNextQiDay());
        System.out.println();
        System.out.println("出生气：" + baZi.getChuShengQi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("月相：" + baZi.getYueXiang());
        System.out.println("月将：" + baZi.getYueJiang());
        System.out.println("月将神：" + baZi.getYueJiangShen());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("人元司令分野：" + baZi.getRenYuanSiLingFenYe());
        System.out.println("身体强弱：" + baZi.getShenTiQiangRuo());
        System.out.println("喜用神：" + baZi.getXiYongShen());
        System.out.println("喜用神方位：" + baZi.getXiYongShenFangWei());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("骨重：" + baZi.getGuZhong().get(0));
        System.out.println("骨重批注：" + baZi.getGuZhong().get(1));

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("公历起运日期：" + baZi.getSolarQiYunDateStr());
        System.out.println("公历起运信息：" + baZi.getSolarQiYun());
        System.out.println("公历交运信息：" + baZi.getSolarJiaoYun());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("正财运：" + baZi.getZhengCaiYun());
        System.out.println();
        System.out.println("正财运：" + baZi.getPianCaiYun());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("正桃花运：" + baZi.getZhengTaoHuaYun());
        System.out.println();
        System.out.println("偏桃花运：" + baZi.getPianTaoHuaYun());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("星宿：" + baZi.getXingXiu());
        System.out.println("星宿吉凶：" + baZi.getXingXiuJiXiong());
        System.out.println("星宿吉凶歌诀：" + baZi.getXingXiuJiXiongGeJue());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("命卦：" + baZi.getMingGua());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("日柱论命：" + baZi.getRiZhuLunMing());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("五行分析：" + baZi.getWuXingFenXi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("运势分析：" + baZi.getYunShiFenXi());

        System.out.println("\n--------------------------------------------------------------------------------------------------------------\n");

        System.out.println("性格分析：" + baZi.getXingGeFenXi());

    }

    /**
     * 大运流年
     */
    @Test
    public void daYunTest() {

        // 1、初始化大运流年
        Date solarDate = new Date(2024 - 1900, 1 - 1, 1, 0, 0, 0); // 公历日期
        BaZiDaYunLiuNianUtil baZiDaYunLiuNianUtil = new BaZiDaYunLiuNianUtil(solarDate, 1, 1, 2, 1, 0);


        // 2.1、获取大运（干支、天干十神、地支十神、自坐、星运、公历日期、公历年、年龄、藏干、副星、空亡、纳音）
        List<List<String>> daYun = baZiDaYunLiuNianUtil.getDaYun(13); // 获取大运

        // 2.2、获取流年（干支、天干十神、地支十神、自坐、星运、公历日期、公历年、年龄、藏干、副星、空亡、纳音）
        List<List<String>> liuNian = baZiDaYunLiuNianUtil.getLiuNian(13, 1); // 获取流年

        // 2.3、获取小运（干支、天干十神、地支十神、自坐、星运、公历日期、公历年、年龄、藏干、副星、空亡、纳音）
        List<List<String>> xiaoYun = baZiDaYunLiuNianUtil.getXiaoYun(13, 1); // 获取小运

        // 2.4、获取流月（干支、天干十神、地支十神、自坐、星运、公历日期、公历几月几日、十二节、藏干、副星、空亡、纳音）
        List<List<String>> liuYue = baZiDaYunLiuNianUtil.getLiuYue(13, 1, 1, 2024); // 获取流月【注意：公历年需动态获取，此处仅用于演示】

        // 2.5、获取流日（干支、天干十神、地支十神、自坐、星运、公历日期、公历日、农历日、藏干、副星、空亡、纳音）
        List<List<String>> liuRi = baZiDaYunLiuNianUtil.getLiuRi(2024, 2); // 获取流日【注意：公历年、公历月需动态获取，此处仅用于演示】

        // 2.6、获取流时（干支、天干十神、地支十神、自坐、星运、公历日期、公历时、汉代命名、藏干、副星、空亡、纳音）
        List<List<String>> liuShi = baZiDaYunLiuNianUtil.getLiuShi(2024, 2, 4); // 获取流时【注意：公历年、公历月、公历日需动态获取，此处仅用于演示】


        // 3、数据
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ ☯ 大运流年 ☯ ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n");

        System.out.println("公历日期：" + DateUtil.getDateStr(solarDate, DateUtil.DATE_TIME_FORMAT));

        System.out.println("\n\n----------------------------------------------------- 大运 -----------------------------------------------------\n");
        for (List<String> value : daYun) {
            System.out.println(value);
        }

        System.out.println("\n\n----------------------------------------------------- 流年 -----------------------------------------------------\n");
        for (List<String> value : liuNian) {
            System.out.println(value);
        }

        System.out.println("\n\n----------------------------------------------------- 小运 -----------------------------------------------------\n");
        for (List<String> value : xiaoYun) {
            System.out.println(value);
        }

        System.out.println("\n\n----------------------------------------------------- 流月 -----------------------------------------------------\n");
        for (List<String> value : liuYue) {
            System.out.println(value);
        }

        System.out.println("\n\n----------------------------------------------------- 流日 -----------------------------------------------------\n");
        for (List<String> value : liuRi) {
            System.out.println(value);
        }

        System.out.println("\n\n----------------------------------------------------- 流时 -----------------------------------------------------\n");
        for (List<String> value : liuShi) {
            System.out.println(value);
        }

    }


}
