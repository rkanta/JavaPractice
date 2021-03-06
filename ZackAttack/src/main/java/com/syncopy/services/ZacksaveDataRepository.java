package com.syncopy.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ZacksaveDataRepository extends CrudRepository<Zack_Alerts,Integer> {
	
	// List<Zack_Alerts> FindByTicker(String stk_Daycol_Date,String stk_Daycol_Ticker);
	
	//List<Stk_Day> FindAllByDates(String stk_Daycol_Date,String stk_Daycol_Ticker,String stk_Day_Minute);

}
