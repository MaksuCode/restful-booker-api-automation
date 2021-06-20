import org.junit.jupiter.api.Test;
import service.RestfulBookerService;

public class Test_Get_Bookings {

    RestfulBookerService restfulBookerService = new RestfulBookerService();

    @Test
    public void get_booking_ids(){
        restfulBookerService.getBookingIds()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void get_booking_by_id(){
        restfulBookerService.getBookingById("1")
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void create_new_booking(){
        restfulBookerService.createNewBooking("Mustafa" , "Aksu")
                .assertThat()
                .statusCode(200) ;
    }
}
