import com.solid.pdfconverter.ExcelPDFConverter;
import com.solid.pdfconverter.core.PDFConverter;
import com.solid.pdfconverter.WordPDFConverter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import static java.nio.file.Paths.get;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Class PDFConverterTest
 * Created by wajahat
 */
public class PDFConverterTest {

    private PDFConverter pdfConverter = new PDFConverter();
    private static final String WORD_FILE = "word";
    private static final String EXCEL_FILE = "excel";
    private static final String WORD_FILE_EXT = ".doc";
    private static final String EXCEL_FILE_EXT = ".xlsx";
    private static final String PDF_FILE_EXT = ".pdf";
    private ClassLoader classLoader = getClass().getClassLoader();

    static void writeByte(byte[] bytes, File file)
    {
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
        }

        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void testWordConverter() throws Exception {
        String fileName = WORD_FILE + WORD_FILE_EXT;
        assertNotNull(classLoader.getResource(fileName));
        File file = new File(classLoader.getResource(fileName).getFile());
        byte [] fileBytes = Files.readAllBytes(get(file.getPath()));
        File pdfFile = new File(WORD_FILE + PDF_FILE_EXT);
        writeByte(pdfConverter.convertToPDF(new WordPDFConverter(), fileBytes), pdfFile);
        assertTrue(pdfFile.exists());
    }

    @Test
    public void testExcelConverter() throws Exception {
        String fileName = EXCEL_FILE + EXCEL_FILE_EXT;
        assertNotNull(classLoader.getResource(fileName));
        File file = new File(classLoader.getResource(fileName).getFile());
        byte [] fileBytes = Files.readAllBytes(get(file.getPath()));
        File pdfFile = new File(EXCEL_FILE + PDF_FILE_EXT);
        writeByte(pdfConverter.convertToPDF(new ExcelPDFConverter(), fileBytes), pdfFile);
        assertTrue(pdfFile.exists());
    }
}
