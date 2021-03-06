package com.etrade.exampleapp.oauth;

import java.security.GeneralSecurityException;

import com.etrade.exampleapp.model.OAuth1Parameters;

public interface OAuthSigner {
	//Returns oauth signature method, for exmaple HMAC-SHA1
	String getSignatureMethod();
	
	//compute signature based on given signature method
	String computeSignature(String signatureBaseString,OAuth1Parameters params) throws GeneralSecurityException;
}
