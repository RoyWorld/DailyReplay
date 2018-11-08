import Vue from 'vue'
import Router from 'vue-router'
import Welcome from '@/views/Welcome'
import DailyReplay from '@/views/DailyReplay'
import Principle from '@/views/Principle'
import Test from '@/views/Test'
import Report from '@/views/Report'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/welcome'
    },
    {
      path: '/welcome',
      name: 'welcome',
      component: Welcome
    },
    {
      path: '/dailyreplay',
      name: 'dailyreplay',
      component: DailyReplay
    },
    {
      path: '/principle',
      name: 'principle',
      component: Principle
    },
    {
      path: '/test',
      name: 'test',
      component: Test
    },
    {
      path: '/report/*',
      name: 'report',
      component: Report
    },
  ]
})
