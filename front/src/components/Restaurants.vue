<script setup>
// import { routerKey } from "vue-router";

// import { computed } from "@vue/reactivity";
import { ref, computed, onMounted } from "vue";
import RestaurantItem from "./RestaurantItem.vue";
import Restaurant from "./Restaurant.vue";

const list = ref([
  { title: "Andy's Pizza", description: "Pizzeria" },
  { title: "Tratoria", description: "Italian Restaurant" },
  { title: "Oro", description: "Restaurant" },
  { title: "Granier", description: "Cafe" },
  { title: "Sincer", description: "Italian Restaurant" },
  { title: "Mojito", description: "Restaurant" },
  { title: "Mojo", description: "Pizzeria" },
  { title: "TaxiBlues", description: "Italian Restaurant" },
  { title: "Momo", description: "Asian Restaurant" },
]);

// onMounted(() => {
//   fetch("http://localhost:3000/list")
//     .then((response) => response.json())
//     .then((data) => (list.value = data));
// });
</script>

<template>
  <div class="screen">
    <!-- <button @click="ada">Add</button> -->
    <h1 class="restaurants-num">All available menus</h1>
    <div class="restaurants">
      <div class="restaurants-for" v-for="item in list">
        <router-link
          class="restaurant-info"
          :to="{ name: 'Restaurant', params: { id: item } }"
        >
          <restaurant-item
            :title="item.title"
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
    margin: 0;
    padding-top: 180px;
    padding-bottom: 48px;
    color: var(--verdeInchis);
    font-weight: 700;
    font-size: 48px;
    margin-left: 100px;
    letter-spacing: 0.75px;
    @media screen and (max-width: 544px) {
      margin-left: 45px;
      // width: 100vh;
      // font-size: 78px;
      display: inline-block;
      padding: 0;
      padding-top: 128px;
      padding-bottom: 32px;
    }
  }
  .restaurants {
    background-color: #ffffff;
    background-image: radial-gradient(
      hsla(128, 32%, 57%, 0.3) 0.9px,
      #ffffff 0.9px
    );
    background-size: 18px 18px;
    margin: 0;
    padding: 48px 100px;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    text-align: center;
    justify-content: center;
    font-size: 24px;
    gap: 100px;
    margin-bottom: 96px;
    @media screen and (max-width: 1555px) {
      padding: 48px 48px;
      gap: 48px;
    }
    @media screen and (max-width: 544px) {
      display: flex;
      flex-direction: column;
      justify-content: center;
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
