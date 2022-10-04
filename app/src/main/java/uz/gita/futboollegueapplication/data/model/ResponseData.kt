package uz.gita.futboollegueapplication.data.model

data class ResponseData<T>(
    var status :Boolean,
    val data : T
)
