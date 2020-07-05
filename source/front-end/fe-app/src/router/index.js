import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'


Vue.use(VueRouter)

  const routes = [
   {
     path: '/',
     redirect: '/home'

   },
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/userprofile',
    name: 'UserProfile',
    component: () => import(/* webpackChunkName: "about" */ '../views/UserProfile.vue')
  },
  {
    path: '/userlogin',
    name: 'UserLogin',
    component: () => import(/* webpackChunkName: "about" */ '../views/UserLogin.vue')
  },
  {
    path: '/newuser',
    name: 'NewUser',
    component: () => import(/* webpackChunkName: "about" */ '../views/CreateNewUser.vue')
  },
  {
    path: '/products',
    name: 'Products',
    component: () => import(/* webpackChunkName: "about" */ '../views/Products.vue')
  },
  {
    path: '/outofstock',
    name: 'OutOfStock',
    component: () => import(/* webpackChunkName: "about" */ '../views/OutOfStock.vue')
  },
  {
    path: '/orderfailed',
    name: 'OrderFailed',
    component: () => import(/* webpackChunkName: "about" */ '../views/OrderFailed.vue')
  },
  {
    path: '/ordersuccesfull',
    name: 'OrderSuccesfull',
    component: () => import(/* webpackChunkName: "about" */ '../views/OrderSuccesfull.vue')
  }
]

const router = new VueRouter({
  routes
})


export default router