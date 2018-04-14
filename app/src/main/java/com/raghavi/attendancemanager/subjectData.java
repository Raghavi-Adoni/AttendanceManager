package com.raghavi.attendancemanager;

/**
 * Created by Raghavi on 4/5/2018.
 */

public class subjectData {
    private String subName;
    private int totalLec;
    private int bunkedLec;
    private float minPercent;

    public subjectData(String subName,int totalLec,int bunkedLec,float minPercent) {
        this.subName = subName;
        this.totalLec = totalLec;
        this.bunkedLec=bunkedLec;
        this.minPercent=minPercent;
    }

public subjectData()
{
    subName = "";
    totalLec = 0;
    bunkedLec=0;
    minPercent=0;
}

    public String getSubName() {

        return subName;
    }

    public void setSubName(String subName) {

        this.subName = subName;
    }

    public int getTotalLec() {

        return totalLec;
    }

    public void setTotalLec(int totalLec) {
        this.totalLec = totalLec;
    }


    public int getBunkedLec() {

        return bunkedLec;
    }
    public void setBunkedLec(int bunkedLec) {
        this.bunkedLec = bunkedLec;
    }

    public float getMinPercent() {

        return minPercent;
    }
    public void setMinPercent(float minPercent) {
        this.minPercent = minPercent;
    }

}