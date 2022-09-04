<template>
    <div id="login">
        <el-dialog :visible.sync="loginVisible" width="500px">

            <div id="select_log_reg">
                <ul>
                    <li @click="logOrReg=true">登陆</li>
                    <li @click="logOrReg=false">注册</li>
                </ul>
            </div>
            <br/>
            <!-- 登录 -->
            <el-form :model="loginForm" ref="ruleForm" label-width="100px" class="demo-ruleForm" v-if="logOrReg">
                <el-form-item label="用户名:" prop="name">
                    <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
                </el-form-item>

                
                <el-form-item label="密码" prop="delivery">
                    <el-input v-model="loginForm.password" type="password" placeholder="请输入密码"></el-input>
                </el-form-item>
                <el-button type="primary" @click="login">登 录</el-button>
            </el-form>

            <!-- 注册 -->
            <el-form :model="regForm" ref="ruleForm" label-width="100px" class="demo-ruleForm" v-if="!logOrReg">
                <el-form-item label="用户名:" prop="name">
                    <el-input v-model="regForm.username" placeholder="请输入用户名"></el-input>
                </el-form-item>

                <el-form-item label="密码" prop="delivery">
                    <el-input v-model="regForm.password" type="password" placeholder="请输入密码"></el-input>
                </el-form-item>

                <el-form-item label="确认密码" prop="delivery">
                    <el-input v-model="regForm.enpassword" type="password"  placeholder="请确认密码"></el-input>
                </el-form-item>
                <el-button type="primary" @click="register">注 册</el-button>
            </el-form>
            <br/>
            

        </el-dialog>

    </div>
</template>

<script>
  export default {
    data() {
      return {
        //登录表单数据
        loginForm:{
            username:"",
            password:""
        },
        //注册表单数据
        regForm:{
            username:"",
            password:"",
            enpassword:""
        },
        //判断展示登陆或注册表单,
        logOrReg:true,
        //是否弹出对话框
        loginVisible:this.$store.state.loginVisible
      };
    },
    methods:{
        //登录
        login(){
            if(this.loginForm.username==""){
                alert("请输入用户名")
            }else if(this.loginForm.password==""){
                alert("请输入密码")
            }else{
                
                //判断用户名是否正确
                var _this = this
                 this.$axios({
                     url:"/Login",
                     method: 'post',
                     params:{username:this.loginForm.username,password:this.loginForm.password},
                     timeout:3000                     
                 }).then(function(resp){
                     
                     //登录成功
                     if(resp.data==='登录成功'){
                         //设置会话参数
                         sessionStorage.setItem("loginname",_this.loginForm.username)
                         _this.$store.commit('alterIfLogin',true)
                         _this.loginVisible = false
                         return
                     }
                    alert(resp.data)
                 }).catch(function(err){
                     alert("发生错误!"+err.message);
                 })
                
            }
        },
        //注册
        register(){
            if(this.regForm.username==""){
                alert("请输入用户名")
            }else if(this.regForm.password!=this.regForm.enpassword){
                alert("密码不一致")
            }else if(this.regForm.password==""){
                alert("请输入密码")
            }else if(this.regForm.enpassword==""){
                alert("请确认密码")
            }else{
                var _this = this
                 this.$axios({
                     url:"/Register",
                     method: 'post',
                     params:{username:this.regForm.username,password:this.regForm.password},
                     timeout:3000                     
                 }).then(function(resp){
                     alert(resp.data)
                     if(resp.data=='注册成功'){
                         _this.logOrReg = true
                         _this.loginForm.username = _this.regForm.username
                         _this.regForm={username:"",password:"",enpassword:""}
                     }
                 }).catch(function(err){
                     alert("发生错误!"+err.message);
                 })
            }
        }
    },  
    watch:{
        //改变的时候，传入store
       loginVisible(){
            this.$store.commit('alterLoginV',this.dialogFormVisible)
        }
    }
  };
</script>

<style scoped>
#select_log_reg{
    position:absolute;
    left: 17px;
    top:11px;
}
#select_log_reg li{
    display: inline-block;
    background-color: rgba(209, 157, 157, 0.1);
    font-size:20px ;
    line-height: 40px;
    text-align: center;
    width: 60px;
    height: 40px;
    margin: 1px;
    border-radius: 7px;
}
#select_log_reg li:hover{
    cursor: pointer;
    background-color: rgba(209, 157, 157, 0.2);
}
.el-input{
    width: 250px;
}
.el-button{
    position: relative;
    left:200px;
    background-color: red;
    border: none;
}
.el-button:hover{
    background-color: rgba(255, 0, 0, 0.733);
}
</style>