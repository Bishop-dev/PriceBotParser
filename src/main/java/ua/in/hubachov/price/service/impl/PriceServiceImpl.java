package ua.in.hubachov.price.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.hubachov.price.model.Product;
import ua.in.hubachov.price.parser.ProductParser;
import ua.in.hubachov.price.service.PriceService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * Created by Sashko on 4/7/17.
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private ProductParser productParser;

    @Override
    public Product getProduct(final String url) {
        final Product product = productParser.parse(url);
        return product == null ? generateRandomProduct() : product;
    }

    private Product generateRandomProduct() {
        return Product.create(randomString("WRONG URL "), randomDouble(), randomBoolean());
    }

    private String randomString(final String prefix) {
        return prefix + current().nextInt(100, 1000);
    }

    private double randomDouble() {
        return new BigDecimal(current().nextDouble(100, 1000)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private boolean randomBoolean() {
        return current().nextBoolean();
    }

}
