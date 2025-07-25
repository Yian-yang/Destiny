package xuan.utils.bazi;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

import xuan.utils.bazi.maps.BaZiGanZhiLiuYiMap;
import xuan.utils.bazi.maps.BaZiJiChuMap;
import xuan.utils.bazi.settings.BaZiJiChuSetting;
import xuan.utils.bazi.utils.BaZiGanZhiLiuYiUtil;
import xuan.utils.bazi.utils.BaZiJiChuUtil;
import xuan.utils.bazi.utils.BaZiShenShaUtil;
import xuan.utils.DateUtil;
import xuan.utils.CommonUtil;
import com.nlf.calendar.Solar;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.EightChar;
import com.nlf.calendar.eightchar.Yun;
import com.nlf.calendar.eightchar.DaYun;
import com.nlf.calendar.eightchar.LiuNian;

/**
 * 八字
 *
 * @author 善待
 */
public class BaZi {

    /**
     * 八字 - 基础设置
     */
    private BaZiJiChuSetting baZiJiChuSetting;

    /**
     * 公历日期
     */
    private Solar solar;
    /**
     * 农历日期
     */
    private Lunar lunar;

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
     * 胎元干
     */
    private String taiYuanGan;
    /**
     * 胎息干
     */
    private String taiXiGan;
    /**
     * 命宫干
     */
    private String mingGongGan;
    /**
     * 身宫干
     */
    private String shenGongGan;

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
     * 胎元支
     */
    private String taiYuanZhi;
    /**
     * 胎息支
     */
    private String taiXiZhi;
    /**
     * 命宫支
     */
    private String mingGongZhi;
    /**
     * 身宫支
     */
    private String shenGongZhi;

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
     * 正财运（年份、年龄、干支）
     */
    private List<List<String>> zhengCaiYun;
    /**
     * 偏财运（年份、年龄、干支）
     */
    private List<List<String>> pianCaiYun;

    /**
     * 正桃花运（年份、年龄、干支）
     */
    private List<List<String>> zhengTaoHuaYun;
    /**
     * 偏桃花运（年份、年龄、干支）
     */
    private List<List<String>> pianTaoHuaYun;


    /**
     * 八字
     */
    protected EightChar eightChar;
    /**
     * 运
     */
    protected Yun yun;
    /**
     * 小运持续的年数
     */
    protected int xiaoYunYearSum;

    /**
     * 流年
     */
    protected List<List<String>> liuNian;
    /**
     * 流年是否已初始化（true:已初始化。false:未初始化）
     */
    protected boolean liuNianStatus;

    /**
     * 八字神煞工具
     */
    protected BaZiShenShaUtil baZiShenShaUtil;
    /**
     * 八字神煞工具是否已初始化（true:已初始化。false:未初始化）
     */
    protected boolean baZiShenShaUtilStatus;

//*******************************************************************************************************************************

    /**
     * 使用基础设置初始化
     *
     * @param baZiJiChuSetting 八字 - 基础设置
     */
    public BaZi(BaZiJiChuSetting baZiJiChuSetting) {

        this.baZiJiChuSetting = baZiJiChuSetting; // 基础设置

        // 1、获取日期
        Map<String, Object> date = BaZiJiChuUtil.getDate(baZiJiChuSetting);
        this.solar = (Solar) date.get("solar"); // 公历日期
        this.lunar = (Lunar) date.get("lunar"); // 农历日期

        // 2.1、获取干支
        Map<String, List<String>> ganZhi = BaZiJiChuUtil.getGanZhi(baZiJiChuSetting, this.lunar);
        List<String> yearGanZhi = ganZhi.get("yearGanZhi");
        this.yearGan = yearGanZhi.get(0); // 年干
        this.yearZhi = yearGanZhi.get(1); // 年支
        this.yearGanZhi = yearGanZhi.get(2); // 年干支
        List<String> monthGanZhi = ganZhi.get("monthGanZhi");
        this.monthGan = monthGanZhi.get(0); // 月干
        this.monthZhi = monthGanZhi.get(1); // 月支
        this.monthGanZhi = monthGanZhi.get(2); // 月干支
        List<String> dayGanZhi = ganZhi.get("dayGanZhi");
        this.dayGan = dayGanZhi.get(0); // 日干
        this.dayZhi = dayGanZhi.get(1); // 日支
        this.dayGanZhi = dayGanZhi.get(2); // 日干支
        // 2.2、若使用未知时辰，则替换干支
        List<String> hourGanZhi = ganZhi.get("hourGanZhi");
        this.hourGan = hourGanZhi.get(0); // 时干
        this.hourZhi = hourGanZhi.get(1); // 时支
        this.hourGanZhi = hourGanZhi.get(2); // 时干支

        // 3、初始化外部类
        EightChar eightChar = this.lunar.getEightChar();
        eightChar.setSect(baZiJiChuSetting.getDayGanZhiType() + 1);
        this.eightChar = eightChar; // 八字
        this.yun = eightChar.getYun(baZiJiChuSetting.getSex(), baZiJiChuSetting.getQiYunLiuPaiType() + 1); // 运

        // 4、获取胎元、胎息、命宫、身宫
        this.taiYuanGanZhi = eightChar.getTaiYuan(); // 胎元干支
        this.taiYuanGan = eightChar.getTaiYuan().substring(0, 1); // 胎元干
        this.taiYuanZhi = eightChar.getTaiYuan().substring(1, 2); // 胎元支
        this.taiXiGanZhi = eightChar.getTaiXi(); // 胎息干支
        this.taiXiGan = eightChar.getTaiXi().substring(0, 1); // 胎息干
        this.taiXiZhi = eightChar.getTaiXi().substring(1, 2); // 胎息支
        this.mingGongGanZhi = eightChar.getMingGong(); // 命宫干支
        this.mingGongGan = eightChar.getMingGong().substring(0, 1); // 命宫干
        this.mingGongZhi = eightChar.getMingGong().substring(1, 2); // 命宫支
        this.shenGongGanZhi = eightChar.getShenGong(); // 身宫干支
        this.shenGongGan = eightChar.getShenGong().substring(0, 1); // 身宫干
        this.shenGongZhi = eightChar.getShenGong().substring(1, 2); // 身宫支

        // 5、初始化其他必要数据
        initializeLiuNian(); // 初始化流年
        initializeCaiHua(); // 初始化财运、桃花

    }

//===============================================================================================================================

    /**
     * 获取公历日期（Solar型）
     *
     * @return 公历日期（如：2024-01-01）
     */
    public Solar getSolar() {
        return this.solar;
    }

    /**
     * 获取农历日期（Lunar型）
     *
     * @return 农历日期（如：二〇二三年冬月二十）
     */
    public Lunar getLunar() {
        return this.lunar;
    }

    /**
     * 获取公历日期（String型）
     *
     * @return 公历日期（如：2024年01月01日00时00分00秒）
     */
    public String getSolarStr() {
        return DateUtil.getSolarStr(this.solar);
    }

    /**
     * 获取农历日期（String型）
     *
     * @return 农历日期（如：二〇二三年冬月二十(早)子时）
     */
    public String getLunarStr() {
        return DateUtil.getLunarStr(this.lunar);
    }

    /**
     * 获取公历日期（Date型）
     *
     * @return 公历日期（如：Mon Jan 01 00:00:00 CST 2024）
     */
    public Date getSolarDate() {
        return DateUtil.stringToDate(DateUtil.getSolarStr(this.solar));
    }

    /**
     * 获取农历日期（Date型）
     *
     * @return 农历日期（如：Mon Nov 20 00:00:00 CST 2023）
     */
    public Date getLunarDate() {
        return DateUtil.stringToDate(DateUtil.getLunarStr2(this.lunar));
    }


    /**
     * 获取年龄
     *
     * @param isXuSui 是否使用虚岁（true:是。false:否）
     */
    public int getAge(boolean isXuSui) {

        LocalDate nowDate = LocalDate.now(); // 当前日期
        LocalDate birthDate = getSolarDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // 出生日期

        // 1.1、计算实岁
        int age = Period.between(birthDate, nowDate).getYears();
        // 1.2、计算虚岁
        if (isXuSui) {
            age = age + (nowDate.getMonthValue() > birthDate.getMonthValue() || (nowDate.getMonthValue() == birthDate.getMonthValue() && nowDate.getDayOfMonth() >= birthDate.getDayOfMonth()) ? 1 : 0);
        }

        return age;

    }

    /**
     * 获取姓名
     *
     * @return 姓名（如：缘主）
     */
    public String getName() {
        return this.baZiJiChuSetting.getName();
    }

    /**
     * 获取性别
     *
     * @return 性别（如：男）
     */
    public String getSex() {
        return this.baZiJiChuSetting.getSex() == 0 ? "女" : "男";
    }

    /**
     * 获取占事
     *
     * @return 占事（如：未填写）
     */
    public String getOccupy() {
        return this.baZiJiChuSetting.getOccupy();
    }

    /**
     * 获取造
     *
     * @return 造（如：乾造）
     */
    public String getZao() {
        return this.baZiJiChuSetting.getSex() == 0 ? "坤造" : "乾造";
    }

    /**
     * 获取太岁类型
     *
     * @return 太岁类型，若无数据则返回null（如：值）
     */
    public String getTaiSuiType() {

        if (this.baZiJiChuSetting.getYearGanZhiType() == 0) {
            return BaZiJiChuMap.TAI_SUI_TYPE.get(new Lunar().getYearZhi() + this.yearZhi); // 以正月初一起算
        } else if (this.baZiJiChuSetting.getYearGanZhiType() == 1) {
            BaZiJiChuMap.TAI_SUI_TYPE.get(new Lunar().getYearZhiByLiChun() + this.yearZhi); // 以立春当天起算
        } else if (this.baZiJiChuSetting.getYearGanZhiType() == 2) {
            BaZiJiChuMap.TAI_SUI_TYPE.get(new Lunar().getYearZhiExact() + this.yearZhi); // 以立春交接时刻起算
        }

        return BaZiJiChuMap.TAI_SUI_TYPE.get(new Lunar().getYearZhi() + this.yearZhi);

    }

    /**
     * 获取星期
     *
     * @return 星期（如：周一）
     */
    public String getXingQi() {
        return "周" + this.lunar.getWeekInChinese();
    }

    /**
     * 获取季节
     *
     * @return 季节（如：孟春）
     */
    public String getJiJie() {
        return this.lunar.getSeason();
    }

    /**
     * 获取生肖
     *
     * @return 生肖（如：鼠）
     */
    public String getShengXiao() {

        if (this.baZiJiChuSetting.getYearGanZhiType() == 0) {
            return this.lunar.getYearShengXiao(); // 以正月初一起算
        } else if (this.baZiJiChuSetting.getYearGanZhiType() == 1) {
            return this.lunar.getYearShengXiaoByLiChun(); // 以立春当天起算
        } else if (this.baZiJiChuSetting.getYearGanZhiType() == 2) {
            return this.lunar.getYearShengXiaoExact(); // 以立春交接时刻起算
        }

        return this.lunar.getYearShengXiao();

    }

    /**
     * 获取年冲生肖
     *
     * @return 年冲生肖（如：鼠）
     */
    public String getYearChongShengXiao() {
        return BaZiJiChuMap.DI_ZHI_SHENG_XIAO.get(BaZiJiChuMap.DI_ZHI_CHONG.get(this.yearZhi));
    }

    /**
     * 获取月冲生肖
     *
     * @return 月冲生肖（如：鼠）
     */
    public String getMonthChongShengXiao() {
        return BaZiJiChuMap.DI_ZHI_SHENG_XIAO.get(BaZiJiChuMap.DI_ZHI_CHONG.get(this.monthZhi));
    }

    /**
     * 获取日冲生肖
     *
     * @return 日冲生肖（如：鼠）
     */
    public String getDayChongShengXiao() {
        return BaZiJiChuMap.DI_ZHI_SHENG_XIAO.get(BaZiJiChuMap.DI_ZHI_CHONG.get(this.dayZhi));
    }

    /**
     * 获取时冲生肖
     *
     * @return 时冲生肖（如：鼠）
     */
    public String getHourChongShengXiao() {
        return BaZiJiChuMap.DI_ZHI_SHENG_XIAO.get(BaZiJiChuMap.DI_ZHI_CHONG.get(this.hourZhi));
    }

    /**
     * 获取星座
     *
     * @return 星座（如：魔羯座）
     */
    public String getXingZuo() {
        return this.solar.getXingZuo() + "座";
    }

    /**
     * 获取五不遇时
     *
     * @return 五不遇时（true:符合。false:不符合）
     */
    public boolean getWuBuYuShi() {
        return this.hourGanZhi.equals(BaZiJiChuMap.WU_BU_YU_SHI.get(this.dayGan));
    }


    /**
     * 获取值年九星五行
     *
     * @return 值年九星五行（如：木）
     */
    public String getYearJiuXingWuXing() {
        return this.lunar.getYearNineStar(this.baZiJiChuSetting.getYearGanZhiType() + 1).getWuXing();
    }

    /**
     * 获取值月九星五行
     *
     * @return 值月九星五行（如：木）
     */
    public String getMonthJiuXingWuXing() {
        return this.lunar.getMonthNineStar(this.baZiJiChuSetting.getMonthGanZhiType() + 2).getWuXing();
    }

    /**
     * 获取值日九星五行
     *
     * @return 值日九星五行（如：木）
     */
    public String getDayJiuXingWuXing() {
        return this.lunar.getDayNineStar().getWuXing();
    }

    /**
     * 获取值时九星五行
     *
     * @return 值时九星五行（如：木）
     */
    public String getHourJiuXingWuXing() {
        return this.lunar.getTimeNineStar().getWuXing();
    }


    /**
     * 获取值年九星方位
     *
     * @return 值年九星方位（如：震）
     */
    public String getYearJiuXingFangWei() {
        return this.lunar.getYearNineStar(this.baZiJiChuSetting.getYearGanZhiType() + 1).getPosition();
    }

    /**
     * 获取值月九星方位
     *
     * @return 值月九星方位（如：震）
     */
    public String getMonthJiuXingFangWei() {
        return this.lunar.getMonthNineStar(this.baZiJiChuSetting.getMonthGanZhiType() + 2).getPosition();
    }

    /**
     * 获取值日九星方位
     *
     * @return 值日九星方位（如：震）
     */
    public String getDayJiuXingFangWei() {
        return this.lunar.getDayNineStar().getPosition();
    }

    /**
     * 获取值时九星方位
     *
     * @return 值时九星方位（如：震）
     */
    public String getHourJiuXingFangWei() {
        return this.lunar.getTimeNineStar().getPosition();
    }


    /**
     * 获取值年九星方位描述
     *
     * @return 值年九星方位描述（如：正东）
     */
    public String getYearJiuXingFangWeiMiaoShu() {
        return this.lunar.getYearNineStar(this.baZiJiChuSetting.getYearGanZhiType() + 1).getPositionDesc();
    }

    /**
     * 获取值月九星方位描述
     *
     * @return 值月九星方位描述（如：正东）
     */
    public String getMonthJiuXingFangWeiMiaoShu() {
        return this.lunar.getMonthNineStar(this.baZiJiChuSetting.getMonthGanZhiType() + 2).getPositionDesc();
    }

    /**
     * 获取值日九星方位描述
     *
     * @return 值日九星方位描述（如：正东）
     */
    public String getDayJiuXingFangWeiMiaoShu() {
        return this.lunar.getDayNineStar().getPositionDesc();
    }

    /**
     * 获取值时九星方位描述
     *
     * @return 值时九星方位描述（如：正东）
     */
    public String getHourJiuXingFangWeiMiaoShu() {
        return this.lunar.getTimeNineStar().getPositionDesc();
    }


    /**
     * 获取值年九星之玄空九星
     *
     * @return 值年九星之玄空九星（如：文曲）
     */
    public String getYearJiuXingXuanKong() {
        return this.lunar.getYearNineStar(this.baZiJiChuSetting.getYearGanZhiType() + 1).getNameInXuanKong();
    }

    /**
     * 获取值月九星之玄空九星
     *
     * @return 值月九星之玄空九星（如：文曲）
     */
    public String getMonthJiuXingXuanKong() {
        return this.lunar.getMonthNineStar(this.baZiJiChuSetting.getMonthGanZhiType() + 2).getNameInXuanKong();
    }

    /**
     * 获取值日九星之玄空九星
     *
     * @return 值日九星之玄空九星（如：文曲）
     */
    public String getDayJiuXingXuanKong() {
        return this.lunar.getDayNineStar().getNameInXuanKong();
    }

    /**
     * 获取值时九星之玄空九星
     *
     * @return 值时九星之玄空九星（如：文曲）
     */
    public String getHourJiuXingXuanKong() {
        return this.lunar.getTimeNineStar().getNameInXuanKong();
    }


    /**
     * 获取值年九星之北斗九星
     *
     * @return 值年九星之北斗九星（如：天权）
     */
    public String getYearJiuXingBeiDou() {
        return this.lunar.getYearNineStar(this.baZiJiChuSetting.getYearGanZhiType() + 1).getNameInBeiDou();
    }

    /**
     * 获取值月九星之北斗九星
     *
     * @return 值月九星之北斗九星（如：天权）
     */
    public String getMonthJiuXingBeiDou() {
        return this.lunar.getMonthNineStar(this.baZiJiChuSetting.getMonthGanZhiType() + 2).getNameInBeiDou();
    }

    /**
     * 获取值日九星之北斗九星
     *
     * @return 值日九星之北斗九星（如：天权）
     */
    public String getDayJiuXingBeiDou() {
        return this.lunar.getDayNineStar().getNameInBeiDou();
    }

    /**
     * 获取值时九星之北斗九星
     *
     * @return 值时九星之北斗九星（如：天权）
     */
    public String getHourJiuXingBeiDou() {
        return this.lunar.getTimeNineStar().getNameInBeiDou();
    }


    /**
     * 获取值年九星之奇门九星
     *
     * @return 值年九星之奇门九星（如：天心）
     */
    public String getYearJiuXingQiMen() {
        return this.lunar.getYearNineStar(this.baZiJiChuSetting.getYearGanZhiType() + 1).getNameInQiMen();
    }

    /**
     * 获取值月九星之奇门九星
     *
     * @return 值月九星之奇门九星（如：天心）
     */
    public String getMonthJiuXingQiMen() {
        return this.lunar.getMonthNineStar(this.baZiJiChuSetting.getMonthGanZhiType() + 2).getNameInQiMen();
    }

    /**
     * 获取值日九星之奇门九星
     *
     * @return 值日九星之奇门九星（如：天心）
     */
    public String getDayJiuXingQiMen() {
        return this.lunar.getDayNineStar().getNameInQiMen();
    }

    /**
     * 获取值时九星之奇门九星
     *
     * @return 值时九星之奇门九星（如：天心）
     */
    public String getHourJiuXingQiMen() {
        return this.lunar.getTimeNineStar().getNameInQiMen();
    }


    /**
     * 获取值年九星之太乙九星
     *
     * @return 值年九星之太乙九星（如：轩辕）
     */
    public String getYearJiuXingTaiYi() {
        return this.lunar.getYearNineStar(this.baZiJiChuSetting.getYearGanZhiType() + 1).getNameInTaiYi();
    }

    /**
     * 获取值月九星之太乙九星
     *
     * @return 值月九星之太乙九星（如：轩辕）
     */
    public String getMonthJiuXingTaiYi() {
        return this.lunar.getMonthNineStar(this.baZiJiChuSetting.getMonthGanZhiType() + 2).getNameInTaiYi();
    }

    /**
     * 获取值日九星之太乙九星
     *
     * @return 值日九星之太乙九星（如：轩辕）
     */
    public String getDayJiuXingTaiYi() {
        return this.lunar.getDayNineStar().getNameInTaiYi();
    }

    /**
     * 获取值时九星之太乙九星
     *
     * @return 值时九星之太乙九星（如：轩辕）
     */
    public String getHourJiuXingTaiYi() {
        return this.lunar.getTimeNineStar().getNameInTaiYi();
    }


    /**
     * 获取八字
     *
     * @return 八字（如：[癸卯, 甲子, 甲子, 甲子]）
     */
    public List<String> getBaZi() {
        return Arrays.asList(getYearGanZhi(), getMonthGanZhi(), getDayGanZhi(), getHourGanZhi());
    }

    /**
     * 获取八字五行
     *
     * @return 八字五行（如：[水木, 木水, 木水, 木水]）
     */
    public List<String> getBaZiWuXing() {
        return Arrays.asList(getYearGanZhiWuXing(), getMonthGanZhiWuXing(), getDayGanZhiWuXing(), getHourGanZhiWuXing());
    }

    /**
     * 获取八字纳音
     *
     * @return 八字纳音（如：[金箔金, 海中金, 海中金, 海中金]）
     */
    public List<String> getBaZiNaYin() {
        return Arrays.asList(getYearGanZhiNaYin(), getMonthGanZhiNaYin(), getDayGanZhiNaYin(), getHourGanZhiNaYin());
    }

    /**
     * 获取八字空亡
     *
     * @return 八字空亡（如：[辰巳, 戌亥, 戌亥, 戌亥]）
     */
    public List<String> getBaZiKongWang() {
        return Arrays.asList(getYearGanZhiKongWang(), getMonthGanZhiKongWang(), getDayGanZhiKongWang(), getHourGanZhiKongWang());
    }


    /**
     * 获取年干
     *
     * @return 年干（如：甲）
     */
    public String getYearGan() {
        return this.yearGan;
    }

    /**
     * 获取月干
     *
     * @return 月干（如：甲）
     */
    public String getMonthGan() {
        return this.monthGan;
    }

    /**
     * 获取日干
     *
     * @return 日干（如：甲）
     */
    public String getDayGan() {
        return this.dayGan;
    }

    /**
     * 获取日干
     *
     * @return 日干（如：甲）
     */
    public String getHourGan() {
        return this.hourGan;
    }

    /**
     * 获取胎元干
     *
     * @return 胎元干（如：辛）
     */
    public String getTaiYuanGan() {
        return this.taiYuanGan;
    }

    /**
     * 获取胎息干
     *
     * @return 胎息干（如：辛）
     */
    public String getTaiXiGan() {
        return this.taiXiGan;
    }

    /**
     * 获取命宫干
     *
     * @return 命宫干（如：辛）
     */
    public String getMingGongGan() {
        return this.mingGongGan;
    }

    /**
     * 获取身宫干
     *
     * @return 身宫干（如：辛）
     */
    public String getShenGongGan() {
        return this.shenGongGan;
    }


    /**
     * 获取年支
     *
     * @return 年支（如：子）
     */
    public String getYearZhi() {
        return this.yearZhi;
    }

    /**
     * 获取月支
     *
     * @return 月支（如：子）
     */
    public String getMonthZhi() {
        return this.monthZhi;
    }

    /**
     * 获取日支
     *
     * @return 日支（如：子）
     */
    public String getDayZhi() {
        return this.dayZhi;
    }

    /**
     * 获取时支
     *
     * @return 时支（如：子）
     */
    public String getHourZhi() {
        return this.hourZhi;
    }

    /**
     * 获取胎元支
     *
     * @return 胎元支（如：未）
     */
    public String getTaiYuanZhi() {
        return this.taiYuanZhi;
    }

    /**
     * 获取胎息支
     *
     * @return 胎息支（如：未）
     */
    public String getTaiXiZhi() {
        return this.taiXiZhi;
    }

    /**
     * 获取命宫支
     *
     * @return 命宫支（如：未）
     */
    public String getMingGongZhi() {
        return this.mingGongZhi;
    }

    /**
     * 获取身宫支
     *
     * @return 身宫支（如：未）
     */
    public String getShenGongZhi() {
        return this.shenGongZhi;
    }


    /**
     * 获取年干支
     *
     * @return 年干支（如：甲子）
     */
    public String getYearGanZhi() {
        return this.yearGanZhi;
    }

    /**
     * 获取月干支
     *
     * @return 月干支（如：甲子）
     */
    public String getMonthGanZhi() {
        return this.monthGanZhi;
    }

    /**
     * 获取日干支
     *
     * @return 日干支（如：甲子）
     */
    public String getDayGanZhi() {
        return this.dayGanZhi;
    }

    /**
     * 获取时干支
     *
     * @return 时干支（如：甲子）
     */
    public String getHourGanZhi() {
        return this.hourGanZhi;
    }

    /**
     * 获取胎元干支
     *
     * @return 胎元干支（如：辛未）
     */
    public String getTaiYuanGanZhi() {
        return this.taiYuanGanZhi;
    }

    /**
     * 获取胎息干支
     *
     * @return 胎息干支（如：辛未）
     */
    public String getTaiXiGanZhi() {
        return this.taiXiGanZhi;
    }

    /**
     * 获取命宫干支
     *
     * @return 命宫干支（如：辛未）
     */
    public String getMingGongGanZhi() {
        return this.mingGongGanZhi;
    }

    /**
     * 获取身宫干支
     *
     * @return 身宫干支（如：辛未）
     */
    public String getShenGongGanZhi() {
        return this.shenGongGanZhi;
    }


    /**
     * 获取年干五行
     *
     * @return 年干五行（如：木）
     */
    public String getYearGanWuXing() {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(this.yearGan);
    }

    /**
     * 获取月干五行
     *
     * @return 月干五行（如：木）
     */
    public String getMonthGanWuXing() {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(this.monthGan);
    }

    /**
     * 获取日干五行
     *
     * @return 日干五行（如：木）
     */
    public String getDayGanWuXing() {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(this.dayGan);
    }

    /**
     * 获取时干五行
     *
     * @return 时干五行（如：木）
     */
    public String getHourGanWuXing() {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(this.hourGan);
    }

    /**
     * 获取胎元干五行
     *
     * @return 胎元干五行（如：木）
     */
    public String getTaiYuanGanWuXing() {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(this.taiYuanGan);
    }

    /**
     * 获取胎息干五行
     *
     * @return 胎息干五行（如：木）
     */
    public String getTaiXiGanWuXing() {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(this.taiXiGan);
    }

    /**
     * 获取命宫干五行
     *
     * @return 命宫干五行（如：木）
     */
    public String getMingGongGanWuXing() {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(this.mingGongGan);
    }

    /**
     * 获取身宫干五行
     *
     * @return 身宫干五行（如：木）
     */
    public String getShenGongGanWuXing() {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(this.shenGongGan);
    }

    /**
     * 获取天干五行
     *
     * @param tianGan 天干
     * @return 天干五行（如：木）
     */
    public String getTianGanWuXing(String tianGan) {
        return BaZiJiChuMap.TIAN_GAN_WU_XING.get(tianGan);
    }


    /**
     * 获取年支五行
     *
     * @return 年支五行（如：木）
     */
    public String getYearZhiWuXing() {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(this.yearZhi);
    }

    /**
     * 获取月支五行
     *
     * @return 月支五行（如：木）
     */
    public String getMonthZhiWuXing() {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(this.monthZhi);
    }

    /**
     * 获取日支五行
     *
     * @return 日支五行（如：木）
     */
    public String getDayZhiWuXing() {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(this.dayZhi);
    }

    /**
     * 获取时支五行
     *
     * @return 时支五行（如：木）
     */
    public String getHourZhiWuXing() {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(this.hourZhi);
    }

    /**
     * 获取胎元支五行
     *
     * @return 胎元支五行（如：木）
     */
    public String getTaiYuanZhiWuXing() {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(this.taiYuanZhi);
    }

    /**
     * 获取胎息支五行
     *
     * @return 胎息支五行（如：木）
     */
    public String getTaiXiZhiWuXing() {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(this.taiXiZhi);
    }

    /**
     * 获取命宫支五行
     *
     * @return 命宫支五行（如：木）
     */
    public String getMingGongZhiWuXing() {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(this.mingGongZhi);
    }

    /**
     * 获取身宫支五行
     *
     * @return 身宫支五行（如：木）
     */
    public String getShenGongZhiWuXing() {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(this.shenGongZhi);
    }

    /**
     * 获取地支五行
     *
     * @param diZhi 地支
     * @return 地支五行（如：木）
     */
    public String getDiZhiWuXing(String diZhi) {
        return BaZiJiChuMap.DI_ZHI_WU_XING.get(diZhi);
    }


    /**
     * 获取年干支五行
     *
     * @return 年干支五行（如：木水）
     */
    public String getYearGanZhiWuXing() {
        return getYearGanWuXing() + getYearZhiWuXing();
    }

    /**
     * 获取月干支五行
     *
     * @return 月干支五行（如：木水）
     */
    public String getMonthGanZhiWuXing() {
        return getMonthGanWuXing() + getMonthZhiWuXing();
    }

    /**
     * 获取日干支五行
     *
     * @return 日干支五行（如：木水）
     */
    public String getDayGanZhiWuXing() {
        return getDayGanWuXing() + getDayZhiWuXing();
    }

    /**
     * 获取时干支五行
     *
     * @return 时干支五行（如：木水）
     */
    public String getHourGanZhiWuXing() {
        return getHourGanWuXing() + getHourZhiWuXing();
    }

    /**
     * 获取胎元干支五行
     *
     * @return 胎元干支五行（如：木水）
     */
    public String getTaiYuanGanZhiWuXing() {
        return getTaiYuanGanWuXing() + getTaiYuanZhiWuXing();
    }

    /**
     * 获取胎息干支五行
     *
     * @return 胎息干支五行（如：木水）
     */
    public String getTaiXiGanZhiWuXing() {
        return getTaiXiGanWuXing() + getTaiXiZhiWuXing();
    }

    /**
     * 获取命宫干支五行
     *
     * @return 命宫干支五行（如：木水）
     */
    public String getMingGongGanZhiWuXing() {
        return getMingGongGanWuXing() + getMingGongZhiWuXing();
    }

    /**
     * 获取身宫干支五行
     *
     * @return 身宫干支五行（如：木水）
     */
    public String getShenGongGanZhiWuXing() {
        return getMingGongGanWuXing() + getMingGongZhiWuXing();
    }

    /**
     * 获取干支五行
     *
     * @param ganZhi 干支
     * @return 干支五行（如：木水）
     */
    public String getGanZhiWuXing(String ganZhi) {
        ganZhi = (null != ganZhi && ganZhi.length() >= 2) ? ganZhi : CommonUtil.EMPTY2;
        return getTianGanWuXing(ganZhi.substring(0, 1)) + getDiZhiWuXing(ganZhi.substring(1, 2));
    }


    /**
     * 获取年干支主星
     *
     * @return 年干支主星（如：正财）
     */
    public String getYearGanZhiZhuXing() {
        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + this.yearGan);
    }

    /**
     * 获取月干支主星
     *
     * @return 月干支主星（如：正财）
     */
    public String getMonthGanZhiZhuXing() {
        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + this.monthGan);
    }

    /**
     * 获取日干支主星
     *
     * @return 日干支主星（如：正财）
     */
    public String getDayGanZhiZhuXing() {
//        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + this.dayGan);
        return "元" + getSex();
    }

    /**
     * 获取时干支主星
     *
     * @return 时干支主星（如：正财）
     */
    public String getHourGanZhiZhuXing() {
        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + this.hourGan);
    }

    /**
     * 获取胎元干支主星
     *
     * @return 胎元干支主星（如：正财）
     */
    public String getTaiYuanGanZhiZhuXing() {
        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + this.taiYuanGan);
    }

    /**
     * 获取胎息干支主星
     *
     * @return 胎息干支主星（如：正财）
     */
    public String getTaiXiGanZhiZhuXing() {
        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + this.taiXiGan);
    }

    /**
     * 获取命宫干支主星
     *
     * @return 命宫干支主星（如：正财）
     */
    public String getMingGongGanZhiZhuXing() {
        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + this.mingGongGan);
    }

    /**
     * 获取身宫干支主星
     *
     * @return 身宫干支主星（如：正财）
     */
    public String getShenGongGanZhiZhuXing() {
        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + this.shenGongGan);
    }

    /**
     * 获取主星
     *
     * @param ganZhi 干支
     * @return 主星（如：正财）
     */
    public String getZhuXing(String ganZhi) {
        ganZhi = (null != ganZhi && ganZhi.length() >= 2) ? ganZhi : CommonUtil.EMPTY2;
        return BaZiJiChuMap.SHI_SHEN.get(this.dayGan + ganZhi.charAt(0));
    }


    /**
     * 获取年支藏干
     *
     * @return 年支藏干（如：[乙]）
     */
    public List<String> getYearZhiCangGan() {
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(this.yearZhi);
    }

    /**
     * 获取月支藏干
     *
     * @return 月支藏干（如：[乙]）
     */
    public List<String> getMonthZhiCangGan() {
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(this.monthZhi);
    }

    /**
     * 获取日支藏干
     *
     * @return 日支藏干（如：[乙]）
     */
    public List<String> getDayZhiCangGan() {
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(this.dayZhi);
    }

    /**
     * 获取时支藏干
     *
     * @return 时支藏干（如：[乙]）
     */
    public List<String> getHourZhiCangGan() {
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(this.hourZhi);
    }

    /**
     * 获取胎元支藏干
     *
     * @return 胎元支藏干（如：[乙]）
     */
    public List<String> getTaiYuanZhiCangGan() {
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(this.taiYuanZhi);
    }

    /**
     * 获取胎息支藏干
     *
     * @return 胎息支藏干（如：[乙]）
     */
    public List<String> getTaiXiZhiCangGan() {
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(this.taiXiZhi);
    }

    /**
     * 获取命宫支藏干
     *
     * @return 命宫支藏干（如：[乙]）
     */
    public List<String> getMingGongZhiCangGan() {
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(this.mingGongZhi);
    }

    /**
     * 获取身宫支藏干
     *
     * @return 身宫支藏干（如：[乙]）
     */
    public List<String> getShenGongZhiCangGan() {
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(this.shenGongZhi);
    }

    /**
     * 获取藏干
     *
     * @param ganZhi 干支
     * @return 藏干（如：[乙]）
     */
    public List<String> getCangGan(String ganZhi) {
        ganZhi = (null != ganZhi && ganZhi.length() >= 2) ? ganZhi : CommonUtil.EMPTY2;
        return BaZiJiChuMap.DI_ZHI_CANG_GAN.get(ganZhi.substring(1, 2));
    }


    /**
     * 获取年支藏干五行
     *
     * @return 年支藏干五行（如：[木]）
     */
    public List<String> getYearZhiCangGanWuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getYearZhiCangGan()) {
            list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
        }
        return list;

    }

    /**
     * 获取月支藏干五行
     *
     * @return 月支藏干五行（如：[木]）
     */
    public List<String> getMonthZhiCangGanWuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getMonthZhiCangGan()) {
            list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
        }
        return list;

    }

    /**
     * 获取日支藏干五行
     *
     * @return 日支藏干五行（如：[木]）
     */
    public List<String> getDayZhiCangGanWuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getDayZhiCangGan()) {
            list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
        }
        return list;

    }

    /**
     * 获取时支藏干五行
     *
     * @return 时支藏干五行（如：[木]）
     */
    public List<String> getHourZhiCangGanWuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getHourZhiCangGan()) {
            list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
        }
        return list;

    }

    /**
     * 获取胎元支藏干五行
     *
     * @return 胎元支藏干五行（如：[木]）
     */
    public List<String> getTaiYuanZhiCangGanWuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getTaiYuanZhiCangGan()) {
            list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
        }
        return list;

    }

    /**
     * 获取胎息支藏干五行
     *
     * @return 胎息支藏干五行（如：[木]）
     */
    public List<String> getTaiXiZhiCangGanWuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getTaiXiZhiCangGan()) {
            list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
        }
        return list;

    }

    /**
     * 获取命宫支藏干五行
     *
     * @return 命宫支藏干五行（如：[木]）
     */
    public List<String> getMingGongZhiCangGanWuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getMingGongZhiCangGan()) {
            list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
        }
        return list;

    }

    /**
     * 获取身宫支藏干五行
     *
     * @return 身宫支藏干五行（如：[木]）
     */
    public List<String> getShenGongZhiCangGanWuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getShenGongZhiCangGan()) {
            list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
        }
        return list;

    }

    /**
     * 获取藏干五行
     *
     * @param cangGan 藏干
     * @return 藏干五行（如：[木]）
     */
    public List<String> getCangGanWuXing(List<String> cangGan) {

        List<String> list = new ArrayList<>();
        if (null != cangGan && cangGan.size() != 0) {
            for (String value : cangGan) {
                list.add(BaZiJiChuMap.TIAN_GAN_WU_XING.get(value));
            }
        }
        return list;

    }


    /**
     * 获取年干支副星
     *
     * @return 年干支副星（如：[正印]）
     */
    public List<String> getYearGanZhiFuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getYearZhiCangGan()) {
            list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
        }
        return list;

    }

    /**
     * 获取月干支副星
     *
     * @return 月干支副星（如：[正印]）
     */
    public List<String> getMonthGanZhiFuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getMonthZhiCangGan()) {
            list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
        }
        return list;

    }

    /**
     * 获取日干支副星
     *
     * @return 日干支副星（如：[正印]）
     */
    public List<String> getDayGanZhiFuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getDayZhiCangGan()) {
            list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
        }
        return list;

    }

    /**
     * 获取时干支副星
     *
     * @return 时干支副星（如：[正印]）
     */
    public List<String> getHourGanZhiFuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getHourZhiCangGan()) {
            list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
        }
        return list;

    }

    /**
     * 获取胎元干支副星
     *
     * @return 胎元干支副星（如：[正印]）
     */
    public List<String> getTaiYuanGanZhiFuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getTaiYuanZhiCangGan()) {
            list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
        }
        return list;

    }

    /**
     * 获取胎息干支副星
     *
     * @return 胎息干支副星（如：[正印]）
     */
    public List<String> getTaiXiGanZhiFuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getTaiXiZhiCangGan()) {
            list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
        }
        return list;

    }

    /**
     * 获取命宫干支副星
     *
     * @return 命宫干支副星（如：[正印]）
     */
    public List<String> getMingGongGanZhiFuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getMingGongZhiCangGan()) {
            list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
        }
        return list;

    }

    /**
     * 获取身宫干支副星
     *
     * @return 身宫干支副星（如：[正印]）
     */
    public List<String> getShenGongGanZhiFuXing() {

        List<String> list = new ArrayList<>();
        for (String value : getShenGongZhiCangGan()) {
            list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
        }
        return list;

    }

    /**
     * 获取副星
     *
     * @param cangGan 藏干
     * @return 副星（如：[正印]）
     */
    public List<String> getFuXing(List<String> cangGan) {

        List<String> list = new ArrayList<>();
        if (null != cangGan && cangGan.size() != 0) {
            for (String value : cangGan) {
                list.add(BaZiJiChuMap.SHI_SHEN.get(this.dayGan + value));
            }
        }
        return list;

    }


    /**
     * 获取年干支自坐
     *
     * @return 年干支自坐（如：长生）
     */
    public String getYearGanZhiZiZuo() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.yearGanZhi);
    }

    /**
     * 获取月干支自坐
     *
     * @return 月干支自坐（如：长生）
     */
    public String getMonthGanZhiZiZuo() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.monthGanZhi);
    }

    /**
     * 获取日干支自坐
     *
     * @return 日干支自坐（如：长生）
     */
    public String getDayGanZhiZiZuo() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGanZhi);
    }

    /**
     * 获取时干支自坐
     *
     * @return 时干支自坐（如：长生）
     */
    public String getHourGanZhiZiZuo() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.hourGanZhi);
    }

    /**
     * 获取胎元干支自坐
     *
     * @return 胎元干支自坐（如：长生）
     */
    public String getTaiYuanGanZhiZiZuo() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.taiYuanGanZhi);
    }

    /**
     * 获取胎息干支自坐
     *
     * @return 胎息干支自坐（如：长生）
     */
    public String getTaiXiGanZhiZiZuo() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.taiXiGanZhi);
    }

    /**
     * 获取命宫干支自坐
     *
     * @return 命宫干支自坐（如：长生）
     */
    public String getMingGongGanZhiZiZuo() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.mingGongGanZhi);
    }

    /**
     * 获取身宫干支自坐
     *
     * @return 身宫干支自坐（如：长生）
     */
    public String getShenGongGanZhiZiZuo() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.shenGongGanZhi);
    }

    /**
     * 获取自坐
     *
     * @param ganZhi 干支
     * @return 自坐（如：长生）
     */
    public String getZiZuo(String ganZhi) {
        ganZhi = (null != ganZhi && ganZhi.length() >= 2) ? ganZhi : CommonUtil.EMPTY2;
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(ganZhi);
    }


    /**
     * 获取年干支星运
     *
     * @return 年干支星运（如：长生）
     */
    public String getYearGanZhiXingYun() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + this.yearZhi);
    }

    /**
     * 获取月干支星运
     *
     * @return 月干支星运（如：长生）
     */
    public String getMonthGanZhiXingYun() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + this.monthZhi);
    }

    /**
     * 获取日干支星运
     *
     * @return 日干支星运（如：长生）
     */
    public String getDayGanZhiXingYun() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + this.dayZhi);
    }

    /**
     * 获取时干支星运
     *
     * @return 时干支星运（如：长生）
     */
    public String getHourGanZhiXingYun() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + this.hourZhi);
    }

    /**
     * 获取胎元干支星运
     *
     * @return 胎元干支星运（如：长生）
     */
    public String getTaiYuanGanZhiXingYun() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + this.taiYuanZhi);
    }

    /**
     * 获取胎息干支星运
     *
     * @return 胎息干支星运（如：长生）
     */
    public String getTaiXiGanZhiXingYun() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + this.taiXiZhi);
    }

    /**
     * 获取命宫干支星运
     *
     * @return 命宫干支星运（如：长生）
     */
    public String getMingGongGanZhiXingYun() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + this.mingGongZhi);
    }

    /**
     * 获取身宫干支星运
     *
     * @return 身宫干支星运（如：长生）
     */
    public String getShenGongGanZhiXingYun() {
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + this.shenGongZhi);
    }

    /**
     * 获取星运
     *
     * @param ganZhi 干支
     * @return 星运（如：长生）
     */
    public String getXingYun(String ganZhi) {
        ganZhi = (null != ganZhi && ganZhi.length() >= 2) ? ganZhi : CommonUtil.EMPTY2;
        return BaZiJiChuMap.SHI_ER_ZHANG_SHENG.get(this.dayGan + ganZhi.charAt(1));
    }


    /**
     * 获取年干支空亡
     *
     * @return 年干支空亡（如：子丑）
     */
    public String getYearGanZhiKongWang() {
        return BaZiJiChuMap.KONG_WANG.get(this.yearGanZhi);
    }

    /**
     * 获取月干支空亡
     *
     * @return 月干支空亡（如：子丑）
     */
    public String getMonthGanZhiKongWang() {
        return BaZiJiChuMap.KONG_WANG.get(this.monthGanZhi);
    }

    /**
     * 获取日干支空亡
     *
     * @return 日干支空亡（如：子丑）
     */
    public String getDayGanZhiKongWang() {
        return BaZiJiChuMap.KONG_WANG.get(this.dayGanZhi);
    }

    /**
     * 获取时干支空亡
     *
     * @return 时干支空亡（如：子丑）
     */
    public String getHourGanZhiKongWang() {
        return BaZiJiChuMap.KONG_WANG.get(this.hourGanZhi);
    }

    /**
     * 获取胎元干支空亡
     *
     * @return 胎元干支空亡（如：子丑）
     */
    public String getTaiYuanGanZhiKongWang() {
        return BaZiJiChuMap.KONG_WANG.get(this.taiYuanGanZhi);
    }

    /**
     * 获取胎息干支空亡
     *
     * @return 胎息干支空亡（如：子丑）
     */
    public String getTaiXiGanZhiKongWang() {
        return BaZiJiChuMap.KONG_WANG.get(this.taiXiGanZhi);
    }

    /**
     * 获取命宫干支空亡
     *
     * @return 命宫干支空亡（如：子丑）
     */
    public String getMingGongGanZhiKongWang() {
        return BaZiJiChuMap.KONG_WANG.get(this.mingGongGanZhi);
    }

    /**
     * 获取身宫干支空亡
     *
     * @return 身宫干支空亡（如：子丑）
     */
    public String getShenGongGanZhiKongWang() {
        return BaZiJiChuMap.KONG_WANG.get(this.shenGongGanZhi);
    }

    /**
     * 获取空亡
     *
     * @param ganZhi 干支
     * @return 空亡（如：子丑）
     */
    public String getKongWang(String ganZhi) {
        return BaZiJiChuMap.KONG_WANG.get(ganZhi);
    }


    /**
     * 获取年干支纳音
     *
     * @return 年干支纳音（如：天上火）
     */
    public String getYearGanZhiNaYin() {
        return BaZiJiChuMap.NA_YIN.get(this.yearGanZhi);
    }

    /**
     * 获取月干支纳音
     *
     * @return 月干支纳音（如：天上火）
     */
    public String getMonthGanZhiNaYin() {
        return BaZiJiChuMap.NA_YIN.get(this.monthGanZhi);
    }

    /**
     * 获取日干支纳音
     *
     * @return 日干支纳音（如：天上火）
     */
    public String getDayGanZhiNaYin() {
        return BaZiJiChuMap.NA_YIN.get(this.dayGanZhi);
    }

    /**
     * 获取时干支纳音
     *
     * @return 时干支纳音（如：天上火）
     */
    public String getHourGanZhiNaYin() {
        return BaZiJiChuMap.NA_YIN.get(this.hourGanZhi);
    }

    /**
     * 获取胎元干支纳音
     *
     * @return 胎元干支纳音（如：天上火）
     */
    public String getTaiYuanGanZhiNaYin() {
        return BaZiJiChuMap.NA_YIN.get(this.taiYuanGanZhi);
    }

    /**
     * 获取胎息干支纳音
     *
     * @return 胎息干支纳音（如：天上火）
     */
    public String getTaiXiGanZhiNaYin() {
        return BaZiJiChuMap.NA_YIN.get(this.taiXiGanZhi);
    }

    /**
     * 获取命宫干支纳音
     *
     * @return 命宫干支纳音（如：天上火）
     */
    public String getMingGongGanZhiNaYin() {
        return BaZiJiChuMap.NA_YIN.get(this.mingGongGanZhi);
    }

    /**
     * 获取身宫干支纳音
     *
     * @return 身宫干支纳音（如：天上火）
     */
    public String getShenGongGanZhiNaYin() {
        return BaZiJiChuMap.NA_YIN.get(this.shenGongGanZhi);
    }

    /**
     * 获取纳音
     *
     * @param ganZhi 干支
     * @return 纳音（如：天上火）
     */
    public String getNaYin(String ganZhi) {
        return BaZiJiChuMap.NA_YIN.get(ganZhi);
    }


    /**
     * 获取年干支神煞
     *
     * @return 年干支神煞（如：[太极贵人]）
     */
    public List<String> getYearGanZhiShenSha() {

        initializeShenSha(); // 初始化神煞
        return this.baZiShenShaUtil.getYearGanZhiShenSha();

    }

    /**
     * 获取月干支神煞
     *
     * @return 月干支神煞（如：[太极贵人]）
     */
    public List<String> getMonthGanZhiShenSha() {

        initializeShenSha(); // 初始化神煞
        return this.baZiShenShaUtil.getMonthGanZhiShenSha();

    }

    /**
     * 获取日干支神煞
     *
     * @return 日干支神煞（如：[太极贵人]）
     */
    public List<String> getDayGanZhiShenSha() {

        initializeShenSha(); // 初始化神煞
        return this.baZiShenShaUtil.getDayGanZhiShenSha();

    }

    /**
     * 获取时干支神煞
     *
     * @return 时干支神煞（如：[太极贵人]）
     */
    public List<String> getHourGanZhiShenSha() {

        initializeShenSha(); // 初始化神煞
        return this.baZiShenShaUtil.getHourGanZhiShenSha();

    }

    /**
     * 获取胎元干支神煞
     *
     * @return 胎元干支神煞（如：[太极贵人]）
     */
    public List<String> getTaiYuanGanZhiShenSha() {

        initializeShenSha(); // 初始化神煞
        return this.baZiShenShaUtil.getDaYunGanZhiShenSha();

    }

    /**
     * 获取胎息干支神煞
     *
     * @return 胎息干支神煞（如：[太极贵人]）
     */
    public List<String> getTaiXiGanZhiShenSha() {

        initializeShenSha(); // 初始化神煞
        return this.baZiShenShaUtil.getLiuNianGanZhiShenSha();

    }

    /**
     * 获取命宫干支神煞
     *
     * @return 命宫干支神煞（如：[太极贵人]）
     */
    public List<String> getMingGongGanZhiShenSha() {

        initializeShenSha(); // 初始化神煞
        return this.baZiShenShaUtil.getLiuYueGanZhiShenSha();

    }

    /**
     * 获取身宫干支神煞
     *
     * @return 身宫干支神煞（如：[太极贵人]）
     */
    public List<String> getShenGongGanZhiShenSha() {

        initializeShenSha(); // 初始化神煞
        return this.baZiShenShaUtil.getLiuRiGanZhiShenSha();

    }


    /**
     * 获取五行木数量
     *
     * @param isDiZhiCangGan 是否包含地支藏干（true:是。false:否）
     * @return 五行木数量（如：1）
     */
    public int getWuXingMuCount(boolean isDiZhiCangGan) {
        return computeWuXingCount("木", isDiZhiCangGan);
    }

    /**
     * 获取五行火数量
     *
     * @param isDiZhiCangGan 是否包含地支藏干（true:是。false:否）
     * @return 五行火数量（如：1）
     */
    public int getWuXingHuoCount(boolean isDiZhiCangGan) {
        return computeWuXingCount("火", isDiZhiCangGan);
    }

    /**
     * 获取五行土数量
     *
     * @param isDiZhiCangGan 是否包含地支藏干（true:是。false:否）
     * @return 五行土数量（如：1）
     */
    public int getWuXingTuCount(boolean isDiZhiCangGan) {
        return computeWuXingCount("土", isDiZhiCangGan);
    }

    /**
     * 获取五行金数量
     *
     * @param isDiZhiCangGan 是否包含地支藏干（true:是。false:否）
     * @return 五行金数量（如：1）
     */
    public int getWuXingJinCount(boolean isDiZhiCangGan) {
        return computeWuXingCount("金", isDiZhiCangGan);
    }

    /**
     * 获取五行水数量
     *
     * @param isDiZhiCangGan 是否包含地支藏干（true:是。false:否）
     * @return 五行水数量（如：1）
     */
    public int getWuXingShuiCount(boolean isDiZhiCangGan) {
        return computeWuXingCount("水", isDiZhiCangGan);
    }


    /**
     * 获取五行旺衰
     *
     * @return 五行旺衰（如：[木旺, 火相, 水休, 金囚, 土死]）
     */
    public List<String> getWuXingWangShuai() {
        return BaZiJiChuMap.WU_XING_WANG_SHUAI.get(this.monthZhi);
    }

    /**
     * 获取五行缺失
     *
     * @return 五行缺失（如：[木]）
     */
    public List<String> getWuXingQueShi() {

        Map<String, String> tianGanWuXingMap = BaZiJiChuMap.TIAN_GAN_WU_XING; // 天干五行（天干为键）
        Map<String, String> diZhiWuXingMap = BaZiJiChuMap.DI_ZHI_WU_XING; // 地支五行（地支为键）

        Set<String> set = new HashSet<>(
                Arrays.asList(tianGanWuXingMap.get(this.yearGan), tianGanWuXingMap.get(this.monthGan), tianGanWuXingMap.get(this.dayGan), tianGanWuXingMap.get(this.hourGan),
                        diZhiWuXingMap.get(this.yearZhi), diZhiWuXingMap.get(this.monthZhi), diZhiWuXingMap.get(this.dayZhi), diZhiWuXingMap.get(this.hourZhi))
        );
        List<String> list = CommonUtil.removeDuplicates(new ArrayList<>(set)); // 删除list数组中重复的元素

        return CommonUtil.getListUnlike(list, Arrays.asList("木", "火", "土", "金", "水"));

    }


    /**
     * 获取天干留意
     *
     * @return 天干留意（如：[甲己相合]）
     */
    public List<String> getTianGanLiuYi() {
        return BaZiGanZhiLiuYiUtil.tanGanLiuYi(this.yearGan, this.monthGan, this.dayGan, this.hourGan, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2);
    }

    /**
     * 获取地支留意
     *
     * @return 地支留意（如：[子丑六合]）
     */
    public List<String> getDiZhiLiuYi() {
        return BaZiGanZhiLiuYiUtil.diZhiLiuYi(this.yearZhi, this.monthZhi, this.dayZhi, this.hourZhi, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2);
    }


    /**
     * 获取上一节
     *
     * @return 上一节（如：大雪）
     */
    public String getPrevJie() {
        return getLunar().getPrevJie(this.baZiJiChuSetting.getJieQiType() == 0).toString();
    }

    /**
     * 获取上一节日期
     *
     * @return 上一节日期（如：2023-12-07 17:32:44）
     */
    public String getPrevJieDateStr() {
        return getLunar().getPrevJie(this.baZiJiChuSetting.getJieQiType() == 0).getSolar().toYmdHms();
    }

    /**
     * 获取距上一节天数
     *
     * @return 距上一节天数（如：24）
     */
    public int getPrevJieDay() {
        return Math.toIntExact(DateUtil.dateInterval(getPrevJieDateStr(), this.solar.toYmdHms()).get("days"));
    }

    /**
     * 获取下一节
     *
     * @return 下一节（如：小寒）
     */
    public String getNextJie() {
        return getLunar().getNextJie(this.baZiJiChuSetting.getJieQiType() == 0).toString();
    }

    /**
     * 获取下一节日期
     *
     * @return 下一节日期（如：2024-01-06 04:49:08）
     */
    public String getNextJieDateStr() {
        return getLunar().getNextJie(this.baZiJiChuSetting.getJieQiType() == 0).getSolar().toYmdHms();
    }

    /**
     * 获取距下一节天数
     *
     * @return 距下一节天数（如：5）
     */
    public int getNextJieDay() {
        return Math.toIntExact(DateUtil.dateInterval(this.solar.toYmdHms(), getNextJieDateStr()).get("days"));
    }

    /**
     * 获取出生节
     *
     * @return 出生节（如：大雪后24天6小时27分16秒、小寒前5天4小时49分8秒）
     */
    public String getChuShengJie() {

        Map<String, Long> prevMap = DateUtil.dateInterval(getPrevJieDateStr(), this.solar.toYmdHms()); // 计算上一节气与排盘日期的时间间隔
        Map<String, Long> nextMap = DateUtil.dateInterval(this.solar.toYmdHms(), getNextJieDateStr()); // 计算排盘日期与下一节气的时间间隔

        long prevDay = prevMap.get("days") > 0 ? prevMap.get("days") : -prevMap.get("days"); // 天
        long prevHours = prevMap.get("hours") > 0 ? prevMap.get("hours") : -prevMap.get("hours"); // 小时
        long prevMinutes = prevMap.get("minutes") > 0 ? prevMap.get("minutes") : -prevMap.get("minutes"); // 分
        long prevSeconds = prevMap.get("seconds") > 0 ? prevMap.get("seconds") : -prevMap.get("seconds"); // 秒

        long nextDay = nextMap.get("days") > 0 ? nextMap.get("days") : -nextMap.get("days"); // 天
        long nextHours = nextMap.get("hours") > 0 ? nextMap.get("hours") : -nextMap.get("hours"); // 小时
        long nextMinutes = nextMap.get("minutes") > 0 ? nextMap.get("minutes") : -nextMap.get("minutes"); // 分
        long nextSeconds = nextMap.get("seconds") > 0 ? nextMap.get("seconds") : -nextMap.get("seconds"); // 秒

        String prevStr = getPrevJie() + "后" + prevDay + "天" + prevHours + "小时" + prevMinutes + "分" + prevSeconds + "秒";
        String nextStr = getNextJie() + "前" + nextDay + "天" + nextHours + "小时" + nextMinutes + "分" + nextSeconds + "秒";

        return prevStr + "、" + nextStr;

    }


    /**
     * 获取上一气
     *
     * @return 上一气（如：冬至）
     */
    public String getPrevQi() {
        return getLunar().getPrevQi(this.baZiJiChuSetting.getJieQiType() == 0).toString();
    }

    /**
     * 获取上一气日期
     *
     * @return 上一气日期（如：2023-12-22 11:27:09）
     */
    public String getPrevQiDateStr() {
        return getLunar().getPrevQi(this.baZiJiChuSetting.getJieQiType() == 0).getSolar().toYmdHms();
    }

    /**
     * 获取距上一气天数
     *
     * @return 距上一气天数（如：9）
     */
    public int getPrevQiDay() {
        return Math.toIntExact(DateUtil.dateInterval(getPrevQiDateStr(), this.solar.toYmdHms()).get("days"));
    }

    /**
     * 获取下一气
     *
     * @return 下一气（如：大寒）
     */
    public String getNextQi() {
        return getLunar().getNextQi(this.baZiJiChuSetting.getJieQiType() == 0).toString();
    }

    /**
     * 获取下一气日期
     *
     * @return 下一气日期（如：2024-01-20 22:07:08）
     */
    public String getNextQiDateStr() {
        return getLunar().getNextQi(this.baZiJiChuSetting.getJieQiType() == 0).getSolar().toYmdHms();
    }

    /**
     * 获取距下一气天数
     *
     * @return 距下一节天数（如：19）
     */
    public int getNextQiDay() {
        return Math.toIntExact(DateUtil.dateInterval(this.solar.toYmdHms(), getNextQiDateStr()).get("days"));
    }

    /**
     * 获取出生气
     *
     * @return 出生气（如：冬至后9天12小时32分51秒、大寒前19天22小时7分8秒）
     */
    public String getChuShengQi() {

        Map<String, Long> prevMap = DateUtil.dateInterval(getPrevQiDateStr(), this.solar.toYmdHms()); // 计算上一节气与排盘日期的时间间隔
        Map<String, Long> nextMap = DateUtil.dateInterval(this.solar.toYmdHms(), getNextQiDateStr()); // 计算排盘日期与下一节气的时间间隔

        long prevDay = prevMap.get("days") > 0 ? prevMap.get("days") : -prevMap.get("days"); // 天
        long prevHours = prevMap.get("hours") > 0 ? prevMap.get("hours") : -prevMap.get("hours"); // 小时
        long prevMinutes = prevMap.get("minutes") > 0 ? prevMap.get("minutes") : -prevMap.get("minutes"); // 分
        long prevSeconds = prevMap.get("seconds") > 0 ? prevMap.get("seconds") : -prevMap.get("seconds"); // 秒

        long nextDay = nextMap.get("days") > 0 ? nextMap.get("days") : -nextMap.get("days"); // 天
        long nextHours = nextMap.get("hours") > 0 ? nextMap.get("hours") : -nextMap.get("hours"); // 小时
        long nextMinutes = nextMap.get("minutes") > 0 ? nextMap.get("minutes") : -nextMap.get("minutes"); // 分
        long nextSeconds = nextMap.get("seconds") > 0 ? nextMap.get("seconds") : -nextMap.get("seconds"); // 秒

        String prevStr = getPrevQi() + "后" + prevDay + "天" + prevHours + "小时" + prevMinutes + "分" + prevSeconds + "秒";
        String nextStr = getNextQi() + "前" + nextDay + "天" + nextHours + "小时" + nextMinutes + "分" + nextSeconds + "秒";

        return prevStr + "、" + nextStr;

    }


    /**
     * 获取月相
     *
     * @return 月相（如：朔）
     */
    public String getYueXiang() {
        return this.lunar.getYueXiang();
    }

    /**
     * 获取月将
     *
     * @return 月将（如：子）
     */
    public String getYueJiang() {
        return BaZiJiChuMap.YUE_JIANG.get(getPrevQi() + getNextQi()).get(0);
    }

    /**
     * 获取月将神
     *
     * @return 月将神（如：神后）
     */
    public String getYueJiangShen() {
        return BaZiJiChuMap.YUE_JIANG.get(getPrevQi() + getNextQi()).get(1);
    }


    /**
     * 获取人元司令分野
     *
     * @return 人元司令分野（如：癸水值令）
     */
    public String getRenYuanSiLingFenYe() {

        String renYuanSiLingFenYe = "";

        int prevJieDayNumber = (getPrevJieDay() < 0 || getPrevJieDay() > 29) ? 1 : getPrevJieDay();
        if (this.baZiJiChuSetting.getRenYuanType() == 0) {
            renYuanSiLingFenYe = BaZiJiChuMap.ZI_REN_YUAN.get(getMonthZhi()).get(prevJieDayNumber); // 子平真诠法诀
        } else if (this.baZiJiChuSetting.getRenYuanType() == 1) {
            renYuanSiLingFenYe = BaZiJiChuMap.YUAN_REN_YUAN.get(getMonthZhi()).get(prevJieDayNumber); // 渊海子平法诀
        } else if (this.baZiJiChuSetting.getRenYuanType() == 2) {
            renYuanSiLingFenYe = BaZiJiChuMap.XING_REN_YUAN.get(getMonthZhi()).get(prevJieDayNumber); // 星平会海法诀
        } else if (this.baZiJiChuSetting.getRenYuanType() == 3) {
            renYuanSiLingFenYe = BaZiJiChuMap.SAN_REN_YUAN.get(getMonthZhi()).get(prevJieDayNumber); // 三命通会法诀
        } else if (this.baZiJiChuSetting.getRenYuanType() == 4) {
            renYuanSiLingFenYe = BaZiJiChuMap.SHEN_REN_YUAN.get(getMonthZhi()).get(prevJieDayNumber); // 神峰通考法诀
        } else if (this.baZiJiChuSetting.getRenYuanType() == 5) {
            renYuanSiLingFenYe = BaZiJiChuMap.WAN_REN_YUAN.get(getMonthZhi()).get(prevJieDayNumber); // 万育吾之法诀
        }
        renYuanSiLingFenYe = "".equals(renYuanSiLingFenYe) ? "己" : renYuanSiLingFenYe;

        return renYuanSiLingFenYe + BaZiJiChuMap.TIAN_GAN_WU_XING.get(renYuanSiLingFenYe) + "值令";

    }

    /**
     * 获取身体强弱
     *
     * @return 身体强弱（如：身强）
     */
    public String getShenTiQiangRuo() {

        Map<String, String> ganZhiWuXingShengKeMap = BaZiJiChuMap.GAN_ZHI_WU_XING_SHENG_KE; // 天干和干支的五行生克关系（天干+干支为键）

        // 方法一：根据[日元]和[月令]之间的五行生克关系计算
//        return ganZhiWuXingShengKeMap.get(this.dayGan + this.monthZhi);

        // 方法二：根据[日元]和[其他干支]之间的算分进行计算
        int jiaFen = 0; // 加分
        jiaFen += BaZiJiChuUtil.ganZhiJiaFen(ganZhiWuXingShengKeMap, getDayGan(), getYearGan(), 8); // 年干统一为8分
        jiaFen += BaZiJiChuUtil.ganZhiJiaFen(ganZhiWuXingShengKeMap, getDayGan(), getYearZhi(), 4); // 年支统一为4分
        jiaFen += BaZiJiChuUtil.ganZhiJiaFen(ganZhiWuXingShengKeMap, getDayGan(), getMonthGan(), 12); // 月干统一为12分
        jiaFen += BaZiJiChuUtil.ganZhiJiaFen(ganZhiWuXingShengKeMap, getDayGan(), getMonthZhi(), 40); // 月支统一为40分
        jiaFen += BaZiJiChuUtil.ganZhiJiaFen(ganZhiWuXingShengKeMap, getDayGan(), getDayZhi(), 12); // 日支统一为12分
        jiaFen += BaZiJiChuUtil.ganZhiJiaFen(ganZhiWuXingShengKeMap, getDayGan(), getHourGan(), 12); // 时干统一为12分
        jiaFen += BaZiJiChuUtil.ganZhiJiaFen(ganZhiWuXingShengKeMap, getDayGan(), getHourZhi(), 12); // 时支统一为12分

        if (jiaFen == 50) {
            return "平衡"; // 加分等于50：平衡（中庸之道）
        } else if (jiaFen >= 40 && jiaFen <= 60) {
            return "接近平衡"; // 加分>=40且<=60：接近平衡（中庸之道）
        } else if (jiaFen < 40) {
            return "身弱"; // 加分小于40：身弱
        } else {
            return "身强"; // 加分大于60：身强
        }

    }


    /**
     * 获取喜用神
     *
     * @return 喜用神（如：[木]）
     */
    public List<String> getXiYongShen() {

        Map<String, String> tianGanWuXingMap = BaZiJiChuMap.TIAN_GAN_WU_XING; // 天干五行（天干为键）
        Map<String, String> diZhiWuXingMap = BaZiJiChuMap.DI_ZHI_WU_XING; // 地支五行（地支为键）
        Map<String, String> ganZhiWuXingShengKeMap = BaZiJiChuMap.GAN_ZHI_WU_XING_SHENG_KE;// 天干和干支的五行生克关系（天干+干支为键）

        Set<String> set = new HashSet<>();

        // 1、若身强，则寻找：克我、我生、我克的干支
        if ("身强".equals(getShenTiQiangRuo())) {
            if ("身弱".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.yearGan))) set.add(tianGanWuXingMap.get(this.yearGan)); // 添加年干五行
            if ("身弱".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.yearZhi))) set.add(diZhiWuXingMap.get(this.yearZhi)); // 添加年支五行
            if ("身弱".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.monthGan))) set.add(tianGanWuXingMap.get(this.monthGan)); // 添加月干五行
            if ("身弱".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.monthZhi))) set.add(diZhiWuXingMap.get(this.monthZhi)); // 添加月支五行
            if ("身弱".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.dayGan))) set.add(tianGanWuXingMap.get(this.dayGan)); // 添加日干五行
            if ("身弱".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.dayZhi))) set.add(diZhiWuXingMap.get(this.dayZhi)); // 添加日支五行
            if ("身弱".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.hourGan))) set.add(tianGanWuXingMap.get(this.hourGan)); // 添加时干五行
            if ("身弱".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.hourZhi))) set.add(diZhiWuXingMap.get(this.hourZhi)); // 添加时支五行
            return new ArrayList<>(set);
        }

        // 2、若身弱，则寻找：同我、生我的干支
        if ("身弱".equals(getShenTiQiangRuo())) {
            if ("身强".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.yearGan))) set.add(tianGanWuXingMap.get(this.yearGan)); // 添加年干的五行
            if ("身强".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.yearZhi))) set.add(diZhiWuXingMap.get(this.yearZhi)); // 添加年支的五行
            if ("身强".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.monthGan))) set.add(tianGanWuXingMap.get(this.monthGan)); // 添加月干的五行
            if ("身强".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.monthZhi))) set.add(diZhiWuXingMap.get(this.monthZhi)); // 添加月支的五行
            if ("身强".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.dayGan))) set.add(tianGanWuXingMap.get(this.dayGan)); // 添加日干五行
            if ("身强".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.dayZhi))) set.add(diZhiWuXingMap.get(this.dayZhi)); // 添加日支的五行
            if ("身强".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.hourGan))) set.add(tianGanWuXingMap.get(this.hourGan)); // 添加时干的五行
            if ("身强".equals(ganZhiWuXingShengKeMap.get(this.dayGan + this.hourZhi))) set.add(diZhiWuXingMap.get(this.hourZhi)); // 添加时支的五行
            return new ArrayList<>(set);
        }

        // 3、若身体为平衡或接近平衡，则使用具体法获取喜用神
        String season = getJiJie().substring(1, 2);
        int lunarMonth = this.lunar.getMonth(); // 农历月
        if (lunarMonth == 3 || lunarMonth == 6 || lunarMonth == 9 || lunarMonth == 12) season = "四季末";
        return BaZiJiChuMap.XI_YONG_SHEN.get(getDayGan() + season);

    }

    /**
     * 获取喜用神方位
     *
     * @return 喜用神方位（如：[东, 东南]）
     */
    public List<String> getXiYongShenFangWei() {

        List<String> xiYongShenFangWei = new ArrayList<>();

        for (int i = 0; i < getXiYongShen().size(); i++) {
            String xiYongShen = getXiYongShen().get(i);
            List<String> xiYongFangWei = BaZiJiChuMap.WU_XING_FANG_WEI.get(xiYongShen);
            xiYongShenFangWei.addAll(xiYongFangWei);
        }

        return xiYongShenFangWei;

    }

    /**
     * 获取骨重及批注
     *
     * @return 骨重及批注（如：[七两, 此命推来福禄宏，不须愁虑苦劳心。荣华富贵已天定，正笏垂绅拜紫宸。]）
     */
    public List<String> getGuZhong() {

        int yearGuZhong = BaZiJiChuMap.YEAR_GU_ZHONG.get(getYearGanZhi()); // 出生年骨重
        int monthGuZhong = BaZiJiChuMap.MONTH_GU_ZHONG.get(getMonthZhi()); // 出生月骨重
        int dayGuZhong = BaZiJiChuMap.DAY_GU_ZHONG.get(getLunar().getDayInChinese()); // 出生日骨重
        int hourGuZhong = BaZiJiChuMap.HOUR_GU_ZHONG.get(getHourZhi()); // 出生时辰骨重

        int guZhong = yearGuZhong + monthGuZhong + dayGuZhong + hourGuZhong; // 骨重
        guZhong = Math.max(guZhong, 21); // 最轻骨重

        if ("男".equals(getSex())) {
            // 1、男命
            guZhong = Math.min(guZhong, 72); // 男命的最重骨重
            Map<Integer, String> yunChengWan = BaZiJiChuMap.GU_ZHONG_PI_ZHU_WAN; // 骨重批注（男命）
            return Arrays.asList(BaZiJiChuUtil.guZhongCharacters(guZhong), yunChengWan.get(guZhong));
        } else {
            // 2、女命
            guZhong = Math.min(guZhong, 71); // 女命的最重骨重
            Map<Integer, String> yunChengWan = BaZiJiChuMap.GU_ZHONG_PI_ZHU_WOMAN; // 骨重批注（女命）
            return Arrays.asList(BaZiJiChuUtil.guZhongCharacters(guZhong), yunChengWan.get(guZhong));
        }

    }


    /**
     * 获取星宿
     *
     * @return 星宿（如：毕宿西方白虎）
     */
    public String getXingXiu() {
        return this.lunar.getXiu() + "宿" + this.lunar.getGong() + "方" + this.lunar.getShou();
    }

    /**
     * 获取星宿吉凶
     *
     * @return 星宿吉凶（如：吉）
     */
    public String getXingXiuJiXiong() {
        return this.lunar.getXiuLuck();
    }

    /**
     * 获取星宿吉凶歌诀
     *
     * @return 星宿吉凶歌诀（如：毕星造作主光前，买得田园有余钱，埋葬此日添官职，田蚕大熟永丰年，开门放水多吉庆，合家人口得安然，婚姻若得逢此日，生得孩儿福寿全。）
     */
    public String getXingXiuJiXiongGeJue() {
        return this.lunar.getXiuSong();
    }


    /**
     * 获取命卦
     *
     * @return 命卦及分析（如：巽卦（东四命））
     */
    public String getMingGua() {

        // 计算年份合数
        int yearCount = 0; // 年份合数
        String yearStr = String.valueOf(getLunar().getYear());
        for (int i = 0; i < yearStr.length(); i++) {
            yearCount += Integer.parseInt(yearStr.split("")[i]);
        }

        Map<Integer, String> mingGuaMap = BaZiJiChuMap.MING_GUA; // 命卦（命卦宫位为键）

        if ("男".equals(getSex())) {
            // 若年份合数大于10，则继续使用年份合数相加，直至小于10为止
            while (true) {
                if (yearCount > 10) {
                    String yearCountStr = String.valueOf(yearCount);
                    yearCount = 0;
                    for (int i = 0; i < yearCountStr.length(); i++) {
                        yearCount += Integer.parseInt(yearCountStr.split("")[i]);
                    }
                } else break;
            }
            // 使用（11-数字之和）得出男命命卦宫位
            yearCount = 11 - yearCount == 5 ? 2 : 11 - yearCount; // 男命命卦宫位为5时，寄坤宫
            return mingGuaMap.get(yearCount);
        } else {
            int womManMingGuaGong = yearCount + 4; // 数字B
            // 若数字B大于9，再用数字B-9；如没有余数或除尽则视为9
            while (true) {
                if (womManMingGuaGong > 9) {
                    womManMingGuaGong -= 9;
                } else break;
            }
            // 得出女命命卦宫位，并获取命卦
            womManMingGuaGong = womManMingGuaGong == 5 ? 8 : womManMingGuaGong; // 女命命卦宫位为5时，寄艮宫
            return mingGuaMap.get(womManMingGuaGong);
        }

    }

    /**
     * 获取日柱论命
     *
     * @return 日柱论命（如：多学少成，防止有始无终 ...）
     */
    public String getRiZhuLunMing() {
        return BaZiJiChuMap.RI_ZHU_LUN_MING.get(this.dayGanZhi);
    }

    /**
     * 获取五行分析
     *
     * @return 五行分析（如：缘主生于癸卯年为金箔金命 ...）
     */
    public String getWuXingFenXi() {

        String yearGanZhiNaYinWuXing = getYearGanZhiNaYin().substring(2, 3); // 年干支纳音五行（如：木）
        return "缘主生于" + this.yearGanZhi + "年为" + getYearGanZhiNaYin() + "命，" + BaZiJiChuMap.WU_XING_FEN_XI.get(yearGanZhiNaYinWuXing);

    }

    /**
     * 获取运势分析
     *
     * @return 运势分析（如：缘主出生在子时，通常具有敏锐的直觉和判断力 ...）
     */
    public String getYunShiFenXi() {
        return BaZiJiChuMap.YUN_SHI_FEN_XI.get(this.hourZhi);
    }

    /**
     * 获取性格分析
     *
     * @return 性格分析（如：[年干支主星（食神）代表内心深处的心思，一般表现为：随性厚道。]）
     */
    public String getXingGeFenXi() {

        Map<String, String> shiShenXingGeMap = BaZiJiChuMap.SHI_SHEN_XING_GE_FEN_XI; // 十神性格表现（十神为键）
        String neiXin = "年干支主星（" + getYearGanZhiZhuXing() + "）通常代表内在性格：" + shiShenXingGeMap.get(getYearGanZhiZhuXing()) + "。";
        String waiZai = "时干支主星（" + getHourGanZhiZhuXing() + "）通常代表外在性格：" + shiShenXingGeMap.get(getHourGanZhiZhuXing()) + "。";
        return neiXin + waiZai;

    }


    /**
     * 获取公历起运日期
     *
     * @return 公历起运日期（如：2032-02-01 00:00:00）
     */
    public String getSolarQiYunDateStr() {
        return this.yun.getStartSolar().toYmdHms();
    }

    /**
     * 获取公历起运信息
     *
     * @return 公历起运信息（如：出生8年1个月后开始起运）
     */
    public String getSolarQiYun() {

        String qiYun = "出生";
        if (this.yun.getStartYear() != 0) qiYun += this.yun.getStartYear() + "年";
        if (this.yun.getStartMonth() != 0) qiYun += this.yun.getStartMonth() + "个月";
        if (this.yun.getStartDay() != 0) qiYun += this.yun.getStartDay() + "天";
        if (this.yun.getStartHour() != 0) qiYun += this.yun.getStartHour() + "小时";
        qiYun += "起运";
        return qiYun;

    }

    /**
     * 获取公历交运信息
     *
     * @return 公历交运信息（如：逢壬、丁年，小寒后25天交运）
     */
    public String getSolarJiaoYun() {

        // 1、通过起运年份的流年干计算交运干
        String jiaoYunGan = BaZiJiChuMap.JIAO_YUN_GAN.get(this.liuNian.get(this.xiaoYunYearSum).get(2).substring(0, 1));

        // 2、计算交运农历日期
        Lunar lunar = new Lunar(DateUtil.updateDate(getSolarDate(), this.yun.getStartYear(), this.yun.getStartMonth(), this.yun.getStartDay()));

        // 3、计算上一节、交运农历日期距上一节的天数
        String prevJie = ""; // 上一节
        int prevJieDay = 0; // 交运农历日期距上一节的天数
        for (int i = 1; i < 60; i++) {
            prevJie = lunar.next(-i).getJie(); // 向前第i天的节，若没有则返回 ""
            if ("".equals(prevJie)) {
                prevJieDay++;
            } else break;
        }

        // 4、返回数据
        return "逢" + jiaoYunGan + "年，" + prevJie + "后" + prevJieDay + "天交运";

    }


    /**
     * 获取正财运
     *
     * @return 正财运，依次为：年份、年龄、干支、合化
     */
    public List<List<String>> getZhengCaiYun() {
        return this.zhengCaiYun;
    }

    /**
     * 获取偏财运
     *
     * @return 偏财运，依次为：年份、年龄、干支、合化
     */
    public List<List<String>> getPianCaiYun() {
        return this.pianCaiYun;
    }

    /**
     * 获取正桃花运
     *
     * @return 正桃花运，依次为：年份、年龄、干支、合化
     */
    public List<List<String>> getZhengTaoHuaYun() {
        return this.zhengTaoHuaYun;
    }

    /**
     * 获取偏桃花运
     *
     * @return 偏桃花运，依次为：年份、年龄、干支、合化
     */
    public List<List<String>> getPianTaoHuaYun() {
        return this.pianTaoHuaYun;
    }

//-------------------------------------------------------------------------------------------------------------------------------

    /**
     * 计算五行数量
     *
     * @param wuXing         五行
     * @param isDiZhiCangGan 是否包含地支藏干（true:是。false:否）
     * @return 五行数量（如：1）
     */
    private int computeWuXingCount(String wuXing, boolean isDiZhiCangGan) {

        int count = 0;

        if (wuXing.equals(getYearGanWuXing())) count++;
        if (wuXing.equals(getMonthGanWuXing())) count++;
        if (wuXing.equals(getDayGanWuXing())) count++;
        if (wuXing.equals(getHourGanWuXing())) count++;
        if (wuXing.equals(getYearZhiWuXing())) count++;
        if (wuXing.equals(getMonthZhiWuXing())) count++;
        if (wuXing.equals(getDayZhiWuXing())) count++;
        if (wuXing.equals(getHourZhiWuXing())) count++;

        if (isDiZhiCangGan) {
            for (String key : getYearZhiCangGanWuXing()) {
                if (wuXing.equals(key)) count++;
            }
            for (String key : getMonthZhiCangGanWuXing()) {
                if (wuXing.equals(key)) count++;
            }
            for (String key : getDayZhiCangGanWuXing()) {
                if (wuXing.equals(key)) count++;
            }
            for (String key : getHourZhiCangGanWuXing()) {
                if (wuXing.equals(key)) count++;
            }
        }

        return count;

    }

    /**
     * 计算财运或桃花运相关信息
     *
     * @param zhengCaiOrZhengTaoHuaMap  正财集合或正桃花集合
     * @param pianCaiOrZhengTaoHuaMap   偏财集合或偏桃花集合
     * @param zhengCaiOrZhengTaoHuaList 保存正财或正桃花信息
     * @param pianCaiOrZhengTaoHuaList  保存偏财或偏桃花信息
     */
    protected void computeCaiHua(Map<String, List<String>> zhengCaiOrZhengTaoHuaMap, Map<String, List<String>> pianCaiOrZhengTaoHuaMap, List<List<String>> zhengCaiOrZhengTaoHuaList, List<List<String>> pianCaiOrZhengTaoHuaList) {

        for (List<String> liuNian : this.liuNian) {
            String liuNianGan = liuNian.get(2).substring(0, 1); // 流年天干
            String liuNianZhi = liuNian.get(2).substring(1, 2); // 流年地支
            List<String> zhengCaiOrZhengTaoHuaGanZhi = zhengCaiOrZhengTaoHuaMap.get(getDayGan()); // 正财干支或正桃花干支
            List<String> pianCaiOrPianTaoHuaGanZhi = pianCaiOrZhengTaoHuaMap.get(getDayGan()); // 正桃花干支或偏桃花干支
            for (int i = 0; i < zhengCaiOrZhengTaoHuaGanZhi.size(); i++) {
                // 判断流年干支是否为正财或正桃花
                if (liuNianGan.equals(zhengCaiOrZhengTaoHuaGanZhi.get(i)) || liuNianZhi.equals(zhengCaiOrZhengTaoHuaGanZhi.get(i))) {
                    // 判断流年干是否为正财
                    if (liuNianGan.equals(zhengCaiOrZhengTaoHuaGanZhi.get(i))) zhengCaiOrZhengTaoHuaList.add(getSiZhuGanZhiHeHua(liuNian, liuNianGan, true));
                    // 判断流年支是否为正财
                    if (liuNianZhi.equals(zhengCaiOrZhengTaoHuaGanZhi.get(i))) zhengCaiOrZhengTaoHuaList.add(getSiZhuGanZhiHeHua(liuNian, liuNianZhi, false));
                    break;
                }
                // 判断流年干支是否为偏财或偏桃花
                if (liuNianGan.equals(pianCaiOrPianTaoHuaGanZhi.get(i)) || liuNianZhi.equals(pianCaiOrPianTaoHuaGanZhi.get(i))) {
                    // 判断流年干是否为偏财
                    if (liuNianGan.equals(pianCaiOrPianTaoHuaGanZhi.get(i))) pianCaiOrZhengTaoHuaList.add(getSiZhuGanZhiHeHua(liuNian, liuNianGan, true));
                    // 判断流年支是否为偏财
                    if (liuNianZhi.equals(pianCaiOrPianTaoHuaGanZhi.get(i))) pianCaiOrZhengTaoHuaList.add(getSiZhuGanZhiHeHua(liuNian, liuNianZhi, false));
                }
            }
        }

    }

    /**
     * 判断并添加四柱干支与流年干支是否构成合化
     *
     * @param list            数据集合
     * @param liuNianGanOrZhi 流年天干或流年地支
     * @param heHuaType       合化计算方式（true:计算天干合化。false:计算地支合化）
     */
    protected List<String> getSiZhuGanZhiHeHua(List<String> list, String liuNianGanOrZhi, boolean heHuaType) {

        Map<String, String> tianGanXiangHeMap = BaZiGanZhiLiuYiMap.TIAN_GAN_XIANG_HE; // 天干相合（天干+天干为键）
        Map<String, String> diZhiLiuHeMap = BaZiGanZhiLiuYiMap.DI_ZHI_LIU_HE; // 地支六合（地支+地支为键）

        String heHua = "";
        if (heHuaType) {
            // 判断四柱天干与流年天干是否构成合化
            if (null != tianGanXiangHeMap.get(getYearGan() + liuNianGanOrZhi)) heHua = "公历" + list.get(0) + "年：年干[" + liuNianGanOrZhi + "]被年干[" + getYearGan() + "]合化(" + tianGanXiangHeMap.get(getYearGan() + liuNianGanOrZhi).substring(2) + ")";
            if (null != tianGanXiangHeMap.get(getMonthGan() + liuNianGanOrZhi)) heHua = "公历" + list.get(0) + "年：年干[" + liuNianGanOrZhi + "]被月干[" + getMonthGan() + "]合化(" + tianGanXiangHeMap.get(getMonthGan() + liuNianGanOrZhi).substring(2) + ")";
            if (null != tianGanXiangHeMap.get(getDayGan() + liuNianGanOrZhi)) heHua = "公历" + list.get(0) + "年：年干[" + liuNianGanOrZhi + "]被日干[" + getDayGan() + "]合化(" + tianGanXiangHeMap.get(getDayGan() + liuNianGanOrZhi).substring(2) + ")";
            if (null != tianGanXiangHeMap.get(getHourGan() + liuNianGanOrZhi)) heHua = "公历" + list.get(0) + "年：年干[" + liuNianGanOrZhi + "]被时干[" + getHourGan() + "]合化(" + tianGanXiangHeMap.get(getHourGan() + liuNianGanOrZhi).substring(2) + ")";
        } else {
            // 判断四柱地支与流年地支是否构成合化
            if (null != diZhiLiuHeMap.get(getYearZhi() + liuNianGanOrZhi)) heHua = "公历" + list.get(0) + "年：年支[" + liuNianGanOrZhi + "]被年支[" + getYearZhi() + "]合化(" + diZhiLiuHeMap.get(getYearZhi() + liuNianGanOrZhi).substring(2) + ")";
            if (null != diZhiLiuHeMap.get(getMonthZhi() + liuNianGanOrZhi)) heHua = "公历" + list.get(0) + "年：年支[" + liuNianGanOrZhi + "]被月支[" + getMonthZhi() + "]合化(" + diZhiLiuHeMap.get(getMonthZhi() + liuNianGanOrZhi).substring(2) + ")";
            if (null != diZhiLiuHeMap.get(getDayZhi() + liuNianGanOrZhi)) heHua = "公历" + list.get(0) + "年：年支[" + liuNianGanOrZhi + "]被日支[" + getDayZhi() + "]合化(" + diZhiLiuHeMap.get(getDayZhi() + liuNianGanOrZhi).substring(2) + ")";
            if (null != diZhiLiuHeMap.get(getHourZhi() + liuNianGanOrZhi)) heHua = "公历" + list.get(0) + "年：年支[" + liuNianGanOrZhi + "]被时支[" + getHourZhi() + "]合化(" + diZhiLiuHeMap.get(getHourZhi() + liuNianGanOrZhi).substring(2) + ")";
        }

        List<String> newList = new ArrayList<>(list);
        newList.add(heHua);

        return newList;

    }

//-------------------------------------------------------------------------------------------------------------------------------

    /**
     * 初始化神煞
     */
    protected void initializeShenSha() {

        if (this.baZiShenShaUtilStatus) return;

        this.baZiShenShaUtil = new BaZiShenShaUtil(this.baZiJiChuSetting.getSex(), getJiJie().substring(1, 2), getYearGanZhiNaYin().substring(2, 3), this.yearGanZhi, this.monthGanZhi,
                this.dayGanZhi, this.hourGanZhi, getTaiYuanGanZhi(), getTaiXiGanZhi(), getMingGongGanZhi(), getShenGongGanZhi(), CommonUtil.EMPTY2
        );

        this.baZiShenShaUtilStatus = true;

    }

    /**
     * 初始化流年
     */
    protected void initializeLiuNian() {

        if (this.liuNianStatus) return;

        // 1、计算大运
        List<List<String>> daYun = new ArrayList<>();
        int daYunLunShu = this.baZiJiChuSetting.getDaYunLunShu() == 0 ? 10 : this.baZiJiChuSetting.getDaYunLunShu();
        DaYun[] daYunSource = this.yun.getDaYun(daYunLunShu);
        for (DaYun dy : daYunSource) {
            daYun.add(new ArrayList<>(Arrays.asList(String.valueOf(dy.getStartYear()), String.valueOf(dy.getStartAge()), dy.getGanZhi())));
        }
        this.xiaoYunYearSum = Integer.parseInt(daYun.get(1).get(1)) - Integer.parseInt(daYun.get(0).get(1)); // 小运持续的年数

        // 2、计算流年
        List<List<String>> liuNian = new ArrayList<>();
        LiuNian[] liuNianSource;
        for (DaYun key : daYunSource) {
            liuNianSource = key.getLiuNian(10);
            for (LiuNian ln : liuNianSource) {
                liuNian.add(new ArrayList<>(Arrays.asList(String.valueOf(ln.getYear()), String.valueOf(ln.getAge()), ln.getGanZhi())));
            }
        }
        this.liuNian = liuNian;

        this.liuNianStatus = true;

    }

    /**
     * 初始化财运、桃花
     */
    protected void initializeCaiHua() {

        // 1、计算财运
        List<List<String>> zhengCaiList = new ArrayList<>(); // 保存正财信息
        List<List<String>> pianCaiList = new ArrayList<>(); // 保存偏财信息
        computeCaiHua(BaZiJiChuMap.RI_ZHU_ZHENG_CAI, BaZiJiChuMap.RI_ZHU_PIAN_CAI, zhengCaiList, pianCaiList); // 计算财运或桃花运相关信息
        this.zhengCaiYun = zhengCaiList; // 正财运年份、年龄、干支
        this.pianCaiYun = pianCaiList; // 偏财运年份、年龄、干支

        // 2、计算桃花运
        if ("男".equals(getSex())) {
            this.zhengTaoHuaYun = getZhengCaiYun(); // 正桃花年份、年龄、干支
            this.pianTaoHuaYun = getPianCaiYun(); // 偏桃花年份、年龄、干支
            return;
        }
        List<List<String>> zhengTaoHuaList = new ArrayList<>(); // 保存正桃花信息
        List<List<String>> pianTaoHuaList = new ArrayList<>(); // 保存偏桃花信息
        computeCaiHua(BaZiJiChuMap.NV_RI_ZHU_ZHENG_TAO_HUA, BaZiJiChuMap.NV_RI_ZHU_PIAN_TAO_HUA, zhengTaoHuaList, pianTaoHuaList); // 计算财运或桃花运相关信息
        this.zhengTaoHuaYun = zhengTaoHuaList; // 正桃花年份、年龄、干支
        this.pianTaoHuaYun = pianTaoHuaList; // 偏桃花年份、年龄、干支

    }


}
