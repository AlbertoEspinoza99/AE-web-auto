package rimac.test.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;
import org.json.JSONTokener;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UtilApp {

    public static void escribirJson(Object jsonObject, String filename) {
        try (FileWriter file = new FileWriter("src/test/resources/jsonData/" + filename + ".json")) {
            file.write(jsonObject.toString());
            System.out.println("Archivo JSON guardado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readJson(String filePath, String jsonPath) throws IOException {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            return JsonPath.read(jsonContent, jsonPath);
        } catch (Exception e) {
            return "ERROR";
        }
    }

    public static String obtenerFechaActual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.now().format(formatter);
    }

    public static String getJsonValue(String jsonFile, String jsonPath) {
        String jValue = "";
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(jsonFile)));
            jValue = JsonPath.read(contenido, jsonPath);
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo JSON: " + e.getMessage(), e);
        }
        return jValue;
    }

    // ✅ Nuevo método agregado
    public static JSONObject leerJson(String filename) {
        File file = new File("src/test/resources/jsonData/" + filename + ".json");

        if (!file.exists()) {
            return new JSONObject(); // Retorna JSON vacío si no existe
        }

        try (FileReader reader = new FileReader(file)) {
            JSONTokener tokener = new JSONTokener(reader);
            return new JSONObject(tokener);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo JSON: " + filename, e);
        }
    }

}
