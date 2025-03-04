package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam(name = "itemId") String itemId); // interface에서는 명시하지 않으면 제대로 인식을 잘 하지 못할때가 있다.

    @GetMapping("/v1/no-log")
    String noLog(); // LogTrace 적용 x
}
