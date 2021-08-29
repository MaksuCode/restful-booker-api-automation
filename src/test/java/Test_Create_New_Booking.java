import io.restassured.response.Response;
import model.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test_Create_New_Booking extends BaseTest{

    Booking booking = new Booking();

    @ParameterizedTest
    @MethodSource("provideBookingInfo")
    public void createNewBooking_happy_path(String firstname , String lastname , int totalPrice , Boolean depositPaid , String checkinDate , String checkoutDate , String additionalNeeds){
        booking.setFirstname(firstname);
        booking.setLastname(lastname);
        booking.setTotalPrice(totalPrice);
        booking.setDepositPaid(depositPaid);
        booking.setCheckInDate(checkinDate);
        booking.setCheckOutDate(checkoutDate);
        booking.setAdditionalNeeds(additionalNeeds);

        Response response = restfulBookerService.createNewBooking(booking);

        assertEquals(response.getStatusCode() , 200);
        assertEquals(firstname , response.jsonPath( ).getString("booking.firstname"));
        assertEquals(lastname , response.jsonPath( ).getString("booking.lastname"));

        booking.setBookingId(Integer.parseInt(response.jsonPath().getString("bookingid")));
    }

    private static Stream<Arguments> provideBookingInfo(){
        return Stream.of(
                Arguments.of("İpek" , "Aksu" , 223 , true , "2018-01-01" , "2019-01-01" , "Dinner" ),
                Arguments.of("Musti" , "Aksu" , 123 , false , "2018-01-01" , "2019-01-01" , "Breakfast")
        );
    }

    @AfterEach
    public void delete_booking(){
        restfulBookerService.deleteBookingById(booking.getBookingId() , tokenCode);
    }
}
