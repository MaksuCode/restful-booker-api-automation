import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class Test_Create_New_Booking extends BaseTest{

    @Test
    public void createNewBooking_happy_path(){
        ValidatableResponse response = restfulBookerService
                .createNewBooking("Mustafa" , "Aksu" , 123 , true , "2018-01-01" , "2019-01-01" , "Dinner");
        response.assertThat().statusCode(200);

    }

}
