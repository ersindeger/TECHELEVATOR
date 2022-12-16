<template>
  <div class="modal-backdrop">
    <div class="modal right">
      <header class="modal-header"><h2>Add a new event</h2></header>

      <form v-on:submit="addEvent" @submit="$emit('close'), $emit('reload')">
        <label for="hostName">Organization: </label>
        <input
          name="hostName"
          class="form-control"
          type="text"
          id = "hostName"
          placeholder="United Methodist Church"
          readonly
        />
        <input
          type="text"
          class="form-control"
          placeholder="Event Name"
          v-model="newEvent.name"
          required
        />

        <input
          placeholder="Event Date"
          class="form-control"
          type="text"
          onfocus="(this.type='date')"
          onblur="(this.type='text')"
          id="date"
          v-model="newEvent.eventDate"
        />
        <div class="input-group mb-3" id="time-container">
          <input
            onfocus="(this.type='time')"
            onblur="(this.type='text')"
            name="startTime"
            type="text"
            class="form-control input-group-text"
            placeholder="Event Start Time"
            v-model="newEvent.startTime"
            required
          />
          <input
            onfocus="(this.type='time')"
            onblur="(this.type='text')"
            name="endTime"
            type="text"
            class="form-control input-group-text"
            placeholder="Event End Time"
            v-model="newEvent.endTime"
            required
          />
        </div>
        <textarea
          id="description"
          type="textarea"
          class="form-control"
          placeholder="Event Description"
          v-model="newEvent.description"
          required
          wrap = "hard"
        />

        <div class="row">
          <div class="col-md-6 mb-4">
            <div class="form-outline">
              <input
                type="text"
                class="form-control form-control-lg"
                placeholder="Address Line 1"
                v-model="newEvent.address.address1"
                required
              />
            </div>
          </div>
          <div class="col-md-6 mb-4">
            <div class="form-outline">
              <input
                type="text"
                class="form-control form-control-lg"
                placeholder="Address Line 2"
                v-model="newEvent.address.address2"
              />
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-3 mb-3">
            <select
              class="select form-control"
              v-model="newEvent.address.state"
              required
            >
              <option value="">State</option>
              <option value="AL">AL</option>
              <option value="AK">AK</option>
              <option value="AR">AR</option>
              <option value="AZ">AZ</option>
              <option value="CA">CA</option>
              <option value="CO">CO</option>
              <option value="CT">CT</option>
              <option value="DC">DC</option>
              <option value="DE">DE</option>
              <option value="FL">FL</option>
              <option value="GA">GA</option>
              <option value="HI">HI</option>
              <option value="IA">IA</option>
              <option value="ID">ID</option>
              <option value="IL">IL</option>
              <option value="IN">IN</option>
              <option value="KS">KS</option>
              <option value="KY">KY</option>
              <option value="LA">LA</option>
              <option value="MA">MA</option>
              <option value="MD">MD</option>
              <option value="ME">ME</option>
              <option value="MI">MI</option>
              <option value="MN">MN</option>
              <option value="MO">MO</option>
              <option value="MS">MS</option>
              <option value="MT">MT</option>
              <option value="NC">NC</option>
              <option value="NE">NE</option>
              <option value="NH">NH</option>
              <option value="NJ">NJ</option>
              <option value="NM">NM</option>
              <option value="NV">NV</option>
              <option value="NY">NY</option>
              <option value="ND">ND</option>
              <option value="OH">OH</option>
              <option value="OK">OK</option>
              <option value="OR">OR</option>
              <option value="PA">PA</option>
              <option value="RI">RI</option>
              <option value="SC">SC</option>
              <option value="SD">SD</option>
              <option value="TN">TN</option>
              <option value="TX">TX</option>
              <option value="UT">UT</option>
              <option value="VT">VT</option>
              <option value="VA">VA</option>
              <option value="WA">WA</option>
              <option value="WI">WI</option>
              <option value="WV">WV</option>
              <option value="WY">WY</option>
            </select>
          </div>
          <div class="col-md-3 mb-3">
            <select class="select form-control" v-model="newEvent.address.city" required>
              <option value="">City</option>
              <option value="Ada">Ada</option>
              <option value="Akron">Akron</option>
              <option value="Alliance">Alliance</option>
              <option value="Amberley">Amberley</option>
              <option value="Amelia">Amelia</option>
              <option value="Arlington">Arlington</option>
              <option value="Ashland">Ashland</option>
              <option value="Ashley">Ashley</option>
              <option value="Ashtabula">Ashtabula</option>
              <option value="Ashville">Ashville</option>
              <option value="Athens">Athens</option>
              <option value="Aurora">Aurora</option>
              <option value="Austintown">Austintown</option>
              <option value="Avon">Avon</option>
              <option value="Avon Center">Avon Center</option>
              <option value="Avon Lake">Avon Lake</option>
              <option value="Bainbridge">Bainbridge</option>
              <option value="Beavercreek">Beavercreek</option>
              <option value="Beckett Ridge">Beckett Ridge</option>
              <option value="Bedford">Bedford</option>
              <option value="Bedford Heights">Bedford Heights</option>
              <option value="Beechwood Trails">Beechwood Trails</option>
              <option value="Bellaire">Bellaire</option>
              <option value="Bellevue">Bellevue</option>
              <option value="Bellville">Bellville</option>
              <option value="Belpre">Belpre</option>
              <option value="Berea">Berea</option>
              <option value="Bethel">Bethel</option>
              <option value="Bethesda">Bethesda</option>
              <option value="Bexley">Bexley</option>
              <option value="Blacklick Estates">Blacklick Estates</option>
              <option value="Brewster">Brewster</option>
              <option value="Bridgetown">Bridgetown</option>
              <option value="Brilliant">Brilliant</option>
              <option value="Broadview Heights">Broadview Heights</option>
              <option value="Cheviot">Cheviot</option>
              <option value="Chillicothe">Chillicothe</option>
              <option value="Cincinnati">Cincinnati</option>
              <option value="Circleville">Circleville</option>
              <option value="Clark-Fulton">Clark-Fulton</option>
              <option value="Clayton">Clayton</option>
              <option value="Clermont County">Clermont County</option>
              <option value="Cleveland">Cleveland</option>
              <option value="Cleveland Heights">Cleveland Heights</option>
              <option value="Cleves">Cleves</option>
              <option value="Clinton">Clinton</option>
              <option value="Clinton County">Clinton County</option>
              <option value="Clyde">Clyde</option>
              <option value="Collinwood">Collinwood</option>
              <option value="Columbiana">Columbus</option>
              <option value="Crestline">Crestline</option>
              <option value="Creston">Creston</option>
              <option value="Cridersville">Cridersville</option>
              <option value="Crooksville">Crooksville</option>
              <option value="Crystal Lakes">Crystal Lakes</option>
              <option value="Curtice">Curtice</option>
              <option value="Cuyahoga County">Cuyahoga County</option>
              <option value="Cuyahoga Falls">Cuyahoga Falls</option>
              <option value="Dalton">Dalton</option>
              <option value="Danville">Danville</option>
              <option value="Darke County">Darke County</option>
              <option value="Day Heights">Day Heights</option>
              <option value="Dayton">Dayton</option>
              <option value="De Graff">De Graff</option>
              <option value="Deer Park">Deer Park</option>
              <option value="Defiance">Defiance</option>
              <option value="Delaware">Delaware</option>
              <option value="Delhi Hills">Delhi Hills</option>
              <option value="Delphos">Delphos</option>
              <option value="Delta">Delta</option>
              <option value="Dennison">Dennison</option>
              <option value="Dent">Dent</option>
              <option value="Deshler">Deshler</option>
              <option value="Devola">Devola</option>
              <option value="Dublin">Dublin</option>
              <option value="Dunlap">Dunlap</option>
              <option value="East Canton">East Canton</option>
              <option value="East Cleveland">East Cleveland</option>
              <option value="East Liverpool">East Liverpool</option>
              <option value="Gahanna">Gahanna</option>
              <option value="Galion">Galion</option>
              <option value="Gallia County">Gallia County</option>
              <option value="Gallipolis">Gallipolis</option>
              <option value="Green Meadows">Green Meadows</option>
              <option value="Green Springs">Green Springs</option>
              <option value="Greenfield">Greenfield</option>
              <option value="Greenhills">Greenhills</option>
              <option value="Greensburg">Greensburg</option>
              <option value="Greentown">Greentown</option>
              <option value="Greenville">Greenville</option>
              <option value="Greenwich">Greenwich</option>
              <option value="Groesbeck">Groesbeck</option>
              <option value="Grove City">Grove City</option>
              <option value="Groveport">Groveport</option>
              <option value="La Croft">La Croft</option>
              <option value="Lagrange">Lagrange</option>
              <option value="Lake Darby">Lake Darby</option>
              <option value="Mariemont">Mariemont</option>
              <option value="Marietta">Marietta</option>
              <option value="Marion">Marion</option>
              <option value="Pickerington">Pickerington</option>
              <option value="Piketon">Piketon</option>
              <option value="Youngstown">Youngstown</option>
              <option value="Zanesville">Zanesville</option>
            </select>
          </div>
          <div class="form-outline col-md-3 mb-3">
          <input
          type="text"
          class="form-control"
          id="zip"
          placeholder="Zip"
          v-model="newEvent.zip"
          required
        />
        </div>
        </div>

         <select
          id="resources"
          class="select form-control"
          name="resource"
          v-model="newEvent.resourceName"
          required
        >
          <option value="">Resource Type</option>
          <option value="Clothing">Clothing</option>
          <option value="School supplies">School supplies</option>
          <option value="Food drives">Food drives</option>
          <option value="Grooming">Grooming</option>
          <option value="Technology">Technology</option>
          <option value="Health">Health</option>
          <option value="Education">Education</option>
          <option value="Childcare">Childcare</option>
        </select>

        <button type="submit" class="btn btn-primary">Add Event</button>
        <button class="btn btn-secondary" @click.stop="$emit('close')">
          Cancel
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import hostService from "../services/HostService";
export default {
  name: "new-event-modal",
  data() {
    return {
      newEvent: {
        name: "",
        startTime: "",
        endTime: "",
        eventDate: "",
        description: "",
        resourceName: "",
        host: this.$store.state.host.name,
        host_description: this.$store.state.host.desc,
        host_img: this.$store.state.host.img,
        address: { address1: "", address2: "", city: "", state: "", zip: "" },
      },
    };
  },
  methods: {
    addEvent() {
      if (confirm("Please confirm adding this event.")) {
        console.log(this.newEvent);
        hostService.addNewEvent(this.newEvent).then(() => {
          window.alert("Event has been added.");
        });
      } else {
        window.alert("Add event has been cancelled.");
      }
    },
  },
  created() {
    this.newEvent = {
      name: "",
      startTime: "",
      endTime: "",
      eventDate: "",
      description: "",
      resourceName: "",
      host: this.$store.state.host.name,
      host_description: this.$store.state.host.desc,
      host_img: this.$store.state.host.img,
      address: { address1: "", address2: "", city: "", state: "", zip: "" },
    };
  },
};
</script>

<style scoped>
#hostName {
  background: rgb(238, 236, 236);
}
header {
  display: flex;
  flex-direction: column;
  justify-content: center;
  font-size: 10px;
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
  width: 50vw;
  height: 100vh;
  background: #ffffff;
  overflow-x: auto;
  display: flex;
  flex-direction: column;
  position: fixed;
  left: 50%;
  right: 0%;
  overflow: hidden;
}

#zip {
  font-size: 15px;
  padding: 10%;
  
}

form {
  display: flex;
  flex-direction: column;
  gap: 7px;
  margin-left: 5%;
  margin-right: 5%;
  margin-top: 2.5%;
}

.input-group-text {
  background-color: white;
  padding: 3%;
  align-items: center;
}

h2 {
  
  font-size: 28px;
}

.time-container {
  display: flex;
  flex-direction: row;
}

#address-container {
  display: flex;
  flex-direction: row;
}

.row {
  display: inline-flex;
  justify-content: center;
}

label {
  text-align: left;
  line-height: 18px;
  margin-top: 10px;
}

input {
  height: 20px;
  flex: 0 0 40px;
  margin-left: 10px;
}

#description {
  flex: 0 0 80px;
}

.btn-primary {

  background: #ba9bdf;
  border: none;

}
</style>