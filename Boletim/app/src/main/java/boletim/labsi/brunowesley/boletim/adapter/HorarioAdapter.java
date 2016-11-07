package boletim.labsi.brunowesley.boletim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import boletim.labsi.brunowesley.boletim.Model.Disciplina;
import boletim.labsi.brunowesley.boletim.R;

/**
 * Created by wesle on 07/11/2016.
 */

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder> {
    protected static final String TAG = "disciplina";
    private final List<Disciplina> disciplinas;
    private final Context context;
    private HorarioOnClickListener horarioOnClickListener;

    public HorarioAdapter(List<Disciplina> disciplina, Context context, HorarioOnClickListener horarioOnClickListener) {
        this.disciplinas = disciplina;
        this.context = context;
        this.horarioOnClickListener = horarioOnClickListener;
    }


    @Override
    public HorarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_disciplinas, parent, false);
        HorarioViewHolder holder = new HorarioViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return this.disciplinas != null ? this.disciplinas.size() : 0;
    }

    public interface HorarioOnClickListener {
        public void onClickDisciplina(View view, int idx);
    }

    @Override
    public void onBindViewHolder(final HorarioViewHolder holder, final int position) {
        Disciplina c = disciplinas.get(position);
        holder.nome.setText(c.getNome());
        holder.dia.setText(c.getDia());
        holder.carga.setText(c.getCargaHoraria());
        holder.hora.setText(c.getHoraInicial());
        if (horarioOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // A variável position é final
                    horarioOnClickListener.onClickDisciplina(holder.itemView, position);
                }
            });
        }
    }




    public static class HorarioViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        TextView dia;
        TextView carga;
        TextView hora;

        public HorarioViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.txt_nome_disciplina);
            dia = (TextView) itemView.findViewById(R.id.txt_dia);
            carga = (TextView) itemView.findViewById(R.id.txt_carga);
            hora = (TextView) itemView.findViewById(R.id.txt_horario);
        }
    }


}



