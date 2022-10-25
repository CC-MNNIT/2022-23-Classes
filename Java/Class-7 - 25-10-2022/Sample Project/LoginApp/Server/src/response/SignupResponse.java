package response;

import java.io.Serializable;

public class SignupResponse extends AppResponse implements Serializable {
    private String message;

    public SignupResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    ResponseType getResponseType() {
        return ResponseType.SIGNUP_RESPONSE;
    }
}
