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
    <button v-on:click="postUser()">postUser</button>
    <br/>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: 'App',
  data() {
      return {
          
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

    let response = await axios.post('http://10.99.135.244:8080/users/', ob)
    let data = response.data
    let pretty = JSON.stringify(data)
    this.textboxmessage = pretty
    console.log("#####################################################")
    console.log(response)
    console.log("#####################################################")
    console.log(data)
    console.log("#####################################################")
    console.log(pretty)
    this.textboxmessage = pretty
    this.$router.push('UserLogin')
    
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
