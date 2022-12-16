<template>
  <div class="event container">

    <div class="card" style="width: 25rem">
      <img class="card-img-top" v-bind:src="event.img" alt="Card image cap" />
      <div class="card-body">
        <h4 class="event-title">{{ event.name }}</h4>
        <h5 class="event-host">{{ event.host }}</h5>
        <div class="date-time">
          <p>{{ event.eventDate }}</p>
          <p class="date-time-">{{ event.startTime }} - {{ event.endTime }}</p>
        </div>
        <p class="card-text">{{ event.shortDescription }}</p>
        <button class="btn btn-primary" @click="$emit('show-details')">
          See More
        </button>
      </div>
    </div>
    <div class="title"></div>
  </div>
</template>

<script>
export default {
  name: "home-event-card",
  props: ["event"],
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
  margin-bottom: 20%;
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

.btn {
  /* background: linear-gradient(to right, #ff9dd3, #ffca91); */
  border-color: #9d75cb;
  border-style: solid;
  border-width: 2px;
  font-weight: bold;
  color: gray;
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


</style>