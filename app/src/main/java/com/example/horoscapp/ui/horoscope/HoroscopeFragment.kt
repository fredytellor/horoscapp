package com.example.horoscapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horoscapp.R
import com.example.horoscapp.databinding.FragmentHoroscopeBinding
import com.example.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter:HoroscopeAdapter

    private var _binding:FragmentHoroscopeBinding?=null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUI()
    }

    private fun initUI() {
     initUIState()
        initHoroscopeList()
    }

    private fun initHoroscopeList() {
        horoscopeAdapter= HoroscopeAdapter(onItemSelected = {
            Toast.makeText(
                context,
                it.name,
                Toast.LENGTH_SHORT
            ).show()})

        //binding.recyclerHoroscopeList.layoutManager= LinearLayoutManager(context)
        //binding.recyclerHoroscopeList.adapter=adapter;

        binding.recyclerHoroscopeList.apply {
            layoutManager=GridLayoutManager(context,2)
            adapter=horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeViewModel.horoscope.collect{
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}
