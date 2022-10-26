<script setup>
import { watch, ref } from "vue";
import { useRoute } from "vue-router";

const route = useRoute();
const visible = ref(route.name === "Home");
watch(route, (x, y) => {
  visible.value = x.name === "Home";
});
</script>

<template>
  <div class="nav" v-show="!visible">
    <router-link to="/">
      <img class="logo" src="../img/Logo.png" alt="menu-hub logo" />
    </router-link>
    <div class="nav-bar">
      <router-link class="right-bar" to="/restaurants">Restaurants</router-link>
      <router-link class="right-bar" :to="{ path: '/', hash: '#about-us' }"
        >About Us</router-link
      >
    </div>
  </div>
</template>
<style scoped lang="scss">
.nav {
  margin: 0;
  backdrop-filter: blur(3px);
  position: fixed;
  width: 100%;
  z-index: 100;
  // background-color: rgba(255, 255, 255, 0.75);
  padding: 20px 100px;
  display: flex;
  align-items: center;
  justify-content: space-between;

  .nav-bar {
    display: flex;
    align-items: center;
    gap: 96px;
  }
  .right-bar {
    text-decoration: none;
    color: var(--verde);
    font-size: 32px;
    transition-property: box-shadow, transform;
    transition: 0.3s ease;
    will-change: box-shadow, transform;
    &:hover {
      color: var(--verdeInchis);
      transform: scale(1.05);
    }
  }
  .logo {
    width: auto;
    height: 52px;
    max-height: 100%;
    transition-property: box-shadow, transform;
    transition: 0.3s ease;
    will-change: box-shadow, transform;
    &:hover {
      transform: scale(1.05);
    }
  }
}
</style>
