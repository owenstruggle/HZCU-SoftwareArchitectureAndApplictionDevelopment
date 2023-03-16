<template>
  <section class="project_section">
    <header class="section_title" style="margin: 30px">学生信息数据表</header>
    <el-row style="margin-top: 20px;">
      <el-col :span="12" :offset="4">
        <el-form :model="formData" ref="formData" label-width="110px" class="demo-formData">
          <el-form-item label="学号" prop="projectName">
            <el-input v-model="formData.id" disabled></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="projectName">
            <el-input v-model="formData.name" disabled></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="projectName">
            <el-input v-model="formData.gender" disabled></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="projectName">
            <el-input v-model="formData.email" disabled></el-input>
          </el-form-item>
          <el-form-item label="身份证号" prop="projectName">
            <el-input v-model="formData.identityCard" disabled></el-input>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </section>
</template>

<script>
import {getUser} from "@/api/getData";

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
    }
  }
}
</script>

<style scoped>

</style>