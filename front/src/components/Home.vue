<script setup>
import { ref, computed } from "vue";
import RestaurantItem from "./RestaurantItem.vue";
import Restaurant from "./Restaurant.vue";

const list = ref([
  { title: "vasea", description: "tipa vasea" },
  { title: "ada", description: "tipa ada" },
  { title: "grig", description: "tipa grig" },
]);
</script>

<template>
  <div>
    <div class="home">
      <div class="home-text">
        <h1 class="home-desc">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquam
          blanditiis praesentium odio minus
        </h1>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente,
          illo ea culpa ab dolore hic debitis aliquid? Ipsam odit itaque placeat
          vero consequatur quidem earum dolores ut minima, quos at?
        </p>
      </div>
      <img class="mancam" src="../img/mancam.jpg" alt="mancam" />
    </div>
    <div class="featured-in">
      <h2 class="heading-featured-in">As featured in</h2>
      <div class="logos">
        <img src="../img/faf_logo2.png" alt="FAF logo" />
        <img src="../img/IRPFC-logo-1.png" alt="Noction logo" />
        <img src="../img/utm-logo.png" alt="UTM logo" />
      </div>
    </div>

    <div class="top">
      <h1 class="top-description">
        MenuHub helps you to choose the best menu!
      </h1>
      <div class="top-restaurants">
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
      </div>
      <router-link class="see-more" to="/restaurants"
        >See more &rarr;</router-link
      >
    </div>
    <div class="testimonials-section">
      <div class="testimonials">
        <div class="galerie">
          <img class="galerie-img" src="../img/test.png" />
        </div>
        <div class="test-name-f">
          <h1 class="test-name">Aici ceva despre ceva</h1>
          <div class="testimonial-info">
            <figure class="testimonial">
              <img
                class="testimonial-img"
                alt="Photo of customer Dave Bryson"
                src="../img/ben.jpg"
              />
              <blockquote class="testimonial-text">
                Lorem ipsum dolor sit, amet consectetur adipisicing elit.
              </blockquote>
              <p class="testimonial-name">&mdash; Dave Bryson</p>
            </figure>
            <figure class="testimonial">
              <img
                class="testimonial-img"
                alt="Photo of customer Dave Bryson"
                src="../img/alice.jpg"
              />
              <blockquote class="testimonial-text">
                Lorem ipsum dolor sit, amet consectetur adipisicing elit.
              </blockquote>
              <p class="testimonial-name">&mdash; Dave Bryson</p>
            </figure>
            <figure class="testimonial">
              <img
                class="testimonial-img"
                alt="Photo of customer Dave Bryson"
                src="../img/marius.jpg"
              />
              <blockquote class="testimonial-text">
                Lorem ipsum dolor sit, amet consectetur adipisicing elit.
              </blockquote>
              <p class="testimonial-name">&mdash; Dave Bryson</p>
            </figure>
            <figure class="testimonial">
              <img
                class="testimonial-img"
                alt="Photo of customer Dave Bryson"
                src="../img/steve.jpg"
              />
              <blockquote class="testimonial-text">
                Lorem ipsum dolor sit, amet consectetur adipisicing elit.
              </blockquote>
              <p class="testimonial-name">&mdash; Dave Bryson</p>
            </figure>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped lang="scss">
.home {
  max-width: 100%;
  color: #888;
  box-shadow: rgba(33, 35, 38, 0.1) 0px 10px 10px -10px;
  overflow: hidden;
  display: grid;
  grid-template-columns: 1fr 1fr;

  padding: 0 64px;

  .home-desc {
    margin: 0;
    color: var(--verde);
  }

  .mancam {
    border-radius: 16px;
    margin: 80px 0;
    height: 500px;
    width: auto;
    justify-self: end;
    box-shadow: rgba(33, 35, 38, 0.1) 0px 10px 10px -10px;
  }
  .home-text {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 48px;
    margin-bottom: 48px;
    p {
      font-size: 24px;
    }
  }
}
.featured-in {
  padding: 48px 0 32px 0;
  margin-bottom: 48px;

  .heading-featured-in {
    font-size: 14px;
    text-transform: uppercase;
    letter-spacing: 0.75px;
    font-weight: 500;
    text-align: center;
    margin-bottom: 24px;
    color: #888;
  }

  .logos {
    margin: 0 400px;
    display: flex;
    justify-content: space-around;
  }

  .logos img {
    height: 64px;
    filter: brightness(0);
    opacity: 50%;
  }
}
.top-restaurants {
  margin: 128px 100px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  text-align: center;
  justify-content: center;
  font-size: 24px;
  gap: 100px;
  margin-bottom: 96px;

  .restaurant-info {
    text-decoration: none;
    text-align: left;
  }
}
.top-description {
  margin: 0;
  font-weight: 700;
  font-size: 48px;
  color: #333;
  margin: 100px;
}
.see-more {
  margin: 0 100px;
  display: block;
  border-radius: 16px;
  transition-property: box-shadow, transform;
  transition: 0.3s ease;
  will-change: box-shadow, transform;
  color: var(--verde);
  text-decoration: none;
  font-weight: 500;
  font-size: 24px;
  text-align: center;
  margin-bottom: 96px;
  &:hover {
    transform: scale(1.05);
  }
}

.testimonials-section {
  max-width: 100%;
  background-color: var(--verdeDeschis);
  margin-bottom: 96px;
  padding-bottom: 96px;
  // padding: 96px 100px;

  .test-name {
    margin: 0;
    font-weight: 700;
    font-size: 48px;
    color: #333;
  }
  .testimonials {
    display: flex;

    .testimonial-info {
      display: grid;
      grid-template-columns: 1fr 1fr;
      row-gap: 48px;
      column-gap: 80px;
    }

    .testimonial-img {
      width: 64px;
      border-radius: 50%;
      margin-bottom: 12px;
    }

    .testimonial-text {
      font-size: 18px;
      line-height: 1.8;
      margin-bottom: 16px;
    }

    .testimonial-name {
      font-size: 16px;
      color: #6f6f6f;
    }
    .galerie-img {
      margin-left: -5px;
      height: 550px;
      max-width: auto;
      border-radius: 16px;
    }
  }
}
</style>
