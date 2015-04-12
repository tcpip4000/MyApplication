package net.ertechnology.testy;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;


public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        if (findViewById(R.id.display_message_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            PlaceHolderFragment fragment1 = new PlaceHolderFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PlaceHolderFragment.PLACEHOLDERFRAGMENT_EXTRA_MSG, getIntent().getStringExtra(MainActivity.MAINACTIVITY_EXTRA_MESSAGE));
            fragment1.setArguments(bundle);
            getFragmentManager().beginTransaction().add(R.id.display_message_container, fragment1).commit();
        }

        if (findViewById(R.id.display_message_container2) != null) {
            if (savedInstanceState != null) {
                return;
            }
            PlaceHolderFragment2 fragment2 = new PlaceHolderFragment2();
            Bundle bundle = new Bundle();
            bundle.putString(PlaceHolderFragment2.PLACEHOLDERFRAGMENT2_EXTRA_MSG, getIntent().getStringExtra(MainActivity.MAINACTIVITY_EXTRA_MESSAGE));
            fragment2.setArguments(bundle);
            getFragmentManager().beginTransaction().add(R.id.display_message_container2, fragment2).commit();
        }

        /*Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MAINACTIVITY_EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        setContentView(textView);*/
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
