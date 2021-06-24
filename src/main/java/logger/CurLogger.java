package logger;

import com.github.dzieciou.testing.curl.CurlLoggingRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.config.RestAssuredConfig;

public interface CurLogger {

    Options options = Options.builder()
            .printMultiliner()
            .build();
    RestAssuredConfig config = CurlLoggingRestAssuredConfigFactory.createConfig();

}
