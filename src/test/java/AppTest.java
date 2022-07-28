import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void 테스트_assertThat(){
        int rs=10+20;
        Assertions.assertEquals(rs,30);

    }
}
