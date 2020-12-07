package pl.jaskot.automat2.frontend.components;

import com.vaadin.flow.component.dialog.Dialog;

public class InfoDialog extends Dialog{

    public InfoDialog(String message){
        add(message);
        open();
    }

}
