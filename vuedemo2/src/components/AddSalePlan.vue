<template>

  <el-steps :active="2"  simple style="margin-top: 5px">
    <el-step title="营销管理" />
    <el-step title="销售机会管理" />
    <el-step title="新建销售计划" />
  </el-steps>

  <h4>添加销售计划</h4>

  <el-form label-width="100px" style="width: 350px" size="small">
    <el-form-item label="销售机会编号：">
      <el-input v-model="plan.id"></el-input>
    </el-form-item>

    <el-form-item label="所属机会编号：">
      <el-input v-model="plan.chcid"></el-input>
    </el-form-item>

    <el-form-item label="执行内容">
      <el-input v-model="plan.todo" type="textarea" />
    </el-form-item>

    <el-form-item >
      <el-button type="primary" @click="add">提交</el-button>
      <el-button type="default" @click="reset">重置</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
export default {
  name: "AddSalePlan",
  data(){
    return {
      plan:{},
    }
  },
  methods:{
    add(){
      let url = "saleplan";
      this.$http.post(url,this.plan).then(resp=>{
        if(resp.data.data == 1){
          this.$router.push("/SalePlan")
        }
      });
    },
    reset(){
      this.plan = {}
    }
  }
}
</script>

<style scoped>

</style>