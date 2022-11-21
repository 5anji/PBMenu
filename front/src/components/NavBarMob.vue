<script setup>
import { Icon } from "@iconify/vue";
import { watch, ref } from "vue";
import { useRoute } from "vue-router";

// export default {
//   name: "ToggleDiv",
//   components: { Icon },
//   data: function () {
//     return {
//       isShow: false,
//     };
//   },
//   props: {
//     msg: String,
//   },
// };
const isShow = ref(false);

const props = defineProps({
  "forceShow":{
    type: Boolean,
    required: true
  }
}, {
  msg: String,
});

const route = useRoute();
const visible = ref(route.name === "Home");
watch(route, (x) => {
  visible.value = x.name === "Home";
});
</script>

<template>
  <div
    v-show="!visible || props.forceShow"
    :class="{ hide: !isShow }"
    class="nav-mob-wr"
  >
    <div
      class="nav-icon"
      @click="isShow = !isShow"
    >
      <Icon
        class="icon"
        icon="ph:list-bold"
      />
    </div>
    <router-link to="/">
      <img
        class="logo"
        src="../img/Logo.png"
        alt="menu-hub logo"
      >

      <!-- {{ currentSection }} -->
    </router-link>
    <div class="nav-mob">
      <!-- <div class="nav-bar"> -->
      <router-link
        class="right-bar"
        to="/restaurants"
        @click="isShow = !isShow"
      >
        Restaurants
      </router-link>
      <router-link
        class="right-bar"
        :to="{ path: '/', hash: '#about-us' }"
        @click="isShow = !isShow"
      >
        About Us
      </router-link>
      <ul class="social-links">
        <li>
          <a
            class="footer-link"
            href="#"
          ><Icon
            class="social-icon"
            icon="uil:instagram"
          />
          </a>
        </li>
        <li>
          <a
            class="footer-link"
            href="#"
          ><Icon
            class="social-icon"
            icon="uil:facebook-f"
          /></a>
        </li>
        <li>
          <a
            class="footer-link"
            href="#"
          ><Icon
            class="social-icon"
            icon="uil:twitter-alt"
          /></a>
        </li>
      </ul>
      <!-- </div> -->
    </div>
  </div>
</template>
<style scoped lang="scss">
.nav-mob-wr {
  // position: relative;
  position: fixed;
  z-index: 100;

  &.hide {
    z-index: 100;

    .nav-mob {
      visibility: hidden !important;
    }
  }

  .nav-icon {
    margin: 0;
    padding: 24px 32px;
    position: absolute;
    z-index: 1000;
    width: 100%;

    background-color: rgba(255, 255, 255, 0.9);

    backdrop-filter: blur(3px);

    // box-shadow: rgb(245, 245, 245) 0px 0px 20px 10px;

    // top: 60px;
    // right: calc(100% - 100px);
    .icon {
      height: 32px;
      width: 32px;
      color: var(--verde);
    }
  }
  .logo {
    position: absolute;
    z-index: 1000;

    right: 32px;
    top: 22px;
    height: 40px;
  }
  .nav-mob {
    // position: relative;
    margin: 84px 0 0 0;
    background-color: rgba(255, 255, 255, 0.9);

    backdrop-filter: blur(3px);

    border-bottom: 1px solid hsla(0, 0%, 95%, 0.6);
    // border-top: 1px solid hsla(0, 0%, 95%, 0.6);

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 24px;
    // height: calc(100vh - 400px);
    width: 100vw;
    padding: 52px 32px 32px 32px;

    .social-links {
      padding:24px 0 0 0;
      margin: 0;
      list-style: none;
      display: flex;
      gap: 24px;

      // grid-row: 2;
      // justify-content: center;
    }

    .social-icon {
      height: 24px;
      width: 24px;
      color: var(--violetInchis);
    }

    .right-bar {
      margin: 0;
      text-decoration: none;
      color: var(--verde);
      font-size: 30px;
      transition-property: box-shadow, transform;
      &:nth-of-type(2) {
        grid-column: 1;
      }
    }
  }
  @media screen and (min-width: 544px) {
    display: none;
  }
}
</style>
