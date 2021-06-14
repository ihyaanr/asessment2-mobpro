package org.d3if2005.itemreminder;

public class MyReminder {

    String titlereminder;
    String locationreminder;
    String datereminder;

    public MyReminder() {
    }

    public MyReminder(String titlereminder, String locationreminder, String datereminder) {
        this.titlereminder = titlereminder;
        this.locationreminder = locationreminder;
        this.datereminder = datereminder;
    }

    public String getTitlereminder() {
        return titlereminder;
    }

    public void setTitlereminder(String titlereminder) {
        this.titlereminder = titlereminder;
    }

    public String getLocationreminder() {
        return locationreminder;
    }

    public void setLocationreminder(String locationreminder) {
        this.locationreminder = locationreminder;
    }

    public String getDatereminder() {
        return datereminder;
    }

    public void setDatereminder(String datereminder) {
        this.datereminder = datereminder;
    }
}
