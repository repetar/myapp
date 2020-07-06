package my.project.app.requesthandler.databaseobjects.user;

import my.project.app.requesthandler.utils.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

// Applied at the class level to indicate this class is a candidate for mapping to the database.
// You can specify the name of the collection where the data will be stored.
@Document(collection = Constants.USER_COLLECTION)
public class User {

    //Applied at the field level to mark the field used for identity purpose.
    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Indexed(unique=true)
    private String email;

    private String address;

    private String password;

    // needed for POST and deserializing json info
    public User() {
    }

    public User(final String firstName,
                final String lastName,
                final String email,
                final String address,
                final String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
