package ua.in.hubachov.price.service;

import ua.in.hubachov.price.model.Product;

/**
 * Created by Sashko on 4/7/17.
 */
public interface PriceService {

    Product getProduct(final String url);

}
