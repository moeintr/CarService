package com.a.common.wrapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorHandler {
    private ErrorHandler() {}
    public static Map getError(Exception e) {
        Map<String, String> map = new HashMap<>();
        e.printStackTrace();
        if (e instanceof ArithmeticException) {
            map.put("code", "101");
            map.put("msg", e.getMessage());
        } else if (e instanceof SQLException) {
            map.put("code", "102");
            map.put("msg", e.getMessage());
        }else {
            map.put("code", "1000");
            map.put("msg", "call 2 supprt "+e.getMessage());
        }
        return map;
    }
}
