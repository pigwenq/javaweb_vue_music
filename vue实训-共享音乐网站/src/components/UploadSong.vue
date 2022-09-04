<template>
    <div id="upload">
         <el-dialog :visible.sync="uploadVisible" width="500px">
             <h1>歌 曲 上 传</h1>
            <br/>
            <br/>

            <el-form :model="uploadForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">


                <el-form-item label="歌曲名:" prop="name">
                    <el-input v-model="uploadForm.songname" placeholder="可自动填写歌曲名"></el-input>
                </el-form-item>

                
                <el-form-item label="歌唱者:" prop="delivery">
                    <el-input v-model="uploadForm.singer" placeholder="可自动填写歌唱者"></el-input>
                </el-form-item>

                <el-form-item label="歌曲类型:" prop="delivery">
                    
                    <el-select :style="selestyle" v-model="uploadForm.typename" placeholder="请选择">
                        <el-option
                        v-for="item in typelist"
                        :key="item.id"
                        :label="item.typename"
                        :value="item.typename">
                    
                        </el-option>
                    </el-select>

                </el-form-item>

                 

                <!-- //文件上传 -->
                <div id="uploadfile">

                    <el-upload
                    class="upload-demo"
                    drag
                    ref="upload"
                    action=""
                    :on-change="change"
                    :auto-upload="false"
                    :limit="1"
                    :http-request="upload"
                    >
                        <i class="el-icon-upload"></i>
                        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                    </el-upload> 
                    <div slot="tip" class="el-upload__tip">只能上传mp3文件</div>
                </div>

                <el-button type="primary" @click="submitUpload">上 传</el-button>
            </el-form>
         </el-dialog>
    </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
    data(){
        return {
             uploadVisible : this.$store.state.uploadVisible, //是否弹出歌曲上传界面

            //歌曲信息
            uploadForm:{
                songname:"",
                singer:"",
                typename:""//选中的类型
            },
            selestyle:{
                width:"250px",
            }
            
        }    
    },
    computed:{
        //类型信息
        ...mapState(['typelist'])
    },
    methods:{
        change(filetemp){   //上传文件的时候进行判断
            var Name = filetemp.name;
            var idx = Name.lastIndexOf(".");  
            if (idx != -1){
                var ext = Name.substr(idx+1);   
                // alert(ext)
                if (ext!='mp3'){
                    alert("仅允许传入mp3文件")
                    return
                }
                this.uploadForm.songname=Name.substr(0,idx)
            }else{
                alert("文件有误")
            }

            var t = Name.indexOf('-');

            this.uploadForm.singer=Name.substr(0,t)
        },
        //提交
        submitUpload() {
            this.$refs.upload.submit();
        },
        //上传
        upload(filetemp){
            if(this.uploadForm.songname==""){
                alert("请输入歌曲名")
            }else if(this.uploadForm.singer==""){
                alert("请输入歌唱者")
            }else if(this.uploadForm.typename==""){
                alert("请选择类型")
            }
            else{
                if(filetemp.file.size==0){//文件大小为0
                    alert("请上传文件")
                    return
                }      
                
                let parms = new FormData()
                parms.append('file',filetemp.file) //传入文件
                //上传类型的判断
                {
                    var Name = filetemp.file.name;
                    var idx = Name.lastIndexOf(".");  
                    if (idx != -1){
                        var ext = Name.substr(idx+1);   
                        // alert(ext)
                        if (ext!='mp3'){
                            alert("仅允许传入mp3文件")
                            return
                        }
                        this.uploadForm.songname=Name.substr(0,idx)
                    }else{
                        alert("文件有误")
                    }
                }
                parms.append('songname',this.uploadForm.songname)
                parms.append('singer',this.uploadForm.singer)
                parms.append("typename",this.uploadForm.typename)
                parms.append("username",this.$store.state.username) //上传者
                
                var _this = this
                this.$axios.post('/UpLoad',parms,{headers: {'Content-Type': 'multipart/form-data'}})
                .then(function(resp){
                    alert(resp.data)
                    _this.uploadVisible=false
                }).catch(function(err){
                    alert(err.message)
                })
            }
        },
        //存放文件此处
    },
     watch:{
        uploadVisible(){
            this.$store.commit('alterUploadV',this.uploadVisible)
        }
    }
}
</script>


<style scoped>

    .el-input--suffix{
        position: relative;
        width: 500px;
    }
    h1{
        position: absolute;
        left: 180px;
        top:0px;
    }
    .el-button{
        position: relative;
        left:200px;
        background-color: red;
        border: none;
    }
    .el-input{
        width: 250px;
    }
    #uploadfile{
        position: relative;
        left:50px;
        
    }
</style>




