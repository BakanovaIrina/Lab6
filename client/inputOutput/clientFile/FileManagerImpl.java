package client.inputOutput.clientFile;

import another.exceptions.UncorrectedFileException;
import another.exceptions.UncorrectedNullException;
import another.file.FileReader;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class FileManagerImpl implements FileManager {
    FileReader fileReader;

    public FileManagerImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public InputStreamReader getInputStreamForScript(String fileName) throws FileNotFoundException, UncorrectedNullException, UncorrectedFileException {
        return fileReader.openFile(fileName);
    }
}
