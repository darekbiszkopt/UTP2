/**
 *
 *  @author Dajcz Dariusz S21522
 *
 */

package zad2;


import java.beans.PropertyVetoException;

public class Main {
  public static void main(String[] args) {
    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);
//
    purch.addChangeListner(evt -> System.out.println("Change value of: " + evt.getPropertyName() + " from: " + evt.getOldValue() + " to: " + evt.getNewValue()));

    purch.vetoChangeListner(evt -> {
      if((double)evt.getNewValue() <= 999)
        throw new PropertyVetoException("Price change to: " + evt.getNewValue() + " not allowed", evt);
    });
//
    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);

      purch.setPrice(500.00);

    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);

  }
}
