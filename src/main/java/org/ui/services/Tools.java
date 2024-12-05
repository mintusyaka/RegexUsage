package org.ui.services;

import org.text_logs_processing.serializers.OrdersTextWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    public static File chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file;
        }

        return null;
    }

    public static List<String> getStrings(String filename)
    {
        try {
            return OrdersTextWriter.read(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getStrings(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<String> list = new ArrayList<String>();
        for(int i = 0; i < model.getRowCount(); i++) {
            list.add(model.getValueAt(i, 1).toString());
        }

        return list;
    }

    public static void fillTable(JTable table, List<String> rows) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        while(model.getRowCount() != 0) {
            model.removeRow(model.getRowCount() - 1);
        }

        model.setColumnIdentifiers(new String[] { "#", "String"});



        for(String row : rows) {
            Vector<String> tableRow = new Vector<>();
            tableRow.add(model.getRowCount() + "");
            tableRow.add(row);
            model.addRow(tableRow);
        }
    }

    public static List<String> getRowsByNicknamePart(List<String> rows, String partOfNickname) {
        String regex = "Username: .*?" + Pattern.quote(partOfNickname) + ".*?, Order ID: .*";

        List<String> resultList = new ArrayList<>();

        rows.stream()
                .filter(line -> line.matches(regex))
                .forEach(resultList::add);

        return resultList;
    }

    public static String getOrderStatusFromUI(JCheckBox delivering, JCheckBox delivered, JCheckBox pending, JCheckBox canceled) {
        StringBuilder regexOptions = new StringBuilder();
        if(delivering.isSelected()) {
            regexOptions.append("Delivering");
        }
        if(delivered.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("Delivered");
        }
        if(pending.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("Pending");
        }
        if(canceled.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("Canceled");
        }

        return regexOptions.toString();
    }

    public static List<String> getRowsByStatus(List<String> rows, String status) {
        String regex = "Status: (" + status + ");.*";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> resultList = new ArrayList<>();

        rows.stream()
                .filter(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.find();
                })
                .forEach(resultList::add);

        return resultList;
    }

    public static String getGroupsFromUI(JCheckBox PZ, JCheckBox PP, JCheckBox VP, JCheckBox SA) {
        StringBuilder regexOptions = new StringBuilder();
        if(PZ.isSelected()) {
            regexOptions.append("pz");
        }
        if(PP.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("pp");
        }
        if(VP.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("vp");
        }
        if(SA.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("sa");
        }

        return regexOptions.toString();
    }

    public static String getYearsFromUI(JCheckBox y2019, JCheckBox y2020, JCheckBox y2021, JCheckBox y2022, JCheckBox y2023) {
        StringBuilder regexOptions = new StringBuilder();
        if(y2019.isSelected()) {
            regexOptions.append("2019");
        }
        if(y2020.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("2020");
        }
        if(y2021.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("2021");
        }
        if(y2022.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("2022");
        }
        if(y2023.isSelected()) {
            if(!regexOptions.toString().isEmpty()) {
                regexOptions.append("|");
            }
            regexOptions.append("2023");
        }

        return regexOptions.toString();
    }

    private static List<String> getStudentsByYear(List<String> rows, String years) {
        if(years.isEmpty())
            return rows;

        String regex = "Year: (" + years + ");.*";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> resultList = new ArrayList<>();

        rows.stream()
                .filter(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.find();
                })
                .forEach(resultList::add);

        return resultList;
    }

    public static List<String> getStudentsByGroupName(List<String> rows, String groupNames) {
        if(groupNames.isEmpty())
            return rows;

        String regex = ".*Email:\\s*\\w+\\.\\w+\\.("+ groupNames +")\\.\\d{4}@lpnu\\.ua.*";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> resultList = new ArrayList<>();

        rows.stream()
                .filter(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.find();
                })
                .forEach(resultList::add);

        return resultList;
    }

    private static List<String> filterByName(List<String> rows, String name) {
        if(name.isEmpty())
            return rows;

        String regex = ".*Email:\\s*" + name.toLowerCase() + "\\.[a-zA-Z]+";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> resultList = new ArrayList<>();

        rows.stream()
                .filter(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.find();
                })
                .forEach(resultList::add);

        return resultList;
    }

    private static List<String> filterBySurname(List<String> rows, String surname) {
        if(surname.isEmpty())
            return rows;

        String regex = ".*Email:\\s*[a-zA-Z]+\\." + surname.toLowerCase() + "\\.[a-zA-Z]+";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> resultList = new ArrayList<>();

        rows.stream()
                .filter(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.find();
                })
                .forEach(resultList::add);

        return resultList;
    }

    public static List<String> getFilteredStudentsRows(List<String> rows, String groups, String years, String name, String surname) {
        return filterBySurname(filterByName(getStudentsByYear(getStudentsByGroupName(rows, groups), years), name), surname);
    }
}
