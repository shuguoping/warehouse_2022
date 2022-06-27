<template>
  销售计划管理
  <table border="1" width="500">
    <tr v-for="(plan,index) in plans" :key="index">
      <td>{{plan.id}}</td>
      <td>{{plan.content}}</td>
      <td>
        <input type="button" value="Edit" @click="edit(plan.id)">
        <router-link :to="{path:'/EditPlan',query:{id:plan.id}}">修改1</router-link>
        <router-link :to="{name:'EditPlan',query:{id:plan.id}}">修改2</router-link>
        <router-link :to="{name:'EditPlan',params:{id:plan.id}}">修改3</router-link>
      </td>
    </tr>
  </table>
</template>

<script>
export default {
  name: "SalePlan",
  data(){
    return {
      plans:[
        {id:1,content:"请客户吃饭"},
        {id:2,content:"还会研讨"},
        {id:3,content:"一起去旅游"}
      ]
    }
  },
  methods:{
    edit(id){
      this.$router.push({"path":"/EditPlan",query:{"id":id}})
    }
  }
}
</script>

<style scoped>

</style>