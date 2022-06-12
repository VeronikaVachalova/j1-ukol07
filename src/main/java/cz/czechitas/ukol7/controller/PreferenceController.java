package cz.czechitas.ukol7.controller;
import com.jgoodies.binding.PresentationModel;
import cz.czechitas.ukol7.formbuilder.ActionBuilder;
import cz.czechitas.ukol7.model.PreferenceBean;
import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class PreferenceController {

    private final PresentationModel<PreferenceBean> model;
    private final Action ulozitAction;

    public PreferenceController () {
        model = new PresentationModel<>(new PreferenceBean());
        ulozitAction = ActionBuilder.create("&Ulozit", this::handleUlozit);
        model.addBeanPropertyChangeListener(this::handlePropertyChange);
        vypoctiStavAkci();
    }

    private void handlePropertyChange(PropertyChangeEvent propertyChangeEvent) {
        vypoctiStavAkci();
    }

    public PresentationModel<PreferenceBean> getModel() {
        return model;
    }
    public Action getUlozitAction() {
        return ulozitAction;
    }

    private void vypoctiStavAkci() {
        if (model.getBean().getPrezdivka() != null && model.getBean().getBarva() != null) {
            ulozitAction.setEnabled(true);
        } else {
            ulozitAction.setEnabled(false);
        }
    }

    public void handleNovy() {
        this.model.setBean(new PreferenceBean());
    }

    public void handleUlozit() {
        PreferenceBean bean = this.model.getBean();
        System.out.println("-- Ukladam udaje --");
        System.out.printf("Prezdivka: %s", bean.getPrezdivka()).println();
        System.out.printf("Oblibena barva: %s", bean.getBarva()).println();

    }
}


