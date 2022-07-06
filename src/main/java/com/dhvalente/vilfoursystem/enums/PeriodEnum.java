package com.dhvalente.vilfoursystem.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum PeriodEnum {

    BIMESTER("Bimestre", 2),
    TRIMESTER("Trismestre", 3),
    FOURMASTER("Quadrimestre", 4),
    SEMESTER("Semestre", 6);


    private final String period;
    private final Integer value;

    private PeriodEnum(String period, Integer value) {
        this.period = period;
        this.value = value;
    }

    public String getPeriod() {
        return period;
    }

    public Integer getValue() {
        return value;
    }

    private static final Map<String, PeriodEnum> Lookup = new HashMap<String, PeriodEnum>();

    static {
        for (PeriodEnum keyValue : EnumSet.allOf(PeriodEnum.class))
            Lookup.put(keyValue.getPeriod(), keyValue);
    }

    public static PeriodEnum get(String period) {
        return Lookup.get(period);
    }

    public static PeriodEnum getByPaymentMethodId(Integer periodId) {
        for (PeriodEnum keyValue : EnumSet.allOf(PeriodEnum.class))
            if (keyValue.getValue().equals(periodId))
                return keyValue;
        return null;
    }
}
