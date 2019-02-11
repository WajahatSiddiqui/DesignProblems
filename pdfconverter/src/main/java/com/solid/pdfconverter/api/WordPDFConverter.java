package com.solid.pdfconverter.api;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Class WordPDFConverter - Converts Word Documents to PDF
 * Created by wajahat
 */
public class WordPDFConverter implements Converter {

    public byte[] convertToPDF(byte[] fileBytes) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(fileBytes);
        Document wordDocument  =  new Document(inputStream);
        ByteArrayOutputStream pdfDocument = new ByteArrayOutputStream();
        wordDocument.save(pdfDocument, SaveFormat.PDF);
        return pdfDocument.toByteArray();
    }
}
