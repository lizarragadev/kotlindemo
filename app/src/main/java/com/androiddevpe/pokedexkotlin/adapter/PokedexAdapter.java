package com.androiddevpe.pokedexkotlin.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.androiddevpe.pokedexkotlin.R;
import com.androiddevpe.pokedexkotlin.model.Pokemon;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Gustavo on 02/05/2017.
 */
public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.ViewHolder> {
    private List<Pokemon> pokemonList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tviName;
        public ImageView iviPhoto;
        public View view;
        public ViewHolder(View  v) {
            super(v);
            this.view = v;
            tviName= (TextView) v.findViewById(R.id.tviName);
            iviPhoto= (ImageView) v.findViewById(R.id.iviPhoto);
        }
    }

    public PokedexAdapter(Context context,List<Pokemon> pokemonList) {
        this.context= context;
        this.pokemonList = pokemonList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pokemon, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon pokemon= pokemonList.get(position);
        holder.tviName.setText(pokemon.getName());
        holder.iviPhoto.setImageBitmap(getBitmapFromAssets(pokemon.getPhoto()));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
    public Bitmap getBitmapFromAssets(String fileName) {
        AssetManager assetManager = context.getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        return bitmap;
    }
}
