package com.wkt.boost.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkt.boost.service.api.SyncService;
import com.wkt.boost.util.ExceptionUtil;

@RestController
@RequestMapping("/api/sync")
public class SyncRestController {

	@Autowired
	private SyncService syncService;
	
	@GetMapping("")
	public String getUserData() {
		RestResult result = RestResult.negativeInstance();
		String res = null;
		try {
			String data = syncService.getUserData(1, new Date());
			//System.out.println(data);
			result.setData(data);
			result.setSuccess(true);
			res = data;
		} catch (Exception e) {
			e.printStackTrace();
			result.setStackTrace(ExceptionUtil.toString(e));
		}
		
		return res;
	}
	
}
