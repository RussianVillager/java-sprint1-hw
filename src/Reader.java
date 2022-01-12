import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {

    String readMonthlyFilesContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    String readYearlyFileContentsOrNull() {
        try {
            return Files.readString(Path.of("resources/y.2021.csv"));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
