<script setup>
defineProps(["title", "description"]);
</script>

<template>
  <div class="restaurant-item">
    <div class="restaurant">
      <h3 class="restaurant-title">{{ title }}</h3>
      <h3 class="restaurant-description">{{ description }}</h3>
    </div>
    <!-- <img class="restaurant-img" src="../img/andys-1.png" /> -->
  </div>
</template>

<style scoped lang="scss">
.restaurant-item {
  margin: 0;

  display: block;
  background-image: url(../img/andys-rest.jpg);
  background-position: right;
  background-size: 200px;
  background-repeat: no-repeat;
  border-radius: 1rem;
  box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px;
  height: 200px;
  display: flex;
  justify-content: space-between;
  overflow: hidden;
  transition-property: box-shadow, transform;
  transition: 0.3s ease;
  will-change: box-shadow, transform;

  &:hover {
    box-shadow: rgba(0, 0, 0, 0.2) 0px 12px 28px 0px,
      rgba(0, 0, 0, 0.1) 0px 2px 4px 0px,
      rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;
    transform: scale(1.05);
  }
  .restaurant {
    display: grid;
    grid-template-rows: 2fr 1fr;
    row-gap: 16px;
    padding: 32px;
    margin-right: 216px;
    align-content: space-between;

    height: 100%;
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
      letter-spacing: 0.75px;
    }
  }
  .restaurant-img {
    height: 300px;
    width: auto;
    align-self: end;
  }
}
</style>
