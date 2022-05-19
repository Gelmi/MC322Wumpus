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
      Boolean jogoAtivo = true;
      
      if(arquivoMovimentos == null) {
	      Controle controle = new Controle();
	      montador.montarCaverna(cave, caverna, controle);
	      System.out.println("=== Caverna");
	      for (int l = 0; l < caverna.toStringMatrix().length ; l++) {
	         for (int c = 0; c < caverna.toStringMatrix()[l].length; c++)
	            System.out.print(caverna.toStringMatrix()[l][c] + ((c < caverna.toStringMatrix()[l].length-1) ? ", " : ""));
	         System.out.println();
	      }
	      System.out.println("Player: "+controle.getJogador());
	      System.out.println("Score: "+controle.getHeroi().getPontuacao());

	      char status = 'P';
	      while(jogoAtivo) {
	    	  jogoAtivo = controle.pegarComandos();
	          for (int l = 0; l < caverna.toStringMatrix().length ; l++) {
	              for (int c = 0; c < caverna.toStringMatrix()[l].length; c++)
	                 System.out.print(caverna.toStringMatrix()[l][c] + ((c < caverna.toStringMatrix()[l].length-1) ? ", " : ""));
	              System.out.println();
	           }
	          System.out.println("Player: "+controle.getJogador());
	          System.out.println("Score: "+controle.getHeroi().getPontuacao());
	          if(controle.getHeroi().getCausa().equals(new String("Voce ganhou =D !!!"))) {
	        	  status = 'W';
	          } else if (controle.getHeroi().getCausa().equals(new String("Voce perdeu =( ..."))){
	        	  status = 'P';
	          }
	          tk.writeBoard(caverna.toCharMatrix(), controle.getHeroi().getPontuacao(), status);
	      }
	      System.out.println(controle.getHeroi().getCausa());
      } else {
          String movements = tk.retrieveMovements();
    	  Controle controle = new Controle("Automático");
	      montador.montarCaverna(cave, caverna, controle);
	      char status = 'P';
	      for(int i = 0; i < movements.length(); i++) {
	    	  jogoAtivo = controle.pegarComandos(Character.toString(movements.charAt(i)));
	          if(controle.getHeroi().getCausa().equals(new String("Voce ganhou =D !!!"))) {
	        	  status = 'W';
	          } else if (controle.getHeroi().getCausa().equals(new String("Voce perdeu =( ..."))){
	        	  status = 'P';
	          }
	          tk.writeBoard(caverna.toCharMatrix(), controle.getHeroi().getPontuacao(), status);
	      }
      }

      
      /*
      String movements = tk.retrieveMovements();
      System.out.println("=== Movimentos");
      System.out.println(movements);
      */
      
      tk.stop();
   }

}
