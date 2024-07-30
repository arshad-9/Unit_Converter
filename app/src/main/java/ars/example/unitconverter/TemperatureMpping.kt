package ars.example.unitconverter

object TemperatureMpping {
    private val TemperatureUnitList = arrayListOf("Celsius","Fahrenheit","Kelvin")



    private  fun convertToCelcius(type :String,value:Double):Double{
       var x=0.0
        if( type =="Celsius"){x= value}
        else if(type  =="Fahrenheit"){
            val y =value-32.0
            x= 0.555556 * y }
        else if(type =="Kelvin"){
            x=value-273.15 }

        return x
    }
    fun convert( from :String ,to :String ,value :Double ):Double {
        val from_To_Metre = convertToCelcius(from,value)

        var ans=0.0
        if (to == "Celsius")
        {
            ans = from_To_Metre
        }
        else if(to =="Fahrenheit"){
           val y = 1.8 *from_To_Metre
           ans =  y + 32.0
        }
        else if(to == "Kelvin"){
            ans  =  from_To_Metre + 273.15
        }
        return ans
    }

    fun getList():ArrayList<String>{
        return TemperatureUnitList
    }
}