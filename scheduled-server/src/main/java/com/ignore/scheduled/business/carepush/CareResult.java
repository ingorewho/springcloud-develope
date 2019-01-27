package com.ignore.scheduled.business.carepush;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: ignore1992
 * @Description: 封装结果
 * @Date: 2019/1/27
 */
@Data
@ToString
public class CareResult {
    /**类型**/
    private String careType;
    /***提示信息*/
    private String option;
}
