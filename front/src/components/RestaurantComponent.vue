<script setup>
import { ref, onMounted } from "vue";
import { Icon } from "@iconify/vue";
import SubsidiaryVue from "./SubsidiaryComponent.vue";
import {getRestaurant,getRestaurantSubsidiary, getRestaurantFood, getRestaurantDrink} from "../api";

import { useRoute } from 'vue-router'
const restaurant = ref({});
const subsidiaries = ref([]);
const food = ref([]);
const drink =ref([])
const route = useRoute();
onMounted(() => {
  getRestaurant({restaurantId: route.params.id})
      .then(({data}) => (restaurant.value=data))
  getRestaurantSubsidiary({restaurantId: route.params.id, pages: 1, nrOfItems: 10})
      .then(({data}) => (subsidiaries.value =data))
  getRestaurantFood({restaurantId: route.params.id, pages: 1, nrOfItems: 10})
      .then(({data}) => (food.value = data))
  getRestaurantDrink({restaurantId: route.params.id, pages: 1, nrOfItems: 10})
      .then(({data}) => (drink.value =data))
});
</script>

<template>
  <div>
    <div class="restaurant">
      <div class="rest">
        <h1
          class="rest-name"
          v-text="restaurant.restaurantName"
        />
        <div class="details">
          <h2 class="description">
            DETAILS
          </h2>
          <div class="rest-info">
            <h3 class="rest-den">
              <Icon
                class="btn-icon"
                icon="uil:receipt-alt"
              />Type:
            </h3>
            <h3
              class="rest-text"
              v-text="restaurant.description"
            />
            <h3 class="rest-den">
              <Icon
                class="btn-icon"
                icon="uil:pricetag-alt"
              />Prices Level:
            </h3>
            <h3 class="rest-text dollar">
              <template
                v-for="price in restaurant.pricing"
                :key="price"
              >
                $
              </template>
            </h3>
          </div>
        </div>
        <div class="contact">
          <h2 class="description">
            CONTACT INFORMATION
          </h2>
          <div class="rest-info">
            <h3 class="rest-den">
              <Icon
                class="btn-icon"
                icon="uil:phone-alt"
              />Phone:
            </h3>
            <a
              class="rest-text"
              :href="'tel:' + restaurant.phone_number "
              v-text="restaurant.phone_number"
            />

            <h3 class="rest-den">
              <Icon
                class="btn-icon"
                icon="uil:envelope"
              />
              Email:
            </h3>
            <a
              class="rest-text"
              :href="'mailto:' + restaurant.email"
              v-text="restaurant.email"
            />
          </div>
        </div>
      </div>
      <div class="rest-img">
        <div class="rest-image">
          <img
            src="../img/andys.jpg"
            alt="restaurant img"
          >
        </div>

        <!-- <template v-for="tag in tags">
          <HashTag :description="tag" />
        </template> -->
      </div>
    </div>
    <div class="restaurant-menu">
      <RouterLink
        class="btn-menu food-category"
        :to="{ path: '/restaurants/:id', hash: '#food-menu' }"
      >
        <div class="btn-align">
          <Icon
            class="btn-icon"
            icon="uil:restaurant"
          />
          <a class="btn-text">Food Menu</a>
        </div>
      </RouterLink>
      <RouterLink
        class="btn-menu drink-category"
        :to="{ path: '/restaurants/:id', hash: '#drink-menu' }"
      >
        <div class="btn-align">
          <Icon
            class="btn-icon"
            icon="uil:glass-martini"
          />
          <a class="btn-text">Drink Menu</a>
        </div>
      </RouterLink>
      <RouterLink
        class="btn-menu advertisment-category"
        :to="{ path: '/restaurants/:id', hash: '#advertisment' }"
      >
        <div class="btn-align">
          <Icon
            class="btn-icon"
            icon="uil:star"
          />

          <a class="btn-text">Subsidiaries</a>
        </div>
      </RouterLink>
    </div>

    <div
      id="food-menu"
      class="block-menu food-category food"
    >
      <div class="menu-description">
        <Icon
          class="menu-icon"
          icon="uil:restaurant"
        />
        <h1 class="menu-text">
          Food Menu
        </h1>
      </div>
      <div class="llist">
        <ul class="list">
          <li
            v-for="meal in food"
            :key="meal.restaurantId"
            class="list-item"
          >
            <img
              class="menu-img"
              src="../img/adelia.jpg"
              alt="item image"
            >
            <h2 class="title">
              {{ meal.foodName }}
            </h2>
            <h3 class="ingredients">
              {{ meal.foodIngredients }}
            </h3>
            <h3 class="price">
              {{ meal.foodPrice }} MDL
            </h3>
          </li>
        </ul>
      </div>
    </div>

    <div
      id="drink-menu"
      class="block-menu drink-category drink"
    >
      <div class="menu-description">
        <Icon
          class="menu-icon"
          icon="uil:glass-martini"
        />
        <h1 class="menu-text">
          Drink Menu
        </h1>
      </div>
      <div class="llist">
        <ul class="list">
          <li
            v-for="d in drink"
            :key="d.restaurantId"
            class="list-item"
          >
            <h2
              class="title"
            >
              {{ d.drinkName }}
            </h2>

            <h3 class="price">
              {{ d.drinkPrice }} MDL
            </h3>
          </li>
        </ul>
      </div>
    </div>
    <div
      id="advertisment"
      class="block-menu advertisment-category adv"
    >
      <div class="menu-description">
        <Icon
          class="menu-icon"
          icon="uil:star"
        />
        <h1 class="menu-text">
          Subsidiaries
        </h1>
      </div>
      <div class="subsidiaries">
        <template
          v-for="subsidiary in subsidiaries"
          :key="subsidiary.Id"
        >
          <SubsidiaryVue
            :title="subsidiary.subsidiaryName"
            :address="subsidiary.address"
            :tel="subsidiary.phoneNumber"
            :schedule="subsidiary.schedule"
          />
        </template>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.restaurant {
  background-color: #ffffff;
  background-image: radial-gradient(
    hsla(128, 32%, 57%, 0.3) 0.9px,
    #ffffff 0.9px
  );
  background-size: 18px 18px;
  display: grid;
  grid-template-columns: 45% 55%;
  align-items: center;
  justify-content: space-between;
  @media screen and (max-width: 544px) {
    grid-template-columns: 1fr;
    padding: 128px 0 64px 0;
  }
  .rest-img {
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 170px 96px 100px 96px;
    position: relative;
    @media screen and (max-width: 544px) {
      grid-row: 2;
      padding: 0 55px;
      background-image: radial-gradient(
        var(--verde) 40%,
        transparent 70%,
        transparent 100%
      );
      margin: 0 auto;

      // background-size: 100px;
      // width: 100vh;
      // flex-direction: column;
    }
    // .tag {
    //   position: absolute;

    //   &:nth-of-type(2) {
    //     top: calc(50% - 250px);
    //     right: calc(50% - 270px);
    //   }
    //   &:nth-of-type(3) {
    //     left: calc(50% - 270px);
    //     bottom: calc(50% - 140px);
    //   }
    //   &:nth-of-type(4) {
    //     bottom: calc(50% - 250px);
    //     left: calc(50% - 270px);
    //   }
    // }

    .rest-image::before {
      content: "";
      border-radius: 40%;
      position: absolute;
      top: 55%;
      left: 50%;
      transform: translate(-50%, -50%);
      padding: 150px 220px;
      background-color: var(--verdeDeschis);
      box-shadow: 0 0 156px 80px rgba(111, 181, 120, 1);
      @media screen and (max-width: 544px) {
        display: none;
      }
    }
  }
  img {
    height: 600px;
    width: auto;
    border-radius: 1.5rem;
    position: relative;
    @media screen and (max-width: 544px) {
      height: 350px;
      margin: 0 auto;
    }
  }
  .rest {
    padding-left: 300px;
    display: flex;
    flex-direction: column;
    gap: 64px;
    justify-content: center;
    @media screen and (max-width: 544px) {
      padding: 0 32px 64px 0;
      gap: 32px;
    }

    .rest-name {
      margin: 0;
      font-size: 52px;
      font-weight: 700;
      letter-spacing: 0.75px;
      color: var(--verde);
      @media screen and (max-width: 544px) {
        font-size: 36px;
      }
    }
    .description {
      margin: 0;
      font-size: 24px;
      font-weight: 500;
      color: var(--verdeInchis);
      letter-spacing: 1px;
      padding-bottom: 24px;
      @media screen and (max-width: 544px) {
        font-size: 24px;
      }
    }
    .rest-info {
      display: grid;
      grid-template-columns: 1fr 1.5fr;
      row-gap: 24px;
      // column-gap: 18px;
      padding-left: 1rem;
      @media screen and (max-width: 544px) {
        grid-template-columns: 1fr 1.5fr;
        gap: 24px;
      }
      .rest-den {
        margin: 0;
        font-size: 20px;
        font-weight: 600;
        color: #767676;
        display: flex;
        gap: 12px;
        @media screen and (max-width: 544px) {
          font-size: 18px;
        }
      }
      .rest-text {
        margin: 0;
        font-size: 20px;
        font-weight: 400;
        color: #767676;
        text-decoration: none;
        @media screen and (max-width: 544px) {
          font-size: 18px;
        }
      }
      .dollar {
        @media screen and (max-width: 544px) {
          align-self: flex-end;
        }
      }
      a.rest-text {
        color: var(--verde);
      }
    }
  }
}
.food-category {
  --text-color: var(--verdeInchis);
  --bg-color: hsl(128, 32%, 95%);
}
.food {
  background-color: #ffffff;
  background-image: radial-gradient(
    hsla(128, 32%, 57%, 0.3) 0.9px,
    #ffffff 0.9px
  );
  background-size: 18px 18px;
}

.drink-category {
  --text-color: hsl(58, 75%, 45%);
  --bg-color: hsl(58, 75%, 95%);
}
.drink {
  background-color: #ffffff;
  background-image: radial-gradient(
    hsla(58, 75%, 45%, 0.3) 0.9px,
    #ffffff 0.9px
  );
  background-size: 18px 18px;
}
.advertisment-category {
  --text-color: var(--violetInchis);
  --bg-color: hsl(277, 32%, 95%);
}
.adv {
  background-color: #ffffff;
  background-image: radial-gradient(
    hsla(277, 31%, 81%, 0.3) 0.9px,
    #ffffff 0.9px
  );
  background-size: 18px 18px;
}

.restaurant-menu {
  display: flex;
  justify-content: space-around;
  align-items: center;
  padding: 96px 100px;
  @media screen and (max-width: 544px) {
    padding: 48px 32px;
    display: grid;
    grid-template-columns: 1fr 1fr;
    // justify-content: center;
    gap: 24px;
    align-items: center;
    justify-content: center;
  }
  .btn-menu {
    text-decoration: none;
    padding: 32px 48px;
    border-radius: 8px;
    transition-property: box-shadow, transform;
    transition: 0.3s ease;
    will-change: box-shadow, transform;
    box-shadow: rgba(0, 0, 0, 0.08) 0 4px 12px;

    @media screen and (max-width: 544px) {
      padding: 24px 10px;
      width: 166px;
      align-self: center;
      justify-self: center;
      &:nth-of-type(3) {
        grid-row: 2;
        grid-column: 1/3;
        justify-self: center;
      }
    }

    &:hover {
      box-shadow: rgba(0, 0, 0, 0.08) 0 4px 12px;
      background-color: var(--bg-color);
    }
    .btn-align {
      display: flex;
      align-items: center;
      justify-content: center;
      gap: 24px;

      @media screen and (max-width: 544px) {
        gap: 8px;
      }

      .btn-icon {
        height: 48px;
        width: 48px;
        // font-size: 3rem;
        color: var(--text-color);
        @media screen and (max-width: 544px) {
          height: 24px;
          width: 24px;
        }
      }
      .btn-text {
        font-size: 24px;
        font-weight: 700;
        display: block;
        color: var(--text-color);
        text-decoration: none;
        // color: #333;
        @media screen and (max-width: 544px) {
          font-size: 18px;
        }
      }
    }
  }
}

.block-menu {
  background-color: var(--bg-color);
  padding: 48px 100px;
  margin: 100px 0;
  letter-spacing: 0.75px;
  @media screen and (max-width: 544px) {
    padding: 32px 32px;
  }
  .menu-description {
    display: flex;
    align-items: center;
    @media screen and (max-width: 544px) {
      gap: 24px;
    }
    .menu-icon {
      height: 64px;
      width: 64px;
      color: var(--text-color);
      @media screen and (max-width: 544px) {
        height: 36px;
      }
    }
    .menu-text {
      font-weight: 700;
      font-size: 48px;
      color: var(--text-color);
      margin-left: 100px;
      letter-spacing: 1.75px;
      @media screen and (max-width: 544px) {
        font-size: 36px;
        margin: 0;
      }
    }
  }
  .subsidiaries {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 80px;
    padding: 48px 0;
    @media screen and (max-width: 544px) {
      grid-template-columns: 1fr;
      gap: 48px;
    }
  }
  .list {
    margin: 0;
    list-style-type: none;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    row-gap: 96px;
    //column-gap: 128px;
    justify-content: space-between;
    align-items: center;
    padding: 48px 0;
    justify-items: center;
    @media screen and (max-width: 544px) {
      grid-template-columns: 1fr;
      padding: 48px 0;
      //gap: 64px;

    }
    .list-item {
      display: flex;
      flex-direction: column ;
      align-items: center;
      gap: 8px;
      width: 320px;
      @media screen and (max-width: 544px) {
        // justify-content: space-between;
        //column-gap: 48px;
      }
      .title {
        margin: 0;
        padding-top: 8px ;
        color: var(--text-color);
        font-size: 24px;
        font-weight: 500;
        @media screen and (max-width: 544px) {
          font-size: 24px;
        }
      }
      .menu-img{
        margin: 0 ;
        height: 250px;
        border-radius: 1rem;

      }
      .ingredients{
        margin: 0 ;
        color: #767676;
        font-size: 18px;
        font-weight: 400;

      }
      .price {
        margin: 0 ;
        padding-top: 8px ;
        color: #888;
        font-size: 24px;
        font-weight: 400;
        @media screen and (max-width: 544px) {
          font-size: 18px;
        }
      }
    }
  }
}
</style>
