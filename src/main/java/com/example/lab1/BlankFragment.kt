package com.example.lab1

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import com.example.lab1.databinding.Fragment1Binding

class BlankFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.button4.setOnClickListener {
            val checkedRadioButtonId = binding.radioGroup.checkedRadioButtonId
            val checkedRadioButton2Id = binding.radioGroup2.checkedRadioButtonId
            var selectedRadioButton: String
            var selectedRadioButton2: String

            when (checkedRadioButtonId or checkedRadioButton2Id) {
                -1 -> dataModel.message.value = "Ничего не выбрано"
                else -> {
                    val numbers: Array<RadioButton> = arrayOf(
                        binding.radioBlue,
                        binding.radioGreen,
                        binding.radioGray,
                        binding.radioRed
                    )

                    val numbers2: Array<RadioButton> = arrayOf(
                        binding.group,
                        binding.group92,
                        binding.group93,
                        binding.group94
                    )


                    for (n in numbers) {
                        for (m in numbers2) {
                            if (n.id == checkedRadioButtonId) {
                                if (m.id == checkedRadioButton2Id) {
                                    selectedRadioButton = n.text.toString()
                                    selectedRadioButton2 = m.text.toString()
                                    dataModel.message.value =
                                        "$selectedRadioButton $selectedRadioButton2"

                                }
                            }
                        }
                    }


                }
            }
        }
    }

    companion object {
        fun newInstance() = BlankFragment()
    }
}
