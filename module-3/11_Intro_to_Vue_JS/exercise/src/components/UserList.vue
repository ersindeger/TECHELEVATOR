<template>
  <table id="tblUsers">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td> <input type="text" id="firstNameFilter" v-model="search.firstName"/> 
        {{search.firstName}}
        </td>

        <td><input type="text" id="lastNameFilter" v-model="search.lastName" />
        {{search.lastName}}
        </td>

        <td><input type="text" id="usernameFilter" v-model="search.username" />
        {{search.username}}
        </td>

        <td><input type="text" id="emailFilter" v-model="search.emailAddress" />
        {{search.emailAddress}}
        </td>

        <td>
          <select id="statusFilter" v-model="search.status" >
            <option value="" >Show All</option>
            <option value="Active"> Active </option>
            <option value="Inactive">Inactive</option>
            {{search.status}}
          </select>
        </td>

      </tr>
      <!-- user listing goes here -->
        <tr v-for="user in filteredUsers" v-bind:key="user.id">

        <td>{{user.firstName}}</td>
        <td>{{user.lastName}}</td>
        <td>{{user.username}}</td>
        <td>{{user.emailAddress}}</td>
        <td>{{user.status}}</td>

        </tr>


    </tbody>
  </table>
</template>

<script>
export default {
  name: 'user-list',
  data() {
    return {
      users: [
        { firstName: 'John', lastName: 'Smith', username: 'jsmith', emailAddress: 'jsmith@gmail.com', status: 'Active' },
        { firstName: 'Anna', lastName: 'Bell', username: 'abell', emailAddress: 'abell@yahoo.com', status: 'Active' },
        { firstName: 'George', lastName: 'Best', username: 'gbest', emailAddress: 'gbest@gmail.com', status: 'Inactive' },
        { firstName: 'Ben', lastName: 'Carter', username: 'bcarter', emailAddress: 'bcarter@gmail.com', status: 'Active' },
        { firstName: 'Katie', lastName: 'Jackson', username: 'kjackson', emailAddress: 'kjackson@yahoo.com', status: 'Active' },
        { firstName: 'Mark', lastName: 'Smith', username: 'msmith', emailAddress: 'msmith@foo.com', status: 'Inactive' }
      ],

      search: 
        {
        firstName: "",
        lastName:"",
        username: "",
        emailAddress: "",
        status: ""
        }
      
    }
  },

  computed: {
    filteredUsers() {
      let filteredArray = this.users;
      // return this.users.filter((user) => {
      //   return user.firstName.includes(this.filterText);
        if (this.search.firstName != '') {
          filteredArray = filteredArray.filter( (user) =>
            user.firstName.toLowerCase().includes(this.search.firstName.toLowerCase())
          )
       }

        if (this.search.lastName != '') {
          filteredArray = filteredArray.filter( (user) =>
            user.lastName.toLowerCase().includes(this.search.lastName.toLowerCase())
          )
       }

        if (this.search.username != '') {
          filteredArray = filteredArray.filter( (user) =>
            user.username.toLowerCase().includes(this.search.username.toLowerCase())
          )
       }
        
        if (this.search.emailAddress != '') {
          filteredArray = filteredArray.filter( (user) =>
            user.emailAddress.toLowerCase().includes(this.search.emailAddress.toLowerCase())
          )
       }

        if (this.search.status != '') {
          filteredArray = filteredArray.filter( (user) =>
            user.status == this.search.status)
                 }


      return filteredArray;
    }
  }

}
</script>


<style scoped>
table {
  margin-top: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}
th {
  text-transform: uppercase
}
td {
  padding: 10px;
}
tr.inactive {
  color: red;
}
input, select {
  font-size: 16px;
}
</style>
