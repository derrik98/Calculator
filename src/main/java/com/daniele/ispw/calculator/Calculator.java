package com.daniele.ispw.calculator;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Calculator extends Application {

    @FXML
    public Button number0 = new Button();
    @FXML
    public Button number1 = new Button();
    @FXML
    public Button number2 = new Button();
    @FXML
    public Button number3 = new Button();
    @FXML
    public Button number4 = new Button();
    @FXML
    public Button number5 = new Button();
    @FXML
    public Button number6 = new Button();
    @FXML
    public Button number7 = new Button();
    @FXML
    public Button number8 = new Button();
    @FXML
    public Button number9 = new Button();

    private String operation = "";
    private String op1 = "";
    private final String error = "Error";
    public static String symbol = "";
    private final ArrayList<String> list = new ArrayList<>();
    Button b = new Button();


    @FXML
    private TextField display = new TextField("");
    @FXML
    protected TextField displayRes = new TextField("");

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    public void selectNumber(MouseEvent mouseEvent) {

        b = (Button) mouseEvent.getSource();
        if (operation.equals(error)) {
            list.clear();
            displayRes.setText("");
            operation = "";
            op1 = b.getText();
            list.add(op1);
            symbol = "";
            operation = b.getText();
            display.setText(operation);
        } else {
            op1 += b.getText();
            operation += b.getText();
            if (op1.length() > 1) {
                list.set(list.size() - 1, op1);
                calculateResult(list);
            } else {
                list.add(op1);
                calculateResult(list);
            }
            display.setText(operation);
        }
    }

    public void selectSymbol(MouseEvent mouseEvent) {
        b = (Button) mouseEvent.getSource();
        if (!symbol.equals("")) {
            op1 = displayRes.getText();
        }
        operation += b.getText();
        symbol = b.getText();
        op1 = "";
        display.setText(operation);
        list.add(symbol);
    }

    @SuppressWarnings("SuspiciousListRemoveInLoop")
    public void calculateResult(ArrayList<String> als) {

        ArrayList<String> alsCopy = new ArrayList<>(als);
        if (alsCopy.get(0).equals("+") || alsCopy.get(0).equals("-") || alsCopy.get(0).equals("*") || alsCopy.get(0).equals("/") || alsCopy.get(0).equals(".") || alsCopy.get(0).equals("^")) {
            operation = error;
            displayRes.setText(error);
            return;
        }
        while ((alsCopy.size() != 1)) {
            for (int i = 0; i <= alsCopy.size() - 1; i++) {
                if (alsCopy.get(i).equals("^") || alsCopy.get(i).equals("/") || alsCopy.get(i).equals("*")) {
                    String o1Copy = alsCopy.get(i - 1);
                    String o2Copy = alsCopy.get(i + 1);
                    String symbolCopy = alsCopy.get(i);
                    alsCopy.remove(i + 1);
                    alsCopy.remove(i);
                    alsCopy.remove(i - 1);
                    alsCopy.add(i - 1, displayResult(o1Copy, o2Copy, symbolCopy));
                }
            }
            for (int i = 0; i <= alsCopy.size() - 1; i++) {
                if ((alsCopy.get(i).equals("-") || alsCopy.get(i).equals("+"))) {
                    String o1Copy = alsCopy.get(i - 1);
                    String o2Copy = alsCopy.get(i + 1);
                    String symbolCopy = alsCopy.get(i);
                    alsCopy.remove(i + 1);
                    alsCopy.remove(i);
                    alsCopy.remove(i - 1);
                    String result = displayResult(o1Copy, o2Copy, symbolCopy);
                    alsCopy.add(i - 1, result);
                }
            }

        }
    }

    public String displayResult(String op1, String op2, String symbol) {
        if (!op1.equals("") && !op2.equals("") && !symbol.equals("")) {
            switch (symbol) {
                case "+" -> {
                    displayRes.setText(sum(Double.parseDouble(op1), Double.parseDouble(op2)));
                    return sum(Double.parseDouble(op1), Double.parseDouble(op2));
                }
                case "-" -> {
                    displayRes.setText(sub(Double.valueOf(op1), Double.valueOf(op2)));
                    return sub(Double.valueOf(op1), Double.valueOf(op2));
                }
                case "*" -> {
                    displayRes.setText(mul(Double.valueOf(op1), Double.valueOf(op2)));
                    return mul(Double.valueOf(op1), Double.valueOf(op2));
                }
                case "/" -> {
                    try {
                        displayRes.setText(div(Double.valueOf(op1), Double.valueOf(op2)));
                        return div(Double.valueOf(op1), Double.valueOf(op2));
                    } catch (DivException e) {
                        display.setText(error);
                    }
                }
                case "^" -> {
                    displayRes.setText(exp(Double.valueOf(op1), Double.valueOf(op2)));
                    return exp(Double.valueOf(op1), Double.valueOf(op2));
                }
                default -> {
                    displayRes.setText(error);
                    display.setText(error);
                }
            }
        }
        if (op1.equals("") && !op2.equals("") && symbol.equals("√")) {
            displayRes.setText(radq(Double.valueOf(op2)));
            operation = display.getText();
            return radq(Double.valueOf(op2));
        } else if (op2.equals("") && symbol.equals("")) {
            displayRes.setText("");
            return "";
        } else {
            displayRes.setText(error);
            return error;
        }

    }

    //Implementazione tasto somma
    private String sum(double num1, double num2) {
        if ((num1 + num2) == (int) (num1 + num2)) {
            return String.valueOf((int) (num1 + num2));
        } else {
            return String.valueOf(num1 + num2);
        }
    }

    //Implementazione tasto radice quadrata
    protected String radq(Double num1) {
        if (Math.sqrt(num1) == (int) Math.sqrt(num1)) {
            return String.valueOf((int) Math.sqrt(num1));
        } else {
            return String.valueOf(Math.sqrt(num1));
        }
    }

    //Implementazione tasto elevazione di potenza
    protected String exp(Double num1, Double num2) {
        if (Math.pow(num1, num2) == (int) Math.pow(num1, num2)) {
            return String.valueOf((int) Math.pow(num1, num2));
        } else {
            return String.valueOf(Math.pow(num1, num2));
        }
    }

    //Implementazione tasto di divisione
    protected String div(Double num1, Double num2) throws DivException {
        if (num2 == 0) {
            throw new DivException(error);
        } else if ((num1 / num2) == (int) (num1 / num2)) {
            return String.valueOf((int) (num1 / num2));
        } else {
            return String.valueOf(num1 / num2);
        }
    }

    //Implementazione tasto di moltiplicazione
    protected String mul(Double num1, Double num2) {
        if ((num1 * num2) == (int) (num1 * num2)) {
            return String.valueOf((int) (num1 * num2));
        } else {
            return String.valueOf(num1 * num2);
        }
    }

    //Implementazione tasto di sottrazione
    protected String sub(Double num1, Double num2) {
        if ((num1 - num2) == (int) (num1 - num2)) {
            return String.valueOf((int) (num1 - num2));
        } else {
            return String.valueOf(num1 - num2);
        }
    }


    //Implementazione tasto C di calcellazione generale
    public void delete() {
        operation = "";
        symbol = "";
        op1 = "";
        display.setText("");
        displayRes.setText("");
        list.clear();
    }

    //Implementazione tasto "uguale"
    public void getResult() {
        op1 = displayRes.getText();
        symbol = "";
        operation = op1;
        display.setText(operation);
        displayRes.clear();
        list.clear();
        list.add(op1);
    }

}