<script setup>
defineProps(["title"]);
</script>

<template>
  <div class="home-rest">
    <h3 class="home-rest-title">{{ title }}</h3>
    <!-- <h3 class="home-rest-desc">{{ description }}</h3> -->
  </div>
</template>
<style scoped lang="scss">
.home-rest {
  width: 170px;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: white;
  padding: 32px 48px;
  border-radius: 8px;
  color: var(--verdeInchis);
  font-size: 24px;
  font-weight: 500;
  letter-spacing: 0.75px;
  box-shadow: rgba(0, 0, 0, 0.08) 0px 4px 12px;
  transition-property: box-shadow, transform;
  transition: 0.3s ease;
  will-change: box-shadow, transform;
  &:hover {
    box-shadow: rgba(0, 0, 0, 0.08) 0px 4px 12px;
    transform: scale(1.05);
    // transform: rotate(1deg);

    transform: scale(1.05);
    background-color: hsl(277, 32%, 95%);
  }

  .home-rest-title {
    margin: 0;
    color: var(--violetInchis);
    font-size: 24px;
    font-weight: 500;
    letter-spacing: 0.75px;
  }
}
</style>
