import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    homes: [
      {
          "homeId": 0,
          "mlsNumber": "1000",
          "address": {
              "addressLine": "123 Elm Street",
              "city": "Columbus",
              "state": "Ohio",
              "zip": 43323
          },
          "numberOfBedrooms": 3.0,
          "numberOfBathrooms": 4.0,
          "price": 250000.00,
          "shortDescription": "Freddies Nightmare will come to your life in the classic home. Sweet dreams!",
          "imageName": require('../assets/1000.jpg')
      },
      {
          "homeId": 0,
          "mlsNumber": "1001",
          "address": {
              "addressLine": "125 Elm Street",
              "city": "Columbus",
              "state": "Ohio",
              "zip": 43323
          },
          "numberOfBedrooms": 3.0,
          "numberOfBathrooms": 3.0,
          "price": 100000.00,
          "shortDescription": "Nice house but the neighbor is a little strange.",
          "imageName": require('../assets/1001.jpg')
      },
      {
          "homeId": 0,
          "mlsNumber": "1002",
          "address": {
              "addressLine": "777 Oak Street",
              "city": "Dublin",
              "state": "Ohio",
              "zip": 43017
          },
          "numberOfBedrooms": 5.0,
          "numberOfBathrooms": 3.0,
          "price": 350000.00,
          "shortDescription": "Charming house far away from those Elm street weirdos.",
          "imageName": require('../assets/1002.jpg')
      },
      {
          "homeId": 0,
          "mlsNumber": "1003",
          "address": {
              "addressLine": "555 E Main Street",
              "city": "Columbus",
              "state": "Ohio",
              "zip": 43203
          },
          "numberOfBedrooms": 25.0,
          "numberOfBathrooms": 10.0,
          "price": 450000.00,
          "shortDescription": "This house was featured on the reality tv show: Kevin Flipped My House.",
          "imageName": require('../assets/1003.jpg')
      },
      {
          "homeId": 0,
          "mlsNumber": "1004",
          "address": {
              "addressLine": "127 Slider Lane",
              "city": "Columbus",
              "state": "Ohio",
              "zip": 43210
          },
          "numberOfBedrooms": 25.0,
          "numberOfBathrooms": 10.0,
          "price": 150000.00,
          "shortDescription": "Next door to the White Castle, always be on the lookout for Harold and Kumar!",
          "imageName": require('../assets/1004.jpg')
      },
      {
          "homeId": 0,
          "mlsNumber": "1005",
          "address": {
              "addressLine": "127 Crime Fighters Blvd",
              "city": "Columbus",
              "state": "Ohio",
              "zip": 43210
          },
          "numberOfBedrooms": 25.0,
          "numberOfBathrooms": 10.0,
          "price": 750000.00,
          "shortDescription": "Rumour has it batman used to live here before upgrading to the bat cave!",
          "imageName": require('../assets/1005.jpg')
      }
  ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
