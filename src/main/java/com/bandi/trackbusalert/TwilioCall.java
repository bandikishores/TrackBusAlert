package com.bandi.trackbusalert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.microsoft.azure.functions.ExecutionContext;
import com.twilio.sdk.Twilio;
import com.twilio.sdk.resource.api.v2010.account.Call;
import com.twilio.sdk.type.PhoneNumber;

public class TwilioCall {

	public static void MakeCall(String timerInfo, ExecutionContext context) throws IOException, URISyntaxException {
		String ACCOUNT_SID = System.getenv("TwilioAccountSid");
		String AUTH_TOKEN = System.getenv("TwilioAuthToken");

		if (timerInfo == null && context == null) {
			ACCOUNT_SID = new String(
					Files.readAllBytes(Paths.get("C:\\Users\\kibandi\\Desktop\\TwilioAccountSid.txt")));
			AUTH_TOKEN = new String(Files.readAllBytes(Paths.get("C:\\Users\\kibandi\\Desktop\\TwilioAuthToken.txt")));
		}

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		String from = "+12057079423";
		String to = "+917795861068";

		Call call = Call.create(ACCOUNT_SID, new PhoneNumber(to), new PhoneNumber(from),
				new URI("http://demo.twilio.com/docs/voice.xml")).execute();

		System.out.println(call.getSid());
	}
}
