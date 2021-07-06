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
        ValidatableResponse response = restfulBookerService.createNewBooking(booking);
        String bookingId = response.extract().jsonPath().getString("bookingid");
        booking.setBookingId(Integer.parseInt(bookingId));
    }

    @Test
    void getBookingIds_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingIds();
        response.assertThat().statusCode(200);
        assertTrue(response.extract().jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void getBooking_with_firstName_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("firstname" , booking.getFirstname());
        response.assertThat().statusCode(200);
        assertEquals(String.valueOf(booking.getBookingId()) , response.extract().jsonPath().getList("bookingid").get(0).toString());
    }

    @Test
    void getBookingIds_with_lastname_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("lastname" , booking.getLastname());
        response.assertThat().statusCode(200);
        assertEquals(String.valueOf(booking.getBookingId()) , response.extract().jsonPath().getList("bookingid").get(0).toString());
    }

    @Test
    void getBookingIds_with_check_in_date_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("checkin" , booking.getCheckInDate());
        response.assertThat().statusCode(200);
        assertTrue(response.extract().jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void getBookingIds_with_check_out_date_happy_path(){
        ValidatableResponse response = restfulBookerService.getBookingByParam("checkout" , booking.getCheckOutDate());
        response.assertThat().statusCode(200);
        assertTrue(response.extract().jsonPath().getString("bookingid").length() > 0);
    }

    @Test
    void  getBookingIds_with_incorrect_id(){
        ValidatableResponse response = restfulBookerService.getBookingById("98723");
        response.assertThat().statusCode(404);
        assertEquals("Not Found" , response.extract().body().asString());
    }

    @AfterAll
    void delete_booking(){
        restfulBookerService.deleteBookingById(booking.getBookingId() , tokenCode);
    }




}
