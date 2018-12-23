package padilah.farid.hadits.similiarityhaditsfarid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.hadits.similiarityhaditsfarid.R;
import padilah.farid.hadits.similiarityhaditsfarid.algoritma.Cosine;

public class SimilarityHaditsActivity extends AppCompatActivity {

    @BindView(R.id.tv_jenis)
    TextView tvJenis;
    @BindView(R.id.tv_hadits_satu)
    TextView tvHaditsSatu;
    @BindView(R.id.tv_hadits_dua)
    TextView tvHaditsDua;
    @BindView(R.id.tv_similiarity)
    TextView tvSimiliarity;
    @BindView(R.id.cv_hadits)
    CardView cvHadits;

    String hadisSatu, hadisDua,deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similarity_hadits);
        ButterKnife.bind(this);

        initToolbar();
        initIntentData();
        initUI();
    }

    private void initUI() {
        tvHaditsSatu.setText(hadisSatu);
        tvHaditsDua.setText(hadisDua);
        tvJenis.setText(deskripsi);

        Cosine cos = new Cosine(2);
        double dSimilarity = Math.round(cos.similarity(hadisSatu, hadisDua) * 100.0);
        tvSimiliarity.setText(String.valueOf(dSimilarity + "%"));
    }

    private void initIntentData() {
        hadisSatu = getIntent().getStringExtra("hadits_satu");
        hadisDua = getIntent().getStringExtra("hadits_dua");
        deskripsi = getIntent().getStringExtra("deskripsi");
    }

    private void initToolbar() {
        getSupportActionBar().setTitle("Similarity Hadits");
        getSupportActionBar().setSubtitle(getIntent().getStringExtra("deskripsi"));
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
