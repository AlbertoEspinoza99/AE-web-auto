package rimac.test.models;

import java.util.HashMap;
import java.util.Map;

public class ConnectionModelDB {

    private static final Map<String, Object> configOracleSASPreProd = new HashMap<>();

    private static final Map<String, Object> configOracleAXPreProd = new HashMap<>();

    private static final Map<String,Object> conifOracleAEOmpremice=new HashMap<>();

    public static Map<String, Object> getConfigOracleAXPreProd() {

        configOracleAXPreProd.put("username", "arocha");
        configOracleAXPreProd.put("password", "sqa2021a");
        configOracleAXPreProd.put("url", "jdbc:oracle:thin:@//rssitax03.rimac.com.pe:1521/SRV_TEST");
//        configSqlServerSAPP.put("url", "jdbc:sqlserver://RSTATSQL01:1433;databaseName=SAP;encrypt=true;trustServerCertificate=true");
//        configSqlServerSAPP.put("driverClassName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        configOracleAXPreProd.put("driverClassName", "oracle.jdbc.OracleDriver");

        return configOracleAXPreProd;
    }

    public static Map<String, Object> getConfigOracleSASPreProd() {

        configOracleSASPreProd.put("username", "arocha");
        configOracleSASPreProd.put("password", "sqa2021a");
        configOracleSASPreProd.put("url", "jdbc:oracle:thin:@//rssitax03.rimac.com.pe:1521/SRV_TEST");
        configOracleSASPreProd.put("driverClassName", "oracle.jdbc.OracleDriver");

        return configOracleSASPreProd;
    }

    public static Map<String,Object> getConfigOracleAEOmpremice(){

        conifOracleAEOmpremice.put("username","APP_VIDA");
        conifOracleAEOmpremice.put("password","DJ5321DA");
        conifOracleAEOmpremice.put("url","jdbc:oracle:thin:@//vidatp-scan.rimac.com.pe:1521/SRV_VIDATP");
        conifOracleAEOmpremice.put("driverClassName","oracle.jdbc.OracleDriver");

        return conifOracleAEOmpremice;
    }

}
