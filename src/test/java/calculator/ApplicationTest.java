package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_커스텀_구분자_혼합_덧셈() {
        assertSimpleTest(() -> {
            run("//;\\n1;5,2:3");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Test
    void 기본_구분자_두자리_덧셈() {
        assertSimpleTest(() -> {
            run("1,10:2");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 커스텀_구분자_두자리_덧셈() {
        assertSimpleTest(() -> {
            run("//;\\n1;15;5");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 기본_커스텀_구분자_혼합_두자리_덧셈() {
        assertSimpleTest(() -> {
            run("//;\\n2:1;18,5");
            assertThat(output()).contains("결과 : 26");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
