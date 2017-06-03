package com.androiddevpe.pokedexkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.androiddevpe.pokedexkotlin.adapter.PokedexKtAdapter
import com.androiddevpe.pokedexkotlin.model.Pokemon
import com.isil.myfirstapp.model.PokemonKt
import java.util.*

/**
 * Created by Gustavo on 02/05/2017.
 */

class PokedexKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex_kotlin)

    }
}
