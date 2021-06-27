import org.junit.jupiter.api.BeforeAll;
import service.RestfulBookerService;
import service.ServiceConstants;

public class BaseTest {

    static String ENV = System.getProperty("ENV");
    static RestfulBookerService restfulBookerService ;

    @BeforeAll
    public static void setUp(){
        String URL = null;
        if (ENV.equals("PROD")){
            URL = ServiceConstants.PROD_URL;
        }else if (ENV.equals("DEV")){
            URL = ServiceConstants.DEV_URL;
        }
        restfulBookerService = new RestfulBookerService(URL);
    }

}
