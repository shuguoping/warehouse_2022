<template>

  <el-steps :active="1"  simple style="margin-top: 5px">
    <el-step title="营销管理" />
    <el-step title="销售机会管理" />
  </el-steps>

  <h4>销售机会管理</h4>


  <el-form :inline="true" size="small">
    <el-form-item label="客户名称：">
      <el-input v-model="custname"></el-input>
    </el-form-item>

    <el-form-item label="概要：">
      <el-input v-model="title"></el-input>
    </el-form-item>

    <el-form-item label="联系人：">
      <el-input v-model="linkman"></el-input>
    </el-form-item>


    <el-form-item>
      <el-button type="danger" @click="clearForm">清空</el-button>
      <el-button @click="showData">查询</el-button>
      <el-button @click="add">新建</el-button>

      <el-button @click="$router.go(-1)">全部</el-button>

    </el-form-item>
  </el-form>

  <el-table :data="pageInfo.list" stripe>
    <el-table-column prop="id" label="编号" width="80"></el-table-column>
    <el-table-column prop="custname" label="客户名称" width="270"></el-table-column>
    <el-table-column prop="title" label="概要" width="290"></el-table-column>
    <el-table-column prop="linkman" label="联系人" width="100"></el-table-column>
    <el-table-column prop="tel" label="联系人电话" width="190"></el-table-column>
    <el-table-column prop="createdate" label="创建时间" width="150"></el-table-column>



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
      custname:'',
      title:'',
      linkman:'',
      isShow:false,
      user:{},
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
        let url = "salechance/"+id;
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
      let url = "salechance/getPaged";
      this.$http.get(url,{params:{
          pageNum:this.pageInfo.pageNum,
          pageSize:this.pageInfo.pageSize,
          custname:this.custname,
          title:this.title,
          linkman:this.linkman,
        }})
          .then(resp=>{
            this.pageInfo = resp.data.data;
          });
    },
    edit(id){
      this.$router.push({path:'/EditSaleChance',query:{id:id}})
    },
    add(){
      this.$router.push("/AddSaleChance");
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
      this.custname = "";
      this.title = "";
      this.linkman = "";
    },
    cancel(){
      this.isShow = false;
      this.user = {}
    },
    update(){
      let url = "salechance";
      this.$http.put(url,this.user).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'更新成功！',
            type:"success"
          });
          this.isShow = false;
          this.pageInfo.list[this.editIndex] = {...this.user};
        }
      });
    },
    insert(){
      let url = "salechance";
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