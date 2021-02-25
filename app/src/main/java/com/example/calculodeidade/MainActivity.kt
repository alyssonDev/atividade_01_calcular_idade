package com.example.calculodeidade

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val anoAtual = Calendar.getInstance().get(Calendar.YEAR)

        btn_efetuar_calculo.setOnClickListener {
            it.hideKeyboard()
            if (edt_ano_nascimento.text.isNotEmpty()) {
                txv_resultado.visibility = VISIBLE
                txv_resultado.text = (String.format(
                    getString(R.string.txv_resultado),
                    anoAtual - edt_ano_nascimento.text!!.toString().toInt()
                ))
            } else {
                txv_resultado.visibility = GONE
                Toast.makeText(this, getString(R.string.toast_mensagem), Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun View.hideKeyboard() {
        val inputManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}