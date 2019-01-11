package com.ignore.entity.soul;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:47 2019/1/11
 */
@Data
public class PeomEntity implements Serializable{
    private static final long serialVersionUID = 2472208423072494813L;
    /**诗词名称.**/
    private String peomName;
    /**诗词作者.**/
    private String author;
    /**诗词简介.**/
    private String introduction;
    /**完整的诗词句**/
    private String completeContent;
    /**亮点的诗词句集合.**/
    private List<String> markedContent;
}
