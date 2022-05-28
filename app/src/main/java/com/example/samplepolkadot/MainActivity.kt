package com.example.samplepolkadot

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.lib.polkalib.PolkaUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import android.provider.MediaStore

import android.R.attr.mimeType
import android.content.ContentResolver

import android.content.ContentValues
import android.net.Uri


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}
