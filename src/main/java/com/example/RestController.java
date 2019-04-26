/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
