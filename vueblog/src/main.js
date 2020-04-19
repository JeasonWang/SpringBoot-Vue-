import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'
import './utils/filter_utils.js'
import store from "./store";
import axios from 'axios' ;

Vue.use(ElementUI)
Vue.config.productionTip = false
window.bus = new Vue();

axios.interceptors.request.use(
  config => {
    if (sessionStorage.getItem('Authorization')) {
      config.headers.Authorization = sessionStorage.getItem('Authorization');
    }

    return config;
  },
  error => {
    return Promise.reject(error);
  });

router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    next();
  } else {
    let token = sessionStorage.getItem('Authorization');
    if (token === 'null' || token === '') {
      next('/?redirect=/login');
    } else {
      next();
    }
  }
})

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: {App}
})
