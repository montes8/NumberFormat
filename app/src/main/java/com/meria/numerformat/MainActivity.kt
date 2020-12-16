package com.meria.numerformat

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.text.NumberFormat.FRACTION_FIELD
import java.text.NumberFormat.INTEGER_FIELD
import java.util.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    lateinit var number : NumberFormat



    //se encarga de imprimir el numero en formato moneda del pais asignado
    //var number : NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "pe"))


    //se encarga de imprimir el numero en formato entero sin decimales
    //var number : NumberFormat = NumberFormat.getNumberInstance()


    //se encarga de imprimir el numero en formato de porcentaje
    //var number : NumberFormat = NumberFormat.getPercentInstance()
    //number  = NumberFormat.getIntegerInstance()




    //var number : NumberFormat = NumberFormat.getInstance(Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initOnClick()
       // define el maximo de decimales
       // number.setMaximumFractionDigits(2);
        // define el minimo de decimales
       // number.setMinimumFractionDigits(2);
        //number.maximumIntegerDigits= 4
        var nu = 10.50

        var po = 10
        editNumber.setText(nu.toString())
    }


    private fun setConverterNumber(number:String){
        editNumberConverter.setText(number)

    }

    private fun initOnClick(){
        btnSoles.setOnClickListener(this)
        btnDolar.setOnClickListener(this)
        btnYen.setOnClickListener(this)
        btnDecimal.setOnClickListener(this)
        btnMinOne.setOnClickListener(this)
        btnMintwo.setOnClickListener(this)
        btnRegionalFrance.setOnClickListener(this)
        btnRegionalUsa.setOnClickListener(this)
        btnTypeFormater.setOnClickListener(this)
        btnPorcentaje.setOnClickListener(this)
        btnBigDecimal.setOnClickListener(this)
        btnSumaThree.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id?:return){
            R.id.btnSoles->{
                number = NumberFormat.getCurrencyInstance(Locale("es", "pe"))
                setConverterNumber(number.format(editNumber.text.toString().toDouble()))
            }
            R.id.btnDolar->{
                number = NumberFormat.getCurrencyInstance(Locale.US)
                setConverterNumber(number.format(editNumber.text.toString().toDouble()))
            }
            R.id.btnYen->{
                number = NumberFormat.getCurrencyInstance(Locale.CHINA)
                setConverterNumber(number.format(editNumber.text.toString().toDouble()))
            }
            R.id.btnDecimal->{
                number  = NumberFormat.getNumberInstance()
                setConverterNumber(number.format(editNumber.text.toString().toDouble()))
            }
            R.id.btnMinOne->{
                number  = NumberFormat.getNumberInstance()
                number.minimumFractionDigits = 1
                setConverterNumber(number.format(editNumber.text.toString().toDouble()))

            }
            R.id.btnMintwo->{
                number  = NumberFormat.getNumberInstance()
                number.minimumFractionDigits = 2
                setConverterNumber(number.format(editNumber.text.toString().toDouble()))
            }
            R.id.btnRegionalFrance->{
                number   = NumberFormat.getInstance(Locale.FRANCE)
                setConverterNumber(number.format(editNumber.text.toString().toDouble()))
            }
            R.id.btnRegionalUsa->{
                number   = NumberFormat.getInstance(Locale.US)
                setConverterNumber(number.format(editNumber.text.toString().toDouble()))
            }


            R.id.btnTypeFormater->{
                txtType.text = "simbolo :${number.currency.symbol}\n nombre:${number.currency.displayName}\n objeto: ${number.currency}"
            }


            R.id.btnBigDecimal->{
                number = NumberFormat.getInstance()
                setConverterNumber(number.format(editNumber.text.toString().toBigDecimal()))
            }

            R.id.btnPorcentaje->{
                number = NumberFormat.getPercentInstance()
                setConverterNumber(number.format(0.5))

            }
            R.id.btnSumaThree->{
                val a = editNumber.text.toString().toDouble()
                val suma = a +a + a
                number = NumberFormat.getCurrencyInstance(Locale("es", "pe"))
                setConverterNumber(number.format(suma))
            }

        }
    }

}