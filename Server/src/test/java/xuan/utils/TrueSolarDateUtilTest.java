package xuan.utils;

import org.junit.Test;
import xuan.utils.DateUtil;
import xuan.utils.TrueSolarDateUtil;

import java.util.Date;

/**
 * 真太阳时测试
 *
 * @author 善待
 */
public class TrueSolarDateUtilTest {

    /**
     * 真太阳时
     */
    @Test
    public void baZiTest() {

        Date date = new Date();
        Date trueSolarDate = TrueSolarDateUtil.getTrueSolarDate(date, 116.23); // 获取真太阳时

        String dateStr = DateUtil.dateToString(date);
        String trueSolarDateStr = DateUtil.dateToString(trueSolarDate);

        System.out.println("标准日期：" + dateStr);
        System.out.println("真太阳时日期：" + trueSolarDateStr);

    }


}
