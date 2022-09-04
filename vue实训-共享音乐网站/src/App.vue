<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style>
  body{
    margin:0px;
    margin-top: 5px;
    background-color: rgb(243, 219, 219);
  }
  ul{
    margin: 0px;
    padding: 0px;
    list-style: none;
  }
  a{
     text-decoration-line: none;
  }
</style>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

</style>

<script>
export default {
  mounted(){
    if(sessionStorage.loginname){
      this.$store.commit('alterUsername',sessionStorage.loginname)
      this.$store.commit('alterIfLogin',true) 
    }
  }
}
</script>
