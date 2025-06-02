package rimac.test.interaction;

import java.util.Random;

public class NombreyNumeroAleatorio {


  public static String aleatorio(){

      String abedecario="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      StringBuilder resultado=new StringBuilder();
      Random ramdom=new Random();

      for (int i=0;i<3;i++){
          resultado.append(abedecario.charAt(ramdom.nextInt(abedecario.length())));
      }

      for (int i=0;i<3;i++){
          resultado.append(ramdom.nextInt(99));
      }

      return resultado.toString();

  }







}
