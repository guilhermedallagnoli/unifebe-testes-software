
import java.math.BigDecimal;
import java.math.RoundingMode;

public class IMCService {
    public double calcularIMC(Double peso, Double altura) {
        if (peso == null) throw new IllegalArgumentException("peso obrigatório");
        if (altura == null || altura == 0) throw new IllegalArgumentException("altura inválida");
        
        BigDecimal bdPeso = new BigDecimal(peso.toString());
        BigDecimal bdAltura = new BigDecimal(altura.toString());
        BigDecimal imc = bdPeso.divide(bdAltura.multiply(bdAltura), 2, RoundingMode.HALF_UP);
        
        return imc.doubleValue();
    }
}