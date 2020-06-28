import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    userId: 'ua'
  },
  mutations: {
    saveUserLogged (state, loggedUser) {
      console.log("current state: " + state.userId)
      console.log("saving: " + loggedUser)
      state.userId = loggedUser
      console.log("state.userLogged: " + state.userId)
    }
  },
  actions: {
    saveUserLogged (context, loggedUser) {
      console.log("dispatching" + loggedUser)
      context.commit('saveUserLogged', loggedUser)
    }
  },
  getters: {
    mystates: state => {
      console.log("getter: " + state.userId)
      return state.userId
    }
  },
  plugins: [createPersistedState()]
})

export default store