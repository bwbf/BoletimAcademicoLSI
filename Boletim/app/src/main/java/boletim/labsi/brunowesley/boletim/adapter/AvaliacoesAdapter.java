package boletim.labsi.brunowesley.boletim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import boletim.labsi.brunowesley.boletim.Model.Anotacoes;
import boletim.labsi.brunowesley.boletim.Model.DataProvas;
import boletim.labsi.brunowesley.boletim.R;

/**
 * Created by wesle on 07/11/2016.
 */

public class AvaliacoesAdapter extends RecyclerView.Adapter<AvaliacoesAdapter.AvalicaoViewHolder> {
    protected static final String TAG = "avaliacoesadapter";
    private final Context context;
    private final List<DataProvas> avaliacoes;
    private AvaliacoesClickListner avaliacoesClickListner;

    public AvaliacoesAdapter(Context context, List<DataProvas> anotacoes, AvaliacoesClickListner avaliacoesClickListner) {
        this.context = context;
        this.avaliacoes = anotacoes;
        this.avaliacoesClickListner = avaliacoesClickListner;
    }


    @Override
    public AvaliacoesAdapter.AvalicaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_avaliacoes, parent, false);
        AvalicaoViewHolder holder = new AvalicaoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final AvaliacoesAdapter.AvalicaoViewHolder holder,final int position) {
        DataProvas prova = avaliacoes.get(position);
        holder.disciplinanome.setText(prova.getDisciplina().getNome());
        holder.data_prova.setText(prova.getData_prova());
        if (avaliacoesClickListner != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    avaliacoesClickListner.onClicAvaliacao(holder.itemView, position);
                }
            });
        }
    }

    public interface AvaliacoesClickListner {
        public void onClicAvaliacao(View view, int idx);
    }

    @Override
    public int getItemCount() {
        return this.avaliacoes != null ? this.avaliacoes.size() : 0;
    }

    public static class AvalicaoViewHolder extends RecyclerView.ViewHolder {
        TextView disciplinanome;
        TextView data_prova;

        public AvalicaoViewHolder(View itemView) {
            super(itemView);
            disciplinanome = (TextView) itemView.findViewById(R.id.disciplina_data);
            data_prova = (TextView) itemView.findViewById(R.id.data_prova);
        }
    }


}
