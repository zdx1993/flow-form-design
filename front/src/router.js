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
        // 动态表单相关页面---开始
        {
          path: 'form_list',
          name: 'form_list',
          component: () => import('./views/flwo_form_design/List.vue')
        },
        {
          path: 'form_details',
          name: 'form_details',
          component: () => import('./views/flwo_form_design/FormDetails.vue')
        },
        // 动态表单相关页面---结束
        // 发起流程页面---开始
        { //起始页
          path: 'demo_entry',
          name: 'demo_entry',
          component: () => import('./views/business/leave/DemoEntry.vue')
        },
        { //表单申请页
          path: 'start_page',
          name: 'start_page',
          component: () => import('./views/business/leave/startPage.vue')
        },
        // 发起流程页面---结束
        // 流程审核页面---开始
        { //审核列表页
          path: 'apply_list',
          name: 'apply_list',
          component: () => import('./views/business/applyLeave/ApplyList.vue')
        },       
        { //审核详情页
          path: 'apply_details',
          name: 'apply_details',
          component: () => import('./views/business/applyLeave/ApplyDetails.vue')
        },   
        // 流程审核页面---结束
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