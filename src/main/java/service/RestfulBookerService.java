package service;

import client.RestAssuredClient;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;

public class RestfulBookerService extends RestAssuredClient {


    public RestfulBookerService(){
        super("https://restful-booker.herokuapp.com");
    }

    public ValidatableResponse getBookingIds(){
        return get("/booking");
    }

    public ValidatableResponse getBookingById(String id){
        return get("/booking/".concat(id));
    }

    public ValidatableResponse createNewBooking(String firstname , String lastname){
        // TODO: 20.06.2021 FIX request body structure
        HashMap<String , String> payload = new HashMap<String , String >();
        payload.put("firstname" , firstname);
        payload.put("lastname" , lastname);
        return post("/booking" , payload);
    }




}
