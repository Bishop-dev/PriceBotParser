package ua.in.hubachov.price.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.in.hubachov.price.model.Product;
import ua.in.hubachov.price.service.PriceService;

/**
 * Created by Sashko on 4/7/17.
 */
@Controller
public class ExternalBotController {

    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Hello!";
    }

    @RequestMapping(value = "/price", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductInfo(@RequestParam("url") String productUrl) {
        return priceService.getProduct(productUrl);
    }

}
