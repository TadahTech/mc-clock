package com.tadahtechnologies.mctest.block;

import com.google.common.collect.Maps;

import java.util.Map;

public enum Letters {

    A(
      "XXX", //
      "X X", //
      "XXX", //
      "X X", //
      "X X"),
    B(
      "XXX", //
      "X  X", //
      "XXX", //
      "X  X", //
      "XXX"),
    C(
      "XXX", //
      "X", //
      "X", //
      "X", //
      "XXX"),
    D(
      "XXX", //
      "X  X", //
      "X  X", //
      "X  X", //
      "XXX"),
    E(
      "XXX", //
      "X", //
      "XX", //
      "X", //
      "XXX"),
    F(
      "XXX", //
      "X", //
      "XX", //
      "X", //
      "X"),
    G(
      "XXX", //
      "X", //
      "X", //
      "X X", //
      "XXX"),
    H(
      "X X", //
      "X X", //
      "XXX", //
      "X X", //
      "X X"),
    I(
      "XXX", //
      " X", //
      " X", //
      " X", //
      "XXX"),
    J(
      "XXXX", //
      "  X", //
      "  X", //
      "  X", //
      "XXX"),
    K(
      "X  X", //
      "X X", //
      "XX", //
      "X X", //
      "X  X"),
    L(
      "X", //
      "X", //
      "X", //
      "X", //
      "XXX"),
    M(
      "XX XX", //
      "X X X", //
      "X X X", //
      "X   X", //
      "X   X"),
    N(
      "X   X", //
      "XX  X", //
      "X X X", //
      "X  XX", //
      "X   X"),
    O(
      " XX ", //
      "X  X", //
      "X  X", //
      "X  X", //
      " XX"),
    P(
      "XXX", //
      "X  X", //
      "XXX", //
      "X", //
      "X"),
    Q(
      " XXX ", //
      "X   X", //
      "X X X", //
      "X  XX", //
      " XXX"),
    R(
      "XXX", //
      "X X", //
      "XX", //
      "X X", //
      "X X"),
    S(
      "XXX", //
      "X", //
      "XXX", //
      "  X", //
      "XXX"),
    T(
      "XXX", //
      " X", //
      " X", //
      " X", //
      " X"),
    U(
      "X  X", //
      "X  X", //
      "X  X", //
      "X  X", //
      " XX"),
    V(
      "X   X", //
      "X   X", //
      " X X", //
      " X X", //
      "  X"),
    W(
      "X   X", //
      "X   X", //
      "X X X", //
      "X X X", //
      " X X"),
    X(
      "X X", //
      "X X", //
      " X", //
      "X X", //
      "X X"),
    Y(
      "X X", //
      "X X", //
      " X", //
      " X", //
      " X"),
    Z(
      "XXX", //
      "  X", //
      " X", //
      "X", //
      "XXX"),
    N1(
      "XX", //
      " X", //
      " X", //
      " X", //
      "XXX"),
    N2(
      "XXX", //
      "  X", //
      "XXX", //
      "X", //
      "XXX"),
    N3(
      "XXX", //
      "  X", //
      "XXX", //
      "  X", //
      "XXX"),
    N4(
      "X X", //
      "X X", //
      "XXX", //
      "  X", //
      "  X"),
    N5(
      "XXX", //
      "X", //
      "XXX", //
      "  X", //
      "XXX"),
    N6(
      "XXX", //
      "X", //
      "XXX", //
      "X X", //
      "XXX"),
    N7(
      "XXX", //
      "  X", //
      "  X", //
      "  X", //
      "  X"),
    N8(
      "XXX", //
      "X X", //
      "XXX", //
      "X X", //
      "XXX"),
    N9(
      "XXX", //
      "X X", //
      "XXX", //
      "  X", //
      "  X"),
    N0(
      "XXX", //
      "X X", //
      "X X", //
      "X X", //
      "XXX"),;

    private static Map<String, BlockFormat> LETTERS = Maps.newHashMap();

    static {
        for (Letters letters : values()) {
            LETTERS.put(letters.letter.toLowerCase(), new BlockFormat(letters.pattern));
        }

        LETTERS.put(":", new BlockFormat("   ", " X ", "   ", " X ", "   "));
        LETTERS.put("-", new BlockFormat("  ", "   ", "XXX", "   ", "   "));
        LETTERS.put(" ", new BlockFormat("   ", "   ", "   ", "   ", "   "));
    }


    private String letter;
    private String[] pattern;

    Letters(String... pattern) {
        this.pattern = pattern;
        this.letter = this.name().contains("N") && this.name().length() > 1 ? this.name().substring(1) : this.name();
    }

    public static BlockFormat get(String c) {
        return LETTERS.get(c);
    }

}
