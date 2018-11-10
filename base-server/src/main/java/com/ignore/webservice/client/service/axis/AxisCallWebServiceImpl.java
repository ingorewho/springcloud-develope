package com.ignore.webservice.client.service.axis;

import com.ignore.webservice.client.service.AbstractCallWebService;
import com.ignore.webservice.dto.request.AxisReqDTO;
import com.ignore.webservice.dto.request.BaseReqDTO;
import com.ignore.webservice.dto.response.AxisRepsDTO;
import com.ignore.webservice.dto.response.BaseResponseDTO;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.constants.Style;
import org.apache.axis.message.SOAPBodyElement;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import javax.xml.namespace.QName;
import java.net.URL;

/**
 * @Author: renzhiqiang-lhq
 * @Description: 通过axis方式调用webservice接口
 * @Date: Created In 14:13 2018/10/10
 */
@org.springframework.stereotype.Service
public class AxisCallWebServiceImpl extends AbstractCallWebService {
    private Logger logger = LogManager.getLogger();

    @Override
    public BaseResponseDTO doCall(BaseReqDTO reqDTO) {
        try{
            AxisReqDTO axisReqDTO = (AxisReqDTO)reqDTO;
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(new URL(axisReqDTO.getUrl()));
            call.setSOAPActionURI("");
            call.setPortName(new QName(axisReqDTO.getNameSpace(), axisReqDTO.getPortName()));
            call.setPortTypeName(new QName(axisReqDTO.getNameSpace(), axisReqDTO.getPortTypeName()));
            call.setProperty(Call.OPERATION_STYLE_PROPERTY, Style.DOCUMENT.getName());
            call.setOperation(axisReqDTO.getOperationName());
            call.addHeader(new SOAPHeaderElement(axisReqDTO.getHeader()));

            Object result = call.invoke(new Object[]{new SOAPBodyElement(axisReqDTO.getBody())});
            return transferResponse(result);
        }catch (Exception e){
            logger.error("通过axis方式调用webservice接口异常", e);
        }
        return null;
    }

    @Override
    protected BaseResponseDTO transferResponse(Object result) {
        try{
            String respsBody = result.toString();
            Document bodyDoc = DocumentHelper.parseText(respsBody.substring(1, respsBody.length()-1));
            AxisRepsDTO repsDTO = new AxisRepsDTO();
            repsDTO.setResult(bodyDoc);
            return repsDTO;
        }catch (Exception e){
            logger.error("axis请求结果解析异常", e);
        }
        return null;
    }


}
