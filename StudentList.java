import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StudentList {
    public static String getLineFromFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
        String line = bufferedReader.readLine();
        return line;
    }

    public static BufferedWriter getFileBufferedWriter() throws Exception {
        return new BufferedWriter(new FileWriter("students.txt", true));
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Invalid number of arguments");
            return;
        }

//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                String words[] = getLineFromFile().split(", ");
                for (String word : words) {
                    System.out.println(word);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                String words[] = getLineFromFile().split(", ");
                Random random = new Random();
                int wordIndex = random.nextInt(words.length);
                System.out.println(words[wordIndex]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = getFileBufferedWriter();
                String wordToAdd = args[0].substring(1);
                Date date = new Date();
                String dateFormatString = "dd-mm-yyyy hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
                String formattedDate = dateFormat.format(date);
                bufferedWriter.write(", " + wordToAdd + "\nList last updated on " + formattedDate);
                bufferedWriter.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String words[] = getLineFromFile().split(", ");
                boolean done = false;
                String wordToSearch = args[0].substring(1);
                for (int index = 0; index < words.length && !done; index++) {
                    if (words[index].equals(wordToSearch)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                char charArray[] = getLineFromFile().toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : charArray) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
    }
}