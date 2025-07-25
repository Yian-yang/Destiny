<script src="@/js/headerfooter/footer.js"></script>

<template>
  <div class="vue">
    <div class="footer">
      <div class="menu">
        <span
          v-for="item in menu"
          :key="item"
        >
          <router-link
            :to="item.link"
            class="item"
          >
            <span class="name">
              <Icon :type="item.icon" />
            {{ item.name }}
            </span>
          </router-link>
        </span>
      </div>

      <div class="copy">
        Copyright © {{ startYear + endYear }}
        <router-link
          to="/"
          class="name"
        >
          网站名称.
        </router-link>
        All Rights Reserved
        <a
          class="bei"
          target="_blank"
          href="https://beian.miit.gov.cn"
        >
          网站备案号
        </a>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss" src="@/css/headerfooter/footer.scss"></style>
