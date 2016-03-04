package brito.viadinho.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by peo_rboliveira on 04/03/16.
 */
@RestController
public class SampleController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Seja bem-vindo";
    }
}
