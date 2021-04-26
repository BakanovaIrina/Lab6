package another.connection.request;

import java.io.Serializable;

public enum RequestType implements Serializable {
    INPUT_ELEMENT,
    EXECUTE_COMMAND,
    INPUT_LANGUAGE,
    END_OF_FILE;

    private static final long serialVersionUID = 1L;
}
