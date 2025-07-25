package xuan.vo.liuyao;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 六爻数据响应数据
 *
 * @author 善待
 */
@Data
public class LiuYaoVo {

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
     * 神煞
     */
    private Map<String, String> shenSha;

    /**
     * 初始六爻爻象标识
     */
    private List<String> liuYaoAsMark;


    /**
     * 六爻爻象
     */
    private List<String> liuYaoAs;

    /**
     * 六爻爻象标识
     */
    private List<String> liuYaoYaoXiangMark;

    /**
     * 六爻爻象标识名称
     */
    private List<String> liuYaoYaoXiangMarkName;


    /**
     * 上卦卦名
     */
    private String shangGuaName;

    /**
     * 下卦卦名
     */
    private String xiaGuaName;

    /**
     * 本卦卦名
     */
    private String benGuaName;

    /**
     * 变卦卦名
     */
    private String bianGuaName;

    /**
     * 互卦卦名
     */
    private String huGuaName;

    /**
     * 错卦卦名
     */
    private String cuoGuaName;

    /**
     * 综卦卦名
     */
    private String zongGuaName;

    /**
     * 伏卦卦名
     */
    private String fuGuaName;


    /**
     * 上卦卦象
     */
    private String shangGuaAs;

    /**
     * 下卦卦象
     */
    private String xiaGuaAs;

    /**
     * 本卦卦象
     */
    private String benGuaAs;

    /**
     * 变卦卦象
     */
    private String bianGuaAs;

    /**
     * 互卦卦象
     */
    private String huGuaAs;

    /**
     * 错卦卦象
     */
    private String cuoGuaAs;

    /**
     * 综卦卦象
     */
    private String zongGuaAs;

    /**
     * 伏卦卦象
     */
    private String fuGuaAs;


    /**
     * 本卦类型
     */
    private String benGuaType;

    /**
     * 变卦类型
     */
    private String bianGuaType;

    /**
     * 互卦类型
     */
    private String huGuaType;

    /**
     * 错卦类型
     */
    private String cuoGuaType;

    /**
     * 综卦类型
     */
    private String zongGuaType;

    /**
     * 伏卦类型
     */
    private String fuGuaType;


    /**
     * 本卦卦身
     */
    private String benGuaGuaShen;

    /**
     * 变卦卦身
     */
    private String bianGuaGuaShen;

    /**
     * 互卦卦身
     */
    private String huGuaGuaShen;

    /**
     * 错卦卦身
     */
    private String cuoGuaGuaShen;

    /**
     * 综卦卦身
     */
    private String zongGuaGuaShen;

    /**
     * 伏卦卦身
     */
    private String fuGuaGuaShen;


    /**
     * 本卦卦辞
     */
    private String benGuaGuaCi;

    /**
     * 变卦卦辞
     */
    private String bianGuaGuaCi;

    /**
     * 互卦卦辞
     */
    private String huGuaGuaCi;

    /**
     * 错卦卦辞
     */
    private String cuoGuaGuaCi;

    /**
     * 综卦卦辞
     */
    private String zongGuaGuaCi;

    /**
     * 伏卦卦辞
     */
    private String fuGuaGuaCi;


    /**
     * 本卦六爻爻名
     */
    private List<String> benGuaLiuYaoName;

    /**
     * 变卦六爻爻名
     */
    private List<String> bianGuaLiuYaoName;

    /**
     * 互卦六爻爻名
     */
    private List<String> huGuaLiuYaoName;

    /**
     * 错卦六爻爻名
     */
    private List<String> cuoGuaLiuYaoName;

    /**
     * 综卦六爻爻名
     */
    private List<String> zongGuaLiuYaoName;

    /**
     * 伏卦六爻爻名
     */
    private List<String> fuGuaLiuYaoName;


    /**
     * 本卦六爻爻象
     */
    private List<String> benGuaLiuYaoAs;

    /**
     * 变卦六爻爻象
     */
    private List<String> bianGuaLiuYaoAs;

    /**
     * 互卦六爻爻象
     */
    private List<String> huGuaLiuYaoAs;

    /**
     * 错卦六爻爻象
     */
    private List<String> cuoGuaLiuYaoAs;

    /**
     * 综卦六爻爻象
     */
    private List<String> zongGuaLiuYaoAs;

    /**
     * 伏卦六爻爻象
     */
    private List<String> fuGuaLiuYaoAs;


    /**
     * 本卦六爻世应
     */
    private List<String> benGuaLiuYaoShiYing;

    /**
     * 变卦六爻世应
     */
    private List<String> bianGuaLiuYaoShiYing;

    /**
     * 互卦六爻世应
     */
    private List<String> huGuaLiuYaoShiYing;

    /**
     * 错卦六爻世应
     */
    private List<String> cuoGuaLiuYaoShiYing;

    /**
     * 综卦六爻世应
     */
    private List<String> zongGuaLiuYaoShiYing;

    /**
     * 伏卦六爻世应
     */
    private List<String> fuGuaLiuYaoShiYing;


    /**
     * 本卦六爻六亲
     */
    private List<String> benGuaLiuYaoLiuQin;

    /**
     * 变卦六爻六亲
     */
    private List<String> bianGuaLiuYaoLiuQin;

    /**
     * 互卦六爻六亲
     */
    private List<String> huGuaLiuYaoLiuQin;

    /**
     * 错卦六爻六亲
     */
    private List<String> cuoGuaLiuYaoLiuQin;

    /**
     * 综卦六爻六亲
     */
    private List<String> zongGuaLiuYaoLiuQin;

    /**
     * 伏卦六爻六亲
     */
    private List<String> fuGuaLiuYaoLiuQin;


    /**
     * 本卦六爻干支
     */
    private List<String> benGuaLiuYaoGanZhi;

    /**
     * 变卦六爻干支
     */
    private List<String> bianGuaLiuYaoGanZhi;

    /**
     * 互卦六爻干支
     */
    private List<String> huGuaLiuYaoGanZhi;

    /**
     * 错卦六爻干支
     */
    private List<String> cuoGuaLiuYaoGanZhi;

    /**
     * 综卦六爻干支
     */
    private List<String> zongGuaLiuYaoGanZhi;

    /**
     * 伏卦六爻干支
     */
    private List<String> fuGuaLiuYaoGanZhi;


    /**
     * 本卦六爻五行
     */
    private List<String> benGuaLiuYaoWuXing;

    /**
     * 变卦六爻五行
     */
    private List<String> bianGuaLiuYaoWuXing;

    /**
     * 互卦六爻五行
     */
    private List<String> huGuaLiuYaoWuXing;

    /**
     * 错卦六爻五行
     */
    private List<String> cuoGuaLiuYaoWuXing;

    /**
     * 综卦六爻五行
     */
    private List<String> zongGuaLiuYaoWuXing;

    /**
     * 伏卦六爻五行
     */
    private List<String> fuGuaLiuYaoWuXing;


    /**
     * 本卦六爻六神
     */
    private List<String> benGuaLiuYaoLiuShen;

    /**
     * 变卦六爻六神
     */
    private List<String> bianGuaLiuYaoLiuShen;

    /**
     * 互卦六爻六神
     */
    private List<String> huGuaLiuYaoLiuShen;

    /**
     * 错卦六爻六神
     */
    private List<String> cuoGuaLiuYaoLiuShen;

    /**
     * 综卦六爻六神
     */
    private List<String> zongGuaLiuYaoLiuShen;

    /**
     * 伏卦六爻六神
     */
    private List<String> fuGuaLiuYaoLiuShen;


    /**
     * 本卦六爻爻辞
     */
    private List<String> benGuaLiuYaoYaoCi;

    /**
     * 变卦六爻爻辞
     */
    private List<String> bianGuaLiuYaoYaoCi;

    /**
     * 互卦六爻爻辞
     */
    private List<String> huGuaLiuYaoYaoCi;

    /**
     * 错卦六爻爻辞
     */
    private List<String> cuoGuaLiuYaoYaoCi;

    /**
     * 综卦六爻爻辞
     */
    private List<String> zongGuaLiuYaoYaoCi;

    /**
     * 伏卦六爻爻辞
     */
    private List<String> fuGuaLiuYaoYaoCi;


    /**
     * 本卦六爻纳音
     */
    private List<String> benGuaLiuYaoNaYin;

    /**
     * 变卦六爻纳音
     */
    private List<String> bianGuaLiuYaoNaYin;

    /**
     * 互卦六爻纳音
     */
    private List<String> huGuaLiuYaoNaYin;

    /**
     * 错卦六爻纳音
     */
    private List<String> cuoGuaLiuYaoNaYin;

    /**
     * 综卦六爻纳音
     */
    private List<String> zongGuaLiuYaoNaYin;

    /**
     * 伏卦六爻纳音
     */
    private List<String> fuGuaLiuYaoNaYin;

    /**
     * 伏卦六爻伏神
     */
    private List<String> fuGuaLiuYaoFuShen;


}
