<template>
  <div class="hello">
    <input v-model="firstName" placeholder="firstName">
    <br/>
    <input v-model="lastName" placeholder="lastName">
    <br/>
    <input v-model="email" placeholder="email">
    <br/>
    <input v-model="address" placeholder="address">
    <br/>
    <input type="password" name="password" v-model="password" placeholder="Password" />
    <br/>
    <button v-on:click="postUser()">Create User</button>
    <br/>
    <h3 v-if="this.emailtaken">Email address already in use.</h3>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: 'App',
  data() {
      return {
        emailtaken:false,
        firstName: '',
        lastName: '',
        email: '',
        address: '',
        password: ''
      }
  },

  methods:{
    async postUser(){
    let ob ={
      "firstName":this.firstName,
      "lastName":this.lastName,
      "email":this.email,
      "address":this.address,
      "password":this.password
    }

    let response = await axios.post('http://10.0.2.15:32134/users/', ob)
    if (response.data == "email taken"){
      this.emailtaken=true

    }else{
      let data = response.data
      this.emailtaken=false
      this.$store.commit('saveUserLogged', data)
      this.$router.push('Home')
    }


    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
