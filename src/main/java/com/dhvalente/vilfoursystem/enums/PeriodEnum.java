package com.dhvalente.vilfoursystem.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum PeriodEnum {

    BIMESTER("Bimestre", 1),
    TRIMESTER("Trismestre", 2),
    FOURMASTER("Quadrimestre", 3),
    SEMESTER("Semestre", 4);


    private final String period;
    private final Integer periodId;

    private PeriodEnum(String period, Integer periodId) {
        this.period = period;
        this.periodId = periodId;
    }

    public String getPeriod() {
        return period;
    }

    public Integer getPeriodId() {
        return periodId;
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
            if (keyValue.getPeriodId().equals(periodId))
                return keyValue;
        return null;
    }
}
