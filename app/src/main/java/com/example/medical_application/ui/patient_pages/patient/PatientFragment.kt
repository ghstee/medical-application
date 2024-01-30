package com.example.medical_application.ui.patient_pages.patient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import com.example.medical_application.MyApp
import com.example.medical_application.R
import moxy.MvpAppCompatFragment


class PatientFragment :  MvpAppCompatFragment() {
    lateinit var mCalender: CalendarView
    lateinit var mDateTxt: TextView


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
        }

        mCalender.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"

            mDateTxt.text = date
        }


    }

}