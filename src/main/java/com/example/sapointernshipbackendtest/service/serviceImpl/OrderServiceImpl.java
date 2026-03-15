package com.example.sapointernshipbackendtest.service.serviceImpl;

import com.example.sapointernshipbackendtest.model.Order;
import com.example.sapointernshipbackendtest.model.OrderItem;
import com.example.sapointernshipbackendtest.model.Product;
import com.example.sapointernshipbackendtest.repository.OrderItemRepository;
import com.example.sapointernshipbackendtest.repository.OrderRepository;
import com.example.sapointernshipbackendtest.repository.ProductRepository;
import com.example.sapointernshipbackendtest.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Order processFlashSaleOrder(String userId, Long productId, int quantity) {
        Integer userPurchasedCount = orderRepository.countTotalQuantityByUserIdAndProductId(userId, productId);
        if (userPurchasedCount + quantity > 2) {
            throw new RuntimeException("Bạn chỉ được mua tối đa 2 sản phẩm Flash Sale!");
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));

        // 3. Kiểm tra tồn kho
        if (product.getStock() < quantity) {
            throw new RuntimeException("Sản phẩm đã hết hàng!");
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        double salePrice = product.getPrice()*0.5; // Giả sử giá gốc 200, sale 50%

        Order order = Order.builder()
                .userId(userId)
                .totalPrice(salePrice * quantity)
                .build();
        Order savedOrder = orderRepository.save(order);

        OrderItem orderItem = OrderItem.builder()
                .order(savedOrder)
                .product(product)
                .quantity(quantity)
                .price(salePrice)
                .build();
        orderItemRepository.save(orderItem);

        return savedOrder;
    }
}
