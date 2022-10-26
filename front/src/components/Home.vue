<script setup>
import { ref, computed, onMounted } from "vue";
import RestaurantItem from "./RestaurantItem.vue";
import Restaurant from "./Restaurant.vue";
import HomeComponents from "./HomeComponents.vue";

// const list = ref([]);
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
onMounted(() => {
  fetch("http://localhost:3000/list")
    .then((response) => response.json())
    .then((data) => (list.value = data));
});
</script>

<template>
  <!-- <div class="home-section">
    <div class="home-home">
      <div class="home">
        <div class="home-desc">
          <div>
            <img class="home-desc-img" src="../img/Logo.png" />
          </div>
          <h3 class="home-desc-text">
            Your girlfriend has no idea what she wants to eat? We can help with
            that!
          </h3>
        </div>
        <div class="home-img">
          <div class="home-photo">
            <div class="home-photo-1">
              <div class="home-photo-2">
                <img src="../img/davey-gravy-DmO662qvWO8-unsplash.jpg" />
              </div>
            </div>
          </div>
          <template v-for="item in list.slice(3, 10)">
            <router-link
              class="home-rest"
              :to="{ name: 'Restaurant', params: { id: item } }"
            >
              <home-components :title="item.title" />
            </router-link>
          </template>
        </div>
      </div>
    </div> -->
  <div class="home">
    <div class="home-sec-img">
      <img class="home-img" src="../img/Logo.png" />
    </div>
    <template v-for="item in list.slice(3, 10)">
      <router-link :to="{ name: 'Restaurant', params: { id: item } }">
        <home-components :title="item.title" />
      </router-link>
    </template>
    <span></span>
    <router-link class="details" :to="{ path: '/', hash: '#feature' }"
      >Details &darr;</router-link
    >
  </div>
  <div class="featured-in" id="feature">
    <h2 class="heading-featured-in">As featured in</h2>
    <div class="logos">
      <img src="../img/faf_logo2.png" alt="FAF logo" />
      <img class="noction" src="../img/IRPFC-logo-1.png" alt="Noction logo" />
      <img src="../img/utm-logo.png" alt="UTM logo" />
    </div>
  </div>
  <div class="top">
    <h1 class="top-description">MenuHub helps you to choose the best menu!</h1>
    <div class="top-restaurants">
      <div v-for="item in list.slice(0, 3)">
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
    <h1 class="test-name">Aici ceva despre ceva</h1>
    <div class="testimonials">
      <div class="gallery">
        <img
          class="gallery-img"
          src="../img/louis-hansel--rUVo0vua1M-unsplash1.jpg"
        />
      </div>

      <div class="testimonial-info">
        <div class="test-border">
          <div class="test-el">
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
          </div>
        </div>
        <div class="test-border">
          <div class="test-el">
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
          </div>
        </div>
        <div class="test-border">
          <div class="test-el">
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
          </div>
        </div>
        <div class="test-border">
          <div class="test-el">
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

  <div class="about-us" id="about-us">
    <div class="about-us-info">
      <h1 class="about-us-desc">About Us</h1>
      <p class="about-us-p">We are</p>
    </div>
    <div class="team">
      <div class="adelia">
        <img class="team-img" src="../img/gabi.jpg" />
        <h1 class="member-name">Gabriel Gîtlan</h1>
        <h2 class="member-post">DevOps</h2>
      </div>
      <div class="adelia">
        <img class="team-img" src="../img/andrei.jpg" />
        <h1 class="member-name">Andrei Sărăteanu</h1>
        <h2 class="member-post">Back-End</h2>
      </div>
      <div class="adelia">
        <img class="team-img" src="../img/adelia.jpg" />
        <h1 class="member-name">Adelia Braguţa</h1>
        <h2 class="member-post">Front-End</h2>
      </div>
      <div class="adelia">
        <img class="team-img" src="../img/valeria.jpg" />
        <h1 class="member-name">Valeria Cozlov</h1>
        <h2 class="member-post">UI/UX Design</h2>
      </div>
      <div class="adelia">
        <img class="team-img" src="../img/grigore.jpg" />
        <h1 class="member-name">Grigore Guzun</h1>
        <h2 class="member-post">Back-End</h2>
      </div>
      <div class="adelia">
        <img class="team-img" src="../img/tudor.jpg" />
        <h1 class="member-name">Tudor Sîrghi</h1>
        <h2 class="member-post">Project Manager</h2>
      </div>
    </div>
  </div>
</template>
<style scoped lang="scss">
.home {
  position: relative;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 100px;
  background-color: #ffffff;
  // opacity: 0.4;
  background-image: radial-gradient(
    hsla(256, 30%, 60%, 0.3) 0.9px,
    #ffffff 0.9px
  );
  background-size: 18px 18px;

  .home-sec-img {
    position: relative;
    .home-img {
      height: 150px;
    }
  }
  .details {
    position: absolute;
    bottom: 70px;
    right: 100px;
    font-weight: 500;
    font-size: 30px;
    color: var(--verde);
    transition-property: box-shadow, transform;
    transition: 0.3s ease;
    will-change: box-shadow, transform;
    cursor: pointer;
    animation: wiggle 1.5s ease infinite;

    /* Keyframes */
    @keyframes wiggle {
      // 0%,
      0%,
      20%,
      50%,
      80%,
      100% {
        transform: translateY(0);
      }
      40% {
        transform: translateY(-30px);
      }
      60% {
        transform: translateY(-15px);
      }
    }
    &:hover {
      animation-play-state: paused;
    }
  }
  a {
    position: absolute;
    text-decoration: none;

    &:nth-of-type(1) {
      --bg-color: #6fb578;
      --bg-color-1: hsl(128, 32%, 95%);
      --txt-color: #405f5a;
      top: 95px;
      // transform: scale(0.9);
      transform: rotate(5deg);
    }
    &:nth-of-type(2) {
      --bg-color: #8b7ab8;
      --txt-color: #8b7ab8;
      --bg-color-1: hsl(277, 32%, 95%);

      top: 220px;
      right: 190px;
      transform: rotate(-5deg);
    }

    &:nth-of-type(3) {
      bottom: 200px;
      right: 250px;
      --bg-color: #6fb578;
      --txt-color: #405f5a;
      --bg-color-1: hsl(128, 32%, 95%);

      transform: rotate(5deg);
    }
    &:nth-of-type(4) {
      bottom: 110px;
      --bg-color: rgba(201, 195, 29, 1);
      --txt-color: rgba(201, 195, 29, 1);
      --bg-color-1: hsl(58, 75%, 95%);

      transform: rotate(-5deg);
    }
    &:nth-of-type(5) {
      top: 270px;
      left: 200px;
      --bg-color: rgba(201, 195, 29, 1);
      --txt-color: rgba(201, 195, 29, 1);
      --bg-color-1: hsl(58, 75%, 95%);

      transform: rotate(-5deg) scale(0.9);
    }
    &:nth-of-type(6) {
      bottom: 190px;
      left: 290px;
      --bg-color: #8b7ab8;
      --txt-color: #8b7ab8;
      --bg-color-1: hsl(277, 32%, 95%);

      transform: rotate(3deg);
    }
  }
}

.featured-in {
  padding: 48px 0 32px 0;
  margin-bottom: 96px;

  .heading-featured-in {
    font-size: 18px;
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
.top-description {
  font-weight: 700;
  font-size: 48px;
  color: var(--verdeInchis);
  margin-left: 100px;
  letter-spacing: 0.75px;
}
.top-restaurants {
  margin: 96px 100px;
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
  background-color: #f3eef6;

  background-image: radial-gradient(
    hsla(256, 30%, 60%, 0.3) 0.9px,
    #ffffff00 0.9px
  );
  background-size: 18px 18px;
  // margin-bottom: 128px;
  padding: 96px 96px 96px 48px;
  box-shadow: hsl(277deg 32% 95%) 0px 0px 20px 10px;
  .test-name {
    margin: 0;
    font-weight: 700;
    font-size: 48px;
    color: var(--violetInchis);
    padding-bottom: 32px;
    padding-left: 80px;
    letter-spacing: 0.75px;
    // text-align: center;
  }

  .testimonials {
    // background-color: white;
    // border-radius: 2rem;
    display: flex;
    gap: 32px;
    align-items: center;
    .gallery {
      padding: 18px 80px;
      background-image: radial-gradient(
        var(--violetInchis) 40%,
        transparent 70%,
        transparent 100%
      );
      .gallery-img {
        height: 550px;
        border-radius: 1.5rem;
        // align-content: flex-end;
      }
    }

    .testimonial-info {
      // padding: 64px;
      padding-right: 48px;
      display: grid;
      grid-template-columns: 1fr 1fr;
      gap: 64px;
      justify-content: center;
      align-items: center;

      .test-el {
        cursor: pointer;
        background-color: white;
        border-radius: 1rem;
        padding: 32px 32px;
        box-shadow: rgba(0, 0, 0, 0.15) 0px 4px 25px 0px;
        transition-property: box-shadow, transform;
        transition: 0.3s ease;
        will-change: box-shadow, transform;

        &:hover {
          box-shadow: rgba(0, 0, 0, 0.2) 0px 12px 28px 0px,
            rgba(0, 0, 0, 0.1) 0px 2px 4px 0px,
            rgba(255, 255, 255, 0.05) 0px 0px 0px 1px inset;
          transform: scale(1.15);
        }
      }
      .testimonial {
        margin: 0;
        display: grid;
        grid-template-columns: 1fr 2fr;

        .testimonial-img {
          width: 80px;
          border-radius: 8px;
          grid-row: 1/3;
          // align-self: center;
          margin-top: 8px;
        }

        .testimonial-text {
          padding: 0;
          margin: 0;
          font-size: 18px;
          line-height: 1.8;
          margin-bottom: 16px;
          color: var(--violetInchis);
          font-weight: 500;
        }
      }
    }
  }
}
.about-us {
  margin: 200px 96px;
  // margin-bottom: 500px;

  .about-us-info {
    // padding-top: 96px;

    .about-us-desc {
      margin: 0;
      font-weight: 700;
      font-size: 48px;
      color: var(--verdeInchis);
      padding-bottom: 24px;
      letter-spacing: 0.75px;
    }
    .about-us-p {
      margin: 0;
      // padding-bottom: 64px;
      color: var(--verde);
      font-size: 24px;
      font-weight: 500;
      padding-right: 500px;
      padding-bottom: 48px;
    }
  }
  .team {
    display: flex;
    justify-content: space-between;
    align-items: center;
    // padding-top: 128px;
    gap: 48px;
    cursor: pointer;

    .adelia {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      gap: 8px;
      transition-property: box-shadow, transform;
      transition: 0.3s ease;
      will-change: box-shadow, transform;
      filter: grayscale(100%);
      opacity: 90%;
      &:hover {
        transform: scale(1.3) rotate(1deg);
        filter: grayscale(0%);
        opacity: 100%;
      }
      &:hover:nth-of-type(2n) {
        transform: scale(1.3) rotate(-1deg);
      }
    }
    .team-img {
      height: 200px;
      border-radius: 16px;

      box-shadow: rgba(0, 0, 0, 0.1) 0px 10px 15px -3px,
        rgba(0, 0, 0, 0.05) 0px 4px 6px -2px;
    }
    .member-name {
      margin: 0;
      font-size: 22px;
      font-weight: 500;
      color: var(--verde);
      padding-top: 8px;

      // letter-spacing: 0.75px;
    }
    .member-post {
      margin: 0;
      font-weight: 400;
      font-size: 18px;
      letter-spacing: 0.75px;
      color: var(--violetInchis);
    }
  }
}
</style>
