package fr.pingtimeout.codekata.romannumerals;

public class ClojureImplementationTest extends AbstractRomanNumeralsKataTest{
    @Override
    public RomanNumeralsConverter createRomanNumeralsConverter() {
        return new ClojureImplementation();
    }
}
