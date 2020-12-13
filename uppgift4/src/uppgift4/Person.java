package uppgift4;

import javafx.beans.property.SimpleStringProperty;

public class Person{
private final SimpleStringProperty firstName;
private final SimpleStringProperty lastName;
private final SimpleStringProperty age;

Person(String fName, String lName, String age) {
    this.firstName = new SimpleStringProperty(fName);
    this.lastName = new SimpleStringProperty(lName);
    this.age = new SimpleStringProperty(age);
}

public String getFirstName() {
    return firstName.get();
}

public void setFirstName(String fName) {
    firstName.set(fName);
}

public String getLastName() {
    return lastName.get();
}

public void setLastName(String fName) {
    lastName.set(fName);
}

public String getAge() {
    return age.get();
}

public void setAge(String fName) {
    age.set(fName);
}
}
 
