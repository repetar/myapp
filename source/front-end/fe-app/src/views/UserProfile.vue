<template>
  <div class="UserProfile">
    <h1>{{ user.firstName }} profile</h1>
        First Name: {{ user.firstName }}
        <br/>
        Last Name: {{user.lastName}} 
        <br/>
        Ema*il: {{user.email}} 
        <br/>
        Address: {{user.address}} 
        <br/>
        <br/>
        <li v-for="order in this.orderList" v-bind:key="order">
       
        <br/>
        {{order.id}} 
      
        <br/>
       {{order.productId}} 
        <br/>
      product description
        <br/>
         </li>
        
  </div>
</template>

<script>

import axios from "axios";

export default {
  
    data(){
        return{ 
        textboxmessage: '',
        orderList: '',
        user: '',
        OrderProductMap:{} 
        } 

    } ,
    mounted:function(){
        this.loadUserData(),
        this.myOrders()
    },
    methods:{
        async loadUserData(){
        let response = await axios.get('http://10.99.135.244:8080/users/' + this.$store.getters.userId)
        this.user = response.data
        },
        async myOrders(){
        let response = await axios.get('http://10.99.135.244:8080/orders/user/' + this.$store.getters.userId)
        let data = response.data
        let pretty = JSON.stringify(data)
        console.log("orders: " + pretty)
        this.orderList = data
        for (var i=0; i<this.orderList.length; i++){
            var on = this.orderList[i]
            console.log("name " + on.productId ) 
            let response = await axios.get('http://10.99.135.244:8080/products/' + on.productId)
            let data = response.data
            console.log("pr: " +  data.productDescription)
            this.OrderProductMap[on.id]=data.productDescription
            console.log("jj: "+ on.id + "   " + this.OrderProductMap[on.id])
        } 
        console.log("aaa " + JSON.stringify(this.OrderProductMap))
        },
        async getDescription(id){
          console.log("get call")
          let response = await axios.get('http://10.99.135.244:8080/products/' + id)
          let data = response.data
          let pretty = JSON.stringify(data)
          console.log("pr: " +  pretty)
          return pretty.productDescription

        } 
    }
}
</script>