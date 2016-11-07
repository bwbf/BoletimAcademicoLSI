package boletim.labsi.brunowesley.boletim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import boletim.labsi.brunowesley.boletim.Model.Notas;
import boletim.labsi.brunowesley.boletim.R;

/**
 * Created by wesle on 07/11/2016.
 */

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.NotasViewHolder> {
    protected static final String TAG = "notasadapter";
    private final List<Notas> notas;
    private final Context context;
    private NotasOnClickListner notasOnClickListner;

    public NotasAdapter(Context context, List<Notas> notas, NotasOnClickListner notasOnClickListner) {
        this.notas = notas;
        this.context = context;
        this.notasOnClickListner = notasOnClickListner;
    }


    @Override
    public NotasAdapter.NotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_notas, parent, false);
        NotasViewHolder holder = new NotasViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final NotasAdapter.NotasViewHolder holder,final int position) {
        Notas n =notas.get(position);
        holder.p1.setText(n.getNota_um());
        holder.sub1.setText( n.getSub_um());
        holder.p2.setText(n.getNota_dois());
        holder.sub2.setText( n.getSub_dois());
        holder.prova_final.setText(n.getNota_final());
        holder.disciplina.setText(n.getDisciplina().getNome());
        if (notasOnClickListner != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // A variável position é final
                    notasOnClickListner.onClicNotas(holder.itemView, position);
                }
            });
        }

    }

    public interface NotasOnClickListner {
        public void onClicNotas(View view, int idx);
    }

    @Override
    public int getItemCount() {
        return this.notas != null ? this.notas.size() : 0;
    }

    public static class NotasViewHolder extends RecyclerView.ViewHolder {
        TextView p1;
        TextView sub1;
        TextView p2;
        TextView sub2;
        TextView prova_final;
        TextView disciplina;

        public NotasViewHolder(View itemView) {
            super(itemView);
            p1 = (TextView) itemView.findViewById(R.id.p1);
            sub1 = (TextView) itemView.findViewById(R.id.sub1);
            p2 = (TextView) itemView.findViewById(R.id.p2);
            sub2 = (TextView) itemView.findViewById(R.id.sub2);
            prova_final = (TextView) itemView.findViewById(R.id.prova_final);
            disciplina = (TextView) itemView.findViewById(R.id.displina);
        }
    }
}
