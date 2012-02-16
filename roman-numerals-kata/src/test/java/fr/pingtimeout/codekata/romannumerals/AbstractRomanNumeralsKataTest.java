package fr.pingtimeout.codekata.romannumerals;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractRomanNumeralsKataTest {

    public abstract RomanNumeralsConverter createRomanNumeralsConverter();

    @Test
    public void test_that_base_symbols_are_converted() {
        final RomanNumeralsConverter converter = createRomanNumeralsConverter();

        assertEquals("Converter should convert base symbols", "I", converter.convertArabicNumber(1));
        assertEquals("Converter should convert base symbols", "V", converter.convertArabicNumber(5));
        assertEquals("Converter should convert base symbols", "X", converter.convertArabicNumber(10));
        assertEquals("Converter should convert base symbols", "L", converter.convertArabicNumber(50));
        assertEquals("Converter should convert base symbols", "C", converter.convertArabicNumber(100));
        assertEquals("Converter should convert base symbols", "D", converter.convertArabicNumber(500));
        assertEquals("Converter should convert base symbols", "M", converter.convertArabicNumber(1000));
    }

    @Test
    public void test_that_unit_tokens_are_converted() {
        final RomanNumeralsConverter converter = createRomanNumeralsConverter();

        assertEquals("Converter should convert unit tokens", "I", converter.convertArabicNumber(1));
        assertEquals("Converter should convert unit tokens", "II", converter.convertArabicNumber(2));
        assertEquals("Converter should convert unit tokens", "III", converter.convertArabicNumber(3));
        assertEquals("Converter should convert unit tokens", "IV", converter.convertArabicNumber(4));
        assertEquals("Converter should convert unit tokens", "V", converter.convertArabicNumber(5));
        assertEquals("Converter should convert unit tokens", "VI", converter.convertArabicNumber(6));
        assertEquals("Converter should convert unit tokens", "VII", converter.convertArabicNumber(7));
        assertEquals("Converter should convert unit tokens", "VIII", converter.convertArabicNumber(8));
        assertEquals("Converter should convert unit tokens", "IX", converter.convertArabicNumber(9));
    }

    @Test
    public void test_that_tens_tokens_are_converted() {
        final RomanNumeralsConverter converter = createRomanNumeralsConverter();

        assertEquals("Converter should convert tens tokens", "X", converter.convertArabicNumber(10));
        assertEquals("Converter should convert tens tokens", "XX", converter.convertArabicNumber(20));
        assertEquals("Converter should convert tens tokens", "XXX", converter.convertArabicNumber(30));
        assertEquals("Converter should convert tens tokens", "XL", converter.convertArabicNumber(40));
        assertEquals("Converter should convert tens tokens", "L", converter.convertArabicNumber(50));
        assertEquals("Converter should convert tens tokens", "LX", converter.convertArabicNumber(60));
        assertEquals("Converter should convert tens tokens", "LXX", converter.convertArabicNumber(70));
        assertEquals("Converter should convert tens tokens", "LXXX", converter.convertArabicNumber(80));
        assertEquals("Converter should convert tens tokens", "XC", converter.convertArabicNumber(90));
    }

    @Test
    public void test_that_mixed_tokens_are_converted() {
        final RomanNumeralsConverter converter = createRomanNumeralsConverter();

        assertEquals("Converter should convert mixed tokens", "XI", converter.convertArabicNumber(11));
        assertEquals("Converter should convert mixed tokens", "XII", converter.convertArabicNumber(12));
        assertEquals("Converter should convert mixed tokens", "XIII", converter.convertArabicNumber(13));
        assertEquals("Converter should convert mixed tokens", "XIV", converter.convertArabicNumber(14));
        assertEquals("Converter should convert mixed tokens", "XV", converter.convertArabicNumber(15));
        assertEquals("Converter should convert mixed tokens", "XVI", converter.convertArabicNumber(16));
        assertEquals("Converter should convert mixed tokens", "XVII", converter.convertArabicNumber(17));
        assertEquals("Converter should convert mixed tokens", "XVIII", converter.convertArabicNumber(18));
        assertEquals("Converter should convert mixed tokens", "XIX", converter.convertArabicNumber(19));
    }

    @Test
    public void test_that_complex_cases_are_handled() {
        final RomanNumeralsConverter converter = createRomanNumeralsConverter();

        assertEquals("Converter should convert complex numbers", "XLII", converter.convertArabicNumber(42));
        assertEquals("Converter should convert complex numbers", "LXXXIX", converter.convertArabicNumber(89));
        assertEquals("Converter should convert complex numbers", "XCIX", converter.convertArabicNumber(99));
        assertEquals("Converter should convert complex numbers", "CXI", converter.convertArabicNumber(111));
        assertEquals("Converter should convert complex numbers", "MCMXCIX", converter.convertArabicNumber(1999));
    }
}
