import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginVisible:false,  //登录框是否弹出
    uploadVisible:false,  //上传框是否弹出
    ifLogin:false,    //系统是否登录

    username:"",  //用户名保存
    typelist:[],//歌曲类型展示

    playmusic:[],//目前播放的音乐数据
    play:false,  //是否播放

    search:{
      searchRe:[],//搜索结果
      key:[]
    }
   
  },
  mutations: {
    //修改登录框是否展示
    alterLoginV(state,LV){
      state.loginVisible = LV
    },
     //修改上传框是否展示
    alterUploadV(state,UV){
      //获取类型
      if(UV==true){
        axios({
          url:"/GetSongType",
          method:'get'
        }).then(function(resp){
          state.typelist =  resp.data
        }).catch(function(err){
          alert(err.message)
        })
      }
      state.uploadVisible = UV
    },
    //修改系统登陆参数
    alterIfLogin(state,IL){
      state.ifLogin = IL
      state.username = sessionStorage.getItem("loginname")
    },
    //修改登录名
    alterUsername(state,UN){
      state.username = UN
    },
    //退出
    quit(state){
      sessionStorage.removeItem("loginname")
      state.ifLogin = false
      state.username=""
    },
    //修改播放的音乐
    alterPlay(state,mes){
      // //申请音乐
      state.play = false
      axios({
        url:"/GetSong",
        method:'post',
        params:{id:mes.id}
      }).then(function(resp){
        
        state.playmusic =  resp.data
  
        state.play=true
      }).catch(function(err){
        alert(err.message)
      })
    },

    //获取搜索结果
    alterSearchRe(state,key){
      state.search.key = key

      axios({
        url:"/Search",
        method:'post',
        params:{search:key,username:state.username}
      }).then(function(resp){
        state.search.searchRe = resp.data
      }).catch(function(err){
        alert(err.message)
      })
    }
  },
  actions: {
    //收藏音乐
    collect({state},music){

      //已登录
      if(state.ifLogin){
        axios({
          url:"/Collect",
          method:'post',
          params:{id:music.id,username:state.username}
        }).catch(function(err){
          alert(err.message)
        })
      }
    }
  },
  modules: {
  }
})
