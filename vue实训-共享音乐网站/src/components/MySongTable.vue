<template>
  <div id="mysong">
    <el-table
      :highlight-current-row="true"
      :border="true"
      :data="data"
      stripe>

          <el-table-column
           label="播放"
            width="60px">
            <template slot-scope="scope">
              <i class="fa fa-play" aria-hidden="true" @click="play(scope.row)"></i>
            </template>
          </el-table-column>

          <el-table-column
            prop="songname"
            label="歌曲标题"
            width="280px">
          </el-table-column>

          <el-table-column
            prop="singer"
            label="歌手"
            width="130px">
          </el-table-column>

          <el-table-column
            prop="date"
            label="上传时间"
            width="130px">
          </el-table-column>

          <el-table-column
            prop="username"
            label="上传者"
            width="100px">
          </el-table-column>

          <el-table-column
            prop="">
             <template slot-scope="scope">
                <i class="fa fa-heart love" 
                  aria-hidden="true" 
                  v-if="scope.row.love" 
                  @click="coll(scope.$index,scope.row)">
                </i>
                <i class="fa fa-heart-o love" 
                    aria-hidden="true" 
                    v-else
                    @click="coll(scope.$index,scope.row)">
                 </i> 
             </template>
          </el-table-column>

    </el-table>
 
  </div>
</template>


<style scoped>
  .down{
    color: rgba(0, 0, 0, 0.685);
    font-size: 18px;
    position: relative;
    left: 20px;
    cursor: pointer;
  }
  .fa-play{
    color: rgba(0, 0, 0, 0.486);
    font-size: 16px;
    position: absolute;
    line-height: 4px;
    right: 22px; 
  }
  .fa-play:hover{
    cursor: pointer;
    font-size:20px ;
    font-size: 18px;
  }
  .el-table__header{
    text-align: center;
  }
  .love{
    color: red;
    font-size: 20px;
    cursor: pointer;
    position: relative;
    left: 16px;
  }
</style>

<script>
import { mapActions } from 'vuex'
  export default {
    props:['data'],
    data(){
      return {
        selectrow:[]
      }
    },
     methods: {
       ...mapActions(['collect']),
      play(row){
        this.selectrow = row
        this.$store.commit('alterPlay',row)
      },
      coll(index,row){
       
        if(this.$store.state.ifLogin==false){
          this.$store.commit('alterLoginV',true)
        }else{
          // alert(row)
          this.collect(row)
          row.love = !row.love
          //传递父组件移除
          this.$emit('change',index)
        }
      }
    },
  }
</script>