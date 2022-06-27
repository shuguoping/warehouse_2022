<template>
  <h4>销售机会管理</h4>
  <el-form :inline="true" size="small">

    <el-form-item label="客户名称：">
      <el-input v-model="userName"></el-input>
    </el-form-item>

    <el-form-item label="概要：">
      <el-input v-model="userName"></el-input>
    </el-form-item>

    <el-form-item label="联系人：">
      <el-input v-model="userName"></el-input>
    </el-form-item>

    <el-form-item label="角色：">
      <el-select  placeholder="请选择角色" v-model="userRoleId">
        <el-option label="全部" value="0"></el-option>
        <el-option
            v-for="status in statuss"
            :key="status.id"
            :value="status.id"
            :label="status.name"
        >
        </el-option>
      </el-select>
    </el-form-item>

    <el-form-item>
      <el-button type="danger" @click="clearForm">清空</el-button>
      <el-button @click="showData">查询</el-button>
      <el-button @click="add">新建</el-button>
    </el-form-item>
  </el-form>

  <el-table :data="pageInfo.list" stripe>
    <el-table-column prop="userId" label="销售机会编号" width="150"></el-table-column>
    <el-table-column prop="userName" label="客户名称" width="200"></el-table-column>
    <el-table-column prop="userRoleId" label="概要" width="200"></el-table-column>
    <el-table-column prop="userRoleId" label="联系人" width="100"></el-table-column>
    <el-table-column prop="userRoleId" label="联系人电话" width="180"></el-table-column>
    <el-table-column prop="userRoleId" label="创建时间" width="150"></el-table-column>

    <el-table-column label="销售机会状态" width="120">
      <template #default="scope">
        {{getStatusName(scope.row.userRoleId)}}
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" type="warning" @click="del(scope.row.userId)">删除</el-button>
        <el-button size="small" type="primary" @click="edit(scope.row.userId)">编辑</el-button>
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
            <template v-if="title == '编辑销售机会'">
              {{chance.userId}}
            </template>
            <template v-else>
              <el-input v-model="chance.userId"></el-input>
            </template>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用户名：">
            <el-input v-model="chance.userName"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="角色：">
            <el-select  placeholder="请选择角色" v-model="chance.userRoleId">
              <el-option
                  v-for="status in statuss"
                  :key="status.id"
                  :value="status.id"
                  :label="status.name"
              >
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>

    <template #footer>
      <el-button type="warning" @click="cancel">取消</el-button>
      <template v-if="title=='编辑销售机会'">
        <el-button type="primary" @click="update">提交</el-button>
      </template>
      <template v-else>
        <el-button type="primary" @click="insert">提交</el-button>
      </template>
    </template>
  </el-dialog>
</template>

<script>
export default {
  name: "SaleChance",
  data(){
    return {
      pageInfo:{},
      num:1,
      statuss:[],
      userName:'',
      userRoleId:"0",
      isShow:false,
      chance:{},
      editIndex:-1,
      title:'编辑销售机会',
      radio1:"2"
    }
  },
  created() {
    this.statuss = [
      {id:1,name:"未分配"},
      {id:2,name:"开发中"},
      {id:3,name:"开发成功"},
      {id:4,name:"开发失败"}
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
            this.showData();
          }else{
            this.$message.error("删除失败！")
          }
        });
      })
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
            this.pageInfo = resp.data.data;
          });
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
    getStatusName(statusId){
      let name ;
      if(statusId == 1){
        name = "未分配";
      }else if(statusId == 2){
        name = "开发中";
      }else if(statusId == 3){
        name = "开发成功";
      }else{
        name = "开发失败";
      }
      return name;
    },
    clearForm(){
      this.userName = "";
      this.userRoleId = "0"
    },
    edit(id,index){
      let url = "sysuser/"+id;
      this.$http.get(url).then(resp=>{
        this.chance = resp.data.data;
        this.isShow = true;
        this.editIndex = index;
      });
    },
    cancel(){
      this.isShow = false;
      this.chance = {}
    },
    update(){
      let url = "sysuser";
      this.$http.put(url,this.chance).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'更新成功！',
            type:"success"
          });
          this.isShow = false;
          this.pageInfo.list[this.editIndex] = {...this.chance};
        }
      });
    },
    add(){
      this.isShow = true;
      this.title = "新建销售机会";
    },
    insert(){
      let url = "sysuser";
      this.$http.post(url,this.chance).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'添加成功！',
            type:"success"
          });
          this.isShow = false;
          this.showData();
          this.chance = {}
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