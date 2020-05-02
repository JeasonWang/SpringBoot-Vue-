import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
const store = new Vuex.Store({
  state: {
    // 存储token
    Authorization: sessionStorage.getItem('Authorization') ? sessionStorage.getItem('Authorization') : ''
  },
  mutations: {
    // 修改token，并将token存入sessionStorage
    changeLogin (state, token) {
      state.Authorization = token.Authorization;
      sessionStorage.setItem('Authorization', token.Authorization);
    }
  }
});

export default store;
