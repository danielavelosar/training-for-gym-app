package com.example.trackingforgym.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trackingforgym.R;
import com.example.trackingforgym.data.Bst;
import com.example.trackingforgym.data.Rutine;
import com.example.trackingforgym.data.RutineHistoric;

import sun.bob.mcalendarview.MCalendarView;

public class Adaptador_Historic_Layout extends RecyclerView.Adapter<Adaptador_Historic_Layout.ViewHolder> implements View.OnClickListener{

    private Bst localDataSet;
    View.OnClickListener listener;

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    public void add(RutineHistoric r){
        localDataSet.insertar(r);
        notifyDataSetChanged();
    }
    /*public RutineHistoric find(RutineHistoric r){
        return localDataSet.find(r).getData();
    }*/

    /*public void addBack(RutineHistoric r){
        localDataSet.pushBack(r);
        notifyDataSetChanged();
    }*/
    public void pop(RutineHistoric i){
        localDataSet.remove(i);
        notifyDataSetChanged();
    }/*
    public void pop(int r){
        localDataSet.pop(r);
        notifyDataSetChanged();
    }
    public void popFront(){
        localDataSet.popFront();
        notifyDataSetChanged();
    }*/
    public RutineHistoric get(int r){
        return localDataSet.get(r);
    }
    public RutineHistoric find(int r){
        return localDataSet.find(r).getData();
    }
    /*public String getDatos (int i){
        return localDataSet[i].getNombre();
    };*/
    public String getDatos (int i){
        return localDataSet.get(i).getNombre();
    };

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView fecha;
        TextView idT;
        ImageView fig;
        MCalendarView calendarView;
        Rutine rutine;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            titulo = (TextView) view.findViewById(R.id.tituloHistoricLayout);
            fecha = (TextView) view.findViewById(R.id.fechaHistoricLayout);
            fig =(ImageView) view.findViewById(R.id.imageView3);
            idT=(TextView) view.findViewById(R.id.idT);
        }

        public TextView getTextView() {
            return titulo;
        }
        public TextView getIdT() {
            return idT;
        }
        public TextView getFechaTextView() {
            return fecha;
        }
        public ImageView getImageView() {
            return fig;
        }
    }

    public Adaptador_Historic_Layout(Bst dataSet) {
        localDataSet = dataSet;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.historic_layout, viewGroup, false);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //System.out.println(localDataSet[position]);
        //viewHolder.getFechaTextView().setText(localDataSet[position].getFecha().toString());
        /*viewHolder.getFechaTextView().setText(localDataSet[position].getFecha().toString());
        viewHolder.getTextView().setText(localDataSet[position].getNombre());
        viewHolder.getImageView().setBackgroundColor(Color.parseColor(localDataSet[position].getColor()));*/
        System.out.println("1 "+localDataSet.get(position).getNombre()+"size "+localDataSet.size);
        localDataSet.inOrder();
        viewHolder.getFechaTextView().setText(localDataSet.get(position).getFecha().toString());
        viewHolder.getTextView().setText(localDataSet.get(position).getNombre());
        viewHolder.getIdT().setText(Integer.toString(localDataSet.get(position).fechaInt));
        viewHolder.getImageView().setBackgroundColor(Color.parseColor(localDataSet.get(position).getColor()));
        viewHolder.rutine=localDataSet.get(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
       // return localDataSet.length;
        return localDataSet.size;
    }
}
