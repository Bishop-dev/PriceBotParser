package ua.in.hubachov.price.parser;

import ua.in.hubachov.price.model.Product;

/**
 * Created by Sashko on 4/8/17.
 */
public interface ProductParser {

    Product parse(final String url);

}
