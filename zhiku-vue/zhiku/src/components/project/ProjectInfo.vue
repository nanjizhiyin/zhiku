<template>
  <div class="projectList">
    <h1>{{ title }}</h1>
    <h1>项目ID: {{ projectID }}</h1>
    <h1>项目名称: {{ projectName }}</h1>
  </div>
</template>

<script>
import $ from 'jquery'
// import router from './../../router'
export default {
  name: 'ProjectInfo',
  data () {
    return {
      title: '项目详情',
      projectID: this.$route.params.projectID,
      projectName: ''
    }
  },
  mounted () {
    this.getProjectList()
  },
  methods: {
    // 读取项目列表
    getProjectList: function () {
      var _this = this
      _this.msg = '获取中...'
      $.ajax({
        url: 'http://127.0.0.1:8088/project/info',
        type: 'get',
        dataType: 'json',
        async: false, // 默认为true 异步
        data: 'projectID=' + _this.projectID,
        error: function (e) {
          alert('出错了:' + e)
        },
        success: function (data) {
          // 处理反馈结果
          var errorcode = data['errorcode']
          if (errorcode === '0') {
            var result = data['result']
            _this.projectName = result['projectName']
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
