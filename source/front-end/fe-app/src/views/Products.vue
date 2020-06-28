<template>
  <div class="products">
    <h1>Products</h1>
    <textarea type="text" v-model=textboxmessage />
    <ul>
    <li v-for="product in this.productlist" v-bind:key="product">
        {{ product.productName }}
        <br/>
        {{product.productDescription}} 
        <br/>
        Price: {{product.productPrice}} 
        <br/>
        <button v-on:click="order(product.id)">Order</button>
        <br/>
        <br/>
    </li>
    </ul>

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
        this.sendData()
    },
    methods:{
        async sendData(){
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
#orderdiv {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>