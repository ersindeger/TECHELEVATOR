<template>
  <div>
    <div id="container">
      <div id="search">
        <label for="zip">Enter a zip code to find your next dream home:</label>
        <input type="text" name="zip" v-model="zipFilter"/>
      </div>

      <div id="main-div">
        <div class="divTable minimalistBlack">
          <div class="divTableHeading">
            <div class="divTableRow">
              <div class="divTableHead"></div>
              <div class="divTableHead">Address</div>
              <div class="divTableHead"># Bedrooms</div>
              <div class="divTableHead"># Bathrooms</div>
              <div class="divTableHead">Price</div>
            </div>
          </div>
          <div class="divTableBody">
            <div
              class="divTableRow"
              v-for="home in filteredHomes"
              v-bind:key="home.mlsNumber"
            >
              <div class="divTableCell">
                <img v-bind:src="getImageURL(home.imageName)" />
              </div>
              <div class="divTableCell">
                {{ home.address.addressLine }} {{ home.address.city }} {{home.address.zip}}
              </div>
              <div class="divTableCell"><div>{{home.numberOfBedrooms}} - Number of Bedrooms</div>
                                        <div>{{home.numberOfBathrooms}} - Bathrooms</div>
              </div>
              <div class="divTableCell">{{home.shortDescription}}</div>
              <div class="divTableCell">${{home.price}}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import homeService from "../services/HomeService.js";

export default {
  name: "home-search",
  data() {
    return {
      zipFilter: "",
      homes: []
    };
  },
  computed: {
    filteredHomes() {
      
      return this.homes.filter((home) => {
        return this.zipFilter == "" ? true : this.zipFilter == home.address.zip;
      });
    },
  },
  created() {
    homeService.search().then ( response => {
      this.homes = response.data;
    } );
  },
  methods: {
    getImageURL(pic){
      return require('../assets/' + pic);
    }
  }


};
</script>

<style scoped>
div.minimalistBlack {
  margin: auto;
  border: 2px solid #06b712;
  width: 80%;
  text-align: left;
  border-collapse: collapse;
}
.divTable.minimalistBlack .divTableCell,
.divTable.minimalistBlack .divTableHead {
  border: 1px solid #000000;
  padding: 5px 4px;
}

.divTable.minimalistBlack .divTableBody .divTableCell {
  font-size: 14px;
}
.divTable.minimalistBlack .divTableHeading {
  background: #1dff2c;
  background: -moz-linear-gradient(top, #55ff61 0%, #33ff41 66%, #1dff2c 100%);
  background: -webkit-linear-gradient(
    top,
    #55ff61 0%,
    #33ff41 66%,
    #1dff2c 100%
  );
  background: linear-gradient(to bottom, #55ff61 0%, #33ff41 66%, #1dff2c 100%);
  border-bottom: 3px solid #0f9a39;
}
.divTable.minimalistBlack .divTableHeading .divTableHead {
  font-size: 15px;
  font-weight: bold;
  color: #109902;
  text-align: left;
}
.minimalistBlack .tableFootStyle {
  font-size: 14px;
}
/* DivTable.com */
.divTable {
  display: table;
  table-layout: fixed;
}
.divTableRow {
  display: table-row;
}
.divTableHeading {
  display: table-header-group;
}
.divTableCell,
.divTableHead {
  display: table-cell;
}
.divTableHeading {
  display: table-header-group;
}
.divTableFoot {
  display: table-footer-group;
}
.divTableBody {
  display: table-row-group;
}

#main-div {
  margin: 30px;
}

#search {
  margin: 20px;
}

input[type="text"] {
  width: 30%;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid green;
  border-radius: 6px;
  margin: 20px
}

#container {
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>