package ex1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FatorialView {
    private JFrame frame;
    private JTextField textField;
    private JLabel resultLabel;
    private FatorialController controller;

    public FatorialView(FatorialController controller) {
        this.controller = controller;
        frame = new JFrame("Cálculo de Fatorial");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Digite um número:");
        label.setBounds(10, 10, 200, 30);
        frame.add(label);

        textField = new JTextField();
        textField.setBounds(10, 50, 200, 30);
        textField.setName("textField");
        frame.add(textField);

        JButton button = new JButton("Calcular");
        button.setBounds(10, 90, 200, 30);
        button.setName("button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularFatorial();
            }
        });
        frame.add(button);

        resultLabel = new JLabel("Resultado:");
        resultLabel.setBounds(10, 130, 200, 30);
        resultLabel.setName("resultLabel");
        frame.add(resultLabel);
    }

    public void exibir() {
        frame.setVisible(true);
    }

    private void calcularFatorial() {
        try {
            int numero = Integer.parseInt(textField.getText());
            long resultado = controller.calcularFatorial(numero);
            resultLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            resultLabel.setText("Digite um número válido.");
        } catch (IllegalArgumentException e) {
            resultLabel.setText(e.getMessage());
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}

