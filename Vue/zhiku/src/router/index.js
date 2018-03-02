import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '@/components/Index'
import FirstIndex from '@/components/first/FirstIndex'
import HelloWorld from '@/components/first/HelloWorld'
import XPFirst from '@/components/first/XPFirst'
import SecondFirst from '@/components/second/SecondFirst'
import SecondHello from '@/components/second/SecondHello'
import Register from '@/components/register/Register'
import Login from '@/components/login/Login'

Vue.use(VueRouter)

// 这里可以带有路由器的配置参数
export default new VueRouter({
  routes: [
    {
      path: '/',
      component: Index
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '/first',
      component: FirstIndex,
      children: [
        { path: 'helloworld', component: HelloWorld },
        { path: 'xpfirst', component: XPFirst }
      ]
    },
    {
      path: '/second',
      component: SecondFirst
    },
    {
      path: '/second/secondhello',
      component: SecondHello
    }
  ]
})
