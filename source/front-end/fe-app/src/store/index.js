import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    userId: '',
    loggedIn: false
  },
  mutations: {
    saveUserLogged (state, loggedUser) {
      console.log("current state: " + state.userId)
      console.log("saving: " + loggedUser)
      state.userId = loggedUser
      state.loggedIn = true
      console.log("state.userLogged: " + state.userId)
    },
    logOut(state){
      state.userId = ''
      state.loggedIn = false
    } 
  },
  actions: {
    saveUserLogged (context, loggedUser) {
      console.log("dispatching" + loggedUser)
      context.commit('saveUserLogged', loggedUser)
    },
    logOut(context){
      context.commit('logOut')
    } 
  },
  getters: {
    userId: state => {
      console.log("getter: " + state.userId)
      return state.userId
    },
    loginState: state =>{
      console.log("login state getter: " + state.loggedIn)
      return state.loggedIn
    } 
  },
  plugins: [createPersistedState()]
})

export default store