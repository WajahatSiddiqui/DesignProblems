package com.solid.pdfconverter.api;

/**
 * Class PDFConverter
 * Created by wajahat
 */
public class PDFConverter {
    public byte[] convertToPDF(Converter converter, byte[] fileBytes) throws Exception {
        return converter.convertToPDF(fileBytes);
    }
}
