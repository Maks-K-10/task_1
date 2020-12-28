public class Main {
    public static void main(String[] args) {

        Task task=new Task();
        for (int i=0; i<100; i++) {
            task.createFile(i);
        }


    }
}
