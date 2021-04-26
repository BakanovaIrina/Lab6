package another;

import java.io.IOException;

public interface Deserializer<T> {
    T deserialize(byte[] bytes) throws IOException, ClassNotFoundException;
}
