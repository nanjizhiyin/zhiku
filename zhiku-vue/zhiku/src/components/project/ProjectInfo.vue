<template>
  <div class="projectList">
    <h1>{{ title }}</h1>
    <h3>项目名称: {{ projectName }}</h3>
    <div>数据表名称: <input type="text" id="tableName"/></div>
    <h3>字段列表:</h3>
    <div id="fieldList">
      <button @click="addField()">添加字段</button>
      <div id="field">
        <span>字段:<input type="text" id="fieldName"/></span>
        <span>数据类型:<input type="text" id="dataType"/></span>
        <span>长度:<input type="text" id="length"/></span>
        <span>主键:<input type="text" id="p"/></span>
        <span>外键:<input type="text" id="f"/></span>
        <span>非空:<input type="text" id="m"/></span>
      </div>
    </div>
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
    //  添加字段
    addField: function () {
      var tmpHtml = '<div id="field">'
      tmpHtml += '<span>字段:<input type="text" id="fieldName"/></span>'
      tmpHtml += '<span>数据类型:<input type="text" id="dataType"/></span>'
      tmpHtml += '<span>长度:<input type="text" id="length"/></span>'
      tmpHtml += '<span>主键:<input type="text" id="p"/></span>'
      tmpHtml += '<span>外键:<input type="text" id="f"/></span>'
      tmpHtml += '<span>非空:<input type="text" id="m"/></span>'
      tmpHtml += '<button id="removeField">减少</button>'
      tmpHtml += '</div>'
      $('#fieldList').append(tmpHtml)
      $('#removeField').unbind().click(function () {
        // $(this).parent().remove()
        $(this).parentNode.removeChild($(this))
      })
    },
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
