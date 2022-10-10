<template>
  <div class="nav">
    <router-link to="/">
      <img class="logo" src="../img/Logo.png" alt="menu-hub logo" />
    </router-link>
    <div class="nav-bar">
      <router-link class="right-bar" to="/restaurants">Restaurants</router-link>
      <router-link class="right-bar" to="/AboutUs">About Us</router-link>
    </div>
  </div>
</template>
<style scoped lang="scss">
.nav {
  position: fixed;
  width: 100%;
  z-index: 100;
  // background: rgb(0, 0, 0);
  // background: linear-gradient(
  //   180deg,
  //   rgba(52, 52, 52, 0.74) 0%,
  //   rgba(52, 52, 52, 0.51) 20%,
  //   rgba(52, 52, 52, 0.37) 37%,
  //   rgba(52, 52, 52, 0.19) 57%,
  //   rgba(52, 52, 52, 0.03) 80%,
  //   rgba(52, 52, 52, 0) 100%
  // );
  background-color: rgba(255, 255, 255, 0.75);
  padding: 32px 100px;
  display: flex;
  align-items: center;
  justify-content: space-between;

  // box-shadow: rgba(33, 35, 38, 0.1) 0px 10px 10px -10px;
  .nav-bar {
    display: flex;
    align-items: center;
    gap: 96px;
  }
  .right-bar {
    text-decoration: none;
    color: var(--verde);
    font-size: 32px;
  }
  .logo {
    width: auto;
    height: 52px;
    max-height: 100%;
  }
}
</style>
