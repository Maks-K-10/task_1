import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;
import java.util.StringJoiner;

public class Line {
    //метод для задания значений подходящих под требования
    public static String newValues() {
        //случайная дата за последние 5 лет
        LocalDate date;

        //случайный набор 10 латинских символов
        String latin;

        //случайный набор 10 русских символов
        String cyrillic;

        //случайное положительное четное целочисленное число в диапазоне от 1 до 100 000 000
        int positiveEven=0;

        //случайное положительное число с 8 знаками после запятой в диапазоне от 1 до 20
        double even;

        //генерация случайной даты в диапазоне 5 лет
        Random random = new Random();
        int minDay = (int) LocalDate.of(2016, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2021, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        //присвоение этого значения
        date = LocalDate.ofEpochDay(randomDay);

        //Создание и присвоение значения для строки из 10 случайных латинских символов
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        latin = sb.toString();

        //Создание и присвоение значения для строки из 10 случайных кириллических символов
        char[] chars2 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
        StringBuilder sb2 = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            char c = chars2[random.nextInt(chars2.length)];
            sb2.append(c);
        }
        cyrillic = sb2.toString();

        //создание и присвоение значения для случайного положительного четного целочисленного числа в диапазоне от 1 до 100 000 000
        boolean key = true;
        while (key) {
            int k = 1 + random.nextInt(100_000_000);
            if (k % 2 == 0) {
                positiveEven = k;
                key = false;
            }
        }

        //создание и присвоение значения для случайного положительного числа с 8 знаками после запятой в диапазоне от 1 до 20
        String formattedDouble = new DecimalFormat("#0.00000000").format((1 + random.nextInt(19_00_000_000) / (double) 100_000_000));
        even = Double.parseDouble(formattedDouble.replace(",", "."));

        return new StringJoiner("||", "","||")
                .add(date.toString())
                .add(latin).add(cyrillic)
                .add(String.valueOf(positiveEven))
                .add(String.valueOf(even))
                .toString();
    }


}
