package xuan.utils.bazi.utils;

import java.util.*;

import xuan.utils.bazi.maps.BaZiGanZhiLiuYiMap;
import xuan.utils.CommonUtil;

/**
 * 八字 - 干支留意工具
 *
 * @author 善待
 */
public class BaZiGanZhiLiuYiUtil {

    /**
     * 计算天干留意
     *
     * @param yearGan    年干
     * @param monthGan   月干
     * @param dayGan     日干
     * @param hourGan    时干
     * @param daYunGan   大运干
     * @param liuNianGan 流年干
     * @param liuYueGan  流月干
     * @param liuRiGan   流日干
     * @param liuShiGan  流时干
     */
    public static List<String> tanGanLiuYi(String yearGan, String monthGan, String dayGan, String hourGan, String daYunGan, String liuNianGan, String liuYueGan, String liuRiGan, String liuShiGan) {

        Set<String> set = new HashSet<>();

        addGanZhiLiuYi(yearGan, monthGan, dayGan, hourGan, daYunGan, liuNianGan, liuYueGan, liuRiGan, liuShiGan, set, BaZiGanZhiLiuYiMap.TIAN_GAN_XIANG_SHENG); // 天干相生
        addGanZhiLiuYi(yearGan, monthGan, dayGan, hourGan, daYunGan, liuNianGan, liuYueGan, liuRiGan, liuShiGan, set, BaZiGanZhiLiuYiMap.TIAN_GAN_XIANG_HE); // 天干相合
        addGanZhiLiuYi(yearGan, monthGan, dayGan, hourGan, daYunGan, liuNianGan, liuYueGan, liuRiGan, liuShiGan, set, BaZiGanZhiLiuYiMap.TIAN_GAN_XIANG_CHONG); // 天干相冲
        addGanZhiLiuYi(yearGan, monthGan, dayGan, hourGan, daYunGan, liuNianGan, liuYueGan, liuRiGan, liuShiGan, set, BaZiGanZhiLiuYiMap.TIAN_GAN_XIANG_KE); // 天干相克

        return CommonUtil.removeDuplicates(new ArrayList<>(set));

    }

    /**
     * 计算地支留意
     *
     * @param yearZhi    年支
     * @param monthZhi   月支
     * @param dayZhi     日支
     * @param hourZhi    时支
     * @param daYunZhi   大运支
     * @param liuNianZhi 流年支
     * @param liuYueZhi  流月支
     * @param liuRiZhi   流日支
     * @param liuShiZhi  流时支
     */
    public static List<String> diZhiLiuYi(String yearZhi, String monthZhi, String dayZhi, String hourZhi, String daYunZhi, String liuNianZhi, String liuYueZhi, String liuRiZhi, String liuShiZhi) {

        Set<String> set = new HashSet<>();

        addGanZhiLiuYi(yearZhi, monthZhi, dayZhi, hourZhi, daYunZhi, liuNianZhi, liuYueZhi, liuRiZhi, liuShiZhi, set, BaZiGanZhiLiuYiMap.DI_ZHI_BAN_HE); // 地支半合
        addGanZhiLiuYi(yearZhi, monthZhi, dayZhi, hourZhi, daYunZhi, liuNianZhi, liuYueZhi, liuRiZhi, liuShiZhi, set, BaZiGanZhiLiuYiMap.DI_ZHI_GONG_HE); // 地支拱合
        addGanZhiLiuYi(yearZhi, monthZhi, dayZhi, hourZhi, daYunZhi, liuNianZhi, liuYueZhi, liuRiZhi, liuShiZhi, set, BaZiGanZhiLiuYiMap.DI_ZHI_AN_HE); // 地支暗合
        addGanZhiLiuYi(yearZhi, monthZhi, dayZhi, hourZhi, daYunZhi, liuNianZhi, liuYueZhi, liuRiZhi, liuShiZhi, set, BaZiGanZhiLiuYiMap.DI_ZHI_LIU_HE); // 地支六合
        addGanZhiLiuYi(yearZhi, monthZhi, dayZhi, hourZhi, daYunZhi, liuNianZhi, liuYueZhi, liuRiZhi, liuShiZhi, set, BaZiGanZhiLiuYiMap.DI_ZHI_XIANG_XING); // 地支相刑
        addGanZhiLiuYi(yearZhi, monthZhi, dayZhi, hourZhi, daYunZhi, liuNianZhi, liuYueZhi, liuRiZhi, liuShiZhi, set, BaZiGanZhiLiuYiMap.DI_ZHI_XIANG_CHONG); // 地支相冲
        addGanZhiLiuYi(yearZhi, monthZhi, dayZhi, hourZhi, daYunZhi, liuNianZhi, liuYueZhi, liuRiZhi, liuShiZhi, set, BaZiGanZhiLiuYiMap.DI_ZHI_XIANG_PO); // 地支相破
        addGanZhiLiuYi(yearZhi, monthZhi, dayZhi, hourZhi, daYunZhi, liuNianZhi, liuYueZhi, liuRiZhi, liuShiZhi, set, BaZiGanZhiLiuYiMap.DI_ZHI_XIANG_HAI); // 地支相害

        return CommonUtil.removeDuplicates(new ArrayList<>(set));

    }

//===============================================================================================================================

    /**
     * 添加天干\地支留意
     *
     * @param yearGanOrZhi    年干\年支
     * @param monthGanOrZhi   月干\月支
     * @param dayGanOrZhi     日干\日支
     * @param hourGanOrZhi    时干\时支
     * @param daYunGanOrZhi   大运干\大运支
     * @param liuNianGanOrZhi 流年干\流年支
     * @param liuYueGanOrZhi  流月干\流月支
     * @param liuRiGanOrZhi   流日干\流日支
     * @param liuShiGanOrZhi  流时干\流时支
     * @param set             天干\地支组合
     * @param map             天干\地支关系
     */
    private static void addGanZhiLiuYi(String yearGanOrZhi, String monthGanOrZhi, String dayGanOrZhi, String hourGanOrZhi, String daYunGanOrZhi, String liuNianGanOrZhi, String liuYueGanOrZhi, String liuRiGanOrZhi, String liuShiGanOrZhi, Set<String> set, Map<String, String> map) {

        set.add(map.get(yearGanOrZhi + monthGanOrZhi));
        set.add(map.get(yearGanOrZhi + dayGanOrZhi));
        set.add(map.get(yearGanOrZhi + hourGanOrZhi));
        set.add(map.get(yearGanOrZhi + daYunGanOrZhi));
        set.add(map.get(yearGanOrZhi + liuNianGanOrZhi));
        set.add(map.get(yearGanOrZhi + liuYueGanOrZhi));
        set.add(map.get(yearGanOrZhi + liuRiGanOrZhi));
        set.add(map.get(yearGanOrZhi + liuShiGanOrZhi));

        set.add(map.get(monthGanOrZhi + yearGanOrZhi));
        set.add(map.get(monthGanOrZhi + dayGanOrZhi));
        set.add(map.get(monthGanOrZhi + hourGanOrZhi));
        set.add(map.get(monthGanOrZhi + daYunGanOrZhi));
        set.add(map.get(monthGanOrZhi + liuNianGanOrZhi));
        set.add(map.get(monthGanOrZhi + liuYueGanOrZhi));
        set.add(map.get(monthGanOrZhi + liuRiGanOrZhi));
        set.add(map.get(monthGanOrZhi + liuShiGanOrZhi));

        set.add(map.get(dayGanOrZhi + yearGanOrZhi));
        set.add(map.get(dayGanOrZhi + monthGanOrZhi));
        set.add(map.get(dayGanOrZhi + hourGanOrZhi));
        set.add(map.get(dayGanOrZhi + daYunGanOrZhi));
        set.add(map.get(dayGanOrZhi + liuNianGanOrZhi));
        set.add(map.get(dayGanOrZhi + liuYueGanOrZhi));
        set.add(map.get(dayGanOrZhi + liuRiGanOrZhi));
        set.add(map.get(dayGanOrZhi + liuShiGanOrZhi));

        set.add(map.get(hourGanOrZhi + yearGanOrZhi));
        set.add(map.get(hourGanOrZhi + monthGanOrZhi));
        set.add(map.get(hourGanOrZhi + dayGanOrZhi));
        set.add(map.get(hourGanOrZhi + daYunGanOrZhi));
        set.add(map.get(hourGanOrZhi + liuNianGanOrZhi));
        set.add(map.get(hourGanOrZhi + liuYueGanOrZhi));
        set.add(map.get(hourGanOrZhi + liuRiGanOrZhi));
        set.add(map.get(hourGanOrZhi + liuShiGanOrZhi));


        set.add(map.get(daYunGanOrZhi + yearGanOrZhi));
        set.add(map.get(daYunGanOrZhi + monthGanOrZhi));
        set.add(map.get(daYunGanOrZhi + dayGanOrZhi));
        set.add(map.get(daYunGanOrZhi + hourGanOrZhi));
        set.add(map.get(daYunGanOrZhi + liuNianGanOrZhi));
        set.add(map.get(daYunGanOrZhi + liuYueGanOrZhi));
        set.add(map.get(daYunGanOrZhi + liuRiGanOrZhi));
        set.add(map.get(daYunGanOrZhi + liuShiGanOrZhi));

        set.add(map.get(liuNianGanOrZhi + yearGanOrZhi));
        set.add(map.get(liuNianGanOrZhi + monthGanOrZhi));
        set.add(map.get(liuNianGanOrZhi + dayGanOrZhi));
        set.add(map.get(liuNianGanOrZhi + hourGanOrZhi));
        set.add(map.get(liuNianGanOrZhi + daYunGanOrZhi));
        set.add(map.get(liuNianGanOrZhi + liuYueGanOrZhi));
        set.add(map.get(liuNianGanOrZhi + liuRiGanOrZhi));
        set.add(map.get(liuNianGanOrZhi + liuShiGanOrZhi));

        set.add(map.get(liuYueGanOrZhi + yearGanOrZhi));
        set.add(map.get(liuYueGanOrZhi + monthGanOrZhi));
        set.add(map.get(liuYueGanOrZhi + dayGanOrZhi));
        set.add(map.get(liuYueGanOrZhi + hourGanOrZhi));
        set.add(map.get(liuYueGanOrZhi + daYunGanOrZhi));
        set.add(map.get(liuYueGanOrZhi + liuNianGanOrZhi));
        set.add(map.get(liuYueGanOrZhi + liuRiGanOrZhi));
        set.add(map.get(liuYueGanOrZhi + liuShiGanOrZhi));

        set.add(map.get(liuRiGanOrZhi + yearGanOrZhi));
        set.add(map.get(liuRiGanOrZhi + monthGanOrZhi));
        set.add(map.get(liuRiGanOrZhi + dayGanOrZhi));
        set.add(map.get(liuRiGanOrZhi + hourGanOrZhi));
        set.add(map.get(liuRiGanOrZhi + daYunGanOrZhi));
        set.add(map.get(liuRiGanOrZhi + liuNianGanOrZhi));
        set.add(map.get(liuRiGanOrZhi + liuYueGanOrZhi));
        set.add(map.get(liuRiGanOrZhi + liuShiGanOrZhi));

        set.add(map.get(liuShiGanOrZhi + yearGanOrZhi));
        set.add(map.get(liuShiGanOrZhi + monthGanOrZhi));
        set.add(map.get(liuShiGanOrZhi + dayGanOrZhi));
        set.add(map.get(liuShiGanOrZhi + hourGanOrZhi));
        set.add(map.get(liuShiGanOrZhi + daYunGanOrZhi));
        set.add(map.get(liuShiGanOrZhi + liuNianGanOrZhi));
        set.add(map.get(liuShiGanOrZhi + liuYueGanOrZhi));
        set.add(map.get(liuShiGanOrZhi + liuRiGanOrZhi));

    }


}
