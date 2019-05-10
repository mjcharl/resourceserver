package com.example;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping({"/user", "/me"})
    public Map<String, String> user(Principal principal, HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("UnserInfo", principal.toString());
        map.put("JSessionID = ", request.getSession().getId());
        return map;
    }

    @RequestMapping({"/insecure/user"})
    public Map<String, String> insecureApi(Principal principal, HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("UnserInfo", "This is the unauthenticated endpoint");
        map.put("JSessionID = ", request.getSession().getId());
        return map;
    }
}
