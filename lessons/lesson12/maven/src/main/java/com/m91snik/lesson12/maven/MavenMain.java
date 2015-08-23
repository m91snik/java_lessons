package com.m91snik.lesson12.maven;

import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by m91snik on 23.08.15.
 */
public class MavenMain {

    private static final Logger logger = LogManager.getLogger(MavenMain.class);

    public static void main(String[] args) {
        logger.error("Executing MavenMain");
        logger.info("Executing MavenMain - info");

        System.out.println(RandomUtils.nextLong(0, 10));
    }
}
