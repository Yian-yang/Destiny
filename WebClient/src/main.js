import { createApp } from 'vue'

import App from '@/App.vue'
import Router from '@/router/router.js'

import ElementPlus from 'element-plus' // element-plus
import 'element-plus/dist/index.css' // element-plus样式
import locale from 'element-plus/es/locale/lang/zh-CN' // element-plus中文

import ViewUIPlus from 'view-ui-plus' // viewui-plus
import 'view-ui-plus/dist/styles/viewuiplus.css' // viewui-plus样式

import '@/assets/css/main.scss' // 全局css
import '@/assets/js/main.js' // 全局js

const app = createApp(App)

app.use(Router)
app.use(ElementPlus, { locale })
app.use(ViewUIPlus, {
  transfer: true, // 所有带浮层的组件，是否将浮层放置在body内，默认为不设置。（可选值为true或false）
  size: 'default', // 所有带有size属性的组件的尺寸，默认为不设置。（可选值为 default或small或large）
  capture: false, // 所有带下拉的组件是否开启capture模式，默认为true。（可选值为 true、false）
  select: {
    arrow: 'md-arrow-dropdown',
    arrowSize: 20
  }
})
app.mount('#app')
