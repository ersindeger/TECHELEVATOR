<template>
  <div id="host-list-all">
      <header>
          <h1>View All of Your Organization's Upcoming and Past Events</h1>
          <h4>Click the headers to collapse or reveal each section.</h4>
      </header>
    <section id="both-lists-container">
      <section class="list">
          <button class="btn btn-primary" @click="showUpEvents = !showUpEvents">Upcoming events <img v-show="!showUpEvents" class="arrow" src="../assets/arrow_right.png" /><img v-show="showUpEvents" class="arrow" src="../assets/arrow_down.png" /></button>
          <div class="events" v-show="showUpEvents"><event-card
        v-bind:event="event"
        v-for="event in upcomingEvents"
        v-bind:key="event.eventId"
        @show-details="openEditEvent(event)"
      /></div>
      </section>
      
      <edit-event-modal :event="event" v-if="showEditEvent" @close="closeEditEvent"  @reload="reloadFirstFive"></edit-event-modal>

      <section class="list">
          <button class="btn btn-primary" @click="showPrevEvents = !showPrevEvents">Previous events <img v-show="!showPrevEvents" class="arrow" src="../assets/arrow_right.png" /><img v-show="showPrevEvents" class="arrow" src="../assets/arrow_down.png" /></button>
          <div class="events" v-show="showPrevEvents"><event-card
        v-bind:event="event"
        v-for="event in previousEvents"
        v-bind:key="event.eventId"
        @show-details="onSeeMore(event)"
      /></div>
      </section>
    </section>
  </div>
</template>

<script>
import hostService from "../services/HostService"
import EventCard from "../components/EventCard.vue"
import EditEventModal from "./EditEventModal.vue"
export default {
    data() {
        return {
            previousEvents: [],
            upcomingEvents: [],
            hostId: this.$store.state.userHostId,
            showUpEvents: true,
            showPrevEvents: false,
            showEditEvent: false,
        }
    },
    components: {
        EventCard,
        EditEventModal
    },
    name: 'host-view-all',
    created() {
        hostService.listHostEvents(this.hostId).then((response) => {
            const events = response.data;
            this.previousEvents = events.filter(event => {
                return event.eventDate < new Date().toLocaleDateString();
            });
            this.upcomingEvents = events.filter(event => {
                return event.eventDate >= new Date().toLocaleDateString();
            });
    });
  },
  methods: {
    openEditEvent(event) {
      this.event = event;
      document.body.classList.add("modal-open");
      document.body.style.overflow = "hidden";
      this.showEditEvent = true;
    },
    closeEditEvent() {
      this.event = [];
      document.body.classList.remove("modal-open");
      document.body.style.overflow = "auto";
      this.showEditEvent = false;
      this.reloadFirstFive();
    },
    reloadEvents() {

      window.setTimeout(()=> {
       hostService.listHostEvents(this.hostId).then((response) => {
            const events = response.data;
            this.previousEvents = events.filter(event => {
                return event.eventDate < new Date().toLocaleDateString();
            });
            this.upcomingEvents = events.filter(event => {
                return event.eventDate >= new Date().toLocaleDateString();
            });},4000);
    });
    },
  }
}
</script>

<style scoped>
header {
  margin: 30px;
  display: flex;
  flex-direction: column;
  gap: 30px;
}

#host-list-all {
  margin-left: 20vw;
  margin-bottom: 65px;
  margin-right: 2vw;
}

#both-lists-container {
    margin-left: 30px;
    display: flex;
    flex-direction: column;
    gap: 15px;
}

.list{
    display: flex;
    flex-direction: column;
    gap: 10px;
}

.events {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
  row-gap: 30px;
}

.btn-primary {
  background-color: #e68897;
  border: #ffbbc6 2px outset;
  font-size: 20px;
}

.btn-primary:hover {
  border: #e77e90 2px outset;
  background-color: white;
  color: black
}

button img {
  height: 20px;
  filter: invert();
}

button:hover img {
  filter: none;
}
</style>