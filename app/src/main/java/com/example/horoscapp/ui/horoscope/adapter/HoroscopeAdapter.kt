package com.example.horoscapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscapp.R
import com.example.horoscapp.domain.model.HoroscopeModel

class HoroscopeAdapter (private var horoscopeList:List<HoroscopeModel> = emptyList(), private val onItemSelected:(horoscopeSign:HoroscopeModel)->Unit) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope_sign,parent,false)
        )
    }

    override fun getItemCount()=horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position],onItemSelected);
    }

    fun updateList(horoscope:List<HoroscopeModel>){
        horoscopeList=horoscope
        notifyDataSetChanged()
    }

}