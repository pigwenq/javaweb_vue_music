<template>
    <div>
        
        <div id="search-head">
            <div id="inp1"><el-input v-model="input" placeholder="请输入内容"></el-input></div>
             <i id="inp2" class="fa fa-search" aria-hidden="true" @click="sea"></i>
             <span id="sp1">搜索 "{{search.key}}",找到 <span>{{search.searchRe.length}} </span>个相关数据</span>
        </div>

        
        <div id="search-list">
            <my-song-table :data="search.searchRe"></my-song-table>
        </div>

        <div id="empty"></div>
    </div>
</template>

<style scoped>
    #empty{
        height: 200px;
    }
    #search-list{
        position: relative;
        margin: auto;
        width: 750px;
        
    }
    #search-head{
        position: relative;
        width: 100%;
        height: 300px;
    }
    #inp1{
        width: 300px;
        position:relative;
        margin: auto;
        top:70px;
    }
    #inp2{
        position: absolute;
        left: 640px;
        top:82px;
        font-size: 20px;
        color: red;
        cursor: pointer;
    }
    #sp1{
        position:absolute;
        bottom: 50px;
        left: 30px;
        color: rgba(0, 0, 0, 0.548);
    }
</style>

<script>
import { mapState } from 'vuex'
import MySongTable from '../components/MySongTable.vue'
export default {
    data(){
        return{
            input:""
        }
        
    },
    computed:{
        ...mapState(['search'])
    },
    methods: {
        sea(){
            this.$store.commit('alterSearchRe',this.input)
        }
    },
    components:{
        MySongTable
    }
}
</script>