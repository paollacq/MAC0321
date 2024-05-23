package ex2;

import ex1.FatorialController;
import ex1.FatorialView;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/*  
Diferença entre Testes de Unidade e Testes de Aceitação

Testes de Unidade:

Focam em testar pequenas partes do código isoladamente que seria testar cada métodos ou classes. É fácil de 
perceber onde está o erro no código com esse teste, usamos o JUnit5 para isso. O objetivo final desse tipo é
garantir que cada unidade de código funcione como esperado.

Testes de Aceitação:

Verificam se o código final atende aos requisitos e expectativas do usuário. Simulam a interação do usuário com o
código como se fosse um teste manual feito por uma terceira pessoa em que a pessoa que roda o Teste de aceitação
está apenas assistindo. Podem ser parcialmente automatizados como foi o caso, mas também podem exigir algum tipo de
interação manual.

Comentário final sobre o teste de aceitação:

Este teste de aceitação utiliza as bibliotecas disponíveis no link dado: https://docs.oracle.com/javase/7/docs/api/
para simular interações do usuário com a interface gráfica criada por nós. O teste verifica se o código feito responde
corretamente quando o usuário insere um número e clica no botão para calcular o fatorial. Também verifica se a aplicação 
lida corretamente com entradas inválidas que seria o segundo caso visto (fatorial de -1).
*/

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteAceitacaoFatorial {
    @Test
    public void testCalculoFatorial() throws Exception {
        FatorialController controller = new FatorialController();
        FatorialView view = new FatorialView(controller);

        SwingUtilities.invokeLater(() -> view.exibir());
        JFrame frame = view.getFrame();

        Robot robot = new Robot();
        robot.setAutoDelay(200);

        robot.mouseMove(frame.getX() + 100, frame.getY() + 100);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

        robot.keyPress(KeyEvent.VK_5);
        robot.keyRelease(KeyEvent.VK_5);

        robot.mouseMove(frame.getX() + 100, frame.getY() + 140);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(1000);

        JLabel resultLabel = (JLabel) frame.getContentPane().getComponent(3);
        assertEquals("Resultado: 120", resultLabel.getText());
    }

    @Test
    public void testEntradaInvalida() throws Exception {
        FatorialController controller = new FatorialController();
        FatorialView view = new FatorialView(controller);

        SwingUtilities.invokeLater(() -> view.exibir());
        JFrame frame = view.getFrame();

        Robot robot = new Robot();
        robot.setAutoDelay(200);

        robot.mouseMove(frame.getX() + 100, frame.getY() + 100);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_MINUS);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);

        robot.mouseMove(frame.getX() + 100, frame.getY() + 140);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(1000);

        JLabel resultLabel = (JLabel) frame.getContentPane().getComponent(3);
        assertEquals("Número deve ser não-negativo.", resultLabel.getText());
    }
}


