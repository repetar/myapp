<template>
  <div class="about">
    <h1>UserLogin</h1>
     <input type="text" name="email" v-model="input.email" placeholder="email" />
      <input type="password" name="password" v-model="input.password" placeholder="Password" />
      <button type="button" v-on:click="login()">Login</button>
      <br/>
      <router-link v-if="loginfailed" to="/newuser">Login failed. Create new user?</router-link>
  </div>
</template>

<script>
import axios from "axios";
export default {
    name: 'Login',
    data() {
        return {
          loginfailed: false,
            input: {
                username: "",
                password: "",
            }
        }
    },
    methods: {
        async login() {
            if(this.input.email != "" && this.input.password != "") {

                let ob ={
                    "email":this.input.email,
                    "password":this.input.password
                }

                let response = await axios.post('http://192.168.0.2:32134/users/login', ob)
                let data = response.data

                if (data.success == "succesfull"){
                    this.$store.commit('saveUserLogged', data.id)
                    this.$router.replace({name: "Home"} );
                } else{
                    this.loginfailed=true
                }
            }
         }
    }
}
</script>

<style scoped>
    #login {
        width: 500px;
        border: 1px solid #CCCCCC;
        background-color: #FFFFFF;
        margin: auto;
        margin-top: 200px;
        padding: 20px;
    }
</style>