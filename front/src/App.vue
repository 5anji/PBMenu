<script setup>
import { ref } from "vue";
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://vuejs.org/api/sfc-script-setup.html#script-setup
import HelloWorld from "./components/HelloWorld.vue";
// import NavBar from "./components/NavBar.vue";
import Footer from "./components/Footer.vue";

const x = ref(true);
// export default {
//   data: () => {
//     return {
//       mobileView: true,
//       showNav: false,
//     };
//   },
//   methods: {
//     handleView() {
//       this.mobileView = window.innerWidth <= 544;
//     },
//   },
//   created() {
//     this.handleView();
//   },
// };
</script>

<template>
  <NavBar :force-show="x"></NavBar>
  <router-view v-slot="{ Component }">
    <transition name="fade">
      <component :is="Component" @show-tipa="($event) => (x = $event)" />
      <!-- @show-nav="($event) => (x = $event)" -->
    </transition>
  </router-view>
  <Footer />
</template>

<style lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,700&display=swap");

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s ease;
}
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

// #app {
//   background-color: #ffffff;
//   // opacity: 0.4;
//   background-image: radial-gradient(
//     hsla(128, 32%, 57%, 0.4) 0.9px,
//     #ffffff 0.9px
//   );
//   background-size: 18px 18px;
// }
</style>
