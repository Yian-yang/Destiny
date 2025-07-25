<script src="@/js/headerfooter/header.js"></script>

<template>
  <div class="vue jinxuan">
    <div class="margins">

      <div class="header">
        <div class="logo">
          <router-link to="/">
            <span class="text">网站名称</span>
          </router-link>
        </div>
      </div>

      <div class="menu">
        <span
          v-for="item in menu"
          :key="item"
        >
          <router-link
            :to="item.link"
            class="item"
          >
            <Icon :type="item.icon" />
            {{ item.name }}
          </router-link>
        </span>
      </div>

    </div>
  </div>
</template>

<style scoped lang="scss" src="@/css/headerfooter/header.scss"></style>
