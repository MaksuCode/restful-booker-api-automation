import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test_GetBookingIds extends BaseTest{


    @Test
    void getBookingIds_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingIds();
        response.assertThat().statusCode(200);
        assertTrue(response.extract().jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void getBooking_with_firstName_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("firstname" , "Eric");
        response.assertThat().statusCode(200);
        assertTrue(response.extract().jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void getBookingIds_with_lastname_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("lastname" , "Brown");
        response.assertThat().statusCode(200);
        assertTrue(response.extract().jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void getBookingIds_with_check_in_date_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("checkin" , "2021-01-01");
        response.assertThat().statusCode(200);
        assertTrue(response.extract().jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void getBookingIds_with_check_out_date_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("checkout" , "2021-01-01");
        response.assertThat().statusCode(200);
        assertTrue(response.extract().jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void  getBookingIds_with_incorrect_id(){
        ValidatableResponse response = restfulBookerService.getBookingById("98723");
        response.assertThat().statusCode(404);
        assertEquals("Not Found" , response.extract().body().asString());
    }




}
