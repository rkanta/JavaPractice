package com.syncopy.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.syncopy.client.ApiRestClient;
import com.syncopy.client.config.AppProperties;
import com.syncopy.models.IexResponse;
import com.syncopy.models.Message;
import com.syncopy.models.PerfMessage;
import com.syncopy.models.Zack;
import com.syncopy.models.ZackAttackResponse;
import com.syncopy.models.ZackData;
import com.syncopy.models.ZackMsg;
import com.syncopy.models.ZackPerformanceResponse;
import com.vdurmont.emoji.EmojiParser;

@Service
public class ZackService {

	@Autowired
	AppProperties Aprop;

	@Autowired
	ApiRestClient apiRestClient;

	@Autowired
	private ZackDataRepository zackDataRepository;

	public ZackAttackResponse attackZack(Zack zack, String symbol) {
		ZackAttackResponse zackResponse = new ZackAttackResponse();

		if (zack.getInvoke() == true) {

			// ResponseEntity<ZackMsg[]> zackMsg =
			// apiRestClient.callService(Aprop.getBaseUrl()+Aprop.getStockUri(), "GET", "");

			// System.out.println(zackMsg.toString());

			zackResponse.setAttacked(true);

		} else {
			zackResponse.setAttacked(false);
		}
		return zackResponse;

	}

	public void updateZackData(ZackData zackData) {
		List<Message> zData = zackData.getMessages();
		for (Message s : zData) {

			Zack_Alerts zAlerts = new Zack_Alerts();

			zAlerts.setAuthor(s.getAuthor());
			// System.out.println("Author " + s.getAuthor());
			String result = EmojiParser.removeAllEmojis(s.getDescription());
			zAlerts.setDescription(result);
			System.out.println("Description " + result);
			String tempTicker = s.getTicker();
			if (tempTicker.contains(",")) {
				tempTicker = tempTicker.substring(tempTicker.indexOf("$"), tempTicker.indexOf(","));
				System.out.println("Ticker if it contains $ " + s.getTicker());
			} else {
				String regEx = "[A-Z]{2,4}";// "\\[A-Z]{4}/g"
				Pattern pattern = Pattern.compile(regEx);
				Matcher matcher = pattern.matcher(result);

				if (matcher.find()) {
					System.out.println("match found in " + result);

					tempTicker = "$" + matcher.group(0) + ",";
					System.out.println("Ticker if it DOESNt contains " + tempTicker);

				}
			}

			zAlerts.setTicker(tempTicker);
			// System.out.println("before tikcer " + s.getTicker());
			// System.out.println("After tikcer " + tempTicker);
			String resDate = "";
			if (s.getTime().contains(".")) {
				resDate = s.getTime().substring(0, s.getTime().indexOf("."));

			} else {
				resDate = s.getTime().substring(0, s.getTime().indexOf("+"));
			}
			// System.out.println("Date " + resDate);
			zAlerts.setTime(FormatStringToDate(resDate));

			zackDataRepository.save(zAlerts);

		}

	}

	public LocalDateTime FormatStringToDate(String sDate1) {

		// DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(sDate1);
		System.out.println(dateTime);
		return dateTime;
	}

	public PerfMessage CalculatePriceAndDuration(String ticker, int tickerCounter, String pricerange,
			String tickerrange) {
		PerfMessage zpm = new PerfMessage();

		// retrieving performance for only single tickers alerted for that day
		// modify below logic if ticker range is null then provide performance for all
		// tickers for the price range period.
		List<Timestamp> tickerFirstalertedDatetime = zackDataRepository.findfirstAlertedDate(ticker);
		LocalDateTime firstAlertedDateTime = null;
		/*
		 * if((tickerrange.toUpperCase().equals("ALL".toString()))) { //if ticker range
		 * is all then price range should be equal to present date - first ticker
		 * alerted date //and firstalerted time becomes present date - price range value
		 * Timestamp presentDate = new Timestamp(System.currentTimeMillis()); Calendar
		 * gc = Calendar.getInstance(); gc.setTime(presentDate); int duration = 0;
		 * if(pricerange.contains("m")) { duration =
		 * Integer.parseInt(pricerange.substring(0, pricerange.indexOf("m")));
		 * //tickerrange.subSequence(0, -duration); gc.add(Calendar.MONTH, -duration);
		 * gc.add(Calendar.DAY_OF_MONTH, 1); } if(pricerange.contains("d")) { duration =
		 * Integer.parseInt(pricerange.substring(0, pricerange.indexOf("d")));
		 * gc.add(Calendar.DAY_OF_MONTH, -duration); //gc.add(Calendar.DAY_OF_MONTH, 1);
		 * } if(pricerange.contains("y")) { duration =
		 * Integer.parseInt(pricerange.substring(0, pricerange.indexOf("y")));
		 * gc.add(Calendar.MONTH, -(duration*12)); } Timestamp priceRangeStartDate =new
		 * Timestamp(gc.getTime().getTime());
		 * 
		 * if(tickerFirstalertedDatetime.get(0).toLocalDateTime().toLocalDate().isBefore
		 * (priceRangeStartDate.toLocalDateTime().toLocalDate())) {
		 * System.out.println("ticker alerted before PriceRange : "+priceRangeStartDate)
		 * ; firstAlertedDateTime = priceRangeStartDate.toLocalDateTime(); }else {
		 * System.out.println("ticker alerted within PriceRange : "+priceRangeStartDate)
		 * ; firstAlertedDateTime = tickerFirstalertedDatetime.get(0).toLocalDateTime();
		 * }
		 * 
		 * }else { tickerFirstalertedDatetime =
		 * zackDataRepository.findfirstAlertedDate(ticker); firstAlertedDateTime =
		 * tickerFirstalertedDatetime.get(0).toLocalDateTime(); }
		 * 
		 */
		// System.out.println("Ticker NAME :" + ticker);
		// System.out.println("first alerted Time :"+time);

		// call made to IEX to get stock data response
		// Note that Sandbox Testing has a request limit of 10 requests per second
		// measured in milliseconds.
		ResponseEntity<IexResponse[]> iexRes = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		String tickerFirstAlert = "";
		if (!(tickerrange.toUpperCase().equals("ALL".toString()))) {
			tickerFirstalertedDatetime = zackDataRepository.findfirstAlertedDate(ticker);
			firstAlertedDateTime = tickerFirstalertedDatetime.get(0).toLocalDateTime();

			iexRes = apiRestClient.callService(Aprop.getBaseUrl() + Aprop.getStockUri(), "GET",
					ticker.substring(ticker.lastIndexOf("$") + 1, ticker.lastIndexOf(",")), tickerrange);
			tickerFirstAlert = firstAlertedDateTime.toString();
		} else {

			iexRes = apiRestClient.callService(Aprop.getBaseUrl() + Aprop.getStockUri(), "GET",
					ticker.substring(ticker.lastIndexOf("$") + 1, ticker.lastIndexOf(",")), pricerange);
			if ((iexRes != null) && (iexRes.getStatusCodeValue() == 200)) {
				IexResponse[] iexList = iexRes.getBody();
				if (iexList.length > 1) {

					tickerFirstAlert = iexList[0].getDate();
					String dateStr = tickerFirstAlert + "T00:00:00";
					firstAlertedDateTime = LocalDateTime.parse(dateStr, formatter);
					System.out.println("ticker alerted before PriceRange : " + tickerFirstAlert);
				}
			} else {
				System.out.println("error occured in IEX response furing ticker call : " + ticker);
			}
		}

		Double alertedPrice = 0.00;
		Boolean comparator = false;
		if ((iexRes != null) && (iexRes.getStatusCodeValue() == 200)) {
			IexResponse[] iexList = iexRes.getBody();
			// loop through to get first alerted price by comparing alerted date with date
			// from iex response
			System.out.println("Ticker response received :" + ticker);
			// System.out.println("first alerted Time :" + tickerFirstAlert);
			List<LocalDateTime> dates = new ArrayList<LocalDateTime>();
			if (iexList.length > 1) {
				for (IexResponse iRes : iexList) {
					String iresDateStr = iRes.getDate() + "T00:00:00";
					String latestDateStr = iRes.getDate() + "T00:00:01";
					LocalDateTime iresDatedateTime = LocalDateTime.parse(iresDateStr, formatter);
					LocalDateTime latDatedateTime = LocalDateTime.parse(latestDateStr, formatter);
					dates.add(latDatedateTime);
					// get first alerted price for the ticker

					if (firstAlertedDateTime.toLocalDate().equals(iresDatedateTime.toLocalDate())) {
						alertedPrice = iRes.getHigh();
						System.out.println("first alerted date high price of the day  :" + alertedPrice);
						comparator = true;
					}
				}

				LocalDateTime latestDatedateTime = Collections.max(dates);
				// need to loop through IEX data again to compare all 1yr data with alerted
				// price

				if (comparator) {

					double tempHighPrice = alertedPrice;
					double tempLowPrice = alertedPrice;
					double latestDatePrice = 0;
					long daysBetween = 12345678910L;
					boolean highPriceFound = false;
					for (IexResponse iRes : iexList) {
						String iresDateStr = iRes.getDate() + "T00:00:01";
						LocalDateTime iexresDatedateTime = LocalDateTime.parse(iresDateStr, formatter);

						if (iexresDatedateTime.compareTo(firstAlertedDateTime) > 0) {

							if (iRes.getHigh() > tempHighPrice) {
								highPriceFound = true;
								tempHighPrice = iRes.getHigh();
								Duration duration = Duration.between(firstAlertedDateTime, iexresDatedateTime);
								daysBetween = duration.toDays();

								// System.out.println("temp high price from alert :" + tempHighPrice);
								// System.out.println("temp no of days to get to the high price :" +
								// daysBetween);

							}
							if (iRes.getHigh() < tempLowPrice) {
								tempLowPrice = iRes.getHigh();
								Duration duration = Duration.between(firstAlertedDateTime, iexresDatedateTime);
								daysBetween = duration.toDays();

								// System.out.println("temp high price from alert :" + tempLowPrice);
								// System.out.println("temp no of days to get to the high price :" +
								// daysBetween);
							}

							// iexresDatedateTime.

						}

						// System.out.println("dates comparision results" +
						// iexresDatedateTime.compareTo(latestDatedateTime));
						// System.out.println("latestDatedateTime" + latestDatedateTime);
						// System.out.println("iexresDatedateTime" + iexresDatedateTime);
						if (iexresDatedateTime.compareTo(latestDatedateTime) == 0) {
							latestDatePrice = iRes.getHigh();
							// System.out.println("latestDatePrice" + latestDatePrice);
						}

					}
					if (!highPriceFound) {
						System.out.println(
								"Alert failed as stock never rose from alerted price till date :" + alertedPrice);
						zpm.setAlertDate(tickerFirstAlert);
						zpm.setChangePercentage(String.valueOf(((tempLowPrice - alertedPrice) / alertedPrice) * 100));
						zpm.setTicker(ticker);
						zpm.setDuration((int) daysBetween);
						zpm.setTickerAlertPrice(String.valueOf(alertedPrice));
						zpm.setTickerAllTimeHigh(String.valueOf(tempLowPrice));

					} else {
						zpm.setAlertDate(tickerFirstAlert);
						zpm.setChangePercentage(String.valueOf(((tempHighPrice - alertedPrice) / alertedPrice) * 100));
						zpm.setTicker(ticker);
						zpm.setDuration((int) daysBetween);
						zpm.setTickerAlertPrice(String.valueOf(alertedPrice));
						zpm.setTickerAllTimeHigh(String.valueOf(tempHighPrice));

					}
					zpm.setpresentchangePercentage(
							String.valueOf(((latestDatePrice - alertedPrice) / alertedPrice) * 100));
				}

			}

		} else {
			System.out.println("Ticker response not received :" + ticker);
			zpm = null;
		}

		return zpm;

	}

	public List<PerfMessage> getPerformanceData(String id, String pricerange, String tickerrange) {
		// get ticker list from DB
		List<PerfMessage> perfMessages = new ArrayList<>();
		PerfMessage pmd = new PerfMessage();

		// for getting date ranges of ticker 1m-> present date = end date and start date
		// = present date - 1m or 30 days
		// 5d -> present date = end date and start date = present date - 5 days
		// 2y -> present date = end date and start date = present date - 2 years
		// DB time format is timestamp

		List<String> tickerList = null;
		if (!(tickerrange.toUpperCase().equals("ALL".toString()))) {
			Timestamp endDate = new Timestamp(System.currentTimeMillis());
			Calendar gc = Calendar.getInstance();
			gc.setTime(endDate);
			int duration = 0;
			if (tickerrange.contains("m")) {
				// tempTicker =
				// tempTicker.substring(tempTicker.indexOf("$"),tempTicker.indexOf(","));
				duration = Integer.parseInt(tickerrange.substring(0, tickerrange.indexOf("m")));
				// tickerrange.subSequence(0, -duration);
				gc.add(Calendar.MONTH, -duration);
			}
			if (tickerrange.contains("d")) {
				duration = Integer.parseInt(tickerrange.substring(0, tickerrange.indexOf("d")));
				gc.add(Calendar.HOUR_OF_DAY, -(duration * 24));
			}
			if (tickerrange.contains("y")) {
				duration = Integer.parseInt(tickerrange.substring(0, tickerrange.indexOf("y")));
				gc.add(Calendar.MONTH, -(duration * 12));
			}
			Timestamp startDate = new Timestamp(gc.getTime().getTime());
			tickerList = zackDataRepository.findDistinctTicker(id, startDate, endDate);
		} else {
			tickerList = zackDataRepository.findDistinctTickers(id);
		}

		// for each ticker make a call to IEX to get complete stock data for 1y
		for (String e : tickerList) {
			// System.out.println("Ticker NAME :"+e);
			int count = 0;
			for (int i = 0; i < e.length(); i++) {
				if (e.charAt(i) == ',') {
					count++;
				}

			}
			// once the test is done place CalculatePriceAndDuration here
			// if ((count == 1) && (e.equalsIgnoreCase("$SHRG,"))){

			if (count == 1) {
				// Note that Sandbox Testing has a request limit of 10 requests per second
				// measured in milliseconds.
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pmd = CalculatePriceAndDuration(e, count, pricerange, tickerrange);
				if ((pmd != null) && (pmd.getTicker() != null)) {
					perfMessages.add(pmd);
					// break;
				} else {
					System.out.println("ticker that not generated " + e);
				}
			}

			/*
			 * 
			 * if (e.equalsIgnoreCase("$VNUE,")) {
			 * 
			 * pmd = CalculatePriceAndDuration(e, count,pricerange,tickerrange); String
			 * isempty = pmd.getTicker(); if(isempty != null) { perfMessages.add(pmd);
			 * //break; }
			 * 
			 * break;
			 * 
			 * }
			 * 
			 */

		}

		/*
		 * PerfMessage zpm = new PerfMessage(); zpm.setAlertDate("2021-01-03");
		 * zpm.setChangePercentage("1"); zpm.setTicker("AAPL"); zpm.setDuration(3);
		 * zpm.setTickerAlertPrice("120"); zpm.setTickerAllTimeHigh("180");
		 */
		// ZackPerformanceResponse zpmr = new ZackPerformanceResponse();

		return perfMessages;

	}
}
