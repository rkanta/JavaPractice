package com.etrade.exampleapp.model;

public class AuthorizedRequestToken {
	private final OAuthToken requestToken;
	
	private final String verifier;
	
	public AuthorizedRequestToken(OAuthToken requestToken, String verifier) {
		this.requestToken = requestToken;
		this.verifier = verifier;
	}

	public OAuthToken getRequestToken() {
		return requestToken;
	}

	public String getVerifier() {
		return verifier;
	}
	
	
}
