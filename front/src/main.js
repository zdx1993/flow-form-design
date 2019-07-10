import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import axios from 'axios'
import qs from 'qs'


Vue.prototype.$ajax = axios    //全局注册，使用方法为:this.$ajax
Vue.prototype.qs = qs           //全局注册，使用方法为:this.qs

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
