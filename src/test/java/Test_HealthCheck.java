import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_HealthCheck extends BaseTest {

    @Test
    @DisplayName("Happy path")
    public void health_check_test(){
        Response response = restfulBookerService.ping();

        assertEquals(response.getStatusCode() , 201);

        assertEquals("Created" , response.asString());
    }


}
