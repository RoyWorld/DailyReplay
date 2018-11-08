<template>
  <div class='calendar' id='calendar'>
    <div class="calendar-title-box">
      <span class='prev-month' id='prevMonth' @click="toPrevMonth"></span>
      <span class='calendar-title' id='calendarTitle'>
        <span>{{calendarYear}}</span>年
        <span>
          <Dropdown trigger="click" @on-click="selectMonth">
          {{calendarMonth}}
          <DropdownMenu slot="list">
            <DropdownItem v-for="month in 12" :name="month" v-bind:key="month">{{month}}</DropdownItem>
          </DropdownMenu>
          </Dropdown>
        </span>月</span>
      <span id='nextMonth' class='next-month' @click="toNextMonth"></span>
    </div>
    <div class="calendar-body-box">
      <table ref="calendarTable" class='calendar-table'>
        <tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr>
        <tr v-for="count in 6"><td v-for="count in 7" @click="getReport"></td></tr>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Calendar',
    data () {
      return {
        completeDate: [],
        calendarYear: '',
        calendarMonth: '',
        _date : '',
      }
    },
    created: function () {
      // `this` 指向 vm 实例
      this.init();
    },
    mounted: function () {
      this.showCalendarData();
    },
    methods : {
      /**
       * 表格中显示数据，并设置类名
       */
      init() {
        this._date = new Date();
      },

      /**
       * 展示日历数据
       */
      showCalendarData() {
        var _year = this._date.getFullYear();
        var _month = this._date.getMonth() + 1;

        var _dateStr = this.getDateStr(this._date);
        // 设置顶部标题栏中的 年、月信息
        this.calendarYear = _dateStr.substr(0, 4);
        this.calendarMonth = _dateStr.substr(4, 2);
        var completeDate = [];

        this.$http.get(`http://127.0.0.1:26339/completeDate/${_year}/${_month}`)
          .then(result => {
            this.show(_year, _month, result.data.completeDate);
          });
      },

      show(_year, _month, _completeDate) {
        this.completeDate = _completeDate;

        // 设置表格中的日期数据
        var _table = this.$refs.calendarTable;
        var _tds = _table.getElementsByTagName("td");
        var _firstDay = new Date(_year, _month - 1, 1);  // 当前月第一天
        for(var i = 0; i < _tds.length; i++) {
          var _thisDay = new Date(_year, _month - 1, i + 1 - _firstDay.getDay());
          var _thisDayStr = this.getDateStr(_thisDay);
          _tds[i].innerText = _thisDay.getDate();
          //_tds[i].data = _thisDayStr;
          _tds[i].setAttribute('data', _thisDayStr);
          if(_thisDayStr == this.getDateStr(new Date())) {    // 当前天
            _tds[i].className = 'currentDay';
          }else if(_thisDayStr.substr(0, 6) == this.getDateStr(_firstDay).substr(0, 6)) {
            _tds[i].className = 'currentMonth';  // 当前月
          }else {    // 其他月
            _tds[i].className = 'otherMonth';
          }

          if (this.isCompleteDate(_thisDayStr)){
            _tds[i].className += ' completeDay';
          }
        }
      },

      /**
       * 点击选择月
       */
      selectMonth(name) {
        var date = this._date;
        this._date = new Date(date.getFullYear(), name - 1, 1);
        this.showCalendarData();
      },

      /**
       * 点击上个月图标触发
       */
      toPrevMonth() {
        var date = this._date;
        this._date = new Date(date.getFullYear(), date.getMonth() - 1, 1);
        this.showCalendarData();
      },

      /**
       * 点击下个月图标触发
       */
      toNextMonth() {
        var date = this._date;
        this._date = new Date(date.getFullYear(), date.getMonth() + 1, 1);
        this.showCalendarData();
      },

      /**
       * 日期转化为字符串， 4位年+2位月+2位日
       */
      getDateStr(date) {
        var _year = date.getFullYear();
        var _month = date.getMonth() + 1;    // 月从0开始计数
        var _d = date.getDate();

        _month = (_month > 9) ? ("" + _month) : ("0" + _month);
        _d = (_d > 9) ? ("" + _d) : ("0" + _d);
        return _year + _month + _d;
      },

      /**
       * 判断date是否已完成
       * @param date
       */
      isCompleteDate(date) {
        var bool = false;
        this.completeDate.forEach(function(element) {
            if (date == element){
                bool = true;
            }
        })
        return bool;
      },

      getReport() {
        if (event) {
            if (event.target.className.indexOf("completeDay") != -1){
                var day = event.target.innerText;
                var report = "report/" + this.calendarYear + "/" + this.calendarMonth + "/" + day;
                this.$router.replace(report);
            }
        }
      },

    }
  }

</script>


<style>
  /* 整体设置 */
  *{margin:0px;padding:0px;}

  /**
  * 设置日历的大小
  */
  .calendar{
    font-size: 30px;
    width: 550px;
    height: 500px;
    display: block;
  }

  /**
  * 设置日历顶部盒子
  */
  .calendar .calendar-title-box{
    position: relative;
    width: 100%;
    height: 72px;
    line-height: 72px;
    text-align:center;
    border-bottom: 2px solid #ddd;
  }

  /**
  * 设置上个月的按钮图标
  */
  .calendar .prev-month {
    position: absolute;
    top: 24px;
    left: 0px;
    display: inline-block;
    width: 0px;
    height: 0px;
    border-left: 0px;
    border-top: 12px solid transparent;
    border-right: 16px solid #999;
    border-bottom: 12px solid transparent;
    cursor: pointer;
  }

  /**
  * 设置下个月的按钮图标
  */
  .calendar .next-month {
    position: absolute;
    top: 24px;
    right: 0px;
    display: inline-block;
    width: 0px;
    height: 0px;
    border-right: 0px;
    border-top: 6px solid transparent;
    border-left: 16px solid #999;
    border-bottom: 12px solid transparent;
    cursor: pointer;
  }


  /* 设置日历表格样式 */
  .calendar-table{
    width: 100%;
    border-collapse: collapse;
    text-align:center;
  }

  /* 表格行高 */
  .calendar-table tr{
    height: 60px;
    line-height: 60px;
  }

  .completeDay {
    border: 2px solid #00ff00;
  }

  /* 当前天 颜色特殊显示 */
  .currentDay {
    color: red;
  }

  /* 本月 文字颜色 */
  .currentMonth {
    color: #999;
  }

  /* 其他月颜色 */
  .otherMonth{
    color: #ede;
  }
</style>
