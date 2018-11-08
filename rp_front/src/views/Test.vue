<template>
  <Collapse v-model="value1">
    <Panel name="1">
      史蒂夫·乔布斯
      <p slot="content">史蒂夫·乔布斯（Steve Jobs），1955年2月24日生于美国加利福尼亚州旧金山，美国发明家、企业家、美国苹果公司联合创办人。
      <Form ref="form"
            :model="dailyreplay"
            class="dailyreplay-form">
          <FormItem :label="$t('dailyreplay.complexInflow.outflowTop')">
            <Input v-for="(item, i) in dailyreplay.outflows" :key="i" v-model="dailyreplay.outflows.item" placeholder="something"/>
          </FormItem>
      </Form>

      <text-and-input v-for="(item, i) in te"
                      v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d"  @input="handleInput($event, i)"></text-and-input>

      <text-and-input
        v-bind:n="pet.n" v-bind:d="pet.d" @input="handleInputPet"></text-and-input>

      <Button type="primary" @click="save()">{{ $t('tip.save') }}</Button>

      <Dropdown trigger="click" @on-click="selectMonth">
        10
        <DropdownMenu slot="list" >
          <DropdownItem v-for="item in 12" :name="item" v-bind:key="item">{{item}}</DropdownItem>
        </DropdownMenu>
      </Dropdown>


      <span @click="selectMonth()">11</span>
      <!--<text-and-input-->
        <!--v-for="(item, index) in te"-->
        <!--v-bind:key="index"-->
        <!--v-bind:n="item.n"-->
        <!--v-bind:d="item.d"></text-and-input>-->

      </p>
    </Panel>
    <Panel name="2">
      斯蒂夫·盖瑞·沃兹尼亚克
      <p slot="content">斯蒂夫·盖瑞·沃兹尼亚克（Stephen Gary Wozniak），美国电脑工程师，曾与史蒂夫·乔布斯合伙创立苹果电脑（今之苹果公司）。斯蒂夫·盖瑞·沃兹尼亚克曾就读于美国科罗拉多大学，后转学入美国著名高等学府加州大学伯克利分校（UC Berkeley）并获得电机工程及计算机（EECS）本科学位（1987年）。</p>
    </Panel>
    <Panel name="3">
      乔纳森·伊夫
      <p slot="content">乔纳森·伊夫是一位工业设计师，现任Apple公司设计师兼资深副总裁，英国爵士。他曾参与设计了iPod，iMac，iPhone，iPad等众多苹果产品。除了乔布斯，他是对苹果那些著名的产品最有影响力的人。
      </p>
    </Panel>
    <Panel name="4">
      日历
      <p slot="content">
        <calendar></calendar>
        {{id}}
        <Button type="primary" @click="getTest()"></Button>
      </p>
    </Panel>
  </Collapse>

</template>
<script>
  import textAndInput from '@/components/TextAndInput'
  import calendar from '@/components/Calendar'

  export default {
    data () {
      return {
        value1: '1',
        id: 2,
        dailyreplay: {
            outflows:[
            'a', 'a', ''
          ]
        },
        pet:{
          n:'11',d:''
        },
        te: [{
          n:'11',d:''
        },{
          n:'12',d:''
        }]
      }
    },
    components: {
      'text-and-input': textAndInput,
      'calendar': calendar
    },
    methods: {
        getTest() {
          this.$http
          .get(`http://127.0.0.1:26339/test/2`)
          .then(result => (this.id = result.data))
        },
        save() {
          this.$http.post(`http://127.0.0.1:26339/replay/saveTest`, this.pet);
        },
        selectMonth(name) {
          alert(name);
        },
        handleInput(event, i) {
          this.te[i].d = val;
          this.$emit('input', value); //触发 input 事件，并传入新值
        },
        handleInputPet(val) {
          this.pet.d = val;
          this.$emit('input', value); //触发 input 事件，并传入新值
        }
    }
  }
</script>
<style scoped>
  .cTitle{

  }
</style>
