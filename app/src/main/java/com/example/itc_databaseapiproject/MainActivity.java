package com.example.itc_databaseapiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.itc_databaseapiproject.database.Dao;
import com.example.itc_databaseapiproject.database.Database;
import com.example.itc_databaseapiproject.database.Entity;
import com.example.itc_databaseapiproject.model.DataItem;
import com.example.itc_databaseapiproject.service.FootballListener;
import com.example.itc_databaseapiproject.service.FootballService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LigaAdapter.ItemClickListener {

    private ArrayList<ListLiga> listLiga ;
    private LigaAdapter ligaAdapter;
//    private List<DataItem> dataItems;
    private List<Entity> dataAll;
    private Entity entity;
    private ArrayList<DetailLiga> listDetailLiga;
    private ArrayList<String> juara;
    private int activeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLiga = new ArrayList<>();
        new FootballService().getLeague(FootballListener);

    }

    private ArrayList<String> buildDataList(){

        String[] listJuara = {
                "Boca Junior",
                "Melbourne City",
                "Flamengo",
                "Jiangsu Footbal Club",
                "AFC Ajax",
                "Manchester City",
                "Lille",
                "Bayern Munchen",
                "Bali United",
                "Inter Milan",
                "Kawasaki Frontale",
                "JDT",
                "Cruz Azul",
                "Sporting CP",
                "FC Zenit",
                "none",
                "Atletico Madrid",
                "Panthum United",
                "Besikthas",
                "Express"
        };
        ArrayList<String> arrayListJuara = new ArrayList<>();
        for(int i = 0 ; i < listJuara.length; i++){
            arrayListJuara.add(listJuara[i]);
        }

        for(int i = 0 ; i < arrayListJuara.size();i++){
            Log.d("LIST JUARA -> ", arrayListJuara.get(i));
        }
        return arrayListJuara;
    }

    FootballListener<List<DataItem>> FootballListener = new FootballListener<List<DataItem>>() {
        @Override
        public void onSuccess(List<DataItem> items) {
            ArrayList<String> dataDetails = new ArrayList<>();
            listDetailLiga = new ArrayList<>();
            Database database = Database.getInstance(MainActivity.this);
            Dao dao = database.dao();
            boolean check = false;
            if(dao.getAllData().isEmpty()) check = true;
            else check = false;
            for(int i = 0; i < items.size(); i++){
                Log.d("Hasil : NAMA LIGA -> ",items.get(i).getName());
                Log.d("Hasil : ABBR -> ",items.get(i).getAbbr());
                if(check){
                    dao.insertData(new Entity(items.get(i).getName(),items.get(i).getAbbr()));
                }else{
                    dao.updateData(new Entity(items.get(i).getName(),items.get(i).getAbbr()));
                }
                listLiga.add(new ListLiga(items.get(i).getName(),items.get(i).getAbbr(),String.valueOf(items.get(i).getLogos().getLight())));
            }
            dataAll = dao.getAllData();
            for (int i = 0; i < items.size();i++){
                dataDetails.add(dataAll.get(i).getLeagueName());
                dataDetails.add(dataAll.get(i).getLeagueAbbr());
            }

            for (int i = 0; i < items.size();i++){
                Log.d("DATABASE: NAMA LIGA -> ",items.get(i).getName());
                Log.d("DATABASE: ABBR -> ",String.valueOf(items.get(i).getAbbr()));
            }

            juara = buildDataList();
            Log.d("PANJANG LIST JUARA -> ", String.valueOf(juara.size()));
            for (int i = 0; i < juara.size(); i++) {
//                Log.d("TAMPIL JUARA -> ", juara.get(i));
                listDetailLiga.add(new DetailLiga(juara.get(i)));
            }
            for (int i = 0; i < juara.size(); i++) {
                Log.d("TAMPIL JUARA LIST-> ", listDetailLiga.get(i).getJuaraLiga());
            }
            ligaAdapter =new LigaAdapter(listLiga,listDetailLiga,MainActivity.this,MainActivity.this);
            RecyclerView recyclerView = findViewById(R.id.rv_main);
            recyclerView.setAdapter(ligaAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setHasFixedSize(true);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR -> ", msg);
        }
    };

    @Override
    public void onItemClick(DetailLiga detailLiga) {
        FragmentManager fragmentManager = getSupportFragmentManager();
//        DetailActivity detailActivity = new DetailActivity();
        DetailActivity fragment = DetailActivity.newInstance(detailLiga.getJuaraLiga());
        Fragment detailFragment = fragmentManager.findFragmentByTag(DetailActivity.class.getSimpleName());


        if(!(detailFragment instanceof DetailActivity)){
            fragmentManager.beginTransaction()
                    .add(R.id.fl_mainFrame,fragment,DetailActivity.class.getSimpleName())
                    .commit();
            activeFragment = 1;
        }

        if(activeFragment == 1){
            fragmentManager.beginTransaction()
                    .replace(R.id.fl_mainFrame,fragment,DetailActivity.class.getSimpleName())
                    .commit();
            activeFragment = 1;
        }

//        FragmentTransaction transaction = MainActivity.this.getSupportFragmentManager().beginTransaction();
////        transaction.replace(R.id.mainFrame,fragment,"detail_fragment");
//        transaction.add(R.id.mainFrame,fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

}