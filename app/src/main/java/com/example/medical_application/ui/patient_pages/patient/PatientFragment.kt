package com.example.medical_application.ui.patient_pages.patient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.medical_application.MyApp
import com.example.medical_application.R
import com.example.medical_application.ui.MainActivity
import com.example.medical_application.ui.Screens
import moxy.MvpAppCompatFragment


class PatientFragment :  MvpAppCompatFragment() {
    lateinit var mCalender: CalendarView
    lateinit var mDateTxt: TextView
    lateinit var mAddNoteBtn: AppCompatButton
    lateinit var mDefTxt: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        MyApp.INSTANCE.mAppComponent.inject(this)

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_patient, container, false)
        initView(view)
        return view
    }

    fun initView(view: View) {
        view.apply {
            mCalender = findViewById(R.id.calendarView)
            mDateTxt = findViewById(R.id.DateTextView)
            mAddNoteBtn = findViewById(R.id.add_note_button)
            mDefTxt = findViewById(R.id.defaultTextView)
        }

        mCalender.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"

            mDateTxt.text = date

            val temple = "24/11/2022"
            if (temple == date) {
                mDefTxt.text = "message"
            }
            else {
                mDefTxt.text = "Записи за этот день отсутствуют"
            }
        }

        mAddNoteBtn.setOnClickListener {
            MainActivity.INSTANCE.router.navigateTo(Screens.AddNoteScreen())
        }


    }

}