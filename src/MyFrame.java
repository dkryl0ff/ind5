import javax.swing.*;

class MyFrame extends JFrame {
    MyFrame() {
        setTitle("Фильтр автомобилей");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyPannel());
        setVisible(true);
    }
}
