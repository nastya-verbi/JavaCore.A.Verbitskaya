package lesson7.Homework7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class WeatherResponse {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Введите название города: ");
                String city = scanner.nextLine();

                System.out.println("Введите 1 для получения прогноза погоды на 1 день;\n" +
                        "2 для прогноза погоды на 5 дней;\n" +
                        "3 для получения всех данных на сегодня из базы;\n" +
                        "4 для получения всех данных из базы на 5 дней;\n" +
                        "Для выхода введите 0.");
                String command = scanner.nextLine();
                if (command.equals("0")) break;
                controller.getWeather(command, city);

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных. Попробуйте ещё раз!");
            }
            catch (NullPointerException e) {
                System.out.println("Несуществующий параметр. Попробуйте ещё раз!");
            }
        }
    }
}
