<template>
    <div id="mymusic">
        <!-- 我的歌单列表 -->
        <div id="mysonglist">
            <el-collapse>
                <br/> 
                <el-collapse-item title="我的歌单" name="1" id="leftList">
                    <div style=" text-align:center;">我喜欢的音乐</div>
                </el-collapse-item>
            </el-collapse>
        </div>

        <div id="songlist-head">
                <img id="song-img" src="../assets/songlist.png">
                <img id="gedan-img" src="../assets/gedan.png">
                <span id="s1">歌曲列表</span>
                <span id="s2">{{tabledata.length}}首歌</span>
                <span id="s3">我喜欢的音乐</span>
        </div>

        <!-- 歌单详情列表 -->
        <div id="songlist">
            <my-song-table :data="tabledata" @change="change"></my-song-table>
        </div>

    </div>
</template>


<style scoped>
    #gedan-img{
        position: absolute;
        width: 60px;
        height: 28px;
        left: 360px;
        top:60px;
    }
    #s3{
        position:absolute;
        left:440px;
        top:58px;
        font-size: 25px;
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
    #music{
        position: relative;
        top:20px;
        height: 100px;
        border: 1px solid red;
        width: 100%;
    }
    #mysonglist{
        position: fixed;
        margin-left: 20px;
        margin-bottom: 20px;
        top:70px;
        width: 220px;
        min-height: 400px;
        border: 1px solid #d3d3d3;
        background-color: rgba(243, 219, 219, 0.267);
    }
    #leftList{
        color: red;
    }
    #songlist{
        border: 1px solid #d3d3d3;
        margin-left: 20px;
        margin-bottom: 20px;
        top:3px;
        width: 800px;
        min-height: 800px;
        position: relative;
       left: 220px;
    }
    #songlist-head{
        border: 1px solid #d3d3d3;
        border-bottom:none ;
        margin-left: 20px;
        width: 780px;
        height: 320px;
        position: relative;
        left: 220px;
    }

</style>

<script>
import MySongTable from'../components/MySongTable.vue'
export default {
    data(){
        return{
            tabledata:[]
        }
    },
    components:{MySongTable},



    methods: {
        //移除音乐
        change(index){
            this.tabledata.splice(index,1)
           
        }
    },

    mounted(){
        var _this = this
        this.$axios({
            url:"/MyloveMusic",
            method:"post",
            params:{username:this.$store.state.username}
            
        }).then(function(resp){
            _this.tabledata = resp.data         
        }).catch(function(err){
            alert(err.message)
        })
        
    }
}
</script>