<template>
<host-event-list></host-event-list>

</template>

<script>
import HostEventList from '../components/HostEventList.vue'
import hostService from "../services/HostService"

export default {
  name: 'host',
  components: { HostEventList
  },
  data() {
    return {
      showEditEvent: false,
    }
  },
  created() {

    hostService.retrieveHostInfo(this.$store.state.userHostId)
    .then(response => {
      const host = {
        name: response.data.host_name,
        desc: response.data.host_description,
        img: response.data.host_img
      }
      this.$store.commit("SET_USER_HOST_INFO", host);          
    }) .catch(error => {
      console.log(error)
    }) 
  }
}
</script>

<style>

</style>