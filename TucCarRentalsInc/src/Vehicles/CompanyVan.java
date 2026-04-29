package Vehicles;

import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;
import utils.CompanyVanCategory;

//import java.time.*;
public class CompanyVan extends Vehicles {
    private CompanyVanCategory category;
    private String type = "CompanyVan";
    public CompanyVan(String licensePlate,String transmission,String make,String model,int  year,String type,CompanyVanCategory category) {
        super(licensePlate,transmission, make, model, category.name(),year);
        this.setType(this.getClass().getName());

    }




    public String marshal() {

        StringBuffer sb = new StringBuffer(super.marshal());

        sb.append("type:").append(this.type).append(",");

        return sb.toString();
    }

    public void unmarshal(String data) throws UnMarshalingException {
        super.unmarshal(data);

        if(data == null) {
            throw new UnMarshalingException("Empty Data");
            }


        String[] parts = data.split(",");
        for (String part : parts) {
            String[] keyValue = part.split(":");

            if (keyValue[0].trim().equals("type")) {
                this.type = keyValue[1];
            }

        }

        }



    public String getType() {
        return type;
    }



    public void setType(String type) {
        this.type = type;
    }



    //LocalDate rentDate;
    //int timeOfLease; ara ta amaxia kathe fora poy fairnoyme neo car den dinoume hmeeromhnia
    // edo na kano enum gia ton xrono kai na ton peraso mesa tis times ana mera 



    }




//LocalDate rentDate;
// int timeOfLease; ara ta amaxia kathe fora poy fairnoyme neo car den dinoume
// hmeeromhnia
// edo na kano enum gia ton xrono kai na ton peraso mesa tis times ana mera