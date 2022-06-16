package za.ac.cput.Domain.Entities;

import java.util.Objects;
import javax.persistence.*;
import javax.persistence.Id;

/**
 * Matthew Jones
 * 220077681
 * Question 1
 */

@Entity(name = "Name")
public class Name
{
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String middleName;
    @Column(nullable = false)
    private String lastName;

    @Id
    @Column(nullable = false, unique = true)
    private String compositeId;

    public Name()
    {
        this.firstName = NameBuilder.firstName;
        this.lastName = NameBuilder.lastName;
        this.middleName = NameBuilder.middleName;

        this.compositeId = firstName + lastName;
    }

    public Name(NameBuilder builder)
    {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;

        this.compositeId = firstName + lastName;
    }

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middleName")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @Column(name = "compositeId")
    public String getCompositeId() {
        return compositeId;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Name name = (Name) obj;

        return Objects.equals(firstName, name.firstName)
                && Objects.equals(middleName, name.middleName)
                && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    public static class NameBuilder
    {
        public static String firstName;
        public static String middleName;
        public static String lastName;

        public NameBuilder() {

            if (this.firstName.equals(null)) {
                throw new IllegalArgumentException("First Name shouldn't be null.");
            }
            if (this.middleName.equals(null)) {
                throw new IllegalArgumentException("Middle Name shouldn't be null");
            }
            if (this.lastName.equals(null)) {
                throw new IllegalArgumentException("Last Name shouldn't be null.");
            }
        }

        public NameBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public NameBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public NameBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Name build()
        {
            return new Name(this);
        }
    }
}
