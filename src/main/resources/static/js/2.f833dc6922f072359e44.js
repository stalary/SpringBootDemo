webpackJsonp([2],{oeCJ:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});n("gCkU");var a=n("zL8q"),l={methods:{logout:function(){var t=this;this.$confirm("确定退出登录吗？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.$http({url:"http://120.24.5.178:8100/user/logout",method:"GET",headers:{"Content-Type":"application/json"},withCredentials:!0}).then(function(t){console.log(t.data.code),0===t.data.code?(a.Message.success("退出成功！"),this.$router.push({name:"login"})):a.Message.warning(t.data.msg)})})},deleteRow:function(t,e){this.$http({url:""}),e.splice(t,1)}},data:function(){return{tableData4:[{id:"1",name:"java",author:"111"}]}}},o={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("add"),t._v(" "),n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData4,"max-height":"250"}},[n("el-table-column",{attrs:{prop:"id",label:"图书编号",align:"center"}}),t._v(" "),n("el-table-column",{attrs:{prop:"name",label:"图书名称",align:"center"}}),t._v(" "),n("el-table-column",{attrs:{prop:"author",label:"作者",align:"center"}}),t._v(" "),n("el-table-column",{attrs:{fixed:"right",label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(n){n.preventDefault(),t.deleteRow(e.$index,t.tableData4)}}},[t._v("\n          移除\n        ")])]}}])})],1),t._v(" "),n("el-button",{staticStyle:{float:"right",margin:"5%"},on:{click:t.logout}},[t._v("退出登录")])],1)},staticRenderFns:[]},i=n("VU/8")(l,o,!1,null,null,null);e.default=i.exports}});
//# sourceMappingURL=2.f833dc6922f072359e44.js.map