package com.android.boilerplate.config

enum class Screen {
    Splash,
    BreedList,
    BreedDetail
}
 fun Screen.routeName():String{
     return when(this){
         Screen.Splash -> "splash"
         Screen.BreedList -> "breed-list"
         Screen.BreedDetail -> "breed-detail/{id}"
     }
 }

fun Screen.createRoute(params:Any?=null):String{
    return when(this){
        Screen.Splash -> "splash"
        Screen.BreedList -> "breed-list"
        Screen.BreedDetail -> "breed-detail/${params}"
    }
}