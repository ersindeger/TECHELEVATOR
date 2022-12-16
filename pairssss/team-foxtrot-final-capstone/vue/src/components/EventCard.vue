<template>
  <div class="event container">
    <!-- <img id="event-img" v-bind:src= event.img alt=""> -->
    <!-- <button class="btn btn-primary speak" v-on:click="speakCard">Speak</button> -->

    <div class="card" style="width: 25rem">
      <img class="card-img-top" v-bind:src="event.img" alt="Card image cap" />
      <div class="card-body">
        <h4 class="event-title">{{ event.name }}</h4>
        <h5 class="event-host">{{ event.host }}</h5>
        <div class="date-time">
          
          <p class="date-time-start">
            {{ event.eventDate }} &nbsp; {{ event.startTime }} - {{ event.endTime }}
          </p>
        </div>
        <p class="card-text">{{ event.shortDescription }}</p>
        <div id="buttons">
          <button
            class="btn btn-primary"
            @click="$emit('show-details')"
            v-if="$store.state.token == ''"
          >
            See More
          </button>
          <button
            class="btn btn-primary"
            @click="$emit('show-details')"
            v-if="$store.state.token != ''"
          >
            Edit Details
          </button>
          <button
            class="btn btn-danger"
            v-if="$store.state.token != ''"
            @click.prevent="deleteEvent"
          >
            🗑 Delete
          </button>
        </div>
      </div>
    </div>
    <div class="title"></div>
  </div>
</template>

<script>
import HostService from "../services/HostService";
export default {
  name: "event-card",
  props: ["event"],
  methods: {
    deleteEvent() {
      if (confirm("Delete this event?")) {
        console.log(this.event);
        HostService.deleteEvent(this.event.eventId)
          .then((response) => {
            if (response.status === 204) {
              window.alert("Event has been deleted.");
              this.$emit = "reload";
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
     speakCard() {
      // let eventTitle = 
      let message = document.querySelector(".card").innerText;
      let utterance = new SpeechSynthesisUtterance();
      console.log(message)
      utterance.text = message;
      speechSynthesis.speak(utterance);
    },
  },
  
};
</script>

<style scoped>
.event {
  display: flex;
  border-radius: 10px;
  width: 420px;
  max-height: 300px;
  min-height: 100px;
  flex-direction: column;
  margin-bottom: 18%;
  transition: transform 250ms;
  }

.event:hover {
  transform: scale(1.1);
  box-shadow: 1;
}


.card-img-top {
  width: 100%;
  height: 15vw;
  object-fit: cover;
}

#event-img {
  display: flex;
}
.event-title {
  max-height: 20%;
}

.container {
  position: relative;
  text-align: center;
  color: white;
}

.btn-danger {
  background-color: white;
  border: #df3b57 1px solid;
  color: rgb(37, 37, 37);
  font-weight: bold;
}

.btn-danger:hover {
  background-color: #df3b57;
}

.btn-primary {
  background: #ba9bdf;
  border: none;
  font-weight: bold;
  color: white;
}
.btn-primary:hover {
  background-color: #003049;
  color: white;
}

#buttons {
  display: flex;
  justify-content: center;
  gap: 10px;
}
</style>