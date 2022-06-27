<template>

  <el-steps :active="1"  simple style="margin-top: 5px">
    <el-step title="基础数据" />
    <el-step title="数据字典-服务类型" />
  </el-steps>

  <h4>服务类型</h4>

  <el-table :data="pageInfo.list" stripe :header-cell-style="{textAlign: 'center'}" :cell-style="{textAlign: 'center'}">
    <el-table-column prop="id" label="编号" width="250"></el-table-column>
    <el-table-column prop="name" label="服务类型名称(可编辑)" width="250"></el-table-column>

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
          <el-form-item label="服务类型编号：">
            <template v-if="title == '编辑服务类型'">
              {{type.id}}
            </template>
            <template v-else>
              <el-input v-model="type.id"></el-input>
            </template>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="客户服务类型：">
            <el-input v-model="type.name"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>

    <template #footer>
      <el-button type="warning" @click="cancel">取消</el-button>
      <template v-if="title=='编辑服务类型'">
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
      type:{},
      editIndex:-1,
      title:'编辑服务类型',
    }
  },
  created() {
    this.ids = [
      {id:1,newtypeid:"1"},
      {id:2,newtypeid:"2"},
      {id:3,newtypeid:"3"},
      {id:4,newtypeid:"4"},
      {id:5,newtypeid:"5"}
    ]
    this.showData();

  },
  methods:{
    del(id){
      console.log(id)
      this.$confirm("是否删除？","提示").then(()=>{
        let url = "dataservertype/"+id;
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
      let url = "dataservertype/getPaged";
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
    getId(typeId){
      let newtypeid ;
      if(typeId == 1){
        newtypeid = "1";
      }else if(typeId == 2){
        newtypeid = "2";
      }else if(typeId == 3){
        newtypeid = "3";
      }else if(typeId == 4){
        newtypeid = "4";
      }else if(typeId == 5){
        newtypeid = "5";
      }

      return newtypeid;
    },
    edit(id,index){
      let url = "dataservertype/"+id;
      this.$http.get(url).then(resp=>{
        this.type = resp.data.data;
        this.isShow = true;
        this.editIndex = index;
      });
    },
    save(){
      this.$message({message:"保存成功！",type:'success'})
    },
    cancel(){
      this.isShow = false;
      this.type = {}
    },
    update(){
      let url = "dataservertype";
      this.$http.put(url,this.type).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'更新成功！',
            type:"success"
          });
          this.isShow = false;
          this.pageInfo.list[this.editIndex] = {...this.type};
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