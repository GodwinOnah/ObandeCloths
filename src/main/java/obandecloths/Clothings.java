package obandecloths;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Clothings {
    @Id
    @SequenceGenerator(
            name = "",
            sequenceName = "Clothing_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Clothing_id_sequence"
    )
    private Integer clothId;
    private String clothName;
    private String clothPictureIdLink;
    private Integer clothPrice;


    public Clothings(Integer clothId, String clothName, String clothPictureIdLink, Integer clothPrice, String clothS3Link) {
        this.clothId = clothId;
        this.clothName = clothName;
        this.clothPictureIdLink = clothPictureIdLink;
        this.clothPrice = clothPrice;

    }

    public Clothings() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothings clothings = (Clothings) o;
        return Objects.equals(clothId, clothings.clothId) && Objects.equals(clothName, clothings.clothName) && Objects.equals(clothPictureIdLink, clothings.clothPictureIdLink) && Objects.equals(clothPrice, clothings.clothPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clothId, clothName, clothPictureIdLink, clothPrice);
    }

    public Integer getClothId() {
        return clothId;
    }

    public void setClothId(Integer clothId) {
        this.clothId = clothId;
    }

    public String getClothName() {
        return clothName;
    }

    public void setClothName(String clothName) {
        this.clothName = clothName;
    }

    public String getClothPictureIdLink() {
        return clothPictureIdLink;
    }

    public void setClothPictureIdLink(String clothPictureIdLink) {
        this.clothPictureIdLink = clothPictureIdLink;
    }

    public Integer getClothPrice() {
        return clothPrice;
    }

    public void setClothPrice(Integer clothPrice) {
        this.clothPrice = clothPrice;
    }
}