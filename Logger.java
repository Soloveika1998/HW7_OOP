import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Logger {
  
  /**
   * Функция производит запись лога в файл
   * @param arr Лог для записи в файл
   * @param path путь к файлу 
   * @throws IOException
   */
  public static void writeFile(LinkedList<String> arr, String path) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
    for (String strings : arr) {
      writer.write(strings + "\n");
    }
    writer.close();
  }

}