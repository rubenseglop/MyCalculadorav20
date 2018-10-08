package com.example.ruben.mycalculadorav20

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var acarreo_numero: String = ""
    private var operacion: Int = 0
    private var resultado: Double = 0.0
    private var resultadohex: Double = 0.0
    private var memoria: Double = 0.0
    private var punto: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun numero(v: View) {
        val numero = findViewById<Button>(v.id)

        if (acarreo_numero.length < 8) {
            acarreo_numero = acarreo_numero + numero.text.toString()
        }
        imprime_pantalla.setText(acarreo_numero)
    }


    fun punto(v: View) {
        if (punto == false) {
            punto = true
            acarreo_numero = acarreo_numero + "."
        }
    }

    fun mmas(v: View) {
        memoria += imprime_pantalla.getText().toString().toDouble()

    }

    fun mmashex(v: View) {

        memoria += imprime_pantalla.getText().toString().toLong(radix = 16).toDouble()

    }

    fun mrc(v: View) {

        imprime_pantalla.setText(memoria.toString())
        if (memoria.toString().substring(memoria.toString().length - 2, memoria.toString().length).equals(".0")) {
            imprime_pantalla.setText(memoria.toString().substring(0, memoria.toString().length - 2))
        } else {
            imprime_pantalla.setText(memoria.toString())
        }
    }

    fun mrchex(v: View) {

        imprime_pantalla.setText(memoria.toString())
        if (memoria.toString().substring(memoria.toString().length - 2, memoria.toString().length).equals(".0")) {
            imprime_pantalla.setText(memoria.toString().substring(0, memoria.toString().length - 2))
        } else {
            imprime_pantalla.setText(memoria.toString())
        }
        acarreo_numero = ""
        convierte(memoria.toInt().toString())

    }


    fun mc(v: View) {
        memoria = 0.0
    }

    fun mas(v: View) {

        punto = false
        acarreo_numero = ""
        operacion = 1
        resultado = imprime_pantalla.getText().toString().toDouble() + resultado

    }

    fun rest(v: View) {

        punto = false
        acarreo_numero = ""
        operacion = 2
        resultado = imprime_pantalla.getText().toString().toDouble() - resultado
    }

    fun mult(v: View) {
        punto = false
        acarreo_numero = ""
        operacion = 3
        if (resultado != 0.0) {
            resultado = imprime_pantalla.getText().toString().toDouble() * resultado
        } else {
            resultado = imprime_pantalla.getText().toString().toDouble()
        }


    }

    fun divi(v: View) {
        punto = false
        acarreo_numero = ""
        operacion = 4
        if (resultado != 0.0) {
            resultado = resultado / imprime_pantalla.getText().toString().toDouble()
        } else {
            resultado = imprime_pantalla.getText().toString().toDouble()
        }
    }

    fun clear(v: View) {
        resultado = 0.0

        punto = false
        if (resultado.toString().substring(resultado.toString().length - 2, resultado.toString().length).equals(".0")) {
            imprime_pantalla.setText(resultado.toString().substring(0, resultado.toString().length - 2))
        } else {
            imprime_pantalla.setText(resultado.toString())
        }
        acarreo_numero=""
    }

    fun clearmax(v: View) {

        resultado = 0.0
        if (resultado.toString().substring(resultado.toString().length - 2, resultado.toString().length).equals(".0")) {
            imprime_pantalla.setText(resultado.toString().substring(0, resultado.toString().length - 2))
        } else {
            imprime_pantalla.setText(resultado.toString())
        }

        acarreo_numero=""
    }

    fun igualdecimal(v: View) {
        acarreo_numero = ""
        punto = false


        if (operacion === 1) {
            resultado = imprime_pantalla.getText().toString().toDouble() + resultado

        }
        if (operacion === 2) {
            resultado = resultado - imprime_pantalla.getText().toString().toDouble()

        }
        if (operacion === 3) {
            resultado = imprime_pantalla.getText().toString().toDouble() * resultado

        }
        if (operacion === 4) {
            try {
                resultado = resultado / imprime_pantalla.getText().toString().toDouble()
                imprime_pantalla.setText(resultado.toString())
            } catch (e: Exception) {
                imprime_pantalla.setText("DIV TO ZERO")
            }


        }
        if (resultado.toString().substring(resultado.toString().length - 2, resultado.toString().length).equals(".0")) {
            imprime_pantalla.setText(resultado.toString().substring(0, resultado.toString().length - 2))
        } else {
            imprime_pantalla.setText(resultado.toString())
        }

        resultado = 0.0

    }


// HEX


    fun mashex(v: View) {
        resultadohex = imprime_pantalla.getText().toString().toLong(radix = 16).toDouble()
        //imprime_pantalla.setText("0");
        acarreo_numero = ""
        operacion = 1;

    }

    fun resthex(v: View) {
        resultadohex = imprime_pantalla.getText().toString().toLong(radix = 16).toDouble()
        //imprime_pantalla.setText("0");
        acarreo_numero = ""
        operacion = 2;
    }

    fun multhex(v: View) {
        resultadohex = imprime_pantalla.getText().toString().toLong(radix = 16).toDouble()
        //imprime_pantalla.setText("0");
        acarreo_numero = ""
        operacion = 3;
    }

    fun divihex(v: View) {
        resultadohex = imprime_pantalla.getText().toString().toLong(radix = 16).toDouble()
        //imprime_pantalla.setText("0");
        acarreo_numero = ""
        operacion = 4;

    }

    fun igualhexadecimal(v: View) {
        acarreo_numero = ""
        try {
            if (operacion === 1) {
                resultadohex = resultadohex + imprime_pantalla.getText().toString().toLong(radix = 16)
                convierte(resultadohex.toInt().toString())
            }
            if (operacion === 2) {
                resultadohex = resultadohex - imprime_pantalla.getText().toString().toLong(radix = 16)
                convierte(resultadohex.toInt().toString())
            }
            if (operacion === 3) {
                resultadohex = resultadohex * imprime_pantalla.getText().toString().toLong(radix = 16)
                convierte(resultadohex.toInt().toString())
            }
            if (operacion === 4) {
                resultadohex = resultadohex / imprime_pantalla.getText().toString().toLong(radix = 16)
                convierte(resultadohex.toInt().toString())
            }
        } catch (e: Exception) {
            imprime_pantalla.setText("DIV TO ZERO")
        }
    }

    fun convierte(decimal: String) {
        val hexString = java.lang.Integer.toHexString(decimal.toInt()).toUpperCase()
        imprime_pantalla.setText(hexString)
    }
}