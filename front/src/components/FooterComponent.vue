<script setup>
import { Icon } from "@iconify/vue";


</script>

<template>
  <div class="footer">
    <div class="footer1">
      <router-link to="/">
        <img
          class="logo"
          src="../img/Logo.png"
          alt="menu-hub logo"
        >
      </router-link>
      <ul class="social-links">
        <li>
          <a
            class="footer-link"
            href="#"
          ><Icon
            class="social-icon"
            icon="uil:instagram"
          />
          </a>
        </li>
        <li>
          <a
            class="footer-link"
            href="#"
          ><Icon
            class="social-icon"
            icon="uil:facebook-f"
          /></a>
        </li>
        <li>
          <a
            class="footer-link"
            href="#"
          ><Icon
            class="social-icon"
            icon="uil:twitter-alt"
          /></a>
        </li>
      </ul>
      <p class="copyright">
        Copyright &copy; 2022 by MenuHub, Inc. All rights reserved.
      </p>
    </div>
    <div class="footer2">
      <p class="contact-us">
        Contact us
      </p>
      <a
        class="email"
        href="mailto: abc@example.com"
      >menuHub@gmail.com</a>
      <a
        class="tel"
        href="tel: +373 788 699 18"
      >(+373) 788 699 18</a>
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
  justify-content: center;
  width: 0 auto;
  @media screen and (max-width: 544px) {
    display: flex;
    padding: 64px 32px;
    gap: 0px;
  }

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
      @media screen and (max-width: 544px) {
        height: 48px;
      }
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
      color: #767676;
    }
    .copyright {
      margin: 0;
      font-size: 14px;
      line-height: 1.6;
      color: #767676;
      grid-row: 3;
      @media screen and (max-width: 544px) {
        text-align: start;
      }
    }
  }
  .footer2 {
    display: flex;
    flex-direction: column;
    gap: 16px;
    align-items: flex-start;
    @media screen and (max-width: 544px) {
      // align-items: flex-end;
    }
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
  .email {
    text-decoration: none;
    font-size: 16px;
    line-height: 1.6;
    color: #767676;
  }
  .tel {
    text-decoration: none;
    font-size: 16px;
    line-height: 1.6;
    color: #767676;
  }
}
</style>
