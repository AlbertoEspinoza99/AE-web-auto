package rimac.test.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class InsertBarrera{

   public static String insert(String numero,int numeroFinalCodidoPoliza,int numeroInicialNumeroPoliza){

       return numero.substring(0,numeroFinalCodidoPoliza)+"|"+numero.substring(numeroInicialNumeroPoliza);
   }








}
