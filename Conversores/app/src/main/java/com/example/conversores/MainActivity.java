package com.example.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabWidget;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    Spinner spn;
    TextView tempVal;
    Button btn;
    conversores miObj = new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cambiar color barra de estado
        cambiarColorBarraEstado(getResources().getColor(R.color.gray60));


        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("longitud").setIndicator("LONGITUD").setContent(R.id.tabLongitud));
        tbh.addTab(tbh.newTabSpec("almacenamiento").setIndicator("ALMACENAMIENTO").setContent(R.id.tabAlmacenamiento));
        tbh.addTab(tbh.newTabSpec("monedas").setIndicator("MONEDAS").setContent(R.id.tabMonedas));
        tbh.addTab(tbh.newTabSpec("masa").setIndicator("MASA").setContent(R.id.tabMasa));
        tbh.addTab(tbh.newTabSpec("volumen").setIndicator("VOLUMEN").setContent(R.id.tabVolumen));
        tbh.addTab(tbh.newTabSpec("tiempo").setIndicator("TIEMPO").setContent(R.id.tabTiempo));
        tbh.addTab(tbh.newTabSpec("transferencia").setIndicator("TRANSFERENCIA_DATOS").setContent(R.id.tabTransfDatos));


        // Obtener el TabWidget personalizado y habilitar el desplazamiento horizontal
        TabWidget tabWidget = tbh.getTabWidget();
        tabWidget.setStripEnabled(false); // Desactivar la tira indicadora
        tabWidget.setShowDividers(TabWidget.SHOW_DIVIDER_NONE); // Ocultar los divisores

        btn = findViewById(R.id.btnLongitudConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spn = findViewById(R.id.spnLongitudDe);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnLongitudA);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtLongitudCantidad);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                double resp = miObj.convertir(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: "+ resp, Toast.LENGTH_LONG).show();
            }
        });
    }


    private void cambiarColorBarraEstado(int color) {
        // Verificar si la versión del SDK es Lollipop o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    } //fin cambiar colorbarraestado

    class conversores{
        double[][] valores = {
                {1, 100, 39.3701, 3.28084, 1.193, 1.09361, 0.001, 0.000621371},
                {},
                {},
                {},
                {},
                {},
                {}
        };
        public double convertir(int opcion, int de, int a, double cantidad){
            return valores[opcion][a] / valores[opcion][de] * cantidad;
        }
    }

}