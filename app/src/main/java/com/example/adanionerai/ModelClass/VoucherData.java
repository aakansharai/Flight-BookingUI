package com.example.adanionerai.ModelClass;

public class VoucherData {
    int image;
    String rewards;

    public VoucherData(int image, String rewards) {
        this.image = image;
        this.rewards = rewards;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }
}
