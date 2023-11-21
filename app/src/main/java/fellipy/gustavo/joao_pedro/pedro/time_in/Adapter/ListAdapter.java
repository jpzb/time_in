package fellipy.gustavo.joao_pedro.pedro.time_in.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import fellipy.gustavo.joao_pedro.pedro.time_in.Evento;
import fellipy.gustavo.joao_pedro.pedro.time_in.ImageCache;
import fellipy.gustavo.joao_pedro.pedro.time_in.Model.HomeViewModel;
import fellipy.gustavo.joao_pedro.pedro.time_in.MyViewHolder;
import fellipy.gustavo.joao_pedro.pedro.time_in.R;
import androidx.paging.PagingDataAdapter;

import androidx.recyclerview.widget.DiffUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ListAdapter extends PagingDataAdapter<Evento, MyViewHolder>{
    private Handler handler = new Handler();

    public ListAdapter(@NonNull DiffUtil.ItemCallback<Evento> diffCallback){
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycleview_eventos, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Evento evento = getItem(position);

        // Titulo do Evento
        TextView tvTituloItemEvento = holder.itemView.findViewById(R.id.tvTituloItemEvento);
        tvTituloItemEvento.setText(evento.nome);

        // Data do Evento
        TextView tvDataItemEvento = holder.itemView.findViewById(R.id.tvDataItemEvento);
        tvDataItemEvento.setText(new SimpleDateFormat("dd/MM/yyyy").format(evento.data));

        // Horario do Evento
        TextView tvHorarioItemEvento = holder.itemView.findViewById(R.id.tvHorarioItemEvento);
        tvHorarioItemEvento.setText(evento.horario_inicio + " - " + evento.horario_fim);

        // Preco Evento
        TextView tvPrecoItemEvento = holder.itemView.findViewById(R.id.tvPrecoItemEvento);
        tvPrecoItemEvento.setText(evento.preco);

        ImageView imgImagemEvento = holder.itemView.findViewById(R.id.imgImagemEvento);
        ImageCache.loadImageUrlToImageView(holder.itemView.getContext(), evento.imagem, imgImagemEvento, 100, 100);
    }
}
