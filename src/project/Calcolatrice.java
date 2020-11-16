package project;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

public class Calcolatrice extends Application{

	private static final int WIDTHWINDOW = 400;
	private static final int HEIGTHWINDOW = 400;
	
	private TextField display = new TextField("");
	private String OPERATION = "";
	private String OP1 = "";
	private String OP2 = "";
	private String SYMBOL = "";
	private int NUMBER0 = 0;
	private int NUMBER1 = 1;
	private int NUMBER2 = 2;
	private int NUMBER3 = 3;
	private int NUMBER4 = 4;
	private int NUMBER5 = 5;
	private int NUMBER6 = 6;
	private int NUMBER7 = 7;
	private int NUMBER8 = 8;
	private int NUMBER9 = 9;
	private boolean RESULT = false;
	private String ERROR = "Error";
	
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
		stage.setTitle("Calcolatrice");
		VBox root = new VBox();
		List<Button> listButton = new ArrayList<>();
		GridPane buttonLayout = new GridPane();
		display.setMinSize(WIDTHWINDOW, HEIGTHWINDOW/5);
		display.setAlignment(Pos.CENTER_RIGHT);
		display.setStyle("-fx-text-fill: black; -fx-font-size: 28;");
		Font font = new Font("Arial", 16);
		
		for(int i = 0; i < 10; i++) {
			Button button = new Button(Integer.toString(i));
			button.setStyle("-fx-text-fill: black; -fx-background-color: white");
			listButton.add(button);
		}
		listButton.add(new Button("."));
        listButton.add(new Button("=")); 
        listButton.add(new Button("+"));
        listButton.add(new Button("-"));
        listButton.add(new Button("*"));
        listButton.add(new Button("/"));
        listButton.add(new Button("C"));
        listButton.add(new Button("^"));
        listButton.add(new Button("√"));
        listButton.add(new Button("←"));
		
		for(int j = 0; j < listButton.size() ; j++) {
			listButton.get(j).setFont(font);
			listButton.get(j).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		}
		
		
		buttonLayout.add(listButton.get(7), 0, 0);
        buttonLayout.add(listButton.get(8), 1, 0);
        buttonLayout.add(listButton.get(9), 2, 0);
        buttonLayout.add(listButton.get(12), 3, 0);
        buttonLayout.add(listButton.get(16), 4, 0);


        buttonLayout.add(listButton.get(4), 0, 1);
        buttonLayout.add(listButton.get(5), 1, 1);
        buttonLayout.add(listButton.get(6), 2, 1);
        buttonLayout.add(listButton.get(13), 3, 1);
        buttonLayout.add(listButton.get(17), 4, 1);

        buttonLayout.add(listButton.get(1), 0, 2);
        buttonLayout.add(listButton.get(2), 1, 2);
        buttonLayout.add(listButton.get(3), 2, 2);
        buttonLayout.add(listButton.get(14), 3, 2);
        buttonLayout.add(listButton.get(18), 4, 2);

        buttonLayout.add(listButton.get(0), 0, 3);
        buttonLayout.add(listButton.get(10), 1, 3);
        buttonLayout.add(listButton.get(11), 2, 3);
        buttonLayout.add(listButton.get(15), 3, 3);
        buttonLayout.add(listButton.get(19), 4, 3);


        buttonLayout.setGridLinesVisible(true);
        buttonLayout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
            RowConstraints rc = new RowConstraints();
            rc.setVgrow(Priority.ALWAYS);
            rc.setFillHeight(true);
            buttonLayout.getRowConstraints().add(rc);
        }
        for (int colIndex = 0; colIndex < 5; colIndex++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS);
            cc.setFillWidth(true);
            buttonLayout.getColumnConstraints().add(cc);
        }

        VBox.setVgrow(buttonLayout, Priority.ALWAYS);
        root.getChildren().addAll(display, buttonLayout);

        Scene scene = new Scene(root, WIDTHWINDOW, HEIGTHWINDOW);
        stage.setScene(scene);
        stage.show();   
        
        
        
		listButton.get(0).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER0);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER0;
					}
					else {
						OP2 += NUMBER0;
					}
				}
				
				OPERATION += NUMBER0;
				display.setText(OPERATION);
			}
		});
		
		listButton.get(1).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER1);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER1;
					}
					else {
						OP2 += NUMBER1;
					}
				}
				
				OPERATION += NUMBER1;
				display.setText(OPERATION);
			}
		});
		
		listButton.get(2).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER2);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER2;
					}
					else {
						OP2 += NUMBER2;
					}
				}
				
				OPERATION += NUMBER2;
				display.setText(OPERATION);
			}
		});
		
		listButton.get(3).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER3);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER3;
					}
					else {
						OP2 += NUMBER3;
					}
				}
				
				OPERATION += "3";
				display.setText(OPERATION);
			}
		});
		
		listButton.get(4).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER4);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER4;
					}
					else {
						OP2 += NUMBER4;
					}
				}
				
				OPERATION += "4";
				display.setText(OPERATION);
			}
		});
		
		listButton.get(5).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER5);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER5;
					}
					else {
						OP2 += NUMBER5;
					}
				}
				
				OPERATION += "5";
				display.setText(OPERATION);
			}
		});
		
		listButton.get(6).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER6);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER6;
					}
					else {
						OP2 += NUMBER6;
					}
				}
				
				OPERATION += "6";
				display.setText(OPERATION);
			}
		});
		
		listButton.get(7).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER7);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER7;
					}
					else {
						OP2 += NUMBER7;
					}
				}
				OPERATION += "7";
				display.setText(OPERATION);
			}
		});
		
		listButton.get(8).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER8);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER8;
					}
					else {
						OP2 += NUMBER8;
					}
				}
				
				OPERATION += "8";
				display.setText(OPERATION);
			}
		});
		
		listButton.get(9).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(RESULT || OPERATION.equals(ERROR)) {
					OPERATION = "";
					OP1 = String.valueOf(NUMBER9);
					OP2 = "";
					RESULT = false;
					SYMBOL = "";
					display.setText(OPERATION);
				}
				else {
					if(SYMBOL.equals("")) {
						OP1 += NUMBER9;
					}
					else {
						OP2 += NUMBER9;
					}
				}
				OPERATION += "9";
				display.setText(OPERATION);
			}
		});
		
		listButton.get(10).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(SYMBOL.equals("")) {
					OP1 += ".";
				}
				else {
					OP2 += ".";
				}
				OPERATION += ".";
				display.setText(OPERATION);
			}
		});
		

		listButton.get(11).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(!OP1.equals("") && !OP2.equals("") && !SYMBOL.equals("")) {
					RESULT = true;
					if(SYMBOL.equals("+")) {
						display.setText(sum(Double.valueOf(OP1), Double.valueOf(OP2)));
					}
					else if(SYMBOL.equals("-")) {
						display.setText(sub(Double.valueOf(OP1), Double.valueOf(OP2)));
					}
					else if(SYMBOL.equals("*")) {
						display.setText(mul(Double.valueOf(OP1), Double.valueOf(OP2)));
					}
					else if(SYMBOL.equals("/")) {
						display.setText(div(Double.valueOf(OP1), Double.valueOf(OP2)));
					}
					else if(SYMBOL.equals("^")) {
						display.setText(exp(Double.valueOf(OP1), Double.valueOf(OP2)));
					}
					OPERATION = display.getText();
					OP1 = OPERATION;
				}
				else if(OP1.equals("") && !OP2.equals("") && SYMBOL.equals("√")) {
					display.setText(radq(Double.valueOf(OP2)));
					OPERATION = display.getText();
					OP2 = OPERATION;
				}
				else {
					OPERATION = ERROR;
				}
				display.setText(OPERATION);
			}
		});
		
		listButton.get(12).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(SYMBOL.equals("")) {
					OPERATION += "+";
					SYMBOL = "+";
				}
				else {
					OPERATION = OPERATION.substring(0, OPERATION.length());
					OPERATION += "+";
					SYMBOL = "+";
				}
				OP2 = "";
				RESULT = false;
				display.setText(OPERATION);
			}
		});
		
		listButton.get(13).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(SYMBOL.equals("")) {
					OPERATION += "-";
					SYMBOL = "-";
				}
				else {
					OPERATION = OPERATION.substring(0, OPERATION.length());
					OPERATION += "-";
					SYMBOL = "-";
				}
				OP2 = "";
				RESULT = false;
				display.setText(OPERATION);
			}
		});
		
		listButton.get(14).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(SYMBOL.equals("")) {
					OPERATION += "*";
					SYMBOL = "*";
				}
				else {
					OPERATION = OPERATION.substring(0, OPERATION.length());
					OPERATION += "*";
					SYMBOL = "*";
				OP2 = "";
				RESULT = false;
				display.setText(OPERATION);
				}
			}
		});
		
		listButton.get(15).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(SYMBOL.equals("")) {
					OPERATION += "/";
					SYMBOL = "/";
				}
				else {
					OPERATION = OPERATION.substring(0, OPERATION.length());
					OPERATION += "/";
					SYMBOL = "/";
				}
				OP2 = "";
				RESULT = false;
				display.setText(OPERATION);
			}
		});
		
		listButton.get(16).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				OPERATION = "";
				SYMBOL = "";
				OP1 = "";
				OP2 = "";
				RESULT = false;
				display.setText("");
			}
		});
		
		listButton.get(17).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(SYMBOL.equals("")) {
					OPERATION += "^";
					SYMBOL = "^";
				}
				else {
					OPERATION = OPERATION.substring(0, OPERATION.length());
					OPERATION += "^";
					SYMBOL = "^";
				}
				OP2 = "";
				RESULT = false;
				display.setText(OPERATION);
			}
		});
		
		listButton.get(18).setOnAction(new EventHandler<ActionEvent>() { //radq
			
			@Override
			public void handle(ActionEvent event) {
				if(SYMBOL.equals("")) {
					OPERATION += "√";
					SYMBOL = "√";
				}
				else {
					OPERATION = OPERATION.substring(0, OPERATION.length());
					OPERATION += "√";
					SYMBOL = "√";
				}
				OP2 = OP1;
				OP1 = "";
				RESULT = false;
				display.setText(OPERATION);
			}
		});
		
		listButton.get(19).setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				if(!RESULT) {
					if(!OP1.equals("") || !OP2.equals("")) {
						if(!SYMBOL.equals("") && (OPERATION.substring(OPERATION.length()-1, OPERATION.length()).equals(SYMBOL))) {
							SYMBOL = "";
							OP2 = "";
							OPERATION = OPERATION.substring(0, OPERATION.length()-1);
						}
						else {
							if(OP1.length() >= 1 && OP2.length() == 0) {
								SYMBOL = "";
								OP1 = OP1.substring(0, OP1.length()-1);
								OPERATION = OP1;
							}
							else if(!SYMBOL.equals("") && OP2.length() >= 1){
								OP2 = OP2.substring(0, OP2.length()-1);
								OPERATION = OPERATION.substring(0, OPERATION.length()-1);
							}
						}
					}
					else {
						OPERATION = "";
						OP1 = "";
						OP2 = "";
						SYMBOL = "";
					}
				}
				else {
					SYMBOL = "";
					OP2 = "";
					OP1 = OP1.substring(0, OP1.length()-1);
					OPERATION = OP1;
				}
				RESULT = false;
				display.setText(OPERATION);
			}
		});
		
	}

	protected String radq(Double num1) {
		if(Math.sqrt(num1) == (int)Math.sqrt(num1)) {
			return String.valueOf((int)Math.sqrt(num1));
		}
		else {
			return String.valueOf(Math.sqrt(num1));
		}
	}

	protected String undo(String str1) {
		if((str1.substring(0, str1.length()-1)).matches("[+---*-/-^]")) {
			return str1.substring(0, str1.length()-1);
		}
		else {
			str1 = str1.substring(0, str1.length()-1);
			return str1;
		}
	}

	protected String exp(Double num1, Double num2) {
		if(Math.pow(num1, num2) == (int)Math.pow(num1, num2)) {
			return String.valueOf((int)Math.pow(num1, num2));
		}
		else {
			return String.valueOf(Math.pow(num1, num2));
		}
	}

	protected String div(Double num1, Double num2) {
		if(num2 == 0) {
			return ERROR;
		}
		else if((num1 / num2) == (int)(num1 / num2)) {
			return String.valueOf((int)(num1 / num2));
		}
		else {
			return String.valueOf(num1 / num2);
		}
	}

	protected String mul(Double num1, Double num2) {
		if((num1 * num2) == (int)(num1 * num2)) {
			return String.valueOf((int)(num1 * num2));
		}
		else {
			return String.valueOf(num1 * num2);
		}
	}

	protected String sub(Double num1, Double num2) {
		if((num1 - num2) == (int)(num1 - num2)) {
			return String.valueOf((int)(num1 - num2));
		}
		else {
			return String.valueOf(num1 - num2);
		}
	}

	protected String sum(double num1, double num2) {
		if((num1 + num2) == (int)(num1 + num2)) {
			return String.valueOf((int)(num1 + num2));
		}
		else {
			return String.valueOf(num1 + num2);
		}
		
	}
}
