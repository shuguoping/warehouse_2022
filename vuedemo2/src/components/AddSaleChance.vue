<template>

  <el-steps :active="2"  simple style="margin-top: 5px">
    <el-step title="营销管理" />
    <el-step title="销售机会管理" />
    <el-step title="新建销售机会" />
  </el-steps>

  <h4>添加销售机会</h4>

  <el-form label-width="100" style=" width: 350px" size="small">
    <el-form-item label="销售机会编号：">
      <el-input v-model="chance.id"></el-input>
    </el-form-item>

    <el-form-item label="机会来源：">
      <el-input v-model="chance.source"></el-input>
    </el-form-item>

    <el-form-item label="客户名称*：">
      <el-input v-model="chance.custname"></el-input>
    </el-form-item>

    <el-form-item label="成功机率*：">
      <el-input v-model="chance.rate"></el-input>
    </el-form-item>

    <el-form-item label="概要*：">
      <el-input v-model="chance.title"></el-input>
    </el-form-item>

    <el-form-item label="联系人电话：">
      <el-input v-model="chance.tel"></el-input>
    </el-form-item>

    <el-form-item label="联系人：">
      <el-input v-model="chance.linkman"></el-input>
    </el-form-item>

    <el-form-item label="机会描述">
      <el-input v-model="chance.desc" type="textarea" />
    </el-form-item>

    <el-form-item label="创建人编号*：">
      <el-input v-model="chance.createid"></el-input>
    </el-form-item>

    <el-form-item label="创建时间*：">
      <el-input v-model="chance.createdate"></el-input>
    </el-form-item>

    <br>
    <el-form-item >
      <el-button type="primary" @click="add">提交</el-button>
      <el-button type="default" @click="reset">重置</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
export default {
  name: "AddSaleChance",
  data(){
    return {
      chance:{},
    }
  },
  methods:{
    add(){
      let url = "salechance";
      this.$http.post(url,this.chance).then(resp=>{
        if(resp.data.data == 1){
          this.$router.push("/SaleChance")
        }
      });
    },
    reset(){
      this.chance = {}
    }
  }
}
</script>

<style scoped>

</style>