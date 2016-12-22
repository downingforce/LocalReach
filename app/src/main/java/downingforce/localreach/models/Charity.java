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
    private String pushId;

    public Charity() {}

    public Charity(String Ein, String Name, String Mission, String City, String State, String Zip, String PublicReport, String Website, String Logo, String Nteecode) {
        this.mEin = Ein;
        this.mName = Name;
        this.mMission = Mission;
        this.mCity = City;
        this.mState = State;
        this.mZip = Zip;
        this.mPublicReport = PublicReport;
        this.mWebsite = Website;
        this.mLogo = Logo;
        this.mNteecode = Nteecode;
    }

    public String getmEin() {
        return mEin;
    }

    public void setmEin(String Ein) {
        this.mEin = Ein;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String Name) {
        this.mName = Name;
    }

    public String getmMission() {
        return mMission;
    }

    public void setmMission(String Mission) {
        this.mMission = Mission;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String City) {
        this.mCity = City;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String State) {
        this.mState = State;
    }

    public String getmZip() {
        return mZip;
    }

    public void setmZip(String Zip) {
        this.mZip = Zip;
    }

    public String getmPublicReport() {
        return mPublicReport;
    }

    public void setmPublicReport(String PublicReport) {
        this.mPublicReport = PublicReport;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public void setmWebsite(String Website) {
        this.mWebsite = Website;
    }

    public String getmLogo() {
        return mLogo;
    }

    public void setmLogo(String Logo) {
        this.mLogo = Logo;
    }

    public String getmNteecode() {
        return mNteecode;
    }

    public void setmNteecode(String Nteecode) {
        this.mNteecode = Nteecode;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
