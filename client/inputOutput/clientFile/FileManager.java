package client.inputOutput.clientFile;

import another.exceptions.UncorrectedFileException;
import another.exceptions.UncorrectedNullException;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public interface FileManager {
    InputStreamReader getInputStreamForScript(String fileName) throws FileNotFoundException,
            UncorrectedNullException, UncorrectedFileException;
}
