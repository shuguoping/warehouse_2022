<template>

  <el-steps :active="2"  simple style="margin-top: 5px">
    <el-step title="营销管理" />
    <el-step title="销售机会管理" />
    <el-step title="销售机会详情" />
  </el-steps>

  <h4>销售机会详情</h4>

  <el-form :inline="true" label-width="100" style=" width: 350px" >
    <el-form-item label="指派人编号：">
      <el-input v-model="chance.dueid"></el-input>
    </el-form-item>

    <el-form-item label="指派日期：">
      <el-input v-model="chance.duedate"></el-input>
    </el-form-item>

    <el-form-item label="销售机会编号：">
      {{chance.id}}
    </el-form-item>

    <el-form-item label="机会来源：">
      {{chance.source}}
    </el-form-item>

    <el-form-item label="客户名称：">
      {{chance.custname}}
    </el-form-item>

    <el-form-item label="成功几率：">
      {{chance.rate}}
    </el-form-item>

    <el-form-item label="概要：">
      {{chance.title}}
    </el-form-item>

    <el-form-item label="联系人电话：">
      {{chance.tel}}
    </el-form-item>

    <el-form-item label="联系人：">
      {{chance.linkman}}
    </el-form-item>

    <el-form-item label="机会描述：">
      {{chance.desc}}
    </el-form-item>

    <el-form-item label="创建人编号：">
      {{chance.createid}}
    </el-form-item>

    <el-form-item label="创建时间：">
      {{chance.createdate}}
    </el-form-item>

    <el-form-item label="计划：">
      <view v-if="plan.plans!='' && plan.plans!=null">
        <li v-for="(item) in plan.plans" :key="item.id">{{item.todo}}</li>
      </view>
    </el-form-item>



    <el-form-item >
      <el-button type="primary" @click="goback">退回</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
export default {
  name: "EditSaleChance",
  data(){
    return {
      chance:{},
      plan:{}
    }
  },
  created() {
    let id = this.$route.query.id;
    let url = "salechance/"+id;
    this.$http.get(url).then(resp=>{
      this.chance = resp.data.data;
      this.plan = resp.data.data;
    });
  },
  methods:{
    goback(){
          this.$router.push("/SaleChance")
    }
  }
}

</script>

<style scoped>

</style>