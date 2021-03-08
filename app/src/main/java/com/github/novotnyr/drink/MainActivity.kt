package com.github.novotnyr.drink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var drinkRecyclerView: RecyclerView

    val viewModel: DrinkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drinkRecyclerView = findViewById(R.id.drinkRecyclerView)
        drinkRecyclerView.layoutManager = GridLayoutManager(this, 3)

        val adapter = DrinkListAdapter()
        drinkRecyclerView.adapter = adapter

        // [x] pridat floating action button
        // [x] pridat ViewModel
        // [x] potrebujeme cez FAB pridavat pohariky do ViewModel

        //Dáta máme na dvoch miestach:
        // - vo adaptéri
        // - vo viewmodeli
        // Zdroj pravdy je ViewModel!
        viewModel.drinks.observe(this) {
            adapter.submitList(it)
        }
    }

    fun onFabClick(view: View) {
        Snackbar.make(view, "Na zdravie!", Snackbar.LENGTH_SHORT).show()
        viewModel.addDrink()
    }


}