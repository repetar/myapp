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
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/UserProfile.vue')
  },
  {
    path: '/userlogin',
    name: 'UserLogin',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/UserLogin.vue')
  },
  {
    path: '/newuser',
    name: 'NewUser',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/CreateNewUser.vue')
  },
  {
    path: '/products',
    name: 'Products',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Products.vue')
  },
  {
    path: '/outofstock',
    name: 'OutOfStock',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/OutOfStock.vue')
  },
  {
    path: '/orderfailed',
    name: 'OrderFailed',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/OrderFailed.vue')
  },
  {
    path: '/ordersuccesfull',
    name: 'OrderSuccesfull',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/OrderSuccesfull.vue')
  }
]

const router = new VueRouter({
  routes
})


export default router