package cn.lacknb.blog.bootjunit5mockitodemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Controller for demonstrating REST API endpoints
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    /**
     * Simple hello endpoint
     * @return greeting message
     */
    @GetMapping
    public String hello() {
        return "Hello, World!";
    }

    /**
     * Hello with name parameter
     * @param name the name to greet
     * @return personalized greeting
     */
    @GetMapping("/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    /**
     * Hello with query parameters
     * @param name the name to greet
     * @param greeting custom greeting message
     * @return personalized greeting
     */
    @GetMapping("/greet")
    public String helloWithParams(
            @RequestParam(required = false, defaultValue = "World") String name,
            @RequestParam(required = false, defaultValue = "Hello") String greeting) {
        return greeting + ", " + name + "!";
    }
}