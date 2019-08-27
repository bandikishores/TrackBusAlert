package com.bandi.trackbusalert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.bandi.trackbusalert.data.BingDistanceMatrixResponse;
import com.bandi.trackbusalert.data.BusTrackResponse;
import com.bandi.trackbusalert.data.Result;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.TimerTrigger;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Function {

	@FunctionName("busTrackAlert")
	public void busTrackAlert(@TimerTrigger(name = "busTrackAlert", schedule = "0 */5 * * * *") String timerInfo,
			ExecutionContext context) throws Exception {

		try {
			String bingAPIKey = System.getenv("MapsKey"); // Kish - TODO : Read this value
			if (timerInfo == null && context == null) {
				bingAPIKey = new String(Files.readAllBytes(Paths.get("C:\\Users\\kibandi\\Desktop\\MapsKey.txt")));
			}

			OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

			Retrofit busTrackRetro = new Retrofit.Builder().baseUrl("http://reports.yourbus.in/")
					.addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();
			BusTrackService busService = busTrackRetro.create(BusTrackService.class);
			Call<BusTrackResponse> call = busService.getLocation("AP27UB1642", "VKVR", "AP27UB1642");

			String busLocation = "";
			Response<BusTrackResponse> responseBus = call.execute();
			BusTrackResponse location = responseBus.body();
			busLocation = location.getData().getLt() + "," + location.getData().getLg();

			Retrofit bingMapsRetro = new Retrofit.Builder().baseUrl("https://dev.virtualearth.net/")
					.addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();

			BingMapsService service = bingMapsRetro.create(BingMapsService.class);
			Call<BingDistanceMatrixResponse> callSync = service.getDistanceMatrix(busLocation, "12.9846522,77.6735034",
					"driving", bingAPIKey);

			Response<BingDistanceMatrixResponse> response = callSync.execute();
			BingDistanceMatrixResponse distanceMatrix = response.body();
			List<Result> results = distanceMatrix.getResourceSets().get(0).getResources().get(0).getResults();
			if (results != null && results.size() > 0) {
				Double travelDistance = results.get(0).getTravelDistance();
				if (travelDistance < 50) {
					System.out.println("ONLY " + travelDistance + " KMS!!!");
					TwilioCall.MakeCall(timerInfo, context);
				} else {
					System.out.println("There is still time " + travelDistance + " KMS ");
				}
			}

			// timeInfo is a JSON string, you can deserialize it to an object using your
			// favorite JSON library
			if (context != null)
				context.getLogger().info("Timer is triggered: " + timerInfo);
		} catch (Exception ex) {
			if (context != null)
				context.getLogger().throwing(this.getClass().toString(), "keepAlive", ex);
			throw ex;
		}
	}
}