package com.example.experiment09_1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.experiment09_1.entity.AccountDAO;
import com.example.experiment09_1.entity.Result;
import com.example.experiment09_1.mapper.AccountMapper;
import com.example.experiment09_1.service.intf.AccountServer;
import com.example.experiment09_1.utils.MD5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author Owem
 * @date 2023/5/15 08:44
 * @description TODO
 **/
@Service
public class AccountServerImpl implements AccountServer {
    @Resource
    AccountMapper accountMapper;
    @Value("${UserParams.Admin_SALT}")
    String Admin_SALT;
    @Value("${UserParams.User_SALT}")
    String User_SALT;

    @Override
    public Result accountLogin(AccountDAO account) {
        AccountDAO sourceAccount = accountMapper.selectOne(new QueryWrapper<AccountDAO>().eq("account_id", account.getAccountId()).eq("password", account.getPassword()));
        if (sourceAccount == null) {
            return Result.ERROR("登录失败", new HashMap<>());
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("accountId", account.getAccountId());
        if (sourceAccount.getJurisdiction() == 0) {
            map.put("token", MD5Util.encode(account.getAccountId(), Admin_SALT));
        } else {
            map.put("token", MD5Util.encode(account.getAccountId(), User_SALT));
        }
        return Result.SUCCESS("登录成功", map);
    }
}
