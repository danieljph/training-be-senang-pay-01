package com.doku.my.trainingbesenangpay01.syntax.basic;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class BasicGui extends JFrame
{
    public BasicGui()
    {
        setSize(400, 300);

        // Set GridBagLayout for the frame's content pane
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        var centerButton = new JButton("Click Me!");
        centerButton.addActionListener(e ->
        {
            try
            {
                Desktop.getDesktop().browse(new URI("https://www.google.com"));
            }
            catch (IOException | URISyntaxException ex)
            {
                ex.printStackTrace(System.err);
            }
        });

        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.weightx = 1.0; // Distribute extra horizontal space
        gbc.weighty = 1.0; // Distribute extra vertical space
        gbc.anchor = GridBagConstraints.CENTER; // Anchor to center

        getContentPane().add(centerButton, gbc); // Add a button with constraints

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Basic GUI");
        setVisible(true);
    }

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.invokeLater(BasicGui::new);
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
