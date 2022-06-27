<template>
  <h4>用户及权限管理</h4>
  <el-radio-group v-model="radio1" >
    <el-radio label="1" size="large">Option 1</el-radio>
    <el-radio label="2" size="large">Option 2</el-radio>
  </el-radio-group>
  <el-form :inline="true" size="small">
    <el-form-item label="用户名：">
      <el-input v-model="userName"></el-input>
    </el-form-item>
    <el-form-item label="角色：">
      <el-select  placeholder="请选择角色" v-model="userRoleId">
        <el-option label="全部" value="0"></el-option>
        <el-option
            v-for="role in roles"
            :key="role.id"
            :value="role.id"
            :label="role.name"
        >
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" @click="clearForm">清空</el-button>
      <el-button @click="showData">查询</el-button>
      <el-button @click="add">新建</el-button>
      <el-button @click="add2">新建2</el-button>
    </el-form-item>
  </el-form>

  <el-table :data="pageInfo.list" stripe>
    <el-table-column prop="userId" label="编号" width="180"></el-table-column>
    <el-table-column prop="userName" label="用户名" width="260"></el-table-column>
    <el-table-column prop="userRoleId" label="角色" width="180"></el-table-column>
    <el-table-column label="角色名" width="180">
      <template #default="scope">
        {{getRoleName(scope.row.userRoleId)}}
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" type="primary" @click="edit(scope.row.userId)">编辑</el-button>
        <el-button size="small" type="warning" @click="del(scope.row.userId)">删除</el-button>
        <el-button size="small" type="primary" @click="edit2(scope.row.userId)">编辑2</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-pagination
      v-model:currentPage="pageInfo.pageNum"
      :page-size="pageInfo.pageSize"
      :background="true"
      :page-sizes="[3, 5, 10]"
      layout="total,sizes,prev, pager, next,jumper"
      :total="pageInfo.total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
  />

  <el-dialog :title="title" v-model="isShow" center width="500px">
    <el-form size="small">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="编号：">
            <template v-if="title == '编辑用户'">
              {{user.userId}}
            </template>
            <template v-else>
              <el-input v-model="user.userId"></el-input>
            </template>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用户名：">
            <el-input v-model="user.userName"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="角色：">
            <el-select  placeholder="请选择角色" v-model="user.userRoleId">
              <el-option
                  v-for="role in roles"
                  :key="role.id"
                  :value="role.id"
                  :label="role.name"
              >
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <template #footer>
      <el-button type="warning" @click="cancel">取消</el-button>
      <template v-if="title=='编辑用户'">
        <el-button type="primary" @click="update">提交</el-button>
      </template>
      <template v-else>
        <el-button type="primary" @click="insert">提交</el-button>
      </template>
    </template>
  </el-dialog>
  <!--  <input type="button" value="添加" @click="add">
    <table border="1" width="600">
      <thead>
        <tr>
          <th>编号</th>
          <th>用户名</th>
          <th>角色</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(user,index) in pageInfo.list" :key="index">
          <td>{{user.userId}}</td>
          <td>{{user.userName}}</td>
          <td>{{user.userRoleId}}</td>
          <td>
            <input type="button" value="编辑" @click="edit(user.userId)">
            <input type="button" value="删除" @click="del(user.userId)">
          </td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="4" align="center">
              <span v-show="pageInfo.hasPreviousPage">
                <a href="#" @click="changePageNum(pageInfo.navigateFirstPage)">首页</a>&nbsp;
                <a href="#" @click="changePageNum(pageInfo.prePage)">上一页</a>
              </span>
              总{{pageInfo.pages}}页 第{{pageInfo.pageNum}}页
              <input size="1" v-model="num"><a href="#" @click="changePageNum(num)">GO</a>
              <a :key="index" v-for="(pageNum,index) in pageInfo.navigatepageNums" href="#" @click="changePageNum(pageNum)">
                [{{pageNum}}]&nbsp;
              </a>
            <span v-show="pageInfo.hasNextPage">
                <a href="#" @click="changePageNum(pageInfo.nextPage)">下一页</a>&nbsp;
                <a href="#" @click="changePageNum(pageInfo.navigateLastPage)">尾页</a>
            </span>
          </td>
        </tr>
      </tfoot>
    </table>-->
</template>

<script>
export default {
  name: "SysUser",
  data(){
    return {
      pageInfo:{},
      num:1,
      roles:[],
      userName:'',
      userRoleId:"0",
      isShow:false,
      user:{},
      editIndex:-1,
      title:'编辑用户',
      radio1:"2"
    }
  },
  created() {
    this.roles = [
      {id:1,name:"高管"},
      {id:2,name:"销售主管"},
      {id:3,name:"客户经理"},
      {id:4,name:"系统管理员"}
    ]
    this.showData();

  },
  methods:{
    del(id){
      console.log(id)
      this.$confirm("是否删除？","提示").then(()=>{
        let url = "sysuser/"+id;
        this.$http.delete(url).then(resp=>{
          if(resp.data.data == 1){
            this.$message({message:"删除成功！",type:'success'})
            // this.$message.error("删除失败！")
            // alert("删除成功！")
            //重新加载数据
            this.showData();
          }else{
            // alert("删除失败！")
            this.$message.error("删除失败！")
          }
        });
      })
      /*if(confirm("是否删除？")){
        let url = "sysuser/"+id;
        this.$http.delete(url).then(resp=>{
          if(resp.data.data == 1){
            alert("删除成功！")
            //重新加载数据
            this.showData();
          }else{
            alert("删除失败！")
          }
        });
      }*/
    },
    showData(){
      let url = "sysuser/getPaged";
      this.$http.get(url,{params:{
          pageNum:this.pageInfo.pageNum,
          pageSize:this.pageInfo.pageSize,
          userName:this.userName,
          userRoleId:this.userRoleId
        }})
          .then(resp=>{
            //resp:响应对象
            //resp.data:响应对象中的数据（Result）
            //resp.data.data:PageInfo
            this.pageInfo = resp.data.data;
          });
    },
    edit(id){
      this.$router.push({path:'/EditSysUser',query:{id:id}})
    },
    add(){
      this.$router.push("/AddSysUser");
    },
    changePageNum(pageNum){
      this.pageInfo.pageNum = pageNum;
      this.showData()
    },
    handleCurrentChange(pageNum){
      this.pageInfo.pageNum = pageNum;
      this.showData()
    },
    handleSizeChange(pageSize){
      this.pageInfo.pageSize = pageSize;
      this.showData()
    },
    getRoleName(roleId){
      let name ;
      if(roleId == 1){
        name = "高管";
      }else if(roleId == 2){
        name = "销售主管";
      }else if(roleId == 3){
        name = "客户经理";
      }else{
        name = "系统管理员";
      }

      return name;
    },
    clearForm(){
      this.userName = "";
      this.userRoleId = "0"
    },
    edit2(id,index){

      let url = "sysuser/"+id;
      this.$http.get(url).then(resp=>{
        this.user = resp.data.data;
        this.isShow = true;
        this.editIndex = index;
      });
    },
    cancel(){
      this.isShow = false;
      this.user = {}
    },
    update(){
      let url = "sysuser";
      this.$http.put(url,this.user).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'更新成功！',
            type:"success"
          });
          this.isShow = false;
          this.pageInfo.list[this.editIndex] = {...this.user};
          // alert("更新成功！")
          // this.$router.push("/SysUser")
        }
      });
    },
    add2(){
      this.isShow = true;
      this.title = "新建用户";
    },
    insert(){
      let url = "sysuser";
      this.$http.post(url,this.user).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'添加成功！',
            type:"success"
          });
          this.isShow = false;
          this.showData();
          this.user = {}

        }
      });
    }
  }
}
</script>

<style scoped>
a{
  text-decoration: none;
}
</style>