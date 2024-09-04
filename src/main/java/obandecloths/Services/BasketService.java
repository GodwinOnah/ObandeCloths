//package obandecloths.Services;
//
//import obandecloths.Basket;
//import obandecloths.BasketItem;
//import obandecloths.Clothings;
//import obandecloths.Repositories.BasketRepo;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class BasketService {
//    private final BasketRepo basketRepo;
//
//    public BasketService(BasketRepo basketRepo) {
//        this.basketRepo = basketRepo;
//    }
//
//    public void addItemToBasket(Basket basket) throws URISyntaxException{
//        basketRepo.save(basket);
//
//    }
//
//    public Basket createNewBasket(){
//        return new Basket();
//    }
//
////    public Optional<Basket> getByIdCBasket(Integer id) {
////
////        return Optional.ofNullable(basketRepo.findById(id).orElseThrow(RuntimeException::new));
////    }
//
////    public List<BasketItem> addOrUpdateBasket(List<BasketItem> items, BasketItem itemToAdd, Integer quantity)
////            throws URISyntaxException {
////       for(BasketItem x : items){
////           if(x.getClothId().equals(itemToAdd.getClothId())) {
////               x.setQuantity(x.getQuantity()+1);
////           } else{
////               itemToAdd.setQuantity(quantity);
////           }
////           items.add(itemToAdd);
////
////       }
////        return items;
////    }
//}