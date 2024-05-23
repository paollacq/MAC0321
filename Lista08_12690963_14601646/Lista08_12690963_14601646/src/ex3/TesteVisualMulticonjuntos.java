package ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TesteVisualMulticonjuntos {
    private JFrame frame;
    private JTextArea arrayListArea;
    private JTextArea setArea;
    private JTextArea linkedListArea;
    private JTextArea stackArea;
    private JTextField inputField;
    private MulticonjuntoArrayList<Integer> arrayList1;
    private MulticonjuntoArrayList<Integer> arrayList2;
    private MulticonjuntoSet<Integer> set1;
    private MulticonjuntoSet<Integer> set2;
    private MulticonjuntoLinkedList<Integer> linkedList1;
    private MulticonjuntoLinkedList<Integer> linkedList2;
    private MulticonjuntoStack<Integer> stack1;
    private MulticonjuntoStack<Integer> stack2;

    public TesteVisualMulticonjuntos() {
        arrayList1 = new MulticonjuntoArrayList<>();
        arrayList2 = new MulticonjuntoArrayList<>();
        set1 = new MulticonjuntoSet<>();
        set2 = new MulticonjuntoSet<>();
        linkedList1 = new MulticonjuntoLinkedList<>();
        linkedList2 = new MulticonjuntoLinkedList<>();
        stack1 = new MulticonjuntoStack<>();
        stack2 = new MulticonjuntoStack<>();

        frame = new JFrame("Teste Visual de Multiconjuntos");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputField = new JTextField(10);
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new AddButtonListener());
        JButton joinButton = new JButton("Juntar");
        joinButton.addActionListener(new JoinButtonListener());
        inputPanel.add(new JLabel("Elemento:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(joinButton);

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 4));

        arrayListArea = new JTextArea();
        arrayListArea.setEditable(false);
        setArea = new JTextArea();
        setArea.setEditable(false);
        linkedListArea = new JTextArea();
        linkedListArea.setEditable(false);
        stackArea = new JTextArea();
        stackArea.setEditable(false);

        displayPanel.add(new JScrollPane(arrayListArea));
        displayPanel.add(new JScrollPane(setArea));
        displayPanel.add(new JScrollPane(linkedListArea));
        displayPanel.add(new JScrollPane(stackArea));

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
                arrayList1.add(elemento);
                set1.add(elemento);
                linkedList1.add(elemento);
                stack1.add(elemento);

                arrayListArea.setText("ArrayList 1:\n" + arrayList1.toString() + "\nArrayList 2:\n" + arrayList2.toString());
                setArea.setText("Set 1:\n" + set1.toString() + "\nSet 2:\n" + set2.toString());
                linkedListArea.setText("LinkedList 1:\n" + linkedList1.toString() + "\nLinkedList 2:\n" + linkedList2.toString());
                stackArea.setText("Stack 1:\n" + stack1.toString() + "\nStack 2:\n" + stack2.toString());

                inputField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Digite um número válido.");
            }
        }
    }

    private class JoinButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            arrayList2.addAll(arrayList1);
            set2.addAll(set1);
            linkedList2.addAll(linkedList1);
            stack2.addAll(stack1);

            arrayListArea.setText("ArrayList 1:\n" + arrayList1.toString() + "\nArrayList 2:\n" + arrayList2.toString());
            setArea.setText("Set 1:\n" + set1.toString() + "\nSet 2:\n" + set2.toString());
            linkedListArea.setText("LinkedList 1:\n" + linkedList1.toString() + "\nLinkedList 2:\n" + linkedList2.toString());
            stackArea.setText("Stack 1:\n" + stack1.toString() + "\nStack 2:\n" + stack2.toString());
        }
    }

    public static void main(String[] args) {
        TesteVisualMulticonjuntos teste = new TesteVisualMulticonjuntos();
        teste.exibir();
    }
}


