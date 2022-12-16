<template>
  <div class="modal-backdrop">
    <div class="modal animated zoomIn">
      <header class="modal-header">
        <slot name="header">
          <h2>{{ event.name }}</h2>
        </slot>
        <p>
          {{ event.eventDate }} &nbsp; {{ event.startTime }} -
          {{ event.endTime }}
        </p>

        <button type="button" class="btn-close" @click="close">x</button>
      </header>

      <section class="modal-body">
        <slot name="body">
          <div class="text-speech-address">
            <div class="text-and-speech">
              <h6 id="modal-event">{{ event.description }}</h6>
              <button class="btn btn-primary speak" v-on:click="speakDetails">
                <img
                  src="../assets/speech-icon.png"
                  alt="Text to speech icon"
                />
              </button>
            </div>
            <p>
              {{ event.address.address1 }}, {{ event.address.city }},
              {{ event.address.state }} {{ event.address.zip }}
            </p>
          </div>
          <div class="map-container">
            <map-tile :address="event.address"></map-tile>
          </div>
        </slot>
      </section>

      <footer class="modal-footer">
        <!-- <slot name="footer"> -->
        <div class="host-nameAndlogo">
          <h4>{{ event.host }}</h4>
          <img
            class="modal-hostImg"
            v-bind:src="event.hostImg"
            alt="Card image cap"
          />
        </div>
        <p class="footer-description">{{ event.host_description }}</p>
        <!-- </slot> -->
      </footer>

      <footer class="modal-close-button">
        <button type="button" class="btn-purple" @click="close">
          Close Event Details
        </button>
      </footer>
    </div>
  </div>
</template>

<script>
import MapTile from "./Map.vue";

export default {
  name: "event-modal",
  props: ["event"],
  methods: {
    close() {
      this.$emit("close");
    },
    speakDetails() {
      let message = document.querySelector("#modal-event").innerText;
      let utterance = new SpeechSynthesisUtterance();
      // let voices = utterance.getVoices();
      // utterance.voice = voices[2];
      utterance.rate = 1.5;

      utterance.text = message;
      speechSynthesis.speak(utterance);
    },
  },
  components: {
    MapTile,
  },
};
</script>

<style scoped>
/* .footer-description{
    display: flex;
    flex-grow: center;
  } */

img {
  width: 45px;
}

.speak {
  width: 70px;
  justify-content: flex-start;
  align-items: flex-start;
  background-color: white;
  border: #89c8d8 solid 2px;
}

.text-and-speech {
    display: flex;
    align-items: flex-start;
}

.speak:hover {
  background-color: white;
  border: #89c8d8 solid 2px;
}

.modal-hostImg {
  width: 90px;
  height: 80px;
  align-items: center;
  margin: 25px;
  padding: 0%;
}

.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.233);
  display: flex;
  justify-content: center;
  align-items: center;
  opacity: 0.97;
}

.modal {
  opacity: 0.95;
  width: 740px;
  height: 750px;
  background: #ffffff;
  box-shadow: 2px 2px 20px 1px;
  overflow-x: auto;
  display: flex;
  flex-direction: column;
  position: absolute;
  bottom: 3%;
  left: 28%;
  top: 1%;
  overflow: hidden;
  border-radius: 10px;
}

.modal-header {
  display: flex;
  flex-wrap: nowrap;
  flex-direction: row;
  padding: 20px 20px 0px;
  position: relative;
  border-bottom: 4px solid #eeeeee;
  justify-content: space-between;
  background-color: #daffef;
  color: #4aae9b;
}

.host-nameAndlogo {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.map-container {
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  padding: 5px 5px 0px;
  position: relative;
  /* border: 4px 4px 4px 4px; */
  justify-content: space-between;
}

.modal-footer {
  display: flex;
  border-top: 1px solid #eeeeee;
  flex-direction: row;
  justify-content: space-evenly;
  flex-wrap: nowrap;
  padding: 5px 25px 5px;
  position: relative;
  border-bottom: 1px solid #eeeeee;
  background-color: #9d75cb;
  border-radius: 0px;
  padding: 5px 5px 5px 5px;
}

.modal-close-button {
  padding: 5px;
  display: flex;
  border-top: 1px solid #eeeeee;
  justify-content: center;
  flex-wrap: nowrap;
  padding: 5px 25px 0px;
  margin: 10px;
  position: relative;
  border-bottom: 1px solid #eeeeee;
}

.modal-body {
  position: relative;
  /* padding-top: 10px; */
  padding: 8% 5% 5% 5%;
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 350px;
  width: auto;
}

.btn-close {
  position: absolute;
  justify-content: center;
  align-items: center;
  top: 0;
  right: 0;
  border: none;
  font-size: 20px;
  padding: 10px;
  cursor: pointer;
  font-weight: bold;
  color: #9d75cb;
  background: transparent;
}

.btn-purple {
  color: white;
  background: #9d75cb;
  border: 1px solid #9d75cb;
  border-radius: 2px;
}
.modal-img {
  width: auto;
  height: 380px;
  align-items: center;
  margin: 15px;
  padding: 2%;
}

#modal-event {
  margin-top: -30px;
}

.zoomIn {
  animation-duration: 0.5s;
}

.modal-footer h4,
.modal-footer p {
  color: white;
}
</style>