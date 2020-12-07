package pl.jaskot.automat2.frontend.components;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import pl.jaskot.automat2.backend.services.MathService;

public class MoneyDialog extends Dialog {

    private double money;
    private String message;

    public MoneyDialog(double money) {
        this.money = money;
        message = "Zwrócone monety: ";
        moneyCalculator("5 zł  ", 5.0);
        moneyCalculator("2 zł  ", 2.0);
        moneyCalculator("1 zł  ", 1.0);
        moneyCalculator("50 gr  ", 0.5);
        moneyCalculator("20 gr  ", 0.2);
        moneyCalculator("10 gr  ", 0.1);
        add(new Label(message));
        open();
    }

    private void moneyCalculator(String name, double value) {
        money = MathService.roundToDecimal(money, 1);
        int x = (int) (money / value);
        money = money - x * value;
        if (x == 0) {
            // nothing to do
        } else if (x == 1) {
            message += name;
        } else {
            message += x + "x " + name;
        }
    }

}