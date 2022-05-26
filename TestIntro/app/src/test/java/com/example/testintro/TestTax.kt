package com.example.testintro

import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class TestTax {

    private lateinit var tax : Tax

    //Test başlamadan neler yapılacağını yazıyoruz bir nevi onCreate
    @Before
    fun setup(){
        tax = Tax()
    }

    //Test bittikten sonra neler yapılacağını yazıyoruz
    @After
    fun teardown(){

    }

    //@Test
    //fun `brut maasin 10 lira oldugu durumunda vsvs`(){}
    //bu şekilde de fonksiyon ismi yazılabilir

    @Test
    fun calculateTaxTest(){
        //val tax = Tax()
        val netTax = tax.calculateTax(100.0,0.1)

        assertThat(netTax).isEqualTo(10)
        //10'a eşit mi? değilse hata ver
    }

    @Test
    fun calculateIncomeTest(){
        //val tax = Tax()
        val netIncome = tax.calculateIncome(100.0,0.1)

        assertThat(netIncome).isEqualTo(90)
    }
}