package com.example.itc_databaseapiproject;

public class ListLiga {
    String namaLiga, abbr;
    String logoKlub;

    public ListLiga(String namaLiga, String abbr,String logoKlub) {
        this.namaLiga = namaLiga;
        this.abbr = abbr;
        this.logoKlub = logoKlub;
    }


    public String getNamaLiga() {
        return namaLiga;
    }

    public void setNamaLiga(String namaLiga) {
        this.namaLiga = namaLiga;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getLogoKlub() {
        return logoKlub;
    }

    public void setLogoKlub(String logoKlub) {
        this.logoKlub = logoKlub;
    }
}
