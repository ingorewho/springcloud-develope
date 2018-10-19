package com.webservice.dto.request;

import lombok.Data;
import org.w3c.dom.Element;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 15:49 2018/10/10
 */
@Data
public class AxisReqDTO extends BaseReqDTO{
    private String url;
    private String nameSpace;
    private String portName;
    private String portTypeName;
    private String operationName;
    private Element header;
    private Element body;
}
