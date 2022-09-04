<template>
    <div id="main">
        <div id="m-head">
           
            <div id="m-logo"><img src="../assets/logo.png"></div>
            <div id="m-faxian"  @click="push('/')">发现音乐</div>
            <div id="m-mymusic" @click="push('/mymusic')">我的音乐</div>
            <div id="m-search">
                <el-input
                    placeholder="请输入内容"
                    v-model="input"
                    >
                </el-input>
                <i id="search-i" class="fa fa-search" aria-hidden="true" @click="search"></i>
            </div>
            
            <div id="m-login">
                <div v-if="ifLogin">
                    欢迎您:{{username}}
                     <el-button type="text" class="head-button" @click="quit"> 退出</el-button>
                </div>
                <div v-else>
                     <el-button type="text" @click="changeLV(true)" class="head-button">点击登陆</el-button>
                </div>
            </div>
            <div id="m-upload">
                <el-button type="primary" @click="changeUV(true)">歌曲上传<i class="el-icon-upload el-icon--right"></i></el-button>
            </div>
        </div>


        <LoginVue v-if="loginVisible"></LoginVue>  <!--登录框!-->
        <UploadSong v-if="uploadVisible"></UploadSong>
        <div id="m-rout"> <router-view/> </div>
        
        <!-- //回到顶部按钮 -->
         <div id='play'>
             <Play></Play>
         </div><!-- 音乐播放器 -->
    </div>
</template>

<script>
import LoginVue from '../components/Login.vue'
import UploadSong from '../components/UploadSong.vue'
import Play from '../components/Play.vue'
import {mapMutations, mapState} from 'vuex'
export default {
     data() {
      return {
        input: '',  //搜索框

      }
    },
    computed:{
        ...mapState(['loginVisible','uploadVisible','ifLogin','username'])
    },
    components:{LoginVue,UploadSong,Play},
    methods:{
        push(to){
           
            if(to=='/mymusic'){
                
                if(this.$store.state.ifLogin==false){
                    this.changeLV(true);
                    return;
                }
            }
            this.$router.push(to)
        }
        ,
        //传递事件修改登陆框展示
        changeLV(tag){
            this.$store.commit('alterLoginV',tag)
        },
        //传递事件修改上传框展示
        changeUV(tag){
            if(this.$store.state.ifLogin==false){//未登录
                this.changeLV(true)
                return
            }
            this.$store.commit('alterUploadV',tag)
        },
        search(){
            this.$router.push('/search')
            this.$store.commit('alterSearchRe',this.input)
        },
        ...mapMutations(['quit'])
    },
    
}
</script>

<style scoped>
#search-i{
    font-size: 20px;
    top:-68px;
    left:210px;
    color: red;
    position: relative;
    cursor: pointer;
}
#play{
    position: fixed;
    height: 70px;
}
#m-head{
    position: fixed;
    z-index: 1000;
    height: 70px;
    box-sizing: border-box;
    background: #242424;
    border-bottom: 1px solid #000;
    width: 100%;
    top:0px;
}
#m-logo{
    float: left;
    width: 157px;
    height: 100%;
    top:2px;
    color: red;
    font-size:  24px;
    position: relative;
    left: 270px;
    line-height: 70px;
}
#m-faxian{
    float: left;
    width: 100px;
    height: 100%;
    text-align: center;
    color: white;
    font-size:  17px;
    position: relative;
    left: 340px;
    line-height: 70px;
}
#m-faxian:hover{
    cursor: pointer;
}
#m-mymusic{
    float: left;
    width: 100px;
    height: 100%;
    text-align: center;
    color: white;
    font-size:  17px;
    position: relative;
    left: 360px;
    line-height: 70px;
}
#m-mymusic:hover{
    cursor: pointer;
}

#m-search{
    float: left;
    height: 100%;
    width: 240px;
    position: relative;
    left: 400px;
    line-height: 70px;
}

#m-login{
    float: left;
    height: 100%;
    width: 190px;
    position: relative;
    left: 540px;
    line-height: 70px;
    color: white;
}
#m-login .el-button--text{
    color: white;
}
#m-upload{
    float: left;
    height: 100%;
    width: 240px;
    position: relative;
    left: 540px;
    line-height: 70px;
}
#m-rout{
     position: relative;
        border: 1px solid #d3d3d3;
        width: 1040px;
        min-height: 700px;
        background-color: #fff;
        border-width: 0 1px ;
        margin: 0 auto;
        top:65px;
}
.el-button--primary{
    background-color: red;
    border: none;
}
</style>