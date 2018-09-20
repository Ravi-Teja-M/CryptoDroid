
package com.example.rmaddali.icryptodroid.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.rmaddali.icryptodroid.R
import com.example.rmaddali.icryptodroid.ui.adapters.OnListItemClicked

class Dashboard : AppCompatActivity() , OnListItemClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    override fun onItemClicked(viewGroup: View, position: Int) {



     }
}
