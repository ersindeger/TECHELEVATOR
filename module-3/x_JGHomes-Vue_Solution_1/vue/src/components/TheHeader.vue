<template>
  <div>
      <img id="logo" src="../assets/java-green.png" alt="">
      <!-- <h1>{{pageTitle}}</h1> -->
      <nav>
           <router-link v-bind:to="{name: 'home'}">Home</router-link>
          <a href="#">About</a>
          <router-link v-bind:to="{name: 'search'}">Search</router-link>
      </nav>
  </div>
</template>

<script>
export default {

    name: 'the-header',
    // data() {
    //     return {
    //         pageTitle: 'Java Green Real Estate'
    //     };
    // }

}
</script>

<style scoped>

#logo {
    width: 15%;
    height: auto;
    display: block;
    margin-left:auto;
    margin-right: auto;
    margin-bottom: 20px;
}

nav {
    display: flex;
    justify-content: center;
}

nav a {
    padding: 15px 25px;
    background-color: #16b065;
    color: black;
}

nav a:hover {
    background-color: #56e38b;
    color: white;
}


</style>