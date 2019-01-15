<template>
  <div class="login">
    <button @click="goIndex">智库</button>
    <h1>{{msg}}</h1>
    <div>
    <label>用户名: </label><input id="username" value="111111"/>
    </div>
    <br />
    <div>
    <label>密  码: </label><input id="password" value="111111"/>
    </div>
    <br />
    <button @click="goLogin">登录</button>
    <button @click="goReister">没有账号去注册</button>
  </div>
</template>

<script>
import $ from 'jquery'
import router from './../../router'
export default {
  name: 'Login',
  data () {
    return {
      msg: '登录'
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
      router.push('/register')
    },
    // 登录
    goLogin: function () {
      var username = $('#username').val()
      var password = $('#password').val()
      $.ajax({
        url: 'http://127.0.0.1:8088/user/login',
        type: 'post',
        data: 'username=' + username + '&password=' + password,
        dataType: 'json',
        async: false, // 默认为true 异步
        error: function (e) {
          alert('出错了:' + e)
        },
        success: function (data) {
          // 处理反馈结果
          var errorcode = data['errorcode']
          if (errorcode === '0') {
            console.log('登录成功')
            var token = data.result.token
            let expireDays = 1000 * 60 * 60
            this.setCookie('token', token, expireDays)
            
            var d = new Date()
            d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000))
            var expires = "expires=" + d.toUTCString()
            console.info(cname + "=" + cvalue + "; " + expires)
            document.cookie = cname + "=" + cvalue + "; " + expires
            console.info(document.cookie)

            router.push('/projectlist')
          } else {
            var errormsg = data['errormsg']
            alert('错误: ' + errormsg)
          }
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
