<template>
  <div class="products">
    <h1>Products</h1>
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
        productlist: '',
        } 

    } ,
    mounted:function(){
        this.getProducts()
    },
    methods:{
        async getProducts(){
        let response = await axios.get('http://10.99.135.244:8080/products/')
        let data = response.data
        let pretty = JSON.stringify(data)
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
        async order(id){

            console.log("ordering id: " + id)
            let ob ={ 
            "orderDate":new Date().toLocaleString(), 
            "userId":this.$store.getters.userId, 
            "productId":id, 
            } 

            let response = await axios.post('http://10.99.135.244:8080/orders/', ob)
            let data = response.data
            let pretty = JSON.stringify(data)
            console.log("#####################################################")
            console.log(response)
            console.log("#####################################################")
            console.log(data)
            console.log("#####################################################")
            console.log(pretty)

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