package com.ignore.options.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description： 天气温馨提示
 * Author: ignore1992
 * Date: Created in 2019/1/5 19:35
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherOption implements Serializable{
    /**温馨提示.**/
    private String kindlyOption;
}
