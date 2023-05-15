package com.example.experiment09_1.service.intf;

import com.example.experiment09_1.entity.AccountDAO;
import com.example.experiment09_1.entity.Result;

/**
 * @author Owem
 * @date 2023/5/15 08:44
 * @description TODO
 **/
public interface AccountServer {
    Result accountLogin(AccountDAO account);
}
