<template>
  <div class="register">
    <button @click="goIndex">智库</button>
    <h1>{{msg}}</h1>
    <div>
    <label>用户名: </label><input id="username" />
    </div>
    <br />
    <div>
    <label>密  码: </label><input id="password" />
    </div>
    <br />
    <button @click="goLogin">已有账号去登录</button>
    <button @click="goReister">注册</button>
  </div>
</template>

<script>
import $ from 'jquery'
import router from './../../router'
export default {
  name: 'Register',
  data () {
    return {
      msg: '注册'
    }
  },
  methods: {
    // 首页
    goIndex: function () {
      // 跳转到首页
      router.push('/')
    },
    // 注册
    goReister: function () {
      // 跳转到注册界面
      var username = $('#username').val()
      var password = $('#password').val()
      $.ajax({
        url: 'http://127.0.0.1:8088/user/register',
        type: 'post',
        data: 'username=' + username + '&password=' + password,
        dataType: 'json',
        async: false, // 默认为true 异步
        error: function () {
          alert('error')
        },
        success: function (data) {
          // 处理反馈结果
          alert('success')
        }
      })
    },
    // 登录
    goLogin: function () {
      router.push('/login')
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
