package com.app.countries.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.countries.R
import com.app.countries.ViewModel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : ListViewModel
    private val countryAdapter = CountryListAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let { countryAdapter.updateCountries(it) }
            countriesList.visibility = View.VISIBLE
        })

        viewModel.countryLoadError.observe(this, Observer { isError->
            isError?.let { loadingError.visibility = if(it) View.VISIBLE else View.INVISIBLE }
        })

        viewModel.loading.observe(this, Observer { isLoading->
            isLoading?.let{loading_view.visibility = if(it) View.VISIBLE else View.INVISIBLE
            if(it){
                loadingError.visibility = View.GONE
                countriesList.visibility = View.GONE
            }
            }
        })
    }
}
