package rimac.test.task.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelEditorRemplazandoValor {

    public static void reemplazarSucursal(String rutaExcel, String nuevoValor) throws Exception {
        FileInputStream file = new FileInputStream(new File(rutaExcel));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0); // suponemos que está en la primera hoja

        int columnaSucursal = -1;

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


        // Buscar la fila con el valor "1967619" y reemplazar
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // saltar encabezado

            Cell cell = row.getCell(columnaSucursal);
            if (cell != null && cell.getCellType() == CellType.NUMERIC &&
                    ((long) cell.getNumericCellValue()) == 1967619L) {

                cell.setCellValue(Long.parseLong(nuevoValor));
                break;
            }
        }




        // Guardar cambios
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(rutaExcel));
        workbook.write(outFile);
        outFile.close();
        workbook.close();
    }
}
