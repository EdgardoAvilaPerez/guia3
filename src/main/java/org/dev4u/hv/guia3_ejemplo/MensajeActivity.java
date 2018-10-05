package org.dev4u.hv.guia3_ejemplo;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MensajeActivity extends AppCompatActivity {

    private TextView txtEntrada;
    private Button btnEnviar;
    private ListView lstMensaje;
    private ArrayList<Mensaje> mensajesArrayList;
    private AdaptadorMensaje adaptadorMensaje;
    String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        txtEntrada = (TextView) findViewById(R.id.txtEntrada);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        lstMensaje = (ListView) findViewById(R.id.lstMensaje);
        fecha = Calendar.getInstance().getTime().toString();

        mensajesArrayList = new ArrayList<>();

        adaptadorMensaje = new AdaptadorMensaje(this,  mensajesArrayList);
        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        //seteando el adaptador al listview
        listView.setAdapter(adaptadorMensaje);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtEntrada.getText().toString().isEmpty()){
                    Toast.makeText(MensajeActivity.this,"Inserta los datos del Mensaje",Toast.LENGTH_SHORT).show();
                }else{//de lo contrario los campos estan llenos

                    //recibo los datos
                    Mensaje c = new Mensaje(
                            fecha,
                            txtEntrada.getText().toString()
                    );
                    //TODO agrego a la lista y luego actualizo el adaptador, de lo contrario no se mostraria el cambio
                    mensajesArrayList.add(c);
                    adaptadorMensaje.notifyDataSetChanged();
                    txtEntrada.setText("");
                }
            }
        });

    }
}
