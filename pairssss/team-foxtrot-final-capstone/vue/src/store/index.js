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
    userHostId: 0,
    host: {name: 'Not set', desc: 'Not set', img: 'Not set'},
    resource_types: [ {name: "School supplies", resourceId: 1}, {name: "Clothing", resourceId: 2}, {name: "Food drives", resourceId: 3}, 
       {name: "Grooming", resourceId: 4},  {name: "Technology", resourceId: 5}, 
       {name: "Health", resourceId: 6}, {name: "Education", resourceId: 7},
       {name: "Childcare", resourceId: 8}
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
    SET_USER_HOST_ID(state, id) {
      state.userHostId = id;
    },
    SET_USER_HOST_INFO(state, host) {
      state.host.name = host.name;
      state.host.desc = host.desc;
      state.host.img = host.img;
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
