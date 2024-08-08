package com.blez.billingservice.service;

import com.blez.billingservice.model.PublishBillModel;
import com.blez.billingservice.model.TripBillModel;
import com.blez.billingservice.utils.ResultState;
import org.springframework.stereotype.Service;


@Service
public class BillingServiceImpl implements BillingService {
    @Override
    public ResultState<TripBillModel> getBillingTrip(String startDestination, String endDestination, int distanceBetween, int numberOfPassenger, int kmPrice, String name) {
        try {
            if (startDestination == null || endDestination == null || distanceBetween < 0 || numberOfPassenger < 0 || kmPrice < 0) {
                return new ResultState.Error<>("Provided details are invalid");
            }
            int fare = kmPrice * distanceBetween;

            int totalFare = (fare * 18 / 100) + fare;

            TripBillModel tripBill = new TripBillModel(name, fare + "", totalFare + "", numberOfPassenger + "", startDestination, endDestination);
            return new ResultState.Success<>(tripBill);


        } catch (Exception e) {
            return new ResultState.Error<>("Error in getting billing trip.");
        }
    }

    @Override
    public ResultState<PublishBillModel> getBillingPublish(String startDestination, String endDestination, int distanceBetween, int numberOfPassenger, int kmPrice,String carModel,String carNumber,String name) {
        try {
            if (startDestination == null || endDestination == null || distanceBetween < 0 || numberOfPassenger < 0 || kmPrice < 0 || carModel ==null || carNumber ==null) {
                return new ResultState.Error<>("Provided details are invalid");
            }
            int fare = kmPrice * distanceBetween;

            int totalFare = (fare * 18 / 100) + fare;

            int commission = totalFare - (totalFare * 40/100);

            PublishBillModel publishBillModel = new PublishBillModel(name,fare + "",commission + "",totalFare + "",numberOfPassenger + "",startDestination,endDestination,carModel,carNumber);
            return new ResultState.Success<>(publishBillModel);


        } catch (Exception e) {
            return new ResultState.Error<>("Error in getting billing trip.");
        }
    }
}
