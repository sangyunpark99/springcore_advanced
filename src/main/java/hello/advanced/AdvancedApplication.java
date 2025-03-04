package hello.advanced;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class, AppV2Config.class}) // AppV1Config.class를 스프링 빈으로 등록
@SpringBootApplication // @ComponentScan의 기능과 같다. , 컴포넌트 스캔을 시작할 위치를 지정한다.
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

}
