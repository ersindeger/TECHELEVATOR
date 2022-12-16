<template>
<div class="row map">
  <l-map v-if="!isLoading" :zoom="zoom" :center="center">
      <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
  
    <l-marker :lat-lng="marker"></l-marker>
  </l-map>
</div>
</template>

<script>
import L from 'leaflet';
import {LMap, LTileLayer, LMarker} from 'vue2-leaflet';
import mapService from '../services/MapService.js'
import { Icon } from 'leaflet';

delete Icon.Default.prototype._getIconUrl;
Icon.Default.mergeOptions({
  iconRetinaUrl: require('leaflet/dist/images/marker-icon-2x.png'),
  iconUrl: require('leaflet/dist/images/marker-icon.png'),
  shadowUrl: require('leaflet/dist/images/marker-shadow.png'),
});

export default {
  name: "map-tile",
  components: {
    LMap,
    LTileLayer,
    LMarker,
  },
  props: ['address'],
  data () {
    return {
      zoom: 80,
      center: {},
      url: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
      attribution:
        '&copy; <a target="_blank" href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      marker: {},
      isLoading: true,
    };
  },
  created() {
    mapService.getCoordinates(this.address.address1 + " " + this.address.address2 + ", " + this.address.city + ", " + this.address.state + " " + this.address.zip)
    .then (response => {
      this.center = L.latLng(response.data[0].lat, response.data[0].lon);
      this.marker = L.latLng(response.data[0].lat, response.data[0].lon);
      this.isLoading = false;

    })
    .catch ( error => {
      console.log(error.response.status)
    })
    
  }
}
</script>

<style scoped>
    .map {
        height: 12em;
        width: 34em;
    }
</style>