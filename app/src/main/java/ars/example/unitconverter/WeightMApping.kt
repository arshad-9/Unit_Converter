package ars.example.unitconverter

object WeightMApping {


   private val weightUnitList = arrayListOf("Kilogram", "Gram", "Milligram", "Pound", "Once","Tonne","Stone")
   private  fun convertToGram(type :String ):Double{
        if( type == "Kilogram"){return 1000.0}
        if(type == "Gram"){return 1.0}
        if(type == "Milligram"){return 0.001}
        if(type == "Pound"){ return 450.0}
        if( type  == "Once"){return 28.3495}
        if (type == "Tonne"){return 1000000.0}
       if(type == "Stone"){return 6350.29}
        return 0.0
    }
    fun convert( from :String ,to:String,value :Double):Double{

        val from_Grams = convertToGram(from)
        val to_Grams = convertToGram(to)

        return (from_Grams * value)/to_Grams
    }
    fun getList():ArrayList<String>
    { return weightUnitList }

}