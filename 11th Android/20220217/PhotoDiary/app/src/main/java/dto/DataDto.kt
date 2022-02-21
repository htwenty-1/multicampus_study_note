package dto

data class DataDto(var seq:Int, var filePath:String, var location:String, var title:String?, var content:String, var reg:String){

    override fun toString(): String {
        return "$seq, $filePath', '$location', '$title', '$content', '$reg'"
    }
}