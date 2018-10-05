package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

public class AdaptadorMensaje extends ArrayAdapter <Mensaje>{

    public AdaptadorMensaje(@NonNull Context context, List<Mensaje> objets) {
        super(context,0, objets);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obteniendo el dato
        Mensaje mensaje = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje, parent, false);
        }
        TextView lblMensahe = (TextView) convertView.findViewById(R.id.lblMensaje);
        TextView lblFecha = (TextView) convertView.findViewById(R.id.lblFecha);
        // mostrar los datos
        lblMensahe.setText(mensaje.Mensaje);
        lblFecha.setText(mensaje.Fecha);
        // Return la convertView ya con los datos
        return convertView;
    }
}
