<script setup>
defineProps(["title", "description"]);
</script>

<template>
  <div class="restaurant-item">
    <h3 class="restaurant-title">{{ title }}</h3>
    <p class="restaurant-description">{{ description }}</p>
  </div>
</template>

<style scoped lang="scss">
.restaurant-item {
  display: block;
  background-color: var(--violetDeschis);
  border-radius: 16px;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 10px 15px -3px,
    rgba(0, 0, 0, 0.05) 0px 4px 6px -2px;
  height: 132px;
  padding: 48px 48px;

  display: flex;
  flex-direction: column;
  gap: 16px;
  transition-property: box-shadow, transform;
  transition: 0.3s ease;
  will-change: box-shadow, transform;

  &:hover {
    box-shadow: rgba(0, 0, 0, 0.1) 0px 20px 25px -5px,
      rgba(0, 0, 0, 0.04) 0px 10px 10px -5px;
    transform: scale(1.05);
  }
  .restaurant-title {
    margin: 0;
    color: var(--violetInchis);
    font-weight: 500;
    font-size: 36px;
  }
  .restaurant-description {
    margin: 0;
    color: #888;
    font-weight: 400;
    font-size: 20px;
  }
}
</style>
