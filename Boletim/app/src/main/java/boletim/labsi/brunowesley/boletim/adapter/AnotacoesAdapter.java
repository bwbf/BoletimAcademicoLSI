package boletim.labsi.brunowesley.boletim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import boletim.labsi.brunowesley.boletim.Model.Anotacoes;
import boletim.labsi.brunowesley.boletim.R;

/**
 * Created by wesle on 07/11/2016.
 */

public class AnotacoesAdapter extends RecyclerView.Adapter<AnotacoesAdapter.AnotacoesViewHolder> {
    protected static final String TAG = "anotacoesadapter";
    private final Context context;
    private final List<Anotacoes> anotacoes;
    private AnotacoesClickListner anotacoesClickListner;

    public AnotacoesAdapter(Context context, List<Anotacoes> anotacoes, AnotacoesClickListner anotacoesClickListner) {
        this.context = context;
        this.anotacoes = anotacoes;
        this.anotacoesClickListner = anotacoesClickListner;
    }


    @Override
    public AnotacoesAdapter.AnotacoesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_anotacoes, parent, false);
        AnotacoesViewHolder holder = new AnotacoesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final AnotacoesAdapter.AnotacoesViewHolder holder,final int position) {
        Anotacoes a = anotacoes.get(position);
        holder.titulo.setText(a.getTitulo());
        holder.descricao.setText(a.getDescricao());
        if (anotacoesClickListner != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // A variável position é final
                    anotacoesClickListner.onClicAnotacoes(holder.itemView, position);
                }
            });
        }

    }

    public interface AnotacoesClickListner {
        public void onClicAnotacoes(View view, int idx);
    }

    @Override
    public int getItemCount() {
        return this.anotacoes != null ? this.anotacoes.size() : 0;
    }


    public static class AnotacoesViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView descricao;

        public AnotacoesViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
            descricao = (TextView) itemView.findViewById(R.id.descricao);
        }

    }
}
