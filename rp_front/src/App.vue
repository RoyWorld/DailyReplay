<template>
  <div id="app">

    <Menu mode="horizontal"
            theme="dark"
            :active-name="$route.path.substring(1)"
            @on-select="forward"
            name="root">
      <MenuItem name="welcome">
        <Icon type="ios-time"></Icon>
        {{ $t("nav.welcome") }}
      </MenuItem>
      <MenuItem name="dailyreplay">
        <Icon type="ios-play"></Icon>
        {{ $t("nav.dailyreplay") }}
      </MenuItem>
      <MenuItem name="selfselection">
        <Icon type="md-star"></Icon>
        {{ $t("nav.selfselection") }}
      </MenuItem>
      <MenuItem name="principle">
        <Icon type="md-bulb"></Icon>
        {{ $t("nav.principle") }}
      </MenuItem>
      <MenuItem name="graph">
        <Icon type="md-cut"></Icon>
        {{ $t("nav.graph") }}
      </MenuItem>
      <MenuItem name="modestatic">
        <Icon type="md-stats"></Icon>
        {{ $t("nav.modestatic") }}
      </MenuItem>
    </Menu>

    <div style="padding: 1.25rem 1.25rem">
      <router-view/>
    </div>
  </div>

</template>

<script>

  export default {
    name: 'App',
    methods:{
      forward(route) {
        this.$router.push({ name: route })
      },
    },
    components: {
    }
  }
</script>

<style scoped>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  font-size: 1rem;
  color: #2c3e50;
}
i.action-icon {
  cursor: pointer;
  font-size: 1.25rem;
}
i.tip-icon {
  position: relative;
  top: 5px;
  padding-left: 5px;
}
i.action-icon + i.action-icon {
  padding-left: 0.625rem;
}
</style>
