package dev.amekwi.calculator_revision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.amekwi.calculator_revision.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
    }
    fun castView() {

        handleClicks()
    }
    fun handleClicks(){

        binding.btnadd.setOnClickListener { add(obtainInputs())}

        binding.btnsubtract.setOnClickListener { subtract(obtainInputs())}

        binding.btnmodulus.setOnClickListener { division(obtainInputs())}

        binding.btndivision.setOnClickListener { modulus( obtainInputs())}

    }
    data class  Inputs(var num1:Double, var num2:Double)
    fun obtainInputs():Inputs?{
        var num1=binding.etnumone.text.toString()
        var num2=binding.etnumtwo.text.toString()
        var error=false

        if (num1.isBlank()){
            binding.tilnumone.error="Enter number 1"
            error=true
        }
        if (num2.isBlank()){
            binding.tilnumtwo.error="Enter number 2"
            error=true
        }
        if(!error) {
            return Inputs(num1.toDouble(), num2.toDouble())
        }
        return null
    }
    fun add(inputs:Inputs?){
        if(inputs!=null){
            val result=inputs.num1+inputs.num2
            displayresult(result)}
    }
    fun subtract(inputs:Inputs?){
        if(inputs!=null){
            val result=inputs.num1 -inputs.num2
            displayresult(result)}
    }
    fun division(inputs:Inputs?){
        if(inputs!=null) {
            val result = inputs.num1 / inputs.num2
            displayresult(result) }
    }
    fun modulus(inputs: Inputs?){
        if(inputs!=null){
            val result= inputs.num1 % inputs.num2
            displayresult(result)}
    }
    fun displayresult(result:Double){
        binding.tvanswer.text=result.toString()
    }
}
