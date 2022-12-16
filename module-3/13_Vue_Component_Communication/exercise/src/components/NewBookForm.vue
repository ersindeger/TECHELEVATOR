<template>
  <div>
      <h2> Add a New Book right here! </h2>

      <form class="new-book-form">
          
          <div class="title-input"> 
              <label for="title"> Title: </label>
              <input id="title" type="text" v-model="newBook.title" />
          </div>
        
          <div class="author-input"> 
              <label for="author"> Author: </label>
              <input id="author" type="text" v-model="newBook.author" />
          </div>

          <div class="isbn-input">
                <label for="isbn"> ISBN: </label>
                <input id="isbn" type="text" v-model="newBook.isbn" />
          </div>
        
          <input type="submit" value="Save" v-on:click.prevent="addNewBook" />
          <input type="button" value="Cancel" v-on:click.prevent="resetForm" />

      </form>

  </div>
</template>

<script>
export default {
    name: "new-book-form",
    data() {
        return {
            showForm: false,
            newBook: {
            read: false,
            },
        };
    },

  methods: {
    addNewBook() {
      this.$store.commit("ADD_BOOK", this.newBook);
      this.resetForm();
    },

    resetForm() {
      this.showForm = false;
      this.newBook = {};
    },

  }
}
</script>

<style scoped>

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input {
  height: 30px;
  width: 300px;
}
form > input[type="button"] {
  width: 100px;
}
form > input[type="submit"] {
  width: 100px;
  margin-right: 10px;
}

</style>