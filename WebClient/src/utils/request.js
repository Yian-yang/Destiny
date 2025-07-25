import axios from 'axios'
import router from '@/router/router.js'
import { ElNotification } from 'element-plus'

const baseURL = 'http://localhost:9999' // 本地
// const baseURL = '' // 服务器

const instance = axios.create({
  baseURL, // 基础地址
  timeout: 300 * 1000 // 接口超时时间（单位：毫秒）
})

// 请求拦截器
instance.interceptors.request.use(

  (config) => {
    // 设置允许跨域的域名，*代表允许任意域名跨域
    // config.setHeader('Access-Control-Allow-Origin', '*');

    // 判断请求头
    // const useStore = useUserStore();
    // if (useStore.token) {
    //   config.headers.Authorization = useStore.token; // 添加请求头
    // }

    return config;

  },
  (err) => {
    Promise.reject(err);
  }
)

// 响应拦截器
instance.interceptors.response.use(
  (res) => {
    // 处理响应数据
    if (String(res.data.code) == '200') {
      return res;
    } else {
      return ElNotification({
        type: 'error',
        title: '提示',
        message: res.data.msg,
        duration: 2000,
        offset: 80,
        position: 'top-right',
        dangerouslyUseHTMLString: true
      })
    }

    // 放行所有响应数据
    // return res;

  },
  (err) => {
    if (err.response?.status == 401 || err.response?.status == 1) {
      router.push('/err');
    }

    // 处理错误
    ElNotification({
      type: 'error',
      title: '提示',
      message: '请稍后重试',
      duration: 3000,
      offset: 80,
      position: 'top-right',
      dangerouslyUseHTMLString: true
    })

    Promise.reject(err);
  }
)

export default instance;
export { baseURL };
