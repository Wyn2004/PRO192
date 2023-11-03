package Module;

import Util.Inputter;
import Util.Validation;
import java.util.Date;
import java.util.Objects;
import java.util.function.Predicate;

public class Vaccine implements Comparable<Vaccine> {

    private String name;
    private String code;
    private int quantity;
    private Date expirationDae;
    private double price;
    private Date lastInjectedDate;

    public Vaccine() {
    }

    public Vaccine(String name, String code, int quantity, Date expirationDae, double price, Date lastInjectedDate) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.expirationDae = expirationDae;
        this.price = price;
        this.lastInjectedDate = lastInjectedDate;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getExpirationDae() {
        return expirationDae;
    }

    public double getPrice() {
        return price;
    }

    public Date getLastInjectedDate() {
        return lastInjectedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpirationDae(Date expirationDae) {
        this.expirationDae = expirationDae;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLastInjectedDate(Date lastInjectedDate) {
        this.lastInjectedDate = lastInjectedDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vaccine other = (Vaccine) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.expirationDae, other.expirationDae)) {
            return false;
        }
        return Objects.equals(this.lastInjectedDate, other.lastInjectedDate);
    }

    @Override
    public String toString() {
        return "Vaccine{" + "name=" + name + ", code=" + code + ", quantity=" + quantity + ", expirationDae=" + Inputter.formatDate.format(expirationDae) + ", price=" + price + ", lastInjectedDate=" + Inputter.formatDate.format(lastInjectedDate) + '}';
    }

    @Override
    public int compareTo(Vaccine o) {
        return this.name.compareTo(o.getName());
    }

    public boolean test(Predicate<Vaccine> p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
