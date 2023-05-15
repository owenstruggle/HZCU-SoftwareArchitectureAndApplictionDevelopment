<template>
    <div class="login_page fillcontain">
        <div class="background">
            <img :src="imgSrc" width="100%" height="100%" alt="background"/>
        </div>
        <!-- 中间子页面 -->
        <transition name="form-fade" mode="in-out">
            <section class="form_contianer" v-show="showLogin">
                <el-form :model="loginForm" :rules="rules" ref="loginForm">
                    <!-- 用户名 -->
                    <el-form-item prop="accountId">
                        <el-input v-model="loginForm.accountId" placeholder="用户名"><span>dsfsf</span></el-input>
                    </el-form-item>
                    <!-- 密码 -->
                    <el-form-item prop="password">
                        <el-input type="password" placeholder="密码" v-model="loginForm.password"></el-input>
                    </el-form-item>
                    <!-- 登录按钮 -->
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('loginForm')" class="submit_btn">登录</el-button>
                    </el-form-item>
                </el-form>
            </section>
        </transition>
    </div>
</template>

<script>
import {login} from '@/api/getData'
import {mapState} from 'vuex'

export default {
    data() {
        return {
            loginForm: {    // 用户登录信息
                accountId: '',
                password: '',
            },
            rules: {    // 表单验证
                accountId: [
                    {required: true, message: '请输入用户名', trigger: 'blur'},
                ],
                password: [
                    {required: true, message: '请输入密码', trigger: 'blur'}
                ],
            },
            showLogin: false,   // 是否展示登录
            imgSrc: require('../assets/background.png')   // 背景图
        }
    },
    mounted() {
        this.showLogin = true;
    },
    computed: {
        ...mapState(['userInfo']),
    },
    methods: {
        /**
         * @author Owem
         * @date 2023/3/23 15:26
         * @description 登录
         */
        async submitForm(formName) {
            this.$refs[formName].validate(async (valid) => {
                if (valid) {
                    const res = await login({accountId: this.loginForm.accountId, password: this.loginForm.password})
                    console.log("login RES", res)
                    if (res.status === 1) {
                        this.$message({
                            type: 'success',
                            message: res.message
                        });
                        // 存储返回的数据
                        this.$store.commit('setUserInfo', res.data)
                        await this.$router.push('/home')
                    } else {
                        this.$message({
                            type: 'error',
                            message: res.message
                        });
                    }
                } else {
                    this.$notify.error({
                        title: '错误',
                        message: '请输入正确的用户名密码',
                        offset: 100
                    });
                    return false;
                }
            });
        },
    }
}
</script>

<style lang="less" scoped>
@import '../style/mixin';

.login_page {
  background-color: #324057;
}

.manage_tip {
  position: absolute;
  width: 100%;
  top: -100px;
  left: 0;

  p {
    font-size: 34px;
    color: #fff;
  }
}

.form_contianer {
  .wh(320px, 210px);
  .ctp(320px, 210px);
  padding: 25px;
  border-radius: 5px;
  text-align: center;
  background-color: #fff;

  .submit_btn {
    width: 100%;
    font-size: 16px;
  }
}

.tip {
  font-size: 12px;
  color: red;
}

.background {
  width: 100%;
  height: 100%;
  overflow: hidden; // 解决图片下方滑动间隙
}

.form-fade-enter-active, .form-fade-leave-active {
  transition: all 1s;
}

.form-fade-enter, .form-fade-leave-active {
  transform: translate3d(0, -50px, 0);
  opacity: 0;
}
</style>
