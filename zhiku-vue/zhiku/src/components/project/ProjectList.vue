<template>
  <div class="projectList">
    <h1>{{ msg }}</h1>

    <div>SecondFirst</div>
  </div>
</template>

<script>
import $ from 'jquery'
export default {
  name: 'ProjectList',
  data () {
    return {
      msg: 'ProjectList'
    }
  },
  methods: {
    // 读取项目列表
    getProjectList: function () {
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
            alert('登录成功')
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
