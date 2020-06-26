<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>

    <input v-model="firstName" placeholder="firstName">
    <br/>
    <input v-model="lastName" placeholder="lastName">
    <br/>
    <input v-model="email" placeholder="email">
    <br/>
    <input v-model="address" placeholder="address">
    <br/>
    <input v-model="message" placeholder="password">
    <br/>
    <button v-on:click="sendData()">getAllUsers</button>
    <br/>
    <button v-on:click="postUser()">postUser</button>
    <br/>
    <button v-on:click="update()">Update</button>
    <br/>
    <textarea type="text" v-model=textboxmessage />
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
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
  components: {
    HelloWorld
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
    async postUser(){
    let ob ={ 
      "firstName":this.firstName, 
      "lastName":this.lastName, 
      "email":this.email, 
      "address":this.address
    } 

    let response = await axios.post('http://10.99.135.244:8080/users/', ob)
    this.textboxmessage = JSON.stringify(response.data).pretty
    },
    update(){
      this.textboxmessage = "updated"

    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
