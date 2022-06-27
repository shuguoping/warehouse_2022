<template>

  <el-steps :active="1"  simple style="margin-top: 5px">
    <el-step title="基础数据" />
    <el-step title="数据字典-企业客户等级" />
  </el-steps>

  <h4>企业客户等级</h4>

  <el-table :data="pageInfo.list" stripe :header-cell-style="{textAlign: 'center'}" :cell-style="{textAlign: 'center'}">
    <el-table-column prop="id" label="编号" width="250"></el-table-column>
    <el-table-column prop="name" label="客户等级名称(可编辑)" width="250"></el-table-column>

    <el-table-column label="对应值(不可编辑)" width="250">
      <template #default="scope">
        {{getId(scope.row.id)}}
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" type="warning" @click="del(scope.row.id)">删除</el-button>
        <el-button size="small" type="primary" @click="edit(scope.row.id)">编辑</el-button>
        <el-button size="small" type="primary" @click="save(scope.row.id)">保存</el-button>
      </template>
    </el-table-column>
  </el-table>

  <br>
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
          <el-form-item label="客户等级编号：">
            <template v-if="title == '编辑客户等级'">
              {{level.id}}
            </template>
            <template v-else>
              <el-input v-model="level.id"></el-input>
            </template>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="客户等级名称：">
            <el-input v-model="level.name"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>

    <template #footer>
      <el-button type="warning" @click="cancel">取消</el-button>
      <template v-if="title=='编辑客户等级'">
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
  name: "SysUser",
  data(){
    return {
      pageInfo:{},
      num:1,
      ids:[],
      name:'',
      isShow:false,
      level:{},
      editIndex:-1,
      title:'编辑客户等级',
    }
  },
  created() {
    this.ids = [
      {id:1,newlevelid:"1"},
      {id:2,newlevelid:"2"},
      {id:3,newlevelid:"3"},
      {id:4,newlevelid:"4"},
      {id:5,newlevelid:"5"}
    ]
    this.showData();

  },
  methods:{
    del(id){
      console.log(id)
      this.$confirm("是否删除？","提示").then(()=>{
        let url = "dataclientlevel/"+id;
        this.$http.delete(url).then(resp=>{
          if(resp.data.data == 1){
            this.$message({message:"删除成功！",type:'success'})

            this.showData();
          }else{
            // alert("删除失败！")
            this.$message.error("删除失败！")
          }
        });
      })
    },
    showData(){
      let url = "dataclientlevel/getPaged";
      this.$http.get(url,{params:{
          pageNum:this.pageInfo.pageNum,
          pageSize:this.pageInfo.pageSize,
          name:this.name,
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
    getId(levelId){
      let newlevelid ;
      if(levelId == 1){
        newlevelid = "1";
      }else if(levelId == 2){
        newlevelid = "2";
      }else if(levelId == 3){
        newlevelid = "3";
      }else if(levelId == 4){
        newlevelid = "4";
      }else if(levelId == 5){
        newlevelid = "5";
      }

      return newlevelid;
    },
    edit(id,index){
      let url = "dataclientlevel/"+id;
      this.$http.get(url).then(resp=>{
        this.level = resp.data.data;
        this.isShow = true;
        this.editIndex = index;
      });
    },
    save(){
      this.$message({message:"保存成功！",type:'success'})
    },
    cancel(){
      this.isShow = false;
      this.level = {}
    },
    update(){
      let url = "dataclientlevel";
      this.$http.put(url,this.level).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'更新成功！',
            type:"success"
          });
          this.isShow = false;
          this.pageInfo.list[this.editIndex] = {...this.level};
          // alert("更新成功！")
          // this.$router.push("/SysUser")
        }
      });
    },
  }
}
</script>

<style scoped>
a{
  text-decoration: none;
}
</style>