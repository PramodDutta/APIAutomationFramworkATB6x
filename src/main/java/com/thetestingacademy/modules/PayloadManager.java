package com.thetestingacademy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingDates;
import com.thetestingacademy.pojos.BookingResponse;

public class PayloadManager {

    Gson gson;

    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        Faker faker = new Faker();
        booking.setFirstname("Pramod");
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1000));
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();
        String jsonPayload = gson.toJson(booking);
        return jsonPayload;
    }

    public String createInvalidPayloadBookingAsString() {
        return "{}";
    }
    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);
    }

    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingRespons = gson.fromJson(responseString,BookingResponse.class);
        return bookingRespons;
    }

}
