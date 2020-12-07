package pl.jaskot.automat2.frontend;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.jaskot.automat2.backend.services.MoneyService;
import pl.jaskot.automat2.backend.services.ProductService;
import pl.jaskot.automat2.frontend.views.ClientPage;
import pl.jaskot.automat2.frontend.views.CoinEntry;

@Route("")
public class MainView extends VerticalLayout {

    private MoneyService moneyService;
    private ProductService productService;
    private CoinEntry coinEntry;
    private ClientPage clientPage;

    public MainView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        createServices();
        createPages();
        add(clientPage);
    }

    private void createPages() {
        clientPage = new ClientPage(moneyService, productService, coinEntry);
    }

    private void createServices() {
        moneyService = new MoneyService();
        productService = new ProductService();
        coinEntry = new CoinEntry(moneyService);
    }
}