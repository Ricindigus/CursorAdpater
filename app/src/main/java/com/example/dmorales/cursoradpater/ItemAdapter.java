package com.example.dmorales.cursoradpater;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by dmorales on 12/02/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    Context contexto;
    CursorAdapter cursorAdapter;
    public ItemAdapter(Context contexto, Cursor cursor) {
        this.contexto = contexto;
        this.cursorAdapter = new CursorAdapter(contexto,cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView dni = view.findViewById(R.id.txt_dni);
                TextView nombres = view.findViewById(R.id.txt_nombres);
                TextView apellidos = view.findViewById(R.id.txt_apellidos);
                TextView celular = view.findViewById(R.id.txt_celular);

                dni.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));
                nombres.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));
                apellidos.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));
                celular.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(4))));
            }
        };
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        cursorAdapter.getCursor().moveToPosition(position);
        cursorAdapter.bindView(holder.itemView,contexto,cursorAdapter.getCursor());
    }

    @Override
    public int getItemCount() {
        return cursorAdapter.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView dni;
        TextView nombres;
        TextView apellidos;
        TextView celular;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            dni = itemView.findViewById(R.id.txt_dni);
            nombres = itemView.findViewById(R.id.txt_nombres);
            apellidos = itemView.findViewById(R.id.txt_apellidos);
            celular = itemView.findViewById(R.id.txt_celular);
        }
    }
}
