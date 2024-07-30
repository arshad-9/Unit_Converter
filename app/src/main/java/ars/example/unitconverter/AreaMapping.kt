package ars.example.unitconverter

object AreaMapping {

    private val areaUnitList= arrayListOf("Square Kilometre", "Square Metre", "Square Mile",
        "Square Foot", "Square Yard", "Square Inch", "Hectare", "Acre")
    private fun ConvertIntSqMetre( type:String):Double{

        if( type == "Square Kilometre"){return 1000000.0}
        if( type == "Square Metre"){return 1.0}
        if( type == "Square Mile"){return 2590000.0}
        if( type == "Square Foot"){return 0.0929029999996671}
        if( type == "Square Yard"){return 0.836127}
        if( type == "Square Inch"){return 0.0006452}
        if( type == "Hectare"){return 9999.9956944}
        if( type == "Acre"){return 4046.85468}
        return 0.0

    }

    fun convert(from :String ,to :String,value :Double):Double{
        val from_in_sqmetre = ConvertIntSqMetre(from)
        val to_in_sqmetre = ConvertIntSqMetre(to)

        return (from_in_sqmetre * value)/to_in_sqmetre
    }
    fun getList():ArrayList<String>{ return areaUnitList }
}