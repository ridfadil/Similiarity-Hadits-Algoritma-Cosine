package padilah.farid.hadits.similiarityhaditsfarid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.activeandroid.query.Select;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.hadits.similiarityhaditsfarid.R;
import padilah.farid.hadits.similiarityhaditsfarid.model.Hadits;

public class UpdateHaditsActivity extends AppCompatActivity {

    @BindView(R.id.et_jenis_hadits)
    EditText etJenisHadits;
    @BindView(R.id.et_hadits_satu)
    EditText etHaditsSatu;
    @BindView(R.id.et_hadits_dua)
    EditText etHaditsDua;
    @BindView(R.id.update)
    Button update;
    String deskripsi = "", haditsSatu = "", haditsDua = "";
    Long id;
    Hadits hadits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hadits);
        ButterKnife.bind(this);
        initToolbar();
        id = getIntent().getLongExtra("id", 0);
        deskripsi = getIntent().getStringExtra("deskripsi");
        haditsSatu = getIntent().getStringExtra("hadits_satu");
        haditsDua = getIntent().getStringExtra("hadits_dua");

        etJenisHadits.setText(deskripsi);
        etHaditsSatu.setText(haditsSatu);
        etHaditsDua.setText(haditsDua);

        hadits = new Select().from(Hadits.class).where("id = ?", id).executeSingle();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etJenisHadits.getText().toString().equals("")
                        && !etHaditsSatu.getText().toString().equals("")
                        && !etHaditsDua.getText().toString().equals("")) {
                    hadits = new
                            Hadits(
                            etJenisHadits.getText().toString(),
                            etHaditsSatu.getText().toString(),
                            etHaditsDua.getText().toString()
                    );
                    hadits.save();
                    Toast.makeText(UpdateHaditsActivity.this, "Berhasil Update", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateHaditsActivity.this, LihatHaditsActivity.class));
                }
            }
        });

    }

    private void initToolbar() {
        getSupportActionBar().setTitle("Update Hadits");
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
