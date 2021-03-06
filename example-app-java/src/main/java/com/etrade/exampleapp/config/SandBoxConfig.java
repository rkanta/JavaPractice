package com.etrade.exampleapp.config;

import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.etrade.exampleapp.account.AccountListClient;
import com.etrade.exampleapp.account.BalanceClient;
import com.etrade.exampleapp.account.PortfolioClient;
import com.etrade.exampleapp.market.QuotesClient;
import com.etrade.exampleapp.model.OAuth1Parameters;
import com.etrade.exampleapp.oauth.AuthorizationService;
import com.etrade.exampleapp.oauth.GetTokenService;
import com.etrade.exampleapp.oauth.OauthController;
import com.etrade.exampleapp.oauth.TempCredentialService;
import com.etrade.exampleapp.oauth.TokenService;
import com.etrade.exampleapp.order.OrderClient;
import com.etrade.exampleapp.order.OrderPreview;

@Configuration
public class SandBoxConfig extends OOauthConfig {

	@Override
	public Map<String, String> apiProperties() {
		Map<String, String> apiParams = super.apiProperties();
		apiParams.put("API_BASE_URL", sandboxBaseUrl);
		return apiParams;
	}

	@Override
	public Map<String,String> oAuthProperties(){
		Map<String, String> oauthParams = super.oAuthProperties();
		oauthParams.put("CONSUMER_KEY", sandboxConsumerKey);
		oauthParams.put("CONSUMER_SECRET", sandboxSecretKey);
		
		return oauthParams;
	}

	@Override
	public GetTokenService getTokenService() {
		// TODO Auto-generated method stub
		return super.getTokenService();
	}

	@Override
	public AccountListClient accountListClient() {
		// TODO Auto-generated method stub
		return super.accountListClient();
	}

	@Override
	public BalanceClient balanceClient() {
		// TODO Auto-generated method stub
		return super.balanceClient();
	}

	@Override
	public PortfolioClient portfolioClient() {
		// TODO Auto-generated method stub
		return super.portfolioClient();
	}

	@Override
	public QuotesClient quotesClient() {
		// TODO Auto-generated method stub
		return super.quotesClient();
	}

	@Override
	public OrderClient orderClient() {
		// TODO Auto-generated method stub
		return super.orderClient();
	}

	@Override
	public OrderPreview orderPreview() {
		// TODO Auto-generated method stub
		return super.orderPreview();
	}

	@Override
	public OAuth1Parameters oAuth1Parameters() {
		// TODO Auto-generated method stub
		return super.oAuth1Parameters();
	}

	@Override
	public TempCredentialService tempCredentialService() {
		// TODO Auto-generated method stub
		return super.tempCredentialService();
	}

	@Override
	public AuthorizationService authorizationService() {
		// TODO Auto-generated method stub
		return super.authorizationService();
	}

	@Override
	public TokenService tokenService() {
		// TODO Auto-generated method stub
		return super.tokenService();
	}

	@Override
	public OauthController oauthController() {
		// TODO Auto-generated method stub
		return super.oauthController();
	}
	
}
