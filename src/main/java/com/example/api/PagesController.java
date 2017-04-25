package com.example.api;

import com.example.model.Bar;
import com.example.model.Baz;
import com.example.model.Foo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    public PagesController(Foo foo, Bar bar, Baz baz) {
        System.out.println("foo"+foo);
        System.out.println("bar"+bar);
        System.out.println(baz);
    }
}



