import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SimpleBrowser extends JFrame {
    private JEditorPane editorPane;
    private JTextField urlField;

    public SimpleBrowser() {
        setTitle("Toty WebBrowser");

        // تنظیم آیکون برای فریم اصلی
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\toty.png");
        setIconImage(icon);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.DARK_GRAY);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        urlField = new JTextField(50);
        JButton goButton = new JButton("Search");
        JButton ABButton = new JButton("About Me");

        panel.add(urlField);
        panel.add(goButton);
        panel.add(ABButton);
        add(panel, BorderLayout.NORTH);

        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setBackground(Color.DARK_GRAY);
        add(scrollPane, BorderLayout.CENTER);

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPage(urlField.getText());
            }
        });

        // اصلاح شده
        ABButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SimpleBrowser.this, "Hi im danial and this app Developed By Me Workwith this app and Enjoy It");
            }
        });
    }

    private void loadPage(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            if (url.startsWith("www.")) {
                url = "http://" + url;
            } else {
                url = "http://www." + url;
            }
        }

        try {
            editorPane.setPage(new URL(url));
            editorPane.setBackground(Color.DARK_GRAY);
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
