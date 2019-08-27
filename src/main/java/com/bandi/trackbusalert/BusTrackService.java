package com.bandi.trackbusalert;

import com.bandi.trackbusalert.data.BusTrackResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusTrackService {

	@GET("/ci/trackApp")
	public Call<BusTrackResponse> getLocation(@Query("v") String origins,
			@Query("o") String destinations, @Query("g") String travelMode);

}
