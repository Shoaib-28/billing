package com.blez.billingservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TripBillModel {
    String name;
    String fare;
    String totalCharges;
    String numberOfPassengers;
    String startDestination;
    String endDestination;




}
