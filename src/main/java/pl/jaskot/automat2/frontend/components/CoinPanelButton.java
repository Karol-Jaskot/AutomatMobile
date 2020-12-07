package pl.jaskot.automat2.frontend.components;

import com.vaadin.flow.component.button.Button;
import pl.jaskot.automat2.frontend.views.CoinEntry;

public class CoinPanelButton extends Button {

    private CoinEntry coinEntry;

    public CoinPanelButton(CoinEntry coinEntry){
        this.coinEntry = coinEntry;
        setText("Panel płatniczy");
        addClickListener(e -> changePanel(coinEntry));
    }

    private void changePanel(CoinEntry coinEntry) {
        if (coinEntry.isOpened()) {
            coinEntry.close();
        } else {
            coinEntry.open();
        }
    }
}
