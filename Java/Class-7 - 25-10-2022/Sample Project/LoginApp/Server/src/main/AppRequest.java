package main;

import java.io.Serializable;

public abstract class AppRequest implements Serializable {
    abstract RequestType getRequestType();
}
