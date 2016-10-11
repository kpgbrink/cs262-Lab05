package edu.calvin.kpb23students.lab05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

/** This test preferences
 *
 * For use as CS 262, Lab 5
 *
 * @author Kristofer
 * @version Fall, 2016
 */

public class MainActivity extends AppCompatActivity {

    // class variables
    private TextView pref;
    private SharedPreferences prefs;
    private boolean testPreference = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Get preferences
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        init();
    }

    // set up pref text
    private void init(){
        pref = (TextView)findViewById(R.id.preference);
        testPreference = prefs.getBoolean("testPreference", true);
        setPrefText(testPreference);
    }

    // Sets text of preference
    private void setPrefText(boolean prefTrue) {
        if (prefTrue) {
            pref.setText("True");
        } else {
            pref.setText("False");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(this, Settings.class);
            startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        testPreference = prefs.getBoolean("testPreference", true);
        setPrefText(testPreference);
    }
}
