package br.fatec;

import java.util.ArrayList;
import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var jogadores = new ArrayList<JogadorMinecraft>();
        var dao = new JogadorMinecraftDAO();
        jogadores = dao.pegar();
        var gerador = new Random();

        while(jogadores.get(0).estaVivo() || jogadores.get(1).estaVivo()){
            var oQueFazer = gerador.nextInt(100);
            var oQueFazer2 = gerador.nextInt(100);
            var dano = gerador.nextInt(4);
            var dano2 = gerador.nextInt(4);
            var ataque = gerador.nextInt(2);
            
            if(jogadores.get(0).estaVivo()){
                if(oQueFazer < jogadores.get(0).getProbMineirar() * 100){
                    jogadores.get(0).minerar();
                }
                else if(oQueFazer < (jogadores.get(0).getProbMineirar() + jogadores.get(0).getProbColetarMadeira()) * 100){
                    jogadores.get(0).coletarMadeira();
                }
                else{
                    jogadores.get(0).construir();
                }
                if (dano == 0) {
                    jogadores.get(0).levarDano();
                }
                System.out.println(jogadores.get(0));
            }
            else{
                System.out.println(jogadores.get(0).getNome() + " esta morto!");
            }

            System.out.printf("\n");
            if(jogadores.get(1).estaVivo()){
                if(oQueFazer2 < jogadores.get(1).getProbMineirar() * 100){
                    jogadores.get(1).minerar();
                }
                else if(oQueFazer2 < (jogadores.get(1).getProbMineirar() + jogadores.get(1).getProbColetarMadeira()) * 100){
                    jogadores.get(1).coletarMadeira();
                }
                else{
                    jogadores.get(1).construir();
                }
                if (dano2 == 0) {
                    jogadores.get(1).levarDano();
                }
                System.out.println(jogadores.get(1));
            }
            else{
                System.out.println(jogadores.get(1).getNome() + " esta morto!");
            }
            System.out.printf("\n");
            
            if(jogadores.get(0).estaVivo() && jogadores.get(1).estaVivo()){
                if(ataque == 0){
                    System.out.println(jogadores.get(0).getNome() + " atacou o " + jogadores.get(1).getNome());
                    jogadores.get(1).levarDano();
                    System.out.println();
                }
                else{
                    System.out.println(jogadores.get(1).getNome() + " atacou o " + jogadores.get(0).getNome());
                    jogadores.get(0).levarDano();
                    System.out.println();
                }

                if(!jogadores.get(0).estaVivo()){
                    System.out.println("\n" + jogadores.get(1).getNome() + " eh o vencedor!\n");
                    dao.vitoriaDerrota(jogadores.get(0), 0, 1);
                    dao.vitoriaDerrota(jogadores.get(1), 1, 0);
                }
                else if(!jogadores.get(1).estaVivo()){
                    System.out.println("\n" + jogadores.get(0).getNome() + " eh o vencedor!\n");
                    dao.vitoriaDerrota(jogadores.get(1), 0, 1);
                    dao.vitoriaDerrota(jogadores.get(0), 1, 0);
                }
            }
            
            System.out.println("============\n");
            Thread.sleep(5000);
        }
        System.out.println("GAME OVER");
    }
}
