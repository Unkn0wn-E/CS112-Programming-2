import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class MergeFile {
    static ArrayList<String> names = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File mergeFile = new File("mergeFile.txt");

        addRandomName(file1, 5);
        addRandomName(file2, 5);
        checkDup(names);

        try (PrintWriter pw = new PrintWriter(mergeFile)) {

            for (String i : names) {
                pw.write(i + "\n");
            }
            pw.close();

        }

    }

    public static void addRandomName(File file, int nameNum) throws Exception {
        String ch = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();

        try (PrintWriter pw = new PrintWriter(file)) {

            for (int i = 0; i < nameNum; i++) {
                int length = new Random().nextInt(5) + 5;

                for (int j = 0; j < length; j++) {
                    if (j == 0)
                        result.append(String.valueOf(ch.charAt(new Random().nextInt(ch.length()))).toUpperCase());
                    result.append(ch.charAt(new Random().nextInt(ch.length())));
                }

                pw.write(result.toString() + "\n");
                names.add(result.toString());

                result.setLength(0);
            }

            pw.close();

        }
    }

    public static void checkDup(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (j == i)
                    continue;
                if (arr.get(i).equals(arr.get(j))) {
                    arr.remove(j);
                }
            }
        }
    }

}