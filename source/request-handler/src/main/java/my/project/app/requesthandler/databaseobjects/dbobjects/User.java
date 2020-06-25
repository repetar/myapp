package my.project.app.requesthandler.databaseobjects.dbobjects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Applied at the class level to indicate this class is a candidate for mapping to the database.
// You can specify the name of the collection where the data will be stored.
@Document(collection = "users")
public class User {

    //Applied at the field level to mark the field used for identity purpose.
    @Id
    private ObjectId id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    public User() {

    }

    public User(final String firstName,
                final String lastName,
                final String phoneNumber,
                final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}