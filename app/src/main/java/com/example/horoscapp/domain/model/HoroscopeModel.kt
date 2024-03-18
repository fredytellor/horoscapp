package com.example.horoscapp.domain.model

import com.example.horoscapp.R

sealed class HoroscopeModel(val name:Int, val img:Int){
    object Aries: HoroscopeModel(R.string.aries,R.drawable.aries)
    object Aquarius: HoroscopeModel(R.string.aquarius,R.drawable.aquarus)
    object Taurus: HoroscopeModel(R.string.taurus,R.drawable.taurus)
    object Gemini: HoroscopeModel(R.string.gemini,R.drawable.gemini)
    object Cancer: HoroscopeModel(R.string.cancer,R.drawable.cancer)
    object Libra: HoroscopeModel(R.string.libra,R.drawable.libra)
    object Leo: HoroscopeModel(R.string.leo,R.drawable.leo)
    object Virgo: HoroscopeModel(R.string.virgo,R.drawable.virgo)
    object Scorpio: HoroscopeModel(R.string.scorpio,R.drawable.scorpio)
    object Sagittarius: HoroscopeModel(R.string.sagittarius,R.drawable.sagittarius)
    object Capricorn: HoroscopeModel(R.string.capricorn,R.drawable.capricorn)
    object Pisces: HoroscopeModel(R.string.pisces,R.drawable.pisces)
}