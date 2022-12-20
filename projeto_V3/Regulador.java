package projeto_V3;

public class Regulador {

    public void aplicarFlores(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) { // para cada mercado ->
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();
            for (int j = 0; j < vendedores.length; j++) { // para cada vendedor
                Vendedor vendedor = vendedores[j];
                if (isSuperiorMetaFlores(vendedor)) {
                    this.bonificar(vendedor);
                }
                System.out.println( vendedor.anunciar() );
            }
        }
    }

    public void aplicarEletronicos(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) { // para cada mercado ->
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();
            for (int j = 0; j < vendedores.length; j++) { // para cada vendedor
                Vendedor vendedor = vendedores[j];
                if (isSuperiorMetaEletronicos(vendedor)) {
                    this.bonificar(vendedor);
                }
                System.out.println( vendedor.anunciar() );
            }
        }
    }

    public void aplicarAlimentos(Mercado[] mercados) {
        for (int i = 0; i < mercados.length; i++) { // para cada mercado ->
            Mercado mercado = mercados[i];
            Vendedor[] vendedores = mercado.getVendedores();
            for (int j = 0; j < vendedores.length; j++) { // para cada vendedor
                Vendedor vendedor = vendedores[j];
                if (isSuperiorMetaAlimentos(vendedor)) {
                    this.bonificar(vendedor);
                }
                System.out.println( vendedor.anunciar() );
            }
        }
    }

    private boolean isSuperiorMetaFlores(Vendedor vendedor) {
        return vendedor.getVendas() > 300;
    }

    private boolean isSuperiorMetaEletronicos(Vendedor vendedor) {
        return vendedor.getVendas() > 700;
    }

    private boolean isSuperiorMetaAlimentos(Vendedor vendedor) {
        return vendedor.getVendas() > 500;
    }

    private void bonificar(Vendedor vendedor) {
        double total = vendedor.getVendas();
        double bonificacao = (total * 0.10);
        vendedor.receberBonificacao(bonificacao);
    }

}

