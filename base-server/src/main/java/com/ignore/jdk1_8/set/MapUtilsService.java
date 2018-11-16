package com.jdk1_8.set;

import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:29 2018/8/31
 * @Modified By:
 */
public class MapUtilsService {
    public static void isEmpty() {
        Map<String, String> map = new HashMap<>();
        System.out.println("Map是否为空: " + MapUtils.isEmpty(map));
    }

    public static void isNotEmpty() {
        Map<String, String> map = new HashMap<>();
        System.out.println("Map是否为空: " + MapUtils.isNotEmpty(map));
    }

    public static void main(String[] args) {
        isEmpty();
        isNotEmpty();
    }
}
