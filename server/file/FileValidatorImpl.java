package server.file;

import another.file.FileValidator;

import java.io.File;

/**
 * Класс, осуществляющий проверку файла и его имени
 */
public class FileValidatorImpl implements FileValidator {
    @Override
    public boolean validateFile(File file){
        if (file.exists() && file.canRead() && file.canWrite()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateFileName(String fileName){
        return fileName != null;
    }
}
