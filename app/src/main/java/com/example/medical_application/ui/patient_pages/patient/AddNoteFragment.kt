package com.example.medical_application.ui.patient_pages.patient

import android.os.Bundle
import com.example.medical_application.MyApp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medical_application.R
import moxy.MvpAppCompatFragment

class AddNoteFragment :  MvpAppCompatFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        MyApp.INSTANCE.mAppComponent.inject(this)

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)
        initView(view)
        return view
    }

    fun initView(view: View) {
        view.apply {

        }

    }
}