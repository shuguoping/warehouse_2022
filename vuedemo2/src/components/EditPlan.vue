<template>
  <h4>编辑计划</h4>
  <table>
    <tr>
      <td>计划编号</td>
      <td>{{$route.query.id}}</td>
      <td>{{$route.params.id}}</td>
    </tr>
  </table>
</template>

<script>
export default {
  name: "EditPlan",
  //vue生命周期
  created() {
    let id =this.$route.query.id;
    alert(id);
  }
}
</script>

<style scoped>

</style>