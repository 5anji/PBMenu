<script setup>
import { Icon } from "@iconify/vue";
</script>

<template>
  <div class="nav-mob">
    <router-link to="/">
      <img class="logo" src="../img/Logo.png" alt="menu-hub logo" />

      <!-- {{ currentSection }} -->
    </router-link>
    <div class="nav-bar">
      <router-link class="right-bar" to="/restaurants">Restaurants</router-link>
      <router-link class="right-bar" :to="{ path: '/', hash: '#about-us' }"
        >About Us</router-link
      >
      <ul class="social-links">
        <li>
          <a class="footer-link" href="#"
            ><Icon class="social-icon" icon="uil:instagram" />
          </a>
        </li>
        <li>
          <a class="footer-link" href="#"
            ><Icon class="social-icon" icon="uil:facebook-f"
          /></a>
        </li>
        <li>
          <a class="footer-link" href="#"
            ><Icon class="social-icon" icon="uil:twitter-alt"
          /></a>
        </li>
      </ul>
    </div>
  </div>
</template>
<style scoped lang="scss">
.nav-mob {
  margin: 0;
  backdrop-filter: blur(100px);
  position: fixed;
  z-index: 100;
  padding: 128px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 64px;
  //   justify-content: center;
  //   height: calc(100vh - 100px);
  height: 100vh;
  width: calc(100% - 100px);
  .logo {
    height: 60px;
  }
  .social-links {
    padding: 0;
    margin: 0;
    list-style: none;
    display: flex;
    gap: 24px;
    padding-top: 100px;
  }

  .social-icon {
    height: 32px;
    width: 32px;
    color: var(--violetInchis);
  }
  .nav-bar {
    display: flex;
    flex-direction: column;
    gap: 48px;
    .right-bar {
      text-decoration: none;
      color: var(--verde);
      font-size: 32px;
      transition-property: box-shadow, transform;
    }
  }
}
</style>
