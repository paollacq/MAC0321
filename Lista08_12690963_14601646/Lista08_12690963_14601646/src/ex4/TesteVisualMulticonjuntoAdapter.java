package ex4;

import ex3.MulticonjuntoArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class TesteVisualMulticonjuntoAdapter {
    private JFrame frame;
    private JTextArea multiconjuntoArea;
    private JTextArea conjuntoArea;
    private JTextField inputField;
    private MulticonjuntoArrayList<Integer> multiconjunto;

    public TesteVisualMulticonjuntoAdapter() {
        multiconjunto = new MulticonjuntoArrayList<>();

        frame = new JFrame("Teste Visual de Multiconjunto Adapter");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputField = new JTextField(10);
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new AddButtonListener());
        JButton adaptButton = new JButton("Adaptar para Conjunto");
        adaptButton.addActionListener(new AdaptButtonListener());
        inputPanel.add(new JLabel("Elemento:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(adaptButton);

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(1, 2));

        multiconjuntoArea = new JTextArea();
        multiconjuntoArea.setEditable(false);
        conjuntoArea = new JTextArea();
        conjuntoArea.setEditable(false);

        displayPanel.add(new JScrollPane(multiconjuntoArea));
        displayPanel.add(new JScrollPane(conjuntoArea));

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(displayPanel, BorderLayout.CENTER);
    }

    public void exibir() {
        frame.setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int elemento = Integer.parseInt(inputField.getText());
                multiconjunto.add(elemento);
                multiconjuntoArea.setText("Multiconjunto:\n" + multiconjunto.toString());
                inputField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Digite um número válido.");
            }
        }
    }

    private class AdaptButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MulticonjuntoAdapter<Integer> adapter = new MulticonjuntoAdapter<>(multiconjunto);
            Set<Integer> conjunto = adapter.getConjunto();
            conjuntoArea.setText("Conjunto (adaptado):\n" + conjunto.toString());
        }
    }

    public static void main(String[] args) {
        TesteVisualMulticonjuntoAdapter teste = new TesteVisualMulticonjuntoAdapter();
        teste.exibir();
    }
}

