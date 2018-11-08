<template>
  <Row>
    <Col span="20">
    <Card>
      <p style="display: block;height: 26px;" slot="title">
        历史复盘
        <Button style="display:block;float:right;" size="small" @click="back">返回</Button>
      </p>
      <pre style="white-space: pre-wrap;">{{report}}</pre>
    </Card>
    </Col>
  </Row>
</template>

<script>
    export default {
        name: 'Report',
        data () {
            return {
                report: ''
            }
        },
        mounted: function () {
          this.getReport();
        },
        components: {},
        methods: {
          getReport() {
            var url = window.location.href; //window.location.href
            var paramArray = url.split("/");
            var year = paramArray.slice(-3)[0];
            var month = paramArray.slice(-3)[1];
            var day = paramArray.slice(-3)[2];

            this.$http.get(`http://127.0.0.1:26339/replay/report/${year}/${month}/${day}`)
              .then(result => {
                  this.report = result.data.report
              });
          },
          back() {
            this.$router.replace("welcome");
          },
        }
    }
</script>

<style>
</style>
