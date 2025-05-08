import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var jogador1 = new JogadorMinecraft("Gilsu");
        var gerador = new Random();

        while(true){
            var oQueFazer = 1 + gerador.nextInt(3);

            switch(oQueFazer){
                case 1: jogador1.minerar();
                    break;
                case 2: jogador1.coletarMadeira();
                    break;
                case 3: jogador1.construir();
                    break;
            }
            System.out.println(jogador1);
            System.out.println("\n============\n");
            Thread.sleep(5000);
        }
    }
}
