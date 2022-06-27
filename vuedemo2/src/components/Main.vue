<template>
  <el-container>
    <el-header>
      <el-row>

        <el-col :span="5" class="title">
          <el-icon><Avatar /></el-icon>
          CRM客户关系管理系统
        </el-col>


        <el-col :span="2" :offset="17" class="user_title">
          <el-dropdown @command="handleCommand" class="el-dropdown-link">
            <span>你好，
              {{username.toUpperCase()}}
              <el-icon class="el-icon--right">
                <arrow-down />
              </el-icon>
            </span>

            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="hideMenu">{{ menuText }}</el-dropdown-item>
                <el-dropdown-item >重置密码</el-dropdown-item>
                <el-dropdown-item command="exit">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </el-col>
      </el-row>
    </el-header>

    <el-container class="main">
      <el-aside width="200px" v-show="menuText=='隐藏菜单'">

        <el-menu>
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>营销管理</span>
            </template>
            <el-menu-item index="1-1">
              <router-link to="/SaleChance">销售机会管理</router-link>
            </el-menu-item >
            <el-menu-item index="1-2">
              <router-link to="/SalePlan">销售计划管理</router-link><br>
            </el-menu-item>
          </el-sub-menu>
        </el-menu>

        <el-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><location /></el-icon>
              <span>客户管理</span>
            </template>
            <el-menu-item index="1-1">
              <router-link to="/Orders">客户信息管理</router-link>
            </el-menu-item >
            <el-menu-item index="1-2">
              <router-link to="/Orders">客户联系人信息管理</router-link>
            </el-menu-item >
            <el-menu-item index="1-3">
              <router-link to="/Orders">客户订单信息管理</router-link>
            </el-menu-item >
            <el-menu-item index="1-3">
              <router-link to="/Orders">客户流失管理</router-link><br>
            </el-menu-item>
          </el-sub-menu>
        </el-menu>

        <el-menu>
          <el-sub-menu index="3">
            <template #title>
              <el-icon><location /></el-icon>
              <span>服务管理</span>
            </template>
            <el-menu-item index="1-1">
              <router-link to="/Orders">服务创建</router-link>
            </el-menu-item >
            <el-menu-item index="1-2">
              <router-link to="/Orders">服务分配</router-link>
            </el-menu-item >
            <el-menu-item index="1-3">
              <router-link to="/Orders">服务处理</router-link>
            </el-menu-item >
            <el-menu-item index="1-4">
              <router-link to="/Orders">服务反馈</router-link>
            </el-menu-item >
            <el-menu-item index="1-5">
              <router-link to="/Orders">服务归档</router-link>
            </el-menu-item >
          </el-sub-menu>
        </el-menu>

        <el-menu>
          <el-sub-menu index="4">
            <template #title>
              <el-icon><location /></el-icon>
              <span>统计报表</span>
            </template>
            <el-menu-item index="1-1">
              <router-link to="/Orders">客户贡献分析</router-link>
            </el-menu-item >
            <el-menu-item index="1-2">
              <router-link to="/Orders">客户构成分析</router-link>
            </el-menu-item >
            <el-menu-item index="1-3">
              <router-link to="/Orders">客户服务分析</router-link>
            </el-menu-item >
            <el-menu-item index="1-4">
              <router-link to="/SOrders">客户流失分析</router-link>
            </el-menu-item >
          </el-sub-menu>
        </el-menu>

        <el-menu>
          <el-sub-menu index="4">
            <template #title>
              <el-icon><location /></el-icon>
              <span>基础数据</span>
            </template>
            <el-menu-item index="1-1">
              <router-link to="/Orders">数据字典-企业客户等级</router-link>
            </el-menu-item >
            <el-menu-item index="1-2">
              <router-link to="/Orders">数据字典-服务类型</router-link>
            </el-menu-item >
            <el-menu-item index="1-3">
              <router-link to="/Orders">数据字典-地区</router-link>
            </el-menu-item >
            <el-menu-item index="1-4">
              <router-link to="/SysUser">用户及权限管理</router-link>
            </el-menu-item >
          </el-sub-menu>
        </el-menu>

      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
    <el-footer>
      <el-row>
        <el-col :span="10" class="title2">@Designed by Chen Siqi & Ding Gaolei & Ning Zhicong & He Mingyu</el-col>
      </el-row>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  name: "MainPage",
  data(){
    return {
      username:'',
      menuText:'隐藏菜单'
    }
  },
  created() {
    this.username = sessionStorage.getItem("username")
  },
  methods:{
    handleCommand(command){
      if(command == "hideMenu"){
        if(this.menuText == "隐藏菜单"){
          this.menuText = "显示菜单";
        }else{
          this.menuText = "隐藏菜单";
        }
      }else if(command == "exit"){
        this.$router.push("/Login");
        sessionStorage.clear();
      }
    }

  }
}
</script>

<style scoped>
.el-header,.el-footer{
  height: 60px;
  background-color: #409EFF;
}

.main{
  min-height: 605px;
}

a{
  text-decoration: none;
}

.title{
  color:white;
  font-size: 24px;
  line-height: 60px;
}

.title2{
  color:white;
  font-size: 15px;
  line-height: 75px;
}

.username{
  color:white;
  font-size: 14px;
  line-height: 60px;
}

.el-dropdown-link {
  cursor: pointer;
  color: #FFF;
}

.el-icon-arrow-down {
  font-size: 12px;
}

.user_title {
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>