package pt.c40task.l05wumpus;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      String cave[][] = tk.retrieveCave();
      Caverna caverna = new Caverna();
      Montador montador = new Montador();
      Controle controle = new Controle();
      
      montador.montarCaverna(cave, caverna, controle);
      
      /*System.out.println("=== Comandos");
      for (int l = 0; l < cave.length ; l++) {
          for (int c = 0; c < cave[l].length; c++)
             System.out.print(cave[l][c] + ((c < cave[l].length-1) ? ", " : ""));
          System.out.println();
       }*/
      
      System.out.println("=== Caverna");
      for (int l = 0; l < caverna.toStringMatrix().length ; l++) {
         for (int c = 0; c < caverna.toStringMatrix()[l].length; c++)
            System.out.print(caverna.toStringMatrix()[l][c] + ((c < caverna.toStringMatrix()[l].length-1) ? ", " : ""));
         System.out.println();
      }
      System.out.println("Player: "+controle.getJogador());
      System.out.println("Score: "+controle.getHeroi().getPontuacao());
      
      Boolean jogoAtivo = true;
      while(jogoAtivo) {
    	  jogoAtivo = controle.pegarComandos();
          for (int l = 0; l < caverna.toStringMatrix().length ; l++) {
              for (int c = 0; c < caverna.toStringMatrix()[l].length; c++)
                 System.out.print(caverna.toStringMatrix()[l][c] + ((c < caverna.toStringMatrix()[l].length-1) ? ", " : ""));
              System.out.println();
           }
          System.out.println("Player: "+controle.getJogador());
          System.out.println("Score: "+controle.getHeroi().getPontuacao());
      }
      System.out.println(controle.getHeroi().getCausa());

      
      String movements = tk.retrieveMovements();
      System.out.println("=== Movimentos");
      System.out.println(movements);
      
      System.out.println("=== Caverna Intermediaria");
      char partialCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '-', '-'},
         {'b', '-', '-', '-'},
         {'p', '-', '-', '-'}
      };
      int score = -120;
      char status = 'x'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(partialCave, score, status);

      System.out.println("=== Última Caverna");
      char finalCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '#', 'f'},
         {'b', '-', '-', 'w'},
         {'#', '-', '-', '-'}
      };
      score = -1210;
      status = 'n'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(finalCave, score, status);
      
      tk.stop();
   }

}
