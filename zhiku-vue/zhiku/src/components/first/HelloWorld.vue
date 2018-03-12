<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>HelloWorld</div>
    <br />
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'HelloWorld'
    }
  }
}
</script>
<style scoped>
  @import 'xpfirst.css';
</style>
