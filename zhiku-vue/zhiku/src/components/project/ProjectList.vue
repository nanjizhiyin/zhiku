<template>
  <div class="projectList">
    <h1>{{ msg }}</h1>
    <ul id="example-1">
      <li v-for = "item in items">
        {{ item.projectName }}
      </li>
    </ul>
    <button @click="getProjectList">登录</button>
  </div>
</template>

<script>
import $ from 'jquery'
export default {
  name: 'ProjectList',
  data () {
    return {
      msg: 'ProjectList',
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
    // 读取项目列表
    getProjectList: function () {
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
            var tmpList = []
            for (var item in result) {
              tmpList.push({'projectID': item['projectID'], 'projectName': item['projectName']})
            }
            this.msg = 'sfsfafasf'
            this.items = tmpList
            alert(this.msg)
            // this.$set(this.msg, 'result')
            // this.set(this.msg, 'result')
            // this.$set(this, 'items', result)
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
