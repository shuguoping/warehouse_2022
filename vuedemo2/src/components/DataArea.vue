<template>

  <el-steps :active="1"  simple style="margin-top: 5px">
    <el-step title="基础数据" />
    <el-step title="数据字典-地区" />
  </el-steps>

  <h4>地区</h4>

  <el-table :data="pageInfo.list" stripe :header-cell-style="{textAlign: 'center'}" :cell-style="{textAlign: 'center'}">
    <el-table-column prop="daid" label="编号" width="250"></el-table-column>

    <el-table-column label="地区名称(可编辑)" width="250" >
      <template #default="scope">
        <template v-if="scope.row.edit">
          <el-input v-model="tempList[scope.$index].daname" ></el-input>
        </template>
        <template v-else>
          {{scope.row.daname}}
        </template>
      </template>
    </el-table-column>

    <el-table-column label="对应值(不可编辑)" width="250">
      <template #default="scope">
        {{getId(scope.row.daid)}}
      </template>
    </el-table-column>

    <el-table-column label="操作">
      <template #default="scope">
        <template v-if="scope.row.edit">
          <el-button size="small" type="warning" @click="cancel2(scope)">取消</el-button>
          <el-button size="small" type="primary" @click="update2(scope)">保存</el-button>
        </template>
        <template v-else>
          <el-button size="small" type="warning" @click="del(scope.row.daid)">删除</el-button>
          <el-button size="small" type="primary" @click="edit(scope.row,scope.$index)">编辑</el-button>
        </template>
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
          <el-form-item label="地区编号：">
            <template v-if="title == '编辑地区'">
              {{area.daid}}
            </template>
            <template v-else>
              <el-input v-model="area.daid"></el-input>
            </template>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="地区名称：">
            <el-input v-model="area.daname"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>

    <template #footer>
      <el-button type="warning" @click="cancel">取消</el-button>
      <template v-if="title=='编辑地区'">
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
      daname:'',
      isShow:false,
      area:{},
      editIndex:-1,
      title:'编辑地区',
      tempList:[]
    }
  },
  created() {
    this.ids = [
      {id:1,newareaid:"1"},
      {id:2,newareaid:"2"},
      {id:3,newareaid:"3"},
      {id:4,newareaid:"4"},
      {id:5,newareaid:"5"}
    ]
    this.showData();

  },
  methods:{
    del(id){
      console.log(id)
      this.$confirm("是否删除？","提示").then(()=>{
        let url = "dataarea/"+id;
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
      let url = "dataarea/getPaged";
      this.$http.get(url,{params:{
          pageNum:this.pageInfo.pageNum,
          pageSize:this.pageInfo.pageSize,
          daname:this.daname,
        }})
          .then(resp=>{
            this.pageInfo = resp.data.data;
            let s = JSON.stringify(this.pageInfo.list)
            this.tempList = JSON.parse(s);
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
    getId(areaId){
      let newareaid ;
      if(areaId == 1){
        newareaid = "1";
      }else if(areaId == 2){
        newareaid = "2";
      }else if(areaId == 3){
        newareaid = "3";
      }else if(areaId == 4){
        newareaid = "4";
      }else if(areaId == 5){
        newareaid = "5";
      }

      return newareaid;
    },
    edit(datarea,index){
      console.log(datarea,index)
      datarea.edit = true;
    },
    cancel(){
      this.isShow = false;
      this.area = {}
    },
    update(){
      let url = "dataarea";
      this.$http.put(url,this.area).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'更新成功！',
            type:"success"
          });
          this.isShow = false;
          this.pageInfo.list[this.editIndex] = {...this.area};
          // alert("更新成功！")
          // this.$router.push("/SysUser")
        }
      });
    },
    cancel2(scope){
      scope.row.edit = false;
      this.tempList[scope.$index] = {...scope.row}
    },
    update2(scope){
      let url = "dataarea";
      this.$http.put(url,this.tempList[scope.$index]).then(resp=>{
        if(resp.data.data == 1){
          this.$message({
            message:'更新成功！',
            type:"success"
          });

          this.pageInfo.list[scope.$index] = {...this.tempList[scope.$index],edit:false}
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