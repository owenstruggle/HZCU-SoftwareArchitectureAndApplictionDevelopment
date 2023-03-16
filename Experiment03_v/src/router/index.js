import Vue from 'vue'
import Router from 'vue-router'

import index from '@/page/index.vue'
import userInfo from "@/page/userInfo.vue";
import addUser from "@/page/addUser.vue";

Vue.use(Router)

const routes = [{
    path: '/',
    name: '主页',
    component: index,
    meta: [''],
}, {
	path: '/user',
	name: '用户信息',
	component: userInfo,
	meta: [''],
},{
	path: '/add',
	name: '添加用户',
	component: addUser,
	meta: [''],
}
]

export default new Router({
    routes,
    strict: process.env.NODE_ENV !== 'production'
})
