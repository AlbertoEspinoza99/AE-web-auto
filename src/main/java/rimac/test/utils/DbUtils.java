package rimac.test.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class DbUtils {

    private static final Logger logger = LoggerFactory.getLogger(DbUtils.class);

    private final JdbcTemplate jdbc;

    public DbUtils(Map<String, Object> config) {
        String url = (String) config.get("url");
        String username = (String) config.get("username");
        String password = (String) config.get("password");
        String driver = (String) config.get("driverClassName");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        jdbc = new JdbcTemplate(dataSource);
        logger.info("init jdbc conexión al servidor BD: {}", url);
        System.out.println("Conexion realizada a: " + url);
    }

    public Object readValue(String query) {
        return jdbc.queryForObject(query, Object.class);
    }

    public Map<String, Object> readRow(String query) {
        return jdbc.queryForMap(query);
    }

    public List<Map<String, Object>> readRows(String query) {
        return jdbc.queryForList(query);
    }

    public Object updateRows(String query) {
        return jdbc.update(query);
    }

    public void commitBD() {
        try {
            jdbc.execute("COMMIT");
            logger.info("Commit realizado correctamente");
        } catch (Exception e) {
            logger.error("Error al realizar el commit: {}", e.getMessage());
        }
    }

    public Object updateElements(String query, Object... params) {
        if (params.length == countOccurrences(query, '?')) {
            return jdbc.update(query, params);
        } else {
            throw new IllegalArgumentException("El número de parámetros no coincide con el número de variables permitidas en la consulta.");
        }
    }

    public List<Map<String, Object>> selectConParametros(String query, Object... params) {
        if (params.length == countOccurrences(query, '?')) {
            return jdbc.queryForList(query, params);
        } else {
            throw new IllegalArgumentException("El número de parámetros no coincide con el número de variables permitidas en la consulta.");
        }
    }

    public void insertRows(String query, List<Object[]> values) {
        try {
            jdbc.batchUpdate(query, values);
            logger.info("Inserción de filas realizada correctamente.");
        } catch (Exception e) {
            logger.error("Error al insertar filas: {}", e.getMessage());
        }
    }

    private int countOccurrences(String sentenciaSql, char marcador) {
        int count = 0;
        for (int i = 0; i < sentenciaSql.length(); i++) {
            if (sentenciaSql.charAt(i) == marcador) {
                count++;
            }
        }
        return count;
    }

}