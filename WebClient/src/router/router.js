import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  linkActiveClass: 'active',
  linkExactActiveClass: 'exact-active',
  routes: [

    /* 排盘 */

    // 由重定向
    {
      path: '/',
      redirect: '/bazi',
      component: () => import('@/views/paipan/XuanBaZiViews.vue'), // 八字排盘
    },

    // 排盘
    // {
    //   path: '/liuyao',
    //   component: () => import('@/views/paipan/XuanLiuYaoViews.vue'), // 六爻排盘
    // },
    {
      path: '/bazi',
      component: () => import('@/views/paipan/XuanBaZiViews.vue'), // 八字排盘
    },
    // {
    //   path: '/qimen',
    //   component: () => import('@/views/paipan/XuanQiMenViews.vue'), // 奇门遁甲排盘
    // },
    // {
    //   path: '/meihua',
    //   component: () => import('@/views/paipan/XuanMeiHuaViews.vue'), // 梅花易数排盘
    // },
    // {
    //   path: '/ziwei',
    //   component: () => import('@/views/paipan/XuanZiWeiViews.vue'), // 紫微斗数排盘
    // },



// ***************************************************************************************

    /* 关于 */

    {
      path: '/about',
      component: () => import('@/views/about/XuanAboutViews.vue') // 关于本站
    },
    {
      path: '/privacy',
      component: () => import('@/views/about/XuanPrivacyViews.vue') // 隐私保护
    },
    {
      path: '/disclaimer',
      component: () => import('@/views/about/XuanDisclaimerViews.vue') // 免责声明
    },

    // ***************************************************************************************

    /* 404 */

    {
      path: '/:catchAll(.*)',
      component: () => import('@/views/notfind/XuanNotFindViews.vue')
    }

  ]
})

// 全局前置守卫
router.beforeEach((to, from, next) => {
  // window.scrollTo(0, 0);
  next();
})

// 全局解析守卫
router.beforeResolve((to, from, next) => {
  next();
})

// 全局后置守卫
router.afterEach((to, from) => {
  window.scrollTo(0, 0);
  // next();
})

export default router;
