package com.m91snik.lesson15.rest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by m91snik on 09.08.15.
 */
@JsonFormat(shape= JsonFormat.Shape.STRING)
public enum UserType {
    REGULAR, MANAGER, ADMIN;
}
