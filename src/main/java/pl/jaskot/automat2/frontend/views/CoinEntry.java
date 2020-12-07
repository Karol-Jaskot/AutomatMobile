package pl.jaskot.automat2.frontend.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import pl.jaskot.automat2.backend.services.MoneyService;
import pl.jaskot.automat2.frontend.components.InfoDialog;
import pl.jaskot.automat2.frontend.components.MoneyDialog;

public class CoinEntry extends Notification {

    private MoneyService moneyService;
    private Label howManyMoney;
    private Button bt10gr, bt20gr, bt50gr, bt1zl, bt2zl, bt5zl;
    private Button btMoneyReturn;

    public CoinEntry(MoneyService moneyService) {
        this.moneyService = moneyService;
        setPosition(Position.BOTTOM_CENTER);

        createMoneyLabel();
        createMoneyButtons();

        add(new Div(),bt10gr, bt20gr, bt50gr, bt1zl, bt2zl, bt5zl, new Div());

        createMoneyReturnButton();
        add(new Button("Zamknij panel", e -> close()));

        open();
    }

    private void createMoneyReturnButton() {
        btMoneyReturn = new Button("Zwróć pieniądze");
        btMoneyReturn.addClickListener(e -> returnMoney());
        add(btMoneyReturn);
    }

    private void returnMoney() {
        showMoneyToReturn(moneyService.showClientMoney());
        moneyService.removeMoney();
        showMoney();
    }

    private void showMoneyToReturn(double money) {
        if(money<=0){
            new InfoDialog("Brak monet do zwrócenia!");
        }else{
            new MoneyDialog(money);
        }
    }

    private void createMoneyLabel() {
        howManyMoney = new Label();
        showMoney();
        add(howManyMoney);
    }

    private void createMoneyButtons() {
        bt10gr = newButton("10 gr", 0.1);
        bt20gr = newButton("20 gr", 0.2);
        bt50gr = newButton("50 gr", 0.5);
        bt1zl = newButton("1 zł", 1.0);
        bt2zl = newButton("2 zł", 2.0);
        bt5zl = newButton("5 zł", 5.0);
    }

    private Button newButton(String name, double value) {
        Button button = new Button(name);
        button.addClickListener(e -> addMoney(value));
        return button;
    }

    
    private void addMoney(double money) {
        moneyService.addClientMoney(money);
        showMoney();
    }

    public void showMoney() {
        howManyMoney.setText(String.format("Obecna suma pieniędzy:  %.2f zł", moneyService.showClientMoney()));
    }

}
