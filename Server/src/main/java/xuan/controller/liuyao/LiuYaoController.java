package xuan.controller.liuyao;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xuan.configuration.result.ResponseResult;
import xuan.configuration.result.ResponseResultEnum;
import xuan.utils.liuyao.LiuYao;
import xuan.utils.liuyao.settings.LiuYaoJiChuSetting;
import xuan.dto.liuyao.LiuYaoDto;
import xuan.vo.liuyao.LiuYaoVo;

/**
 * 六爻排盘Controller
 *
 * @author 善待
 */
@RestController
@RequestMapping("/liuYao")
public class LiuYaoController {

    /**
     * 开始排盘
     *
     * @param dto 六爻设置接收类
     * @return 六爻数据
     */
    @PostMapping("/paiPan")
    public ResponseResult<LiuYaoVo> paiPan(@RequestBody LiuYaoDto dto) {

        // 1、拷贝设置
        LiuYaoJiChuSetting setting = new LiuYaoJiChuSetting();
        BeanUtils.copyProperties(dto, setting);

        // 2、排盘
        LiuYao liuYao = new LiuYao(setting);

        // 3、设置数据
        LiuYaoVo vo = new LiuYaoVo();
//        BeanUtils.copyProperties(liuYao, vo); // 最新版本不再支持拷贝
        vo.setSolarDate(liuYao.getSolarDate()); // 公历日期
        vo.setLunarDate(liuYao.getLunarDate()); // 农历日期
        vo.setSolarStr(liuYao.getSolarStr()); // 公历日期
        vo.setLunarStr(liuYao.getLunarStr()); // 农历日期
        vo.setName(liuYao.getName()); // 姓名
        vo.setSex(liuYao.getSex()); // 性别
        vo.setOccupy(liuYao.getOccupy()); // 占事
        vo.setZao(liuYao.getZao()); // 造
        vo.setTaiSuiType(liuYao.getTaiSuiType()); // 太岁类型
        vo.setXingQi(liuYao.getXingQi()); // 星期
        vo.setJiJie(liuYao.getJiJie()); // 季节
        vo.setShengXiao(liuYao.getShengXiao()); // 生肖
        vo.setXingZuo(liuYao.getXingZuo()); // 星座
        vo.setYueXiang(liuYao.getYueXiang()); // 月相
        vo.setYueJiang(liuYao.getYueJiang()); // 月将
        vo.setYueJiangShen(liuYao.getYueJiangShen()); // 月将神
        vo.setWuBuYuShi(liuYao.getWuBuYuShi()); // 五不遇时
        vo.setYearGan(liuYao.getYearGan()); // 年干
        vo.setMonthGan(liuYao.getMonthGan()); // 月干
        vo.setDayGan(liuYao.getDayGan()); // 日干
        vo.setHourGan(liuYao.getHourGan()); // 时干
        vo.setYearZhi(liuYao.getYearZhi()); // 年支
        vo.setMonthZhi(liuYao.getMonthZhi()); // 月支
        vo.setDayZhi(liuYao.getDayZhi()); // 日支
        vo.setHourZhi(liuYao.getHourZhi()); // 时支
        vo.setYearGanZhi(liuYao.getYearGanZhi()); // 年干支
        vo.setMonthGanZhi(liuYao.getMonthGanZhi()); // 月干支
        vo.setDayGanZhi(liuYao.getDayGanZhi()); // 日干支
        vo.setHourGanZhi(liuYao.getHourGanZhi()); // 时干支
        vo.setYearGanWuXing(liuYao.getYearGanWuXing()); // 年干五行
        vo.setMonthGanWuXing(liuYao.getMonthGanWuXing()); // 月干五行
        vo.setDayGanWuXing(liuYao.getDayGanWuXing()); // 日干五行
        vo.setHourGanWuXing(liuYao.getHourGanWuXing()); // 时干五行
        vo.setYearZhiWuXing(liuYao.getYearZhiWuXing()); // 年支五行
        vo.setMonthZhiWuXing(liuYao.getMonthZhiWuXing()); // 月支五行
        vo.setDayZhiWuXing(liuYao.getDayZhiWuXing()); // 日支五行
        vo.setHourZhiWuXing(liuYao.getHourZhiWuXing()); // 时支五行
        vo.setYearGanZhiWuXing(liuYao.getYearGanZhiWuXing()); // 年干支五行
        vo.setMonthGanZhiWuXing(liuYao.getMonthGanZhiWuXing()); // 月干支五行
        vo.setDayGanZhiWuXing(liuYao.getDayGanZhiWuXing()); // 日干支五行
        vo.setHourGanZhiWuXing(liuYao.getHourGanZhiWuXing()); // 时干支五行
        vo.setYearGanZhiNaYin(liuYao.getYearGanZhiNaYin()); // 年干支纳音
        vo.setMonthGanZhiNaYin(liuYao.getMonthGanZhiNaYin()); // 月干支纳音
        vo.setDayGanZhiNaYin(liuYao.getDayGanZhiNaYin()); // 日干支纳音
        vo.setHourGanZhiNaYin(liuYao.getHourGanZhiNaYin()); // 时干支纳音
        vo.setYearGanZhiKongWang(liuYao.getYearGanZhiKongWang()); // 年干支空亡
        vo.setMonthGanZhiKongWang(liuYao.getMonthGanZhiKongWang()); // 月干支空亡
        vo.setDayGanZhiKongWang(liuYao.getDayGanZhiKongWang()); // 日干支空亡
        vo.setHourGanZhiKongWang(liuYao.getHourGanZhiKongWang()); // 时干支空亡
        vo.setShenSha(liuYao.getShenSha()); // 神煞
        vo.setLiuYaoAsMark(liuYao.getLiuYaoAsMark()); // 六爻爻象标识
        vo.setShangGuaName(liuYao.getShangGuaName()); // 上卦卦名
        vo.setXiaGuaName(liuYao.getXiaGuaName()); // 下卦卦名
        vo.setBenGuaName(liuYao.getBenGuaName()); // 本卦卦名
        vo.setBianGuaName(liuYao.getBianGuaName()); // 变卦卦名
        vo.setHuGuaName(liuYao.getHuGuaName()); // 互卦卦名
        vo.setCuoGuaName(liuYao.getCuoGuaName()); // 错卦卦名
        vo.setZongGuaName(liuYao.getZongGuaName()); // 综卦卦名
        vo.setFuGuaName(liuYao.getFuGuaName()); // 伏卦卦名
        vo.setShangGuaAs(liuYao.getShangGuaAs()); // 上卦卦象
        vo.setXiaGuaAs(liuYao.getXiaGuaAs()); // 下卦卦象
        vo.setBenGuaAs(liuYao.getBenGuaAs()); // 本卦卦象
        vo.setBianGuaAs(liuYao.getBianGuaAs()); // 变卦卦象
        vo.setHuGuaAs(liuYao.getHuGuaAs()); // 互卦卦象
        vo.setCuoGuaAs(liuYao.getCuoGuaAs()); // 错卦卦象
        vo.setZongGuaAs(liuYao.getZongGuaAs()); // 综卦卦象
        vo.setFuGuaAs(liuYao.getFuGuaAs()); // 伏卦卦象
        vo.setBenGuaType(liuYao.getBenGuaType()); // 本卦类型
        vo.setBianGuaType(liuYao.getBianGuaType()); // 变卦类型
        vo.setHuGuaType(liuYao.getHuGuaType()); // 互卦类型
        vo.setCuoGuaType(liuYao.getCuoGuaType()); // 错卦类型
        vo.setZongGuaType(liuYao.getZongGuaType()); // 综卦类型
        vo.setFuGuaType(liuYao.getFuGuaType()); // 伏卦类型
        vo.setBenGuaGuaShen(liuYao.getBenGuaGuaShen()); // 本卦卦身
        vo.setBianGuaGuaShen(liuYao.getBianGuaGuaShen()); // 变卦卦身
        vo.setHuGuaGuaShen(liuYao.getHuGuaGuaShen()); // 互卦卦身
        vo.setCuoGuaGuaShen(liuYao.getCuoGuaGuaShen()); // 错卦卦身
        vo.setZongGuaGuaShen(liuYao.getZongGuaGuaShen()); // 综卦卦身
        vo.setFuGuaGuaShen(liuYao.getFuGuaGuaShen()); // 伏卦卦身
        vo.setBenGuaGuaCi(liuYao.getBenGuaGuaCi()); // 本卦卦辞
        vo.setBianGuaGuaCi(liuYao.getBianGuaGuaCi()); // 变卦卦辞
        vo.setHuGuaGuaCi(liuYao.getHuGuaGuaCi()); // 互卦卦辞
        vo.setCuoGuaGuaCi(liuYao.getCuoGuaGuaCi()); // 错卦卦辞
        vo.setZongGuaGuaCi(liuYao.getZongGuaGuaCi()); // 综卦卦辞
        vo.setFuGuaGuaCi(liuYao.getFuGuaGuaCi()); // 伏卦卦辞
        vo.setBenGuaLiuYaoName(liuYao.getBenGuaLiuYaoName()); // 本卦六爻爻名
        vo.setBianGuaLiuYaoName(liuYao.getBianGuaLiuYaoName()); // 变卦六爻爻名
        vo.setHuGuaLiuYaoName(liuYao.getHuGuaLiuYaoName()); // 互卦六爻爻名
        vo.setCuoGuaLiuYaoName(liuYao.getCuoGuaLiuYaoName()); // 错卦六爻爻名
        vo.setZongGuaLiuYaoName(liuYao.getZongGuaLiuYaoName()); // 综卦六爻爻名
        vo.setFuGuaLiuYaoName(liuYao.getFuGuaLiuYaoName()); // 伏卦六爻爻名
        vo.setBenGuaLiuYaoAs(liuYao.getBenGuaLiuYaoAs()); // 本卦六爻爻象
        vo.setBianGuaLiuYaoAs(liuYao.getBianGuaLiuYaoAs()); // 变卦六爻爻象
        vo.setHuGuaLiuYaoAs(liuYao.getHuGuaLiuYaoAs()); // 互卦六爻爻象
        vo.setCuoGuaLiuYaoAs(liuYao.getCuoGuaLiuYaoAs()); // 错卦六爻爻象
        vo.setZongGuaLiuYaoAs(liuYao.getZongGuaLiuYaoAs()); // 综卦六爻爻象
        vo.setFuGuaLiuYaoAs(liuYao.getFuGuaLiuYaoAs()); // 伏卦六爻爻象
        vo.setBenGuaLiuYaoShiYing(liuYao.getBenGuaLiuYaoShiYing()); // 本卦六爻世应
        vo.setBianGuaLiuYaoShiYing(liuYao.getBianGuaLiuYaoShiYing()); // 变卦六爻世应
        vo.setHuGuaLiuYaoShiYing(liuYao.getHuGuaLiuYaoShiYing()); // 互卦六爻世应
        vo.setCuoGuaLiuYaoShiYing(liuYao.getCuoGuaLiuYaoShiYing()); // 错卦六爻世应
        vo.setZongGuaLiuYaoShiYing(liuYao.getZongGuaLiuYaoShiYing()); // 综卦六爻世应
        vo.setFuGuaLiuYaoShiYing(liuYao.getFuGuaLiuYaoShiYing()); // 伏卦六爻世应
        vo.setBenGuaLiuYaoLiuQin(liuYao.getBenGuaLiuYaoLiuQin()); // 本卦六爻六亲
        vo.setBianGuaLiuYaoLiuQin(liuYao.getBianGuaLiuYaoLiuQin()); // 变卦六爻六亲
        vo.setHuGuaLiuYaoLiuQin(liuYao.getHuGuaLiuYaoLiuQin()); // 互卦六爻六亲
        vo.setCuoGuaLiuYaoLiuQin(liuYao.getCuoGuaLiuYaoLiuQin()); // 错卦六爻六亲
        vo.setZongGuaLiuYaoLiuQin(liuYao.getZongGuaLiuYaoLiuQin()); // 综卦六爻六亲
        vo.setFuGuaLiuYaoLiuQin(liuYao.getFuGuaLiuYaoLiuQin()); // 伏卦六爻六亲
        vo.setBenGuaLiuYaoGanZhi(liuYao.getBenGuaLiuYaoGanZhi()); // 本卦六爻干支
        vo.setBianGuaLiuYaoGanZhi(liuYao.getBianGuaLiuYaoGanZhi()); // 变卦六爻干支
        vo.setHuGuaLiuYaoGanZhi(liuYao.getHuGuaLiuYaoGanZhi()); // 互卦六爻干支
        vo.setCuoGuaLiuYaoGanZhi(liuYao.getCuoGuaLiuYaoGanZhi()); // 错卦六爻干支
        vo.setZongGuaLiuYaoGanZhi(liuYao.getZongGuaLiuYaoGanZhi()); // 综卦六爻干支
        vo.setFuGuaLiuYaoGanZhi(liuYao.getFuGuaLiuYaoGanZhi()); // 伏卦六爻干支
        vo.setBenGuaLiuYaoWuXing(liuYao.getBenGuaLiuYaoWuXing()); // 本卦六爻五行
        vo.setBianGuaLiuYaoWuXing(liuYao.getBianGuaLiuYaoWuXing()); // 变卦六爻五行
        vo.setHuGuaLiuYaoWuXing(liuYao.getHuGuaLiuYaoWuXing()); // 互卦六爻五行
        vo.setCuoGuaLiuYaoWuXing(liuYao.getCuoGuaLiuYaoWuXing()); // 错卦六爻五行
        vo.setZongGuaLiuYaoWuXing(liuYao.getZongGuaLiuYaoWuXing()); // 综卦六爻五行
        vo.setFuGuaLiuYaoWuXing(liuYao.getFuGuaLiuYaoWuXing()); // 伏卦六爻五行
        vo.setBenGuaLiuYaoLiuShen(liuYao.getBenGuaLiuYaoLiuShen()); // 本卦六爻六神
        vo.setBianGuaLiuYaoLiuShen(liuYao.getBianGuaLiuYaoLiuShen()); // 变卦六爻六神
        vo.setHuGuaLiuYaoLiuShen(liuYao.getHuGuaLiuYaoLiuShen()); // 互卦六爻六神
        vo.setCuoGuaLiuYaoLiuShen(liuYao.getCuoGuaLiuYaoLiuShen()); // 错卦六爻六神
        vo.setZongGuaLiuYaoLiuShen(liuYao.getZongGuaLiuYaoLiuShen()); // 综卦六爻六神
        vo.setFuGuaLiuYaoLiuShen(liuYao.getFuGuaLiuYaoLiuShen()); // 伏卦六爻六神
        vo.setBenGuaLiuYaoYaoCi(liuYao.getBenGuaLiuYaoYaoCi()); // 本卦六爻爻辞
        vo.setBianGuaLiuYaoYaoCi(liuYao.getBianGuaLiuYaoYaoCi()); // 变卦六爻爻辞
        vo.setHuGuaLiuYaoYaoCi(liuYao.getHuGuaLiuYaoYaoCi()); // 互卦六爻爻辞
        vo.setCuoGuaLiuYaoYaoCi(liuYao.getCuoGuaLiuYaoYaoCi()); // 错卦六爻爻辞
        vo.setZongGuaLiuYaoYaoCi(liuYao.getZongGuaLiuYaoYaoCi()); // 综卦六爻爻辞
        vo.setFuGuaLiuYaoYaoCi(liuYao.getFuGuaLiuYaoYaoCi()); // 伏卦六爻爻辞
        vo.setBenGuaLiuYaoNaYin(liuYao.getBenGuaLiuYaoNaYin()); // 本卦六爻纳音
        vo.setBianGuaLiuYaoNaYin(liuYao.getBianGuaLiuYaoNaYin()); // 变卦六爻纳音
        vo.setHuGuaLiuYaoNaYin(liuYao.getHuGuaLiuYaoNaYin()); // 互卦六爻纳音
        vo.setCuoGuaLiuYaoNaYin(liuYao.getCuoGuaLiuYaoNaYin()); // 错卦六爻纳音
        vo.setZongGuaLiuYaoNaYin(liuYao.getZongGuaLiuYaoNaYin()); // 综卦六爻纳音
        vo.setFuGuaLiuYaoNaYin(liuYao.getFuGuaLiuYaoNaYin()); // 伏卦六爻纳音
        vo.setFuGuaLiuYaoFuShen(liuYao.getFuGuaLiuYaoFuShen()); // 伏卦六爻伏神

        // 4、返回数据
        return ResponseResult.result(ResponseResultEnum.SUCCESS, vo);

    }


}
