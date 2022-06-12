package cz.czechitas.ukol7.view;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;
import cz.czechitas.ukol7.Aplikace;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.PreferenceBean;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import cz.czechitas.ukol7.Barva;

public class HlavniOkno extends JFrame {
    private final PreferenceController controller;

    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Souhrn");
        this.controller = controller;
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new MigLayout("wrap 2", "[right, 100]rel[50:75:250,grow,fill]"));
        setMinimumSize(new Dimension(300, 200));

        FormBuilderWithContainer<PreferenceBean> formBuilder = FormBuilder.create(controller.getModel())
                .container(this);

        formBuilder
                .label("&Prezdivka")
                .textField("prezdivka")
                .add("span");


        formBuilder
                .label("&Oblibená barva")

                .radioButton("Bila", "barva", Barva.Bila.toString())
                .add("left, span")

                .radioButton("Fialova", "barva", Barva.Fialova.toString())
                .add("left, span")

                .radioButton("zelena", "barva", Barva.Zelena.toString() )
                .add("left, span");

        formBuilder
                .panel(panel -> {
                    JButton ulozitButton = new JButton(controller.getUlozitAction());
                    getRootPane().setDefaultButton(ulozitButton);
                    panel.add(ulozitButton);
                })
                .add("right, span");

        pack();
    }
}



