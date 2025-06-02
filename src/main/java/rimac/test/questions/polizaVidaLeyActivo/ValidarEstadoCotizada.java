package rimac.test.questions.polizaVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import rimac.test.models.ConnectionModelDB;
import rimac.test.utils.DbUtils;
import rimac.test.utils.UtilApp;

import java.util.List;
import java.util.Map;

public class ValidarEstadoCotizada implements Question<String> {

    private final String NumeroPoliza;
    DbUtils DbUtils;

    public ValidarEstadoCotizada(String numeroPoliza) {

        NumeroPoliza = numeroPoliza;
    }

    @Override
    public String answeredBy(Actor actor) {

        DbUtils =new DbUtils(ConnectionModelDB.getConfigOracleAEOmpremice());
        String stspoliza = "";

        List<Map<String,Object>> registro=DbUtils.selectConParametros(UtilApp.getJsonValue("src/test/resources/Sql/sqlQuerys.json","$.poliza-vida-ley-activo"),NumeroPoliza);

        for (Map<String,Object> mapeo:registro){

            stspoliza=mapeo.get("ESTADOACTUAL").toString();
        }

        return stspoliza;
    }


    public static ValidarEstadoCotizada EstadoSql(String NumeroPoliza){
        return Instrumented.instanceOf(ValidarEstadoCotizada.class).withProperties(NumeroPoliza);
    }


}
