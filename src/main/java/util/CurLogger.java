package util;

import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.config.RestAssuredConfig;

public interface CurLogger {

    Options options = Options.builder()
            .printMultiliner()
            .build();
    RestAssuredConfig config = CurlRestAssuredConfigFactory.createConfig(options);

}
