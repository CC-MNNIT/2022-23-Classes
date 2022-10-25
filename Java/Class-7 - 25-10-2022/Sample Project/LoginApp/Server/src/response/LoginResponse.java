package response;

import java.io.Serializable;

public class LoginResponse extends AppResponse implements Serializable {
    private final String firstName,lastName,emailID;
    private final String registrationNo;

    public LoginResponse(String firstName, String lastName, String emailID, String registrationNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.registrationNo = registrationNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    @Override
    ResponseType getResponseType() {
        return ResponseType.LOGIN_RESPONSE;
    }
}