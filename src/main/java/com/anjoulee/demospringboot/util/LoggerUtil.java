package com.anjoulee.demospringboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

    public static void info(Class<? extends Object> obj, String msg) {
        Logger logger = LoggerFactory.getLogger(obj);
        logger.info(msg);
    }


}
