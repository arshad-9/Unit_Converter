package ars.example.unitconverter

object volumeMapping {
    private val VolumeUnitList = arrayListOf("Liter", "Milliliter", "Cubic Meter","Cubic Inch",
        "Cubic Centimeter","US Gallon", "US Tablespoon", "US Teaspoon")



    private  fun convertToLeter(type :String):Double{

        if( type =="Milliliter"){return 0.001}
        if(type  =="Liter"){return 1.0 }
        if(type =="Cubic Meter"){return 1000.0 }
        if(type=="Cubic Inch"){return 0.0163871}
        if( type=="Cubic Centimeter"){return 0.001}
        if(type == "US Gallon"){return 3.78541}
        if(type =="US Tablespoon"){return 0.0147868}
        if(type== "US Teaspoon"){return 0.00492892}

        return 0.0
    }
    fun convert( from :String ,to :String ,value :Double ):Double {
        val from_To_Metre = convertToLeter(from)
        val to_To_Metre = convertToLeter(to)

        return (from_To_Metre * value )/to_To_Metre
    }

    fun getList():ArrayList<String>{
        return VolumeUnitList
    }
}