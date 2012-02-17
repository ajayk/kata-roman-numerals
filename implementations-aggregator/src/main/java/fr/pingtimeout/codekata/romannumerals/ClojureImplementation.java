package fr.pingtimeout.codekata.romannumerals;

import clojure.lang.RT;
import clojure.lang.Var;

import java.io.IOException;

public class ClojureImplementation implements RomanNumeralsConverter {

    private static final Var CONVERT_NUMBER_FUNCTION;

    static {
        try {
            RT.loadResourceScript(ClojureImplementation.class, "fr/pingtimeout/codekata/romannumerals/kata.clj");
            CONVERT_NUMBER_FUNCTION = RT.var("fr.pingtimeout.codekata.romannumerals", "convert-number");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    public String convertArabicNumber(int number) {
        return (String) CONVERT_NUMBER_FUNCTION.invoke("" + number);
    }
}
