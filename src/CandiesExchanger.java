import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Aleksei 23.03.16
 */
public class CandiesExchanger {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int candyCount = readCandyCount();
        int wrappersForCandy = readWrappersForCandy();

        if (candyCount <=0){
            System.out.println("Недопустимое число! Количество конфет должно быть > 0");
            return;
        }

        if (wrappersForCandy <= 0) {
            System.out.println("Недопустимое число! Количество конфет за 1 фантик должно быть > 0");
            return;
        }
        if (wrappersForCandy == 1) {
            System.out.println("Вы получаете бесконечное количество конфет!");
            return;
        }

        System.out.println("Количество обменянных конфет:" + exchange(candyCount, wrappersForCandy));
    }

    /**
     * @param wrappersCount    количество фантиков
     * @param wrappersForCandy количество фантиков за конфету
     * @return
     */
    private static int exchange(int wrappersCount, int wrappersForCandy) {
        int candyCount = wrappersCount / wrappersForCandy;
        int residueWrappers = wrappersCount % wrappersForCandy;
        if (candyCount > 0)
            return candyCount + exchange(candyCount + residueWrappers, wrappersForCandy);
        else
            return 0;
    }

    private static int readCandyCount() throws IOException {
        System.out.print("Введите количество конфет: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Не удалось распарсить введенную строку! Убедитесь что введенное количетсов конфет является числом!!!");
        }
    }

    private static int readWrappersForCandy() throws IOException {
        System.out.print("Введите количество фантиков за 1 конфету: ");
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Не удалось распарсить введенную строку! Убедитесь что введенное количество конфет за фантик является числом!!!");
        }
    }
}