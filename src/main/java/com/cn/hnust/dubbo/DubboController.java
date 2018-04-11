package com.cn.hnust.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年4月11日 上午10:40:20 类说明
 */
@RestController
public class DubboController {
	@Autowired
	@Qualifier("dubboProviderService")
	private DubboProviderService dubboProviderService;
	
	@Autowired
	@Qualifier("dubboProviderService2")
	private DubboProviderService dubboProviderService2;

	@RequestMapping("/dubbo")
	public void dubbo() {
		String dubbo = dubboProviderService.dubbo();
		System.out.println(dubbo);
		
		String dubbo2 = dubboProviderService2.dubbo();
		System.out.println(dubbo2);
	}
	
	@Autowired
	private GenericService genericService;
	@RequestMapping("/generic")
	public void generic() {
		Object $invoke = genericService.$invoke("all", new String[]{"java.lang.String"}, new String[]{"all","other"});
		System.out.println($invoke);
		Object $invoke1 = genericService.$invoke("other", new String[]{"java.lang.String"}, new String[]{"all","other"});
		System.out.println($invoke1);
	}
	
}
