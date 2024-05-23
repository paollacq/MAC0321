package ex1;

public class Main {
    public static void main(String[] args) {
        FatorialController controller = new FatorialController();
        FatorialView view = new FatorialView(controller);
        view.exibir();
    }
}

