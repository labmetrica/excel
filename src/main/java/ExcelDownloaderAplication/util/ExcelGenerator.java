package ExcelDownloaderAplication.util;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ExcelDownloader.modelo.Grupo;

public class ExcelGenerator {

	private ExcelGenerator() {
		throw new IllegalStateException("ExcelGenerator class");
	}

	public static void usuariosToExcel(List<Grupo> grupos) throws IOException {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			final Sheet sheet = workbook.createSheet("Usuario");

			// Header Style
			final Font headerFont = Utils.createFont(workbook, IndexedColors.BLUE.getIndex());
			final CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// User Style
			final Font userFont = Utils.createFont(workbook, IndexedColors.BLACK.getIndex());
			final CellStyle userCellStyle = workbook.createCellStyle();
			userCellStyle.setFont(userFont);

			// Header Row
			final Row headerRow = sheet.createRow(0);

			// Build header
			for (int col = 0; col < grupos.size(); col++) {
				Utils.createCell(headerRow, col, headerCellStyle, Utils.composeHeader(grupos.get(col)));
			}

			// Print all user
			Row userRow = null;
			final int maxUsers = Utils.maxUsers(grupos);
			for (int row = 0; row < maxUsers; row++) {
				userRow = sheet.createRow(row + 1);
				for (int grupo = 0; grupo < grupos.size(); grupo++) {
					sheet.autoSizeColumn(grupo);
					Utils.createCell(userRow, grupo, userCellStyle, Utils.getUserFromGroup(grupos.get(grupo), row));
				}
			}

			// Write the output to a file
			workbook.write(out);
			final FileOutputStream fileOut = new FileOutputStream("Horario.xlsx");
			workbook.write(fileOut);
			fileOut.close();

		}

	}
}
