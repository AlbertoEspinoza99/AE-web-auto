package rimac.test.stepsdefinition.rodolfo;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import rimac.test.task.preEmisionWorksite.DatosGeneralesTask;
import rimac.test.task.preEmisionWorksite.DatosSolicitudTask;
import rimac.test.task.preEmisionWorksite.ProductoTask;
import rimac.test.task.preEmisionWorksite.TitularTask;

import static rimac.test.stepsdefinition.hooks.Hooks.actor;

public class PreEmisionWORKSITE {


   @And("^rellenamos la seccion datos generales canal (.*),vendedor (.*)$")
   public void DatosGenerales(String canal,String vendedor){

      actor.attemptsTo(
              DatosGeneralesTask.DG(canal,vendedor)
      );

   }

   @And("^rellenamos la seccion datos de solicitud (.*),nroSolicitud (.*),nroLote (.*),nroRegistro (.*),RazonSocial (.*),Dependencia (.*),MesDeproducción (.*)$")
   public void rellenamosLaSeccionDatos(String solicitud,String nroSolicitud,String nroLote,String nroRegistro,String RazonSocial,String Dependencias,String MesDeproducción) {

      actor.attemptsTo(
              DatosSolicitudTask.Dsoli(solicitud,nroSolicitud,nroLote,nroRegistro,RazonSocial,Dependencias,MesDeproducción)
      );
   }

   @And("^rellenamos la seccion titular dni (.*),codEmpleado (.*)$")
   public void rellenamosLaSeccionTitular(String dni,String codEmpleado) {

      actor.attemptsTo(
              TitularTask.Titular(dni,codEmpleado)
      );
   }


   @And("^rellenamos la seccion Selecproducto (.*),plan (.*),tipoPlan (.*),Fraccionamiento (.*)$")
   public void rellenamosLaSeccionSelecproducto(String Selecproducto,String plan,String tipoPlan,String Fraccionamiento) {
            actor.attemptsTo(
                    ProductoTask.producto(Selecproducto,plan,tipoPlan,Fraccionamiento)
            );
   }


   @And("^rellenamos la seccion asegurados Nrodni (.*)$")
   public void rellenamosLaSeccionAsegurado(String Nrodni) {

   }

   @Then("^se mostrará el mensaje La solicitud xx se encuentra Pre-Emitida la solicitud de póliza de Worksite quedará como Pre-emitida$")
   public void seMostraráElMensajeLaSolicitud() throws Throwable {

      throw new PendingException();
   }
}
