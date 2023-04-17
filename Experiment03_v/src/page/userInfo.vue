<template>
  <section class="project_section">
    <header class="section_title" style="margin: 30px">学生信息数据表</header>
    <el-row style="margin-top: 20px;">
      <el-col :span="12" :offset="4">
        <el-form :model="formData" :rules="rules" ref="formData" label-width="110px" class="demo-formData">
          <el-form-item label="学号" prop="id">
            <el-input v-model="formData.id" disabled></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="formData.name"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="gender">
            <el-input v-model="formData.gender"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="formData.email"></el-input>
          </el-form-item>
          <el-form-item label="身份证号" prop="identityCard">
            <el-input v-model="formData.identityCard"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button size="small" type="primary" @click="handleUpdate()" style="width: 100px">更新</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </section>
</template>

<script>
import {getUser, updateUser} from "@/api/getData";

export default {
  name: "userInfo",
  data() {
    return {
      formData: {
        id: "",
        name: "",
        email: "",
        gender: "",
        identityCard: ""
      },
      rules: {
        id: [
          {required: true, message: '请输入学号', trigger: 'blur'},
          {type: 'string', message: '请输入正确的学号', len: 8}
        ],
        name: [
          {required: true, message: '请输入姓名', trigger: 'blur'},
          //   1、不能有特殊字符和数字；2、可以输入英文，可以有空格，可以输入英文名字中的点；3、可以输入汉字；4、中文英文不能同时出现；5、长度在1-20；
          {type: 'string', message: '请输入正确的姓名', pattern: /^([\u4e00-\u9fa5]{1,20}|[a-zA-Z\.\s]{1,20})$/}
        ],
        gender: [
          {required: true, message: '请输入性别', trigger: 'blur'},
          {type: 'string', message: '请输入正确的性别', pattern: /^(男|女)$/}
        ],
        email: [
          {required: true, message: '请输入邮箱', trigger: 'blur'},
          {type: 'email', message: '请输入正确的邮箱', trigger: ['blur', 'change']}
        ],
        identityCard: [
          {required: true, message: '请输入身份证号', trigger: 'blur'},
          {
            type: 'string',
            message: '请输入正确的身份证号',
            pattern: /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/
          }
        ]
      }
    }
  },
  mounted() {
    console.log(this.$route.query.id)
    if (this.$route.query.id && this.formData.id !== this.$route.query.id) {
      this.formData.id = this.$route.query.id
      this.getUserInfo()
    }
  },
  methods: {
    async getUserInfo() {
      const res = await getUser({id: this.formData.id})
      console.log("获取用户数据 RES", res)
      if (res.status === 1) {
        this.formData = {
          id: res.data.user.id,
          name: res.data.user.name,
          gender: res.data.user.gender ? '男' : '女',
          email: res.data.user.email,
          identityCard: res.data.user.identityCard
        }
      }
    },
    async handleUpdate() {
      const res = await updateUser({
          id: this.formData.id,
          name: this.formData.name,
          gender: this.formData.gender === '男',
          email: this.formData.email,
          identityCard: this.formData.identityCard
        })
      if (res.status === 1) {
        this.$message({
          type: "success",
          message: res.message
        })
        await this.loadUserInfo()
      } else {
        this.$message({
          type: "error",
          message: "update error"
        })
      }
    }
  }
}
</script>

<style scoped>

</style>