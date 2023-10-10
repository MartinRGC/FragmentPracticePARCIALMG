package com.fragmentpractice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.fragmentpractice.R




class RegistroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view: View = inflater.inflate(R.layout.fragment_registro,container,false)

        val spinner: Spinner = view.findViewById(R.id.spnCountry)
        val etFullname: EditText = view.findViewById(R.id.etFullname)
        val etEmail: EditText = view.findViewById(R.id.etemail)
        val rgGender: RadioGroup = view.findViewById(R.id.rgGender)
        val chkLicence: CheckBox = view.findViewById(R.id.chkLicence)
        val chkCar: CheckBox = view.findViewById(R.id.chkCar)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.country_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        val btnSave: Button = view.findViewById(R.id.btnSave)
        var spnCountryValue=""
        val spnCountry: Spinner = view.findViewById(R.id.spnCountry)

        spnCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                spnCountryValue = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        btnSave.setOnClickListener{
            val intSelectButton: Int = rgGender!!.checkedRadioButtonId
            val radioButton: RadioButton = view.findViewById(intSelectButton)
            val genderValue = radioButton.text
            val fullNameValue = etFullname.text
            val etEmailValue = etEmail.text

            Toast.makeText(requireContext(),"FullName:$fullNameValue",Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(),"etEmailValue:$etEmailValue",Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(),"genderValue:$genderValue",Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(),"spnCountryValue:$spnCountryValue",Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(),"chkLicence:${chkLicence.isChecked}",Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(),"chkCar:${chkCar.isChecked}",Toast.LENGTH_LONG).show()
        }

        return view
    }
}