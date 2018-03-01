<template>
  <div class="XPFirst">
    <h1>{{ msg }}</h1>
    <div>XPFirst</div>
    <br />
  </div>
</template>

<script>
export default {
  name: 'XPFirst',
  data () {
    return {
      msg: 'xpfirst欢迎你'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import 'xpfirst.css';
</style>
