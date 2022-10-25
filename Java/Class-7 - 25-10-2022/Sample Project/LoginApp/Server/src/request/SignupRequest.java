package request;

import java.io.Serializable;

public class SignupRequest extends AppRequest implements Serializable {

    private String registrationNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String registrationNumber, String firstName, String lastName, String email, String password) {
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.SIGNUP_REQUEST;
    }
}
