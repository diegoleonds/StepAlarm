package com.example.stepalarm.view.model

data class Schedule(
    val hour: String,
    var minute: String
) {
    override fun toString(): String = "${hour}:${minute}"
}