package com.telusko.ecom_proj.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatic generation of Id VALUES UNQIUE id
    @JsonFormat
    private int id;
    @JsonFormat
    private String name;
    @JsonFormat
    private String description;
    @JsonFormat
    private String brand;
    @JsonFormat
    private BigDecimal price;
    @JsonFormat
    private String category;
    //@Column(name = "releaseDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy" )
    private Date releaseDate;
    @JsonFormat
    private boolean available;
    @JsonFormat
    private int stock_quantity;

    @JsonFormat
    private String imageName;

    private String imageType;

    @Lob
    private byte[] imageData;

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }


}
