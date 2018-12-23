package padilah.farid.hadits.similiarityhaditsfarid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.hadits.similiarityhaditsfarid.DashboardActivity;
import padilah.farid.hadits.similiarityhaditsfarid.R;
import padilah.farid.hadits.similiarityhaditsfarid.model.Hadits;

public class TambahHadirsActivity extends AppCompatActivity {

    @BindView(R.id.et_jenis_hadits)
    EditText etJenisHadits;
    @BindView(R.id.et_hadits_satu)
    EditText etHaditsSatu;
    @BindView(R.id.et_hadits_dua)
    EditText etHaditsDua;
    @BindView(R.id.add)
    Button add;
    List<Hadits> listHadits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_hadirs);
        ButterKnife.bind(this);
        ActiveAndroid.initialize(this);
        initToolbar();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etJenisHadits.getText().toString().equals("")
                        && !etHaditsSatu.getText().toString().equals("")
                        && !etHaditsDua.getText().toString().equals("")) {

                    Hadits hadits = new
                            Hadits(
                            etJenisHadits.getText().toString(),
                            etHaditsSatu.getText().toString(),
                            etHaditsDua.getText().toString()
                    );

                    hadits.save();
                    recreate();
                    listHadits.add(hadits);
                    Toast.makeText(TambahHadirsActivity.this, "Berhasil menambahkan hadits", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(TambahHadirsActivity.this, DashboardActivity.class));
                } else {
                    Toast.makeText(TambahHadirsActivity.this, "Harap Isi Semua Form", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initToolbar() {
        getSupportActionBar().setTitle("Tambah Hadits");
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
