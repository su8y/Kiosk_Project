package org.example.service;

import org.example.model.Cart;
import org.example.model.Product;
import org.example.repository.CartJdbcRepository;
import org.example.repository.CartRepository;

public class CartService {

    private CartRepository cartRepository;
    private static CartService instance = null;

    private CartService(CartRepository cartRepository) {
        this.cartRepository =  cartRepository;
    }

    public static CartService getInstance() {
        if(instance == null) instance = new CartService(new CartJdbcRepository());
        return instance;
    }

    public int modifyCartCount(Product product, String userId){
        Cart cart = cartRepository.existCart(product.getId(), userId);

        if(cart  == null){
            cartRepository.save(product,userId);
        }else{
            cartRepository.updateById(cart, cart.getAmount() + 1);
        }
        return 1;
    }
}
