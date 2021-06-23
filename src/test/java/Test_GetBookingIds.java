import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.* ;

public class Test_GetBookingIds extends BaseTest{

    @Test
    public void getBookingIds_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingIds();
        response.assertThat().statusCode(200);
        assertTrue(response.extract().asPrettyString().length() > 1); // TODO: 24.06.2021 Create a better assertion here.
    }

    @Test
    public void getBooking_with_firstName_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("firstname" , "Eric");
        response.assertThat().statusCode(200);
        assertTrue(response.extract().asPrettyString().length() > 1); // TODO: 24.06.2021 Create a better assertion here.
    }

}
