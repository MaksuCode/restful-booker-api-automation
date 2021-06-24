package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import logger.CurLogger;

import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class RestAssuredClient implements CurLogger {

    protected String baseUrl ;

    public RestAssuredClient(String baseUrl){
        this.baseUrl = baseUrl ;
    }

    public ValidatableResponse get(String path){
        return
        given()
                .config(config)
                .baseUri(this.baseUrl)
                .contentType(ContentType.JSON)
        .when()
                .get(path)
        .then()
                .log()
                .body();
    }

    public ValidatableResponse post(String path , HashMap object){
        return
        given()
                .config(config)
                .contentType(ContentType.JSON)
                .body(object)
        .when()
                .post(baseUrl.concat(path))
        .then()
                .log()
                .body();
    }

    public ValidatableResponse getWithParam(String path , String paramName , String value){
        return
        given()
                .config(config)
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
        .when()
                .param(paramName , value)
                .get(path)
        .then()
                .log()
                .body();
    }

    public Response put(){
        return null ;
    }

    public Response delete(){
        return null ;
    }


}
