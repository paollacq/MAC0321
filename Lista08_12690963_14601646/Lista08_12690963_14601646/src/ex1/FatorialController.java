package ex1;

public class FatorialController {
    public long calcularFatorial(int numero) throws IllegalArgumentException {
        if (numero < 0) throw new IllegalArgumentException("Número deve ser não-negativo.");
        long fatorial = 1;
        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }
        return fatorial;
    }
}

