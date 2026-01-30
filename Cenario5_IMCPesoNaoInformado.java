public class Cenario5_IMCPesoNaoInformado {
    public static void main(String[] args) {
        IMCService service = new IMCService();
        IMCResult result = new IMCResult();

        IMCInput input = new IMCInput();
        input.peso = null; // não informado
        input.altura = 1.70;

        GivenWhenThen<IMCInput, IMCResult> scenario =
            new GivenWhenThen<IMCInput, IMCResult>(input) {
                @Override
                public void Then(Function<IMCInput, IMCResult> then) {
                    IMCResult r = then.apply(this.input);
                    if ("peso obrigatório".equals(r.erro)) {
                        System.out.println("✅ Cenário 5 passou: erro corretamente lançado");
                    } else {
                        System.out.println("❌ Cenário 5 falhou");
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
