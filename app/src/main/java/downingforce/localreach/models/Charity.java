package downingforce.localreach.models;

import org.parceler.Parcel;

@Parcel
public class Charity {
    String mEin;
    String mName;
    String mMission;
    String mCity;
    String mState;
    String mZip;
    String mPublicReport;
    String mWebsite;
    String mLogo;
    String mNteecode;

    public Charity() {}

    public Charity(String mEin, String mName, String mMission, String mCity, String mState, String mZip, String mPublicReport, String mWebsite, String mLogo, String mNteecode) {
        this.mEin = mEin;
        this.mName = mName;
        this.mMission = mMission;
        this.mCity = mCity;
        this.mState = mState;
        this.mZip = mZip;
        this.mPublicReport = mPublicReport;
        this.mWebsite = mWebsite;
        this.mLogo = mLogo;
        this.mNteecode = mNteecode;
    }

    public String getmEin() {
        return mEin;
    }

    public void setmEin(String mEin) {
        this.mEin = mEin;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmMission() {
        return mMission;
    }

    public void setmMission(String mMission) {
        this.mMission = mMission;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getmZip() {
        return mZip;
    }

    public void setmZip(String mZip) {
        this.mZip = mZip;
    }

    public String getmPublicReport() {
        return mPublicReport;
    }

    public void setmPublicReport(String mPublicReport) {
        this.mPublicReport = mPublicReport;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public void setmWebsite(String mWebsite) {
        this.mWebsite = mWebsite;
    }

    public String getmLogo() {
        return mLogo;
    }

    public void setmLogo(String mLogo) {
        this.mLogo = mLogo;
    }

    public String getmNteecode() {
        return mNteecode;
    }

    public void setmNteecode(String mNteecode) {
        this.mNteecode = mNteecode;
    }
}
