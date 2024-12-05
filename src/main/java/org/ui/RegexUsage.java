package org.ui;

import org.ui.services.Tools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class RegexUsage {
    private JTabbedPane tabbedPanel;
    private JPanel studentsDataManager;
    private JPanel textLogsProcessing;
    private JTable logsRowsTable;
    private JButton selectByStatusButton;
    private JCheckBox deliveringCheckBox;
    private JCheckBox deliveredCheckBox;
    private JCheckBox pendingCheckBox;
    private JCheckBox canceledCheckBox;
    private JButton selectByPartOfNicknameButton;
    private JTextField partOfNicknameTextField;
    private JPanel mainPanel;
    private JButton chooseFile;
    private JTable studentsTable;
    private JCheckBox PZCheckBox;
    private JCheckBox SACheckBox;
    private JCheckBox VPCheckBox;
    private JCheckBox PPCheckBox;
    private JButton filterStudentsButton;
    private JCheckBox a2019CheckBox;
    private JCheckBox a2020CheckBox;
    private JCheckBox a2021CheckBox;
    private JCheckBox a2023CheckBox;
    private JCheckBox a2022CheckBox;
    private JButton chooseStudentsFile;
    private JTextField nameTextField;
    private JTextField surnameTextField;

    public RegexUsage() {
        chooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = Tools.chooseFile();
                if(file != null) {
                    List<String> rows = Tools.getStrings(file.getAbsolutePath());
                    Tools.fillTable(logsRowsTable, rows);
                }
            }
        });
        selectByPartOfNicknameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> list = Tools.getStrings(logsRowsTable);
                if(!list.isEmpty()) {
                    list = Tools.getRowsByNicknamePart(list, partOfNicknameTextField.getText());
                    Tools.fillTable(logsRowsTable, list);
                }
            }
        });
        selectByStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> list = Tools.getStrings(logsRowsTable);
                if(!list.isEmpty()) {
                    String regexOptions = Tools.getOrderStatusFromUI(
                            deliveringCheckBox,
                            deliveredCheckBox,
                            pendingCheckBox,
                            canceledCheckBox
                    );
                    list = Tools.getRowsByStatus(list, regexOptions);
                    Tools.fillTable(logsRowsTable, list);
                }
            }
        });

        // STUDENTS REGEX
        chooseStudentsFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = Tools.chooseFile();
                if(file != null) {
                    List<String> rows = Tools.getStrings(file.getAbsolutePath());
                    Tools.fillTable(studentsTable, rows);
                }
            }
        });
        filterStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> list = Tools.getStrings(studentsTable);
                if(!list.isEmpty()) {
                    String groupRegexOptions = Tools.getGroupsFromUI(PZCheckBox, PPCheckBox, VPCheckBox, SACheckBox);
                    String yearsRegexOptions = Tools.getYearsFromUI(a2019CheckBox, a2020CheckBox, a2021CheckBox, a2022CheckBox, a2023CheckBox);
                    String name = nameTextField.getText();
                    String surname = surnameTextField.getText();
                    list = Tools.getFilteredStudentsRows(list, groupRegexOptions, yearsRegexOptions, name, surname);
                    Tools.fillTable(studentsTable, list);
                }
            }
        });
    }

    public void show() {
        JFrame frame = new JFrame("Big Files Processing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack(); // Adjusts window size based on the preferred size of components
        frame.setLocationRelativeTo(null); // Centers window on the screen
        frame.setVisible(true);

    }
}
