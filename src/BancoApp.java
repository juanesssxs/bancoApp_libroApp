class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class MontoNegativoException extends Exception {
    public MontoNegativoException(String mensaje) {
        super(mensaje);
    }
}

class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + monto);
        }
        saldo -= monto;
    }

    public void depositar(double monto) throws MontoNegativoException {
        if (monto < 0) {
            throw new MontoNegativoException("El monto a depositar no puede ser negativo.");
        }
        saldo += monto;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class BancoApp {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(500);

        try {
            cuenta.retirar(600);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        try {
            cuenta.depositar(-200);
        } catch (MontoNegativoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo actual: " + cuenta.getSaldo());
    }
}
