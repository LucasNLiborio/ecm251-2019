package com.company;

public class ConcessionariaTesteDrive {
    public static void main(String[] args) {
        Gerente g1 = new Gerente("Carlos", 6500);
        Vendedor v1 = new Vendedor("Beatriz",1600, g1);
        Gerente g2 = new Gerente("Jéssica",7000);
        Vendedor v2 = new Vendedor("Bruno",1400,g2);

        double totalVendasMes = 10000;

        System.out.println("Vendedor: ");
        System.out.println("Comissão: " + v1.getComissao(totalVendasMes));
        System.out.println("Gerente: ");
        System.out.println("Comissão: " + g1.getComissao(totalVendasMes));

        if(g1.aumentarSalarioBaseVendedor(v1)){
            System.out.println("Pode dar Aumento! ");
            Vendedor vx = new Vendedor(v1.getNome(),3000,g1);
            System.out.println("Salário Antigo: " + v1.getSalarioDoMes(totalVendasMes));
            System.out.println("Salário Velho: " + vx.getSalarioDoMes(totalVendasMes));
        } else {
            System.out.println("Não pode dar aumento! ");
        }
    }
}
