package com.cmpe277.hackathon.mainactivity.service;

import com.cmpe277.hackathon.mainactivity.dto.MacroAPIResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMacroService {
    @GET("/macroeconomic")
    Call<MacroAPIResponse> getMacroDetails();
}
