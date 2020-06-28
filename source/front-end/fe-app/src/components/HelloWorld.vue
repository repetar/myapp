<template>
  <div class="hello">
    
    <h3>Welcome to product site!</h3>
    <ul>
      <li><router-link to="/products">Product List</router-link></li>
    </ul>

    <br/>
    <input v-model="userid" placeholder="userid">
    <br/>
    <button v-on:click="sendData()">getAllUsers</button>
    <br/>
    <button v-on:click="update()">Update</button>
    <br/>
    <button v-on:click="getUserById()">getuserbyid</button>
    <br/>
    <button v-on:click="deleteUserById()">deleteuserbyid</button>
    <br/>
    <textarea type="text" v-model=textboxmessage />
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: 'App',
  data() {
      return {
          input: {
              firstname: "ff",
              lastname: "gg"
          },
          textboxmessage: "hh"
      }
  },

  methods:{
    async sendData(){
      this.textboxmessage = this.textboxmessage + "abb"
      let response = await axios.get('http://10.99.135.244:8080/users/')
      let data = response.data
      let pretty = JSON.stringify(data)
      this.textboxmessage = pretty
      console.log("#####################################################")
      console.log(response)
      console.log("#####################################################")
      console.log(data)
      console.log("#####################################################")
      console.log(pretty)
    },
    async getUserById(){
      let response = await axios.get('http://10.99.135.244:8080/users/' + this.userid)
      let data = response.data
      let pretty = JSON.stringify(data)
      this.textboxmessage = pretty
    },
   async deleteUserById(){
      let response = await axios.delete('http://10.99.135.244:8080/users/' + this.userid)
      let data = response.data
      let pretty = JSON.stringify(data)
      this.textboxmessage = pretty
    },
    update(){
      this.textboxmessage = this.textboxmessage + "updated" + this.$router.username
      if (this.$router.username != null){
        this.textboxmessage = this.textboxmessage + this.$router.username
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
