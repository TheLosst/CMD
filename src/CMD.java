import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CMD{
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        String ls = args[0];
        switch (args[0]){
            case "ls":

                String[] pathnames;
                String path = in.next();

                File f = new File(path);
                pathnames = f.list();

                for (String pathname : pathnames) {
                    System.out.println(pathname);
                }
                break;

            case "pwd":
                final String dir = System.getProperty("user.dir");
                System.out.println(dir);
                break;

            case "cat":
                String fileName = in.next();
                String content = Files.lines(Paths.get(fileName)).reduce("", String::concat);
                System.out.println(content);
                break;

            case "cd":
                String setNameDir = in.next();
                String setNameFile = in.next();
                File pa = new File(setNameDir, setNameFile);
                System.out.println(pa);
        }
    }
}
