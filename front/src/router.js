import Vue from 'vue'
import Router from 'vue-router'
import Entry from './views/Entry.vue'


Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/',
      redirect: '/form_list',
      name: 'entry', //业务入口页面
      component: Entry,
      children: [
        // 自动以表单相关页面---开始
        {
          path: 'form_list',
          name: 'form_list',
          component: () => import('./views/flwo_form_design/List.vue')
        }
        // 自动以表单相关页面---结束
      ]
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (about.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    // }
  ]
})