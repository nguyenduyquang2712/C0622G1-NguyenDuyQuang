package case_study.view;

import case_study.controller.FuramaController;

import java.io.IOException;

public class FuramaMainView {
    public static void main(String[] args) throws IOException {
        FuramaController furama = new FuramaController();
        furama.menuUser();
    }
}
