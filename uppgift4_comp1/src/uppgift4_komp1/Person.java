package uppgift4_komp1;

import java.io.Serializable;

public class Person implements Serializable {

private static final long serialVersionUID = 2L;
String   firstName;
String   lastName;
String  age;

public Person() {
    
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String fName) {
    this.firstName=fName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lName) {
    this.lastName=lName;
}

public String getAge() {
    return age;
}

public void setAge(String age) {
    this.age=age;
}
}
 
