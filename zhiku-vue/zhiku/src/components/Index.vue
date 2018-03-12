<template>
  <div class="index">
    <h1>{{msg}}</h1>
    <br />
  <div>
      <button @click="goLogin">登录</button>
      <button @click="goReister">注册</button>
      <button @click="projectList">项目列表</button>
      <button @click="goLogout">退出</button>
  </div>
  </div>
</template>

<script>
import router from './../router'
import $ from 'jquery'
export default {
  name: 'Index',
  data () {
    return {
      msg: '欢迎使用智库系统'
    }
  },
  methods: {
    // 注册
    goReister: function () {
      // 跳转到注册界面
      router.push('/register')
    },
    // 登录
    goLogin: function () {
      router.push('/login')
    },
    // 项目列表
    projectList: function () {
      router.push('/projectlist')
    },
    // 退出
    goLogout: function () {
      $.ajax({
        url: 'http://127.0.0.1:8088/user/logout',
        async: false, // 默认为true 异步
        error: function (e) {
          alert('出错了111:' + e)
        },
        success: function (data) {
          router.push('/')
        }
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
