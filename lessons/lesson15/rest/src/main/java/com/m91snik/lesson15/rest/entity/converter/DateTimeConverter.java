package com.m91snik.lesson15.rest.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by m91snik on 09.08.15.
 */
@Converter(autoApply = true)
public class DateTimeConverter implements AttributeConverter<Date, Timestamp> {

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(Date date) {
        return date == null ? null : new Timestamp(date.getTime());
    }

    @Override
    public Date convertToEntityAttribute(java.sql.Timestamp dbData) {
        return dbData == null ? null : new Date(dbData.getTime());
    }
}
