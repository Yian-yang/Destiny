<script>
import XuanHeader from '@/components/headerfooter/XuanHeader.vue' // 页头
import XuanFooter from '@/components/headerfooter/XuanFooter.vue' // 页脚

export default {
  components: {
    XuanHeader, // 页头
    XuanFooter // 页脚
  },
  el: 'app',
  data() {
    return {
    }
  },
  watch: {
  },
  created() {
  },
  mounted() {
  },
  methods: {
  }
}
</script>


<template>
  <div class="app-container">
    <header class="header">
      <XuanHeader />
    </header>

    <main class="main-content">
      <router-view></router-view>
    </main>

    <footer class="footer">
      <XuanFooter />
    </footer>

    <div>
      <el-backtop class="mouse" :right="40" :bottom="40" visibility-height="100" />
    </div>
  </div>
</template>

<style scoped lang="scss">
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  background-color: #000000;
}

.header {
  flex-shrink: 0;
}

.main-content {
  flex: 1;
  padding: 80px 0px 0px 0px;
  background-color: #000000;
}

.footer {
  flex-shrink: 0;
  margin-top: auto;
}

.mouse {
  z-index: 9999;
  border-radius: 50px;
}
</style>
