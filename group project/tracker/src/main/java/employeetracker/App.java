package employeetracker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class App extends JFrame {
    private DefaultTableModel employeeModel, attendanceModel;
    private JTable employeeTable, attendanceTable;
    private JTextField firstNameField, lastNameField, departmentField, positionField;
    private JTextField dateField, timeInField, timeOutField;
    private JButton addEmployeeButton, updateEmployeeButton, deleteEmployeeButton;
    private JTabbedPane tabbedPane;

    private App() {
        super("Employee Tracking System");

        // Employee table model and table
        String[] employeeColumnNames = { "Employee ID", "First Name", "Last Name", "Department", "Position" };
        employeeModel = new DefaultTableModel(employeeColumnNames, 0);
        employeeTable = new JTable(employeeModel);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only single selection

        // Attendance table model and table
        String[] attendanceColumnNames = { "Employee ID", "Name", "Date", "Time In", "Time Out", "Hours" };
        attendanceModel = new DefaultTableModel(attendanceColumnNames, 0);
        attendanceTable = new JTable(attendanceModel);

        // Input fields
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        departmentField = new JTextField(10);
        positionField = new JTextField(10);

        // Input fields for attendance details
        dateField = new JTextField(10);
        timeInField = new JTextField(10);
        timeOutField = new JTextField(10);

        // Buttons
        addEmployeeButton = new JButton("Add Employee");
        updateEmployeeButton = new JButton("Update Employee");
        deleteEmployeeButton = new JButton("Delete Employee");
        JButton recordAttendanceButton = new JButton("Record Attendance");

        /**
         * creting the tabs
         */
        // Setup employee panel
        JPanel employeePanel = setupEmployeePanel(addEmployeeButton, updateEmployeeButton, deleteEmployeeButton);

        // Setup attendance panel
        JPanel attendancePanel = setupAttendancePanel(recordAttendanceButton);

        // Tabbed Pane
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Employee Management", employeePanel);
        tabbedPane.addTab("Attendance Tracking", attendancePanel);

        // Add components to frame
        this.setLayout(new BorderLayout());
        this.add(tabbedPane, BorderLayout.CENTER);

        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    /**
     * setupEmployeePanel is a function that listens to the clicking of employee
     * record buttons
     * it returns a pannel for adding and displaying employees
     */
    private JPanel setupEmployeePanel(JButton addEmployeeButton, JButton updateEmployeeButton,
            JButton deleteEmployeeButton) {
        JPanel panel = new JPanel();
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Department:"));
        panel.add(departmentField);
        panel.add(new JLabel("Position:"));
        panel.add(positionField);
        panel.add(addEmployeeButton);
        panel.add(updateEmployeeButton);
        panel.add(deleteEmployeeButton);
        panel.add(new JScrollPane(employeeTable));

        addEmployeeButton.addActionListener(e -> addEmployee());
        updateEmployeeButton.addActionListener(e -> updateEmployee());
        deleteEmployeeButton.addActionListener(e -> deleteEmployee());

        return panel;
    }

    /**
     * setupAttendancePanel is a function that listens to the clicking of attendance
     * record button
     * it returns a pannel for recording employee attendance
     */
    private JPanel setupAttendancePanel(JButton recordAttendanceButton) {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);
        panel.add(new JLabel("Time In (HH:MM):"));
        panel.add(timeInField);
        panel.add(new JLabel("Time Out (HH:MM):"));
        panel.add(timeOutField);
        panel.add(recordAttendanceButton);
        panel.add(new JScrollPane(attendanceTable));

        recordAttendanceButton.addActionListener(e -> recordAttendance());

        return panel;
    }

    /**
     * add an employee
     */
    private void addEmployee() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String department = departmentField.getText();
        String position = positionField.getText();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !department.isEmpty() && !position.isEmpty()) {
            // Assuming employee_id is auto-incremented and handled by database or backend
            // logic
            employeeModel.addRow(
                    new Object[] { employeeModel.getRowCount() + 1, firstName, lastName, department, position });
            firstNameField.setText("");
            lastNameField.setText("");
            departmentField.setText("");
            positionField.setText("");
        }

    }

    /**
     * update employee records
     *
     */
    private void updateEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow >= 0) {
            employeeModel.setValueAt(firstNameField.getText(), selectedRow, 1);
            employeeModel.setValueAt(lastNameField.getText(), selectedRow, 2);
            employeeModel.setValueAt(departmentField.getText(), selectedRow, 3);
            employeeModel.setValueAt(positionField.getText(), selectedRow, 4);
        }
    }

    /**
     * delete employee records
     *
     */
    private void deleteEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow >= 0) {
            employeeModel.removeRow(selectedRow);
        }
    }

    /**
     * update employee records
     *
     */
    private void recordAttendance() {
        // Get selected employee
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "No employee selected", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get employee ID
        Object employeeIdObj = employeeModel.getValueAt(selectedRow, 0);
        if (employeeIdObj == null) {
            JOptionPane.showMessageDialog(this, "Invalid employee ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String employeeId = employeeIdObj.toString();

        // Get employee name (first and last name)
        String employeeName = employeeModel.getValueAt(selectedRow, 1) + " " + employeeModel.getValueAt(selectedRow, 2);

        // Get date, time-in, and time-out
        String date = dateField.getText();
        String timeIn = timeInField.getText();
        String timeOut = timeOutField.getText();

        // Parse and calculate hours worked
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalDate parsedDate = LocalDate.parse(date, dateFormatter);
            LocalTime parsedTimeIn = LocalTime.parse(timeIn, timeFormatter);
            LocalTime parsedTimeOut = LocalTime.parse(timeOut, timeFormatter);

            // Calculate total hours worked
            double hoursWorked = java.time.Duration.between(parsedTimeIn, parsedTimeOut).toMinutes() / 60.0;

            // Add record to attendance table
            attendanceModel.addRow(
                    new Object[] { employeeId, employeeName, parsedDate, parsedTimeIn, parsedTimeOut, hoursWorked });

            // Clear input fields
            dateField.setText("");
            timeInField.setText("");
            timeOutField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}
