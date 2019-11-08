package com.epmresources.server.service.impl;

import com.epmresources.server.domain.*;
import com.epmresources.server.repository.*;
import com.epmresources.server.service.WishlistsExtendService;
import com.epmresources.server.service.dto.ProductsDTO;
import com.epmresources.server.service.mapper.ProductsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class WishlistsExtendServiceImpl implements WishlistsExtendService {

    private final Logger log = LoggerFactory.getLogger(WishlistsExtendServiceImpl.class);
    private final PeopleExtendRepository peopleExtendRepository;
    private final WishlistsRepository wishlistsRepository;
    private final WishlistProductsRepository wishlistProductsRepository;
    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;
    private final UserRepository userRepository;

    public WishlistsExtendServiceImpl(PeopleExtendRepository peopleExtendRepository, WishlistsRepository wishlistsRepository, WishlistProductsRepository wishlistProductsRepository, ProductsRepository productsRepository, ProductsMapper productsMapper, UserRepository userRepository) {
        this.peopleExtendRepository = peopleExtendRepository;
        this.wishlistsRepository = wishlistsRepository;
        this.wishlistProductsRepository = wishlistProductsRepository;
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Wishlists addToWishlist(Principal principal, Long id) {
        try {
            People people = getUserFromPrinciple(principal);

            Wishlists wishlists = people.getWishlist();

            if (wishlists == null) {
                wishlists = new Wishlists();
                wishlists.setWishlistUser(people);
                wishlistsRepository.save(wishlists);
            } else if (wishlists.getWishlistLists() != null || !wishlists.getWishlistLists().isEmpty()) {
                for (WishlistProducts i : wishlists.getWishlistLists()) {
                    if (i.getProduct().getId().equals(id)) {
                        return wishlists;
                    }
                }
            }

            Products product = productsRepository.getOne(id);
            WishlistProducts wishlistProducts = new WishlistProducts();
            wishlistProducts.setProduct(product);

            wishlistProducts.setWishlist(wishlists);
            wishlists.getWishlistLists().add(wishlistProducts);
            wishlistProductsRepository.save(wishlistProducts);

            return wishlists;
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public Boolean isInWishlist(Principal principal, Long productId) {
        People people = getUserFromPrinciple(principal);
        for (WishlistProducts wishlistProducts : people.getWishlist().getWishlistLists()) {
            if (wishlistProducts.getProduct().getId().equals(productId)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Wishlists fetchWishlist(Principal principal) {
        People people = getUserFromPrinciple(principal);
        return people.getWishlist();
    }

    @Override
    public List<ProductsDTO> fetchWishlistProducts(Principal principal) {
        try {
            People people = getUserFromPrinciple(principal);

            List<Products> productsList = new ArrayList<>();
            Set<WishlistProducts> wishlistProductsList;

            if (people.getWishlist() != null) {
                wishlistProductsList = people.getWishlist().getWishlistLists();
                for (WishlistProducts wishlistProducts : wishlistProductsList) {
                    productsList.add(wishlistProducts.getProduct());
                }
            }

            return productsList.stream()
                .map(productsMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public Wishlists removeFromWishlist(Principal principal, Long id) {
        People people = getUserFromPrinciple(principal);
        Wishlists wishlists = people.getWishlist();
        if (wishlists == null) {
            throw new IllegalArgumentException("Not found");
        }
        Set<WishlistProducts> wishlistProductsList = wishlists.getWishlistLists();
        WishlistProducts wishlistProductToDelete = null;
        for (WishlistProducts i : wishlistProductsList) {
            if (i.getProduct().getId().equals(id)) {
                wishlistProductToDelete = i;
                break;
            }
        }
        if (wishlistProductToDelete == null) {
            throw new IllegalArgumentException("Delete Item Not Found");
        }

        wishlistProductsList.remove(wishlistProductToDelete);

        if (wishlists.getWishlistLists() == null || wishlists.getWishlistLists().size() == 0) {
            people.setWishlist(null);
            peopleExtendRepository.save(people);
            return null;
        }

        wishlists.setWishlistLists(wishlistProductsList);
        wishlistProductsRepository.delete(wishlistProductToDelete);

        return wishlists;
    }

    @Override
    public void emptyWishlist(Principal principal) {
        People people = getUserFromPrinciple(principal);
        people.setWishlist(null);
        peopleExtendRepository.save(people);
    }

    private People getUserFromPrinciple(Principal principal) {
        if (principal == null || principal.getName() == null) {
            throw new IllegalArgumentException("Invalid access");
        }
        Optional<User> userOptional = userRepository.findOneByLogin(principal.getName());
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        Optional<People> people = peopleExtendRepository.findPeopleByEmailAddress(userOptional.get().getEmail());
        if (!people.isPresent()) {
            throw new IllegalArgumentException("People not found");
        }
        return people.get();
    }
}
