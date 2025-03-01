package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    /**
     * 변하지 않는 부분이 코드의 중복이 발생합니다.
     */
    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("완료 시간 = {}", resultTime);
    }

    /**
     * 변하지 않는 부분이 코드의 중복이 발생합니다.
     */
    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("완료 시간 = {}", resultTime);
    }

    /**
     * 템플릿 메서드 패턴 적용
     * 다형성을 사용해서 변하는 부분과 변하지 않는 부분을 분리합니다.
     * 변하지 않는 부분의 코드의 중복이 일어나지 않습니다.
     * 로직 수정에도 유연합니다. 추상화 되어 있기 때문에, 한곳에서만 로직을 수정하면 됩니다.
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();

    }

    /**
     * 템플릿 메서드 패턴은 매번 SubClassLogic1, SubClassLogic2처럼 Class를 매번 선언해주어야 합니다.
     * 매번 Class를 선언해주지 않기 위해선 익명 내부 클래스를 사용합니다.
     */
    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        log.info("클래스 이름1={}", template1.getClass());
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };

        log.info("클래스 이름2={}", template2.getClass());
        template2.execute();
    }
}
