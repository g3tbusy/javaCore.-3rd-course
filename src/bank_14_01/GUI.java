package bank_14_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUI {
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Bank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel idLabel = new JLabel("Введите ID: ");
        JTextField idField = new JTextField();
        JButton loginButton = new JButton("Войти");

        JLabel greetingLabel = new JLabel("Добро пожаловать, ");
        JLabel balanceLabel = new JLabel("Ваш баланс: ");
        JLabel statusLabel = new JLabel("Ваш статус: ");

        JLabel greetingValue = new JLabel("Неизвестно");
        JLabel balanceValue = new JLabel("Неизвестно");
        JLabel statusValue = new JLabel("Неизвестно");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userId;
                try {
                    userId = Integer.parseInt(idField.getText());
                    showUserInfo(userId, greetingValue, balanceValue, statusValue);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Введите корректный ID клиента", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(loginButton);

        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new FlowLayout());
        userInfoPanel.add(greetingLabel);
        userInfoPanel.add(greetingValue);

        panel.add(userInfoPanel);
        panel.add(balanceLabel);
        panel.add(balanceValue);
        panel.add(statusLabel);
        panel.add(statusValue);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void showUserInfo(int userId, JLabel greetingValue, JLabel balanceValue, JLabel statusValue) {
        String query = "SELECT surname, name, patronymic, balance, status FROM Users WHERE user_id = ?";
        try (Connection conn = DB.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String surname = rs.getString("surname");
                String name = rs.getString("name");
                String patronymic = rs.getString("patronymic");
                double balance = rs.getDouble("balance");
                String status = rs.getString("status");

                greetingValue.setText(surname + " " + name + " " + patronymic);
                balanceValue.setText(String.format("%.2f₽", balance));
                statusValue.setText(status);
            } else {
                JOptionPane.showMessageDialog(null, "Клиент с таким ID не найден", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
