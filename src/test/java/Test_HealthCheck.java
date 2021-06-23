import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.* ;

public class Test_HealthCheck extends BaseTest {

    @Test
    public void health_check_test(){
        ValidatableResponse response = restfulBookerService.ping();
        response.assertThat().statusCode(201);
        assertEquals("Created" , response.extract().asPrettyString());
    }


}
