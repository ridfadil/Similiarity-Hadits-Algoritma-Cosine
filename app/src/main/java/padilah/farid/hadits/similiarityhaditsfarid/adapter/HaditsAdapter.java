package padilah.farid.hadits.similiarityhaditsfarid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.hadits.similiarityhaditsfarid.R;
import padilah.farid.hadits.similiarityhaditsfarid.activity.SimilarityHaditsActivity;
import padilah.farid.hadits.similiarityhaditsfarid.activity.UpdateHaditsActivity;
import padilah.farid.hadits.similiarityhaditsfarid.model.Hadits;

public class HaditsAdapter extends RecyclerView.Adapter<HaditsAdapter.ListMenuViewHolder> {

    private Context context;
    private final List<Hadits> listHadits;

    public HaditsAdapter(Context context, List<Hadits> listHadits) {
        this.context = context;
        this.listHadits = listHadits;
    }

    @Override
    public ListMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hadits, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListMenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ListMenuViewHolder holder, final int position) {
        final Hadits hadits = listHadits.get(position);
        final Hadits hadis = listHadits.get(position);
        final Hadits mCurrent = listHadits.get(position);
        final Long idCurrent = mCurrent.getId();

        Log.e("ID", "" + idCurrent);
        holder.txtDeskripsi.setText(hadits.jenis);
        holder.txtHaditsSatu.setText(String.valueOf(hadits.haditsSatu));
        holder.txtHaditsDua.setText(String.valueOf(hadits.haditsDua));
        holder.cekSimiliarity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SimilarityHaditsActivity.class);
                i.putExtra("deskripsi", hadis.jenis);
                i.putExtra("hadits_satu", hadis.haditsSatu);
                i.putExtra("hadits_dua", hadis.haditsDua);
                context.startActivity(i);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hadits.delete(Hadits.class, hadis.getId());

                listHadits.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, UpdateHaditsActivity.class);
                i.putExtra("deskripsi", hadis.jenis);
                i.putExtra("id", idCurrent);
                i.putExtra("hadits_satu", hadis.haditsSatu);
                i.putExtra("hadits_dua", hadis.haditsDua);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHadits.size();
    }

    public class ListMenuViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        @BindView(R.id.tv_jenis)
        TextView txtDeskripsi;
        @BindView(R.id.tv_hadits_satu)
        TextView txtHaditsSatu;
        @BindView(R.id.tv_hadits_dua)
        TextView txtHaditsDua;
        @BindView(R.id.cek_similiarity)
        TextView cekSimiliarity;
        @BindView(R.id.update)
        TextView update;
        @BindView(R.id.delete)
        TextView delete;

        final HaditsAdapter mAdapter;

        public ListMenuViewHolder(View itemView, HaditsAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mAdapter = adapter;
        }

    }
}
