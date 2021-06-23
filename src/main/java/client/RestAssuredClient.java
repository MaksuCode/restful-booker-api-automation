package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class RestAssuredClient {

    protected String baseUrl ;

    public RestAssuredClient(String baseUrl){
        this.baseUrl = baseUrl ;
    }

    public ValidatableResponse get(String path){
        return
        given()
                .baseUri(this.baseUrl)
                .contentType(ContentType.JSON)
                .log()
                .all()
        .when()
                .get(path)
        .then()
                .log()
                .all();
    }

    public ValidatableResponse post(String path , HashMap object){
        return
        given()
                .contentType(ContentType.JSON)
                .body(object)
                .log()
                .all()
        .when()
                .post(baseUrl.concat(path))
        .then()
                .log()
                .all();
    }

    public ValidatableResponse getWithParam(String path , String paramName , String value){
        return
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log()
                .all()
        .when()
                .param(paramName , value)
                .get(path)
        .then()
                .log()
                .all();
    }

    public Response put(){
        return null ;
    }

    public Response delete(){
        return null ;
    }


}