package com.example.calculadora

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.example.calculadora.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(),  View.OnClickListener {

    private var shared_pref: String = "com.example.app"
    private var number_key = "number"
    private lateinit var binding: ActivityMainBinding
    private var num1:Long = 0
    private var num2:Long = 0
    private lateinit var operator:String
    private lateinit var sharedP: SharedPreferences
    private lateinit var number: String





    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedP = getSharedPreferences(shared_pref, Context.MODE_PRIVATE)
        number = sharedP.getString(number_key, "0").toString()
        binding.numero.text = number


        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.button0.setOnClickListener(this)
        binding.buttonC.setOnClickListener(this)
        binding.buttonBorrar.setOnClickListener(this)
        binding.buttonSumar.setOnClickListener(this)
        binding.buttonMenos.setOnClickListener(this)
        binding.buttonMultiplicar.setOnClickListener(this)
        binding.buttonDividir.setOnClickListener(this)
        binding.buttonIgual.setOnClickListener(this)
        binding.buttonRaiz?.setOnClickListener(this)
        binding.buttonExponente?.setOnClickListener(this)
        binding.buttonPorcentaje?.setOnClickListener(this)



        




    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when(v?.id){
            binding.button1.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button2.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button3.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button4.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button5.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button6.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button7.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button8.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button9.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.button0.id->{
                if(binding.numero.text.toString() != "0") {
                    binding.numero.append((v as Button).text)
                }else{
                    binding.numero.text = (v as Button).text
                }
                saveData()
            }
            binding.buttonC.id->{
                binding.numero.text = "0"
                saveData()
            }
            binding.buttonBorrar.id->{
                if(binding.numero.text.toString() != "" && binding.numero.text.toString() != "0") {
                    binding.numero.text = binding.numero.text.substring(0, binding.numero.text.length - 1)
                }else {
                    binding.numero.text = "0"
                }
                saveData()
            }
            binding.buttonSumar.id->{
                if(!flagOperador()){
                binding.numero.append("+")
                }
                saveData()
            }
            binding.buttonMenos.id->{
                if(!flagOperador()){
                    binding.numero.append("-")
                }
                saveData()
            }
            binding.buttonMultiplicar.id->{
                if(!flagOperador()){
                    binding.numero.append("x")
                }
                saveData()
            }
            binding.buttonDividir.id->{
                if(!flagOperador()){
                    binding.numero.append("/")
                }
                saveData()
            }
            binding.buttonRaiz?.id->{
                if(!flagOperador()){
                    binding.numero.text = "√"
                }
                saveData()
            }
            binding.buttonExponente?.id->{
                if(!flagOperador()){
                    binding.numero.append("^")
                }
                saveData()
            }
            binding.buttonPorcentaje?.id->{
                if(!flagOperador()){
                    binding.numero.append("%")
                }
            }

            binding.buttonIgual.id->{
                if(binding.numero.text.contains("+")){
                    operator = "+"
                    binding.numero.text = (getNum1(operator)+getNum2(operator)).toString()
                }
                if(binding.numero.text.contains("-")){
                    operator = "-"
                    binding.numero.text = (getNum1(operator)-getNum2(operator)).toString()
                }
                if(binding.numero.text.contains("x")){
                    operator = "x"
                    binding.numero.text = (getNum1(operator)*getNum2(operator)).toString()
                }
                if(binding.numero.text.contains("/")){
                    operator = "/"
                    binding.numero.text = (getNum1(operator)/getNum2(operator)).toString()
                }
                if(binding.numero.text.contains("√")){
                    operator = "√"
                    binding.numero.text =
                        (1*(sqrt(getNum2(operator).toDouble()))).toLong().toString()
                }
                if(binding.numero.text.contains("^")){
                    operator = "^"
                    binding.numero.text =
                        getNum1(operator).toDouble().pow(getNum2(operator).toInt()).toLong().toString()
                }
                if(binding.numero.text.contains("%")){
                    operator = "%"
                    binding.numero.text =
                        ((getNum1(operator)*getNum2(operator))/100).toString()
                }
                saveData()

            }


        }

    }
    private fun getNum1(operator:String ):Long{
        return binding.numero.text.toString().substring(0, binding.numero.text.indexOf(operator)).toLong()
    }
    private fun getNum2(operator: String):Long{
        return binding.numero.text.toString().substring(binding.numero.text.indexOf(operator)+1, binding.numero.text.length).toLong()
    }
    private fun flagOperador():Boolean{
        if(binding.numero.text.toString().contains("+")
            || binding.numero.text.toString().contains("-")
            || binding.numero.text.toString().contains("x" )
            || binding.numero.text.toString().contains("/")
            || binding.numero.text.toString().contains("√")
            || binding.numero.text.toString().contains("^")
            || binding.numero.text.toString().contains("%")){
            return true
        }
        return false
    }



    private fun saveData(){
        val sharedPrefences = getSharedPreferences(shared_pref,Context.MODE_PRIVATE)
        val editor = sharedPrefences.edit()
        editor.putString("number", binding.numero.text.toString())
        editor.commit()
    }

}




