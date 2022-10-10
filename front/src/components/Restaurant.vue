<script setup>
import { useRoute } from "vue-router";
import { ref } from "vue";
const route = useRoute();
const dd = ref(route.params);
</script>

<template>
  <div class="restaurant">
    <div class="rest-info">
      <h1 class="rest-name">Andys Pizza</h1>
      <h3 class="rest-price">$ $ $</h3>
      <h3 class="rest-contact">+(373)00 00 00</h3>
      <div class="has-tag">
        <a class="has-tag1" href="#">#Vegetarian</a>
        <a class="has-tag2" href="#">#Pizza</a>
        <a class="has-tag3" href="#">#LocDeJoaca</a>
      </div>
    </div>

    <img class="foto" src="../img/andys.jpg" />
  </div>
  <div class="menu">Menu</div>
</template>

<style scoped lang="scss">
.restaurant {
  max-width: 100%;
  box-shadow: rgba(33, 35, 38, 0.1) 0px 10px 10px -10px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  column-gap: 48px;
  align-items: center;
  padding: 0 64px;
  .rest-info {
    display: flex;
    flex-direction: column;
    gap: 24px;
    justify-self: center;
    .rest-name {
      margin: 0;
      color: var(--verde);
      font-weight: 700;
      font-size: 48px;
    }
    .has-tag {
      display: block;

      display: flex;
      gap: 24px;

      .has-tag1 {
        text-decoration: none;
        background-color: var(--violetDeschis);
        padding: 8px 12px;
        border-radius: 16px;
        color: #333;
      }
      .has-tag2 {
        text-decoration: none;
        background-color: var(--verdeDeschis);
        padding: 8px 12px;
        border-radius: 16px;
        color: #333;
      }
      .has-tag3 {
        text-decoration: none;
        background-color: var(--galben);
        padding: 8px 12px;
        border-radius: 16px;
        color: #333;
      }
    }
    .rest-price {
      margin: 0;
      font-size: 24px;
      font-weight: 700;
    }
    .rest-contact {
      margin: 0;
    }
  }
  .foto {
    width: auto;
    height: 500px;
    justify-self: center;
    border-radius: 16px;
    margin: 32px 32px;
  }
}
.menu {
  background-color: #faf1e6;
  padding: 200px 100px;
  margin: 100px 100px;
  border-radius: 16px;
}
</style>
