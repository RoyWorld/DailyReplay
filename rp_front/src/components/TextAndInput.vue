<template>
  <Col span="6">
    <div class="hello">
      <strong>{{internN}}</strong>
      <Input v-model="internD" type="textarea" style="width: 10rem;" @input="$emit('input',internD)" placeholder="Enter something..."/>
    </div>
  </Col>
</template>

<script>
  export default {
    name: 'TextAndInput',
    data () {
      return {
        internN:this.n,
        internD:this.d
//        n:'',
//        d:''
      }
    },
//    watch:{
//      d(newValue){
//        this.d = newValue
//      }
//    },
    props: {
      n: {
        type: String
      },
      d: {
        type: String
      }
    },
    methods: {
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }
</style>
