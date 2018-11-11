package com.ignore.utils.aop.aspect.log.db;

import com.ignore.dto.common.dblog.DbLogDTO;
import com.ignore.utils.aop.aspect.log.db.async.WriteDbLogServiceAsync;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/11/10 20:30
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Aspect
@ComponentScan
public class DbOutputLogAspectHandler {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private WriteDbLogServiceAsync writeDbLogServiceAsync;

    @AfterReturning(returning = "response", pointcut = "@annotation(com.ignore.utils.aop.aspect.log.DbOutputLog)")
    public void dbLog(JoinPoint point, Object response){
        logger.info("进入!");
        //获取方法实例
        Signature signature = point.getSignature();
        //获取调用方法全名称:包名.类名.方法名
        String caller = signature.toLongString();
        //获取类名
        String className = signature.getDeclaringTypeName();
        //获取方法名
        String methodName = signature.getName();
        //参数
        Object[] args = point.getArgs();
        //返回值:response
        if (true){
            DbLogDTO dbLogDTO = new DbLogDTO();
            dbLogDTO.setArgs(StringUtils.join(args, ","));
            dbLogDTO.setCaller(caller);
            dbLogDTO.setResponse(response != null ? response.toString() : "");
            writeDbLogServiceAsync.writeDbLog(dbLogDTO);
        }
    }
}
