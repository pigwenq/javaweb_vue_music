<template>
    <div id = 'play'>
        <audio ref="audio" autoplay v-if="play" controls duration>
            <source :src="sc+playmusic.fileurl"/>
        </audio>
    </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
     data(){
           return {
                sc:this.$axios.defaults.baseURL+"/music/", //路径
                stop:true
            }
       },
    computed:{
        ...mapState(['playmusic','play']),
        
    }
  
}
</script>

<style scoped>
    #play{
        position: relative;
        bottom: 0px;
        width: 100%;
        height: 100%;
        z-index:1000;
        /* background-color: rgba(12, 12, 12, 0.795); */
    }
    audio{
        height: 100%;
        width: 100%;
    }
</style>