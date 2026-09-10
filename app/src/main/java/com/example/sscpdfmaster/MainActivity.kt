package com.example.sscpdfmaster

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun showHome() {

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(24, 35, 24, 24)
        root.setBackgroundColor(Color.WHITE)

        val title = TextView(this)
        title.text = "📚\nSSC PDF MASTER"
        title.textSize = 28f
        title.setTextColor(Color.rgb(20, 60, 110))
        title.typeface = Typeface.DEFAULT_BOLD
        title.gravity = Gravity.CENTER
        title.setPadding(0, 0, 0, 30)

        root.addView(
            title,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        val grid = GridLayout(this)
        grid.columnCount = 2
        grid.rowCount = 2

        addSubject(grid, "E", "English")
        addSubject(grid, "GS", "GS / GK")
        addSubject(grid, "R", "Reasoning")
        addSubject(grid, "M", "Maths")

        root.addView(
            grid,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        setContentView(root)
    }

    private fun addSubject(
        grid: GridLayout,
        code: String,
        name: String
    ) {

        val button = Button(this)

        button.text = "$code\n$name"
        button.textSize = 18f
        button.setAllCaps(false)

        button.setOnClickListener {
            showSubject(code, name)
        }

        val params = GridLayout.LayoutParams()
        params.width = 0
        params.height = 220
        params.columnSpec = GridLayout.spec(
            GridLayout.UNDEFINED,
            1f
        )
        params.setMargins(8, 8, 8, 8)

        grid.addView(button, params)
    }

    private fun showSubject(code: String, name: String) {

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(24, 30, 24, 24)

        val title = TextView(this)
        title.text = "$code — $name"
        title.textSize = 26f
        title.typeface = Typeface.DEFAULT_BOLD
        title.setTextColor(Color.rgb(20, 60, 110))

        layout.addView(title)

        val info = TextView(this)
        info.text = "\nChapter-wise PDFs\n\nअभी यहाँ chapters और PDFs जोड़े जा सकते हैं।"
        info.textSize = 18f

        layout.addView(info)

        val addButton = Button(this)
        addButton.text = "+ Add PDF"
        addButton.setOnClickListener {
            Toast.makeText(
                this,
                "PDF selection अगले version में जोड़ी जाएगी",
                Toast.LENGTH_SHORT
            ).show()
        }

        layout.addView(addButton)

        val backButton = Button(this)
        backButton.text = "← Home"
        backButton.setOnClickListener {
            showHome()
        }

        layout.addView(backButton)

        setContentView(layout)
    }
}
