import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import store from './store'
import 'font-awesome/css/font-awesome.min.css';


import axios from 'axios'
import qs from 'qs'
axios.defaults.baseURL='http://localhost:8081/Music'   //全局配置baseurl  http://localhost:8081
axios.defaults.timeout=3000

Vue.prototype.$axios = axios
Vue.prototype.$qs=qs

Vue.config.productionTip = false
Vue.use(ElementUI)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
