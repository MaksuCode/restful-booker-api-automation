package service;

import client.RestAssuredClient;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;

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

    public ValidatableResponse createNewBooking(String firstname , String lastname){
        HashMap<String , String> payload = new HashMap<String , String >();
        payload.put("firstname" , firstname);
        payload.put("lastname" , lastname);
        return post("/booking" , payload);
    }


}
