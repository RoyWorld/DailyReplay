<template>
  <span id="clock">
    Time:
    <span class="date">{{ date }}</span>
    <span class="time">{{ time }}</span>
  </span>
</template>

<script>
  export default {
    name: 'DigitalClock',
    data () {
      return {
        time: '',
        date: '',
        week: ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
      }
    },
    mounted: function () {
      // `this` 指向 vm 实例
      this.todo();
    },
    methods: {
      zeroPadding(num, digit) {
        var zero = '';
        for(var i = 0; i < digit; i++) {
          zero += '0';
        }
        return (zero + num).slice(-digit);
      },
      todo: function(){
        setInterval(function(){
            var cd = new Date();
            this.time = this.zeroPadding(cd.getHours(), 2) + ':' + this.zeroPadding(cd.getMinutes(), 2) + ':' + this.zeroPadding(cd.getSeconds(), 2);
            this.date = this.zeroPadding(cd.getFullYear(), 4) + '-' + this.zeroPadding(cd.getMonth()+1, 2) + '-' + this.zeroPadding(cd.getDate(), 2) + ' ' + this.week[cd.getDay()];
        }.bind(this), 1000);
      }
    }
  }

</script>

<style>
  #clock {
    font-family: 'Share Tech Mono', monospace;
    color: #ffffff;
    /*transform: translate(-50%, -50%);*/
    color: #daf6ff;
    text-shadow: 0 0 20px rgba(10, 175, 230, 1), 0 0 20px rgba(10, 175, 230, 0);
    color: #000000;
  }
  .time {
    color: #000000;
    width: 100%;
    letter-spacing: 0.05em;
    font-size: 12px;
    padding: 5px 0;
  }
  .date {
    color: #000000;
    width: 100%;
    letter-spacing: 0.1em;
    font-size: 12px;
  }
</style>
