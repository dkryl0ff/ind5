import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyPannel extends JPanel {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField f1, f2, f3, f4, f5, f6, f7, f8;
    JTextArea t1;
    Autopark autopark = new Autopark();
    JButton addButton, filterButton;

    MyPannel() {
        // Поля ввода для добавления автомобиля
        l1 = new JLabel("Марка");
        add(l1);
        f1 = new JTextField(20);
        add(f1);

        l2 = new JLabel("Номер");
        add(l2);
        f2 = new JTextField(20);
        add(f2);

        l3 = new JLabel("Пробег");
        add(l3);
        f3 = new JTextField(20);
        add(f3);

        l4 = new JLabel("Стоимость");
        add(l4);
        f4 = new JTextField(20);
        add(f4);

        l5 = new JLabel("Год");
        add(l5);
        f5 = new JTextField(20);
        add(f5);

        l6 = new JLabel("Объём двигателя");
        add(l6);
        f6 = new JTextField(20);
        add(f6);

        // Поля для диапазона фильтрации
        l7 = new JLabel("Мин. объём");
        add(l7);
        f7 = new JTextField(10);
        add(f7);

        l8 = new JLabel("Макс. объём");
        add(l8);
        f8 = new JTextField(10);
        add(f8);

        // Кнопки
        addButton = new JButton("Добавить автомобиль");
        addButton.addActionListener(new AddAutoListener());
        add(addButton);

        filterButton = new JButton("Фильтровать");
        filterButton.addActionListener(new FilterListener());
        add(filterButton);

        // Поле для вывода
        t1 = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(t1);
        add(scrollPane);
    }

    private class AddAutoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String mark = f1.getText();
                String number = f2.getText();
                double probeg = Double.parseDouble(f3.getText());
                double cost = Double.parseDouble(f4.getText());
                int year = Integer.parseInt(f5.getText());
                double volume = Double.parseDouble(f6.getText());

                Auto auto = new Auto(number, mark, probeg, cost, year, volume);
                autopark.addAuto(auto);
                t1.append("Добавлено: " + auto.print());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка ввода! Проверьте корректность данных.");
            }
        }
    }

    private class FilterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double minVolume = Double.parseDouble(f7.getText());
                double maxVolume = Double.parseDouble(f8.getText());
                String filtered = autopark.filterAutos(minVolume, maxVolume);
                t1.setText("Отфильтрованные автомобили:\n" + filtered);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка ввода диапазона объёма!");
            }
        }
    }
}
