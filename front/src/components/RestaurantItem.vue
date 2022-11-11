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
  background-color: white;
  background-image: url(../img/andys-rest.jpg);
  background-position: right;
  background-size: 200px;
  background-repeat: no-repeat;
  border-radius: 1rem;
  box-shadow: rgba(17, 17, 26, 0.05) 0px 4px 16px,
    rgba(17, 17, 26, 0.05) 0px 8px 32px;
  height: 200px;
  width: 435px;
  display: flex;
  justify-content: space-between;
  overflow: hidden;
  transition-property: box-shadow, transform;
  transition: 0.3s ease;
  will-change: box-shadow, transform;
  @media screen and (max-width: 544px) {
    height: 150px;
    width: 335px;
    background-size: 150px;
    // width: 100vh;
  }
  &:hover {
    box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px;
    transform: scale(1.05);
    @media screen and (max-width: 544px) {
      transform: none;
    }
  }
  .restaurant {
    display: grid;
    grid-template-rows: 2fr 1fr;
    row-gap: 16px;
    padding: 32px;
    margin-right: 216px;
    align-content: space-between;
    height: 100%;
    @media screen and (max-width: 544px) {
      margin-right: 150px;
    }

    .restaurant-title {
      margin: 0;
      color: var(--violetInchis);
      font-weight: 500;
      font-size: 36px;
      @media screen and (max-width: 544px) {
        font-size: 28px;
      }
    }
    .restaurant-description {
      margin: 0;
      color: #767676;
      font-weight: 400;
      font-size: 20px;
      letter-spacing: 0.75px;
      @media screen and (max-width: 544px) {
        font-size: 18px;
      }
    }
  }
  .restaurant-img {
    height: 300px;
    width: auto;
    align-self: end;
  }
}
</style>
