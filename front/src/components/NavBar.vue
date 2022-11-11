<script setup>
import { watch, ref, onMounted, onUnmounted } from "vue";
import { useRoute } from "vue-router";

const scrollRef = ref({});
const props = defineProps(["forceShow"]);

// const onEnter = () => {};

// const onExit = () => {};

const route = useRoute();
const visible = ref(route.name === "Home");
watch(route, (x) => {
  visible.value = x.name === "Home";
});
</script>

<template>
  <div class="nav" v-show="!visible || props.forceShow">
    <router-link to="/">
      <img class="logo" src="../img/Logo.png" alt="menu-hub logo" />
      <!-- {{ currentSection }} -->
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
  padding: 20px 100px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  @media screen and (max-width: 544px) {
    // width: 100vh;
  }
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
