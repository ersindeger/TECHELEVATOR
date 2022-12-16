<template>
  <div id="header">
    <nav class="navbar-brand logo-head">
      <router-link v-bind:to="{ name: 'home' }"><img id="logo" src="../assets/white_logo.jpg" alt="" /></router-link>
       <router-link v-bind:to="{ name: 'home' }"><h1 id="#pageTitle">{{ pageTitle }}</h1></router-link>
    </nav>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'about' }">About</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'demo' }">Demo</router-link>&nbsp;&nbsp;
      <router-link id="host-login" v-bind:to="{ name: 'login' }"
        ><button class="btn btn-primary">Host Login</button></router-link
      > &nbsp;&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "the-header",
  data() {
    return {
      pageTitle: "LIFELINE",
    };
  },
};
</script>

<style scoped>
#header {
  display: flex;
  align-items: center;
  gap: 10%;
  justify-content: space-between;
  height: 100px;
  margin-bottom: 2.5%;
  border-bottom: rgb(148,26,242) 1px solid;
  padding-left: 10px;

}

h1 {
background: -webkit-linear-gradient(rgb(37, 218, 231), rgb(148,26,242));
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  }

#logo {
  height: auto;
  height: 95px;
  margin-right: 2%;
}

.logo-head {
  display: flex;
  align-items: center;
}

#host-login {
  font-size: 80%;
}

.btn {
    background-color: #3bf9e7;
    border-radius: 3px;
    color: black;
    border: solid 2px #6AFDC8;
}

a {
  text-decoration: none;
  color: black;
}

#nav {
  font-size: 150% !important;
}
a:hover {
  color: rgb(148,26,242);
  font-weight: bold;
}
</style>