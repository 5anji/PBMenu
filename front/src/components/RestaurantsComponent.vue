<script setup>
// import { routerKey } from "vue-router";

// import { computed } from "@vue/reactivity";
import { ref, onMounted} from "vue";
import RestaurantItem from "./RestaurantItem.vue";
import Restaurant from "./RestaurantComponent.vue";
import {getRestaurantAll} from "../api";

const list = ref([]);

onMounted(() => {
  // fetch("http://localhost:3000/list")
  //   .then((response) => response.json())
  //   .then((data) => (list.value = data));
  getRestaurantAll({pages: 1, nrOfItems: 10})
      .then(({data}) => (list.value = data))
});
</script>

<template>
  <div class="screen">
    <!-- <button @click="ada">Add</button> -->
    <h1 class="restaurants-num">
      All available menus
    </h1>
    <div class="restaurants">
      <div
        v-for="item in list"
        :key="item.restaurantId"
        class="restaurants-for"
      >
        <router-link
          class="restaurant-info"
          :to="{ name: 'Restaurant', params: { id: item.restaurantId } }"
        >
          <restaurant-item
            :title="item.restaurantName"
            :description="item.description"
          />
        </router-link>
      </div>
      <!-- <restaurant-item /> -->
    </div>
  </div>
</template>
<style scoped lang="scss">
.screen {
  .restaurants-num {
    background-size: 18px 18px;
    margin: 0 0 0 100px;
    padding-top: 180px;
    padding-bottom: 48px;
    color: var(--verdeInchis);
    font-weight: 700;
    font-size: 48px;
    letter-spacing: 0.75px;
    @media screen and (max-width: 544px) {
      margin-left: 45px;
      // width: 100vh;
      // font-size: 78px;
      display: inline-block;
      padding:128px 0 32px 0;
    }
  }
  .restaurants {
    background-color: #ffffff;
    background-image: radial-gradient(
      hsla(128, 32%, 57%, 0.3) 0.9px,
      #ffffff 0.9px
    );
    background-size: 18px 18px;
    margin: 0 0 96px 0;
    padding: 48px 100px;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    text-align: center;
    justify-content: center;
    font-size: 24px;
    gap: 100px;
    @media screen and (max-width: 1555px) {
      padding: 48px 48px;
      gap: 48px;
    }
    @media screen and (max-width: 544px) {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      margin: 0;
      padding: 80px 32px 128px 32px;
      gap: 64px;
    }

    .restaurant-info {
      text-decoration: none;
      text-align: left;
    }
  }
}
</style>
