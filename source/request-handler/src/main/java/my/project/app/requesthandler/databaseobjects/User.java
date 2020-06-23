package my.project.app.requesthandler.databaseobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.BasicDBObject;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements  IDatabaseObject {

    BasicDBObject basicDBO = new BasicDBObject();

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("address")
    private String address;

    @ConstructorProperties({"userId",
            "firstName",
            "lastName",
            "phoneNumber",
            "address"})
    public User(final int userId,
                final String firstName,
                final String lastName,
                final String phoneNumber,
                final String address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User (BasicDBObject dbObject) {

        this.userId = dbObject.getInt("userId");
        this.firstName = dbObject.getString("firstName");
        this.lastName = dbObject.getString("lastName");
        this.phoneNumber = dbObject.getString("phoneNumber");
        this.address = dbObject.getString("address");
    }

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
        basicDBO.put("userId", this.getUserId());
        basicDBO.put("firstName", this.getFirstName());
        basicDBO.put("lastName", this.getLastName());
        basicDBO.put("phoneNumber", this.getPhoneNumber());
        basicDBO.put("address", this.getAddress());
        return basicDBO;
    }

}
