package FileSync.ServerData.DataTypes;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
@XmlAccessorType(XmlAccessType.NONE)
public class UserDT {

    @XmlElement
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    // Must have no-argument constructor
    public UserDT() {

    }

    public UserDT(String fname, String lname, int age, int id) {
        this.firstName = fname;
        this.lastName = lname;
        this.age = age;
        this.id = id;
    }

    public void setFirstName(String fname) {
        this.firstName = fname;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return new StringBuffer(" First Name : ").append(this.firstName)
                .append(" Last Name : ").append(this.lastName)
                .append(" Age : ").append(this.age).append(" ID : ")
                .append(this.id).toString();
    }

}