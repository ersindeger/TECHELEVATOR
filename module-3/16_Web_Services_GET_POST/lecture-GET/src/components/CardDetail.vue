<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>

    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <comments-list v-bind:comments="card.comments" v-else />

    <div class="board-actions" v-if="!isLoading">
      <router-link
        v-bind:to="{ name: 'Board', params: { id: $route.params.boardID } }"
        >Back to Board</router-link
      >
    </div>
  </div>
</template>

<script>

//TODO: add the import

import CommentsList from '../components/CommentsList';

export default {
  name: 'card-detail',
  components: {
    CommentsList
  },
  data() {
    return {
      card: {
        title: '',
        description: '',
        status: '',
        comments: []
      },
      isLoading: true
    };
  },

  //TODO: add a create() to fetch the data from the service. We need the boardid and card id from the route path

};
</script>
