package projeto_V3;

public class Mercado {

    private Vendedor[] vendedores;

    private String local;

    private Comprador[] comprs;

    private int totvendas;



    public Mercado(Vendedor[] vendedores, String local, Comprador[] comprs) {
        this.vendedores = vendedores;
        this.local = local;
        this.comprs = comprs;
    }



    public Vendedor[] getVendedores() {
        return vendedores;
    }

    public Comprador[] getComprs() {
        return comprs;
    }


    public void aplicarCadaMercado(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) { // para cada mercado ->
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();
            totvendas = 0;
            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];
                totvendas += vendedor.getVendas();
            }
        }

        System.out.println("\nVendas Totais: R$ " + totvendas);
    }

    public int TotVendasPorMercado(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) {
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();
            totvendas = 0;
            for (int j = 0; j < vendedores.length; j++) {
                Vendedor vendedor = vendedores[j];
                totvendas += vendedor.getVendas();
            }
        }

        return totvendas;
    }

}

