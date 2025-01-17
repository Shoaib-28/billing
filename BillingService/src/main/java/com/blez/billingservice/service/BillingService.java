package com.blez.billingservice.service;

import com.blez.billingservice.model.PublishBillModel;
import com.blez.billingservice.model.TripBillModel;
import com.blez.billingservice.utils.ResultState;

public interface BillingService {

    public ResultState<TripBillModel> getBillingTrip(String startDestination, String endDestination, int distanceBetween, int numberOfPassenger, int kmPrice, String name);

    public ResultState<PublishBillModel> getBillingPublish(String startDestination, String endDestination, int distanceBetween, int numberOfPassenger, int kmPrice, String carModel, String carNumber, String name);
}
