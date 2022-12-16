<template>
  <div class="container">

      <h2> Welcome, {{ this.$store.state.host.name }} </h2>
      <img id="logo" src="../assets/color_logo.png" alt="" />

  </div>
</template>

<script>
export default {
    name: "admin-header"

}
</script>

<style scoped>

.container {
    margin-left: 21vw;
    width: 76vw;
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
}

.container img {
    height: 120px;
}
</style>