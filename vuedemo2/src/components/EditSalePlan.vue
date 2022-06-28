<template>

  <el-steps :active="2"  simple style="margin-top: 5px">
    <el-step title="营销管理" />
    <el-step title="销售机会管理" />
    <el-step title="编辑销售计划" />
  </el-steps>

  <h4>编辑销售计划</h4>

  <el-form label-width="100" style=" width: 350px" size="small">
    <el-form-item label="销售计划编号：">
      {{plan.id}}
    </el-form-item>

    <el-form-item label="所属销售计划编号：">
      <el-input v-model="plan.chcid"></el-input>
    </el-form-item>

    <el-form-item label="执行内容：">
      <el-input v-model="plan.todo" type="textarea" />
    </el-form-item>

    <el-form-item >
      <el-button type="primary" @click="update">保存</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
export default {
  name: "EditSalePlan",
  data(){
    return {
      plan:{},
    }
  },
  created() {
    let id = this.$route.query.id;
    let url = "saleplan/"+id;
    this.$http.get(url).then(resp=>{
      this.plan = resp.data.data;
    });
  },
  methods:{
    update(){
      let url = "saleplan";
      this.$http.put(url,this.plan).then(resp=>{
        if(resp.data.data == 1){
          this.$router.push("/SalePlan")
        }
      });
    }
  }
}

</script>

<style scoped>

</style>