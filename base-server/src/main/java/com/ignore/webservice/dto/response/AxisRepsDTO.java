package com.ignore.webservice.dto.response;

import lombok.Data;
import org.dom4j.Document;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:04 2018/10/10
 */
@Data
public class AxisRepsDTO extends BaseResponseDTO {
    private Document result;
}
