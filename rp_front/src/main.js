// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Iview from 'iview'
import axios from 'axios'
import VueI18n from 'vue-i18n'
import numeral from 'numeral'


import 'iview/dist/styles/iview.css'
import zh_CN from 'iview/dist/locale/zh-CN'
import http from './common/http'
import { getInitConfig } from './common/native'

Vue.use(VueI18n)
Vue.use(Iview)

Vue.config.productionTip = false

// Setting i18n
const i18n = new VueI18n({
  locale: 'zh-CN',
  messages: {
    'zh-CN': Object.assign(require('./i18n/zh-CN').default, zh_CN)
  }
})

Vue.prototype.$noSpinHttp = axios.create()
Vue.prototype.$http = http.build()
Vue.prototype.$http.interceptors.response.use(
  response => {
  return response
},
  error => {
  if (!error.response) {
    Vue.prototype.$Message.error(i18n.t('alert.refused'))
  } else if (error.response.status == 400) {
    let i18nKey =
      'alert["' +
      new URL(error.config.url).pathname +
      '"]' +
      '.' +
      error.config.method +
      '.' +
      error.response.data.code
    Vue.prototype.$Message.error(i18n.t(i18nKey))
  } else if (error.response.status == 404) {
    Vue.prototype.$Message.error(i18n.t('alert.notFound'))
  } else if (error.response.status == 504) {
    Vue.prototype.$Message.error(i18n.t('alert.timeout'))
  } else {
    Vue.prototype.$Message.error(i18n.t('alert.error'))
  }
  return Promise.reject(error)
}
)

Vue.prototype.$numeral = numeral
Date.prototype.format = function(fmt) {
  var o = {
    'M+': this.getMonth() + 1, // Month
    'd+': this.getDate(), // Day
    'h+': this.getHours(), // Hour
    'm+': this.getMinutes(), // Minute
    's+': this.getSeconds(), // Second
    'q+': Math.floor((this.getMonth() + 3) / 3), // Quarter
    S: this.getMilliseconds() // Millisecond
  }
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length))
  }
  for (var k in o) {
    if (new RegExp('(' + k + ')').test(fmt)) {
      fmt = fmt.replace(RegExp.$1, RegExp.$1.length === 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length))
    }
  }
  return fmt
}

Promise.prototype.finally = function(callback) {
  let P = this.constructor
  return this.then(
      value => P.resolve(callback()).then(() => value),
  reason =>
  P.resolve(callback()).then(() => {
    throw reason
  })
  )
}

// Change the page according to the routing changes title
router.beforeEach((to, from, next) => {
  if (to.meta.title) {
  document.title = `Daily Replay-${to.meta.title}`
}
next()
})

// Get client configuration information
// getInitConfig()
//   .then(result => {
//   Vue.prototype.$config = result
// // Set default language
// i18n.locale = result.locale
// })
// .finally(() => {
//   new Vue({
//       router,
//       i18n,
//       render: h => h(App)
// }).$mount('#app')
// })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  i18n,
  components: { App },
  template: '<App/>',
  render: h => h(App)
})

