<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
        <h3>Welcome to product site!</h3>
    <ul>
      <li><router-link to="/products">Product List</router-link></li>
    </ul>
  </div>
  
</template>

<script>
// @ is an alias to /src


export default {
  name: 'Home',
  components: {
    
  },
  data() {
    return {
        authenticated: this.$store.getters.loginState,
    }
},
}
</script>
