<template>
  <h4>添加用户</h4>
  <el-form label-width="100px" style="width: 350px" size="small">
    <el-form-item label="编号：">
      <el-input v-model="user.userId"></el-input>
    </el-form-item>
    <el-form-item label="用户名：">
      <el-input v-model="user.userName"></el-input>
    </el-form-item>
    <el-form-item label="用户角色:">
      <el-select v-model="user.userRoleId" placeholder="请选择角色">
        <el-option
            v-for="role in roles"
            :key="role.id"
            :value="role.id"
            :label="role.name"
        >
        </el-option>
      </el-select>
      <!--      <el-input v-model="user.userRoleId"></el-input>-->
    </el-form-item>
    <el-form-item >
      <el-button type="primary" @click="add">提交</el-button>
      <el-button type="default" @click="reset">重置</el-button>
    </el-form-item>
  </el-form>
  <!--  <table width="150" border="1">
      <tr>
        <td>编号：</td>
        <td><input v-model="user.userId"></td>
      </tr>
      <tr>
        <td>用户名：</td>
        <td><input v-model="user.username"></td>
      </tr>
      <tr>
        <td>角色：</td>
        <td><input v-model="user.userRoleId"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="button" value="提交" @click="add"></td>
      </tr>
    </table>-->
</template>

<script>
export default {
  name: "EditSysUser",
  data(){
    return {
      user:{},
      roles:[]
    }
  },
  methods:{
    add(){
      let url = "sysuser";
      this.$http.post(url,this.user).then(resp=>{
        if(resp.data.data == 1){
          // alert("更新成功！")
          this.$router.push("/SysUser")
        }
      });
    },
    reset(){
      /*this.user.userId = "";
      this.user.username = "";
      this.user.userRoleId = "";*/
      this.user = {}
    }
  },
  created() {
    this.roles = [
      {id:1,name:"高管"},
      {id:2,name:"销售主管"},
      {id:3,name:"客户经理"},
      {id:4,name:"系统管理员"}
    ]
  }
}
</script>

<style scoped>

</style>