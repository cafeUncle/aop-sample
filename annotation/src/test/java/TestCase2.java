import org.junit.Test;

import java.math.BigDecimal;

public class TestCase2 {

    @Test
    public void bigDecimal(){
        BigDecimal number = BigDecimal.ZERO;
        number = new BigDecimal("6");
        System.out.println(number.intValue());

        BigDecimal number2 = BigDecimal.ZERO;
        System.out.println(number2.intValue());
    }

    @Test
    public void bigDecimal2() {
        BigDecimal number = new BigDecimal(100);
        BigDecimal number2 = new BigDecimal("100");
        BigDecimal number3 = BigDecimal.valueOf(100);
        System.out.println(number.intValue());
        System.out.println(number2.intValue());
        System.out.println(number3.intValue());
    }
}
