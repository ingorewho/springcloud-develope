package com.ignore.response.outinterface.gaode.weather;

import lombok.Data;

import java.io.Serializable;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2019/1/5 20:01
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Data
public class WeatherResponse implements Serializable{
    private static final long serialVersionUID = 1533667718562499796L;
    private String status;
    private int count;
    private String info;
    private String infocode;
}
