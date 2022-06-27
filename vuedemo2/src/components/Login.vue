<template>
  <div :style="background" class="bgBackground">
    <br><br><br><br><br>
    <el-form class="loginForm">
      <h3 class="login-title">CRM客户关系管理系统登录</h3>
      <el-form-item >
        <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="password" v-model="user.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item >
        <el-button type="primary" style="width: 100%" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "LoginPage",
  data(){
    return{
      user:{},
      background: {
        // 背景图片地址
        backgroundImage: 'url(' + require('D:\\SHOU Intermediate Comprehensive Development Experiments\\login.jpg') + ')',
        // 背景图片是否重复
        backgroundRepeat: 'no-repeat',
        // 背景图片大小
        backgroundSize: 'cover',
        // 背景颜色
        backgroundColor: '#000',
        // 背景图片位置
        backgroundPosition: 'center top'
      }
    }
  },
  methods:{
    login(){
      let url = "sysuser/login";
      this.$http.get(url,{params:this.user}).then(resp=>{
        console.log(resp)
        if(resp.data.data != null){
          sessionStorage .setItem("username",this.user.username);
          this.$router.push("/Main")
        }else{
          alert("用户名或密码错误！")
        }
      })
    }
  }
}
</script>

<style scoped>
.loginForm{
  width:350px;
  margin:100px auto 10px;
  border:1px solid #eaeaea;
  padding:35px 35px 15px 35px;
  border-radius: 15px;
  box-shadow:0 0 25px #cac6c6;
}
.login-title{
  text-align: center;
  color:#505458;
  margin:0px auto 40px;
}
.bgBackground{
  width:100%;
  height:725px;
}
</style>