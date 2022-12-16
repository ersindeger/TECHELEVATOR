<template>
  <div id="app">

    <router-link v-bind:to="{name: 'bestsellers'}"> Best Sellers </router-link> ||
    <router-link v-bind:to="{name: 'newreleases'}"> New Releases </router-link> ||
    <router-link v-bind:to="{name: 'readinglist'}"> Reading List </router-link> ||
    <router-link v-bind:to="{name: 'newbookform'}"> New Book Form </router-link> ||
    

    <router-view />
  </div>
</template>

<script>

export default {
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>
