package com.example.beachtriplist;

import android.content.Context;

import com.example.beachtriplist.Model.Klu;
import com.example.beachtriplist.Model.Loteng;
import com.example.beachtriplist.Model.Lotim;
import com.example.beachtriplist.Model.Pantai;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Pantai> pantais = new ArrayList<>();

    private static List<Lotim> initDataLotim(Context ctx) {
        List<Lotim> lotims = new ArrayList<>();
        lotims.add(new Lotim(ctx.getString(R.string.kura_kura), ctx.getString(R.string.asal_kura),
                ctx.getString(R.string.desc_kura), R.drawable.pantai_kura_kura));
        lotims.add(new Lotim(ctx.getString(R.string.syurga), ctx.getString(R.string.syurga_asal),
                ctx.getString(R.string.desc_syurga), R.drawable.pantai_surga));
        lotims.add(new Lotim(ctx.getString(R.string.pink), ctx.getString(R.string.asal_pink),
                ctx.getString(R.string.desc_pink), R.drawable.pantai_pink));

        return lotims;
    }

    private static List<Loteng> initDataLoteng(Context ctx) {
        List<Loteng> lotengs = new ArrayList<>();
        lotengs.add(new Loteng(ctx.getString(R.string.belanak), ctx.getString(R.string.asal_belanak),
                ctx.getString(R.string.desc_belanak), R.drawable.pantai_selong_belanak));
        lotengs.add(new Loteng(ctx.getString(R.string.semeti), ctx.getString(R.string.asal_semeti),
                ctx.getString(R.string.desc_semeti), R.drawable.pantai_semeti));
        lotengs.add(new Loteng(ctx.getString(R.string.aan), ctx.getString(R.string.asal_aan),
                ctx.getString(R.string.desc_aan), R.drawable.pantai_tanjung_aan));
        return lotengs;
    }

    private static List<Klu> initDataKlu(Context ctx) {
        List<Klu> klus = new ArrayList<>();
        klus.add(new Klu(ctx.getString(R.string.terawangan), ctx.getString(R.string.asal_terawangan),
                ctx.getString(R.string.desc_terawangan), R.drawable.pantai_gili_trawangan));
        klus.add(new Klu(ctx.getString(R.string.kecinan), ctx.getString(R.string.asal_kecinan),
                ctx.getString(R.string.desc_kecinan), R.drawable.pantai_kecinan));
        klus.add(new Klu(ctx.getString(R.string.sengigi), ctx.getString(R.string.asal_sengigi),
                ctx.getString(R.string.desc_sengigi), R.drawable.pantai_senggigi));
        return klus;
    }




    private static void initAllPantais(Context ctx) {
        pantais.addAll(initDataLotim(ctx));
        pantais.addAll(initDataLoteng(ctx));
        pantais.addAll(initDataKlu(ctx));
    }

    public static List<Pantai> getAllPantai(Context ctx) {
        if (pantais.size() == 0) {
            initAllPantais(ctx);
        }
        return  pantais;
    }

    public static List<Pantai> getPantaisByTipe(Context ctx, String jenis) {
        List<Pantai> pantaisByType = new ArrayList<>();
        if (pantais.size() == 0) {
            initAllPantais(ctx);
        }
        for (Pantai h : pantais) {
            if (h.getJenis().equals(jenis)) {
                pantaisByType.add(h);
            }
        }
        return pantaisByType;
    }

}