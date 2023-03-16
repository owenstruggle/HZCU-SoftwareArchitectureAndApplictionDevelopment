<template>
  <section class="project_section">
    <header class="section_title" style="margin: 30px">学生信息创建表</header>
    <el-row style="margin-top: 20px;">
      <el-col :span="12" :offset="4">
        <el-form :model="formData" :rules="rules" ref="formData" label-width="110px" class="demo-formData">
          <el-form-item label="学号" prop="id">
            <el-input v-model="formData.id" placeholder="请输入学号"></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="formData.name" placeholder="请输入姓名"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="gender">
            <el-input v-model="formData.gender" placeholder="请输入性别"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="formData.email" placeholder="请输入邮箱"></el-input>
          </el-form-item>
          <el-form-item label="身份证号" prop="identityCard">
            <el-input v-model="formData.identityCard" placeholder="请输入身份证号"></el-input>
          </el-form-item>
          <el-form-item class="button_submit">
            <el-button type="primary" @click="submitForm">立即创建</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </section>
</template>

<script>

import {addUser} from "@/api/getData";

export default {
  name: "addUser",
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
  methods: {
    async submitForm() {
      if (!this.verify()) {
        this.$message({
          type: 'error',
          message: "身份证验证错误"
        });
        return
      }
      const res = await addUser({
        id: this.formData.id,
        name:this.formData.name,
        gender:this.formData.gender === '男',
        identityCard: this.formData.identityCard,
        email: this.formData.email
      })
      if (res.status === 1) {
        this.$message({
          type: 'success',
          message: "新建成功"
        });
        await this.$router.push({name: '用户信息', query: {id: this.formData.id}})
      } else {
        this.$message({
          type: 'error',
          message: "新建失败"
        });
      }
    },
    verify() {
      if (this.formData.id === '' || this.formData.name === '' || this.formData.gender === '' || this.formData.email === '' || this.formData.identityCard === '')
        return false

      let factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
      let parity = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];
      let code = this.formData.identityCard.substring(17);
      let sum = 0;
      for (let i = 0; i < 17; i++) {
        sum += this.formData.identityCard[i] * factor[i];
      }
      return parity[sum % 11] === code.toUpperCase();
    }
  }
}
</script>

<style scoped>

</style>