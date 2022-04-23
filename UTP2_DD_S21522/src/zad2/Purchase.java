/**
 *
 *  @author Dajcz Dariusz S21522
 *
 */

package zad2;


import java.beans.*;

public class Purchase {

    private VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected String prod;
    protected String data;
    protected double price;
    public Purchase(String prod , String data, double price) {
        this.prod = prod;
        this.data = data;
        this.price = price;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        var oldValue = this.prod;
        this.prod = prod;
        propertyChangeSupport.firePropertyChange("prod", oldValue, prod);

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        var oldValue = this.data;
        this.data = data;
        propertyChangeSupport.firePropertyChange("data", oldValue, data);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws PropertyVetoException {
        double oldValue = this.price;
        vetoableChangeSupport.fireVetoableChange("price", oldValue, price);

        this.price = price;
        propertyChangeSupport.firePropertyChange("price", oldValue, price);
    }

    @Override
    public String toString() {
        return "Purchase [" +
                "prod=" + prod  +
                ", data=" + data +
                ", price=" + price +
                "]";
    }

    public void vetoChangeListner(VetoableChangeListener vetoableChangeListener) {
        vetoableChangeSupport.addVetoableChangeListener(vetoableChangeListener);
    }

    public void addChangeListner(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

}
