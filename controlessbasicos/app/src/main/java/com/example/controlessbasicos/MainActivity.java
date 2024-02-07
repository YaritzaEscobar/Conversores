package com.example.controlessbasicos;


        import androidx.appcompat.app.AppCompatActivity;
        import android.app.Notification;
        import android.os.Bundle;
        import android.os.Message;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    RadioGroup opt;
    Button btn;
    Spinner spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    //opt = findViewById(R.id.optCalculadora);
                    spn = findViewById(R.id.spnOpciones);

                    tempVal = findViewById(R.id.txtnum1);
                    double num1 = Double.parseDouble(tempVal.getText().toString());

                    tempVal = findViewById(R.id.txtnum2);
                    double num2 = Double.parseDouble(tempVal.getText().toString());

                    double resp = 0;
                        /*switch (opt.getCheckedRadioButtonId()){
                            case R.id.optSuma:
                                resp = num1+num2;
                                break;
                            case R.id.optResta:
                                resp = num1-num2;
                                break;
                            case R.id.optMultiplicacion:
                                resp=num1*num2;
                                break;
                            case R.id.optDivision:
                                resp = num1/num2;
                                break;
                        }*/
                    switch (spn.getSelectedItemPosition()){
                        case 0: //suma
                            resp = num1+num2;
                            break;
                        case 1: //resta
                            resp = num1-num2;
                            break;
                        case 2: //multiplicacion
                            resp = num1*num2;
                            break;
                        case 3: //division
                            resp = num1/num2;
                            break;
                        case 4: //exponenciacion
                            resp = Math.pow(num1,num2);
                            break;
                        case 5: //porcentaje
                            resp= num1*(num2/100.0);
                            break;
                        case 6: //factorial
                            resp=1;
                            for(int i=1; i<=num1; i++){
                                resp=resp*i;
                            }
                            break;
                        case 7: //raiz
                            if(num2==2){
                                if (num1==num1){
                                    resp = Math.sqrt(num1); //raiz cuadrada
                                }
                            } else if(num2==3){
                                if (num1==num1){
                                    resp = Math.cbrt(num1); //raiz cubica
                                }
                            } else {
                                tempVal.setText("Escribir 2 o 3"); //mensaje para q escriba raiz cuadrada o cubica
                            }
                            break;
                    }
                    tempVal = findViewById(R.id.lblrespuesta);
                    tempVal.setText("Respuesta: " + resp );
                }catch (Exception e){
                    tempVal = findViewById(R.id.lblrespuesta);
                    tempVal.setText("Error: "+ e.getMessage());
                }
            }
        });

    }
}