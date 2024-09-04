//package obandecloths.Controllers;
//
//import obandecloths.BasketItem;
//import obandecloths.Clothings;
//import obandecloths.Services.BasketService;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URISyntaxException;
//import java.util.List;
//
//@RestController
//@RequestMapping("api/basket")
//@CrossOrigin("*")
//public class BasketController {
//
//    public final BasketService basketService;
//
//    public BasketController(BasketService basketService) {
//        this.basketService = basketService;
//    }
//
//    record NewRequest(
//           Integer clothId,
//           String clothName,
//           String clothPictureIdLink,
//           Integer clothPrice,
//           Integer quantity
//
//
//    ){
//    };
//
//    @GetMapping
//    public List<Clothings> getBasket(){
//        return basketService.getBasket();
//    }
//
//    @PutMapping
//    public void addToBasket(@RequestBody NewRequest newRequest)
//            throws URISyntaxException {
//        BasketItem basketItem = new BasketItem();
//        basketItem.setClothId(newRequest.clothId);
//        basketItem.setClothName(newRequest.clothName);
//        basketItem.setClothPrice(newRequest.clothPrice());
//        basketItem.setQuantity(newRequest.quantity);
//
//        basketService.addBasket(basketItem);
//    }
//
//}
