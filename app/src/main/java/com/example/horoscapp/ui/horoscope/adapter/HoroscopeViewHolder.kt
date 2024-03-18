package com.example.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscapp.databinding.ItemHoroscopeSignBinding
import com.example.horoscapp.domain.model.HoroscopeModel

class HoroscopeViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private  val binding = ItemHoroscopeSignBinding.bind(view)

    fun render(horoscopeSign:HoroscopeModel, onItemSelected:(HoroscopeModel)-> Unit){
        binding.itemHoroscopeSignImg.setImageResource(horoscopeSign.img)
        binding.itemHoroscopeSignText.setText(horoscopeSign.name)
        //binding.itemHoroscopeSignText.text=binding.itemHoroscopeSignText.context.getString(horoscopeSign.name)

        binding.itemSignParent.setOnClickListener{
            startRotationAnimation(binding.itemHoroscopeSignImg, newLambda = {onItemSelected(horoscopeSign)})
        }
    }


    private fun startRotationAnimation(view: View,newLambda:()->Unit){
        view.animate().apply {
            duration =500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{ newLambda() }
            start()

        }
    }

}