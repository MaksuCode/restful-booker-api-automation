package service;

import client.RestAssuredClient;
import io.restassured.response.ValidatableResponse;

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

    public ValidatableResponse createNewBooking(String firstname , String lastname , int totalPrice , Boolean depositPaid , String checkinDate , String checkoutDate , String additionalNeeds){
        Map<String , Object> jsonBody = new HashMap<String , Object>();
        jsonBody.put("firstname" , firstname);
        jsonBody.put("lastname" , lastname);
        jsonBody.put("totalprice" , totalPrice);
        jsonBody.put("depositpaid" , depositPaid);
        Map<String , String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin" , checkinDate);
        bookingDatesMap.put("checkout" , checkoutDate);
        jsonBody.put("bookingdates" , bookingDatesMap);
        jsonBody.put("additionalneeds" , additionalNeeds);
        return post("/booking" , jsonBody);
    }


}
