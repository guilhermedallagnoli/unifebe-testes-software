import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestIMC {
    public static void main(String[] args) {
        Double peso = 40.0;
        Double altura = 1.60;
        
        BigDecimal bdPeso = new BigDecimal(peso);
        BigDecimal bdAltura = new BigDecimal(altura);
        BigDecimal imc = bdPeso.divide(bdAltura.multiply(bdAltura), 2, RoundingMode.HALF_UP);
        
        System.out.println("BigDecimal result: " + imc.doubleValue());
        System.out.println("BigDecimal toString: " + imc.toString());
        
        // Tentando com string
        BigDecimal bdPeso2 = new BigDecimal("40.0");
        BigDecimal bdAltura2 = new BigDecimal("1.60");
        BigDecimal imc2 = bdPeso2.divide(bdAltura2.multiply(bdAltura2), 2, RoundingMode.HALF_UP);
        System.out.println("String BigDecimal result: " + imc2.doubleValue());
        System.out.println("String BigDecimal toString: " + imc2.toString());
    }
}
