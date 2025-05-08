import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var jogador1 = new JogadorMinecraft("Gilsu");
        var jogador2 = new JogadorMinecraft("Steve Construtor");
        var gerador = new Random();

        while(jogador1.estaVivo() || jogador2.estaVivo()){
            var oQueFazer = 1 + gerador.nextInt(3);
            var oQueFazer2 = 1 + gerador.nextInt(10);
            var dano = gerador.nextInt(4);
            var dano2 = gerador.nextInt(4);
            var ataque = gerador.nextInt(2);

            if(jogador1.estaVivo()){
                switch(oQueFazer){
                    case 1: jogador1.minerar();
                        break;
                    case 2: jogador1.coletarMadeira();
                        break;
                    case 3: jogador1.construir();
                        break;
                }  
                if (dano == 0) {
                    jogador1.levarDano();
                }
                System.out.println(jogador1);
            }
            else{
                System.out.println(jogador1.getNome() + " esta morto!");
            }
            
            System.out.printf("\n");
            if(jogador1.estaVivo() && jogador2.estaVivo()){
                switch(ataque){
                    case 0: System.out.println(jogador1.getNome() + " atacou o " + jogador2.getNome());
                        jogador2.levarDano();
                        break;
                    case 1: System.out.println(jogador2.getNome() + " atacou o " + jogador1.getNome());
                        jogador1.levarDano();
                        break;
                }
                if(!jogador1.estaVivo()){
                    System.out.println("\n" + jogador2.getNome() + " eh o vencedor!");
                }
                else if(!jogador2.estaVivo()){
                    System.out.println("\n" + jogador1.getNome() + " eh o vencedor!");
                }
            }
            System.out.printf("\n");

            if(jogador2.estaVivo()){
                switch(oQueFazer2){
                    case 1,2,3,4,5,6: jogador2.construir();
                        break;
                    case 7,8,9: jogador2.coletarMadeira();
                        break;
                    case 10: jogador2.minerar();
                }
                if (dano2 == 0) {
                    jogador2.levarDano();
                }
                System.out.println(jogador2);
            }
            else{
                System.out.println(jogador2.getNome() + " esta morto!");
            }
            
            System.out.println("\n============\n");
            Thread.sleep(5000);
        }
        System.out.println("GAME OVER");
    }
}
