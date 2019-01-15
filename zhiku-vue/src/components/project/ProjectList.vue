<template>
  <div class="projectInfo">
    <h1>{{ msg }}</h1>
    <ul id="example-1">
      <li @click="goProjectInfo(item)" v-for = "item in items">
        {{ item.projectID }} ----- {{ item.projectName }} >>
      </li>
    </ul>
    <button @click="getProjectList">获取列表</button>
  </div>
</template>
<script>
import $ from 'jquery'
import router from './../../router'
export default {
  name: 'ProjectInfo',
  data () {
    return {
      msg: 'ProjectInfo',
      items: [
        { projectID: '1', projectName: 'Foo' },
        { projectID: '2', projectName: 'Bar' }
      ]
    }
  },
  mounted () {
    this.getProjectList()
  },
  methods: {
    // 打开项目详情页
    goProjectInfo: function (item) {
      router.push('/projectInfo/' + item.projectID)
    },
    // 读取项目列表
    getProjectList: function () {
      var _this = this
      _this.msg = '获取列表中...'
      $.ajax({
        url: 'http://127.0.0.1:8088/project/list',
        type: 'get',
        dataType: 'json',
        async: false, // 默认为true 异步
        data: 'page=' + 1 + '&pageSize=' + 11,
        error: function (e) {
          alert('出错了:' + e)
        },
        success: function (data) {
          // 处理反馈结果
          var errorcode = data['errorcode']
          if (errorcode === '0') {
            var result = data['result']
            _this.msg = '获取列表成功'
            _this.items = result
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
a {
  color: #42b983;
}
</style>
