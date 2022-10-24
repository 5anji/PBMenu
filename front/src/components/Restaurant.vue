<script setup>
import { useRoute } from "vue-router";
import { ref } from "vue";
import { Icon } from "@iconify/vue";
import HasTag from "./HashTag.vue";
import HashTag from "./HashTag.vue";
const route = useRoute();
const dd = ref(route.params);

const tags = ["Pizza", "Vegetarian", "Vegan"];
</script>

<template>
  <div>
    <div class="restaurant">
      <div class="rest">
        <h1 class="rest-name">Andys Pizza</h1>
        <div class="details">
          <h2 class="description">DETAILS</h2>
          <div class="rest-info">
            <h3 class="rest-den">Type:</h3>
            <h3 class="rest-text">Pizzeria</h3>
            <h3 class="rest-den">Prices Level:</h3>
            <h3 class="rest-text">$ $ $</h3>
          </div>
        </div>
        <div class="contact">
          <h2 class="description">CONTACT INFORMATION</h2>
          <div class="rest-info">
            <h3 class="rest-den">Phone:</h3>
            <a class="rest-text" href="tel: +373 788 699 18"
              >(+373) 788 699 18</a
            >
            <h3 class="rest-den">Email:</h3>
            <a class="rest-text" href="mailto:abc@example.com"
              >menuHub@gmail.com</a
            >
          </div>
        </div>
      </div>
      <div class="rest-img">
        <div class="rest-image">
          <img src="../img/andys.jpg" />
        </div>

        <template v-for="tag in tags">
          <HashTag :description="tag" />
        </template>
      </div>
    </div>
    <div class="restaurant-menu">
      <div class="btn-menu food-category">
        <Icon class="btn-icon" icon="uil:restaurant" />

        <a href="#" class="btn-text">Food Menu</a>
      </div>
      <div class="btn-menu drink-category">
        <Icon class="btn-icon" icon="uil:glass-martini" />
        <a href="#" class="btn-text">Drink Menu</a>
      </div>
      <div class="btn-menu advertisment-category">
        <Icon class="btn-icon" icon="uil:star" />
        <a href="#" class="btn-text">Advertisment</a>
      </div>
    </div>

    <div class="block-menu food-category">
      <div class="menu-description">
        <Icon class="menu-icon" icon="uil:restaurant" />
        <h1 class="menu-text">Food Menu</h1>
      </div>
    </div>

    <div class="block-menu drink-category">
      <div class="menu-description">
        <Icon class="menu-icon" icon="uil:glass-martini" />
        <h1 class="menu-text">Drink Menu</h1>
      </div>
    </div>
    <div class="block-menu advertisment-category">
      <div class="menu-description">
        <Icon class="menu-icon" icon="uil:star" />
        <h1 class="menu-text">Advertisment</h1>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.restaurant {
  display: grid;
  grid-template-columns: 45% 55%;
  align-items: center;
  justify-content: space-between;

  .rest-img {
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 170px 96px 170px 96px;
    position: relative;
    // background-image: radial-gradient(var(--verde) 0%, transparent 55%);
    .tag {
      position: absolute;

      &:nth-of-type(2) {
        top: calc(50% - 250px);
        right: calc(50% - 270px);
      }
      &:nth-of-type(3) {
        left: calc(50% - 270px);
        bottom: calc(50% - 140px);
      }
      &:nth-of-type(4) {
        bottom: calc(50% - 250px);
        left: calc(50% - 270px);
      }
    }

    .rest-image::before {
      content: "";
      background-color: rgba(111, 181, 120, 1);
      border-radius: 40%;
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);

      padding: 150px 220px;
      background-color: var(--verdeDeschis);

      box-shadow: 0px 0px 156px 80px rgba(111, 181, 120, 1);
      // box-shadow: 0px 0px 156px 80px rgba(197, 220, 160, 1);
    }
  }
  img {
    height: 600px;
    width: auto;
    border-radius: 1.5rem;
    position: relative;
  }
  .rest {
    padding-left: 300px;
    display: flex;
    flex-direction: column;
    gap: 64px;
    justify-content: center;

    .rest-name {
      margin: 0;
      font-size: 52px;
      font-weight: 700;
      letter-spacing: 0.75px;
      color: var(--verde);
    }
    .description {
      margin: 0;
      font-size: 24px;
      font-weight: 500;
      color: var(--verdeInchis);
      letter-spacing: 1px;
      padding-bottom: 24px;
    }
    .rest-info {
      display: grid;
      grid-template-columns: 1fr 2fr;
      row-gap: 24px;
      padding-left: 1rem;
      .rest-den {
        margin: 0;
        font-size: 20px;
        font-weight: 600;
        color: #333;
      }
      .rest-text {
        margin: 0;
        font-size: 20px;
        font-weight: 400;
        color: #333;
        text-decoration: none;
      }
      a.rest-text {
        color: var(--verde);
      }
    }
  }
}
.food-category {
  --text-color: var(--verdeInchis);
  --bg-color: hsl(83, 46%, 95%);
}

.drink-category {
  --text-color: var(--violetInchis);
  --bg-color: hsl(277, 32%, 95%);
}

.advertisment-category {
  --text-color: hsl(58, 75%, 45%);
  --bg-color: hsl(58, 75%, 95%);
}

.restaurant-menu {
  display: flex;
  justify-content: space-around;
  align-items: center;
  // gap: 16px;
  padding: 0 100px;
  .btn-menu {
    padding: 32px 48px;
    // background-color: var(--violetDeschis);
    border-radius: 8px;
    transition-property: box-shadow, transform;
    transition: 0.3s ease;
    will-change: box-shadow, transform;
    display: flex;
    gap: 24px;
    box-shadow: rgba(0, 0, 0, 0.08) 0px 4px 12px;
    justify-content: space-between;
    align-items: center;

    &:hover {
      box-shadow: rgba(0, 0, 0, 0.08) 0px 4px 12px;
      // transform: scale(1.05);
      background-color: var(--bg-color);
    }
    .btn-icon {
      font-size: 3rem;
      color: var(--text-color);
    }
    .btn-text {
      font-size: 24px;
      font-weight: 700px;
      text-decoration: none;
      display: block;
      color: var(--text-color);
    }
  }
}

.block-menu {
  background-color: var(--bg-color);
  padding: 48px 100px;
  margin: 100px 0px;
  letter-spacing: 0.75px;
  .menu-description {
    display: flex;
    align-items: center;
    .menu-icon {
      height: 64px;
      width: 64px;
      color: var(--text-color);
    }
    .menu-text {
      font-weight: 700;
      font-size: 48px;
      color: var(--text-color);
      margin-left: 100px;
    }
  }
}
</style>
