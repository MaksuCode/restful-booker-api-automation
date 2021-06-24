import org.junit.jupiter.api.BeforeAll;
import service.RestfulBookerService;

public class BaseTest {

    RestfulBookerService restfulBookerService = new RestfulBookerService();

    @BeforeAll
    public void create_booking_for_test(){
        // TODO: 24.06.2021 Create a couple of bookings to use
    }

}
