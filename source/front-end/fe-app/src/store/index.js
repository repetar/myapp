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
      state.userId = loggedUser
      state.loggedIn = true
    },
    logOut(state){
      state.userId = ''
      state.loggedIn = false
    }
  },
  getters: {
    userId: state => {
      return state.userId
    },
    loginState: state =>{
      return state.loggedIn
    }
  },
  plugins: [createPersistedState()]
})

export default store