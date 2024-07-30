package ars.example.unitconverter

import android.util.Log
import kotlin.math.abs
import kotlin.math.pow

object LengthMapping {

    private val lengthUnitList = arrayListOf("Kilometre","Hectometre","Decametre","Metre",
        "Decimetre","Centimetre","MiliMeter","Inch","Foot","Yard","Mile")

    private  fun convertToMetre(type :String):Double{

        if( type =="Kilometre"){return 1000.0}
        if(type  =="Hectometre"){return 100.0 }
        if(type =="Decametre"){return 10.0 }
        if(type =="Metre"){return 1.0 }
        if(type =="Decimetre"){return 0.1 }
        if(type =="Centimetre"){return 0.01 }
        if(type =="MilliMeter"){return 0.001}
        if(type =="Inch"){return 0.0254}
        if(type =="Foot"){return 0.3048}
        if(type =="Yard"){return 0.9144}
        if(type =="Mile" ){return 1609.34}

        return 0.0
    }
     fun convert( from :String ,to :String ,value :Double ):Double {
         val from_To_Metre = convertToMetre(from)
         val to_To_Metre = convertToMetre(to)

         return (from_To_Metre * value )/to_To_Metre
     }

    fun getList():ArrayList<String>{
        return lengthUnitList
    }



}