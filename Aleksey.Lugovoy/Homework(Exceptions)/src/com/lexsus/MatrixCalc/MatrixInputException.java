package com.lexsus.MatrixCalc;

import java.util.logging.Logger;

/**
 * Created by Lexsus on 03.08.2015.
 */

public class MatrixInputException extends RuntimeException
{
    private static Logger log = Logger.getLogger(MatrixInputException.class.getName());
    public MatrixInputException(String message, Throwable cause) {

        super(message, cause);
        log.info(message);
    }
}
