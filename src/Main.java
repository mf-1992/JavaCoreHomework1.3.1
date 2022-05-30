import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File[] catalogs = {
                new File("G://Games/src"),
                new File("G://Games/src/main"),
                new File("G://Games/src/test"),
                new File("G://Games/res"),
                new File("G://Games/res/drawables"),
                new File("G://Games/res/vectors"),
                new File("G://Games/res/icons"),
                new File("G://Games/savegames"),
                new File("G://Games/temp")};
        File[] files = {
                new File("G://Games/src/main/Main.java"),
                new File("G://Games/src/main/Utils.java"),
                new File("G://Games/temp/temp.txt")};
        StringBuilder sb = new StringBuilder();
        for (File catalog : catalogs) {
            if (catalog.mkdir())
                sb.append("Каталог ").append(catalog.getName()).append(" создан");
            sb.append("\n");
        }
        for (File file : files) {
            try {
                if (file.createNewFile())
                    sb.append("Файл ").append(file.getName()).append(" создан");
                sb.append("\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        String text = sb.toString();
        try (FileWriter writer = new FileWriter("G://Games/temp/temp.txt")) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
