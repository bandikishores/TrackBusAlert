package com.bandi.trackbusalert;

import com.bandi.trackbusalert.data.BingDistanceMatrixResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BingMapsService {

	@GET("/REST/v1/Routes/DistanceMatrix")
	public Call<BingDistanceMatrixResponse> getDistanceMatrix(@Query("origins") String origins,
			@Query("destinations") String destinations, @Query("travelMode") String travelMode,
			@Query("key") String APIKey);

}
