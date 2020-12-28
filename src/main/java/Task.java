import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task {
    private final int LINES_AMOUNT=100_000;
    private final String FILE_PATH= "D:/учеба/selfEducation/KP/demo/task_1/src/main/java/files/";

    public void createFile(int i) {
        String fileName = FILE_PATH + i;
        File file=new File(fileName);
        Line newLine=new Line();
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int j=0; i<LINES_AMOUNT;i++) {
                newLine.newValues();
                fileWriter.write(newLine.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
