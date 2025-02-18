package bank_14_01;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Users
{
    public int userId;
    public String status; // basic, vip, premium

    public String surname; // фамилия
    public String name; // имя
    public String patronymic; // отчество

    public double balance;

    public Users(int userId, String status, String surname, String name, String patronymic, double balance)
    {
        this.userId = userId;
        this.status = status;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.balance = balance;
    }

    public static final List<Users> userList = Arrays.asList(
            new Users(1, "BASIC", "КАЛИНИН", "ИВАН", "ИЛЬИЧ", 10000),
            new Users(2, "BASIC", "ФАДЕЕВ", "ТИМОФЕЙ", "ДМИТРИЕВИЧ", 7240),
            new Users(3, "BASIC", "КУЗНЕЦОВА", "ЕЛИЗАВЕТА", "ВАСИЛЬЕВА", 8734),
            new Users(4, "BASIC", "КУЗИН", "МАТВЕЙ", "ВИКТОРОВИЧ", 93273),
            new Users(5, "BASIC", "ИВАНОВА", "АЛЕКСАНДРА", "ПАВЛОВНА", 3341),
            new Users(6, "VIP", "ИСАЕВ", "НИКИТА", "НИКОЛАЕВИЧ", 987304),
            new Users(7, "VIP", "КРЮКОВ", "ДАНИЭЛЬ", "ТИМОФЕЕВИЧ", 4872478),
            new Users(8, "VIP", "ХАРИТОНОВА", "АДЕЛЯ", "ДАНИИЛОВНА", 37623),
            new Users(9, "VIP", "ВОРОНИНА", "ПОЛИНА", "ПАВЛОВНА", 874378),
            new Users(10, "VIP", "ТИТОВА", "АЛЕКСАНДРА", "ИВАНОВНА", 39463),
            new Users(11, "PREMIUM", "КИСЕЛЕВ", "АЛЕКСАНДР", "НИКОЛАЕВИЧ", 235),
            new Users(12, "PREMIUM", "ТУМАНОВА", "АЛЕКСАНДРА", "РУСЛАНОВНА", 4763484),
            new Users(13, "PREMIUM", "ФЕДОРОВА", "МАРИНА", "МИРОНОВНА", 453421),
            new Users(14, "PREMIUM", "ВОЛОШИНА", "ВАЛЕРИЯ", "МАКСИМОВНА", 987436),
            new Users(15, "PREMIUM", "КОММИСАРОВА", "СОФЬЯ", "СЕРГЕЕВНА", 4897378)
    );

    public int getUserId() { return userId; }
    public String getStatus() { return status; }
    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getPatronymic() { return patronymic; }
    public double getBalance() { return balance; }
}