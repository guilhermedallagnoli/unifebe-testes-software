import java.util.function.Function;

public class Cenario2_IMCPesoMinimo {
    public static void main(String[] args) {
        IMCService service = new IMCService();
        IMCResult result = new IMCResult();

        IMCInput input = new IMCInput();
        input.peso = 40.0;
        input.altura = 1.60;
        input.resultadoEsperado = 15.63;

        GivenWhenThen<IMCInput, IMCResult> scenario =
                new GivenWhenThen<IMCInput, IMCResult>(input) {
                    @Override
                    public void Then(Function<IMCInput, IMCResult> then) {
                        IMCResult r = then.apply(this.input);
                        if (r.erro != null) {
                            System.out.println("Teste falhou: " + r.erro);
                        } else if (Math.abs(r.imc - input.resultadoEsperado) < 0.01) {
                            System.out.println("Cenário 2 passou");
                        } else {
                            System.out.println("Cenário 2 falhou: esperado " + input.resultadoEsperado + ", obtido " + r.imc);
                        }
                    }
                };

        scenario.Given(in -> {});
        scenario.When(in -> {
            try {
                result.imc = service.calcularIMC(in.peso, in.altura);
            } catch (IllegalArgumentException e) {
                result.erro = e.getMessage();
            }
        });
        scenario.Then(in -> result);
    }
}
