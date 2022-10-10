<script setup>
// import { routerKey } from "vue-router";

// import { computed } from "@vue/reactivity";
import { ref, computed } from "vue";
import RestaurantItem from "./RestaurantItem.vue";
import Restaurant from "./Restaurant.vue";

const list = ref([
  { title: "vasea", description: "tipa vasea" },
  { title: "ada", description: "tipa ada" },
  { title: "grig", description: "tipa grig" },
  { title: "andrei", description: "tipa andrei" },
  { title: "gabi", description: "tipa gabi" },
  { title: "sorin", description: "tipa sorin" },
]);
</script>

<template>
  <div class="screen">
    <!-- <button @click="ada">Add</button> -->
    <div class="restaurants">
      <div v-for="item in list">
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
.restaurants {
  padding: 128px 100px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  text-align: center;
  justify-content: center;
  font-size: 24px;
  gap: 100px;

  .restaurant-info {
    text-decoration: none;
    text-align: left;
  }
}
</style>
