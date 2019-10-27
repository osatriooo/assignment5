import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BigDecimal> number = new ArrayList<>();
        BigDecimal tampung = new BigDecimal(0);
        number.add(new BigDecimal(3));
        number.add(new BigDecimal(7));
        number.add(new BigDecimal(6));
        number.add(new BigDecimal(5));
        for (int i = 0; i < number.size() ; i++) {
            tampung = tampung.add(number.get(i));
            System.out.println(tampung);
        }
    }
}
