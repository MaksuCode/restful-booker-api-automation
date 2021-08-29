import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.Booking;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test_GetBookingIds extends BaseTest{

    Booking booking = new Booking();

    @BeforeAll
    void create_new_booking_for_test(){
        booking.setFirstname("Sergio");
        booking.setLastname("Perez");
        booking.setTotalPrice(123);
        booking.setDepositPaid(true);
        booking.setCheckInDate("2021-01-01");
        booking.setCheckOutDate("2021-02-01");
        booking.setAdditionalNeeds("lunch");

        Response response = restfulBookerService.createNewBooking(booking);

        booking.setBookingId(Integer.parseInt(response.jsonPath().getString("bookingid")));
    }

    @Test
    void getBookingIds_happy_path(){
        Response response = restfulBookerService.getBookingIds();

        assertEquals(response.getStatusCode() , 200);

        assertTrue(response.jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void getBooking_with_firstName_happy_path(){
        Response response = restfulBookerService.getBookingByParam("firstname" , booking.getFirstname());

        assertEquals(response.getStatusCode() , 200);

        assertEquals(String.valueOf(booking.getBookingId()) , response.jsonPath().getList("bookingid").get(0).toString());
    }

    @Test
    void getBookingIds_with_lastname_happy_path(){
        Response response = restfulBookerService.getBookingByParam("lastname" , booking.getLastname());

        assertEquals(response.getStatusCode() , 200);

        assertEquals(String.valueOf(booking.getBookingId()) , response.jsonPath().getList("bookingid").get(0).toString());
    }

    @Test
    void getBookingIds_with_check_in_date_happy_path(){
        Response response = restfulBookerService.getBookingByParam("checkin" , booking.getCheckInDate());

        assertEquals(response.getStatusCode() , 200);

        assertTrue(response.jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void getBookingIds_with_check_out_date_happy_path(){
        Response response = restfulBookerService.getBookingByParam("checkout" , booking.getCheckOutDate());

        assertEquals(response.getStatusCode() , 200);

        assertTrue(response.jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void  getBookingIds_with_incorrect_id(){
        Response response = restfulBookerService.getBookingById("98723");

        assertEquals(response.getStatusCode() , 404);

        assertEquals("Not Found" , response.body().asString());
    }

    @AfterAll
    void delete_booking(){
        restfulBookerService.deleteBookingById(booking.getBookingId() , tokenCode);
    }




}
