<script setup>
defineProps(["title"]);
</script>

<template>
  <div class="home-rest-wrapper">
    <div class="home-rest">
      <h3 class="home-rest-title">{{ title }}</h3>
      <span class="more">More &rarr;</span>
      <!-- <h3 class="home-rest-desc">{{ description }}</h3> -->
    </div>
  </div>
</template>
<style lang="scss">
.home-rest-wrapper {
  padding: 2rem 0.5rem;
  background-image: radial-gradient(
    var(--bg-color) 0%,
    transparent 70%,
    transparent 100%
  );
  background-size: 90% 100%;
  background-repeat: no-repeat;
  background-position: center;
  transition-property: box-shadow, transform;
  transition: 0.3s ease;
  will-change: box-shadow, transform;
  @media screen and (max-width: 544px) {
    padding: 1.1rem 0rem;
  }

  .home-rest {
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: white;
    padding: 32px 48px;
    border-radius: 8px;
    font-size: 24px;
    font-weight: 500;
    letter-spacing: 0.75px;
    box-shadow: rgba(0, 0, 0, 0.08) 0px 4px 12px;
    @media screen and (max-width: 544px) {
      padding: 18px 24px;
    }
    .home-rest-title {
      margin: 0;
      font-size: 2.5rem;
      font-weight: 500;
      letter-spacing: 0.75px;
      color: var(--txt-color);
      @media screen and (max-width: 544px) {
        font-size: 20px;
      }
    }
    .more {
      position: absolute;
      bottom: 12px;
      font-size: 18px;
      color: var(--verdeInchis);
      opacity: 0;
      transition: opacity 0.3s;
    }
  }
  &:hover {
    transform: scale(1.05);
    .more {
      opacity: 1;
    }
    .home-rest {
      background-color: var(--bg-color-1);
    }
  }
}
</style>
