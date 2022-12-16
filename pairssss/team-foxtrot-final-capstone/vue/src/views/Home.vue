<template>
  <div class="home">
    <div class="parent">
      <div class="img">
        <img src="../assets/kiosk_homepage2.png" />
      </div>
      <div class="text">
        <div class="text-button">
          <div class="main-text">
            <h1 class="software-t-s">SOFTWARE THAT SERVES...</h1>

            <div>
              <h4>
                <p class="vision-p">People.</p>
                <p class="vision-p">Communities.</p>
                <p class="vision-p">Organizations.</p>
              </h4>
            </div>
          </div>
          <div class="cta">
            <button
              class="btn btn-info"
              @click.prevent="$router.push({ name: 'demo' })"
            >
              <div class="btn-txt">
                <p class="vision-s">
                  We are committed to connecting people to resources.
                </p>
                <div class="try-arrow">
                <p class="button-try">TRY IT NOW →</p>
               </div>
              </div>
            </button>
          </div>
        </div>
      </div>
    </div>

    <div></div>
    &nbsp;
    <h3>&nbsp; &nbsp; Featured Events:</h3>
    <home-event-list> </home-event-list>
  </div>
</template>

<script>
import HomeEventList from "../components/HomeEventList.vue";
// import HomeService from "../services/HomeService"

export default {
  name: "home",
  components: {
    HomeEventList,
  },
};
</script>


<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Lexend:wght@200&family=Unbounded:wght@300;400;500;900&display=swap");

.kiosk {
  width: 99vw;
  opacity: 0.9;
}

.text-button {
  display: flex;
  justify-content: space-between;
  width: 90vw;
}

.button-p {
  margin-top: -60px;
  font-size: 120px;
}

.cta {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
  margin-right: 2%;
}

img {
  display: flex;
  margin-left: 4%;
  justify-content: center;
  height: auto;
  width: auto;
  width: 90vw;
  max-height: 90vh;
  filter: brightness(115%) saturate(120%);
}
.software-t-s {
  padding: 10px 10px 10px 10px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  font-size: 60px;
}

.btn-txt {
  /* display: flex; */
  align-content: center;
  justify-content: center;
}

.button-try {
  margin-left: 15px;
  font-size: 25px;
  color: white;
}

.vision-p {
  font-size: 35px;
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
  margin-left: 3%;
  align-items: flex-start;
}

.vision-s {
  font-size: 20px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: flex-start;
}

.vision {
  padding: 10px 10px 10px 10px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  font-size: 40px;
  width: 30vw;
}
.btn-info {
  background-color: rgb(38,242,255);
  border: rgb(38,242,255) 1px outset;
  font-size: 50px;
  margin-right: 2%;
  margin-top:40%;
  width: 30vw;
  height: 30vh;
  margin-right: 10%;
}
.cta :hover {
  background-color: rgb(38, 231, 245);
}

.home {
  display: flex;
  flex-direction: column;
  padding-left: 10px;
}

.text {
  position: relative;
  /* padding-top: 10px; */
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  justify-content: center;
  padding: 5px 5px 5px 5px;
  width: 90vw;
  font-family: "Unbounded";
}

* {
  box-sizing: border-box;
  width: 100%;
}
.parent {
  position: relative;
  /* max-width: 800px; */
  margin: 0 auto;
  display: flex;
  flex-direction: row;
}
.parent img {
  vertical-align: center;
  opacity: 0.9;
}
.parent .text {
  position: absolute;
  display: flex;
  top: 0;
  margin-left: 4%;
  /* background: rgb(0, 0, 0); /* Fallback color */
  /* background: rgba(0, 0, 0, 0.1); Black background with opacity */
  /* color: #ffffff; */
  /* width: 90vw; */
  /* padding: 20px; */
  /* align-items: center; */
}
</style>

