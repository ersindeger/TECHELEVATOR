<template>
  <div>
      <img id="logo" src="../assets/java-green.png" alt="">
      <!-- <h1>{{pageTitle}}</h1> -->
      <nav>
           <router-link v-bind:to="{name: 'home'}">Home</router-link>
          <a href="#">About</a>
          <router-link v-bind:to="{name: 'search'}">Search</router-link>
          <router-link v-bind:to="{name: 'addAHome'}">Add Home</router-link>
           <router-link v-bind:to="{name: 'weather'}">Get Weather Report</router-link>
            <router-link v-bind:to="{name: 'nasa'}">Get Picture Of The Data</router-link>
            <router-link v-bind:to="{name: 'login'}" v-show="$store.state.token == ''">Login</router-link>
             <router-link v-bind:to="{name: 'logout'}" v-show="$store.state.token != ''">Logout</router-link>
      </nav>

    <p v-show="$store.state.token != ''">Welcome {{$store.state.user}}</p>


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