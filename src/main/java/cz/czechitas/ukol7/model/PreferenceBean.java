package cz.czechitas.ukol7.model;
import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;
import java.beans.PropertyChangeListener;

public class PreferenceBean implements ObservableBean {

    private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);

    private String prezdivka;
    private String barva;

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        String oldValue = this.prezdivka;
        this.prezdivka = prezdivka;
        pcs.firePropertyChange("prezdivka", oldValue, prezdivka);
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        String oldValue = this.barva;
        this.barva = barva;
        pcs.firePropertyChange("barva", oldValue, barva);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
