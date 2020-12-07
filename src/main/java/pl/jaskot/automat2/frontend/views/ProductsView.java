package pl.jaskot.automat2.frontend.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import pl.jaskot.automat2.backend.entity.Product;
import pl.jaskot.automat2.backend.services.MoneyService;
import pl.jaskot.automat2.backend.services.ProductService;
import pl.jaskot.automat2.frontend.components.InfoDialog;
import pl.jaskot.automat2.frontend.components.MoneyDialog;

public class ProductsView extends VerticalLayout {

    private MoneyService moneyService;
    private ProductService productService;
    private CoinEntry coinEntry;

    public ProductsView(MoneyService moneyService, ProductService productService, CoinEntry coinEntry) {
        this.moneyService = moneyService;
        this.productService = productService;
        this.coinEntry = coinEntry;

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(new H1("Automat z napojami"));
        createProductsList();
    }

    private void createProductsList() {
        HorizontalLayout pageLayout = new HorizontalLayout();
        for (Product product : productService.getProducts()) {
            pageLayout.add(productLayout(product));
            add(pageLayout);
        }
    }

    private VerticalLayout productLayout(Product product){
        VerticalLayout divProduct = new VerticalLayout();
        divProduct.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Label lbHowMany = new Label(" Ilość: " + product.getHowMany() + "   ");
        divProduct.add(lbHowMany,
                createImage(product.getImageLink()),
                new Label(String.format("Cena: %.2f zł ", product.getPrice())),
                new Button("Wybieram!",e -> checkThisProduct(product, lbHowMany)));
        return divProduct;
    }

    private void checkThisProduct(Product product, Label lbHowMany) {
        if (moneyService.showClientMoney() < product.getPrice()) {
            new InfoDialog("Brak wystarczających środków!");
        } else {
            if (product.getHowMany() == 0) {
                new InfoDialog("Brak podanego produktu!");
            } else {
                new InfoDialog("Produkt gotowy do odebrania!");
                moneyService.payForProduct(product.getPrice());
                coinEntry.showMoney();
                productService.takeOneProduct(product);
                lbHowMany.setText(" Ilość: " + product.getHowMany() + "   ");
            }
        }
    }

    private Image createImage(String linkToImage){
        Image image = new Image(linkToImage, "Foto");
        image.setHeight("100px");
        image.setWidth("100px");
        return image;
    }
}