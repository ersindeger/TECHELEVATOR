<template>
  <div>
    <section id="homeEvents">
      <home-event-card
      v-bind:event="event"
        v-for="event in events"
        v-bind:key="event.eventId"
      > 
      </home-event-card>
      </section>
  </div>
</template>

<script>
import homeService from "../services/HomeService.js";
import HomeEventCard from "./HomeEventCard.vue";

export default {
  name: "home-event-list",
  data() {
    return {
      events: [],
      resource_type: "",
      // zip_code: "",
      resource_types: this.$store.state.resource_types,
      modal_event: null,
      showFilter: false,
      active: false,
      hideFilter: true,
    };
  },
  components: {
    HomeEventCard
  },
  created() {
    homeService.getEvents().then((response) => {
      this.events = response.data;
      const shuffled = this.events.sort(() => 0.75 - Math.random());
      this.events = shuffled.slice(0,3);
      this.events = this.events.timeSort();
    });
  },
  computed: {
    filteredEventList() {
      const sorted = this.events
      const dateSort = sorted.sort((a,b) =>  {    
        return new Date(a.eventDate) - new Date(b.eventDate)
      })
       const timeSort = dateSort.sort( (a,b) => {
        return new Date(a.startTime) - new Date(b.startTime)
      })
      return timeSort.filter((event) => {
        if (this.resource_type == "") {
          if (this.zip_code == "") {
            return true;
          }
          return this.zip_code == event.address.zip;
        } else if (this.zip_code == "") {
          return this.resource_type == event.resourceName;
        }
        return (
          this.resource_type == event.resourceName &&
          this.zip_code == event.address.zip
        );
      });
    },
  },

};
</script>

<style scoped>
#homeEvents{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

</style>