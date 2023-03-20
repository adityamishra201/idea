package com.example.newnirmaya;

public class ModelClass {
    private int logo_image_view;
    private String insurance_name_text_view;
    private String description_text_view;


    ModelClass(int logo_image_view,String insurance_name_text_view,String description_text_view){
        this.logo_image_view = logo_image_view;
        this.insurance_name_text_view=insurance_name_text_view;
        this.description_text_view=description_text_view;
    }

    public int getLogo_image_view() {
        return logo_image_view;
    }

    public String getInsurance_name_text_view() {
        return insurance_name_text_view;
    }

    public String getDescription_text_view() {
        return description_text_view;
    }
}
