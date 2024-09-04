package obandecloths;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Basket {
    @Id
    @SequenceGenerator(
            name = "",
            sequenceName = "Basket_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Basket_id_sequence"
    )
    private UUID Id;
    private List<BasketItem> basketItems;

    public Basket() {}

    public Basket(UUID id, List<BasketItem> basketItems) {
        Id = id;
        this.basketItems = basketItems;
    }


    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

//    public void addItemToBasket(Clothings clothings) {
//        this.basketItems.add(clothings);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(Id, basket.Id) && Objects.equals(basketItems, basket.basketItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, basketItems);
    }
}
