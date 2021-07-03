package service;

import client.RestAssuredClient;
import io.restassured.response.ValidatableResponse;
import model.Booking;

import java.util.HashMap;
import java.util.Map;

public class RestfulBookerService extends RestAssuredClient {

    public RestfulBookerService(String baseUrl){
        super(baseUrl);
    }

    public ValidatableResponse ping() {
        return get("/ping");
    }

    public ValidatableResponse auth(String username , String password){
        HashMap<String , String> payload = new HashMap<String , String >();
        payload.put("username" , username);
        payload.put("password" , password) ;
        return post("/auth" , payload);
    }

    public ValidatableResponse getBookingIds(){
        return get("/booking");
    }

    public ValidatableResponse getBookingById(String id){
        return get("/booking/".concat(id));
    }

    public ValidatableResponse getBookingByParam(String paramName , String value){
        return getWithParam("/booking" , paramName , value);
    }

    public ValidatableResponse createNewBooking(Booking booking){
        Map<String , Object> jsonBody = new HashMap<String , Object>();
        jsonBody.put("firstname" , booking.getFirstname());
        jsonBody.put("lastname" , booking.getLastname());
        jsonBody.put("totalprice" , booking.getTotalPrice());
        jsonBody.put("depositpaid" , booking.getDepositPaid());
        Map<String , String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin" , booking.getCheckInDate());
        bookingDatesMap.put("checkout" , booking.getCheckOutDate());
        jsonBody.put("bookingdates" , bookingDatesMap);
        jsonBody.put("additionalneeds" , booking.getAdditionalNeeds());
        return post("/booking" , jsonBody);
    }

    public ValidatableResponse deleteBookingById(int bookingId , String tokenCode){
        return delete("/booking/".concat(String.valueOf(bookingId)) , tokenCode);

    }


}
