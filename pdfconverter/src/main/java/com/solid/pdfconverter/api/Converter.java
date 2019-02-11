package com.solid.pdfconverter.api;

/**
 * API to convert to a given document into another format
 * Created by wajahat
 */
public interface Converter {
    public byte[] convertToPDF(byte[] fileBytes) throws Exception;
}
