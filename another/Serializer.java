package another;

import java.io.IOException;
import java.io.Serializable;

public interface Serializer<T> {
    byte[] serialize(T type) throws IOException;
}
