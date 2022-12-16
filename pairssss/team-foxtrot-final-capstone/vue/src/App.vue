<template>
  <div id="app">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Lexend:wght@200&display=swap"
      rel="stylesheet"
    />

    <admin-sidebar v-if="$store.state.token != ''"> <burger/> </admin-sidebar>
    <the-header v-if="$store.state.token == ''" />
    <admin-header v-if="$store.state.token != ''" />
    <router-view />
    <the-footer v-if="$store.state.token == ''" />
    <vue-speech />
  </div>
</template>

<script>
import TheHeader from "./components/TheHeader.vue";
import TheFooter from "./components/TheFooter.vue";
import AdminSidebar from "./components/AdminSideBar.vue"
import Burger from "./components/Burger.vue"
import AdminHeader from "./components/AdminHeader.vue"
import Vue from 'vue';
import VueI18n from 'vue-i18n';
import VueSpeech from './components/VueSpeechSynthesis.vue'

  Vue.use(VueI18n);

  const i18n = new VueI18n({
      locale: "en",
  });

  export const languages = {
      "en": "English",
      "fr": "Français"
  }

 

export default {
  i18n,
  VueSpeech,
  name: "App",
  data() {
    return {
      defaultLanguage: "en"
    }
  },
  
  components: {
    TheHeader,
    TheFooter,
    AdminSidebar,
    Burger,
    AdminHeader,
    VueSpeech
  },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lexend:wght@200&family=Unbounded:wght@300;400;500;900&display=swap');
#app {
  font-family: "Lexend", sans-serif;
}

* {
  text-decoration: none;
  color: black;
}


</style>