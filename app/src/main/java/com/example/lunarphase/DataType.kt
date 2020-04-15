package com.example.lunarphase

enum class DataType {
    Data("data");

    private val dataName: String

    constructor(dataName: String) {
        this.dataName = dataName
    }

    override fun toString(): String {
        return dataName
    }


}