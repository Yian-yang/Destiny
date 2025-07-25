package xuan.vo.bazi;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 大运流年数据封装
 *
 * @author 善待
 */
@Data
public class BaZiDaYunLiuNianPackageVo implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * 干支（用于：大运、流年、小运、流月、流日、流时）
     */
    private String ganZhi;

    /**
     * 天干十神（用于：大运、流年、小运、流月、流日、流时）
     */
    private String tianShen;

    /**
     * 地支十神（用于：大运、流年、小运、流月、流日、流时）
     */
    private String diShen;

    /**
     * 自坐（用于：大运、流年、小运、流月、流日、流时）
     */
    private String ziZuo;

    /**
     * 星运（用于：大运、流年、小运、流月、流日、流时）
     */
    private String xingYun;

    /**
     * 公历日期（用于：大运、流年、小运、流月、流日、流时）
     */
    private String solarDate;

    /**
     * 藏干（用于：大运、流年、小运、流月、流日、流时）
     */
    private String cangGan;

    /**
     * 副星（用于：大运、流年、小运、流月、流日、流时）
     */
    private String fuXing;

    /**
     * 空亡（用于：大运、流年、小运、流月、流日、流时）
     */
    private String kongWang;

    /**
     * 纳音（用于：大运、流年、小运、流月、流日、流时）
     */
    private String naYin;

    /**
     * 神煞（用于：大运、流年、小运、流月、流日、流时）
     */
    private String shenSha;


    /**
     * 公历年（用于：大运、流年、小运、流月）
     */
    private String solarYear;

    /**
     * 年龄（用于：大运、流年、小运、流月）
     */
    private String age;

    /**
     * 公历几月几日（用于：流月）
     */
    private String solarMonthDay;

    /**
     * 十二节农历月（用于：流月）
     */
    private String lunarMonth;

    /**
     * 十二节（用于：流月）
     */
    private String shiErJie;

    /**
     * 公历日（用于：流日）
     */
    private String solarDay;

    /**
     * 农历日（用于：流日）
     */
    private String lunarDay;

    /**
     * 公历时（用于：流时）
     */
    private String solarHour;

    /**
     * 十二时辰汉代命名（用于：流时）
     */
    private String shiErShiChenHaMing;

//----------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 大运封装
     *
     * @param daYun 大运（干支、天干十神、地支十神、自坐、星运、公历日期、公历年、年龄、藏干、副星、空亡、纳音、神煞）
     */
    public static List<BaZiDaYunLiuNianPackageVo> daYunPackage(List<List<String>> daYun) {

        List<BaZiDaYunLiuNianPackageVo> lists = new ArrayList<>();

        for (List<String> item : daYun) {
            BaZiDaYunLiuNianPackageVo vo = new BaZiDaYunLiuNianPackageVo();
            vo.setGanZhi(item.get(0)); // 干支
            vo.setTianShen(item.get(1)); // 天干十神
            vo.setDiShen(item.get(2)); // 地支十神
            vo.setZiZuo(item.get(3)); // 自坐
            vo.setXingYun(item.get(4)); // 星运
            vo.setSolarDate(item.get(5)); // 公历日期
            vo.setSolarYear(item.get(6)); // 公历年
            vo.setAge(item.get(7)); // 年龄
            vo.setCangGan(item.get(8)); // 藏干
            vo.setFuXing(item.get(9)); // 副星
            vo.setKongWang(item.get(10)); // 空亡
            vo.setNaYin(item.get(11)); // 纳音
            vo.setShenSha(item.get(12)); // 神煞
            lists.add(vo);
        }

        return lists;

    }

    /**
     * 流年封装
     *
     * @param liuNian 流年（干支、天干十神、地支十神、自坐、星运、公历日期、公历年、年龄、藏干、副星、空亡、纳音、神煞）
     */
    public static List<BaZiDaYunLiuNianPackageVo> liuNianPackage(List<List<String>> liuNian) {

        List<BaZiDaYunLiuNianPackageVo> lists = new ArrayList<>();

        for (List<String> item : liuNian) {
            BaZiDaYunLiuNianPackageVo vo = new BaZiDaYunLiuNianPackageVo();
            vo.setGanZhi(item.get(0)); // 干支
            vo.setTianShen(item.get(1)); // 天干十神
            vo.setDiShen(item.get(2)); // 地支十神
            vo.setZiZuo(item.get(3)); // 自坐
            vo.setXingYun(item.get(4)); // 星运
            vo.setSolarDate(item.get(5)); // 公历日期
            vo.setSolarYear(item.get(6)); // 公历年
            vo.setAge(item.get(7)); // 年龄
            vo.setCangGan(item.get(8)); // 藏干
            vo.setFuXing(item.get(9)); // 副星
            vo.setKongWang(item.get(10)); // 空亡
            vo.setNaYin(item.get(11)); // 纳音
            vo.setShenSha(item.get(12)); // 神煞
            lists.add(vo);
        }

        return lists;

    }

    /**
     * 小运封装
     *
     * @param xiaoYun 小运（干支、天干十神、地支十神、自坐、星运、公历日期、公历年、年龄、藏干、副星、空亡、纳音、神煞）
     */
    public static List<BaZiDaYunLiuNianPackageVo> xiaoYunPackage(List<List<String>> xiaoYun) {

        List<BaZiDaYunLiuNianPackageVo> lists = new ArrayList<>();

        for (List<String> item : xiaoYun) {
            BaZiDaYunLiuNianPackageVo vo = new BaZiDaYunLiuNianPackageVo();
            vo.setGanZhi(item.get(0)); // 干支
            vo.setTianShen(item.get(1)); // 天干十神
            vo.setDiShen(item.get(2)); // 地支十神
            vo.setZiZuo(item.get(3)); // 自坐
            vo.setXingYun(item.get(4)); // 星运
            vo.setSolarDate(item.get(5)); // 公历日期
            vo.setSolarYear(item.get(6)); // 公历年
            vo.setAge(item.get(7)); // 年龄
            vo.setCangGan(item.get(8)); // 藏干
            vo.setFuXing(item.get(9)); // 副星
            vo.setKongWang(item.get(10)); // 空亡
            vo.setNaYin(item.get(11)); // 纳音
            vo.setShenSha(item.get(12)); // 神煞
            lists.add(vo);
        }

        return lists;

    }

    /**
     * 流月封装
     *
     * @param liuYue 流月（干支、天干十神、地支十神、自坐、星运、公历日期、公历几月几日、十二节、藏干、副星、空亡、纳音、神煞）
     */
    public static List<BaZiDaYunLiuNianPackageVo> liuYuePackage(List<List<String>> liuYue) {

        List<BaZiDaYunLiuNianPackageVo> lists = new ArrayList<>();

        for (List<String> item : liuYue) {
            BaZiDaYunLiuNianPackageVo vo = new BaZiDaYunLiuNianPackageVo();
            vo.setGanZhi(item.get(0)); // 干支
            vo.setTianShen(item.get(1)); // 天干十神
            vo.setDiShen(item.get(2)); // 地支十神
            vo.setZiZuo(item.get(3)); // 自坐
            vo.setXingYun(item.get(4)); // 星运
            vo.setSolarDate(item.get(5)); // 公历日期
            vo.setSolarMonthDay(item.get(6)); // 公历几月几日
            vo.setLunarMonth(item.get(7)); // 十二节农历月
            vo.setShiErJie(item.get(8)); // 十二节
            vo.setCangGan(item.get(9)); // 藏干
            vo.setFuXing(item.get(10)); // 副星
            vo.setKongWang(item.get(11)); // 空亡
            vo.setNaYin(item.get(12)); // 纳音
            vo.setShenSha(item.get(13)); // 神煞
            lists.add(vo);
        }

        return lists;

    }

    /**
     * 流日封装
     *
     * @param liuRi 流日（干支、天干十神、地支十神、自坐、星运、公历日期、农历日、藏干、副星、空亡、纳音、神煞）
     */
    public static List<BaZiDaYunLiuNianPackageVo> liuRiPackage(List<List<String>> liuRi) {

        List<BaZiDaYunLiuNianPackageVo> lists = new ArrayList<>();

        for (List<String> item : liuRi) {
            BaZiDaYunLiuNianPackageVo vo = new BaZiDaYunLiuNianPackageVo();
            vo.setGanZhi(item.get(0)); // 干支
            vo.setTianShen(item.get(1)); // 天干十神
            vo.setDiShen(item.get(2)); // 地支十神
            vo.setZiZuo(item.get(3)); // 自坐
            vo.setXingYun(item.get(4)); // 星运
            vo.setSolarDate(item.get(5)); // 公历日期
            vo.setSolarDay(item.get(6)); // 公历日
            vo.setLunarDay(item.get(7)); // 农历日
            vo.setCangGan(item.get(8)); // 藏干
            vo.setFuXing(item.get(9)); // 副星
            vo.setKongWang(item.get(10)); // 空亡
            vo.setNaYin(item.get(11)); // 纳音
            vo.setShenSha(item.get(12)); // 神煞
            lists.add(vo);
        }

        return lists;

    }

    /**
     * 流时封装
     *
     * @param liuShi 流时（干支、天干十神、地支十神、自坐、星运、公历日期、公历时、汉代命名、藏干、副星、空亡、纳音、神煞）
     */
    public static List<BaZiDaYunLiuNianPackageVo> liuShiPackage(List<List<String>> liuShi) {

        List<BaZiDaYunLiuNianPackageVo> lists = new ArrayList<>();

        for (List<String> item : liuShi) {
            BaZiDaYunLiuNianPackageVo vo = new BaZiDaYunLiuNianPackageVo();
            vo.setGanZhi(item.get(0)); // 干支
            vo.setTianShen(item.get(1)); // 天干十神
            vo.setDiShen(item.get(2)); // 地支十神
            vo.setZiZuo(item.get(3)); // 自坐
            vo.setXingYun(item.get(4)); // 星运
            vo.setSolarDate(item.get(5)); // 公历日期
            vo.setSolarHour(item.get(6)); // 公历时
            vo.setShiErShiChenHaMing(item.get(7)); // 汉代命名
            vo.setCangGan(item.get(8)); // 藏干
            vo.setFuXing(item.get(9)); // 副星
            vo.setKongWang(item.get(10)); // 空亡
            vo.setNaYin(item.get(11)); // 纳音
            vo.setShenSha(item.get(12)); // 神煞
            lists.add(vo);
        }

        return lists;

    }


}
