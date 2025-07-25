package xuan.vo.bazi;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 八字数据响应数据
 *
 * @author 善待
 */
@Data
public class BaZiVo {

    /**
     * 公历日期
     */
    private Date solarDate;

    /**
     * 农历日期
     */
    private Date lunarDate;

    /**
     * 公历日期
     */
    private String solarStr;

    /**
     * 农历日期
     */
    private String lunarStr;


    /**
     * 姓名
     */
    private String name;

    /**
     * 占事
     */
    private String occupy;

    /**
     * 性别（男。女）
     */
    private String sex;

    /**
     * 造
     */
    private String zao;

    /**
     * 太岁类型
     */
    private String taiSuiType;

    /**
     * 星期
     */
    private String xingQi;

    /**
     * 季节
     */
    private String jiJie;

    /**
     * 生肖
     */
    private String shengXiao;

    /**
     * 年冲生肖
     */
    private String yearChongShengXiao;

    /**
     * 月冲生肖
     */
    private String monthChongShengXiao;

    /**
     * 日冲生肖
     */
    private String dayChongShengXiao;

    /**
     * 时冲生肖
     */
    private String hourChongShengXiao;

    /**
     * 星座
     */
    private String xingZuo;

    /**
     * 月相
     */
    private String yueXiang;

    /**
     * 月将
     */
    private String yueJiang;

    /**
     * 月将神
     */
    private String yueJiangShen;

    /**
     * 五不遇时
     */
    private boolean wuBuYuShi;


    /**
     * 值年九星属性
     */
    private String yearJiuXingAttribute;

    /**
     * 值月九星属性
     */
    private String monthJiuXingAttribute;

    /**
     * 值日九星属性
     */
    private String dayJiuXingAttribute;

    /**
     * 值时九星属性
     */
    private String hourJiuXingAttribute;


    /**
     * 值年玄空九星
     */
    private String yearJiuXingXuanKong;

    /**
     * 值月玄空九星
     */
    private String monthJiuXingXuanKong;

    /**
     * 值日玄空九星
     */
    private String dayJiuXingXuanKong;

    /**
     * 值时玄空九星
     */
    private String hourJiuXingXuanKong;


    /**
     * 值年北斗九星
     */
    private String yearJiuXingBeiDou;

    /**
     * 值月北斗九星
     */
    private String monthJiuXingBeiDou;

    /**
     * 值日北斗九星
     */
    private String dayJiuXingBeiDou;

    /**
     * 值时北斗九星
     */
    private String hourJiuXingBeiDou;


    /**
     * 值年奇门九星
     */
    private String yearJiuXingQiMen;

    /**
     * 值月奇门九星
     */
    private String monthJiuXingQiMen;

    /**
     * 值日奇门九星
     */
    private String dayJiuXingQiMen;

    /**
     * 值时奇门九星
     */
    private String hourJiuXingQiMen;


    /**
     * 值年太乙九星
     */
    private String yearJiuXingTaiYi;

    /**
     * 值月太乙九星
     */
    private String monthJiuXingTaiYi;

    /**
     * 值日太乙九星
     */
    private String dayJiuXingTaiYi;

    /**
     * 值时太乙九星
     */
    private String hourJiuXingTaiYi;


    /**
     * 八字
     */
    private List<String> baZi;

    /**
     * 八字五行
     */
    private List<String> baZiWuXing;

    /**
     * 八字空亡
     */
    private List<String> baZiKongWang;

    /**
     * 八字纳音
     */
    private List<String> baZiNaYin;


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
     * 年干五行
     */
    private String yearGanWuXing;

    /**
     * 月干五行
     */
    private String monthGanWuXing;

    /**
     * 日干五行
     */
    private String dayGanWuXing;

    /**
     * 时干五行
     */
    private String hourGanWuXing;

    /**
     * 胎元干五行
     */
    private String taiYuanGanWuXing;

    /**
     * 胎息干五行
     */
    private String taiXiGanWuXing;

    /**
     * 命宫干五行
     */
    private String mingGongGanWuXing;

    /**
     * 身宫干五行
     */
    private String shenGongGanWuXing;


    /**
     * 年支五行
     */
    private String yearZhiWuXing;

    /**
     * 月支五行
     */
    private String monthZhiWuXing;

    /**
     * 日支五行
     */
    private String dayZhiWuXing;

    /**
     * 时支五行
     */
    private String hourZhiWuXing;

    /**
     * 胎元支五行
     */
    private String taiYuanZhiWuXing;

    /**
     * 胎息支五行
     */
    private String taiXiZhiWuXing;

    /**
     * 命宫支五行
     */
    private String mingGongZhiWuXing;

    /**
     * 身宫支五行
     */
    private String shenGongZhiWuXing;


    /**
     * 年干支五行
     */
    private String yearGanZhiWuXing;

    /**
     * 月干支五行
     */
    private String monthGanZhiWuXing;

    /**
     * 日干支五行
     */
    private String dayGanZhiWuXing;

    /**
     * 时干支五行
     */
    private String hourGanZhiWuXing;

    /**
     * 胎元干支五行
     */
    private String taiYuanGanZhiWuXing;

    /**
     * 胎息干支五行
     */
    private String taiXiGanZhiWuXing;

    /**
     * 命宫干支五行
     */
    private String mingGongGanZhiWuXing;

    /**
     * 身宫干支五行
     */
    private String shenGongGanZhiWuXing;


    /**
     * 年干支纳音
     */
    private String yearGanZhiNaYin;

    /**
     * 月干支纳音
     */
    private String monthGanZhiNaYin;

    /**
     * 日干支纳音
     */
    private String dayGanZhiNaYin;

    /**
     * 时干支纳音
     */
    private String hourGanZhiNaYin;

    /**
     * 胎元干支纳音
     */
    private String taiYuanGanZhiNaYin;

    /**
     * 胎息干支纳音
     */
    private String taiXiGanZhiNaYin;

    /**
     * 命宫干支纳音
     */
    private String mingGongGanZhiNaYin;

    /**
     * 身宫干支纳音
     */
    private String shenGongGanZhiNaYin;


    /**
     * 年干支空亡
     */
    private String yearGanZhiKongWang;

    /**
     * 月干支空亡
     */
    private String monthGanZhiKongWang;

    /**
     * 日干支空亡
     */
    private String dayGanZhiKongWang;

    /**
     * 时干支空亡
     */
    private String hourGanZhiKongWang;

    /**
     * 胎元干支空亡
     */
    private String taiYuanGanZhiKongWang;

    /**
     * 胎息干支空亡
     */
    private String taiXiGanZhiKongWang;

    /**
     * 命宫干支空亡
     */
    private String mingGongGanZhiKongWang;

    /**
     * 身宫干支空亡
     */
    private String shenGongGanZhiKongWang;


    /**
     * 年干支主星
     */
    private String yearGanZhiZhuXing;

    /**
     * 月干支主星
     */
    private String monthGanZhiZhuXing;

    /**
     * 日干支主星
     */
    private String dayGanZhiZhuXing;

    /**
     * 时干支主星
     */
    private String hourGanZhiZhuXing;

    /**
     * 胎元干支主星
     */
    private String taiYuanGanZhiZhuXing;

    /**
     * 胎息干支主星
     */
    private String taiXiGanZhiZhuXing;

    /**
     * 命宫干支主星
     */
    private String mingGongGanZhiZhuXing;

    /**
     * 身宫干支主星
     */
    private String shenGongGanZhiZhuXing;


    /**
     * 年支藏干
     */
    private List<String> yearZhiCangGan;

    /**
     * 月支藏干
     */
    private List<String> monthZhiCangGan;

    /**
     * 日支藏干
     */
    private List<String> dayZhiCangGan;

    /**
     * 时支藏干
     */
    private List<String> hourZhiCangGan;

    /**
     * 胎元支藏干
     */
    private List<String> taiYuanZhiCangGan;

    /**
     * 胎息支藏干
     */
    private List<String> taiXiZhiCangGan;

    /**
     * 命宫支藏干
     */
    private List<String> mingGongZhiCangGan;

    /**
     * 身宫支藏干
     */
    private List<String> shenGongZhiCangGan;


    /**
     * 年支藏干五行
     */
    private List<String> yearZhiCangGanWuXing;

    /**
     * 月支藏干五行
     */
    private List<String> monthZhiCangGanWuXing;

    /**
     * 日支藏干五行
     */
    private List<String> dayZhiCangGanWuXing;

    /**
     * 时支藏干五行
     */
    private List<String> hourZhiCangGanWuXing;

    /**
     * 胎元支藏干五行
     */
    private List<String> taiYuanZhiCangGanWuXing;

    /**
     * 胎息支藏干五行
     */
    private List<String> taiXiZhiCangGanWuXing;

    /**
     * 命宫支藏干五行
     */
    private List<String> mingGongZhiCangGanWuXing;

    /**
     * 身宫支藏干五行
     */
    private List<String> shenGongZhiCangGanWuXing;


    /**
     * 年干支副星
     */
    private List<String> yearGanZhiFuXing;

    /**
     * 月干支副星
     */
    private List<String> monthGanZhiFuXing;

    /**
     * 日干支副星
     */
    private List<String> dayGanZhiFuXing;

    /**
     * 时干支副星
     */
    private List<String> hourGanZhiFuXing;

    /**
     * 胎元干支副星
     */
    private List<String> taiYuanGanZhiFuXing;

    /**
     * 胎息干支副星
     */
    private List<String> taiXiGanZhiFuXing;

    /**
     * 命宫干支副星
     */
    private List<String> mingGongGanZhiFuXing;

    /**
     * 身宫干支副星
     */
    private List<String> shenGongGanZhiFuXing;


    /**
     * 年干支自坐
     */
    private String yearGanZhiZiZuo;

    /**
     * 月干支自坐
     */
    private String monthGanZhiZiZuo;

    /**
     * 日干支自坐
     */
    private String dayGanZhiZiZuo;

    /**
     * 时干支自坐
     */
    private String hourGanZhiZiZuo;

    /**
     * 胎元干支自坐
     */
    private String taiYuanGanZhiZiZuo;

    /**
     * 胎息干支自坐
     */
    private String taiXiGanZhiZiZuo;

    /**
     * 命宫干支自坐
     */
    private String mingGongGanZhiZiZuo;

    /**
     * 身宫干支自坐
     */
    private String shenGongGanZhiZiZuo;


    /**
     * 年干支星运
     */
    private String yearGanZhiXingYun;

    /**
     * 月干支星运
     */
    private String monthGanZhiXingYun;

    /**
     * 日干支星运
     */
    private String dayGanZhiXingYun;

    /**
     * 时干支星运
     */
    private String hourGanZhiXingYun;

    /**
     * 胎元干支星运
     */
    private String taiYuanGanZhiXingYun;

    /**
     * 胎息干支星运
     */
    private String taiXiGanZhiXingYun;

    /**
     * 命宫干支星运
     */
    private String mingGongGanZhiXingYun;

    /**
     * 身宫干支星运
     */
    private String shenGongGanZhiXingYun;


    /**
     * 年干支神煞
     */
    private List<String> yearGanZhiShenSha;

    /**
     * 月干支神煞
     */
    private List<String> monthGanZhiShenSha;

    /**
     * 日干支神煞
     */
    private List<String> dayGanZhiShenSha;

    /**
     * 时干支神煞
     */
    private List<String> hourGanZhiShenSha;

    /**
     * 胎元干支神煞
     */
    private List<String> taiYuanGanZhiShenSha;

    /**
     * 胎息干支神煞
     */
    private List<String> taiXiGanZhiShenSha;

    /**
     * 命宫干支神煞
     */
    private List<String> mingGongGanZhiShenSha;

    /**
     * 身宫干支神煞
     */
    private List<String> shenGongGanZhiShenSha;


    /**
     * 五行木数量（不包含地支藏干）
     */
    private int wuXingMuCount;

    /**
     * 五行火数量（不包含地支藏干）
     */
    private int wuXingHuoCount;

    /**
     * 五行土数量（不包含地支藏干）
     */
    private int wuXingTuCount;

    /**
     * 五行金数量（不包含地支藏干）
     */
    private int wuXingJinCount;

    /**
     * 五行水数量（不包含地支藏干）
     */
    private int wuXingShuiCount;


    /**
     * 五行木数量（包含地支藏干）
     */
    private int wuXingMuCangGanCount;

    /**
     * 五行火数量（包含地支藏干）
     */
    private int wuXingHuoCangGanCount;

    /**
     * 五行土数量（包含地支藏干）
     */
    private int wuXingTuCangGanCount;

    /**
     * 五行金数量（包含地支藏干）
     */
    private int wuXingJinCangGanCount;

    /**
     * 五行水数量（包含地支藏干）
     */
    private int wuXingShuiCangGanCount;


    /**
     * 五行缺失
     */
    private List<String> wuXingQueShi;

    /**
     * 五行旺衰
     */
    private List<String> wuXingWangShuai;


    /**
     * 天干留意
     */
    private List<String> tianGanLiuYi;

    /**
     * 地支留意
     */
    private List<String> diZhiLiuYi;


    /**
     * 上一节
     */
    private String prevJie;

    /**
     * 上一节日期
     */
    private String prevJieDateStr;

    /**
     * 距上一节天数
     */
    private int prevJieDayNumber;


    /**
     * 下一节
     */
    private String nextJie;

    /**
     * 下一节日期
     */
    private String nextJieDateStr;

    /**
     * 距下一节天数
     */
    private int nextJieDayNumber;


    /**
     * 出生节气
     */
    private String chuShengJieQi;

    /**
     * 人元司令分野
     */
    private String renYuanSiLingFenYe;

    /**
     * 身体强弱
     */
    private String shenTiQiangRuo;

    /**
     * 喜用神
     */
    private List<String> xiYongShen;

    /**
     * 喜用神方位
     */
    private List<String> xiYongShenFangWei;

    /**
     * 骨重及批注
     */
    private List<String> guZhong;


    /**
     * 公历起运日期
     */
    private String solarQiYunDateStr;

    /**
     * 公历起运信息
     */
    private String solarQiYun;

    /**
     * 公历交运信息
     */
    private String solarJiaoYun;


    /**
     * 正财运年份、年龄、干支、合化
     */
    private List<List<String>> zhengCaiYun;

    /**
     * 偏财运年份、年龄、干支、合化
     */
    private List<List<String>> pianCaiYun;

    /**
     * 正桃花年份、年龄、干支、合化
     */
    private List<List<String>> zhengTaoHua;

    /**
     * 偏桃花年份、年龄、干支、合化
     */
    private List<List<String>> pianTaoHua;


    /**
     * 星宿
     */
    private String xingXiu;

    /**
     * 星宿吉凶
     */
    private String xiuJiXiong;

    /**
     * 星宿吉凶歌诀
     */
    private String xiuJiXiongGeJue;


    /**
     * 命卦
     */
    private String mingGua;

    /**
     * 日柱论命
     */
    private String riZhuLunMing;

    /**
     * 五行分析
     */
    private String wuXingFenXi;

    /**
     * 运势分析
     */
    private String yunShiFenXi;

    /**
     * 性格分析
     */
    private String xingGeFenXi;


}
