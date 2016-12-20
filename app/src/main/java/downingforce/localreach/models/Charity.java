package downingforce.localreach.models;

import org.parceler.Parcel;

@Parcel
public class Charity {
    String Ein;
    String Name;
    String Mission;
    String City;
    String State;
    String Zip;
    String PublicReport;
    String Website;
    String Logo;
    String Nteecode;

    public Charity() {}

    public Charity(String Ein, String Name, String Mission, String City, String State, String Zip, String PublicReport, String Website, String Logo, String Nteecode) {
        this.Ein = Ein;
        this.Name = Name;
        this.Mission = Mission;
        this.City = City;
        this.State = State;
        this.Zip = Zip;
        this.PublicReport = PublicReport;
        this.Website = Website;
        this.Logo = Logo;
        this.Nteecode = Nteecode;
    }

    public String getmEin() {
        return Ein;
    }

    public void setmEin(String Ein) {
        this.Ein = Ein;
    }

    public String getmName() {
        return Name;
    }

    public void setmName(String Name) {
        this.Name = Name;
    }

    public String getmMission() {
        return Mission;
    }

    public void setmMission(String Mission) {
        this.Mission = Mission;
    }

    public String getmCity() {
        return City;
    }

    public void setmCity(String City) {
        this.City = City;
    }

    public String getmState() {
        return State;
    }

    public void setmState(String State) {
        this.State = State;
    }

    public String getmZip() {
        return Zip;
    }

    public void setmZip(String Zip) {
        this.Zip = Zip;
    }

    public String getmPublicReport() {
        return PublicReport;
    }

    public void setmPublicReport(String PublicReport) {
        this.PublicReport = PublicReport;
    }

    public String getmWebsite() {
        return Website;
    }

    public void setmWebsite(String Website) {
        this.Website = Website;
    }

    public String getmLogo() {
        return Logo;
    }

    public void setmLogo(String Logo) {
        this.Logo = Logo;
    }

    public String getmNteecode() {
        return Nteecode;
    }

    public void setmNteecode(String Nteecode) {
        this.Nteecode = Nteecode;
    }
}
