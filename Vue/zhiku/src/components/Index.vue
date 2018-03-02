<template>
  <div class="index">
    <div>
        <button @click="goLogin">登录</button>
        <button @click="goReister">注册</button>
    </div>
    <h1>{{msg}}</h1>
    <br />
  </div>
</template>

<script>
import router from './../router'
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
