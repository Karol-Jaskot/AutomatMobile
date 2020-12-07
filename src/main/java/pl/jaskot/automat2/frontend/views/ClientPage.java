package pl.jaskot.automat2.frontend.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import pl.jaskot.automat2.backend.services.MoneyService;
import pl.jaskot.automat2.backend.services.ProductService;
import pl.jaskot.automat2.frontend.components.CoinPanelButton;

public class ClientPage extends VerticalLayout {

    public ClientPage(MoneyService moneyService, ProductService productService, CoinEntry coinEntry){
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(
                new ProductsView(moneyService, productService, coinEntry),
                new CoinPanelButton(coinEntry));
    }

}
