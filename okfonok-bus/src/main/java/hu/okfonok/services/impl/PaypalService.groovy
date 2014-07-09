package hu.okfonok.services.impl;

import hu.okfonok.services.PaymentService;

import java.io.File;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.paypal.api.payments.Payment;
import com.paypal.core.rest.OAuthTokenCredential

/**
 * https://github.com/paypal/rest-api-sdk-java
 * @author aacs
 *
 */
@Service("paypalService")
class PaypalService implements PaymentService {
	PaypalService() {
		Payment.initConfig(getClass().getResourceAsStream("/sdk_config.properties"))
//		String accessToken = new OAuthTokenCredential("test", "test").getAccessToken()
	}
	
	void asd() {
		
	}
}
