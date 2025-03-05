package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Proxy implements Subject {

    private Subject target; // 진짜 객체
    private String cacheValue; // 캐싱

    public Proxy(Subject subject) {
        this.target = subject;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");

        if(cacheValue == null) {  // 캐싱
            cacheValue = target.operation(); // cacheValue에 값이 없는 경우 실제 객체를 호출
        }

        return cacheValue;
    }
}
