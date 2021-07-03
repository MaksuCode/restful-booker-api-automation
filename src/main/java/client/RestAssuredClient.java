package client;

import com.github.dzieciou.testing.curl.CurlLoggingRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {

    protected String baseUrl ;
    Options options = Options.builder()
            .printMultiliner()
            .build();
    RestAssuredConfig config = CurlLoggingRestAssuredConfigFactory.createConfig(options);

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

    public ValidatableResponse post(String path , Map object){
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

    public ValidatableResponse put(){
        return null ;
    }

    public ValidatableResponse delete(String path , String tokenCode){
        return
        given()
                .config(config)
                .baseUri(baseUrl)
                .header("Cookie" , "token=".concat(tokenCode))
                .contentType(ContentType.JSON)
        .when()
                .delete(path)
        .then()
                .log()
                .body();
    }


}
