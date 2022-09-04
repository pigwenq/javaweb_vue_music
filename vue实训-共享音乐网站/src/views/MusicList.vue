<template>
    <div id="musiclist">
        <div id="songlist-head">
                <img id="song-img" src="../assets/songlist.png">
                <img id="gedan-img" src="../assets/gedan.png">
                
                <span id="s1">歌曲列表</span>
                <span id="s2">{{tabledata.length}}首歌</span>
                <span id="s3">{{listname}}</span>
        </div>
        <!-- 歌单详情列表 -->
        <div id="songlist">
            <my-song-table :data="tabledata"></my-song-table>
        </div>
    </div>
</template>

<style scoped>
    #s3{
        position:absolute;
        left:440px;
        top:58px;
        font-size: 25px;
    }
    #gedan-img{
        position: absolute;
            width: 60px;
            height: 28px;
            left: 360px;
            top:60px;
    }
    #musiclist{
        position: relative;
        
        width: 100%;
        height: 100%;
        min-height: 900px;
    }
    #songlist-head{
        border: 1px solid #d3d3d3;
        border-bottom:none ;
        margin-left: 20px;
        top:3px;
        width: 780px;
        height: 320px;
        position: relative;
        margin: auto;
    }
    #s1{
        position: absolute;
        left: 30px;
        bottom: 20px;
        font-size: 24px;
    }
    #s2{
        position: absolute;
        left: 155px;
        bottom:20px;
        font-size: 14px;
    }
    #song-img{
        position: relative;
        width: 208px;
        height: 208px;
        background-position: 0px -1285px;
        top: 30px;
        left: 50px;
    }
    #songlist{
        border: 1px solid #d3d3d3;
        margin-left: 20px;
        margin-bottom: 20px;
        top:3px;
        width: 780px;
        min-height: 800px;
        position: relative;
        margin: auto;

    }
</style>

<script>
import MySongTable from '../components/MySongTable.vue'
export default {
    data(){
        return{
            tabledata:[],
            listname:""
        }
    },
    components:{MySongTable},
    mounted(){
        this.listname = this.$route.query.listname
        var _this = this
        //获取歌曲信息
        this.$axios({
            url:"/GetSongList",
            method:"post",
            params:{typename:_this.listname,num:9999,username:this.$store.state.username}
            
        }).then(function(resp){
            _this.tabledata = resp.data         
        }).catch(function(err){
            alert(err.message)
        })
    }
}
</script>