package my.anna.helloworld

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Handle user interactions
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Show the activity_main.xml layout file
        setContentView(R.layout.activity_main)

        // Get reference to text views
        val editText: EditText = findViewById(R.id.editText)
        val textView: TextView = findViewById(R.id.textView)

        // Pass references to context to ColorManager
        val colorManager = ColorManager(this)

        // Tap on a button changes text, background and buttons colors
        findViewById<Button>(R.id.buttonChangeColor).setOnClickListener {
            Log.i("MyAppLog", "Tapped on change color button")

            editText.hideKeyboard()

            colorManager.changeColors()
        }


        // Tap on a button changes label text to user-entered text,
        // or to default android greeting if there is no input.
        findViewById<Button>(R.id.buttonChangeText).setOnClickListener {

            Log.i("MyAppLog", "Tapped on change text button")

            editText.hideKeyboard()

            // Greet Android
            if (editText.text.isBlank()) {
                textView.setText(R.string.greeting_android)
                return@setOnClickListener
            }

            // Show custom text
            textView.text = editText.text
            editText.setText("")
            editText.clearFocus()
            editText.setHint(R.string.hint_greeting)

        }


        // Tap on the background resets all views to default settings
        findViewById<View>(R.id.backgroundView).setOnClickListener{

            Log.i("MyAppLog", "Tapped on the background")

            colorManager.setDefaultColors()

            textView.setText(R.string.greeting_default)

            // Release focus from the editText view
            editText.setText("")
            editText.isFocusableInTouchMode = false
            editText.isFocusable = false
            editText.isFocusableInTouchMode = true
            editText.isFocusable = true

            editText.hideKeyboard()
        }
    }


    fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

}