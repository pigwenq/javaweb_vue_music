import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (to) {
return VueRouterPush.call(this, to).catch(err => err)
}

const routes = [
  {
    path: '/',
    name: 'Main',
    component: ()=>import("../views/Main.vue"),
    children:[
      {path:'/',component:()=>import("../views/Faxian.vue")},
      {path:'/mymusic',component:()=>import("../views/MyMusic.vue")},
      {path:'/musiclist',component:()=>import("../views/MusicList.vue")},
      {path:'/search',component:()=>import("../views/Search.vue")}
    ]
  },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  routes
})

export default router
