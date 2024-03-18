package com.example.horoscapp.data.provider

import com.example.horoscapp.domain.model.HoroscopeModel
import com.example.horoscapp.domain.model.HoroscopeModel.*
import javax.inject.Inject


class HoroscopeProvider @Inject constructor(){

     fun getHoroscope():List<HoroscopeModel>{
         return listOf(
             Aries,Taurus,Gemini,Cancer,Leo,Virgo,Libra,Scorpio,Sagittarius,Capricorn,Aquarius,Pisces
         )
     }

}