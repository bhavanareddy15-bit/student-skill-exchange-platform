import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class StudentSkillExchange extends JFrame {

    private final String DATA_FILE = "data/students.txt";
    private final String REQUEST_FILE = "data/requests.txt";

    public StudentSkillExchange() {
        setTitle("Student Skill Exchange Platform");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel(
            "Student Skill Exchange Platform",
            SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JButton registerButton = new JButton("Register Student");
        JButton skillsButton = new JButton("View Skills");
        JButton searchButton = new JButton("Find Students");
        JButton requestButton = new JButton("Exchange Requests");

        JPanel panel = new JPanel(new GridLayout(4, 1, 15, 15));
        panel.setBorder(
            BorderFactory.createEmptyBorder(30, 100, 30, 100)
        );

        panel.add(registerButton);
        panel.add(skillsButton);
        panel.add(searchButton);
        panel.add(requestButton);

        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        registerButton.addActionListener(e -> registerStudent());
        skillsButton.addActionListener(e -> viewSkills());
        searchButton.addActionListener(e -> findStudents());
        requestButton.addActionListener(e -> exchangeRequests());
    }

    // Register Student
    private void registerStudent() {
        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JTextField department = new JTextField();
        JTextField year = new JTextField();
        JTextField teach = new JTextField();
        JTextField learn = new JTextField();

        Object[] fields = {
            "Student Name:", name,
            "Email:", email,
            "Department:", department,
            "Year of Study:", year,
            "Skills to Teach:", teach,
            "Skills to Learn:", learn
        };

        int result = JOptionPane.showConfirmDialog(
            this, fields, "Student Registration",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result != JOptionPane.OK_OPTION) return;

        String[] values = {
            name.getText().trim(),
            email.getText().trim(),
            department.getText().trim(),
            year.getText().trim(),
            teach.getText().trim(),
            learn.getText().trim()
        };

        for (String value : values) {
            if (value.isEmpty() || value.contains("|")) {
                JOptionPane.showMessageDialog(this,
                    "Fill all fields. Do not use | in any field.");
                return;
            }
        }

        if (!values[1].contains("@")) {
            JOptionPane.showMessageDialog(this,
                "Enter a valid email address.");
            return;
        }

        try {
            File folder = new File("data");
            if (!folder.exists()) folder.mkdirs();

            try (PrintWriter out = new PrintWriter(
                    new FileWriter(DATA_FILE, true))) {
                out.println(String.join("|", values));
            }

            JOptionPane.showMessageDialog(this,
                "Student registered successfully!");

        } catch (IOException ex) {
            showError(ex);
        }
    }

    // Load Students
    private DefaultTableModel loadStudents(String query) {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Name", "Department", "Teach", "Learn"}, 0
        );

        File file = new File(DATA_FILE);
        if (!file.exists()) return model;

        try (BufferedReader br = new BufferedReader(
                new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 6) {
                    boolean matches = query.isEmpty();

                    for (String field : data) {
                        if (field.toLowerCase().contains(query)) {
                            matches = true;
                            break;
                        }
                    }

                    if (matches) {
                        model.addRow(new Object[]{
                            data[0], data[2], data[4], data[5]
                        });
                    }
                }
            }

        } catch (IOException ex) {
            showError(ex);
        }

        return model;
    }

    // Display Table
    private void showTable(DefaultTableModel model, String heading) {
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                "No records found.");
            return;
        }

        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(550, 220));

        JOptionPane.showMessageDialog(this, scroll, heading,
            JOptionPane.PLAIN_MESSAGE);
    }

    // View Skills
    private void viewSkills() {
        showTable(loadStudents(""), "Registered Student Skills");
    }

    // Find Students
    private void findStudents() {
        String input = JOptionPane.showInputDialog(this,
            "Enter name, department, or skill to search:");

        if (input == null) return;

        String query = input.trim().toLowerCase();

        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Enter a search term.");
            return;
        }

        showTable(loadStudents(query), "Search Results");
    }

    // Exchange Requests Menu
    private void exchangeRequests() {
        String[] options = {
            "Create Request", "View Requests", "Cancel"
        };

        int choice = JOptionPane.showOptionDialog(
            this, "Choose an action:", "Exchange Requests",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]
        );

        if (choice == 0) createRequest();
        else if (choice == 1) viewRequests();
    }

    // Create Exchange Request
    private void createRequest() {
        JTextField sender = new JTextField();
        JTextField receiver = new JTextField();
        JTextField offered = new JTextField();
        JTextField wanted = new JTextField();

        Object[] fields = {
            "Your Name:", sender,
            "Student Name to Exchange With:", receiver,
            "Skill You Offer:", offered,
            "Skill You Want to Learn:", wanted
        };

        int result = JOptionPane.showConfirmDialog(
            this, fields, "Create Exchange Request",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (result != JOptionPane.OK_OPTION) return;

        String[] values = {
            sender.getText().trim(),
            receiver.getText().trim(),
            offered.getText().trim(),
            wanted.getText().trim()
        };

        for (String value : values) {
            if (value.isEmpty() || value.contains("|")) {
                JOptionPane.showMessageDialog(this,
                    "Fill all fields. Do not use | in any field.");
                return;
            }
        }

        if (values[0].equalsIgnoreCase(values[1])) {
            JOptionPane.showMessageDialog(this,
                "You cannot request an exchange with yourself.");
            return;
        }

        try {
            File folder = new File("data");
            if (!folder.exists()) folder.mkdirs();

            try (PrintWriter out = new PrintWriter(
                    new FileWriter(REQUEST_FILE, true))) {
                out.println(String.join("|", values) + "|Pending");
            }

            JOptionPane.showMessageDialog(this,
                "Exchange request saved successfully!");

        } catch (IOException ex) {
            showError(ex);
        }
    }

    // View Exchange Requests
    private void viewRequests() {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"From", "To", "Offered", "Wanted", "Status"}, 0
        );

        File file = new File(REQUEST_FILE);

        if (!file.exists()) {
            JOptionPane.showMessageDialog(this,
                "No exchange requests found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 5) {
                    model.addRow(data);
                }
            }

        } catch (IOException ex) {
            showError(ex);
            return;
        }

        showTable(model, "Saved Exchange Requests");
    }

    // Error Handling
    private void showError(Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error: " + ex.getMessage(),
            "File Error", JOptionPane.ERROR_MESSAGE);
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new StudentSkillExchange().setVisible(true)
        );
    }
}