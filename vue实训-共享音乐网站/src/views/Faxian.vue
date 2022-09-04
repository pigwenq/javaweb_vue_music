<template>
    <div id="faxian">
        <!-- 经典老歌 -->
        <div id="old-music">
           <div id = "f-head">
               <span>经典老歌</span>
               <a @click="toroute('经典老歌')">更多>></a>
           </div>
           
            <ul class="f-music-ul">
                <li v-for="(music,index) in oldmusic" :key="index">
                    <span id="li1"><a @click="alterPlay(music)">{{music.songname}}</a></span>
                    <span id="li2">{{music.date}}</span>
                </li>
            </ul>
        </div>

        <!-- 影视金曲 -->
        <div id="tv-music">
           <div id = "f-head">
               <span>影视金曲</span>
               <a @click="toroute('影视金曲')">更多>></a>
           </div>

           <ul class="f-music-ul">
                <li v-for="(music,index) in tvmusic" :key="index">
                    <span id="li1"><a @click="alterPlay(music)">{{music.songname}}</a></span>
                    <span id="li2">{{music.date}}</span>
                </li>
            </ul>
        </div>

        <!-- 新歌上架 -->
        <div id="new-music">
           <div id = "f-head">
               <span>新歌上架</span>
               <a @click="toroute('新歌上架')">更多>></a>
           </div>

           <ul class="f-music-ul">
                <li v-for="(music,index) in newmusic" :key="index">
                    <span id="li1"><a @click="alterPlay(music)">{{music.songname}}</a></span>
                    <span id="li2">{{music.date}}</span>
                </li>
            </ul>
        </div>

        <!-- 华语金曲 -->
        <div id="chinese-music">
           <div id = "f-head">
               <span>华语金曲</span>
               <a @click="toroute('华语金曲')">更多>></a>
           </div>

           <ul class="f-music-ul">
                <li v-for="(music,index) in chinesemusic" :key="index">
                    <span id="li1"><a @click="alterPlay(music)">{{music.songname}}</a></span>
                    <span id="li2">{{music.date}}</span>
                </li>
            </ul>
        </div>
        

        <!-- 排行榜 -->
        <div id="rank">
           <div id = "f-rank-head">
                <span>音乐排行榜</span>
                <a>播放量</a>
           </div>
           <ul class="f-music-ul">
                <li v-for="(music,index) in rankingmusic" :key="index">
                    <span style="color:red"> &nbsp;{{index+1}}</span>
                    <span id="li3"><a @click="alterPlay(music)">{{music.songname}}</a></span>
                    <span id="li2" class="li4">{{music.clicknum}}</span>
                </li>
            </ul>
        </div>
    </div>
</template>

    
<script>
import {mapMutations} from 'vuex'
export default {
    data(){
        return {
            oldmusic:[],
            tvmusic:[],
            newmusic:[],
            chinesemusic:[],
            rankingmusic:[]//排行榜信息
        }
    },
    methods: {
        toroute(to){
            this.$router.push({path:'/musiclist',query:{listname:to}})
        },
        ...mapMutations(['alterPlay'])
        // play(mes){
        //     this.$router.push('/'+mes.fileurl)
        // }
    },
    mounted(){
        var _this = this
        //获取经典老歌
        this.$axios({
            url:"/GetSongList",
            method:"post",
            params:{typename:'经典老歌',num:9,username:this.$store.state.username}
        }).then(function(resp){
            _this.oldmusic = resp.data         
        })
        //获取影视金曲
        this.$axios({
            url:"/GetSongList",
            method:"post",
            params:{typename:'影视金曲',num:9,username:this.$store.state.username}
        }).then(function(resp){
           
            _this.tvmusic = resp.data         
        })
        //获取新歌上架
        this.$axios({
            url:"/GetSongList",
            method:"post",
            params:{typename:'新歌上架',num:9,username:this.$store.state.username}
        }).then(function(resp){
            
            _this.newmusic = resp.data         
        })
        //获取华语金曲
        this.$axios({
            url:"/GetSongList",
            method:"post",
            params:{typename:'华语金曲',num:9,username:this.$store.state.username}
        }).then(function(resp){
            
            _this.chinesemusic = resp.data         
        })

        //获取排行榜歌曲
        this.$axios({
            url:"/GetRankingSong",
            method:"post",
            params:{num:20}
        }).then(function(resp){
            _this.rankingmusic = resp.data         
        })
    }
}
</script>


<style scoped>
    a{
        color: rgba(25, 26, 29, 0.959);
        cursor: pointer;
    }
    a:hover{
        color: rgb(38, 38, 194);
    }
    #f-rank-head a{
        position: relative;
        right: -80px;
        color: rgba(0, 0, 0, 0.527);
    }
    .f-music-ul{
        padding-top:10px ;
    }
    .f-music-ul li{
        height: 29px;
        border-bottom: 1px solid #c7d7e47e;
    }
    .f-music-ul li span{
        position: relative;
        line-height: 29px;
    }
    #li1{
        position:absolute;
        left: 20px;
        width: 260px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }
    #li2{
        position:absolute;
        right: 10px;
    }
    #li3{
        position:absolute;
        left: 26px;
        width: 140px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }
    .li4{
        color: rgba(19, 17, 17, 0.719);
    }
    #faxian{
        position: relative;
        min-height: 1000px;
        top:10px;
    }
    #f-head{
        background-color: #c7d7e44b;
        border-bottom:1px solid  #c7d7e4cc;
    }
     #f-head span{
        position: relative;
        left: 10px;
         color: rgb(131, 108, 6);
    }
    #f-head a{
        position: relative;
        left: 270px;
    } 
    #f-rank-head span{
        position: relative;
        left: 10px;
    }
    #f-rank-head{
        background-color: #c7d7e44b;
        border-bottom:1px solid  #c7d7e4cc;
         color: rgb(131, 108, 6);
    }



    #old-music{
        float: left;
        border: 1px solid #d3d3d3;
        width: 390px;
        height: 300px;
        position: absolute;
        margin: 10px;
    }
    #tv-music{
        float: left;
        border: 1px solid #d3d3d3;
        width: 390px;
        height: 300px;
        position: absolute;
        margin: 10px;
        color: black;
        left: 400px;
       
    }
    #new-music{
        float: left;
        border: 1px solid #d3d3d3;
        width: 390px;
        height: 300px;
        position: absolute;
        margin: 10px;
        color: black;
        top: 320px;
    }
    #chinese-music{
        float: left;
        border: 1px solid #d3d3d3;
        width: 390px;
        height: 300px;
        position: absolute;
        margin: 10px;
        color: black;
        left: 400px;
        top:320px;
    }

    #rank{
        float: left;
        border: 1px solid #d3d3d3;
        width: 210px;
        height: 620px;
        position: absolute;
        margin: 10px;
        color: black;
        right: 0px;
    }
    
   
</style>
