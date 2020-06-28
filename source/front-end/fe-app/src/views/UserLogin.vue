<template>
  <div class="about">
    <h1>UserLogin</h1>
     <input type="text" name="email" v-model="input.email" placeholder="email" />
      <input type="password" name="password" v-model="input.password" placeholder="Password" />
      <button type="button" v-on:click="login()">Login</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
    name: 'Login',
    data() {
        return {
            input: {
                username: "",
                password: ""
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
                    this.$emit("authenticated", true);
                    this.$router.replace({ name: "Home" });
                    // get userid here
                    this.$router.username = "amyusernameaa";

                  } else{
                    console.log("A username and password must be present");
                  } 
             } else {
                    console.log("The username and / or password is incorrect");
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