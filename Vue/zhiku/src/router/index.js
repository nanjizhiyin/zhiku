import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import FirstIndex from '@/components/first/FirstIndex'
import HelloWorld from '@/components/first/HelloWorld'
import XPFirst from '@/components/first/XPFirst'
import SecondFirst from '@/components/second/SecondFirst'
import SecondHello from '@/components/second/SecondHello'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: Index
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
