package projeto_V3;

import java.util.Random;

public class Comprador {

    private String nome;
    private String sobrenome;

    public int compras;


    public Comprador(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    private static final Random random = new Random();
    public void comprar(Vendedor vendedores) {
        vendedores.vender(random.nextInt(1000));
    }

    public void comprasClientes(int c) {
        this.compras += c;
    }

    public void comprasRealizadas(Comprador compradores) {
        compradores.comprasClientes(random.nextInt(1000));
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }

    public int getCompras() {
        return compras;
    }


    public String anunciar2() {
        return nome + " " + sobrenome + " e comprei R$ " + compras;
    }


}

