package my.project.app.requesthandler.databaseobjects.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

// Applied at the class level to indicate this class is a candidate for mapping to the database.
// You can specify the name of the collection where the data will be stored.
@Document(collection = "users")
public class User {

    //Applied at the field level to mark the field used for identity purpose.
    @Id
    private String id;

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    public User(final String firstName,
                final String lastName,
                final String email,
                final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.userId = UUID.randomUUID().toString();

    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
