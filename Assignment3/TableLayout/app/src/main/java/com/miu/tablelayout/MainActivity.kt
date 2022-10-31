package com.miu.tablelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener {
            val tableRow = TableRow(applicationContext)

            val layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 24, 0, 0)
            tableRow.layoutParams = layoutParams

            val versionTextView = TextView(applicationContext)
            versionTextView.text = version.text.toString()
            versionTextView.textSize = 16f
            tableRow.addView(versionTextView)

            val codeTextView = TextView(applicationContext)
            codeTextView.text = codeName.text.toString()
            codeTextView.textSize = 16f
            tableRow.addView(codeTextView)

            tableLayout.addView(tableRow, layoutParams)

            version.text.clear()
            codeName.text.clear()
            codeName.clearFocus()
        }

        }
}


