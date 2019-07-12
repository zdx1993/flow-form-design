<template>
  <div class="entry">
    <div class="nav" style="background:#ddd">
      导航栏
    </div>
    <router-view></router-view>
    <div class="footer" style="background:#ddd">
      页脚
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'EntryPage'
}
</script>
