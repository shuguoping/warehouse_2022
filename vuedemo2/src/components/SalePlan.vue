<template>

  <el-steps :active="1"  simple style="margin-top: 5px">
    <el-step title="营销管理" />
    <el-step title="销售计划管理" />
  </el-steps>

  <h4>销售计划管理</h4>


  <el-form :inline="true" size="small">
    <el-form-item label="执行内容：">
      <el-input v-model="todo"></el-input>
    </el-form-item>

    <el-form-item label="所属销售机会编号：">
      <el-input v-model="chcid"></el-input>
    </el-form-item>


    <el-form-item>
      <el-button type="danger" @click="clearForm">清空</el-button>
      <el-button @click="showData">查询</el-button>
      <el-button @click="add">新建</el-button>


    </el-form-item>
  </el-form>

  <el-table :data="pageInfo.list" stripe :header-cell-style="{textAlign: 'center'}" :cell-style="{textAlign: 'center'}">
    <el-table-column prop="id" label="编号" width="80"></el-table-column>
    <el-table-column prop="chcid" label="所属销售机会编号" width="270"></el-table-column>
    <el-table-column prop="todo" label="执行内容" width="360"></el-table-column>

    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" type="primary" @click="edit(scope.row.id)">编辑</el-button>
        <el-button size="small" type="warning" @click="del(scope.row.id)">删除</el-button>
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

</template>

<script>
export default {
  name: "SysUser",
  data(){
    return {
      pageInfo:{},
      num:1,
      todo:'',
      chcid:[],
      isShow:false,
      plan:{},
      editIndex:-1,
      radio1:"2"
    }
  },
  created() {
    this.showData();
  },
  methods:{
    del(id){
      console.log(id)
      this.$confirm("是否删除？","提示").then(()=>{
        let url = "saleplan/"+id;
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
      let url = "saleplan/getPaged";
      this.$http.get(url,{params:{
          pageNum:this.pageInfo.pageNum,
          pageSize:this.pageInfo.pageSize,
          todo:this.todo,
          chcid:this.chcid
        }})
          .then(resp=>{
            this.pageInfo = resp.data.data;
          });
    },
    edit(id){
      this.$router.push({path:'/EditSalePlan',query:{id:id}})
    },
    add(){
      this.$router.push("/AddSalePlan");
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
    clearForm(){
      this.todo = "";
      this.chcid = [];
    },
    cancel(){
      this.isShow = false;
      this.plan = {}
    },
    update(){
      let url = "saleplan";
      this.$http.put(url,this.plan).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'更新成功！',
            type:"success"
          });
          this.isShow = false;
          this.pageInfo.list[this.editIndex] = {...this.plan};
        }
      });
    },
    insert(){
      let url = "saleplan";
      this.$http.post(url,this.plan).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'添加成功！',
            type:"success"
          });
          this.isShow = false;
          this.showData();
          this.plan = {}
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