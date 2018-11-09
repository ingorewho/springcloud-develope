package com.server.controller;

import com.server.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: renzhiqiang-lhq
 * @Description:
 * @Date: Created In 16:43 2018/9/3
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/producer")
public class ProduceController
{
	@Autowired
	private ProduceService produceService;

	@GetMapping(value = "/service")
	public String service()
	{
		return produceService.service();
	}
}
