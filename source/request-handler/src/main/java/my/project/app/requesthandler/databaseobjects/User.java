package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.BasicDBObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements  IDatabaseObject {

    BasicDBObject basicDBO = new BasicDBObject();

    private int userId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BasicDBObject createDBObject() {
        basicDBO.put("firstName", this.getFirstName());
        basicDBO.put("lastName", this.getLastName());
        basicDBO.put("phoneNumber", this.getPhoneNumber());
        basicDBO.put("address", this.getAddress());
        return basicDBO;
    }

}
