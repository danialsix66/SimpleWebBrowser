import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SimpleBrowser extends JFrame {
    private JEditorPane editorPane;
    private JTextField urlField;

    public SimpleBrowser() {
        setTitle("Simple Browser");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ساخت پنل برای نوار آدرس
        JPanel panel = new JPanel();
        urlField = new JTextField(30);
        JButton goButton = new JButton("Go");

        panel.add(urlField);
        panel.add(goButton);
        add(panel, BorderLayout.NORTH);

        // ساخت JEditorPane برای نمایش صفحات وب
        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        add(scrollPane, BorderLayout.CENTER);

        // گوش دادن به دکمه
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPage(urlField.getText());
            }
        });
    }

    private void loadPage(String url) {
        try {
            editorPane.setPage(new URL(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading page: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleBrowser browser = new SimpleBrowser();
            browser.setVisible(true);
        });
    }
}
