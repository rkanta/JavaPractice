package com.syncopy.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Stk_Day database table.
 * 
 */
@Entity
@Table(name="Zack_Alerts")
public class Zack_Alerts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idZack_Alerts;

	private String author;

	private String ticker;

	private String description;

	private LocalDateTime time;

	public Zack_Alerts() {
	}

	public int getIdZack_Alerts() {
		return idZack_Alerts;
	}

	public void setIdZack_Alerts(int idZack_Alerts) {
		this.idZack_Alerts = idZack_Alerts;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime localDateTime) {
		time = localDateTime;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}