export default {
    el: 'app',
    data() {
        return {
            menu: [
                { name: '关于本站', link: '/about', icon: '' },
                { name: '隐私条款', link: '/privacy', icon: '' },
                { name: '免责声明', link: '/disclaimer', icon: '' },
            ],
            startYear: 2025, // 版权开始年
            endYear: '', // 版权结束年
        }
    },
    watch: {
    },
    created() {
        this.copyRightYear(); // 处理版权年份
    },
    mounted() {
    },
    methods: {

        /**
         * 处理版权年份
         */
        copyRightYear() {

            var nowDateYear = new Date().getFullYear();
            this.endYear = nowDateYear > this.startYear ? '-' + nowDateYear : '';

        }

    }
}
