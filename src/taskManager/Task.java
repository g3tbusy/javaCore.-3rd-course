package taskManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private final String title;
    private final String text;
    private final Date date;

    public Task(String title, String text, Date date)
    {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }

    @Override
    public String toString()
    {
        return "Заголовок: " + title + "\n" +
                "Текст: " + text + "\n" +
                "Дата: " + dateFormat.format(date);
    }
}