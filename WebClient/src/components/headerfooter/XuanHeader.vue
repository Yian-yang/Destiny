<template>
  <header class="bolt-header">
    <div class="logo">DestinyCur</div>
    <nav class="center-actions">
      <a href="#" class="shop-link">返回商店</a>
    </nav>
    <!-- 右侧按钮区域暂时隐藏 -->
  </header>
</template>

<script>
export default {
  name: 'XuanHeader'
}
</script>

<style scoped lang="scss">
.bolt-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 56px;
  padding: 0 48px;
  background: linear-gradient(90deg, #1a232a 0%, #222b33 60%, #181a1b 100%);
  border-bottom: none;
  box-shadow: none;
  position: relative;

  .logo {
    font-size: 22px;
    font-weight: bold;
    font-style: italic;
    color: #fff;
    letter-spacing: 1px;
    margin-right: 32px;
    user-select: none;
  }
  .center-actions {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    align-items: center;
    height: 100%;
    z-index: 1;
    .shop-link {
      color: #e0e6ed;
      font-size: 15px;
      text-decoration: none;
      font-weight: 500;
      padding: 0 18px;
      background: none;
      border: none;
      border-radius: 4px;
      transition: color 0.2s, text-decoration 0.2s;
      cursor: pointer;
      &:hover {
        color: #fff;
        text-decoration: underline;
      }
    }
  }
}
</style>
