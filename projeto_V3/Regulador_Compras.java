package projeto_V3;

public class Regulador_Compras {

    private int totcompras = 0;

    public void aplicarCompras(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Comprador[] compradores = mercado.getComprs();
            for (int j = 0; j < compradores.length; j++) {
                Comprador comprador = compradores[j];
                totcompras += comprador.getCompras();
                System.out.println( comprador.anunciar2() );
            }
        }

    }

    public void TotalCompras() {
        System.out.println("\nTotal de compras dos compradores: R$ " + totcompras);
    }

}

