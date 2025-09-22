package hillel;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

  public String readFromFile(String path) {
    try (FileReader reader = new FileReader(path)) {
      int sym;
      StringBuilder stringBuilder = new StringBuilder();
      while ((sym = reader.read()) != -1) {
        stringBuilder.append((char) sym);
      }
      return stringBuilder.toString();
    } catch (IOException ex) {
      return ex.getMessage();
    }
  }
}
