
import java.math.BigDecimal;
import java.math.RoundingMode;

public class IMCService {
    public double calcularIMC(Double peso, Double altura) {
        if (peso == null) throw new IllegalArgumentException("peso obrigatório");
        if (altura == null || altura == 0) throw new IllegalArgumentException("altura inválida");
        
        BigDecimal pesoBD = new BigDecimal(peso);
        BigDecimal alturaBD = new BigDecimal(altura);
        
        BigDecimal imc = pesoBD.divide(alturaBD.multiply(alturaBD), 10, RoundingMode.HALF_UP);
        imc = imc.setScale(2, RoundingMode.HALF_UP);
        
        return imc.doubleValue();
    }
}