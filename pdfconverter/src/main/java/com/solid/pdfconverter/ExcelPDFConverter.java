package com.solid.pdfconverter;

import com.aspose.cells.PdfCompliance;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.solid.pdfconverter.api.Converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Class ExcelPDFConverter
 * Created by wajahat
 */
public class ExcelPDFConverter implements Converter {

    public byte[] convertToPDF(byte[] fileBytes) throws Exception {
        InputStream input = new ByteArrayInputStream(fileBytes);
        Workbook workbook = new Workbook(input);
        PdfSaveOptions saveOptions = new PdfSaveOptions();
        saveOptions.setCompliance(PdfCompliance.PDF_A_1_B);
        ByteArrayOutputStream pdfDocument = new ByteArrayOutputStream();
        workbook.save(pdfDocument, saveOptions);
        return pdfDocument.toByteArray();
    }
}
