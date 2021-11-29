package com.kyotobytes.calculatethis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import android.widget.EditText
import android.widget.Toast
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonPercentage: android.widget.Button
    lateinit var buttonClear: android.widget.Button
    lateinit var buttonDivide: android.widget.Button
    lateinit var buttonAdd: android.widget.Button
    lateinit var buttonMultiply: android.widget.Button
    lateinit var buttonSubtract: android.widget.Button
    lateinit var buttonEqual: android.widget.Button
    lateinit var buttonBackspace: android.widget.Button
    lateinit var buttonDot: android.widget.Button
    lateinit var inputText: EditText
    lateinit var resultText: EditText
    var check=0;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        assignButtons()
        var text: String

        button0.setOnClickListener{
            text=inputText.text.toString()+"0"
            inputText.setText(text)
            result(text)
        }
        button00.setOnClickListener{
            text=inputText.text.toString()+"00"
            inputText.setText(text)
            result(text)
        }
        button1.setOnClickListener{
            text=inputText.text.toString()+"1"
            inputText.setText(text)
            result(text)
        }
        button2.setOnClickListener{
            text=inputText.text.toString()+"2"
            inputText.setText(text)
            result(text)
        }
        button3.setOnClickListener{
            text=inputText.text.toString()+"3"
            inputText.setText(text)
            result(text)
        }
        button4.setOnClickListener{
            text=inputText.text.toString()+"4"
            inputText.setText(text)
            result(text)
        }
        button5.setOnClickListener{
            text=inputText.text.toString()+"5"
            inputText.setText(text)
            result(text)
        }
        button6.setOnClickListener{
            text=inputText.text.toString()+"6"
            inputText.setText(text)
            result(text)
        }
        button7.setOnClickListener{
            text=inputText.text.toString()+"7"
            inputText.setText(text)
            result(text)
        }
        button8.setOnClickListener{
            text=inputText.text.toString()+"8"
            inputText.setText(text)
            result(text)
        }
        button9.setOnClickListener{
            text=inputText.text.toString()+"9"
            inputText.setText(text)
            result(text)
        }
        buttonDot.setOnClickListener{
            text=inputText.text.toString()+"."
            inputText.setText(text)
            result(text)
        }
        buttonClear.setOnClickListener {
            inputText.setText("")
            resultText.setText((""))
            text=""
        }
        buttonAdd.setOnClickListener {
            text=inputText.text.toString()+"+"
            inputText.setText(text)
            check+=1
        }
        buttonSubtract.setOnClickListener {
            text=inputText.text.toString()+"-"
            inputText.setText(text)
            check+=1
        }
        buttonMultiply.setOnClickListener {
            text=inputText.text.toString()+"*"
            inputText.setText(text)
            check+=1
        }
        buttonDivide.setOnClickListener {
            text=inputText.text.toString()+"/"
            inputText.setText(text)
            check+=1
        }
        buttonPercentage.setOnClickListener {
            text=inputText.text.toString()+"%"
            inputText.setText(text)
            check+=1
        }
        buttonEqual.setOnClickListener {
            text=resultText.text.toString()
            inputText.setText(text)
            resultText.setText("")
        }
        buttonBackspace.setOnClickListener {
            var Backspace: String=""
            if(TextUtils.isEmpty(inputText.text.toString())){

            }else{
                val stringBuilder :StringBuilder=StringBuilder(inputText.text)
                val find=inputText.text.toString()
                val find2=find.last()
                if(find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('÷')||find2.equals('%')){
                    check-=1
                }
                stringBuilder.deleteCharAt(inputText.text.length-1)
                Backspace=stringBuilder.toString()
                inputText.setText(Backspace)
                result(Backspace)
            }
        }

    }
    fun assignButtons(){
        button0=findViewById(R.id.buttonZero)
        button00=findViewById(R.id.buttonDoubleZero)
        button1=findViewById(R.id.buttonOne)
        button2=findViewById(R.id.buttonTwo)
        button3=findViewById(R.id.buttonThree)
        button4=findViewById(R.id.buttonFour)
        button5=findViewById(R.id.buttonFive)
        button6=findViewById(R.id.buttonSix)
        button7=findViewById(R.id.buttonSeven)
        button8=findViewById(R.id.buttonEight)
        button9=findViewById(R.id.buttonNine)
        buttonPercentage=findViewById(R.id.buttonPercentage)
        buttonClear=findViewById(R.id.buttonClear)
        buttonDivide=findViewById(R.id.buttonDivide)
        buttonAdd=findViewById(R.id.buttonAdd)
        buttonMultiply=findViewById(R.id.buttonMultiply)
        buttonSubtract=findViewById(R.id.buttonSubtract)
        buttonEqual=findViewById(R.id.buttonEqual)
        buttonBackspace=findViewById(R.id.buttonBackspace)
        buttonDot=findViewById(R.id.buttonDot)
        inputText=findViewById(R.id.inputNumber)
        resultText=findViewById(R.id.result)
        inputText.movementMethod=ScrollingMovementMethod()
        inputText.setActivated(true)
        inputText.setPressed(true)
    }

    private fun result(text: String) {
        val engine: ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any=engine.eval(text)
            val mainResult=result.toString()
            if(check==0){
                resultText.setText("")
            }else{
                resultText.setText(mainResult)
            }
        }catch (e: ScriptException){
            //do nothing
            Toast.makeText(applicationContext, "an ERROR occurred!", Toast.LENGTH_LONG).show()
        }
    }
}