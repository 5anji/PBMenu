<template>
  <div class="footer">
    <div class="footer1">
      <router-link to="/">
        <img class="logo" src="../img/Logo.png" alt="menu-hub logo" />
      </router-link>
      <ul class="social-links">
        <li>
          <a class="footer-link" href="#"
            ><img class="social-icon" src="../img/instagram-logo.png" />
          </a>
        </li>
        <li>
          <a class="footer-link" href="#"
            ><img class="social-icon" src="../img/facebook-logo.png"
          /></a>
        </li>
        <li>
          <a class="footer-link" href="#"
            ><img class="social-icon" src="../img/twitter-logo.png"
          /></a>
        </li>
      </ul>
      <p class="copyright">
        Copyright &copy; 2022 by Omnifood, Inc. All rights reserved.
      </p>
    </div>
    <div class="footer2">
      <p class="contact-us">Contact us</p>
      <p>menuHub@gmail.com</p>
      <p>(+373) 788 699 18</p>
    </div>
  </div>
</template>

<style scoped lang="scss">
.footer {
  padding: 100px 100px;
  border-top: 1px solid #ddd;
  color: #888;
  text-align: center;
  bottom: 0;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 100px;

  .footer1 {
    display: flex;
    flex-direction: column;
    gap: 16px;
    align-items: flex-start;
    .logo {
      margin: 0;
      width: auto;
      height: 52px;
      max-height: 100%;
    }
    .social-links {
      padding: 0;
      margin: 0;
      list-style: none;
      display: flex;
      gap: 24px;
    }

    .social-icon {
      height: 24px;
      width: 24px;
    }
    .copyright {
      margin: 0;
      font-size: 14px;
      line-height: 1.6;
      color: #767676;
      grid-row: 3;
    }
  }
  .footer2 {
    display: flex;
    flex-direction: column;
    gap: 16px;
    align-items: flex-start;
  }
  p {
    margin: 0;
    padding: 0;
  }
  .contact-us {
    margin-bottom: 32px;
    font-weight: 700;
    font-size: 18px;
  }
}
</style>
