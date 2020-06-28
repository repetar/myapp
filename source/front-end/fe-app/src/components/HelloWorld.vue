<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
      For a guide and recipes on how to configure / customize this project,<br>
      check out the
      <a href="https://cli.vuejs.org" target="_blank" rel="noopener">vue-cli documentation</a>.
    </p>
    <h3>Installed CLI Plugins</h3>
    <ul>
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel" target="_blank" rel="noopener">babel</a></li>
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-eslint" target="_blank" rel="noopener">eslint</a></li>
    </ul>
    <h3>Essential Links</h3>
    <ul>
      <li><a href="https://vuejs.org" target="_blank" rel="noopener">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank" rel="noopener">Forum</a></li>
      <li><a href="https://chat.vuejs.org" target="_blank" rel="noopener">Community Chat</a></li>
      <li><a href="https://twitter.com/vuejs" target="_blank" rel="noopener">Twitter</a></li>
      <li><a href="https://news.vuejs.org" target="_blank" rel="noopener">News</a></li>
    </ul>
    <h3>Ecosystem</h3>
    <ul>
      <li><a href="https://router.vuejs.org" target="_blank" rel="noopener">vue-router</a></li>
      <li><a href="https://vuex.vuejs.org" target="_blank" rel="noopener">vuex</a></li>
      <li><a href="https://github.com/vuejs/vue-devtools#vue-devtools" target="_blank" rel="noopener">vue-devtools</a></li>
      <li><a href="https://vue-loader.vuejs.org" target="_blank" rel="noopener">vue-loader</a></li>
      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank" rel="noopener">awesome-vue</a></li>
    </ul>

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
    <input v-model="userid" placeholder="userid">
    <br/>
    <button v-on:click="sendData()">getAllUsers</button>
    <br/>
    <button v-on:click="postUser()">postUser</button>
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
      this.textboxmessage = this.textboxmessage + "updated"
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
