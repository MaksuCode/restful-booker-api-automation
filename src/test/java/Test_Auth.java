import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.* ;

public class Test_Auth extends BaseTest{

    @Test
    public void auth_happy_path(){
        ValidatableResponse response = restfulBookerService.auth("admin" , "password123");
        response.assertThat().statusCode(200);
        assertEquals(response.extract().path("token").toString().length(), 15);
    }

    @ParameterizedTest
    @MethodSource("provideBadCredentials")
    public void auth_test(String username , String password , String responseMessage){
        ValidatableResponse response = restfulBookerService.auth(username , password);
        response.assertThat().statusCode(200);
        assertEquals(responseMessage , response.extract().path("reason"));
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
