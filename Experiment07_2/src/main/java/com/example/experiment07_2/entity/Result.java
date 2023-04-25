package com.example.experiment07_2.entity;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.HashMap;

/**
 * @author Owem
 * @date 2023/3/15 20:14
 * @description TODO
 **/
@Data
public class Result {
    private int status;
    private String message;
    private HashMap<String, Object> data;

    public static Result SUCCESS(String mes, HashMap<String, Object> map) {
        Result result = new Result();
        result.setStatus(1);
        result.setMessage(mes);
        result.setData(map);
        return result;
    }
    public static Result SUCCESS(String msg, PageInfo data) {
        Result result = new Result();
        result.setStatus(1);
        result.setMessage(msg);

        HashMap<String, Object> map = new HashMap<>();
        map.put("total", data.getTotal());
        map.put("list", data.getList());

        result.setData(map);
        return result;
    }

    public static Result ERROR(String mes, HashMap<String, Object> map) {
        Result result = new Result();
        result.setStatus(2);
        result.setMessage(mes);
        result.setData(map);
        return result;
    }
}
