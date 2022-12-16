<template>
    <div>
  <div id="sidebar-container" class="px-3 py-2" v-if="showNav">
      <div id="header-container">
        <div class="navbar-brand logo-head">
            <!-- <button @click.prevent="showNav = !showNav"><img id="hmbrg-icon" src="../assets/menu-icon.png" /></button> -->
        <div class="logo-header">
        <!--  -->
        <div class="logo-text">
            <h1 id="#pageTitle">{{ pageTitle }}</h1>
            <h3>Admin Portal</h3>
        </div></div>
      </div>
        </div>
      <div class="nav-container">
      <div class="current-user">
          <img id="user-img" src="../assets/umc_logo.png" alt="" />
      <h3>{{ userName }}</h3>
      </div>
      <nav>
      <router-link v-bind:to="{ name: 'host' }">Admin Portal Overview</router-link>
      <router-link v-bind:to="{ name: 'hostAll' }">View all of your organization's events</router-link>
      <!-- <a href='#'>View all future events</a> -->
      <!-- <a href='#'>View all past events</a> -->
    
      </nav>
    <div class="settings-logout">
        <a href='#'>⚙ Settings</a>
    <router-link id="host-logout"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        ><button class="btn btn-primary">Logout</button></router-link
      >
      </div>
      </div>
  </div>
    </div>
</template>
 
<script>
export default {
    name: 'admin-sidebar',
    data() {
        return {
            pageTitle: 'LIFELINE',
            userName: this.$store.state.user.username,
            showNav: true
        }
    },
}
</script>
 
<style scoped>
 
    #sidebar-container {
        background-color: #2f0053;
        width: 20vw;
        max-width: 100vw;
        color: white;
        height: 100vh;
        top: 0;
        position: fixed;
        z-index: 1;
    }
 
    .logo-header {
        display:flex;
        align-items: flex-start;
        gap: 20px;
    }
 
    #hmbrg-icon {
        height: 30px;
    }
 
    .navbar-brand {
        display: flex;
        justify-content: flex-start;
        align-items: center;
        color: white;
        position: fixed;
        top:1vh;
        left:2vw;
        gap: 40px;
        z-index: 2;
        margin-left: 2;
    }
 
    .full-width {
        width: 100vw;
    }
 
    .nav-container {
 
        padding-top: 18vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 5vh;
    }

    h1 {
        font-size: 55px;
    }

    h3 {
        font-size: 32px;
    }
 
    a {
        font-size: 20px;
        text-align: left;
    }
 
    * {
        color:white;
        text-decoration: none;
    }
 
    a:hover {
        color: #DAFFEF;
    }
 
    .btn:hover {
        background-color: #34846F;
    }
 
    .nav-container h3 {
        font-size: 30px;
    }
 
    nav {
        display: flex;
        flex-direction: column;
        gap: 30px;
        align-items: flex-start;
    }
 
    .settings-logout {
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 30px;
    }
 
    .settings-logout a {
        font-size: 22px
    }
 
    .btn {
        background-color: #DAFFEF;
        border-radius: 3px;
        color: black;
        border: none;
        font-size: 25px;
    }
 
    .current-user {
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 30px;
    }
 
    #user-img {
        border-radius: 50%;
        height: 90px;
    }
 
</style>