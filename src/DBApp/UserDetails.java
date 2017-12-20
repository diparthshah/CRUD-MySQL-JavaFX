package DBApp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserDetails {

    private final StringProperty name;
    private final StringProperty age;
    private final StringProperty email;

    //Default constructor
    public UserDetails(String name, String age, String email) {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
        this.email = new SimpleStringProperty(email);
    }

    //Getters
    public String getName() {
        return name.get();
    }

    public String getAge() {
        return age.get();
    }


    public String getEmail() {
        return email.get();
    }

    //Setters
    public void setName(String value) {
        name.set(value);
    }

    public void setAge(String value) {
        age.set(value);
    }

    public void setEmail(String value) {
        email.set(value);
    }

    //Property values
    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty departmentProperty() {
        return age;
    }

    public StringProperty emailProperty() {
        return email;
    }
}