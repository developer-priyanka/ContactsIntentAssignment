package my.assignment.firstintentassignment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends Activity {
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search=(SearchView)findViewById(R.id.searchView);
        search.setQueryHint("SearchView");


        //*** setOnQueryTextFocusChangeListener ***
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

               // Toast.makeText(getBaseContext(), String.valueOf(hasFocus),
                 //       Toast.LENGTH_SHORT).show();
            }
        });


        //*** setOnQueryTextListener ***
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                // TODO Auto-generated method stub

                Uri webpage = Uri.parse("http://google.com/#q="+query);
                Intent baseIntent = null;
                baseIntent=new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(baseIntent);

                Toast.makeText(getBaseContext(), query,
                        Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub

                //	Toast.makeText(getBaseContext(), newText,
                //Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
