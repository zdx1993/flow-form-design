<template>
  <div class="entry">
    <div class="nav">
      <ul>
        <li>导航栏</li>
      </ul>
    </div>
    <router-view></router-view>
    <div class="footer">
      页脚
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'home'
}
</script>
