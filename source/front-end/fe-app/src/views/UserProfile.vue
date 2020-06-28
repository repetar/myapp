<template>
  <div class="UserProfile">
    <h1>User Profile Page</h1>

  </div>
</template>

<script>

import axios from "axios";

export default {
  
    data(){
        return{ 
        textboxmessage: '',
        productlist: '',
        } 

    } ,
    mounted:function(){
        this.getUSerData()
    },
    methods:{
        async getUserData(){
        this.textboxmessage = this.textboxmessage + "abb"
        let response = await axios.get('http://10.99.135.244:8080/products/')
        let data = response.data
        let pretty = JSON.stringify(data)
        this.textboxmessage = pretty
        this.productlist = data
        console.log("#####################################################")
        console.log(response)
        console.log("#####################################################")
        console.log(data)
        console.log("#####################################################")
        console.log(pretty)
        for (var i=0; i<pretty.length; i++){
            var on = pretty[i]
            console.log("name " + on.productName ) 
        } 
        },
        order(id){
            
            console.log("ordering id: " + id)
        } 
    }
}
</script>