<template>
  <Row>
    <Col span="7">
    <Card>
      <p style="display: block;height:35px" slot="title">
        <span class="title">{{ $t('principle.select') }}</span>
        <Dropdown trigger="custom" :visible="selectVisible"
                  style="margin-left: 15px;display:block;float:right;">
            <Button shape="circle" icon="md-add" @click="handleOpen('select')"></Button>
          <DropdownMenu slot="list">
            <div style="text-align: right;margin:10px;">
              <Input v-model="select" type="textarea" style="width: 25rem;" placeholder="Enter something..."/>
            </div>
            <div style="text-align: center;margin:10px;">
              <Button type="primary" shape="circle" @click="addPrinciple('select', select)">添加</Button>
              <Button type="error" @click="handleClose('select')" shape="circle">关闭</Button>
            </div>
          </DropdownMenu>
        </Dropdown>
      </p>
      <div style="width: 300px;">
        <p v-for="(item, index) in principle.selects"
           :key="index">
          <Icon type="md-close" @click="delPrinciple(index, 'select')"/>  <b>{{index}}:</b> <mark>{{item}}</mark>
        </p>
      </div>
    </Card>
    </Col>


    <Col span="7" offset="1">
    <Card>
      <p style="display: block;height:35px" slot="title">
        <span class="title">{{ $t('principle.buy') }}</span>
        <Dropdown trigger="custom" :visible="buyVisible"
                  style="margin-left: 15px;display:block;float:right;">
          <Button shape="circle" icon="md-add" @click="handleOpen('buy')"></Button>
          <DropdownMenu slot="list">
            <div style="text-align: right;margin:10px;">
              <Input v-model="buy" type="textarea" style="width: 25rem;" placeholder="Enter something..."/>
            </div>
            <div style="text-align: center;margin:10px;">
              <Button type="primary" shape="circle" @click="addPrinciple('buy', this.buy)">添加</Button>
              <Button type="error" @click="handleClose('buy')" shape="circle">关闭</Button>
            </div>
          </DropdownMenu>
        </Dropdown>
      </p>
      <div style="width: 300px;">
        <p v-for="(item, index) in principle.buys"
           :key="index">
          <Icon type="md-close" @click="delPrinciple(index, 'buy')"/> <b>{{index}}:</b> <mark>{{item}}</mark>
        </p>
      </div>
    </Card>
    </Col>


    <Col span="7" offset="1">
    <Card>
      <p style="display: block;height:35px" slot="title">
        <span class="title">{{ $t('principle.sell') }}</span>
        <Dropdown trigger="custom" :visible="sellVisible"
                  style="margin-left: 15px;display:block;float:right;">
          <Button shape="circle" icon="md-add" @click="handleOpen('sell', this.sell)"></Button>
          <DropdownMenu slot="list">
            <div style="text-align: right;margin:10px;">
              <Input v-model="sell" type="textarea" style="width: 25rem;" placeholder="Enter something..."/>
            </div>
            <div style="text-align: center;margin:10px;">
              <Button type="primary" shape="circle" @click="addPrinciple('sell')">添加</Button>
              <Button type="error" @click="handleClose('sell')" shape="circle">关闭</Button>
            </div>
          </DropdownMenu>
        </Dropdown>
      </p>
      <div style="width: 300px;">
        <p v-for="(item, index) in principle.sells"
           :key="index">
          <Icon type="md-close" @click="delPrinciple(index, 'sell')"/> <b>{{index}}:</b> <mark>{{item}}</mark>
        </p>
      </div>
    </Card>
    </Col>
  </Row>
</template>

<script>
  export default {
    name: 'Principle',
    data () {
      return {
        principle: {
            selects: [],
            buys: [],
            sells: []
        },
        select: '',
        buy: '',
        sell: '',
        selectVisible: false,
        buyVisible: false,
        sellVisible: false
      }
    },
    mounted: function () {
      // `this` 指向 vm 实例
      this.getPrinciple();
    },
    methods: {
        getPrinciple() {
          this.$http.get(`http://127.0.0.1:26339/principle`)
            .then(result => {
                this.principle = result.data.principle
            })
        },
        addPrinciple(principleType, principleContent) {
          this.$http.put(`http://127.0.0.1:26339/principle/add/${principleType}/${principleContent}`)
            .then(result => {
              this.handleClose(principleType);
              this.getPrinciple();
            })
        },
        delPrinciple(index, principleType){
          this.$http.delete(`http://127.0.0.1:26339/principle/del/${principleType}/${index}`)
            .then(result => {
              this.getPrinciple();
            })
        },
        handleOpen (title) {
          if (title == 'select'){
            this.selectVisible = true;
          }else if (title == 'buy'){
            this.buyVisible = true;
          }else if (title == 'sell'){
            this.sellVisible = true;
          }
        },
        handleClose (title) {
          if (title == 'select'){
            this.selectVisible = false;
          }else if (title == 'buy'){
            this.buyVisible = false;
          }else if (title == 'sell'){
            this.sellVisible = false;
          }
        }
    }
  }
</script>

<style>
  mark{
    background-color: gainsboro;
    color: black;
  }
  .title{
    font: bold normal 25px 微软雅黑;
  }
</style>
