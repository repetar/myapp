<template>
  <div class="UserProfile">
    <h1>{{ user.firstName }} profile</h1>
        First Name: {{ user.firstName }}
        <br/>
        Last Name: {{user.lastName}}
        <br/>
        Email: {{user.email}}
        <br/>
        Address: {{user.address}}
        <br/>
        Orders:
        <br/>
        <br/>
        <br/>
        <li v-for="order in this.orderList" v-bind:key="order">
        <br/>
        {{order.id}}
        <br/>
         </li>

  </div>
</template>

<script>

import axios from "axios";

export default {

    data(){
        return{
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
            let response = await axios.get('http://192.168.0.3:32134/users/' + this.$store.getters.userId)
            this.user = response.data
        },
        async myOrders(){
            let response = await axios.get('http://192.168.0.3:32134/orders/user/' + this.$store.getters.userId)
            let data = response.data
            this.orderList = data
            for (var i=0; i<this.orderList.length; i++){
                var on = this.orderList[i]
                let response = await axios.get('http://192.168.0.3:32134/products/' + on.productId)
                let data = response.data
                this.OrderProductMap[on.id]=data.productDescription
            }
        },
        async getDescription(id){
            let response = await axios.get('http://192.168.0.3:32134/products/' + id)
            let data = response.data
            let pretty = JSON.stringify(data)
            return pretty.productDescription
        }
    }
}
</script>