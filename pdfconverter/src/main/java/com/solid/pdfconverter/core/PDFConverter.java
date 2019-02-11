package com.solid.pdfconverter.core;

import com.solid.pdfconverter.api.Converter;

/**
 * Class PDFConverter
 * Created by wajahat
 */
public class PDFConverter {
    public byte[] convertToPDF(Converter converter, byte[] fileBytes) throws Exception {
        return converter.convertToPDF(fileBytes);
    }
}
