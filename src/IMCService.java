
public class IMCService {
    public double calcularIMC(Double peso, Double altura) {
        if (peso == null) throw new IllegalArgumentException("peso obrigatório");
        if (altura == null || altura == 0) throw new IllegalArgumentException("altura inválida");
        return Math.round((peso / (altura * altura)) * 100.0) / 100.0; // arredonda 2 casas
    }
}