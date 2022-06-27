import { createApp } from 'vue'
//导入，默认导出的数据，在其他模块中使用的时候，可以任意起名
import App from './App.vue'
import VueRouter from './router/index'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'


import axios from 'axios'
axios.defaults.baseURL="http://localhost:8081/"
//允许传递证书（cookie）
axios.defaults.withCredentials=true

let app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
//把VueRouter对象插入到当前Vue实例中
app.use(VueRouter)
app.use(ElementPlus)
app.config.globalProperties.$http=axios
app.mount('#app')