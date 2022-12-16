<template>
  <div id="host-list">
    <header>
      <h1>Overview | Manage Your Organization's Upcoming Events</h1>
      <h5>Here you can see your next 5 events. You can add, edit, and delete events. Click "View All" to view a list of all of your organization's past and upcoming events.</h5>
    </header>
    <section id="events">
      <div class="new-event">
      <button class="btn btn-secondary" @click="openAddEvent">Add Event <br>+
        
      </button>
      <new-event-modal v-if="showAddEvent" @close="closeAddEvent" @reload="reloadFirstFive">
        </new-event-modal>
        <edit-event-modal :event="event" v-if="showEditEvent" @close="closeEditEvent"  @reload="reloadFirstFive"></edit-event-modal>
    </div>
      <event-card  
        v-bind:event="event"
        v-for="event in firstFive"
        v-bind:key="event.eventId"
        @show-details="openEditEvent(event)"
        v-model="hostId"
      />
      <button class="btn btn-info" @click.prevent="$router.push({name: 'hostAll'})">View All</button>
    </section>
    
    
  </div>
</template>

<script>
import hostService from "../services/HostService.js";
import EventCard from "./EventCard.vue";
import NewEventModal from "./NewEventModal.vue";
import EditEventModal from "./EditEventModal.vue"

export default {
  name: "host-event-list",
  data() {
    return {
      events: [],
      hostId: this.$store.state.userHostId,
      hostName: "",
      showAddEvent: false,
      showEditEvent: false,
      event: []
    };
  },
  methods: {
    openAddEvent() {
      document.body.classList.add("modal-open");
      document.body.style.overflow = "hidden";
      this.showAddEvent = true;
    },
    closeAddEvent() {
      document.body.classList.remove("modal-open");
      document.body.style.overflow = "auto";
      this.showAddEvent = false;
      this.reloadFirstFive();
    },
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
    reloadFirstFive() {
      window.setTimeout(()=> {
       hostService.listHostEvents(this.hostId).then((response) => {
         console.log("reached call hostservice in reloadfirstfive");
      this.events = response.data;},4000);
    });
    },
  },

  computed: {
    firstFive() {
      console.log("reached firstfive computed property")
      const events = this.events;
      const upcomingEvents = events.filter((event) => {
        return event.eventDate >= new Date().toLocaleDateString();
      })
      const firstFiveEvents = upcomingEvents.slice(0, 5);
      console.log(firstFiveEvents)
      return firstFiveEvents;
    },
  },
  components: {
    EventCard,
    NewEventModal,
    EditEventModal
  },
  created() {
    hostService.listHostEvents(this.hostId).then((response) => {
      this.events = response.data;
    });
  },
};
</script>

<style scoped>

header {
  margin: 30px;
  display: flex;
  flex-direction: column;
  gap: 30px;
}
#host-list {
  margin-left: 20vw;
}

h5 {
  width: 600px;
}

#events {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  row-gap: 30px;;
}

.modal-open {
  overflow: hidden;
  position: fixed;
}

#new-event {
  border: black 3px solid;
  
}

.btn-info {
  width: 60px;
  height: 90px;
  margin-top: 360px;
  border-radius: 2px;
  background-color: #ba9bdf;
  border: #003049 1px solid;
  font-weight: bold;
  margin-right: 20px
}

.btn-info:hover {
  background-color: #003049;
  color: white;
  border: none;
}

.btn-secondary {
  background-color: white;
  color: black;
  border: 2px solid #72f8c7;
  height: 280px;
  width: 250px;
  margin: 30px;
  margin-top: 120px;
  font-size: 28px;
}

  .btn-secondary:hover {
    background-color: #b1ffe2;
    color: black;
    font-weight: bold;
    border: none;
  }
</style>