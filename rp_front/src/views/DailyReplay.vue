<template>
  <Form ref="form"
        :model="dailyreplay"
        class="dailyreplay-form">
    <Collapse :value="['data','complexInflow','marketReview','hotspot','sympatheticStock','midstock']">
      <!--数据-->
      <Panel name="data">
        {{ $t('dailyreplay.data.title') }}
        <div slot="content">
          <FormItem>
            <Col span="4" offset="1">
              {{ $t('dailyreplay.data.trading') }}
              <Input v-model="dailyreplay.data.trading"></Input>
            </Col>
            <Col span="5">
              {{ $t('dailyreplay.data.nonInlineTrading') }}
              <Input v-model="dailyreplay.data.noninlinetrading"></Input>
            </Col>
            <Col span="4">
              {{ $t('dailyreplay.data.failing') }}
              <Input v-model="dailyreplay.data.failing"></Input>
            </Col>
          </FormItem>
          <FormItem >
            <Col span="8" offset="1">
            {{ $t('dailyreplay.data.profitMarkingEffect') }}
            <Select v-model="dailyreplay.data.profitmarkingeffect" style="width:100px">
              <Option v-for="item in profitMarkingEffect" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
            </Col>
          </FormItem>
          <FormItem >
            <Col span="4" offset="1">
            {{ $t('dailyreplay.data.rise') }}
            <Input v-model="dailyreplay.data.rise"></Input>
            </Col>
            <Col span="4" offset="1">
            {{ $t('dailyreplay.data.fall') }}
            <Input v-model="dailyreplay.data.fall"></Input>
            </Col>
          </FormItem>
          <FormItem >
            <Col span="8" offset="1">
            {{ $t('dailyreplay.data.marginFinancing') }}
            <Select v-model="dailyreplay.data.marginfinancing.change" style="width:100px">
              <Option v-for="item in marginFinancing" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
            <Input v-model="dailyreplay.data.marginfinancing.sum"></Input>
            </Col>
          </FormItem>
          <FormItem>
            <Col span="3" offset="1">
            {{ $t('dailyreplay.data.foreignCapital') }}
            <Select v-model="dailyreplay.data.foreigncapital.sum" style="width:100px">
              <Option v-for="item in foreignCapital" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
            </Col>
            <Col span="4">
            {{ $t('dailyreplay.data.SH') }}
            <FormItem v-for="(item, index) in dailyreplay.data.foreigncapital.sh"
                      :key="index">
              <Input v-model="dailyreplay.data.foreigncapital.sh[index]" type="textarea" placeholder="Enter something..."/>
            </FormItem>
            <Button type="dashed"  @click="handleAddForeigncapital('sh')" icon="plus-round">Add</Button>
            </Col>
            <Col span="4">
            {{ $t('dailyreplay.data.SZ') }}
            <FormItem v-for="(item, index) in dailyreplay.data.foreigncapital.sz"
                      :key="index">
              <Input v-model="dailyreplay.data.foreigncapital.sz[index]" type="textarea" placeholder="Enter something..."/>
            </FormItem>
            <Button type="dashed"  @click="handleAddForeigncapital('sz')" icon="plus-round">Add</Button>
            </Col>
          </FormItem>
        </div>
      </Panel>
      <!--板块流入-->
      <Panel name="complexInflow">
        {{ $t('dailyreplay.complexInflow.title') }}
        <div slot="content">
          <FormItem :label="$t('dailyreplay.complexInflow.inflowTop')">
            <Input style="padding-left: 10px;" v-for="(item, i) in dailyreplay.complexinflow.inflows" :key="i" v-model="dailyreplay.complexinflow.inflows[i]" placeholder="something"/>
          </FormItem>
          <FormItem :label="$t('dailyreplay.complexInflow.outflowTop')">
            <Input style="padding-left: 10px;" v-for="(item, i) in dailyreplay.complexinflow.outflows" :key="i" v-model="dailyreplay.complexinflow.outflows[i]" placeholder="something"/>
          </FormItem>
        </div>
      </Panel>
      <!--当日市场一览-->
      <Panel name="marketReview">
        {{ $t('dailyreplay.marketReview.title') }}
        <div slot="content">
          <Collapse>
            <Panel name="marketReview.market">
              {{ $t('dailyreplay.marketReview.market') }}
              <div slot="content">
                <FormItem>
                  <Input v-model="dailyreplay.marketreview.market" type="textarea" :rows="6" style="width:50rem" placeholder="Enter something..."/>
                </FormItem>
              </div>
            </Panel>
            <Panel name="marketReview.sympatheticStock">
              {{ $t('dailyreplay.marketReview.sympatheticStock') }}
              <div slot="content">
                <FormItem :label="$t('dailyreplay.dragon')">
                  <text-and-input v-for="(item, i) in dailyreplay.marketreview.sympatheticstock.dragon"
                                  v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d" @input="handleInput($event, i, 'dragon')"></text-and-input>
                </FormItem>
                <FormItem :label="$t('dailyreplay.oneTrading')">
                  <text-and-input v-for="(item, i) in dailyreplay.marketreview.sympatheticstock.onetrading"
                                  v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d" @input="handleInput($event, i, 'onetrading')"></text-and-input>
                </FormItem>
                <FormItem :label="$t('dailyreplay.twoTrading')">
                  <text-and-input v-for="(item, i) in dailyreplay.marketreview.sympatheticstock.twotrading"
                                  v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d" @input="handleInput($event, i, 'twotrading')"></text-and-input>
                </FormItem>
                <FormItem :label="$t('dailyreplay.threeTrading')">
                  <text-and-input v-for="(item, i) in dailyreplay.marketreview.sympatheticstock.threetrading"
                                  v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d" @input="handleInput($event, i, 'threetrading')"></text-and-input>
                </FormItem>
                <FormItem :label="$t('dailyreplay.fourTrading')">
                  <text-and-input v-for="(item, i) in dailyreplay.marketreview.sympatheticstock.fourtrading"
                                  v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d" @input="handleInput($event, i, 'fourtrading')"></text-and-input>
                </FormItem>
                <FormItem :label="$t('dailyreplay.breakTrading')">
                  <text-and-input v-for="(item, i) in dailyreplay.marketreview.sympatheticstock.breaktrading"
                                  v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d" @input="handleInput($event, i, 'breaktrading')"></text-and-input>
                </FormItem>
                <FormItem :label="$t('dailyreplay.bigFall')">
                  <text-and-input v-for="(item, i) in dailyreplay.marketreview.sympatheticstock.bigfall"
                                  v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d" @input="handleInput($event, i, 'bigfall')"></text-and-input>
                </FormItem>
                <FormItem :label="$t('dailyreplay.subNewStock')">
                  <text-and-input v-for="(item, i) in dailyreplay.marketreview.sympatheticstock.subnewstock"
                                  v-bind:key="i" v-bind:n="item.n" v-bind:d="item.d" @input="handleInput($event, i, 'subnewstock')"></text-and-input>
                </FormItem>
              </div>
            </Panel>
            <Panel name="marketReview.summary">
              {{ $t('dailyreplay.marketReview.summary') }}
              <div slot="content">
                <FormItem>
                  <Col span="4" offset="1">
                  {{ $t('dailyreplay.breakTradingRate') }}
                  <Input v-model="dailyreplay.marketreview.summary.breaktradingrate" style="width:2rem"/>
                  %
                  </Col>
                  <Col span="4" offset="1">
                  {{ $t('dailyreplay.contiTradingRate') }}
                  <Input v-model="dailyreplay.marketreview.summary.contitradingrate" style="width:2rem"/>
                  %
                  </Col>
                </FormItem>
                <FormItem>
                  <Input v-model="dailyreplay.marketreview.summary.sum" type="textarea" :rows="6" style="width:50rem" placeholder="Enter something..."/>
                </FormItem>
              </div>
            </Panel>
          </Collapse>
        </div>
      </Panel>
      <!--热点-->
      <Panel name="hotspot">
        {{ $t('dailyreplay.hotspot.title') }}
        <div slot="content">
          <FormItem
            v-for="(item, index) in dailyreplay.hotspot"
            :key="index">
            <Col span="12">
            <Input v-model="item.name" placeholder="something"/>
            <Select v-model="item.complexhot" style="width:100px">
              <Option v-for="item in complexhot" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
            <Select v-model="item.dragon" style="width:100px">
              <Option v-for="item in havedragon" :value="item.value" :key="item.value">{{ item.label }}</Option>
            </Select>
            <Input v-model="item.sum" placeholder="something"/>
            </Col>
          </FormItem>
          <FormItem>
            <Col span="4">
            <Button type="dashed" long @click="handleAddHotspot" icon="plus-round">Add</Button>
            </Col>
          </FormItem>
        </div>
      </Panel>
      <!--情绪股-->
      <Panel name="sympatheticStock">
        {{ $t('dailyreplay.sympatheticStock.title') }}
        <div slot="content">
          <FormItem
            :label="$t('dailyreplay.dragon')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.dragon"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('dragon')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.dragonTwo')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.dragontwo"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('dragontwo')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.subNewStock')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.subnewstock"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('subnewstock')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.mainBreakTrading')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.mainbreaktrading"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('mainbreaktrading')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.nomainBreakTrading')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.nomainbreaktrading"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('nomainbreaktrading')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.bigFall')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.bigfall"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('bigfall')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.stopTrade')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.stoptrade"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('stoptrade')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.oneTrading')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.onetrading"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('onetrading')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.twoTrading')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.twotrading"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('twotrading')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.threeTrading')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.threetrading"
                 :key="index">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('threetrading')" icon="plus-round">Add</Button>
          </FormItem>
          <FormItem
            :label="$t('dailyreplay.fourTrading')">
            <Col span="4"
                 v-for="(item, index) in dailyreplay.sympatheticstock.fourtrading"
                 :key="index"
                 :label="$t('dailyreplay.fourTrading')">
            <Input v-model="item.n" placeholder="something"/>
            </Col>
            <Button type="dashed"  @click="handleAddStock('fourtrading')" icon="plus-round">Add</Button>
          </FormItem>
          <h3 style="color: #ed3f14;">{{ $t('dailyreplay.notice') }}</h3>
        </div>
      </Panel>
      <!--中线股一览-->
      <!--<Panel name="midstock">-->
        <!--{{ $t('dailyreplay.marketReview.title') }}-->
        <!--<div slot="content">-->
        <!--</div>-->
      <!--</Panel>-->
    </Collapse>
    <div style="padding-top:1.25rem;">
      <!--<Button type="primary"-->
              <!--@click="setConfig">{{ $t('tip.save') }}</Button>-->
      <Button type="primary" @click="save()">{{ $t('tip.save') }}</Button>
    </div>
  </Form>
</template>

<script>
  import textAndInput from '@/components/TextAndInput'

  export default {
    name: 'DailyReplay',
    components: {
      'text-and-input': textAndInput
    },
    data() {
      return {
        dailyreplay: {
          data: {
            trading:'',
            noninlinetrading:'',
            failing:'',
            profitmarkingeffect:'',
            rise:'',
            fall:'',
            marginfinancing:{
                change:'',
                sum:''
            },
            foreigncapital:{
                sum:'',
                sh:[''],
                sz:['']
            }
          },
          complexinflow:{
            inflows:['','','','',''],
            outflows:['','','','','']
          },
          marketreview:{
            market:'',
            sympatheticstock:{
                dragon:[],
                onetrading:[],
                twotrading:[],
                threetrading:[],
                fourtrading:[],
                breaktrading:[],
                bigfall:[],
                subnewstock:[]
            },
            summary:{
              breaktradingrate:'',
              contitradingrate:'',
              sum:''
            }
          },
          hotspot:[{
            name:'',
            complexhot:'',
            dragon:'',
            sum:''
          }],
          sympatheticstock:{
            dragon:[],
            dragontwo:[],
            subnewstock:[],
            mainbreaktrading:[],
            nomainbreaktrading:[],
            bigfall:[],
            stoptrade:[],
            onetrading:[],
            twotrading:[],
            threetrading:[],
            fourtrading:[],
            breaktrading:[]
          }
//          appConfig: {}
        },

        //select option
        profitMarkingEffect: [
          {
            value: '好（>4）',
            label: '好（>4）'
          },
          {
            value: '较好（2.5-4）',
            label: '较好（2.5-4）'
          },
          {
            value: '中（1.5-2.5）',
            label: '中（1.5-2.5）'
          },
          {
            value: '较差（0.5-1.5）',
            label: '较差（0.5-1.5）'
          },
          {
            value: '差（<0.5）',
            label: '差（<0.5）'
          }
        ],
        marginFinancing:[
          {
            value: '上升',
            label: '上升'
          },
          {
            value: '下降',
            label: '下降'
          },],
        foreignCapital:[
          {
            value: '流入',
            label: '流入'
          },
          {
            value: '流出',
            label: '流出'
          },],
        complexhot:[
          {
            value:'有板块效应',
            label: '有板块效应'
          },
          {
            value:'无明显板块效应',
            label: '无明显板块效应'
          },
          {
            value:'无板块效应',
            label: '无板块效应'
          }, ],
        havedragon:[
          {
            value:'有龙头',
            label: '有龙头'
          },
          {
            value:'无龙头',
            label: '无龙头'
          },
        ],

      }
    },

    mounted: function () {
      // `this` 指向 vm 实例
      this.getSympatheticStock();
    },

    methods: {
      getSympatheticStock() {
        this.$http.get(`http://127.0.0.1:26339/replay/sympatheticStock`)
          .then(result => {
            this.dailyreplay.marketreview.sympatheticstock = result.data.replay.sympatheticstock
          });
      },
      handleAddHotspot() {
        this.dailyreplay.hotspot.push({
          name: '',
          complexhot: '',
          dragon: '',
          sum: ''
        });
      },
      handleAddStock(category) {
//        this.dailyreplay.sympatheticstock[category].index++;
        this.dailyreplay.sympatheticstock[category].push({
          n: '',
          d: ''
        });
      },
      handleAddForeigncapital(category) {
        this.dailyreplay.data.foreigncapital[category].push('');
      },
      handleInput(val, i, category) {
        this.dailyreplay.marketreview.sympatheticstock[category][i].d = val;
      },
      save() {
        this.$http
          .post(`http://127.0.0.1:26339/replay/save`, this.dailyreplay)
          .then(result => {
                if (result.data.success){
                  var _dateStr = getDateString();
                  var year = _dateStr.substr(0, 4);
                  var month = _dateStr.substr(4, 2);
                  var day = _dateStr.substr(6, 2);
                  var report = "report/" + year + "/" + month + "/" + day;
                  this.$router.replace(report);
                }else{
                  alert("保存失败");
                }
              }
          );
      },
      getDateString() {
        this._date = new Date();
        var _year = date.getFullYear();
        var _month = date.getMonth() + 1;    // 月从0开始计数
        var _d = date.getDate();

        _month = (_month > 9) ? ("" + _month) : ("0" + _month);
        _d = (_d > 9) ? ("" + _d) : ("0" + _d);
        return _year + _month + _d;
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .dailyreplay-form .ivu-input-wrapper {
    width: 10rem;
  }
  .dailyreplay-form .ivu-select {
    width: 10rem;
  }
  .dailyreplay-form .string-input {
    width: 10rem;
  }
</style>
