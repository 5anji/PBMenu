<template>
  <div class="home">
    <div class="home-desc">dfgd</div>
    <div class="home-img">
      <div class="home-photo">
        <div class="home-photo-1">
          <img src="../img/oro.jpg" />
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped lang="scss">
.home {
  margin: 0;
  display: grid;
  grid-template-columns: 40% 60%;
  .home-desc {
    margin: 0;
    padding-top: 100px;
  }
  .home-img {
    margin: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 300px 96px 170px 96px;
    position: relative;
  }

  .home-photo::before {
    content: "";
    border-radius: 40%;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 150px 220px;
    background-color: rgba(111, 181, 120, 0.86);

    box-shadow: 0px 0px 156px 80px rgba(111, 181, 120, 1);
    // box-shadow: 0px 0px 156px 80px rgba(197, 220, 160, 1);
  }
  .home-photo-1::before {
    content: "";
    border-radius: 40%;
    position: absolute;
    top: 30%;
    left: 45%;
    transform: translate(-50%, -50%);
    padding: 150px 200px;
    background-color: rgba(111, 181, 120, 0.86);

    box-shadow: 0px 0px 156px 80px rgba(139, 122, 184, 1);
  }
  img {
    height: 700px;
    width: auto;
    border-radius: 1.5rem;
    // position: relative;
  }
}
</style>
