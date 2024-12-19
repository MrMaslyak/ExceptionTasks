import Exception.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.println("**************************************");
        devide(10, 0);
        devide(10, 2);
        System.out.println("**************************************");
        parseInput("123");
        parseInput("abc");
        System.out.println("**************************************");
        register(22);
        register(15);
        System.out.println("**************************************");
        readFile("file.txt");
        readFile("file.docx");
        System.out.println("**************************************");
        multipleException(10, 0);
        multipleException(10, 2);
        System.out.println("**************************************");
        processFile("file.txt");
        processFile("file.docx");
        System.out.println("**************************************");
        calculateSquareRoot(-4);
        calculateSquareRoot(16);
        System.out.println("**************************************");
        validateEmail("user@example.com");
        validateEmail("invalid.email");
        System.out.println("**************************************");
        validateEmailLogging("user@example.com");
        validateEmailLogging("invalid.email");
        System.out.println("**************************************");
        complexOperation();


    }

    public static void devide(int a, int b) {
        try {
            int c = a / b;
            System.out.println("Результат деления " + c);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль невозможно");
        }
    }

    public static void parseInput(String input) {
        try {
            int number = Integer.parseInt(input);
            if (input.isEmpty()){
                throw new NumberFormatException();
            }
            System.out.println("Вы ввели число " + number);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число или строка пуста");
        }
    }

    public static void register(int age) {
        try {
            if (age < 18) {
                throw new InvalidAgeException("Вам нет 18 лет");
            } else if (age > 100) {
                throw new InvalidAgeException("Некоректный возраст");
            } else {
                System.out.println("Регистрация прошла успешно");
            }
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        try {
            if (!fileName.endsWith(".txt")) {
                throw new InvalidFileException("Неверное расширение файла");
            } else {
                System.out.println("Файл успешно прочитан");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void multipleException(int a, int b) {
        try {
            int c = a / b;
            System.out.println("Результат деления " + c);
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль невозможно");
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод");
        }
    }

    public static void processFile(String fileName) {
        try {
            if (fileName.endsWith(".txt")) {
                System.out.println("Открытие файла");
                System.out.println("Чтение файла...");
            } else {
                throw new InvalidFileException("Неверное расширение файла");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Закрытие файла");
        }
    }

    public static void calculateSquareRoot(double number){
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Невозможно вычислить квадратный корень отрицательного числа");
            }
            double result = Math.sqrt(number);
            System.out.println("Квадратный корень числа " + number + " равен " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateEmail(String email){
        try {
            if (!email.contains("@")) {
                throw new InvalidEmailException("Неверный формат email");
            }
            System.out.println("Email валиден");
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateEmailLogging(String email){
        Logger logger = Logger.getLogger(Main.class.getName());
        try {
            if (!email.contains("@")) {
                logger.warning("Неверный формат email: " + email);
                throw new InvalidEmailException("Неверный формат email");
            }
            logger.info("Email валиден: " + email);
            System.out.println("Email валиден");
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
            logger.severe("Ошибка валидации email: " + e.getMessage());
            System.out.println("Ошибка валидации email: " + e.getMessage());
        }
    }

    public static void complexOperation(){
        try {
            readData();
            calculate();
            saveResults();
        } catch (IOException e) {
            System.out.println("Ошибка чтения данных: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычислений: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }

    public static void readData() throws IOException {
        System.out.println("Чтение данных...");
        throw new IOException("Ошибка чтения данных!");
    }


    public static void calculate() throws ArithmeticException {
        System.out.println("Выполнение вычислений...");
        throw new ArithmeticException("Деление на ноль в вычислениях!");
    }


    public static void saveResults() throws SQLException {
        System.out.println("Сохранение данных...");
        throw new SQLException("Ошибка сохранения данных в базу!");
    }

}