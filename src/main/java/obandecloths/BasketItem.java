package obandecloths;

import java.util.Objects;

public class BasketItem {

    private Integer clothId;
    private String clothName;
    private String clothPictureIdLink;
    private Integer clothPrice;
    private Integer quantity;

    public BasketItem() {}
    public BasketItem(Integer clothId, String clothName, String clothPictureIdLink, Integer clothPrice, Integer quantity) {
        this.clothId = clothId;
        this.clothName = clothName;
        this.clothPictureIdLink = clothPictureIdLink;
        this.clothPrice = clothPrice;
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketItem that = (BasketItem) o;
        return Objects.equals(clothId, that.clothId) && Objects.equals(clothName, that.clothName) && Objects.equals(clothPictureIdLink, that.clothPictureIdLink) && Objects.equals(clothPrice, that.clothPrice) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clothId, clothName, clothPictureIdLink, clothPrice, quantity);
    }
}
