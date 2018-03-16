<template>
  <div class="projectList">
    <h1>{{ title }}</h1>
    <h3>项目名称: {{ projectName }}</h3>
    <div>数据表名称: <input type="text" id="tableName"/></div>
    <h3>字段列表:</h3>
    <div id="fieldList">
      <div>
        <span>字段:<input type="text" id="fieldName" value="1"/></span>
        <span>数据类型:<input type="text" id="dataType" value="2"/></span>
        <span>长度:<input type="text" id="length" value="3"/></span>
        <span>主键:<input type="text" id="primary"/></span>
        <span>外键:<input type="text" id="foreign"/></span>
        <span>非空:<input type="text" id="mandatory"/></span>
      </div>
    </div>
    <button @click="addField()">添加字段</button>
    <button @click="saveField()">保存</button>
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
      projectName: '',
      fields: [0]
    }
  },
  mounted () {
    this.getProjectList()
  },
  methods: {
    // 保存字段
    saveField: function () {
      var tmpList = []
      var tmpDivs = $('#fieldList').children('div')
      var tmpLen = tmpDivs.length
      for (var i = 0; i < tmpLen; i++) {
        // 字段名
        var fieldName = $(tmpDivs[i]).find("[id='fieldName']").val()
        var dataType = $(tmpDivs[i]).find("[id='dataType']").val()
        var length = $(tmpDivs[i]).find("[id='length']").val()
        var primary = $(tmpDivs[i]).find("[id='primary']").val()
        var foreign = $(tmpDivs[i]).find("[id='foreign']").val()
        var mandatory = $(tmpDivs[i]).find("[id='mandatory']").val()
        if (fieldName === '' || dataType === '' || length === '') {
          alert('数据不能为空,请确认后再保存')
          return
        }
        var tmpDic = {}
        tmpDic['fieldName'] = fieldName
        tmpDic['dataType'] = dataType
        tmpDic['length'] = length
        tmpDic['primary'] = primary
        tmpDic['foreign'] = foreign
        tmpDic['mandatory'] = mandatory
        tmpList.push(tmpDic)
        // 上传数据
        var _this = this
        _this.msg = '获取中...'
        $.ajax({
          url: 'http://127.0.0.1:8088/project/' + _this.projectID + '/save',
          type: 'put',
          contenttype: 'application/json;charset=UTF-8',
          error: function (XMLHttpRequest, textStatus, errorThrown) {
            //   // 状态码
            // alert(XMLHttpRequest.status)
            // // 状态
            // alert(XMLHttpRequest.readyState)
            // 错误信息
            // alert(textStatus)
          },
          success: function (data) {
            // 处理反馈结果
            alert('OK')
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
    },
    // 添加字段
    addField: function () {
      // 获取id=fieldList下的span元素个数
      var tmpHtml = '<div>'
      tmpHtml += '<span>字段:<input type="text" id="fieldName"/></span>'
      tmpHtml += '<span>数据类型:<input type="text" id="dataType"/></span>'
      tmpHtml += '<span>长度:<input type="text" id="length"/></span>'
      tmpHtml += '<span>主键:<input type="text" id="primary"/></span>'
      tmpHtml += '<span>外键:<input type="text" id="foreign"/></span>'
      tmpHtml += '<span>非空:<input type="text" id="mandatory"/></span>'
      tmpHtml += '<button class="removeField">减少</button>'
      tmpHtml += '</div>'
      // 添加控件
      $('#fieldList').append(tmpHtml)
        // 删除控件
      $('.removeField').click(function () {
        $(this).parent().remove()
      })
    },
    // 读取项目列表
    getProjectList: function () {
      var _this = this
      _this.msg = '获取中...'
      $.ajax({
        url: 'http://127.0.0.1:8088/project/' + _this.projectID + '/info',
        type: 'get',
        dataType: 'json',
        async: false, // 默认为true 异步
        error: function (XMLHttpRequest, textStatus, errorThrown) {
          // 状态码
          alert(XMLHttpRequest.status)
          // 状态
          alert(XMLHttpRequest.readyState)
          // 错误信息
          alert(textStatus)
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
