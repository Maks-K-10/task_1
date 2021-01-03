import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    private static int mergedCounter = 0;
    private final int LINES_AMOUNT = 100_000;
    private final String FILE_PATH = "D:/учеба/selfEducation/KP/demo/task_1/src/main/java/files/";
    private final String MERGED_PATH = "D:/учеба/selfEducation/KP/demo/task_1/src/main/java/mergedFiles/";

    public void createFile(int i) {
        String fileName = FILE_PATH + i;
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(Stream
                    .generate(Line::newValues)
                    .limit(LINES_AMOUNT)
                    .collect(Collectors.joining("\n")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mergeFiles() {
        File file = new File(MERGED_PATH + mergedCounter);

        for (int i = 0; i < 100; i++) {
            File file1 = new File(FILE_PATH + i);

            try {
                String file1Str = FileUtils.readFileToString(file1) + "\n";

                FileUtils.write(file, file1Str, true); // true for append
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
