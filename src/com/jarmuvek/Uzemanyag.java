package com.jarmuvek;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Uzemanyag {

    enum Tipus {
        Benzin, Dizel, MEGHATAROZATLAN;
        private static final Map<String, Uzemanyag.Tipus> ENUM_MAP = Stream.of(Uzemanyag.Tipus.values())
                .collect(Collectors.toMap(Enum::name, Function.identity()));

        public static Uzemanyag.Tipus of(final String name) {
            return ENUM_MAP.getOrDefault(name, MEGHATAROZATLAN);
        }
    }

    private int mennyiseg;

    public Uzemanyag(Tipus tipus, int mennyiseg) {

        this.mennyiseg = mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }
}
