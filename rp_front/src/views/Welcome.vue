<template>
  <Row>
    <Col span="11">
    <Card>
      <p style="display: block;" slot="title">
        Welcome
        <digitalClock style="display:block;float:right;"></digitalClock>
      </p>
      <div style="width: 300px;height: 500px;">
        <logo></logo>
      </div>
    </Card>
    </Col>
    <Col span="11" offset="2">
    <Card dis-hover>
      <p slot="title">日历</p>
      <calendar></calendar>
    </Card>
    </Col>

  </Row>
</template>

<script>
  import logo from '@/components/Logo'
  import calendar from '@/components/Calendar'
  import digitalClock from '@/components/DigitalClock'

  export default {
    name: 'HelloWorld',
    data () {
      return {
        msg: 'Welcome to Your Vue.js App'
      }
    },
    components: {
      'logo': logo,
      'calendar': calendar,
      'digitalClock': digitalClock
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
