package com.ignore.exception.strategy;

import com.ignore.enumerate.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: ignore1992
 * @Description: 推送策略异常
 * @Date: Created In 10:11 2019/1/30
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class PushStrategyException extends RuntimeException{
    private String msg;
    private ExceptionEnum exception;
}
