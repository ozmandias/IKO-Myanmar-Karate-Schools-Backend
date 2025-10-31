package com.james.IKO_Myanmar.converter;

import com.james.IKO_Myanmar.type.DayOfWeek;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class DayOfWeekSetConverter implements AttributeConverter<Set<DayOfWeek>, String> {
    @Override
    public String convertToDatabaseColumn(Set<DayOfWeek> entityValue) {
        if(entityValue == null || entityValue.isEmpty()) return null;
        return entityValue.stream().map(Enum::name).collect(Collectors.joining(","));
    }

    @Override
    public Set<DayOfWeek> convertToEntityAttribute(String databaseValue) {
        if(databaseValue == null || databaseValue.isBlank()) return new HashSet<>();
        return Arrays.stream(databaseValue.split(",")).map(DayOfWeek::valueOf).collect(Collectors.toSet());
    }
}
