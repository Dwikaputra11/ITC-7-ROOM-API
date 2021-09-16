package com.example.itc_databaseapiproject.database;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "football")
public class Entity {

    public static final String TABLE_NAME = "Football";
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "leagueName" )
    private String leagueName;
    @ColumnInfo(name = "leagueAbbr")
    private String leagueAbbr;

    public Entity(int id, String leagueName, String leagueAbbr) {
        this.id = id;
        this.leagueName = leagueName;
        this.leagueAbbr = leagueAbbr;
    }

    public int getId() {
        return id;
    }


    public String getLeagueName() {
        return leagueName;
    }


    public String getLeagueAbbr() {
        return leagueAbbr;
    }

    @Ignore

    public Entity(String leagueName, String leagueAbbr) {
        this.leagueName = leagueName;
        this.leagueAbbr = leagueAbbr;
    }
}
