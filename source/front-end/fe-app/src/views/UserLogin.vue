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
                // post
                   let ob ={
                         "email":this.input.email,
                         "password":this.input.password
                  }
                  let response = await axios.post('http://10.99.135.244:8080/users/login', ob)
                  let data = response.data
                  if (data == "success"){
                    // get userid here
                    console.log("user email: " + ob.email)
                    let user = await axios.get('http://10.99.135.244:8080/users/email/' + ob.email)
                    let data = user.data
                    console.log("firstname:" + data.firstName)
                    console.log("login state: " + this.$store.getters.loginState)
                    console.log("initial id: " + this.$store.getters.userId)
                    this.$store.commit('saveUserLogged', data.id)
                    console.log("authenticated state 2: " + this.authenticated)
                    this.$router.replace({name: "Home"} );
                    
                    console.log("login state 2: " + this.$store.getters.loginState)

                  } else{

                    console.log("The username and / or password is incorrect");
                    this.loginfailed=true

                  }
             } else {
                console.log("A username and password must be present");

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