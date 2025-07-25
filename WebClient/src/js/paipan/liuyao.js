// 六爻排盘API接口
import {
    paiPanApi, // 开始排盘
} from '@/api/paipan/liuyao-api.js'

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
            paiPanType: 0, // 排盘类型（0:日期。1:自动。2:手动）
            liuYao: 0, // 上爻（六爻）
            wuYao: 0, // 五爻
            siYao: 0, // 四爻
            sanYao: 0, // 三爻
            erYao: 0, // 二爻
            yiYao: 0, // 初爻（一爻）
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
            paiPanTypeOptions: [
                { value: 0, label: '日期' },
                { value: 1, label: '自动' },
                { value: 1, label: '手动' }
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
            yaoOptions: [
                { value: 0, label: '—（2正1背）' },
                { value: 1, label: '- -（1正2背）' },
                { value: 2, label: '— ○（0正3背）' },
                { value: 3, label: '- - ×（3正0背）' }
              ],


            // 数据
            data: {}, // 数据
            isData: false, // 数据状态（true:存在。false:不存在）
            dataPage: 1, // 数据显示界面（1:基础信息）
            liuYaoIndex: [5, 4, 3, 2, 1, 0], // 六爻从上至下索引

            // 其他
            muColor: '#00ad00', // 五行木颜色
            huoColor: '#d40000', // 五行火颜色
            tuColor: '#b16400', // 五行土颜色
            jinColor: '#efa800', // 五行金颜色
            shuiColor: '#2e83f6', // 五行水颜色

        }
    },
    watch: {
        
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
                paiPanType: this.paiPanType, // 排盘类型
                liuYao: this.liuYao, // 上爻（六爻）
                wuYao: this.wuYao, // 五爻
                siYao: this.siYao, // 四爻
                sanYao: this.sanYao, // 三爻
                erYao: this.erYao, // 二爻
                yiYao: this.yiYao, // 初爻（一爻）
                yearGanZhiType: this.yearGanZhiType, // 年干支类型（0:以正月初一作为新年的开始。1:以立春当天作为新年的开始。2:以立春交接时刻作为新年的开始）
                monthGanZhiType: this.monthGanZhiType, // 月干支类型（0:以节交接当天起算。1:以节交接时刻起算）
                dayGanZhiType: this.dayGanZhiType // 日干支类型（0:晚子时日柱按明天。1:晚子时日柱按当天）
            }

            // 发送请求
            paiPanApi(query).then((res) => {
                if (String(res.data.code) === '200' && null !== res.data.data) {
                    var data = res.data.data;

                    window.scroll(0, 0);

                    this.data = data; // 排盘数据
                    this.isData = true; // 数据状态（true:存在。false:不存在）
                }
            })

        },

        /**
         * 返回排盘
         */
        fanHuiPaiPanMethod() {


            window.scroll(0, 0);

            this.isData = false; // 数据状态（true:存在。false:不存在）
            this.dataPage = 1; // 数据显示界面（1:基础信息）
            this.data = {}; // 数据

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
