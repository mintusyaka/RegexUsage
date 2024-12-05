package org.main;

import org.ui.RegexUsage;

import javax.swing.*;

public class RegexUsageApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegexUsage().show();
            }
        });
    }
}
