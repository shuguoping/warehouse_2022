<template>

  <el-steps :active="2"  simple style="margin-top: 5px">
    <el-step title="营销管理" />
    <el-step title="销售机会管理" />
    <el-step title="编辑销售机会" />
  </el-steps>

  <h4>编辑用户</h4>

  <el-form label-width="100" style=" width: 350px" size="small">
    <el-form-item label="销售机会编号：">
      {{chance.id}}
    </el-form-item>

    <el-form-item label="机会来源：">
      <el-input v-model="chance.source"></el-input>
    </el-form-item>

    <el-form-item label="客户名称：*">
      <el-input v-model="chance.custname" ></el-input>
    </el-form-item>

    <el-form-item label="成功几率：*">
      <el-input v-model="chance.rate"></el-input>
    </el-form-item>

    <el-form-item label="概要：*">
      <el-input v-model="chance.title"></el-input>
    </el-form-item>

    <el-form-item label="联系人电话：">
      <el-input v-model="chance.tel"></el-input>
    </el-form-item>

    <el-form-item label="联系人：">
      <el-input v-model="chance.linkman"></el-input>
    </el-form-item>

    <el-form-item label="机会描述：">
      <el-input v-model="chance.desc" type="textarea" />
    </el-form-item>

    <el-form-item label="创建人编号：">
      {{chance.createid}}
    </el-form-item>

    <el-form-item label="创建时间：">
      {{chance.createdate}}
    </el-form-item>

    <el-form-item >
      <el-button type="primary" @click="update">保存</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
export default {
  name: "EditSysUser",
  data(){
    return {
      chance:{},
    }
  },
  created() {
    let id = this.$route.query.id;
    let url = "salechance/"+id;
    this.$http.get(url).then(resp=>{
      this.chance = resp.data.data;
    });
  },
  methods:{
    update(){
      let url = "salechance";
      this.$http.put(url,this.chance).then(resp=>{
        if(resp.data.data == 1){
          this.$router.push("/SaleChance")
        }
      });
    }
  }
}

</script>

<style scoped>

</style>