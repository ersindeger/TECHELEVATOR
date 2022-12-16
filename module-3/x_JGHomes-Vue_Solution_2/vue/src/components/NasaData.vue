<template>
  <div>
      <p>placeholder</p>
      <button v-on:click="getData">Click here to see the picture of the day</button>

      <div>
          <img v-bind:src='info.url'>
      </div>
  </div>
</template>

<script>

import nasaService from '../services/NasaService.js';

export default {

name: 'nasa-data',

data() {
    return {
        info: ''
    }
},
methods: {

  getData() {

      nasaService.getNasaData().then (response => {
          this.info = response.data;
      })
  }
}





}
</script>

<style>

</style>