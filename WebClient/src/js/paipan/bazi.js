// 八字排盘API接口
import {
    paiPanApi, // 开始排盘
    daYunInitializeApi, // 大运流年初始化
    daYunApi, // 点击大运
    liuNianApi, // 点击流年
    liuYueApi, // 点击流月
    liuRiApi, // 点击流日
    liuShiApi, // 点击流时
    taiMingShenApi // 点击胎命身
} from '@/api/paipan/bazi-api.js'

export default {
    el: 'app',
    data() {
        return {

            // 选项
            name: '', // 姓名
            sex: 1, // 性别（0:女。1:男）
            occupy: '', // 占事
            date: '', // 日期
            dateType: 0, // 日期类型（0:公历。1:农历）
            leapMonthType: 0, // 闰月类型（0:不使用闰月。1:使用闰月）
            jieQiType: 1, // 节气类型（0:按天计算。1:按分钟计算）
            qiYunLiuPaiType: 1, // 起运流派类型（0:按天数和时辰数计算：3天1年、1天4个月、1时辰10天。1:按分钟数计算：4320分=1年、360分=1月、12分=1天、1分=2小时）
            renYuanType: 0, // 人元司令分野类型（0:子平真诠法诀。1:渊海子平法诀。2:星平会海法诀。3:三命通会法诀。4:神峰通考法诀。5:万育吾之法诀）
            daYunLunShu: 10, // 一共需要计算多少轮大运（最小10轮，最大16轮）
            yearGanZhiType: 2, // 年干支类型（0:以正月初一作为新年的开始。1:以立春当天作为新年的开始。2:以立春交接时刻作为新年的开始）
            monthGanZhiType: 1, // 月干支类型（0:以节交接当天起算。1:以节交接时刻起算）
            dayGanZhiType: 0, // 日干支类型（0:晚子时日柱按明天。1:晚子时日柱按当天）

            sexOptions: [
                { value: 1, label: '男' },
                { value: 0, label: '女' }
            ],
            dateTypeOptions: [
                { value: 0, label: '公历' },
                { value: 1, label: '农历' }
            ],
            leapMonthTypeOptions: [
                { value: 0, label: '非闰月' },
                { value: 1, label: '闰月' }
            ],
            jieQiTypeOptions: [
                { value: 0, label: '按天计算' },
                { value: 1, label: '按分钟计算' }
            ],
            qiYunLiuPaiTypeOptions: [
                { value: 0, label: '按天和时辰计算' },
                { value: 1, label: '按分钟计算' }
            ],
            renYuanTypeOptions: [
                { value: 0, label: '子平真诠法诀' },
                { value: 1, label: '渊海子平法诀' },
                { value: 2, label: '星平会海法诀' },
                { value: 3, label: '三命通会法诀' },
                { value: 4, label: '神峰通考法诀' },
                { value: 5, label: '万育吾之法诀' }
            ],
            yearGanZhiTypeOptions: [
                { value: 0, label: '以正月初一作为新年的开始' },
                { value: 1, label: '以立春当天作为新年的开始' },
                { value: 2, label: '以立春交接时刻作为新年的开始' }
            ],
            monthGanZhiTypeOptions: [
                { value: 0, label: '以节交接当天起算' },
                { value: 1, label: '以节交接时刻起算' }
            ],
            dayGanZhiTypeOptions: [
                { value: 0, label: '晚子时日干支算当天' },
                { value: 1, label: '晚子时日干支算明天' }
            ],


            // 数据
            data: {}, // 数据
            isData: false, // 数据状态（true:存在。false:不存在）
            dataPage: 1, // 数据显示界面（1:基础信息。2:命盘信息。3:更多信息）
            caiHuaTab: '1', // 正财年卡片（1:正财年。2:偏财年。3:正桃花年。4:偏桃花年）

            muCount: 0, // 五行木数量
            huoCount: 0, // 五行火数量
            tuCount: 0, // 五行土数量
            jinCount: 0, // 五行金数量
            shuiCount: 0, // 五行水数量

            mingPanMode: 2, // 左侧·命盘模式（1:四柱。2:默认。3:胎命身）
            mingPanModeStr: '默认', // 左侧·命盘模式（默认为：四柱+大运、流年）
            mingPanModeOptions: ['四柱', '默认', '胎命身'],
            daYunLiuNianMode: 1, // 大运流年显示模式（1:标准。2:详细）

            daYunData: {}, // 右侧·大运数据
            liuNianData: {}, // 右侧·流年数据
            xiaoYunData: {}, // 右侧·小运数据
            liuYueData: {}, // 右侧·流月数据
            liuRiData: {}, // 右侧·流日数据
            liuShiData: {}, // 右侧·流时数据

            isDaYunData: false, // 大运流年数据状态（true:存在。false:不存在）

            daYunDataFirst: {}, // 右侧·第一轮大运数据
            liuNianDataFirst: {}, // 右侧·第一轮流年数据
            xiaoYunDataFirst: {}, // 右侧·第一轮小运数据
            liuYueDataFirst: {}, // 右侧·第一轮流月数据

            tianGanLiuYi: {}, // 天干留意
            diZhiLiuYi: {}, // 地支留意
            tianGanLiuYiBei: {}, // 天干留意(备份)
            diZhiLiuYiBei: {}, // 地支留意(备份)

            isDaYunMingPan: true, // 左侧·是否显示大运命盘（true:是。false:否）
            isLiuNianMingPan: true, // 左侧·是否显示流年命盘（true:是。false:否）
            isLiuYueMingPan: false, // 左侧·是否显示流月命盘（true:是。false:否）
            isLiuRiMingPan: false, // 左侧·是否显示流日命盘（true:是。false:否）
            isLiuShiMingPan: false, // 左侧·是否显示流时命盘（true:是。false:否）
            isTaiYuanMingPan: false, // 左侧·是否显示胎元命盘（true:是。false:否）
            isTaiXiMingPan: false, // 左侧·是否显示胎息命盘（true:是。false:否）
            isMingGongMingPan: false, // 左侧·是否显示命宫命盘（true:是。false:否）
            isShenGongMingPan: false, // 左侧·是否显示身宫命盘（true:是。false:否）

            isLiuRiData: false, // 右侧·是否显示流日数据（true:是。false:否）
            isLiuShiData: false, // 右侧·是否显示流时数据（true:是。false:否）

            daYunLun: 1, // 大运轮
            liuNianLun: 1, // 流年轮
            liuYueLun: 0, // 流月轮
            liuRiLun: 0, // 流日轮
            liuShiLun: 0, // 流时轮

            daYunGanZhi: '', // 大运干支
            liuNianGanZhi: '', // 流年干支
            xiaoYunGanZhi: '', // 小运干支
            liuYueGanZhi: '', // 流月干支
            liuRiGanZhi: '', // 流日干支
            liuShiGanZhi: '', // 流时干支

            // 其他
            muColor: '#00ad00', // 五行木颜色
            huoColor: '#d40000', // 五行火颜色
            tuColor: '#b16400', // 五行土颜色
            jinColor: '#efa800', // 五行金颜色
            shuiColor: '#2e83f6', // 五行水颜色
            ganZhiYinYang: false, // 干支阴阳（true:阴干支显示斜体。false:阴干支不显示斜体）
            cangGanWuXingSwitch: false, // 是否显示包含藏干五行数量（true:是。false:否）

        }
    },
    watch: {
        // 藏干五行开关监听
        cangGanWuXingSwitch(val) {
            if (val) {
                this.muCount = this.data.wuXingMuCangGanCount; // 五行木数量（包含地支藏干）
                this.huoCount = this.data.wuXingHuoCangGanCount; // 五行火数量（包含地支藏干）
                this.tuCount = this.data.wuXingTuCangGanCount; // 五行土数量（包含地支藏干）
                this.jinCount = this.data.wuXingJinCangGanCount; // 五行金数量（包含地支藏干）
                this.shuiCount = this.data.wuXingShuiCangGanCount; // 五行水数量（包含地支藏干）
            } else {
                this.muCount = this.data.wuXingMuCount; // 五行木数量（不包含地支藏干）
                this.huoCount = this.data.wuXingHuoCount; // 五行火数量（不包含地支藏干）
                this.tuCount = this.data.wuXingTuCount; // 五行土数量（不包含地支藏干）
                this.jinCount = this.data.wuXingJinCount; // 五行金数量（不包含地支藏干）
                this.shuiCount = this.data.wuXingShuiCount; // 五行水数量（不包含地支藏干）
            }
        },

        // 命盘模式监听
        mingPanModeStr(val) {
            if ('四柱' === val) {
                this.mingPanMode = 1;
                this.isDaYunMingPan = false; // 左侧·是否显示大运命盘（true:是。false:否）
                this.isLiuNianMingPan = false; // 左侧·是否显示流年命盘（true:是。false:否）
                this.isLiuYueMingPan = false; // 左侧·是否显示流月命盘（true:是。false:否）
                this.isLiuRiMingPan = false; // 左侧·是否显示流日命盘（true:是。false:否）
                this.isLiuShiMingPan = false; // 左侧·是否显示流时命盘（true:是。false:否）
                this.isTaiYuanMingPan = false; // 左侧·是否显示胎元命盘（true:是。false:否）
                this.isTaiXiMingPan = false; // 左侧·是否显示胎息命盘（true:是。false:否）
                this.isMingGongMingPan = false; // 左侧·是否显示命宫命盘（true:是。false:否）
                this.isShenGongMingPan = false; // 左侧·是否显示身宫命盘（true:是。false:否）
                this.tianGanLiuYi = this.data.tianGanLiuYi; // 天干留意
                this.diZhiLiuYi = this.data.diZhiLiuYi; // 地支留意
                this.ganZhiTuJieIndex = 1; //干支图解索引，用于记录大运流年切换（1:四柱。2:四柱+大运、流年。3:四柱+大运、流年、流月。4:四柱+大运、流年、流月、流日。5:四柱+大运、流年、流月、流日、流时。6:四柱+胎元、胎息、命宫、身宫）
            } else if ('默认' === val) {
                this.mingPanMode = 2;
                this.isDaYunMingPan = true; // 左侧·是否显示大运命盘（true:是。false:否）
                this.isLiuNianMingPan = true; // 左侧·是否显示流年命盘（true:是。false:否）
                this.isLiuYueMingPan = false; // 左侧·是否显示流月命盘（true:是。false:否）
                this.isLiuRiMingPan = false; // 左侧·是否显示流日命盘（true:是。false:否）
                this.isLiuShiMingPan = false; // 左侧·是否显示流时命盘（true:是。false:否）
                this.isTaiYuanMingPan = false; // 左侧·是否显示胎元命盘（true:是。false:否）
                this.isTaiXiMingPan = false; // 左侧·是否显示胎息命盘（true:是。false:否）
                this.isMingGongMingPan = false; // 左侧·是否显示命宫命盘（true:是。false:否）
                this.isShenGongMingPan = false; // 左侧·是否显示身宫命盘（true:是。false:否）
                this.tianGanLiuYi = this.tianGanLiuYiBei; // 天干留意
                this.diZhiLiuYi = this.diZhiLiuYiBei; // 地支留意
                this.ganZhiTuJieIndex = 2; //干支图解索引，用于记录大运流年切换（1:四柱。2:四柱+大运、流年。3:四柱+大运、流年、流月。4:四柱+大运、流年、流月、流日。5:四柱+大运、流年、流月、流日、流时。6:四柱+胎元、胎息、命宫、身宫）
            } else if ('胎命身' === val) {
                // this.mingPanMode = 3;
                this.taiMingShenMethod(); // 胎命身
                this.ganZhiTuJieIndex = 6; //干支图解索引，用于记录大运流年切换（1:四柱。2:四柱+大运、流年。3:四柱+大运、流年、流月。4:四柱+大运、流年、流月、流日。5:四柱+大运、流年、流月、流日、流时。6:四柱+胎元、胎息、命宫、身宫）
            }
        }
    },
    created() {
        this.date = new Date();
    },
    mounted() {
        // this.$refs.videoRef.addEventListener('ended', this.restartVideoMethod()); // 播放MP4
    },
    methods: {

        /**
         * 播放MP4
         */
        restartVideoMethod() {

            this.$refs.videoRef.currentTime = 0;
            this.$refs.videoRef.play();

        },

        /**
         * 开始排盘
         */
        paiPanMethod() {

            // 条件构造
            let query = {
                name: this.name, // 姓名
                sex: this.sex, // 性别（0:女。1:男）
                occupy: this.occupy, // 占事
                date: this.date, // 日期
                dateType: this.dateType, // 日期类型（0:公历。1:农历）
                leapMonthType: this.leapMonthType, // 闰月类型（0:不使用闰月。1:使用闰月）
                jieQiType: this.jieQiType, // 节气类型（0:按天计算。1:按分钟计算）
                qiYunLiuPaiType: this.qiYunLiuPaiType, // 起运流派类型（0:按天数和时辰数计算：3天1年、1天4个月、1时辰10天。1:按分钟数计算：4320分=1年、360分=1月、12分=1天、1分=2小时）
                renYuanType: this.renYuanType, // 人元司令分野类型（0:子平真诠法诀。1:渊海子平法诀。2:星平会海法诀。3:三命通会法诀。4:神峰通考法诀。5:万育吾之法诀）
                daYunLunShu: this.daYunLunShu, // 一共需要计算多少轮大运（最小10轮，最大16轮）
                yearGanZhiType: this.yearGanZhiType, // 年干支类型（0:以正月初一作为新年的开始。1:以立春当天作为新年的开始。2:以立春交接时刻作为新年的开始）
                monthGanZhiType: this.monthGanZhiType, // 月干支类型（0:以节交接当天起算。1:以节交接时刻起算）
                dayGanZhiType: this.dayGanZhiType // 日干支类型（0:晚子时日柱按明天。1:晚子时日柱按当天）
            }

            // 发送请求
            paiPanApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    this.data = data; // 排盘数据

                    this.isData = true; // 数据状态（true:存在。false:不存在）
                }
            })

        },

        /**
         * 切换大运流年显示模式
         */
        daYunLiuNianModeMethod() {

            this.daYunLiuNianMode = (this.daYunLiuNianMode === 1) ? 2 : 1;

        },

        /**
         * 大运流年初始化
         */
        daYunInitializeMethod() {

            // 判断是否已初始化大运流年
            if (this.isDaYunData) {
                this.dataPage = 2; // 数据显示界面（1:基础信息。2:命盘信息）
                return;
            }

            // 条件构造
            let query = {
                solarDate: this.data.solarDate, // 公历出生日期
                sex: '男' === this.data.sex ? 1 : 0, // 性别
                yearGanZhiType: this.yearGanZhiType, // 年干支类型
                monthGanZhiType: this.monthGanZhiType, // 月干支类型
                dayGanZhiType: this.dayGanZhiType, // 日干支类型
                qiYunLiuPaiType: this.qiYunLiuPaiType, // 起运流派类型
                daYunLunShu: this.daYunLunShu // 一共需要计算多少轮大运
            }

            // 发送请求
            daYunInitializeApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    this.daYunData = data.daYun; // 右侧·大运数据
                    this.liuNianData = data.liuNian; // 右侧·流年数据
                    this.xiaoYunData = data.xiaoYun; // 右侧·小运数据
                    this.liuYueData = data.liuYue; // 右侧·流月数据

                    this.daYunDataFirst = data.daYun; // 右侧·第一轮大运数据
                    this.liuNianDataFirst = data.liuNian; // 右侧·第一轮流年数据
                    this.xiaoYunDataFirst = data.xiaoYun; // 右侧·第一轮小运数据
                    this.liuYueDataFirst = data.liuYue; // 右侧·第一轮流月数据

                    this.tianGanLiuYi = data.tianGanLiuYi; // 天干留意
                    this.diZhiLiuYi = data.diZhiLiuYi; // 地支留意
                    this.tianGanLiuYiBei = data.tianGanLiuYi; // 天干留意(备份)
                    this.diZhiLiuYiBei = data.diZhiLiuYi; // 地支留意(备份)

                    // 设置初始大运干支、流年干支
                    if (this.xiaoYunData.length === 0) {
                        this.daYunGanZhi = data.daYunData[1].ganZhi; // 大运干支。若小运数据个数为0，直接取第一轮的第一个大运干支
                        this.liuNianGanZhi = data.liuNian[0].ganZhi; // 流年干支。
                    } else {
                        this.daYunGanZhi = data.xiaoYun[0].ganZhi; // 大运干支。将大运干支替换为第一轮的第一个小运干支
                        this.liuNianGanZhi = data.liuNian[0].ganZhi; // 流年干支。
                    }

                    this.isDaYunData = true; // 数据状态（true:存在。false:不存在）
                    this.dataPage = 2; // 数据显示界面（1:基础信息。2:命盘信息。3:更多信息）
                }
            })

        },

        /**
         * 点击大运
         * 
         * @param daYunLun       大运轮
         * @param daYunGanZhi    大运干支
         * @param daYunSolarDate 大运公历日期
         */
        daYunMethod(daYunLun, daYunGanZhi, daYunSolarDate) {

            this.mingPanMode = 2; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.mingPanModeStr = '默认'; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.daYunLun = daYunLun; // 设置大运轮
            this.isDaYunMingPan = true; // 左侧·是否显示大运命盘（true:是。false:否）
            this.isLiuNianMingPan = true; // 左侧·是否显示流年命盘（true:是。false:否）
            this.isLiuYueMingPan = false; // 左侧·是否显示流月命盘（true:是。false:否）
            this.isLiuRiMingPan = false; // 左侧·是否显示流日命盘（true:是。false:否）
            this.isLiuShiMingPan = false; // 左侧·是否显示流时命盘（true:是。false:否）
            this.isTaiYuanMingPan = false; // 左侧·是否显示胎元命盘（true:是。false:否）
            this.isTaiXiMingPan = false; // 左侧·是否显示胎息命盘（true:是。false:否）
            this.isMingGongMingPan = false; // 左侧·是否显示命宫命盘（true:是。false:否）
            this.isShenGongMingPan = false; // 左侧·是否显示身宫命盘（true:是。false:否）
            this.isLiuRiData = false; // 右侧·是否显示流日数据（true:是。false:否）
            this.isLiuShiData = false; // 右侧·是否显示流时数据（true:是。false:否）
            this.liuNianLun = 1; // 重置流年轮
            this.liuYueLun = 0; // 重置流月轮
            this.liuRiLun = 0; // 重置流日轮
            this.liuShiLun = 0; // 重置流时轮
            this.liuRiData = {}; // 清空流日数据
            this.liuShiData = {}; // 清空流时数据

            // 处理大运干支
            if (daYunLun === 1) {
                this.liuNianLun = 1; // 流年轮数重置为第一轮
                if (this.xiaoYunData.length === 0) {
                    this.daYunGanZhi = this.daYunData[1].ganZhi; // 大运干支
                } else {
                    this.daYunGanZhi = this.xiaoYunDataFirst[0].ganZhi; // 大运干支
                }
            } else {
                this.daYunGanZhi = daYunGanZhi; // 大运干支
            }

            // 条件构造
            let query = {
                solarDate: this.data.solarDate, // 公历出生日期
                sex: '男' === this.data.sex ? 1 : 0, // 性别
                yearGanZhiType: this.yearGanZhiType, // 年干支类型
                monthGanZhiType: this.monthGanZhiType, // 月干支类型
                dayGanZhiType: this.dayGanZhiType, // 日干支类型
                qiYunLiuPaiType: this.qiYunLiuPaiType, // 起运流派类型
                daYunLunShu: this.daYunLunShu, // 一共需要计算多少轮大运
                daYunGanZhi: this.daYunGanZhi, // 大运干支
                daYunLun: daYunLun, // 大运轮
                liuNianLun: this.liuNianLun, // 流年轮
                daYunSolarDate: daYunSolarDate // 大运公历日期
            }

            // 发送请求
            daYunApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    this.liuNianData = data.liuNian; // 右侧·流年数据
                    this.xiaoYunData = data.xiaoYun; // 右侧·小运数据
                    this.liuYueData = data.liuYue; // 右侧·流月数据

                    this.tianGanLiuYi = data.tianGanLiuYi; // 天干留意
                    this.diZhiLiuYi = data.diZhiLiuYi; // 地支留意
                    this.tianGanLiuYiBei = data.tianGanLiuYi; // 天干留意(备份)
                    this.diZhiLiuYiBei = data.diZhiLiuYi; // 地支留意(备份)

                    this.liuNianGanZhi = data.liuNian[0].ganZhi; // 流年干支
                }
            })

        },

        /**
         * 点击流年
         * 
         * @param liuNianLun       流年轮
         * @param liuNianGanZhi    流年干支
         * @param liuNianSolarDate 流年公历日期
         */
        liuNianMethod(liuNianLun, liuNianGanZhi, liuNianSolarDate) {

            this.mingPanMode = 2; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.mingPanModeStr = '默认'; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.liuNianLun = liuNianLun; // 设置流年轮
            this.liuNianGanZhi = liuNianGanZhi; // 设置流年干支
            this.isDaYunMingPan = true; // 左侧·是否显示大运命盘（true:是。false:否）
            this.isLiuNianMingPan = true; // 左侧·是否显示流年命盘（true:是。false:否）
            this.isLiuYueMingPan = false; // 左侧·是否显示流月命盘（true:是。false:否）
            this.isLiuRiMingPan = false; // 左侧·是否显示流日命盘（true:是。false:否）
            this.isLiuShiMingPan = false; // 左侧·是否显示流时命盘（true:是。false:否）
            this.isTaiYuanMingPan = false; // 左侧·是否显示胎元命盘（true:是。false:否）
            this.isTaiXiMingPan = false; // 左侧·是否显示胎息命盘（true:是。false:否）
            this.isMingGongMingPan = false; // 左侧·是否显示命宫命盘（true:是。false:否）
            this.isShenGongMingPan = false; // 左侧·是否显示身宫命盘（true:是。false:否）
            this.isLiuRiData = false; // 右侧·是否显示流日数据（true:是。false:否）
            this.isLiuShiData = false; // 右侧·是否显示流时数据（true:是。false:否）
            this.liuYueLun = 0; // 重置流月轮
            this.liuRiLun = 0; // 重置流日轮
            this.liuShiLun = 0; // 重置流时轮
            this.liuRiData = {}; // 清空流日数据
            this.liuShiData = {}; // 清空流时数据

            // 处理大运干支
            if (this.daYunLun === 1) {
                if (this.xiaoYunData.length === 0) {
                    this.daYunGanZhi = this.daYunData[daYunLun - 1].ganZhi; // 大运干支
                } else {
                    this.daYunGanZhi = this.xiaoYunDataFirst[liuNianLun - 1].ganZhi; // 大运干支
                }
            }

            // 条件构造
            let query = {
                solarDate: this.data.solarDate, // 公历出生日期
                sex: '男' === this.data.sex ? 1 : 0, // 性别
                yearGanZhiType: this.yearGanZhiType, // 年干支类型
                monthGanZhiType: this.monthGanZhiType, // 月干支类型
                dayGanZhiType: this.dayGanZhiType, // 日干支类型
                qiYunLiuPaiType: this.qiYunLiuPaiType, // 起运流派类型
                daYunLunShu: this.daYunLunShu, // 一共需要计算多少轮大运
                daYunGanZhi: this.daYunGanZhi, // 大运干支
                liuNianGanZhi: liuNianGanZhi, // 流年干支
                daYunLun: this.daYunLun, // 大运轮
                liuNianLun: liuNianLun, // 流年轮
                liuNianSolarDate: liuNianSolarDate // 流年公历日期
            }

            // 发送请求
            liuNianApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    this.liuYueData = data.liuYue; // 右侧·流月数据

                    this.tianGanLiuYi = data.tianGanLiuYi; // 天干留意
                    this.diZhiLiuYi = data.diZhiLiuYi; // 地支留意
                    this.tianGanLiuYiBei = data.tianGanLiuYi; // 天干留意(备份)
                    this.diZhiLiuYiBei = data.diZhiLiuYi; // 地支留意(备份)
                }
            })

        },

        /**
         * 点击流月
         * 
         * @param liuYueLun    流月轮
         * @param liuYueGanZhi 流月干支
         * @param solarDate    流月公历日期
         */
        liuYueMethod(liuYueLun, liuYueGanZhi, liuYueSolarDate) {

            this.mingPanMode = 2; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.mingPanModeStr = '默认'; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.liuYueLun = liuYueLun; // 设置流月轮
            this.liuYueGanZhi = liuYueGanZhi; // 设置流月干支
            this.isDaYunMingPan = true; // 左侧·是否显示大运命盘（true:是。false:否）
            this.isLiuNianMingPan = true; // 左侧·是否显示流年命盘（true:是。false:否）
            // this.isLiuYueMingPan = true; // 左侧·是否显示流月命盘（true:是。false:否）
            this.isLiuRiMingPan = false; // 左侧·是否显示流日命盘（true:是。false:否）
            this.isLiuShiMingPan = false; // 左侧·是否显示流时命盘（true:是。false:否）
            this.isTaiYuanMingPan = false; // 左侧·是否显示胎元命盘（true:是。false:否）
            this.isTaiXiMingPan = false; // 左侧·是否显示胎息命盘（true:是。false:否）
            this.isMingGongMingPan = false; // 左侧·是否显示命宫命盘（true:是。false:否）
            this.isShenGongMingPan = false; // 左侧·是否显示身宫命盘（true:是。false:否）
            this.isLiuShiData = false; // 右侧·是否显示流时数据（true:是。false:否）
            this.liuRiLun = 0; // 重置流日轮
            this.liuShiLun = 0; // 重置流时轮
            this.liuShiData = {}; // 清空流时数据

            // 条件构造
            let query = {
                solarDate: this.data.solarDate, // 公历出生日期
                sex: '男' === this.data.sex ? 1 : 0, // 性别
                yearGanZhiType: this.yearGanZhiType, // 年干支类型
                monthGanZhiType: this.monthGanZhiType, // 月干支类型
                dayGanZhiType: this.dayGanZhiType, // 日干支类型
                qiYunLiuPaiType: this.qiYunLiuPaiType, // 起运流派类型
                daYunGanZhi: this.daYunGanZhi, // 大运干支
                liuNianGanZhi: this.liuNianGanZhi, // 流年干支
                liuYueGanZhi: liuYueGanZhi, // 流月干支
                liuYueSolarDate: liuYueSolarDate // 流月公历日期
            }

            // 发送请求
            liuYueApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    this.liuRiData = data.liuRi; // 右侧·流日数据

                    this.tianGanLiuYi = data.tianGanLiuYi; // 天干留意
                    this.diZhiLiuYi = data.diZhiLiuYi; // 地支留意
                    this.tianGanLiuYiBei = data.tianGanLiuYi; // 天干留意(备份)
                    this.diZhiLiuYiBei = data.diZhiLiuYi; // 地支留意(备份)

                    this.isLiuYueMingPan = true; // 左侧·是否显示流月命盘（true:是。false:否）
                    this.isLiuRiData = true; // 右侧·是否显示流日数据（true:是。false:否）
                }
            })

        },

        /**
         * 点击流日
         * 
         * @param liuRiLun    流日轮
         * @param liuRiGanZhi 流日干支
         * @param solarDate   流日公历日期
         */
        liuRiMethod(liuRiLun, liuRiGanZhi, liuRiSolarDate) {

            this.mingPanMode = 2; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.mingPanModeStr = '默认'; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.liuRiLun = liuRiLun; // 设置流日轮
            this.liuRiGanZhi = liuRiGanZhi; // 设置流日干支
            this.isDaYunMingPan = true; // 左侧·是否显示大运命盘（true:是。false:否）
            this.isLiuNianMingPan = true; // 左侧·是否显示流年命盘（true:是。false:否）
            this.isLiuYueMingPan = true; // 左侧·是否显示流月命盘（true:是。false:否）
            // this.isLiuRiMingPan = true; // 左侧·是否显示流日命盘（true:是。false:否）
            this.isLiuShiMingPan = false; // 左侧·是否显示流时命盘（true:是。false:否）
            this.isTaiYuanMingPan = false; // 左侧·是否显示胎元命盘（true:是。false:否）
            this.isTaiXiMingPan = false; // 左侧·是否显示胎息命盘（true:是。false:否）
            this.isMingGongMingPan = false; // 左侧·是否显示命宫命盘（true:是。false:否）
            this.isShenGongMingPan = false; // 左侧·是否显示身宫命盘（true:是。false:否）
            this.liuShiLun = 0; // 重置流时轮

            // 条件构造
            let query = {
                solarDate: this.data.solarDate, // 公历出生日期
                sex: '男' === this.data.sex ? 1 : 0, // 性别
                yearGanZhiType: this.yearGanZhiType, // 年干支类型
                monthGanZhiType: this.monthGanZhiType, // 月干支类型
                dayGanZhiType: this.dayGanZhiType, // 日干支类型
                qiYunLiuPaiType: this.qiYunLiuPaiType, // 起运流派类型
                daYunGanZhi: this.daYunGanZhi, // 大运干支
                liuNianGanZhi: this.liuNianGanZhi, // 流年干支
                liuYueGanZhi: this.liuYueGanZhi, // 流月干支
                liuRiGanZhi: liuRiGanZhi, // 流日干支
                liuRiSolarDate: liuRiSolarDate // 流日公历日期
            }

            // 发送请求
            liuRiApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    this.liuShiData = data.liuShi; // 右侧·流时数据

                    this.tianGanLiuYi = data.tianGanLiuYi; // 天干留意
                    this.diZhiLiuYi = data.diZhiLiuYi; // 地支留意
                    this.tianGanLiuYiBei = data.tianGanLiuYi; // 天干留意(备份)
                    this.diZhiLiuYiBei = data.diZhiLiuYi; // 地支留意(备份)

                    this.isLiuRiMingPan = true; // 左侧·是否显示流日命盘（true:是。false:否）
                    this.isLiuShiData = true; // 右侧·是否显示流时数据（true:是。false:否）
                }
            })

        },

        /**
         * 点击流时
         * 
         * @param liuShiLun    流时轮
         * @param liuShiGanZhi 流时干支
         */
        liuShiMethod(liuShiLun, liuShiGanZhi) {

            this.mingPanMode = 2; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.mingPanModeStr = '默认'; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.liuShiLun = liuShiLun; // 设置流时轮
            this.liuShiGanZhi = liuShiGanZhi; // 设置流时干支
            this.isDaYunMingPan = true; // 左侧·是否显示大运命盘（true:是。false:否）
            this.isLiuNianMingPan = true; // 左侧·是否显示流年命盘（true:是。false:否）
            this.isLiuYueMingPan = true; // 左侧·是否显示流月命盘（true:是。false:否）
            this.isLiuRiMingPan = true; // 左侧·是否显示流日命盘（true:是。false:否）
            // this.isLiuShiMingPan = true; // 左侧·是否显示流时命盘（true:是。false:否）
            this.isTaiYuanMingPan = false; // 左侧·是否显示胎元命盘（true:是。false:否）
            this.isTaiXiMingPan = false; // 左侧·是否显示胎息命盘（true:是。false:否）
            this.isMingGongMingPan = false; // 左侧·是否显示命宫命盘（true:是。false:否）
            this.isShenGongMingPan = false; // 左侧·是否显示身宫命盘（true:是。false:否）

            // 条件构造
            let query = {
                solarDate: this.data.solarDate, // 公历出生日期
                sex: '男' === this.data.sex ? 1 : 0, // 性别
                yearGanZhiType: this.yearGanZhiType, // 年干支类型
                monthGanZhiType: this.monthGanZhiType, // 月干支类型
                dayGanZhiType: this.dayGanZhiType, // 日干支类型
                qiYunLiuPaiType: this.qiYunLiuPaiType, // 起运流派类型
                daYunGanZhi: this.daYunGanZhi, // 大运干支
                liuNianGanZhi: this.liuNianGanZhi, // 流年干支
                liuYueGanZhi: this.liuYueGanZhi, // 流月干支
                liuRiGanZhi: this.liuRiGanZhi, // 流日干支
                liuShiGanZhi: liuShiGanZhi, // 流时干支
                yearGanZhi: this.data.yearGanZhi, // 年干支
                monthGanZhi: this.data.monthGanZhi, // 月干支
                dayGanZhi: this.data.dayGanZhi, // 日干支
                hourGanZhi: this.data.hourGanZhi, // 时干支
                jiJie: this.data.jiJie, // 季节
                yearGanZhiNaYinWuXing: this.data.yearGanZhiNaYin.substring(2, 3) // 年干支纳音五行
            }

            // 发送请求
            liuShiApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    this.tianGanLiuYi = data.tianGanLiuYi; // 天干留意
                    this.diZhiLiuYi = data.diZhiLiuYi; // 地支留意
                    this.tianGanLiuYiBei = data.tianGanLiuYi; // 天干留意(备份)
                    this.diZhiLiuYiBei = data.diZhiLiuYi; // 地支留意(备份)

                    this.isLiuShiMingPan = true; // 左侧·是否显示流时命盘（true:是。false:否）
                }
            })

        },

        /**
         * 点击胎命身
         */
        taiMingShenMethod() {

            // 条件构造
            let query = {
                yearGanZhi: this.data.yearGanZhi, // 年干支
                monthGanZhi: this.data.monthGanZhi, // 月干支
                dayGanZhi: this.data.dayGanZhi, // 日干支
                hourGanZhi: this.data.hourGanZhi, // 时干支
                taiYuanGanZhi: this.data.taiYuanGanZhi, // 胎元干支
                taiXiGanZhi: this.data.taiXiGanZhi, // 胎息干支
                mingGongGanZhi: this.data.mingGongGanZhi, // 命宫干支
                shenGongGanZhi: this.data.shenGongGanZhi // 身宫干支
            }

            // 发送请求
            taiMingShenApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    this.tianGanLiuYi = data.tianGanLiuYi; // 天干留意
                    this.diZhiLiuYi = data.diZhiLiuYi; // 地支留意

                    this.isDaYunMingPan = false; // 左侧·是否显示大运命盘（true:是。false:否）
                    this.isLiuNianMingPan = false; // 左侧·是否显示流年命盘（true:是。false:否）
                    this.isLiuYueMingPan = false; // 左侧·是否显示流月命盘（true:是。false:否）
                    this.isLiuRiMingPan = false; // 左侧·是否显示流日命盘（true:是。false:否）
                    this.isLiuShiMingPan = false; // 左侧·是否显示流时命盘（true:是。false:否）
                    this.isTaiYuanMingPan = true; // 左侧·是否显示胎元命盘（true:是。false:否）
                    this.isTaiXiMingPan = true; // 左侧·是否显示胎息命盘（true:是。false:否）
                    this.isMingGongMingPan = true; // 左侧·是否显示命宫命盘（true:是。false:否）
                    this.isShenGongMingPan = true; // 左侧·是否显示身宫命盘（true:是。false:否）
                }
            })

        },

        /**
         * 返回排盘
         */
        fanHuiPaiPanMethod() {

            this.isData = false; // 数据状态（true:存在。false:不存在）
            this.data = {}, // 数据
            this.dataPage = 1; // 数据显示界面（1:基础信息。2:命盘信息。3:更多信息）
            this.caiHuaTab = '1'; // 正财年卡片
            this.isDaYunData = false; // 大运流年数据状态（true:存在。false:不存在）

            this.mingPanMode = 1; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.mingPanModeStr = '默认'; // 左侧·命盘类型（1:四柱。2:默认。3:胎命身）
            this.daYunLiuNianMode = 1; // 大运流年显示模式（1:标准。2:详细）

            this.isDaYunMingPan = true; // 左侧·是否显示大运命盘（true:是。false:否）
            this.isLiuNianMingPan = true; // 左侧·是否显示流年命盘（true:是。false:否）
            this.isLiuYueMingPan = false; // 左侧·是否显示流月命盘（true:是。false:否）
            this.isLiuRiMingPan = false; // 左侧·是否显示流日命盘（true:是。false:否）
            this.isLiuShiMingPan = false; // 左侧·是否显示流时命盘（true:是。false:否）
            this.isTaiYuanMingPan = false; // 左侧·是否显示胎元命盘（true:是。false:否）
            this.isTaiXiMingPan = false; // 左侧·是否显示胎息命盘（true:是。false:否）
            this.isMingGongMingPan = false; // 左侧·是否显示命宫命盘（true:是。false:否）
            this.isShenGongMingPan = false; // 左侧·是否显示身宫命盘（true:是。false:否）

            this.isLiuRiData = false; // 右侧·是否显示流日数据（true:是。false:否）
            this.isLiuShiData = false; // 右侧·是否显示流时数据（true:是。false:否）

            this.daYunLun = 1; // 大运轮
            this.liuNianLun = 1; // 流年轮
            this.liuYueLun = 0; // 流月轮
            this.liuRiLun = 0; // 流日轮
            this.liuShiLun = 0; // 流时轮

        },

        /**
         * 切换为基础信息
         */
        jiChuMethod() {

            this.dataPage = 1; // 数据显示界面（1:基础信息。2:命盘信息。3:更多信息）

        },

        /**
         * 切换为命盘信息
         */
        mingPanMethod() {

            this.daYunInitializeMethod(); // 大运流年初始化

        },

        /**
         * 切换为更多信息
         */
        gengDuoMethod() {

            this.dataPage = 3; // 数据显示界面（1:基础信息。2:命盘信息。3:更多信息）

        },

        /**
         * 干支高亮（区分阴阳）
         * 
         * @param ganOrZhi 天干或地支
         */
        ganZhiGaoLiangMethod(ganOrZhi) {

            // 阳干支
            if ('甲' === ganOrZhi || '寅' === ganOrZhi) return ('<font color="' + this.muColor + '">' + ganOrZhi + '</font>');
            if ('丙' === ganOrZhi || '午' === ganOrZhi) return ('<font color="' + this.huoColor + '">' + ganOrZhi + '</font>');
            if ('戊' == ganOrZhi || '辰' === ganOrZhi || '戌' === ganOrZhi) return ('<font color="' + this.tuColor + '">' + ganOrZhi + '</font>');
            if ('庚' === ganOrZhi || '申' === ganOrZhi) return ('<font color="' + this.jinColor + '">' + ganOrZhi + '</font>');
            if ('壬' === ganOrZhi || '子' === ganOrZhi) return ('<font color="' + this.shuiColor + '">' + ganOrZhi + '</font>');

            // 阴干支
            if ('乙' === ganOrZhi || '卯' === ganOrZhi) {
                if (this.ganZhiYinYang) return ('<font color="' + this.muColor + '"><i>' + ganOrZhi + '</i></font>');
                return ('<font color="' + this.muColor + '">' + ganOrZhi + '</font>');
            }
            if ('丁' === ganOrZhi || '巳' === ganOrZhi) {
                if (this.ganZhiYinYang) return ('<font color="' + this.huoColor + '"><i>' + ganOrZhi + '</i></font>');
                return ('<font color="' + this.huoColor + '">' + ganOrZhi + '</font>');
            }
            if ('己' === ganOrZhi || '丑' === ganOrZhi || '未' === ganOrZhi) {
                if (this.ganZhiYinYang) return ('<font color="' + this.tuColor + '"><i>' + ganOrZhi + '</i></font>');
                return ('<font color="' + this.tuColor + '">' + ganOrZhi + '</font>');
            }
            if ('辛' === ganOrZhi || '酉' === ganOrZhi) {
                if (this.ganZhiYinYang) return ('<font color="' + this.jinColor + '"><i>' + ganOrZhi + '</i></font>');
                return ('<font color="' + this.jinColor + '">' + ganOrZhi + '</font>');
            }
            if ('癸' === ganOrZhi || '亥' === ganOrZhi) {
                if (this.ganZhiYinYang) return ('<font color="' + this.shuiColor + '"><i>' + ganOrZhi + '</i></font>');
                return ('<font color="' + this.shuiColor + '">' + ganOrZhi + '</font>');
            }

        },

        /**
         * 干支高亮2（区分阴阳）
         * 
         * @param ganZhi 干支
         */
        ganZhiGaoLiangMethod2(ganZhi) {

            let gan = ganZhi.substring(0, 1); // 天干
            let zhi = ganZhi.substring(1, 2); // 地支

            if ('甲' === gan) {
                gan = ('<font color="' + this.muColor + '">' + gan + '</font>');
            } else if ('丙' === gan) {
                gan = ('<font color="' + this.huoColor + '">' + gan + '</font>');
            } else if ('戊' === gan) {
                gan = ('<font color="' + this.tuColor + '">' + gan + '</font>');
            } else if ('庚' === gan) {
                gan = ('<font color="' + this.jinColor + '">' + gan + '</font>');
            } else if ('壬' === gan) {
                gan = ('<font color="' + this.shuiColor + '">' + gan + '</font>');
            } else if ('乙' === gan) {
                gan = this.ganZhiYinYang ? ('<font color="' + this.muColor + '"><i>' + gan + '</i></font>') : ('<font color="' + this.muColor + '">' + gan + '</font>');
            } else if ('丁' === gan) {
                gan = this.ganZhiYinYang ? ('<font color="' + this.huoColor + '"><i>' + gan + '</i></font>') : ('<font color="' + this.huoColor + '">' + gan + '</font>');
            } else if ('己' === gan) {
                gan = this.ganZhiYinYang ? ('<font color="' + this.tuColor + '"><i>' + gan + '</i></font>') : ('<font color="' + this.tuColor + '">' + gan + '</font>');
            } else if ('辛' === gan) {
                gan = this.ganZhiYinYang ? ('<font color="' + this.jinColor + '"><i>' + gan + '</i></font>') : ('<font color="' + this.jinColor + '">' + gan + '</font>');
            } else if ('癸' === gan) {
                gan = this.ganZhiYinYang ? ('<font color="' + this.shuiColor + '"><i>' + gan + '</i></font>') : ('<font color="' + this.shuiColor + '">' + gan + '</font>');
            }

            if ('寅' === zhi) {
                zhi = ('<font color="' + this.muColor + '">' + zhi + '</font>');
            } else if ('午' === zhi) {
                zhi = ('<font color="' + this.huoColor + '">' + zhi + '</font>');
            } else if ('辰' === zhi || '戌' === zhi) {
                zhi = ('<font color="' + this.tuColor + '">' + zhi + '</font>');
            } else if ('申' === zhi) {
                zhi = ('<font color="' + this.jinColor + '">' + zhi + '</font>');
            } else if ('子' === zhi) {
                zhi = ('<font color="' + this.shuiColor + '">' + zhi + '</font>');
            } else if ('卯' === zhi) {
                zhi = this.ganZhiYinYang ? ('<font color="' + this.muColor + '"><i>' + zhi + '</i></font>') : ('<font color="' + this.muColor + '">' + zhi + '</font>');
            } else if ('巳' === zhi) {
                zhi = this.ganZhiYinYang ? ('<font color="' + this.huoColor + '"><i>' + zhi + '</i></font>') : ('<font color="' + this.huoColor + '">' + zhi + '</font>');
            } else if ('丑' === zhi || '未' == zhi) {
                zhi = this.ganZhiYinYang ? ('<font color="' + this.tuColor + '"><i>' + zhi + '</i></font>') : ('<font color="' + this.tuColor + '">' + zhi + '</font>');
            } else if ('酉' === zhi) {
                zhi = this.ganZhiYinYang ? ('<font color="' + this.jinColor + '"><i>' + zhi + '</i></font>') : ('<font color="' + this.jinColor + '">' + zhi + '</font>');
            } else if ('亥' === zhi) {
                zhi = this.ganZhiYinYang ? ('<font color="' + this.shuiColor + '"><i>' + zhi + '</i></font>') : ('<font color="' + this.shuiColor + '">' + zhi + '</font>');
            }

            return gan + zhi;

        },

        /**
         * 干支五行高亮
         * 
         * @param ganOrZhi 天干或地支
         */
        ganZhiInWuXingGaoLiangMethod(ganOrZhi) {

            if ('甲' === ganOrZhi || '乙' === ganOrZhi || '寅' === ganOrZhi || '卯' === ganOrZhi) {
                return ('<font color="' + this.muColor + '">木</font>');
            }
            if ('丙' === ganOrZhi || '丁' === ganOrZhi || '巳' === ganOrZhi || '午' === ganOrZhi) {
                return ('<font color="' + this.huoColor + '">火</font>');
            }
            if ('戊' === ganOrZhi || '己' === ganOrZhi || '辰' === ganOrZhi || '戌' === ganOrZhi || '丑' === ganOrZhi || '未' === ganOrZhi) {
                return ('<font color="' + this.tuColor + '">土</font>');
            }
            if ('庚' == ganOrZhi || '辛' === ganOrZhi || '申' === ganOrZhi || '酉' === ganOrZhi) {
                return ('<font color="' + this.jinColor + '">金</font>');
            }
            if ('壬' === ganOrZhi || '癸' === ganOrZhi || '亥' === ganOrZhi || '子' === ganOrZhi) {
                return ('<font color="' + this.shuiColor + '">水</font>');
            }

        },

        /**
         * 五行高亮
         * 
         * @param wuXing 五行
         */
        wuXingGaoLiangMethod(wuXing) {

            let data = '';
            for (var i = 0; i < wuXing.length; i++) {
                if ('木' === wuXing[i]) {
                    data += ('<font color=' + this.muColor + '">木</font>');
                } else if ('火' === wuXing[i]) {
                    data += ('<font color="' + this.huoColor + '">火</font>');
                } else if ('土' === wuXing[i]) {
                    data += ('<font color="' + this.tuColor + '">土</font>');
                } else if ('金' === wuXing[i]) {
                    data += ('<font color="' + this.jinColor + '">金</font>');
                } else if ('水' === wuXing[i]) {
                    data += ('<font color="' + this.shuiColor + '">水</font>');
                }
            }

            return data;

        },

        /**
         * 五行高亮2
         * 
         * @param wuXing 两个五行
         */
        wuXingGaoLiangMethod2(wuXing) {

            let l = wuXing.substring(0, 1);

            if ('木' == l) {
                return ('<font color="' + this.muColor + '">' + wuXing + '</font>');
            }
            if ('火' == l) {
                return ('<font color="' + this.huoColor + '">' + wuXing + '</font>');
            }
            if ('土' == l) {
                return ('<font color="' + this.tuColor + '">' + wuXing + '</font>');
            }
            if ('金' == l) {
                return ('<font color="' + this.jinColor + '">' + wuXing + '</font>');
            }
            if ('水' == l) {
                return ('<font color="' + this.shuiColor + '">' + wuXing + '</font>');
            }

        },

    }
}
