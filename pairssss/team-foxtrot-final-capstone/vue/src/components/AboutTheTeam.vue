<template>
  <div class="container">
    <div id="logo-header">
      <h1> About the team</h1>
      <img id="team-logo" src="../assets/color_logo.png" alt="Team logo" />
    </div>
    <div id="people">
      <div id="steph" class="person">
        <div class="words">
          <div class="name-title">
            <h2>Stephanie Navarro</h2>
            <h4>Software Engineer</h4>
          </div>
          <p>
            Before Tech Elevator, she was a manager at a trampoline park. In her free time
            she reads, plays violin and spends time outside. She would
            eventually like to be in a position that uses tech as a tool to help
            people access the resources they need, which was the inspiration for LifeLine.
          </p>
        </div>
        <img src="../assets/Steph1.jpg" alt="Stephanie photo" />
      </div>
      <div id="miranda" class="person">
        <div class="words">
          <div class="name-title">
            <h2>Miranda Kolker</h2>
            <h4>Software Engineer</h4>
          </div>
          <p>
            She graduated from college in 2018 with Russian and Criminal Justice
            degrees, her last job was in IT at Chipotle's restaurant support
            center. Outside of work, she plays D&D and videos games. She is looking for 
            a role which is challenging and fulfilling, in a forward-thinking company.
          </p>
        </div>
        <img src="../assets/miranda-2.jpg" alt="Miranda photo" />
      </div>
      <div id="ersin" class="person">
        <div class="words">
          <div class="name-title">
            <h2>Ersin Değer</h2>
            <h4>Software Engineer</h4>
          </div>
          <p>
            Ersin Deger is a former Assistant Professor of Mathematics turned
            Software Developer. He is dedicated to simplifying complex subjects and to
            present them in the most understandable way. Outside of work, he likes to 
            play the guitar and watch soccer. He is looking to join a team/company with 
            a mission, and be an asset to his future company in the long run.
          </p>
        </div>
        <img src="../assets/ersin-2.jpg" alt="Ersin photo" />
      </div>
      <div id="scott" class="person">
        <div class="words">
          <div class="name-title">
            <h2>Scott Sedor</h2>
            <h4>Scrum Master</h4>
          </div>
          <p>
            Scott was an academic fellow this cohort (just like a real-life
            Clippy 📎). He is a Tech Elevator alum who worked as the insightful inspiration of a scrum master
            for this project. He has a background in construction, and is a native 
            New Yorker. His support through GIFs in homework assignment grades kept 
            many students alive, along with his cat sweaters. Thank you, Scott!
          </p>
        </div>
        <img src="../assets/scott.jpg" alt="Scott photo" />
      </div>
      <div id="steve" class="person">
        <div class="words">
          <div class="name-title">
            <h2>Steve Carmichael</h2>
            <h4>Product Manager</h4>
          </div>
          <p>
            Steve was the amazing and willful Product Manager for this project, in his 15th cohort as
            an instructor. Before that, he worked just over 23'ish years as a
            developer, tech lead, and solutions architect at several places and has
            the gray hairs to prove it. On the side, he coaches at his own sports
            performance company where he privately works with
            athletes to improve their strength, speed and endurance. He also
            works with adult runners in distances from just getting started to
            50-100 mile ultra races and everything in between. Thank you, Steve!
          </p>
        </div>
        <img src="../assets/steve.jpg" alt="Steve photo" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "about-the-team",
};
</script>

<style scoped>
#team-logo {
  height: 650px;
  border: none;
}

img {
  max-height: 400px;
  border: rgb(37, 218, 231) 4px outset;
}

#miranda img, #scott img {
  border: rgb(148,26,242) 4px outset;
}

#logo-header {
  display: flex;
  align-items: center;
  justify-content: center;
}

#logo-header h1 {
  font-size: 80px;
  border-bottom: rgb(148,26,242) 5px solid;
  border-left: rgb(37, 218, 231) 5px solid;
  padding-left: 50px;
  padding-bottom: 20px;
}

#people {
  display: flex;
  flex-direction: column;
  gap: 30px;
}

.person {
  display: flex;
  gap: 35px;
  flex-direction: row-reverse;
  justify-content: flex-end;
  align-items: center;
}

#miranda, #scott {
  flex-direction: row;
}

.name-title {
  display: flex;
  gap: 10px;
  align-items: flex-end;
}

.words {
  width: 500px;
}

p {
  font-size: 20px;
}

.container {
  margin-bottom: 60px;
}
</style>