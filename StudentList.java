import java.io.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class StudentList {

    public static String getLineFromFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.STUDENTS_FILE_NAME)));
        String line = bufferedReader.readLine();
        return line;
    }

    public static BufferedWriter getFileBufferedWriter() throws Exception {
        return new BufferedWriter(new FileWriter(Constants.STUDENTS_FILE_NAME, true));
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(Constants.MSG_INVALID_ARGUMENTS);
            return;
        }

//		Check arguments
        if (args[0].equals(Constants.ARG_LIST_DATA)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                for (String word : getLineFromFile().split(Constants.WORDS_SPLIT_REGEX)) {
                    System.out.println(word);
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        } else if (args[0].equals(Constants.ARG_SHOW_RANDOM_DATA)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                String words[] = getLineFromFile().split(Constants.WORDS_SPLIT_REGEX);
                int wordIndex = new Random().nextInt(words.length);
                System.out.println(words[wordIndex]);
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        } else if (args[0].contains(Constants.ARG_ADD_DATA)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                BufferedWriter bufferedWriter = getFileBufferedWriter();
                String formattedDate = new SimpleDateFormat(Constants.DATE_FORMAT_PATTERN).format(new Date());
                bufferedWriter.write(Constants.WORDS_SPLIT_REGEX + args[0].substring(1) + "\n" + Constants.MSG_DATA_UPDATED + " " + formattedDate);
                bufferedWriter.close();
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        } else if (args[0].contains(Constants.ARG_FIND_DATA)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                if (Arrays.asList(getLineFromFile().split(Constants.WORDS_SPLIT_REGEX)).contains(args[0].substring(1))) {
                    System.out.println(Constants.MSG_DATA_FOUND);
                } else {
                    System.out.println(Constants.MSG_DATA_NOT_FOUND);
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        } else if (args[0].contains(Constants.ARG_COUNT_WORDS)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                boolean in_word = false;
                int count = 0;
                for (char c : getLineFromFile().toCharArray()) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " " + Constants.MSG_WORDS_FOUND);
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        }
    }
}