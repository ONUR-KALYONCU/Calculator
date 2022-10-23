package com.example.deneme;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    TextField txt;
    @FXML
    Button btn;

    String process;  // The action I chose ( x,/,-,+,% )

    double number_in_memory;  // I backed up the 1st value to enter the 2nd value

    public void click_number_Event(ActionEvent event){

        Button a=(Button) event.getSource();
        txt.setText(txt.getText()+a.getText());
    }

    public void click_operator_Event(ActionEvent event){
        if (txt.getText().equals(""))return;
        Button b=(Button) event.getSource();
        process=b.getText();
        number_in_memory = Double.valueOf(txt.getText());
        txt.clear();

    }

    public void equal_Event(){

        double conclusion;
        if (txt.getText().equals(""))return;

        if(process.equals("+")){
            conclusion=Double.valueOf(txt.getText())+number_in_memory;
            txt.setText(String.valueOf(conclusion));
        }
        if (process.equals("-")){
            conclusion=Double.valueOf(txt.getText());


            if (conclusion>number_in_memory)
            {
                conclusion=conclusion-number_in_memory;
                txt.setText(String.valueOf("-"+conclusion));
            }
            else
            {
               conclusion=number_in_memory-conclusion;
               txt.setText(String.valueOf(conclusion));
            }
        }
        if (process.equals("x")){
            conclusion=Double.valueOf(txt.getText())*number_in_memory;
            txt.setText(String.valueOf(conclusion));
        }

        if (process.equals("/")){
            conclusion=number_in_memory/Double.valueOf(txt.getText());
            txt.setText(String.valueOf(conclusion));
        }
        if(process.equals("%")){
            conclusion=number_in_memory%Double.valueOf(txt.getText());
            txt.setText(String.valueOf(conclusion));
        }

    }

    public void delete_Event(){
        txt.clear();
        number_in_memory=0;
    }



}