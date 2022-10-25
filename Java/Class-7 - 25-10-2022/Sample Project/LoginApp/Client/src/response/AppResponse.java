package response;

import java.io.Serializable;

public abstract class AppResponse implements Serializable {
    abstract ResponseType getResponseType();
}
