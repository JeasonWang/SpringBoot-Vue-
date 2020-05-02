<template>
  <div v-loading="loading">
    <el-row>
      <el-col :span="10" :offset="7">
        <el-card :body-style="{ padding: '0px' }">
          <img :src="user.userface" :alt="user.nickname" class="image">
          <div style="padding: 14px;">
            <p>姓名：{{user.username}}</p>
            <p>昵称：{{user.nickname}}</p>
            <p>邮箱：{{user.email}}</p>
            <p>注册时间：{{user.regTime}}</p>
            <p>状态：{{user.enabled == 1 ? '启用' : '禁用'}}</p>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
              <el-button type="primary" style="line-height: 10px" @click="updateUser">修改</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>
<script>
  import {getRequest} from "../utils/api";

  export default {
    mounted() {
      getRequest("/currentUser").then(resp=> {
        if (resp.status == 200) {
          this.user = resp.data;
        }
      })
    },
    data() {
      return {
        user: null,
        currentDate: new Date()
      };
    },
    methods: {
      updateUser: function () {

      }
    }
  }
</script>
<style scoped>
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .image {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    display: block;
    margin: auto;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
</style>
