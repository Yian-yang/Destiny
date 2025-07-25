package xuan.controller.bazi;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xuan.configuration.result.ResponseResult;
import xuan.configuration.result.ResponseResultEnum;
import xuan.dto.bazi.*;
import xuan.utils.bazi.BaZi;
import xuan.utils.bazi.settings.BaZiJiChuSetting;
import xuan.utils.bazi.utils.BaZiDaYunLiuNianUtil;
import xuan.utils.bazi.utils.BaZiGanZhiLiuYiUtil;
import xuan.utils.CommonUtil;
import xuan.utils.DateUtil;
import xuan.vo.bazi.BaZiDaYunLiuNianPackageVo;
import xuan.vo.bazi.*;

import java.util.*;

/**
 * 八字排盘Controller
 *
 * @author 善待
 */
@RestController
@RequestMapping("/baZi")
public class BaZiController {

    /**
     * 开始排盘
     *
     * @param dto 八字请求数据
     * @return 数据
     */
    @PostMapping("/paiPan")
    public ResponseResult<BaZiVo> paiPan(@RequestBody BaZiDto dto) {

        // 1、拷贝八字基础设置
        BaZiJiChuSetting setting = new BaZiJiChuSetting();
        BeanUtils.copyProperties(dto, setting);

        // 2、排盘
        BaZi baZi = new BaZi(setting);

        // 3、设置数据
        BaZiVo vo = new BaZiVo();
//        BeanUtils.copyProperties(baZi, vo); // 最新版本不再支持拷贝
        vo.setSolarDate(baZi.getSolarDate()); // 公历日期
        vo.setLunarDate(baZi.getLunarDate()); // 农历日期
        vo.setSolarStr(baZi.getSolarStr()); // 公历日期
        vo.setLunarStr(baZi.getLunarStr()); // 农历日期
        vo.setName(baZi.getName()); // 姓名
        vo.setSex(baZi.getSex()); // 性别
        vo.setOccupy(baZi.getOccupy()); // 占事
        vo.setZao(baZi.getZao()); // 造
        vo.setTaiSuiType(baZi.getTaiSuiType()); // 太岁类型
        vo.setXingQi(baZi.getXingQi()); // 星期
        vo.setJiJie(baZi.getJiJie()); // 季节
        vo.setShengXiao(baZi.getShengXiao()); // 生肖
        vo.setYearChongShengXiao(baZi.getYearChongShengXiao()); // 年冲生肖
        vo.setMonthChongShengXiao(baZi.getMonthChongShengXiao()); // 月冲生肖
        vo.setDayChongShengXiao(baZi.getDayChongShengXiao()); // 日冲生肖
        vo.setHourChongShengXiao(baZi.getHourChongShengXiao()); // 时冲生肖
        vo.setXingZuo(baZi.getXingZuo()); // 星座
        vo.setYueXiang(baZi.getYueXiang()); // 月相
        vo.setYueJiang(baZi.getYueJiang()); // 月将
        vo.setYueJiangShen(baZi.getYueJiangShen()); // 月将神
        vo.setWuBuYuShi(baZi.getWuBuYuShi()); // 五不遇时
        vo.setYearJiuXingAttribute("方位在" + baZi.getYearJiuXingFangWeiMiaoShu() + "，落" + baZi.getYearJiuXingFangWei() + "宫，五行属" + baZi.getYearJiuXingWuXing()); // 值年九星属性
        vo.setMonthJiuXingAttribute("方位在" + baZi.getMonthJiuXingFangWeiMiaoShu() + "，落" + baZi.getMonthJiuXingFangWei() + "宫，五行属" + baZi.getMonthJiuXingWuXing()); // 值月九星属性
        vo.setDayJiuXingAttribute("方位在" + baZi.getDayJiuXingFangWeiMiaoShu() + "，落" + baZi.getDayJiuXingFangWei() + "宫，五行属" + baZi.getDayJiuXingWuXing()); // 值日九星属性
        vo.setHourJiuXingAttribute("方位在" + baZi.getHourJiuXingFangWeiMiaoShu() + "，落" + baZi.getHourJiuXingFangWei() + "宫，五行属" + baZi.getHourJiuXingWuXing()); // 值时九星属性
        vo.setYearJiuXingXuanKong(baZi.getYearJiuXingXuanKong()); // 值年玄空九星
        vo.setMonthJiuXingXuanKong(baZi.getMonthJiuXingXuanKong()); // 值月玄空九星
        vo.setDayJiuXingXuanKong(baZi.getDayJiuXingXuanKong()); // 值日玄空九星
        vo.setHourJiuXingXuanKong(baZi.getHourJiuXingXuanKong()); // 值时玄空九星
        vo.setYearJiuXingBeiDou(baZi.getYearJiuXingBeiDou()); // 值年北斗九星
        vo.setMonthJiuXingBeiDou(baZi.getMonthJiuXingBeiDou()); // 值月北斗九星
        vo.setDayJiuXingBeiDou(baZi.getDayJiuXingBeiDou()); // 值日北斗九星
        vo.setHourJiuXingBeiDou(baZi.getHourJiuXingBeiDou()); // 值时北斗九星
        vo.setYearJiuXingQiMen(baZi.getYearJiuXingQiMen()); // 值年奇门九星
        vo.setMonthJiuXingQiMen(baZi.getMonthJiuXingQiMen()); // 值月奇门九星
        vo.setDayJiuXingQiMen(baZi.getDayJiuXingQiMen()); // 值日奇门九星
        vo.setHourJiuXingQiMen(baZi.getHourJiuXingQiMen()); // 值时奇门九星
        vo.setYearJiuXingTaiYi(baZi.getYearJiuXingTaiYi()); // 值年太乙九星
        vo.setMonthJiuXingTaiYi(baZi.getMonthJiuXingTaiYi()); // 值月太乙九星
        vo.setDayJiuXingTaiYi(baZi.getDayJiuXingTaiYi()); // 值日太乙九星
        vo.setHourJiuXingTaiYi(baZi.getHourJiuXingTaiYi()); // 值时太乙九星
        vo.setBaZi(baZi.getBaZi()); // 八字
        vo.setBaZiWuXing(baZi.getBaZiWuXing()); // 八字五行
        vo.setBaZiKongWang(baZi.getBaZiKongWang()); // 八字空亡
        vo.setBaZiNaYin(baZi.getBaZiNaYin()); // 八字纳音
        vo.setYearGan(baZi.getYearGan()); // 年干
        vo.setMonthGan(baZi.getMonthGan()); // 月干
        vo.setDayGan(baZi.getDayGan()); // 日干
        vo.setHourGan(baZi.getHourGan()); // 时干
        vo.setTaiYuanGan(baZi.getTaiYuanGan()); // 胎元干
        vo.setTaiXiGan(baZi.getTaiXiGan()); // 胎息干
        vo.setMingGongGan(baZi.getMingGongGan()); // 命宫干
        vo.setShenGongGan(baZi.getShenGongGan()); // 身宫干
        vo.setYearZhi(baZi.getYearZhi()); // 年支
        vo.setMonthZhi(baZi.getMonthZhi()); // 月支
        vo.setDayZhi(baZi.getDayZhi()); // 日支
        vo.setHourZhi(baZi.getHourZhi()); // 时支
        vo.setTaiYuanZhi(baZi.getTaiYuanZhi()); // 胎元支
        vo.setTaiXiZhi(baZi.getTaiXiZhi()); // 胎息支
        vo.setMingGongZhi(baZi.getMingGongZhi()); // 命宫支
        vo.setShenGongZhi(baZi.getShenGongZhi()); // 身宫支
        vo.setYearGanZhi(baZi.getYearGanZhi()); // 年干支
        vo.setMonthGanZhi(baZi.getMonthGanZhi()); // 月干支
        vo.setDayGanZhi(baZi.getDayGanZhi()); // 日干支
        vo.setHourGanZhi(baZi.getHourGanZhi()); // 时干支
        vo.setTaiYuanGanZhi(baZi.getTaiYuanGanZhi()); // 胎元干支
        vo.setTaiXiGanZhi(baZi.getTaiXiGanZhi()); // 胎息干支
        vo.setMingGongGanZhi(baZi.getMingGongGanZhi()); // 命宫干支
        vo.setShenGongGanZhi(baZi.getShenGongGanZhi()); // 身宫干支
        vo.setYearGanWuXing(baZi.getYearGanWuXing()); // 年干五行
        vo.setMonthGanWuXing(baZi.getMonthGanWuXing()); // 月干五行
        vo.setDayGanWuXing(baZi.getDayGanWuXing()); // 日干五行
        vo.setHourGanWuXing(baZi.getHourGanWuXing()); // 时干五行
        vo.setTaiYuanGanWuXing(baZi.getTaiYuanGanWuXing()); // 胎元干五行
        vo.setTaiXiGanWuXing(baZi.getTaiXiGanWuXing()); // 胎息干五行
        vo.setMingGongGanWuXing(baZi.getMingGongGanWuXing()); // 命宫干五行
        vo.setShenGongGanWuXing(baZi.getShenGongGanWuXing()); // 身宫干五行
        vo.setYearZhiWuXing(baZi.getYearZhiWuXing()); // 年支五行
        vo.setMonthZhiWuXing(baZi.getMonthZhiWuXing()); // 月支五行
        vo.setDayZhiWuXing(baZi.getDayZhiWuXing()); // 日支五行
        vo.setHourZhiWuXing(baZi.getHourZhiWuXing()); // 时支五行
        vo.setTaiYuanZhiWuXing(baZi.getTaiYuanZhiWuXing()); // 胎元支五行
        vo.setTaiXiZhiWuXing(baZi.getTaiXiZhiWuXing()); // 胎息支五行
        vo.setMingGongZhiWuXing(baZi.getMingGongZhiWuXing()); // 命宫支五行
        vo.setShenGongZhiWuXing(baZi.getShenGongZhiWuXing()); // 身宫支五行
        vo.setYearGanZhiWuXing(baZi.getYearGanZhiWuXing()); // 年干支五行
        vo.setMonthGanZhiWuXing(baZi.getMonthGanZhiWuXing()); // 月干支五行
        vo.setDayGanZhiWuXing(baZi.getDayGanZhiWuXing()); // 日干支五行
        vo.setHourGanZhiWuXing(baZi.getHourGanZhiWuXing()); // 时干支五行
        vo.setTaiYuanGanZhiWuXing(baZi.getTaiYuanGanZhiWuXing()); // 胎元干支五行
        vo.setTaiXiGanZhiWuXing(baZi.getTaiXiGanZhiWuXing()); // 胎息干支五行
        vo.setMingGongGanZhiWuXing(baZi.getMingGongGanZhiWuXing()); // 命宫干支五行
        vo.setShenGongGanZhiWuXing(baZi.getShenGongGanZhiWuXing()); // 身宫干支五行
        vo.setYearGanZhiNaYin(baZi.getYearGanZhiNaYin()); // 年干支纳音
        vo.setMonthGanZhiNaYin(baZi.getMonthGanZhiNaYin()); // 月干支纳音
        vo.setDayGanZhiNaYin(baZi.getDayGanZhiNaYin()); // 日干支纳音
        vo.setHourGanZhiNaYin(baZi.getHourGanZhiNaYin()); // 时干支纳音
        vo.setTaiYuanGanZhiNaYin(baZi.getTaiYuanGanZhiNaYin()); // 胎元干支纳音
        vo.setTaiXiGanZhiNaYin(baZi.getTaiXiGanZhiNaYin()); // 胎息干支纳音
        vo.setMingGongGanZhiNaYin(baZi.getMingGongGanZhiNaYin()); // 命宫干支纳音
        vo.setShenGongGanZhiNaYin(baZi.getShenGongGanZhiNaYin()); // 身宫干支纳音
        vo.setYearGanZhiKongWang(baZi.getYearGanZhiKongWang()); // 年干支空亡
        vo.setMonthGanZhiKongWang(baZi.getMonthGanZhiKongWang()); // 月干支空亡
        vo.setDayGanZhiKongWang(baZi.getDayGanZhiKongWang()); // 日干支空亡
        vo.setHourGanZhiKongWang(baZi.getHourGanZhiKongWang()); // 时干支空亡
        vo.setTaiYuanGanZhiKongWang(baZi.getTaiYuanGanZhiKongWang()); // 胎元干支空亡
        vo.setTaiXiGanZhiKongWang(baZi.getTaiXiGanZhiKongWang()); // 胎息干支空亡
        vo.setMingGongGanZhiKongWang(baZi.getMingGongGanZhiKongWang()); // 命宫干支空亡
        vo.setShenGongGanZhiKongWang(baZi.getShenGongGanZhiKongWang()); // 身宫干支空亡
        vo.setYearGanZhiZhuXing(baZi.getYearGanZhiZhuXing()); // 年干支主星
        vo.setMonthGanZhiZhuXing(baZi.getMonthGanZhiZhuXing()); // 月干支主星
        vo.setDayGanZhiZhuXing(baZi.getDayGanZhiZhuXing()); // 日干支主星
        vo.setHourGanZhiZhuXing(baZi.getHourGanZhiZhuXing()); // 时干支主星
        vo.setTaiYuanGanZhiZhuXing(baZi.getTaiYuanGanZhiZhuXing()); // 胎元干支主星
        vo.setTaiXiGanZhiZhuXing(baZi.getTaiXiGanZhiZhuXing()); // 胎息干支主星
        vo.setMingGongGanZhiZhuXing(baZi.getMingGongGanZhiZhuXing()); // 命宫干支主星
        vo.setShenGongGanZhiZhuXing(baZi.getShenGongGanZhiZhuXing()); // 身宫干支主星
        vo.setYearZhiCangGan(baZi.getYearZhiCangGan()); // 年支藏干
        vo.setMonthZhiCangGan(baZi.getMonthZhiCangGan()); // 月支藏干
        vo.setDayZhiCangGan(baZi.getDayZhiCangGan()); // 日支藏干
        vo.setHourZhiCangGan(baZi.getHourZhiCangGan()); // 时支藏干
        vo.setTaiYuanZhiCangGan(baZi.getTaiYuanZhiCangGan()); // 胎元支藏干
        vo.setTaiXiZhiCangGan(baZi.getTaiXiZhiCangGan()); // 胎息支藏干
        vo.setMingGongZhiCangGan(baZi.getMingGongZhiCangGan()); // 命宫支藏干
        vo.setShenGongZhiCangGan(baZi.getShenGongZhiCangGan()); // 身宫支藏干
        vo.setYearZhiCangGanWuXing(baZi.getYearZhiCangGanWuXing()); // 年支藏干五行
        vo.setMonthZhiCangGanWuXing(baZi.getMonthZhiCangGanWuXing()); // 月支藏干五行
        vo.setDayZhiCangGanWuXing(baZi.getDayZhiCangGanWuXing()); // 日支藏干五行
        vo.setHourZhiCangGanWuXing(baZi.getHourZhiCangGanWuXing()); // 时支藏干五行
        vo.setTaiYuanZhiCangGanWuXing(baZi.getTaiYuanZhiCangGanWuXing()); // 胎元支藏干五行
        vo.setTaiXiZhiCangGanWuXing(baZi.getTaiXiZhiCangGanWuXing()); // 胎息支藏干五行
        vo.setMingGongZhiCangGanWuXing(baZi.getMingGongZhiCangGanWuXing()); // 命宫支藏干五行
        vo.setShenGongZhiCangGanWuXing(baZi.getShenGongZhiCangGanWuXing()); // 身宫支藏干五行
        vo.setYearGanZhiFuXing(baZi.getYearGanZhiFuXing()); // 年干支副星
        vo.setMonthGanZhiFuXing(baZi.getMonthGanZhiFuXing()); // 月干支副星
        vo.setDayGanZhiFuXing(baZi.getDayGanZhiFuXing()); // 日干支副星
        vo.setHourGanZhiFuXing(baZi.getHourGanZhiFuXing()); // 时干支副星
        vo.setTaiYuanGanZhiFuXing(baZi.getTaiYuanGanZhiFuXing()); // 胎元干支副星
        vo.setTaiXiGanZhiFuXing(baZi.getTaiXiGanZhiFuXing()); // 胎息干支副星
        vo.setMingGongGanZhiFuXing(baZi.getMingGongGanZhiFuXing()); // 命宫干支副星
        vo.setShenGongGanZhiFuXing(baZi.getShenGongGanZhiFuXing()); // 身宫干支副星
        vo.setYearGanZhiZiZuo(baZi.getYearGanZhiZiZuo()); // 年干支自坐
        vo.setMonthGanZhiZiZuo(baZi.getMonthGanZhiZiZuo()); // 月干支自坐
        vo.setDayGanZhiZiZuo(baZi.getDayGanZhiZiZuo()); // 日干支自坐
        vo.setHourGanZhiZiZuo(baZi.getHourGanZhiZiZuo()); // 时干支自坐
        vo.setTaiYuanGanZhiZiZuo(baZi.getTaiYuanGanZhiZiZuo()); // 胎元干支自坐
        vo.setTaiXiGanZhiZiZuo(baZi.getTaiXiGanZhiZiZuo()); // 胎息干支自坐
        vo.setMingGongGanZhiZiZuo(baZi.getMingGongGanZhiZiZuo()); // 命宫干支自坐
        vo.setShenGongGanZhiZiZuo(baZi.getShenGongGanZhiZiZuo()); // 身宫干支自坐
        vo.setYearGanZhiXingYun(baZi.getYearGanZhiXingYun()); // 年干支星运
        vo.setMonthGanZhiXingYun(baZi.getMonthGanZhiXingYun()); // 月干支星运
        vo.setDayGanZhiXingYun(baZi.getDayGanZhiXingYun()); // 日干支星运
        vo.setHourGanZhiXingYun(baZi.getHourGanZhiXingYun()); // 时干支星运
        vo.setTaiYuanGanZhiXingYun(baZi.getTaiYuanGanZhiXingYun()); // 胎元干支星运
        vo.setTaiXiGanZhiXingYun(baZi.getTaiXiGanZhiXingYun()); // 胎息干支星运
        vo.setMingGongGanZhiXingYun(baZi.getMingGongGanZhiXingYun()); // 命宫干支星运
        vo.setShenGongGanZhiXingYun(baZi.getShenGongGanZhiXingYun()); // 身宫干支星运
        vo.setYearGanZhiShenSha(baZi.getYearGanZhiShenSha()); // 年干支神煞
        vo.setMonthGanZhiShenSha(baZi.getMonthGanZhiShenSha()); // 月干支神煞
        vo.setDayGanZhiShenSha(baZi.getDayGanZhiShenSha()); // 日干支神煞
        vo.setHourGanZhiShenSha(baZi.getHourGanZhiShenSha()); // 时干支神煞
        vo.setTaiYuanGanZhiShenSha(baZi.getTaiYuanGanZhiShenSha()); // 胎元干支神煞
        vo.setTaiXiGanZhiShenSha(baZi.getTaiXiGanZhiShenSha()); // 胎息干支神煞
        vo.setMingGongGanZhiShenSha(baZi.getMingGongGanZhiShenSha()); // 命宫干支神煞
        vo.setShenGongGanZhiShenSha(baZi.getShenGongGanZhiShenSha()); // 身宫干支神煞
        vo.setWuXingMuCount(baZi.getWuXingMuCount(false)); // 五行木数量（不包含地支藏干）
        vo.setWuXingHuoCount(baZi.getWuXingHuoCount(false)); // 五行火数量（不包含地支藏干）
        vo.setWuXingTuCount(baZi.getWuXingTuCount(false)); // 五行土数量（不包含地支藏干）
        vo.setWuXingJinCount(baZi.getWuXingJinCount(false)); // 五行金数量（不包含地支藏干）
        vo.setWuXingShuiCount(baZi.getWuXingShuiCount(false)); // 五行水数量（不包含地支藏干）
        vo.setWuXingMuCangGanCount(baZi.getWuXingMuCount(true)); // 五行木数量（包含地支藏干）
        vo.setWuXingHuoCangGanCount(baZi.getWuXingHuoCount(true)); // 五行火数量（包含地支藏干）
        vo.setWuXingTuCangGanCount(baZi.getWuXingTuCount(true)); // 五行土数量（包含地支藏干）
        vo.setWuXingJinCangGanCount(baZi.getWuXingJinCount(true)); // 五行金数量（包含地支藏干）
        vo.setWuXingShuiCangGanCount(baZi.getWuXingShuiCount(true)); // 五行水数量（包含地支藏干）
        vo.setWuXingQueShi(baZi.getWuXingQueShi()); // 五行缺失
        vo.setWuXingWangShuai(baZi.getWuXingWangShuai()); // 五行旺衰
        vo.setTianGanLiuYi(baZi.getTianGanLiuYi()); // 天干留意
        vo.setDiZhiLiuYi(baZi.getDiZhiLiuYi()); // 地支留意
        vo.setPrevJie(baZi.getPrevJie()); // 上一节
        vo.setPrevJieDateStr(baZi.getPrevJieDateStr()); // 上一节日期
        vo.setPrevJieDayNumber(baZi.getPrevJieDay()); // 距上一节天数
        vo.setNextJie(baZi.getNextJie()); // 下一节
        vo.setNextJieDateStr(baZi.getNextJieDateStr()); // 下一节日期
        vo.setNextJieDayNumber(baZi.getNextJieDay()); // 距下一节天数
        vo.setChuShengJieQi(baZi.getChuShengJie()); // 出生节
        vo.setRenYuanSiLingFenYe(baZi.getRenYuanSiLingFenYe()); // 人元司令分野
        vo.setShenTiQiangRuo(baZi.getShenTiQiangRuo()); // 身体强弱
        vo.setXiYongShen(baZi.getXiYongShen()); // 喜用神
        vo.setXiYongShenFangWei(baZi.getXiYongShenFangWei()); // 喜用神方位
        vo.setGuZhong(baZi.getGuZhong()); // 骨重及批注
        vo.setXingXiu(baZi.getXingXiu()); // 星宿
        vo.setXiuJiXiong(baZi.getXingXiuJiXiong()); // 星宿吉凶
        vo.setXiuJiXiongGeJue(baZi.getXingXiuJiXiongGeJue()); // 星宿吉凶歌诀
        vo.setMingGua(baZi.getMingGua()); // 命卦
        vo.setRiZhuLunMing(baZi.getRiZhuLunMing()); // 日柱论命
        vo.setWuXingFenXi(baZi.getWuXingFenXi()); // 五行分析
        vo.setYunShiFenXi(baZi.getYunShiFenXi()); // 运势分析
        vo.setXingGeFenXi(baZi.getXingGeFenXi()); // 性格分析
        vo.setSolarQiYunDateStr(baZi.getSolarQiYunDateStr()); // 公历起运日期
        vo.setSolarQiYun(baZi.getSolarQiYun()); // 公历起运信息
        vo.setSolarJiaoYun(baZi.getSolarJiaoYun()); // 公历交运信息
        vo.setZhengCaiYun(baZi.getZhengCaiYun()); // 正财运年份、年龄、干支、合化
        vo.setPianCaiYun(baZi.getPianCaiYun()); // 偏财运年份、年龄、干支、合化
        vo.setZhengTaoHua(baZi.getZhengTaoHuaYun()); // 正桃花年份、年龄、干支、合化
        vo.setPianTaoHua(baZi.getPianTaoHuaYun()); // 偏桃花年份、年龄、干支、合化

        // 4、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }

    /**
     * 大运流年初始化
     *
     * @param dto 大运流年初始化请求数据
     * @return 数据
     */
    @PostMapping("/daYunInitialize")
    public ResponseResult<BaZiDaYunInitializeVo> daYunInitialize(@RequestBody BaZiDaYunInitializeDto dto) {

        // 1、计算大运、流年、小运、流月
        BaZiDaYunLiuNianUtil dyUtil = new BaZiDaYunLiuNianUtil(dto.getSolarDate(), dto.getSex(), dto.getQiYunLiuPai(), dto.getYearGanZhiType(), dto.getMonthGanZhiType(), dto.getDayGanZhiType());
        List<List<String>> daYun = dyUtil.getDaYun(dto.getDaYunLunShu()); // 获取大运
        List<List<String>> liuNian = dyUtil.getLiuNian(dto.getDaYunLunShu(), 1); // 获取流年
        List<List<String>> xiaoYun = dyUtil.getXiaoYun(dto.getDaYunLunShu(), 1); // 获取小运
        List<List<String>> liuYue = dyUtil.getLiuYue(dto.getDaYunLunShu(), 1, 1, dto.getSolarDate().getYear() + 1900); // 获取流月

        // 2、处理大运干支、流年干支
        String daYunGanZhi = ""; // 大运干支
        String daYunGan = "";  // 大运干
        String daYunZhi = "";  // 大运支
        String liuNianGanZhi = ""; // 流年干支
        String liuNianGan = "";  // 流年干
        String liuNianZhi = "";  // 流年支
        if (xiaoYun.size() != 0) {
            daYunGanZhi = xiaoYun.get(0).get(0);
        } else {
            daYunGanZhi = daYun.get(1).get(0);
        }
        if (daYun.size() != 0) {
            liuNianGanZhi = liuNian.get(0).get(0);
        }
        if (StringUtils.isNotBlank(daYunGanZhi) && daYunGanZhi.length() >= 1) daYunGan = daYunGanZhi.substring(0, 1);
        if (StringUtils.isNotBlank(daYunGanZhi) && daYunGanZhi.length() >= 2) daYunZhi = daYunGanZhi.substring(1, 2);
        if (StringUtils.isNotBlank(liuNianGanZhi) && liuNianGanZhi.length() >= 1) liuNianGan = liuNianGanZhi.substring(0, 1);
        if (StringUtils.isNotBlank(liuNianGanZhi) && liuNianGanZhi.length() >= 2) liuNianZhi = liuNianGanZhi.substring(1, 2);

        // 3、计算干支留意
        List<String> tianGanLiuYi = BaZiGanZhiLiuYiUtil.tanGanLiuYi(dyUtil.getYearGan(), dyUtil.getMonthGan(), dyUtil.getDayGan(), dyUtil.getHourGan(), daYunGan, liuNianGan, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2);
        List<String> diZhiLiuYi = BaZiGanZhiLiuYiUtil.diZhiLiuYi(dyUtil.getYearZhi(), dyUtil.getMonthZhi(), dyUtil.getDayZhi(), dyUtil.getHourZhi(), daYunZhi, liuNianZhi, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2);

        // 4、封装数据
        BaZiDaYunInitializeVo vo = new BaZiDaYunInitializeVo();
        vo.setDaYun(BaZiDaYunLiuNianPackageVo.daYunPackage(daYun)); // 大运
        vo.setLiuNian(BaZiDaYunLiuNianPackageVo.liuNianPackage(liuNian)); // 流年
        vo.setXiaoYun(BaZiDaYunLiuNianPackageVo.xiaoYunPackage(xiaoYun)); // 小运
        vo.setLiuYue(BaZiDaYunLiuNianPackageVo.liuYuePackage(liuYue)); // 流月
        vo.setTianGanLiuYi(tianGanLiuYi); // 天干留意
        vo.setDiZhiLiuYi(diZhiLiuYi); // 地支留意

        // 5、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }

    /**
     * 点击大运
     *
     * @param dto 大运切换请求数据
     * @return 数据
     */
    @PostMapping("/daYun")
    public ResponseResult<BaZiDaYunVo> daYun(@RequestBody BaZiDaYunDto dto) {

        // 1、计算流年、小运、流月
        BaZiDaYunLiuNianUtil dyUtil = new BaZiDaYunLiuNianUtil(dto.getSolarDate(), dto.getSex(), dto.getQiYunLiuPai(), dto.getYearGanZhiType(), dto.getMonthGanZhiType(), dto.getDayGanZhiType());
        Date daYunSolarDate = DateUtil.stringToDate2(dto.getDaYunSolarDate()); // 大运公历日期
        List<List<String>> liuNian = dyUtil.getLiuNian(dto.getDaYunLunShu(), dto.getDaYunLun()); // 获取流年
        List<List<String>> xiaoYun = dyUtil.getXiaoYun(dto.getDaYunLunShu(), dto.getDaYunLun()); // 获取小运
        List<List<String>> liuYue = dyUtil.getLiuYue(dto.getDaYunLunShu(), dto.getDaYunLun(), dto.getLiuNianLun(), daYunSolarDate.getYear() + 1900); // 获取流月

        // 2、处理流年干支
        String liuNianGan = ""; // 流年干
        String liuNianZhi = ""; // 流年支
        String liuNianGanZhi = liuNian.get(dto.getLiuNianLun() - 1).get(0); // 流年干支
        if (StringUtils.isNotBlank(liuNianGanZhi) && liuNianGanZhi.length() >= 1) liuNianGan = liuNianGanZhi.substring(0, 1); // 流年干
        if (StringUtils.isNotBlank(liuNianGanZhi) && liuNianGanZhi.length() >= 2) liuNianZhi = liuNianGanZhi.substring(1, 2); // 流年支

        // 3、计算干支留意
        List<String> tianGanLiuYi = BaZiGanZhiLiuYiUtil.tanGanLiuYi(dyUtil.getYearGan(), dyUtil.getMonthGan(), dyUtil.getDayGan(), dyUtil.getHourGan(), dto.getDaYunGanZhi().substring(0, 1), liuNianGan, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2);
        List<String> diZhiLiuYi = BaZiGanZhiLiuYiUtil.diZhiLiuYi(dyUtil.getYearZhi(), dyUtil.getMonthZhi(), dyUtil.getDayZhi(), dyUtil.getHourZhi(), dto.getDaYunGanZhi().substring(1, 2), liuNianZhi, CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2);

        // 4、封装数据
        BaZiDaYunVo vo = new BaZiDaYunVo();
        vo.setLiuNian(BaZiDaYunLiuNianPackageVo.liuNianPackage(liuNian)); // 流年
        vo.setXiaoYun(BaZiDaYunLiuNianPackageVo.xiaoYunPackage(xiaoYun)); // 小运
        vo.setLiuYue(BaZiDaYunLiuNianPackageVo.liuYuePackage(liuYue)); // 流月
        vo.setTianGanLiuYi(tianGanLiuYi); // 天干留意
        vo.setDiZhiLiuYi(diZhiLiuYi); // 地支留意

        // 5、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }

    /**
     * 点击流年
     *
     * @param dto 流年切换请求数据
     * @return 数据
     */
    @PostMapping("/liuNian")
    public ResponseResult<BaZiLiuNianVo> liuNian(@RequestBody BaZiLiuNianDto dto) {

        // 1、计算流月
        BaZiDaYunLiuNianUtil dyUtil = new BaZiDaYunLiuNianUtil(dto.getSolarDate(), dto.getSex(), dto.getQiYunLiuPai(), dto.getYearGanZhiType(), dto.getMonthGanZhiType(), dto.getDayGanZhiType());
        Date liuNianXiaoYunSolarDate = DateUtil.stringToDate2(dto.getLiuNianSolarDate()); // 流年公历日期
        List<List<String>> liuYue = dyUtil.getLiuYue(dto.getDaYunLunShu(), dto.getDaYunLun(), dto.getLiuNianLun(), liuNianXiaoYunSolarDate.getYear() + 1900); // 获取流月

        // 2、计算干支留意
        List<String> tianGanLiuYi = BaZiGanZhiLiuYiUtil.tanGanLiuYi(dyUtil.getYearGan(), dyUtil.getMonthGan(), dyUtil.getDayGan(), dyUtil.getHourGan(), dto.getDaYunGanZhi().substring(0, 1), dto.getLiuNianGanZhi().substring(0, 1), CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2);
        List<String> diZhiLiuYi = BaZiGanZhiLiuYiUtil.diZhiLiuYi(dyUtil.getYearZhi(), dyUtil.getMonthZhi(), dyUtil.getDayZhi(), dyUtil.getHourZhi(), dto.getDaYunGanZhi().substring(1, 2), dto.getLiuNianGanZhi().substring(1, 2), CommonUtil.EMPTY2, CommonUtil.EMPTY2, CommonUtil.EMPTY2);

        // 3、封装数据
        BaZiLiuNianVo vo = new BaZiLiuNianVo();
        vo.setLiuYue(BaZiDaYunLiuNianPackageVo.liuYuePackage(liuYue)); // 流月
        vo.setTianGanLiuYi(tianGanLiuYi); // 天干留意
        vo.setDiZhiLiuYi(diZhiLiuYi); // 地支留意

        // 4、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }

    /**
     * 点击流月
     *
     * @param dto 流月切换请求数据
     * @return 数据
     */
    @PostMapping("/liuYue")
    public ResponseResult<BaZiLiuYueVo> liuYue(@RequestBody BaZiLiuYueDto dto) {

        // 1、计算流日
        BaZiDaYunLiuNianUtil dyUtil = new BaZiDaYunLiuNianUtil(dto.getSolarDate(), dto.getSex(), dto.getQiYunLiuPai(), dto.getYearGanZhiType(), dto.getMonthGanZhiType(), dto.getDayGanZhiType());
        Date liuYueSolarDate = DateUtil.stringToDate2(dto.getLiuYueSolarDate()); // 流月公历日期
        List<List<String>> liuRi = dyUtil.getLiuRi(liuYueSolarDate.getYear() + 1900, liuYueSolarDate.getMonth() + 1); // 获取流日

        // 2、计算干支留意
        List<String> tianGanLiuYi = BaZiGanZhiLiuYiUtil.tanGanLiuYi(dyUtil.getYearGan(), dyUtil.getMonthGan(), dyUtil.getDayGan(), dyUtil.getHourGan(), dyUtil.getDayGanZhi().substring(0, 1), dto.getLiuNianGanZhi().substring(0, 1), dto.getLiuYueGanZhi().substring(0, 1), CommonUtil.EMPTY2, CommonUtil.EMPTY2);
        List<String> diZhiLiuYi = BaZiGanZhiLiuYiUtil.diZhiLiuYi(dyUtil.getYearZhi(), dyUtil.getMonthZhi(), dyUtil.getDayZhi(), dyUtil.getHourZhi(), dto.getDaYunGanZhi().substring(1, 2), dto.getLiuNianGanZhi().substring(1, 2), dto.getLiuYueGanZhi().substring(1, 2), CommonUtil.EMPTY2, CommonUtil.EMPTY2);

        // 3、封装数据
        BaZiLiuYueVo vo = new BaZiLiuYueVo();
        vo.setLiuRi(BaZiDaYunLiuNianPackageVo.liuRiPackage(liuRi)); // 流日
        vo.setTianGanLiuYi(tianGanLiuYi); // 天干留意
        vo.setDiZhiLiuYi(diZhiLiuYi); // 地支留意

        // 4、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }

    /**
     * 点击流日
     *
     * @param dto 流日切换请求数据
     * @return 数据
     */
    @PostMapping("/liuRi")
    public ResponseResult<BaZiLiuRiVo> liuRi(@RequestBody BaZiLiuRiDto dto) {

        // 1、计算流时
        BaZiDaYunLiuNianUtil dyUtil = new BaZiDaYunLiuNianUtil(dto.getSolarDate(), dto.getSex(), dto.getQiYunLiuPai(), dto.getYearGanZhiType(), dto.getMonthGanZhiType(), dto.getDayGanZhiType());
        Date liuRiSolarDate = DateUtil.stringToDate2(dto.getLiuRiSolarDate()); // 流日公历日期
        List<List<String>> liuShi = dyUtil.getLiuShi(liuRiSolarDate.getYear() + 1900, liuRiSolarDate.getMonth() + 1, liuRiSolarDate.getDate()); // 获取流时

        // 2、计算干支留意
        List<String> tianGanLiuYi = BaZiGanZhiLiuYiUtil.tanGanLiuYi(dyUtil.getYearGan(), dyUtil.getMonthGan(), dyUtil.getDayGan(), dyUtil.getHourGan(), dyUtil.getDayGanZhi().substring(0, 1), dto.getLiuNianGanZhi().substring(0, 1), dto.getLiuYueGanZhi().substring(0, 1), dto.getLiuRiGanZhi().substring(0, 1), CommonUtil.EMPTY2);
        List<String> diZhiLiuYi = BaZiGanZhiLiuYiUtil.diZhiLiuYi(dyUtil.getYearZhi(), dyUtil.getMonthZhi(), dyUtil.getDayZhi(), dyUtil.getHourZhi(), dyUtil.getDayGanZhi().substring(1, 2), dto.getLiuNianGanZhi().substring(1, 2), dto.getLiuYueGanZhi().substring(1, 2), dto.getLiuRiGanZhi().substring(1, 2), CommonUtil.EMPTY2);

        // 3、封装数据
        BaZiLiuRiVo vo = new BaZiLiuRiVo();
        vo.setLiuShi(BaZiDaYunLiuNianPackageVo.liuShiPackage(liuShi)); // 流时
        vo.setTianGanLiuYi(tianGanLiuYi); // 天干留意
        vo.setDiZhiLiuYi(diZhiLiuYi); // 地支留意

        // 4、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }

    /**
     * 点击流时
     *
     * @param dto 流时切换请求数据
     * @return 数据
     */
    @PostMapping("/liuShi")
    public ResponseResult<BaZiLiuShiVo> liuShi(@RequestBody BaZiLiuShiDto dto) {

        // 1、计算干支留意
        List<String> tianGanLiuYi = BaZiGanZhiLiuYiUtil.tanGanLiuYi(dto.getYearGanZhi().substring(0, 1), dto.getMonthGanZhi().substring(0, 1), dto.getDayGanZhi().substring(0, 1), dto.getHourGanZhi().substring(0, 1), dto.getDaYunGanZhi().substring(0, 1), dto.getLiuNianGanZhi().substring(0, 1), dto.getLiuYueGanZhi().substring(0, 1), dto.getLiuRiGanZhi().substring(0, 1), dto.getLiuShiGanZhi().substring(0, 1));
        List<String> diZhiLiuYi = BaZiGanZhiLiuYiUtil.diZhiLiuYi(dto.getYearGanZhi().substring(1, 2), dto.getMonthGanZhi().substring(1, 2), dto.getDayGanZhi().substring(1, 2), dto.getHourGanZhi().substring(1, 2), dto.getDaYunGanZhi().substring(1, 2), dto.getLiuNianGanZhi().substring(1, 2), dto.getLiuYueGanZhi().substring(1, 2), dto.getLiuRiGanZhi().substring(1, 2), dto.getLiuShiGanZhi().substring(1, 2));

        // 2、封装数据
        BaZiLiuShiVo vo = new BaZiLiuShiVo();
        vo.setTianGanLiuYi(tianGanLiuYi); // 天干留意
        vo.setDiZhiLiuYi(diZhiLiuYi); // 地支留意

        // 3、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }

    /**
     * 点击胎命身
     *
     * @param dto 胎命身切换请求数据
     * @return 数据
     */
    @PostMapping("/taiMingShen")
    public ResponseResult<BaZiTaiMingShenVo> taiMingShen(@RequestBody BaZiTaiMingShenDto dto) {

        // 1、计算干支留意
        List<String> tianGanLiuYi = BaZiGanZhiLiuYiUtil.tanGanLiuYi(dto.getYearGanZhi().substring(0, 1), dto.getMonthGanZhi().substring(0, 1), dto.getDayGanZhi().substring(0, 1), dto.getHourGanZhi().substring(0, 1), dto.getTaiYuanGanZhi().substring(0, 1), dto.getTaiXiGanZhi().substring(0, 1), dto.getMingGongGanZhi().substring(0, 1), dto.getShenGongGanZhi().substring(0, 1), CommonUtil.EMPTY2);
        List<String> diZhiLiuYi = BaZiGanZhiLiuYiUtil.diZhiLiuYi(dto.getYearGanZhi().substring(1, 2), dto.getMonthGanZhi().substring(1, 2), dto.getDayGanZhi().substring(1, 2), dto.getHourGanZhi().substring(1, 2), dto.getTaiYuanGanZhi().substring(1, 2), dto.getTaiXiGanZhi().substring(1, 2), dto.getMingGongGanZhi().substring(1, 2), dto.getShenGongGanZhi().substring(1, 2), CommonUtil.EMPTY2);

        // 2、封装数据
        BaZiTaiMingShenVo vo = new BaZiTaiMingShenVo();
        vo.setTianGanLiuYi(tianGanLiuYi); // 天干留意
        vo.setDiZhiLiuYi(diZhiLiuYi); // 地支留意

        // 3、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }


}
