<script setup>
import { ref, onMounted, watch } from "vue";
import RestaurantItem from "./RestaurantItem.vue";
import Restaurant from "./RestaurantComponent.vue";
import HomeComponents from "./HomeComponents.vue";
import { Icon } from "@iconify/vue";
import {getRestaurantAll} from "../api";

// const list = ref([]);
const list = ref([]);
onMounted(() => {
  getRestaurantAll({pages: 1, nrOfItems: 6})
      .then(({data}) => (list.value =data))
});

const emit = defineEmits(["show-nav", "show-tipa"]);

const currentSection = ref("");
// const tipa = ref(false);

watch(currentSection, (val) => {
  emit("show-nav", val !== "home");
});

onMounted(() => {
  const observer = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
      if (entry.target.getAttribute("class") === "home") {
        if (entry.intersectionRatio > 0) {
          console.log("1111111");
          emit("show-tipa", false);
        } else {
          console.log("000000000000");
          emit("show-tipa", true);
        }
      }

      if (entry.intersectionRatio > 0) {
        currentSection.value = entry.target.getAttribute("class");
      }
    });
  });
  document.querySelectorAll("section").forEach((section) => {
    observer.observe(section);
  });
});
</script>
<template>
  <section class="home">
    <div class="home-sec-img">
      <img
        class="home-img"
        src="../img/Logo.png"
        alt="MenuHub logo"
      >
    </div>
    <template
      v-for="item in list"
      :key="item.restaurantId"
    >
      <router-link
        :to="{ name: 'Restaurant', params: { id: item.restaurantId } }"
      >
        <home-components :title="item.restaurantName" />
      </router-link>
    </template>
    <span />
    <router-link
      class="details"
      :to="{ path: '/', hash: '#feature' }"
    >
      Details &darr;
    </router-link>
  </section>
  <section
    id="feature"
    class="featured-in"
  >
    <h1 class="heading-featured-in">
      As featured in
    </h1>
    <div class="logos">
      <img
        src="../img/faf_logo2.png"
        alt="FAF logo"
      >
      <img
        class="noction"
        src="../img/IRPFC-logo-1.png"
        alt="Noction logo"
      >
      <img
        src="../img/utm-logo.png"
        alt="UTM logo"
      >
    </div>
  </section>
  <section class="top">
    <h1 class="top-description">
      MenuHub helps you to choose the best menu!
    </h1>
    <div class="top-restaurants">
      <div
        v-for="item in list.slice(0, 3)"
        :key="item.restaurantId"
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
    </div>
    <router-link
      class="see-more"
      to="/restaurants"
    >
      See more
      <Icon
        class="icon"
        icon="ic:round-keyboard-arrow-right"
      />
      <!-- <Icon class="icon" icon="tabler:arrow-narrow-right" /> -->
    </router-link>
  </section>
  <section class="testimonials-section">
    <h1 class="test-name">
      Testimonials
    </h1>
    <div class="testimonials">
      <div class="gallery">
        <div class="gal">
          <img
            class="gallery-img"
            src="../img/louis-hansel--rUVo0vua1M-unsplash1.jpg"
            alt="people testimonial"
          >
        </div>
      </div>

      <div class="testimonial-info">
        <div class="test-border">
          <div class="test-el">
            <figure class="testimonial">
              <img
                class="testimonial-img"
                alt="Photo of customer Dave Bryson"
                src="../img/ben.jpg"
              >
              <div class="testimonail-text">
                <blockquote class="testimonial-text">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                </blockquote>
                <p class="testimonial-name">
                  &mdash; Dave Bryson
                </p>
              </div>
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
              >
              <div class="testimonail-text">
                <blockquote class="testimonial-text">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                </blockquote>
                <p class="testimonial-name">
                  &mdash; Dave Bryson
                </p>
              </div>
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
              >
              <div class="testimonail-text">
                <blockquote class="testimonial-text">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                </blockquote>
                <p class="testimonial-name">
                  &mdash; Dave Bryson
                </p>
              </div>
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
              >
              <div class="testimonail-text">
                <blockquote class="testimonial-text">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                </blockquote>
                <p class="testimonial-name">
                  &mdash; Dave Bryson
                </p>
              </div>
            </figure>
          </div>
        </div>
      </div>
    </div>
  </section>

  <section
    id="about-us"
    class="about-us"
  >
    <div class="about-us-info">
      <h1 class="about-us-desc">
        About Us
      </h1>
      <p class="about-us-p">
        We are Software Engineers students from TUM university...
      </p>
    </div>
    <div class="team">
      <div class="adelia">
        <img
          class="team-img"
          src="../img/gabi.jpg"
          alt="member Gabriel"
        >
        <h1 class="member-name">
          Gabriel Gîtlan
        </h1>
        <h2 class="member-post">
          DevOps
        </h2>
      </div>
      <div class="adelia">
        <img
          class="team-img"
          src="../img/andrei.jpg"
          alt="member Andrei"
        >
        <h1 class="member-name">
          Andrei Sărăteanu
        </h1>
        <h2 class="member-post">
          Back-End
        </h2>
      </div>
      <div class="adelia">
        <img
          class="team-img"
          src="../img/adelia.jpg"
          alt="member Adelia"
        >
        <h1 class="member-name">
          Adelia Braguţa
        </h1>
        <h2 class="member-post">
          Front-End
        </h2>
      </div>
      <div class="adelia">
        <img
          class="team-img"
          src="../img/valeria.jpg"
          alt="member Valeria"
        >
        <h1 class="member-name">
          Valeria Cozlov
        </h1>
        <h2 class="member-post">
          UI/UX Design
        </h2>
      </div>
      <div class="adelia">
        <img
          class="team-img"
          src="../img/photo_2022-11-21_15-05-59.jpg"
          alt="member Grigore"
        >
        <h1 class="member-name">
          Grigore Guzun
        </h1>
        <h2 class="member-post">
          Back-End
        </h2>
      </div>
      <div class="adelia">
        <img
          class="team-img"
          src="../img/tudor.jpg"
          alt="member Tudor"
        >
        <h1 class="member-name">
          Tudor Sîrghi
        </h1>
        <h2 class="member-post">
          Project Manager
        </h2>
      </div>
    </div>
  </section>
</template>
<style scoped lang="scss">
.home {
  position: relative;
  z-index: 1000;
  height: 100vh;
  width: auto;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 100px;
  background-color: #ffffff;
  background-image: radial-gradient(
    hsla(256, 30%, 60%, 0.3) 0.9px,
    #ffffff 0.9px
  );
  background-size: 18px 18px;
  @media screen and (max-width: 544px) {
    height: 70vh;
  }
  .home-sec-img {
    position: relative;

    .home-img {
      height: 150px;
      @media screen and (max-width: 544px) {
        height: 75px;
      }
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
    animation: wiggle 2s ease infinite;
    @media screen and (max-width: 544px) {
      display: none;
    }

    @keyframes wiggle {
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
    @media screen and (max-width: 544px) {
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
      transform: rotate(5deg);
      @media screen and (max-width: 544px) {
        top: 44px;
        transform: rotate(0deg);
      }
    }
    &:nth-of-type(2) {
      --bg-color: #8b7ab8;
      --txt-color: #8b7ab8;
      --bg-color-1: hsl(277, 32%, 95%);

      top: 220px;
      right: 190px;
      transform: rotate(-5deg);
      @media screen and (max-width: 544px) {
        top: 114px;
        right: 30px;
        transform: rotate(-5deg);
      }
    }

    &:nth-of-type(3) {
      bottom: 200px;
      right: 250px;
      --bg-color: #6fb578;
      --txt-color: #405f5a;
      --bg-color-1: hsl(128, 32%, 95%);

      transform: rotate(5deg);
      @media screen and (max-width: 544px) {
        bottom: 114px;
        right: 30px;
        transform: rotate(5deg);
      }
    }
    &:nth-of-type(4) {
      bottom: 100px;
      --bg-color: rgba(201, 195, 29, 1);
      --txt-color: rgba(201, 195, 29, 1);
      --bg-color-1: hsl(58, 75%, 95%);

      transform: rotate(-5deg);
      @media screen and (max-width: 544px) {
        bottom: 44px;
      }
    }
    &:nth-of-type(5) {
      top: 270px;
      left: 200px;
      --bg-color: rgba(201, 195, 29, 1);
      --txt-color: rgba(201, 195, 29, 1);
      --bg-color-1: hsl(58, 75%, 95%);

      transform: rotate(-5deg);
      @media screen and (max-width: 544px) {
        top: 124px;
        left: 30px;
        transform: rotate(5deg);
      }
    }
    &:nth-of-type(6) {
      bottom: 114px;
      left: 290px;
      --bg-color: #8b7ab8;
      --txt-color: #8b7ab8;
      --bg-color-1: hsl(277, 32%, 95%);

      transform: rotate(3deg);
      @media screen and (max-width: 544px) {
        bottom: 114px;
        left: 30px;
        transform: rotate(-3deg);
      }
    }
  }
}

.featured-in {
  padding: 48px 0 32px 0;
  margin-bottom: 96px;
  @media screen and (max-width: 544px) {
    margin:0 0 48px 0;
  }

  .heading-featured-in {
    font-size: 18px;
    text-transform: uppercase;
    letter-spacing: 0.75px;
    font-weight: 500;
    text-align: center;
    margin-bottom: 24px;
    color: #888;
    @media screen and (max-width: 544px) {
      font-size: 10px;
    }
  }

  .logos {
    margin: 0 400px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    @media screen and (max-width: 544px) {
      margin: 0 10px;
    }
  }

  .logos img {
    height: 64px;
    filter: brightness(0);
    opacity: 50%;
    @media screen and (max-width: 544px) {
      height: 32px;
    }
    &:nth-of-type(2) {
      // height: 90px;
      transform: scale(1.3);
    }
  }
}
.top {
  padding: 96px 100px;
  @media screen and (max-width: 1555px) {
    padding-left: 48px;
    padding-right: 48px;
  }
  @media screen and (max-width: 544px) {
    padding: 32px;
  }
}
.top-description {
  font-weight: 700;
  font-size: 48px;
  color: var(--verdeInchis);
  // margin-left: 100px;
  letter-spacing: 0.75px;
  @media screen and (max-width: 544px) {
    font-size: 36px;
    margin: 0 24px 0 0;
  }
}
.top-restaurants {
  display: grid;
  margin: 96px 0;

  grid-template-columns: 1fr 1fr 1fr;
  text-align: center;
  justify-content: center;
  font-size: 24px;
  gap: 100px;
  @media screen and (max-width: 1555px) {
    gap: 48px;
    justify-content: space-between;
  }
  @media screen and (max-width: 544px) {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 64px 0;
    gap: 64px;
  }

  .restaurant-info {
    text-decoration: none;
    text-align: left;
  }
}
.see-more {
  margin: 0 100px 96px 0;
  transition-property: box-shadow, transform;
  transition: 0.3s ease;
  will-change: box-shadow, transform;
  color: var(--verde);
  text-decoration: none;
  font-weight: 500;
  font-size: 24px;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 4px;

  @media screen and (max-width: 544px) {
    margin: 0 0 96px 0;
    font-size: 24px;
  }

  &:hover {
    transform: scale(1.05);
  }
  .icon {
    height: 32px;
    width: 32px;
    color: var(--bg-color);
  }
}

.testimonials-section {
  background-color: #f3eef6;

  background-image: radial-gradient(
    hsla(256, 30%, 60%, 0.3) 0.9px,
    #ffffff00 0.9px
  );
  background-size: 18px 18px;
  padding: 96px 96px 96px 48px;
  box-shadow: hsl(277deg 32% 95%) 0 0 20px 10px;
  @media screen and (max-width: 544px) {
    padding: 48px 0;
    margin-bottom: 32px;
  }

  .test-name {
    margin: 0;
    font-weight: 700;
    font-size: 48px;
    color: var(--violetInchis);
    padding-bottom: 32px;
    padding-left: 80px;
    letter-spacing: 0.75px;
    @media screen and (max-width: 544px) {
      padding: 32px;
      font-size: 36px;

      // margin: 32px;
    }
  }

  .testimonials {
    display: flex;
    gap: 32px;
    align-items: center;
    @media screen and (max-width: 544px) {
      display: grid;
      grid-template-columns: 1fr;
    }

    .gallery {
      padding: 18px 80px;
      display: flex;
      align-items: center;
      justify-content: center;
      background-image: radial-gradient(
        var(--violetInchis) 40%,
        transparent 70%,
        transparent 100%
      );
      @media screen and (max-width: 544px) {
        grid-row: 2;
        margin: 0 auto;
        padding: 0 55px;

        // width: 350px;
      }
      .gal {
        @media screen and (max-width: 544px) {
          grid-row: 2;
          // padding-top: 32px;
          // width: 350px;
        }

        .gallery-img {
          height: 550px;
          width: auto;

          border-radius: 1.5rem;
          @media screen and (max-width: 544px) {
            height: 300px;
          }
        }
      }
    }

    .testimonial-info {
      padding-right: 48px;
      display: grid;
      grid-template-columns: 1fr 1fr;
      gap: 64px;
      justify-content: center;
      align-items: center;
      @media screen and (max-width: 1555px) {
        gap: 48px;
        padding: 0;
      }
      @media screen and (max-width: 544px) {
        grid-template-columns: 1fr;
        gap: 48px;
        justify-content: center;
        padding: 0 0 32px 0;
        justify-self: center; // margin: 32px;
      }

      .test-border {
        @media screen and (max-width: 544px) {
          margin: 0 auto;
          padding: 0 32px;
        }
      }
      .test-el {
        cursor: pointer;
        background-color: white;
        border-radius: 1rem;
        padding: 32px 32px;
        box-shadow: rgba(17, 17, 26, 0.05) 0 4px 16px,
          rgba(17, 17, 26, 0.05) 0 8px 32px;
        transition-property: box-shadow, transform;
        transition: 0.3s ease;
        will-change: box-shadow, transform;

        @media screen and (max-width: 544px) {
          margin: 0;
          padding: 0;
          // width: 300px;
          background-color: transparent;
          box-shadow: none;
        }

        &:hover {
          box-shadow: rgba(0, 0, 0, 0.15) 0 5px 15px 0;
          transform: scale(1.15);
          @media screen and (max-width: 544px) {
            box-shadow: none;
            transform: none;
            cursor: none;
          }
        }
      }
      .testimonial {
        margin: 0;
        display: grid;
        grid-template-columns: 1fr 2fr;
        @media screen and (max-width: 1555px) {
          column-gap: 12px;
        }
        @media screen and (max-width: 544px) {
          // column-gap: 24px;
        }

        .testimonial-img {
          width: 80px;
          border-radius: 8px;
          grid-row: 1/3;
          margin-top: 8px;
          @media screen and (max-width: 544px) {
            display: block;
            // margin: 0 auto;
            margin-top: 8px;
          }
        }

        .testimonial-text {
          padding: 0;
          margin: 0 0 16px 0 ;
          font-size: 18px;
          line-height: 1.8;
          color: var(--violetInchis);
          font-weight: 400;
          @media screen and (max-width: 544px) {
            font-size: 18px;
          }
        }
        .testimonial-name {
          color: #767676;
          @media screen and (max-width: 544px) {
            margin: 0;
            font-size: 16px;
          }
        }
      }
    }
  }
}
.about-us {
  padding: 210px 96px;
  @media screen and (max-width: 544px) {
    padding: 64px 32px 128px 32px;
  }

  .about-us-info {
    .about-us-desc {
      margin: 0;
      font-weight: 700;
      font-size: 48px;
      color: var(--verdeInchis);
      padding-bottom: 24px;
      letter-spacing: 0.75px;
      @media screen and (max-width: 544px) {
        font-size: 36px;
        // padding-bottom: 32px;
      }
    }
    .about-us-p {
      margin: 0;
      // color: var(--verde);
      color: #767676;
      font-size: 24px;
      font-weight: 500;
      padding-right: 500px;
      padding-bottom: 48px;
      @media screen and (max-width: 544px) {
        font-size: 24px;
        padding: 0 0 48px 0;
      }
    }
  }
  .team {
    display: flex;
    justify-content: space-between;
    align-items: center;
    gap: 48px;
    cursor: pointer;
    @media screen and (max-width: 1555px) {
      display: grid;
      grid-template-columns: 1fr 1fr 1fr;
      gap: 32px;
    }
    @media screen and (max-width: 544px) {
      display: grid;
      grid-template-columns: 1fr 1fr;
      gap: 32px;
    }

    .adelia {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      gap: 4px;
      transition-property: box-shadow, transform;
      transition: 0.3s ease;
      will-change: box-shadow, transform;
      filter: grayscale(100%);
      opacity: 90%;
      @media screen and (max-width: 544px) {
        opacity: 90%;
        filter: grayscale(100%);
      }
      &:hover {
        transform: scale(1.3) rotate(1deg);
        filter: grayscale(0%);
        opacity: 100%;
        @media screen and (max-width: 544px) {
          transform: scale(1.3) rotate(1deg);
          filter: grayscale(0%);
          opacity: 1;
        }
      }
      &:hover:nth-of-type(2n) {
        transform: scale(1.3) rotate(-1deg);
      }
    }
    .team-img {
      height: 200px;
      border-radius: 16px;
      box-shadow: rgba(0, 0, 0, 0.1) 0 10px 15px -3px,
        rgba(0, 0, 0, 0.05) 0px 4px 6px -2px;
      @media screen and (max-width: 544px) {
        height: 110px;
      }
    }
    .member-name {
      margin: 0;
      font-size: 22px;
      font-weight: 500;
      color: var(--verdeInchis);
      padding-top: 1px;
      transform: none;
      @media screen and (max-width: 544px) {
        font-size: 18px;
      }
    }
    .member-post {
      margin: 0;
      font-weight: 400;
      font-size: 18px;
      letter-spacing: 0.75px;
      color: var(--violetInchis);
      @media screen and (max-width: 544px) {
        font-size: 16px;
      }
    }
  }
}
</style>
