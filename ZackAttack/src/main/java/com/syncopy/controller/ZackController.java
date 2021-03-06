package com.syncopy.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.websocket.PerMessageDeflate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syncopy.models.PerfMessage;
import com.syncopy.models.Zack;
import com.syncopy.models.ZackAttackResponse;
import com.syncopy.models.ZackData;
import com.syncopy.models.ZackPerformanceResponse;
import com.syncopy.services.ZackService;

@RestController
public class ZackController {
	
	@Autowired
	private ZackService zackService;
	
	@RequestMapping(method=RequestMethod.POST,value="/zack/attack")
	public ZackAttackResponse zackRequest(@RequestBody Zack zack) {
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/zack/attackData")
	public void zackData(@RequestBody ZackData zackData) {
		
		zackService.updateZackData(zackData);
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/zack/getperformanceData")
	public ZackPerformanceResponse getZackPerformanceData(String id,String pricerange,String tickerrange) {
		
		ZackPerformanceResponse zpmr = new ZackPerformanceResponse();
		
		List<PerfMessage> perMessages = zackService.getPerformanceData(id,pricerange,tickerrange);
		int count =0;
		double totalpeak = 0;
		double totaltillPresent = 0;
		for(PerfMessage msg : perMessages) {
			totalpeak = totalpeak+Double.valueOf(msg.getChangePercentage());
			totaltillPresent = totaltillPresent+Double.valueOf(msg.getpresentchangePercentage());
			count++;
		}
		zpmr.setTotalResults(count);
		zpmr.setavgpeakreturns(String.valueOf(totalpeak/count));
		zpmr.setavgpresentreturns(String.valueOf(totaltillPresent/count));
		zpmr.setPerfMessages(perMessages);
		return zpmr;
		
	}
	
	

}
