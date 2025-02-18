package loginPass;

import java.util.Scanner;

class LoginException extends RuntimeException
{
    public LoginException(String message)
    {
        super(message);
    }
}

class PasswordException extends RuntimeException
{
    public PasswordException(String message)
    {
        super(message);
    }
}

public class App
{
    public static void validate(String login, String password, String repeatPassword) throws LoginException, PasswordException
    {
        if (login.length() >= 15)
        {
            throw new LoginException("Логин должен быть меньше 15 символов.");
        }

        if (!login.matches("[A-Za-z0-9_]+"))
        {
            throw new LoginException("Логин может содержать только латинские буквы, цифры и символ подчеркивания.");
        }

        if (password.length() < 7 || password.length() > 20)
        {
            throw new PasswordException("Пароль должен быть от 7 до 20 символов.");
        }

        if (!password.matches("[A-Za-z0-9_]+"))
        {
            throw new PasswordException("Пароль может содержать только латинские буквы, цифры, символ подчеркивания и совпадать с подтвержденным паролем.");
        }

        if (!password.equals(repeatPassword))
        {
            throw new PasswordException("Пароли не совпадают.");
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = input.nextLine();

        System.out.print("Введите пароль: ");
        String password = input.nextLine();

        System.out.print("Повторите пароль: ");
        String repeatPassword = input.nextLine();

        try
        {
            validate(login, password, repeatPassword);
            System.out.println("Логин и пароль успешно сохранены.");
        }
        catch (LoginException | PasswordException e)
        {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
