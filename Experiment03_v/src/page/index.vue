<template>
  <section class="project_section">
    <header class="section_title" style="margin: 30px">学生信息数据表</header>
    <el-row style="margin-top: 20px; display: flex; flex-direction:column;">
      <el-row style="display: flex;justify-content: flex-end;">
        <el-button type="danger" style="margin: 15px; width: 100px;" @click="handleAdd">添加用户</el-button>
      </el-row>
      <el-form ref="formData" label-width="110px" class="demo-formData">
        <el-table :data="tableData" highlight-current-row border>
          <el-table-column type="index" width="100px"></el-table-column>
          <el-table-column property="id" label="学号"></el-table-column>
          <el-table-column property="name" label="姓名"></el-table-column>
          <el-table-column property="gender" label="性别"></el-table-column>
          <el-table-column property="email" label="电子邮箱"></el-table-column>
          <el-table-column property="identityCard" label="身份证号"></el-table-column>
          <el-table-column label="操作" width="240px">
            <template v-slot="scope">
              <el-button size="small" type="primary" @click="handleDetails(scope.$index)" style="width: 100px">查看详情</el-button>
              <el-button size="small" type="danger" @click="handleDelete(scope.$index)" style="width: 100px">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="Pagination" style="text-align: left;margin-top: 10px;">
          <el-pagination @current-change="handleCurrentChange" :current-page="pageForm.pageNum"
                         :page-size="pageForm.pageSize" layout="total, prev, pager, next" :total="total">
          </el-pagination>
        </div>
      </el-form>
    </el-row>
  </section>
</template>

<script>
import {getAllUser, deleteUser} from "@/api/getData";

export default {
  name: "index",
  data() {
    return {
      tableData: [],
      pageForm: {
        pageNum: 1,
        pageSize: 5
      },
      total: 0
    }
  },
  mounted() {
    this.loadUserInfo()
  },
  methods: {
    async loadUserInfo() {
      const res = await getAllUser({pageNum: this.pageForm.pageNum, pageSize: this.pageForm.pageSize})
      // console.log("获取全部用户数据 RES", res)
      if (res.status === 1) {
        this.tableData = []
        this.total = res.data.total
        const _this = this
        res.data.list.forEach(user => {
          _this.tableData.push({
            id: user.id,
            name: user.name,
            gender: user.gender? '男' : '女',
            email: user.email,
            identityCard: user.identityCard
          })
        })
      }
    },
    async handleCurrentChange(index) {
      this.pageForm.pageNum = index
      await this.loadUserInfo()
    },
    handleDetails(index) {
      this.$router.push({name: '用户信息', query: {id: this.tableData[index].id}})
    },
    async handleDelete(index) {
      const res = await deleteUser({id: this.tableData[index].id})
      if (res.status === 1) {
        await this.loadUserInfo()
      } else {
        this.$message({
          type: "error",
          message: "delete error"
        })
      }
    },
    handleAdd() {
      this.$router.push({name: '添加用户'})
    }
  }
}
</script>

<style lang="less">
@import '../style/mixin';

.data_section {
  padding: 20px;
  margin-bottom: 40px;

  .section_title {
    text-align: center;
    font-size: 30px;
    margin-bottom: 10px;
  }

  .data_list {
    text-align: center;
    font-size: 14px;
    color: #666;
    border-radius: 6px;
    background: #E5E9F2;

    .data_num {
      color: #333;
      font-size: 26px;

    }

    .head {
      border-radius: 6px;
      font-size: 22px;
      padding: 4px 0;
      color: #fff;
      display: inline-block;
    }
  }

  .today_head {
    background: #FF9800;
  }

  .all_head {
    background: #20A0FF;
  }
}

.project_section {
  .section_title {
    text-align: center;
    font-size: 25px;
    margin-bottom: 10px;
  }
}

.wan {
  .sc(16px, #333)
}
</style>