package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 泛型T表示数据 data 的类型
 *
 * @auther Stiles-JKY
 * @date 2020/11/3-10:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //404 not_found
    private Integer code;//状态码
    private String message;//错误消息
    private T data;//泛型类

    //只有状态码 code 和 错误消息 message
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
