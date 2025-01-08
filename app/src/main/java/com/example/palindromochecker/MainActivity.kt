package com.example.palindromochecker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Change status bar color
        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)

        //Word Input
        val wordInput : EditText = findViewById(R.id.word_input)

        //On Click Button Checker
        val buttonChecker : Button = findViewById(R.id.check_button)
        buttonChecker.setOnClickListener { palindromoCheck(wordInput.text.toString()) }

        //Reload Button
        val reloadButton : Button = findViewById(R.id.reload_button)
        reloadButton.setOnClickListener { reloadCheck() }

    }


        //Palíndromo function
        fun palindromoCheck(p : String) : Boolean{

            var result : Boolean

            if (p.equals(p.reversed())){
                result = true
            } else {
                result = false
            }


            //Variables
            val buttonCheckerView : Button = findViewById<Button>(R.id.check_button)
            val wordInputView : EditText = findViewById<EditText>(R.id.word_input)
            val checkResultView : LinearLayout = findViewById<LinearLayout>(R.id.check_result)
            val wordInputResult : TextView = findViewById<TextView>(R.id.word_input_result)
            val textCheckResult : TextView = findViewById<TextView>(R.id.text_check_result)

            //Hide Views
            buttonCheckerView.visibility = View.GONE
            wordInputView.visibility = View.GONE

            //Show view Result
            checkResultView.visibility = View.VISIBLE

            //Word Input = Word Result
            wordInputResult.text = wordInputView.text



            if(result == true){
                textCheckResult.text = "Es un palíndromo"
                textCheckResult.setTextColor(getResources().getColor(R.color.green))
            } else {
                textCheckResult.text = "No es un palíndromo"
                textCheckResult.setTextColor(getResources().getColor(R.color.red))
            }



            return result

        }


        //Reload function
        fun reloadCheck(){


            //Variables
            val buttonCheckerView : Button = findViewById<Button>(R.id.check_button)
            val wordInputView : EditText = findViewById<EditText>(R.id.word_input)
            val checkResultView : LinearLayout = findViewById<LinearLayout>(R.id.check_result)


            //Show Views
            buttonCheckerView.visibility = View.VISIBLE
            wordInputView.visibility = View.VISIBLE

            //Hide view Result
            checkResultView.visibility = View.GONE

            //Word Input Clear
            wordInputView.text.clear()


        }




}