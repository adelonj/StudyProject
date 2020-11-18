package algorithms;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Contact {
    private String lastName;
    private long phone;

    public Contact(String lastName, long phone) {
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhone() {
        return phone;
    }
}
