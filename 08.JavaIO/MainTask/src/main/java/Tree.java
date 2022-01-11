import exceptions.FileNotFoundException;
import utils.Reader;
import utils.Writer;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Tree {

    public static void tree(String path, String outputFile, String separator, boolean isLast){
        if(!path.equals(outputFile)) {
            try {
                File file = new File(path);
                File[] files = file.listFiles();
                int countDir = (int) Arrays.stream(files).filter(File::isDirectory).count();
                int countFile = (int) Arrays.stream(files).filter(File::isFile).count();

                Writer.writeToFile(outputFile, true, separator + "--" + file.getName());

                if (isLast) {
                    separator = new StringBuilder(separator).replace(separator.length() - 1, separator.length(), " ").toString();
                }
                if (countDir != 0) { // если есть подкаталоги, то сдвигаем вправо
                    separator += "  |";
                } else if (countFile != 0) {
                    separator += "   ";
                }
                for (File eachFile : files) {
                    if (eachFile.isFile()) {
                        Writer.writeToFile(outputFile, true, separator + "  " + eachFile.getName());
                    }
                }
                int dirNumber = 0;
                for (File eachFile : files) {
                    if (eachFile.isDirectory()) {
                        dirNumber++;
                        tree(eachFile.getAbsolutePath(), outputFile, separator, dirNumber == countDir);
                    }
                }
            }
            catch (NullPointerException e){
                throw new FileNotFoundException("Incorrect path");
            }
        }
        else {
            List<String> fileLines = Reader.readFromFile(outputFile);

            if (fileLines.size() != 0) {

                int dirCount = (int) (fileLines.stream().filter(o1 -> o1.contains("|--")).count() + 1);
                int filesCount = (int) (fileLines.stream().filter(o1 -> !o1.contains("|--")).count() - 1);

                BigDecimal averageCount = (BigDecimal.valueOf((double) filesCount / (double) dirCount))
                        .setScale(2, RoundingMode.HALF_UP);
                BigDecimal averageFilesNames = null;

                Optional<Integer> commonFileNamesLength = fileLines.stream().filter(o1 -> !o1.contains("|--")).map(o1 -> {
                    while (o1.charAt(0) == ' ' || o1.charAt(0) == '|') {
                        o1 = new StringBuilder(o1).replace(0, 1, "").toString();
                    }
                    return o1.length();
                }).reduce(Integer::sum);

                if (commonFileNamesLength.isPresent()) {
                    averageFilesNames = BigDecimal.valueOf(((double) commonFileNamesLength.get() - fileLines.get(0).length()) / (double) filesCount)
                            .setScale(2, RoundingMode.HALF_UP);
                }

                System.out.println("Folders count: " + dirCount);
                System.out.println("Files count: " + filesCount);
                System.out.println("Average count of files in directory: " + averageCount);
                System.out.println("Average name length of files: " + averageFilesNames);
            }
            else {
                System.out.println("File is empty!");
            }
        }
    }
}
