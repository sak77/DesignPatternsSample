package com.saket.designpatternssample.Builder;

/**
 * Created by sshriwas on 2020-02-08
 */
public class VisaApplication {

    private int visa_app_no;
    private String country_of_origin;
    private String destination_country;
    private String purpose_of_travel;
    private int no_of_travellers;
    private String date_of_travel;

    private VisaApplication(VisaApplicationBuilder builder) {
        this.visa_app_no = builder.visa_app_no;
        this.country_of_origin = builder.country_of_origin;
        this.destination_country = builder.destination_country;
        this.purpose_of_travel = builder.purpose_of_travel;
        this.no_of_travellers = builder.no_of_travellers;
        this.date_of_travel = builder.date_of_travel;
    }

    //Inner builder class
    public static class VisaApplicationBuilder {
        //One of the drawbacks of builder pattern is that
        //all fields from out class need to be duplicated in the builder class as well
        private int visa_app_no;
        private String country_of_origin;
        private String destination_country;
        private String purpose_of_travel;
        private int no_of_travellers;
        private String date_of_travel;

        //Mandatory fields should be included in builder constructor
        public VisaApplicationBuilder(int visa_app_no) {
            this.visa_app_no = visa_app_no;
        }

        //Each setter should return type of Builder
        public VisaApplicationBuilder setCountry_of_origin(String country_of_origin) {
            this.country_of_origin = country_of_origin;
            return this;
        }

        public VisaApplicationBuilder setDestination_country(String destination_country) {
            this.destination_country = destination_country;
            return this;
        }

        public VisaApplicationBuilder setPurpose_of_travel(String purpose_of_travel) {
            this.purpose_of_travel = purpose_of_travel;
            return this;
        }

        public VisaApplicationBuilder setNo_of_travellers(int no_of_travellers) {
            this.no_of_travellers = no_of_travellers;
            return this;
        }

        public VisaApplicationBuilder setDate_of_travel(String date_of_travel) {
            this.date_of_travel = date_of_travel;
            return this;
        }

        public VisaApplication Build () {
            return new VisaApplication(this);
        }
    }
}
