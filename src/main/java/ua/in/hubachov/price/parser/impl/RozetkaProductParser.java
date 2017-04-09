package ua.in.hubachov.price.parser.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import ua.in.hubachov.price.model.Product;
import ua.in.hubachov.price.parser.ProductParser;

/**
 * Created by Sashko on 4/8/17.
 */
@Service
public class RozetkaProductParser implements ProductParser {

    @Override
    public Product parse(final String url) {
        try {
            final Document page = Jsoup.connect(url).get();
            final String priceStr =
                    page.select("meta[itemprop=price]").first().attr("content");
            String productName = "";
            Element productNameElement = page.select("meta[itemprop=name]").first();
            if (productNameElement == null) {
                productName = page.select("span[class=detail-tabs-i-title-inner]").first().text();
            } else {
                productName = productNameElement.attr("content");
            }
            final double price = Double.parseDouble(priceStr);
            boolean available = true;
            if (page.select("div[class=detail-status]").first().text().equals("Нет в наличии")) {
                available = false;
            }
            return Product.create(productName, price, available);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
