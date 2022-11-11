<script setup>
defineProps(["title", "address", "tel", "schedule"]);
</script>

<template>
  <div class="subsidiary">
    <h1 class="title">{{ title }}</h1>

    <h2 class="tel">{{ tel }}</h2>
    <h2 class="address">{{ address }}</h2>

    <h2 class="schedule">{{ schedule }}</h2>
  </div>
</template>
<style scoped lang="scss">
.subsidiary {
  margin: 0;
  background-color: white;
  border-radius: 1rem;
  display: grid;
  grid-template-columns: 2fr 1fr;
  justify-content: center;
  align-items: center;
  row-gap: 18px;
  padding: 32px;
  transition-property: box-shadow, transform;
  transition: 0.3s ease;
  will-change: box-shadow, transform;
  box-shadow: rgba(17, 17, 26, 0.05) 0px 4px 16px,
    rgba(17, 17, 26, 0.05) 0px 8px 32px;
  @media screen and (max-width: 544px) {
    grid-template-columns: 1fr;
    gap: 8px;
  }

  &:hover {
    box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px 0px;
    transform: scale(1.05);
    @media screen and (max-width: 544px) {
      transform: none;
    }
  }

  .title {
    margin: 0;
    color: var(--violetInchis);
    color: #888;
    font-size: 30px;
    font-weight: 700;
    @media screen and (max-width: 544px) {
      font-size: 24px;
      justify-self: center;
    }
  }
  .address {
    margin: 0;
    color: var(--violetDeschis);
    font-size: 20px;
    font-weight: 500;
    letter-spacing: 1.75px;
    @media screen and (max-width: 544px) {
      grid-row: 2;
      justify-self: center;
      font-size: 18px;
      padding-bottom: 18px;
    }
  }

  .tel {
    display: block;
    margin: 0;
    color: #888;
    font-weight: 400;
    font-size: 20px;
    align-self: center;
    justify-self: flex-end;
    @media screen and (max-width: 544px) {
      justify-self: center;
      // font-size:
    }
  }
  .schedule {
    display: block;
    margin: 0;
    color: #888;
    font-weight: 400;
    justify-self: flex-end;
    align-self: center;
    font-size: 20px;
    @media screen and (max-width: 544px) {
      justify-self: center;
      // font-size: 24px;
    }
  }
}
</style>
