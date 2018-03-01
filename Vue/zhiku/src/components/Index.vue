<template>
  <div class="hello">
    <h1>{{msg}}</h1>
    <div>
    <label>用户名: </label><input id="username" />
    </div>
    <br />
    <div>
    <label>密  码: </label><input id="password" />
    </div>
    <br />
    <button id="loginBt">登录</button>
    <button id="registerBt">注册</button>
  </div>
</template>

<script>
import $ from 'jquery'
export default {
  name: 'Index',
  data () {
    return {
      msg: '登录'
    }
  }
}

$(document).ready(function () {
  // 登录
  $('#loginBt').click(function () {
    var username = $('#username').val()
    var password = $('#password').val()
    $.ajax({
      url: 'http://127.0.0.1:8088/user/login',
      type: 'post',
      data: 'username=' + username + '&password=' + password,
      dataType: 'json',
      async: false, // 默认为true 异步
      error: function () {
        alert('error')
      },
      success: function (data) {
        alert('success')
      }
    })
  })
  // 注册
  $('#registerBt').click(function () {
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
        alert('success')
      }
    })
  })
})
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
