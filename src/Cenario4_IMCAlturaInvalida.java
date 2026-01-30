import java.util.function.Function;

public class Cenario4_IMCAlturaInvalida {
    public static void main(String[] args) {
        IMCService service = new IMCService();
        IMCResult result = new IMCResult();

        IMCInput input = new IMCInput();
        input.peso = 70.0;
        input.altura = 0.0; // inválido

        GivenWhenThen<IMCInput, IMCResult> scenario =
                new GivenWhenThen<IMCInput, IMCResult>(input) {
                    @Override
                    public void Then(Function<IMCInput, IMCResult> then) {
                        IMCResult r = then.apply(this.input);
                        if ("altura inválida".equals(r.erro)) {
                            System.out.println("Cenário 4: erro corretamente lançado, Resultado "+ input.altura);
                        } else {
                            System.out.println("Cenário 4, Resultado: " + input.altura);
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
