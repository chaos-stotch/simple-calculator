package com.vitor.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numberZero,numberOne,numberTwo,numberThree,numberFour,numberFive,numberSix,numberSeven,numberEight,numberNine,
    point,plus,less,multiply,divide,equal,clear;

    private TextView txtExpression,txtResult;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        Objects.requireNonNull(getSupportActionBar()).hide();

        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        point.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        less.setOnClickListener(this);
        plus.setOnClickListener(this);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpression.setText("");
                txtResult.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expression = findViewById(R.id.txt_expression);
                String text = expression.getText().toString();

                if(!text.isEmpty()){
                    byte var0 = 0;
                    int var1 = text.length()-1;

                    String txtExpression = text.substring(var0, var1);
                    expression.setText(txtExpression);
                }
                txtResult.setText("");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Expression expression = new ExpressionBuilder(txtExpression.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if (result == (double) longResult) {
                        txtResult.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResult.setText((CharSequence) String.valueOf(result));
                    }
                }catch (Exception e){
                    txtResult.setText("ERROR");
                }
                txtExpression.setText("");
            }
        });
    }

    private void initializeComponents(){
        numberZero=findViewById(R.id.number_zero);
        numberOne=findViewById(R.id.number_one);
        numberTwo=findViewById(R.id.number_two);
        numberThree=findViewById(R.id.number_three);
        numberFour=findViewById(R.id.number_four);
        numberFive=findViewById(R.id.number_five);
        numberSix=findViewById(R.id.number_six);
        numberSeven=findViewById(R.id.number_seven);
        numberEight=findViewById(R.id.number_eight);
        numberNine=findViewById(R.id.number_nine);
        point=findViewById(R.id.bt_point);
        plus=findViewById(R.id.bt_plus);
        less=findViewById(R.id.bt_less);
        multiply=findViewById(R.id.bt_multiply);
        divide=findViewById(R.id.bt_divide);
        equal=findViewById(R.id.bt_equal);
        clear=findViewById(R.id.bt_clear);
        txtExpression=findViewById(R.id.txt_expression);
        txtResult=findViewById(R.id.txt_result);
        backspace=findViewById(R.id.backspace);
    }

    public void addExpression(String string, boolean clean_data){
        if(txtResult.getText().equals("")){
            txtExpression.setText(" ");
        }
        if (clean_data){
            txtResult.setText(" ");
            txtExpression.append(string);
        }else{
            txtExpression.append(txtResult.getText());
            txtExpression.append(string);
            txtResult.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.number_zero:
                addExpression("0", true);
                break;
            case R.id.number_one:
                addExpression("1", true);
                break;
            case R.id.number_two:
                addExpression("2", true);
                break;
            case R.id.number_three:
                addExpression("3", true);
                break;
            case R.id.number_four:
                addExpression("4", true);
                break;
            case R.id.number_five:
                addExpression("5", true);
                break;
            case R.id.number_six:
                addExpression("6", true);
                break;
            case R.id.number_seven:
                addExpression("7", true);
                break;
            case R.id.number_eight:
                addExpression("8", true);
                break;
            case R.id.number_nine:
                addExpression("9", true);
                break;
            case R.id.bt_point:
                addExpression(".", true);
                break;
            case R.id.bt_divide:
                addExpression("/", false);
                break;
            case R.id.bt_multiply:
                addExpression("*", false);
                break;
            case R.id.bt_less:
                addExpression("-", false);
                break;
            case R.id.bt_plus:
                addExpression("+", false);
                break;
        }
    }
}