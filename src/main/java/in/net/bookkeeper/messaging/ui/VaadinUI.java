package in.net.bookkeeper.messaging.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * Created by krganeshrajhan on 18/11/17.
 */
@SpringUI
@Theme("valo")
public class VaadinUI extends UI {
    private int clickCounter = 0;
    private Label clickCounterLabel;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = VaadinUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);

        layout.addComponent(new Label("Hello World!"));
        layout.addComponent(new Label("Greetings from server."));
        layout.addComponent(new Label("I have "
                + Runtime.getRuntime().availableProcessors()
                + " processors and "
                + (Runtime.getRuntime().totalMemory() / 1000000)
                + " MB total memory."));

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                clickCounter++;
                clickCounterLabel.setValue("Clicks: " + clickCounter);
                Notification.show("Thank you for clicking.");
            }
        });

        layout.addComponent(button);
        layout.addComponent(clickCounterLabel = new Label("Clicks: 0"));
    }
}
