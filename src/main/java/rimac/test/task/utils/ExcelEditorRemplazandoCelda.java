package rimac.test.task.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;

public class ExcelEditorRemplazandoCelda {

    public static void reemplazarSucursal(String nuevoValor,String valor,String rutaAbsolutarutaExcel) throws Exception {

       // String rutaAbsolutarutaExcel= Paths.get("src/test/resources/archivos","VL DNI valido - VL.xlsx").toAbsolutePath().toString();


        FileInputStream file = new FileInputStream(new File(rutaAbsolutarutaExcel));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0); // suponemos que está en la primera hoja

        int columnaSucursal = -1;
        int columnaTipoProducto=-1;


        // Buscar la columna "SUCURSAL_EMPRESA"
        Row encabezado = sheet.getRow(0);
        for (Cell cell : encabezado) {
            if (cell.getStringCellValue().equalsIgnoreCase("SUCURSAL_EMPRESA")) {
                columnaSucursal = cell.getColumnIndex();
                break;
            }
        }

        if (columnaSucursal == -1) {
            throw new Exception("No se encontró la columna SUCURSAL_EMPRESA");
        }


        // Buscar la columna "TIPO_PRODUCTO"
        Row encabezado2 = sheet.getRow(0);
        for (Cell cell : encabezado2) {
            if (cell.getStringCellValue().equalsIgnoreCase("TIPO_PRODUCTO")) {
                columnaTipoProducto = cell.getColumnIndex();
                break;
            }
        }

        if (columnaTipoProducto == -1) {
            throw new Exception("No se encontró la columna SUCURSAL_EMPRESA");
        }



        // Obtener la fila elegida y cambiar la celda en esa columna
        Row row = sheet.getRow(1);
        if (row != null) {
            Cell cell = row.getCell(columnaSucursal);
            if (cell == null) {
                cell = row.createCell(columnaSucursal);
            }
            cell.setCellValue(nuevoValor);
        } else {
            throw new Exception("La fila " + 1 + " no existe.");
        }


        // Obtener la fila elegida y cambiar la celda en esa columna TIPO_PRODUCTO
        Row row1 = sheet.getRow(1);
        if (row1 != null) {
            Cell cell = row1.getCell(columnaTipoProducto);
            if (cell == null) {
                cell = row1.createCell(columnaTipoProducto);
            }
            cell.setCellValue(valor);
        } else {
            throw new Exception("La fila " + 1 + " no existe.");
        }


        // Guardar cambios
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(rutaAbsolutarutaExcel));
        workbook.write(outFile);
        outFile.close();
        workbook.close();
    }
}
