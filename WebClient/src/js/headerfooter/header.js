export default {
    el: 'app',
    data() {
        return {
            menu: [
                // { name: '六爻', link: '/liuyao', icon: '' },
                { name: '八字', link: '/bazi', icon: '' },
                // { name: '奇门遁甲', link: '/qimen', icon: '' },
                // { name: '梅花易数', link: '/meihua', icon: '' },
                // { name: '紫薇斗数', link: '/ziwei', icon: '' }
            ],
        }
    },
    watch: {
    },
    created() {
    },
    mounted() {
        this.updateTime(); // 初始化时间显示
        this.interval = setInterval(this.updateTime, 1000); // 每秒更新时间
    },
    methods: {
        updateTime() {
            this.currentTime = new Date().toLocaleString(); // 获取当前时间
        }
    },
    beforeDestroy() {
        clearInterval(this.interval); // 防止内存泄露
    }
}
