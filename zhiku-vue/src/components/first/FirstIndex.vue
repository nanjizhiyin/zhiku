<template>
  <div class="XPFirst">
    <h1>{{ msg }}</h1>
    <div>Index</div>
    <br />
    <router-link to="/first/">FirstIndex</router-link>
    <router-link to="/first/helloworld/">HelloWorld</router-link>
    <router-link to="/first/xpfirst/">xpfirst</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'FirstIndex',
  data () {
    return {
      msg: 'FirstIndex欢迎你'
    }
  }
}
</script>
<style scoped>
@import 'xpfirst.css';
</style>
