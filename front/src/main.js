import { createApp } from "vue";
import "normalize.css";
import App from "./App.vue";
import { createRouter, createWebHistory } from "vue-router";
import Home from "./components/Home.vue";
import Restaurants from "./components/Restaurants.vue";
import Restaurant from "./components/Restaurant.vue";
import "./style.css";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home,
    },
    {
      path: "/restaurants",
      name: "Restaurants",
      component: Restaurants,
    },
    {
      path: "/restaurants/:id",
      name: "Restaurant",
      component: Restaurant,
    },
  ],
  scrollBehavior(to, from, savedPosition) {
    return to.hash ? { el: to.hash } : { top: 0 };
  },
});

createApp(App).use(router).mount("#app");
