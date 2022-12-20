package projeto_V3;

import java.util.Random;

public class Main {

    private static final String[] nomesVendedores = new String[] {
            "Caio", "Marina", "Lucas", "Rafael", "Bernado", "Ezio", "Jociele", "Ariane", "Antonia", "Vinicius"
    };

    private static final String[] sobrenomes = new String[] {
            "Matias", "Fernandes", "Maia", "Rocha", "Gaspar",
            "Leão", "Alves", "Fagundes", "Sineza", "Bertoldi"
    };

    private static final String[] nomesCompradores = new String [] {
            "Vinicius", "Jociele", "Breno", "Vitor", "Alesandro",
            "Cicero", "Debora", "Eduardo", "Ezio", "Grabriel",
            "Vitor", "Wallys"
    };

    private static final Random random = new Random();

    private static int sequencial = 0;


    public static void main(String[] args) {

        Vendedor[] vendedoresFlores = criarVendedores();
        Vendedor[] vendedoresEletronicos = criarVendedores();
        Vendedor[] vendedoresAlimentos = criarVendedores();
        Vendedor[] vendedoresTotais = criarVendedores();

        Comprador[] compradoresFlores = criarCompradores();
        Comprador[] compradoresEletronicos = criarCompradores();
        Comprador[] compradoresAlimentos = criarCompradores();
        Comprador[] compradoresTotais = criarCompradores();

        Mercado mercadoFlores = new Mercado(vendedoresFlores, "Mercado de floes em Holambra", compradoresFlores);
        Mercado mercadoEletronicos = new Mercado(vendedoresEletronicos, "Mercado de Eletrônicos em São Paulo", compradoresEletronicos);
        Mercado mercadoAlimentos = new Mercado(vendedoresAlimentos, "Mercados de Alimentos em Guarulhos", compradoresAlimentos);
        Mercado mercadoTotal = new Mercado(vendedoresTotais, "Todos", compradoresTotais);


        int qtdeVendedores = mercadoFlores.getVendedores().length;
        int indiceComprador = 0;

        for (int i = 0; i < qtdeVendedores; i++) {
            Vendedor vendedor = mercadoFlores.getVendedores()[i];
            indiceComprador = random.nextInt(compradoresFlores.length);
            Comprador comprador = compradoresFlores[indiceComprador];
            comprador.comprar(vendedor);
        }

        int qtdeCompradores = mercadoFlores.getComprs().length;

        for (int i = 0; i < qtdeCompradores; i++) {
            Comprador comp = mercadoFlores.getComprs()[i];
            indiceComprador = random.nextInt(compradoresFlores.length);
            Comprador comprador = compradoresFlores[indiceComprador];
            comprador.comprasRealizadas(comp);
        }


        int qtdeVendedores2 = mercadoEletronicos.getVendedores().length;

        for (int i = 0; i < qtdeVendedores2; i++) {
            Vendedor vendedor = mercadoEletronicos.getVendedores()[i];
            indiceComprador = random.nextInt(compradoresEletronicos.length);
            Comprador comprador = compradoresEletronicos[indiceComprador];
            comprador.comprar(vendedor);
        }

        int qtdeCompradores2 = mercadoEletronicos.getComprs().length;

        for (int i = 0; i < qtdeCompradores2; i++) {
            Comprador comp = mercadoEletronicos.getComprs()[i];
            indiceComprador = random.nextInt(compradoresEletronicos.length);
            Comprador comprador = compradoresEletronicos[indiceComprador];
            comprador.comprasRealizadas(comp);
        }

        int qtdeVendedores3 = mercadoAlimentos.getVendedores().length;

        for (int i = 0; i < qtdeVendedores3; i++) {
            Vendedor vendedor = mercadoAlimentos.getVendedores()[i];
            indiceComprador = random.nextInt(compradoresAlimentos.length);
            Comprador comprador = compradoresAlimentos[indiceComprador];
            comprador.comprar(vendedor);
        }

        int qtdeCompradores3 = mercadoAlimentos.getComprs().length;

        for (int i = 0; i < qtdeCompradores3; i++) {
            Comprador comp = mercadoAlimentos.getComprs()[i];
            indiceComprador = random.nextInt(compradoresAlimentos.length);
            Comprador comprador = compradoresAlimentos[indiceComprador];
            comprador.comprasRealizadas(comp);
        }

        Regulador regulador = new Regulador();
        Regulador_Compras regulador_compras = new Regulador_Compras();


        System.out.println("Sumário do Mercado de Flores");
        System.out.println("Mercado de Flores - Análise dos Vendedores:");
        regulador.aplicarFlores(new Mercado[]{mercadoFlores});
        System.out.println("\nMercado de Flores - Análise dos Compradores: ");
        regulador_compras.aplicarCompras(new Mercado[]{mercadoFlores});
        mercadoTotal.aplicarCadaMercado(new Mercado[]{mercadoFlores});


        System.out.println("");
        System.out.println("Sumário do Mercado de Eletrônicos");
        System.out.println("Mercado de Eletrônicos - Análise dos Vendedores:");
        regulador.aplicarEletronicos(new Mercado[]{mercadoEletronicos});
        System.out.println("\nMercado de Eletrônicos - Análise dos Compradores: ");
        regulador_compras.aplicarCompras(new Mercado[]{mercadoEletronicos});
        mercadoTotal.aplicarCadaMercado(new Mercado[]{mercadoEletronicos});


        System.out.println("");
        System.out.println("Sumário do Mercado de Alimentos");
        System.out.println("Mercado de Alimentos - Análise dos Vendedores:");
        regulador.aplicarAlimentos(new Mercado[]{mercadoAlimentos});
        System.out.println("\nMercado de Alimentos - Análise dos Compradores: ");
        regulador_compras.aplicarCompras(new Mercado[]{mercadoAlimentos});
        mercadoTotal.aplicarCadaMercado(new Mercado[]{mercadoAlimentos});

        regulador_compras.TotalCompras();

        int vendasFlores = mercadoTotal.TotVendasPorMercado(new Mercado[]{mercadoFlores});
        int vendasEletronicos = mercadoTotal.TotVendasPorMercado(new Mercado[]{mercadoEletronicos});
        int vendasAlimentos = mercadoTotal.TotVendasPorMercado(new Mercado[]{mercadoAlimentos});

        maisLucrativo(vendasFlores, vendasEletronicos, vendasAlimentos);

    }


    public static void maisLucrativo(int vendasFlores, int vendasEletronicos, int vendasAlimentos) {
        if (vendasFlores > vendasEletronicos && vendasFlores > vendasAlimentos) {
            System.out.println("\nO mercados de Flores é o mais lucrativo com R$: " + vendasFlores);
        } else if (vendasEletronicos > vendasFlores && vendasEletronicos > vendasAlimentos) {
            System.out.println("\nO mercados de Eletrônicos é o mais lucrativo com R$: " + vendasEletronicos);
        } else if (vendasAlimentos > vendasFlores && vendasAlimentos > vendasEletronicos) {
            System.out.println("\nO mercados de Alimentos é o mais lucrativo com R$: " + vendasAlimentos);
        }
    }

    private static Vendedor[] criarVendedores() {
        Vendedor[] vendedores = new Vendedor[nomesVendedores.length];
        for (int i = 0; i < nomesVendedores.length; i++) {
            int indiceNome = random.nextInt(nomesVendedores.length);
            String nome = nomesVendedores[indiceNome];

            int indiceSobrenome = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[indiceSobrenome] + " " + proximoSequencial();
            vendedores[i] = new Vendedor(nome, sobrenome);
        }
        return vendedores;
    }

    private static Comprador[] criarCompradores() {
        Comprador[] compradores = new Comprador[nomesCompradores.length];
        for (int i = 0; i < nomesCompradores.length; i++) {
            int indiceNome = random.nextInt(nomesCompradores.length);
            String nome = nomesCompradores[indiceNome];

            int indiceSobrenome = random.nextInt(sobrenomes.length);
            String sobrenome = sobrenomes[indiceSobrenome] + " " + proximoSequencial();


            compradores[i] = new Comprador(nome, sobrenome);
        }

        return compradores;
    }

    private static int proximoSequencial() {
        return ++sequencial;
    }
}




