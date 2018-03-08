package mx.iteso.app.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable {
    private String title;
    private String store;
    private String phone;
    private String location;
    private int image;
    private Integer code;

    public ItemProduct(String title, String store, String phone, String location, int image, int code) {
        this.title = title;
        this.store = store;
        this.phone = phone;
        this.location = location;
        this.image = image;
        this.code = code;
    }
    public ItemProduct(Parcel in){
        title = in.readString();
        store = in.readString();
        phone = in.readString();
        location = in.readString();
        image = in.readInt();
        code = in.readInt();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(store);
        parcel.writeString(phone);
        parcel.writeString(location);
        parcel.writeInt(image);
        parcel.writeInt(code);


    }

    public static final Parcelable.Creator<ItemProduct> CREATOR = new Parcelable.Creator<ItemProduct>(){
        @Override
        public ItemProduct createFromParcel(Parcel parcel) {
            return new ItemProduct(parcel);
        }

        @Override
        public ItemProduct[] newArray(int i) {
            return new ItemProduct[0];
        }
    };
}
