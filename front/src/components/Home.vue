<script setup>
import { ref, computed, onMounted } from "vue";
import RestaurantItem from "./RestaurantItem.vue";
import Restaurant from "./Restaurant.vue";
import HomeComponents from "./HomeComponents.vue";

const list = ref([]);
onMounted(() => {
  fetch("http://localhost:3000/list")
    .then((response) => response.json())
    .then((data) => (list.value = data));
});
</script>

<template>
  <div class="home-section">
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
    </div>
    <!-- <div class="home">
      <div class="home-sec-img">
        <img class="home-img" src="../img/Logo.png" />
      </div>
      <template v-for="item in list.slice(3, 10)">
        <router-link
          class="home-rest"
          :to="{ name: 'Restaurant', params: { id: item } }"
        >
          <home-components :title="item.title" />
        </router-link>
      </template>
    </div>  -->
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

    <div class="about-us" id="#a">
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
  </div>
</template>
<style scoped lang="scss">
.home {
  max-width: 100%;
  margin: 0;
  display: grid;
  grid-template-columns: 40% 60%;
  .home-desc {
    margin: 0;
    padding-top: 250px;
    display: flex;
    flex-direction: column;
    gap: 80px;

    .home-desc-img {
      height: 100px;
      padding-left: 250px;
    }
    .home-desc-text {
      margin: 0;
      font-size: 36px;
      font-weight: 700;
      letter-spacing: 0.75px;
      color: var(--verde);
      padding-left: 150px;
      text-align: center;
    }
  }
  .home-img {
    margin: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 90px 96px 170px 96px;
    position: relative;
    .home-rest {
      position: absolute;
      &:nth-of-type(1) {
        bottom: calc(50% - 50px);
        right: calc(50% - 190px);
      }
      &:nth-of-type(2) {
        bottom: calc(50% - 160px);
        right: calc(50% - 190px);
      }
      &:nth-of-type(3) {
        bottom: calc(50% - 270px);
        right: calc(50% - 190px);
      }
      &:nth-of-type(4) {
        top: calc(50% - 160px);
        left: calc(50% - 350px);
      }
      &:nth-of-type(5) {
        top: calc(50% - 270px);
        left: calc(50% - 350px);
      }
      &:nth-of-type(6) {
        top: calc(50% - 380px);
        left: calc(50% - 350px);
      }
    }
  }

  .home-photo::before {
    content: "";
    border-radius: 50%;
    position: absolute;
    top: 62%;
    left: 41%;
    transform: translate(-50%, -50%);
    padding: 170px;
    background-color: rgba(111, 181, 120, 0.86);

    box-shadow: 0px 0px 156px 100px rgba(111, 181, 120, 1);
  }
  .home-photo-1::before {
    content: "";
    border-radius: 50%;
    position: absolute;
    top: 28%;
    left: 42%;
    transform: translate(-50%, -50%);
    padding: 150px;
    background-color: rgba(111, 181, 120, 0.86);

    box-shadow: 0px 0px 156px 90px rgba(139, 122, 184, 1);
    box-shadow: 0px 0px 156px 80px rgba(201, 195, 29, 1);
  }
  .home-photo-2::before {
    content: "";
    border-radius: 50%;
    position: absolute;
    top: 50%;
    left: 57%;
    transform: translate(-50%, -50%);
    padding: 190px;
    background-color: rgba(111, 181, 120, 0.86);

    box-shadow: 0px 0px 156px 110px rgba(201, 195, 29, 1);
    box-shadow: 0px 0px 156px 110px rgba(139, 122, 184, 1);
  }
  img {
    height: 670px;
    width: auto;
    border-radius: 1.5rem;
    position: relative;
  }
}

// .home {
//   position: relative;
//   max-width: 100vh;
//   display: flex;
//   align-items: center;
//   justify-content: center;
//   margin: 340px auto;
//   .home-sec-img {
//     position: relative;
//     .home-img {
//       height: 150px;
//     }
//   }
//   .home-rest {
//     position: absolute;

//     &:nth-of-type(1) {
//       top: calc(50% - 170px);
//       left: calc(50% - 20px);
//       &:hover {
//         transform: rotate(5deg);
//       }
//     }
//     &:nth-of-type(2) {
//       top: calc(50% - 15px);
//       right: calc(50% - 500px);
//       // transform: rotate(-15deg);
//     }

//     &:nth-of-type(3) {
//       bottom: calc(50% - 300px);
//       right: calc(50% - 400px);
//       // transform: rotate(15 deg);
//     }
//     &:nth-of-type(4) {
//       bottom: calc(50% - 430px);
//       left: calc(50% - 200px);
//       // transform: rotate(-15deg);
//     }
//     &:nth-of-type(5) {
//       top: calc(50% - 15px);
//       left: calc(50% - 600px);
//     }
//     &:nth-of-type(6) {
//       bottom: calc(50% - 300px);
//       left: calc(50% - 700px);
//       // transform: rotate(-15deg);
//     }
//   }
// }

.featured-in {
  padding: 48px 0 32px 0;
  margin-bottom: 96px;

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
  max-width: 100%;
  background-color: hsl(83, 46%, 95%);
  margin-bottom: 200px;
  padding: 64px 96px;

  .test-name {
    margin: 0;
    font-weight: 700;
    font-size: 48px;
    color: var(--verdeInchis);
    padding-bottom: 32px;
    padding-left: 40px;
    letter-spacing: 0.75px;
    // text-align: center;
    background-image: radial-gradient(var(--verde) 0%, transparent 55%);
  }

  .testimonials {
    background-color: white;
    border-radius: 2rem;
    display: flex;
    overflow: hidden;
    align-items: center;
    justify-content: center;
    .gallery {
      .gallery-img {
        height: 650px;
      }
    }

    .testimonial-info {
      padding: 64px;
      display: grid;
      grid-template-columns: 1fr 1fr;
      gap: 32px;
      justify-content: center;
      align-items: center;
    }

    .testimonial-img {
      width: 64px;
      border-radius: 50%;
    }

    .testimonial-text {
      padding: 0;
      margin: 0;
      font-size: 18px;
      line-height: 1.8;
      margin-bottom: 16px;
      color: var(--verdeInchis);
      font-weight: 500;
    }
  }
}
.about-us {
  padding: 0 100px;
  padding-bottom: 200px;

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
      padding-bottom: 64px;
      color: var(--verde);
      font-size: 24px;
      font-weight: 500;
      padding-right: 500px;
      padding-bottom: 96px;
    }
  }
  .team {
    display: flex;
    justify-content: space-around;
    align-items: center;
    // padding-top: 128px;
    gap: 48px;

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
      font-size: 20px;
      font-weight: 500;
      color: var(--verde);

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
