import './assets/common.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router';
import axios from 'axios';

const app = createApp(App)
// createApp(App).mount('#app')
app.config.globalProperties.$axios = axios; //전역변수로 설정 어디서든 this.$axios로 호출가능하게
app.config.globalProperties.$serverUrl = '//localhost:8080' //전역변수로 설정 어디서든 this.$serverUrl 호출가능하게
app.use(router).mount('#app')