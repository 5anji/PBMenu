<script setup>
// import { routerKey } from "vue-router";

// import { computed } from "@vue/reactivity";
import { ref, computed, onMounted } from "vue";
import RestaurantItem from "./RestaurantItem.vue";
import Restaurant from "./Restaurant.vue";

const list = ref([]);

onMounted(() => {
  fetch("http://localhost:3000/list")
    .then((response) => response.json())
    .then((data) => (list.value = data));
});
</script>

<template>
  <div class="screen">
    <h1 class="restaurants-num">All available menus</h1>
    <!-- <button @click="ada">Add</button> -->
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
.restaurants-num {
  margin: 0;
  padding-top: 180px;
  padding-bottom: 96px;
  color: var(--verde);
  font-weight: 700;
  font-size: 64px;
  margin-left: 100px;
  letter-spacing: 0.75px;
}
.restaurants {
  margin: 0;
  padding: 0 100px;
  padding-bottom: 128px;
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
