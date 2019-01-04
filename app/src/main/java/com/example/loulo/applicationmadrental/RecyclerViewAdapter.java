package com.example.loulo.applicationmadrental;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Vehicule> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Vehicule> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Requête option pour Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.vehicule_row_item, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, Res1Activity.class);
                i.putExtra("vehicule_name", mData.get(viewHolder.getAdapterPosition()).getNom());
                i.putExtra("vehicule_price", mData.get(viewHolder.getAdapterPosition()).getPrixjournalierbase());
                i.putExtra("vehicule_category", mData.get(viewHolder.getAdapterPosition()).getCategorieco2());
                i.putExtra("vehicule_image", mData.get(viewHolder.getAdapterPosition()).getImage());

                mContext.startActivity(i);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_nom.setText(mData.get(position).getNom());
        holder.tv_prixjournalierbase.setText(mData.get(position).getPrixjournalierbase()+" € / jour");
        holder.tv_categorieco2.setText("Catégorie CO2 : "+mData.get(position).getCategorieco2());
        holder.tv_promotion.setText("Promotion : "+mData.get(position).getPromotion()+"%");

        // Charger image depuis internet
        Glide.with(mContext).load(mData.get(position).getImage()).apply(option).into(holder.img_image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nom;
        TextView tv_prixjournalierbase;
        TextView tv_categorieco2;
        TextView tv_promotion;
        ImageView img_image;
        TextView tv_equipements;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_nom = itemView.findViewById(R.id.vehicule_name);
            tv_prixjournalierbase = itemView.findViewById(R.id.vehicule_price);
            tv_categorieco2 = itemView.findViewById(R.id.vehicule_category);
            tv_promotion = itemView.findViewById(R.id.vehicule_promotion);
            img_image = itemView.findViewById(R.id.vehicule_image);

        }
    }

}
