package com.syncopy.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ZackDataRepository extends JpaRepository<Zack_Alerts,Integer> {
	
	 //List<Zack_Alerts> findAlerts(String Ticker);
	
	 List<Zack_Alerts> findByTicker(String Ticker);
	 
	 /*
	 @Query(value = "Select DISTINCT(e.Ticker) from Users.Zack_Alerts e", nativeQuery=true)
	 List<String> findDistinctTickers();
	 */
	 @Query(value = "Select e.Time from Users.Zack_Alerts e where e.Ticker = ?1 ORDER BY e.Time ASC", nativeQuery=true)
	 List<Timestamp> findfirstAlertedDate(String ticker);
	 
	 
	 @Query(value = "Select DISTINCT(e.Ticker) from Users.Zack_Alerts e where e.Author = ?1 ", nativeQuery=true)
	 List<String> findDistinctTickers(String author);
	 
	 @Query(value = "Select DISTINCT(e.Ticker) from Users.Zack_Alerts e where e.Author = ?1 AND e.Time BETWEEN ?2 AND ?3", nativeQuery=true)
	 List<String> findDistinctTicker(String author, Timestamp startDate, Timestamp endDate);
	 
	 @Query(value = "SELECT x.Ticker,x.Time FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY e.Ticker ORDER BY e.Time asc) AS ROWNUM FROM Users.Zack_Alerts e WHERE e.author = ?1 ) x WHERE ROWNUM = 1", nativeQuery=true)
	 List<String> findDistinctTickerAndTime(String author);
	 
	  

}
