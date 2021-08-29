import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Auth extends BaseTest{

    @Test
    public void auth_happy_path(){
        Response response = restfulBookerService.auth("admin" , "password123");

        assertEquals(response.getStatusCode() , 200);

        assertEquals(15 , response.jsonPath().getString("token").length());
    }

    @ParameterizedTest
    @MethodSource("provideBadCredentials")
    public void auth_test(String username , String password , String responseMessage){
        Response response = restfulBookerService.auth(username , password);

        assertEquals(response.getStatusCode() , 200);

        assertEquals(response.jsonPath().getString("reason") , responseMessage);
    }

    private static Stream<Arguments> provideBadCredentials(){
        return Stream.of(
                Arguments.of("" , "" , "Bad credentials"),
                Arguments.of("abc" , "" , "Bad credentials"),
                Arguments.of("abc" , "123" ,"Bad credentials"),
                Arguments.of(null , "123" ,"Bad credentials"),
                Arguments.of(null , null ,"Bad credentials"),
                Arguments.of("abc" , null ,"Bad credentials")
        );
    }




}
