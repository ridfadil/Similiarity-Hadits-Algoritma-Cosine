package padilah.farid.hadits.similiarityhaditsfarid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.hadits.similiarityhaditsfarid.R;
import padilah.farid.hadits.similiarityhaditsfarid.adapter.HaditsAdapter;
import padilah.farid.hadits.similiarityhaditsfarid.model.Hadits;

public class LihatHaditsActivity extends AppCompatActivity {

    @BindView(R.id.rv_list_hadits)
    RecyclerView rvListHadits;
    List<Hadits> listHadits = new ArrayList<>();
    HaditsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_hadits);
        ButterKnife.bind(this);
        initToolbar();
        listHadits = new Select().from(Hadits.class).orderBy("id ASC").execute();

        mAdapter = new HaditsAdapter(LihatHaditsActivity.this, listHadits);
        rvListHadits.setAdapter(mAdapter);
        rvListHadits.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initToolbar() {
        getSupportActionBar().setTitle("Lihat Hadits");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
