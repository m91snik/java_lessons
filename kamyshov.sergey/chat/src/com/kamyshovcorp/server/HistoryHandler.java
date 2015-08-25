package com.kamyshovcorp.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kamyshov.sergey on 21.08.15.
 */
public class HistoryHandler {

    private static final String FILE_HISTORY = "chat_history.txt";
    private static final int DEFAULT_HISTORY_SIZE = 5;

    public static void writeHistory(String message) {
        Path src = Paths.get(FILE_HISTORY);
        try {
            Files.write(src, Arrays.asList(message), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл " + FILE_HISTORY);
            e.printStackTrace();
        }
    }

    public static String readHistory() {
        Path src = Paths.get(FILE_HISTORY);
        List<String> historyLines = null;
        try {
            historyLines = Files.readAllLines(src);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла " + FILE_HISTORY);
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        // Получаем последние несколько сообщений, кол-во которых задается константой
        for (int i = historyLines.size() - DEFAULT_HISTORY_SIZE; i < historyLines.size(); i++) {
            if (i != historyLines.size() - 1) {
                stringBuilder.append(historyLines.get(i) + "\n");
            } else {
                stringBuilder.append(historyLines.get(i));
            }
        }
        return stringBuilder.toString();
    }
}
