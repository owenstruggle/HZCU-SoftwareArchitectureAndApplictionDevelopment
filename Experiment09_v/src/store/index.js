/**
 * @author Owem
 * @date 2023/3/23 15:26
 * @description store 配置
 */

import Vue from 'vue'
import Vuex from 'vuex'
import storage from "@/store/storage";

Vue.use(Vuex)

const state = {
	userInfo: storage.get('userInfo'),		// 用户数据
}

// 计算属性
const mutations = {
	setUserInfo(state, userInfo) {
		state.userInfo = userInfo;
		storage.set('userInfo', userInfo)
	}
}

// 外部调取的方法
const actions = {
	setUserInfoFun(context, userInfo) {
		context.commit('setUserInfo', userInfo);
	}
}

export default new Vuex.Store({
	state,
	actions,
	mutations,
})
